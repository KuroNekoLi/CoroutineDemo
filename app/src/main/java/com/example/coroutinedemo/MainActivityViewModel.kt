package com.example.coroutinedemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private val myJob = Job()
    //為了能停止作用域的協程，我們必須傳遞一個Job()的實例到CoroutineScope的參數
    //這個Job可以控制此作用域內的所有協程
    private val myScope = CoroutineScope(IO+myJob)


    fun getUserData(){
        myScope.launch {
            //程式碼...
        }
    }

    fun getUserData2(){
        //viewModelScope是一個綁定viewModel的協程作用域
        viewModelScope.launch {
            //程式碼...
        }
    }

    //為了避免memory leak，在onCleared中必須取消此協程
    override fun onCleared() {
        super.onCleared()
        myJob.cancel()
    }
}