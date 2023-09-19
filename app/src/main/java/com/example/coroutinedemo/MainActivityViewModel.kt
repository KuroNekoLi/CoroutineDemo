package com.example.coroutinedemo

import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutinedemo.model.User
import com.example.coroutinedemo.model.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {
    //創建repository實例
    private var userRepository = UserRepository()
    var users : MutableLiveData<List<User>> = MutableLiveData()

    fun getUserData(){
        viewModelScope.launch {
            var result : List<User>? = null
            //耗時操作，所以要切換到IO線程
            withContext(IO){
                result = userRepository.getUsers()
            }
            //接著要將它作為livedata
            users.value = result
            //再來回到MainActivity
        }
    }
}