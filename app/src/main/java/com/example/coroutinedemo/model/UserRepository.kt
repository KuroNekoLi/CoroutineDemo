package com.example.coroutinedemo.model

import kotlinx.coroutines.delay

class UserRepository {
    //在真實的狀況中可能是從呼叫REST API，或者從地端的資料庫得到
    suspend fun getUsers() : List<User>{
        //模擬取得資料的耗時操作
        delay(8000)
        val users : List<User> = listOf(
            User(1,"Sam"),
            User(2,"Taro"),
            User(3,"Jame"),
            User(4,"Amy")
        )
        return users
    }
}