package com.dirror.music.api

/**
 * 网易云 API 地址
 */
object CloudMusicApi {

    /**
     * 默认搜索关键词
     * 说明 : 调用此接口 , 可获取默认搜索关键词
     */
    const val SEARCH_DEFAULT = "${API_AUTU}/search/default"

    /**
     * 首页-发现说明 : 调用此接口 , 可获取APP首页信息
     * 可选参数 : refresh: 是否刷新数据,默认为true
     */
    const val HOME_FIND = "${API_AUTU}/homepage/block/page"

    /**
     * 热搜列表(详细)
     * 说明 : 调用此接口,可获取热门搜索列表
     */
    const val SEARCH_HOT_DETAIL = "${API_AUTU}/search/hot/detail"

    /**
     * 获取歌手部分信息和歌手单曲
     * 说明 : 调用此接口 , 传入歌手 id, 可获得歌手部分信息和热门歌曲
     * 必选参数 : id: 歌手 id, 可由搜索接口获得
     * 接口地址 : /artists
     * 调用例子 : /artists?id=6452
     */
    const val ARTISTS = "${API_AUTU}/artists"

    /**
     * 获取歌词
     * 说明 : 调用此接口 , 传入音乐 id 可获得对应音乐的歌词 ( 不需要登录 )
     * 必选参数 : id: 音乐 id
     * 接口地址 : /lyric
     * 调用例子 : /lyric?id=33894312
     * 返回数据如下图 : 获取歌词
     */
    const val LYRIC = "${API_AUTU}/lyric"
}