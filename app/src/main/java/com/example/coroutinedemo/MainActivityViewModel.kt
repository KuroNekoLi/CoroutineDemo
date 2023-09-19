package com.example.coroutinedemo

import androidx.lifecycle.*
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

//    Android架構組件團隊引入了一個新的協程（coroutine）構建塊，用於LiveData。這個新的構建塊會在LiveData變得活躍時自動執行。
//    它會自動決定何時停止執行，並考慮到生命週期所有者（lifecycle owner）的狀態來取消構建塊內的協程。
//    在LiveData的構建塊內，你可以使用emit()函數來為LiveData設置一個值。
    var users = liveData(IO){
        val result = userRepository.getUsers()
        emit(result)
    }
//    var users : MutableLiveData<List<User>> = MutableLiveData()
//
//    fun getUserData(){
//        viewModelScope.launch {
//            var result : List<User>? = null
//            //耗時操作，所以要切換到IO線程
//            withContext(IO){
//                result = userRepository.getUsers()
//            }
//            //接著要將它作為livedata
//            users.value = result
//            //再來回到MainActivity
//        }
//    }
}