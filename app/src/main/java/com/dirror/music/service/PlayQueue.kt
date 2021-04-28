package com.dirror.music.service

import androidx.lifecycle.MutableLiveData
import com.dirror.music.MyApplication
import com.dirror.music.music.standard.data.StandardSongData
import com.dirror.music.room.PlayQueueData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList

/**
 * 播放队列
 * 保证 Service 对其的唯一引用
 * @author Moriafly
 * @since 2021年2月7日10:27:15
 */
object PlayQueue {

    /* 随机播放的队列 */
    var currentQueue = MutableLiveData<ArrayList<StandardSongData>>().also {
        it.value = ArrayList()
    }

    private var normalQueue = MutableLiveData<ArrayList<StandardSongData>>().also {
        it.value = ArrayList()
    }

    private var queue = ArrayList<StandardSongData>()

    fun setNormal(list: ArrayList<StandardSongData>) {
        queue = list
        normalQueue.value = list
        normal()
    }

    /**
     * 随机播放
     */
    fun random() {
        val shuffle = currentQueue.value
        shuffle?.shuffle()
        currentQueue.value = shuffle
        savePlayQueue()
    }

    fun normal() {
        currentQueue.value?.clear()
        currentQueue.value?.addAll(queue)
        savePlayQueue()
    }

    /**
     * 保存歌单到数据库
     */
    private fun savePlayQueue() {
        GlobalScope.launch {
            MyApplication.appDatabase.playQueueDao().loadAll().forEach {
                MyApplication.appDatabase.playQueueDao().deleteById(it.songData.id ?: "")
            }
            currentQueue.value?.let {
                for (song in 0..it.lastIndex) {
                    MyApplication.appDatabase.playQueueDao().insert(PlayQueueData(it[song]))
                }
            }
        }
    }

}