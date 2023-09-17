package com.example.coroutinedemo

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserDataManager {

    suspend fun getTotalUserCount():Int{
        var count = 0
        CoroutineScope(IO).launch {
            delay(1000)
            count = 50
        }

        //用async可以達到效果，但不是好方法，因為沒有辦法處理例外
        val deferred = CoroutineScope(IO).async {
            delay(3000)
            return@async 70
        }
        return count+deferred.await()
    }
}