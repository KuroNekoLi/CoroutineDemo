package com.example.coroutinedemo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.concurrent.Executors

class MyViewModel : ViewModel() {
    private val executorService = Executors.newFixedThreadPool(2)
    val userLiveData : MutableLiveData<UserData> = MutableLiveData()

    fun  downloadUserData() {
        executorService.execute{
            for (i in 1..200000) {
                Log.i("LinLi", "value: $i");
                val currentThreadName = Thread.currentThread().name
                userLiveData.postValue(UserData(i, currentThreadName))
            }
        }
    }
}

data class UserData(val userId: Int, val threadName: String)
