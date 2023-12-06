package com.example.seniorandroiddev.coroutines.viewmodelscope

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.seniorandroiddev.coroutines.repository.UserRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {

    private var userRepository = UserRepository()

    var users = liveData(Dispatchers.IO) {
        val result = userRepository.getUsers();
        emit(result)
    }

//    var users: MutableLiveData<List<User>> = MutableLiveData()
//
//    fun getUserData() {
//        viewModelScope.launch {
//
//            var result: List<User>? = null
//            withContext(Dispatchers.IO) {
//                result = userRepository.getUsers()
//            }
//            users.value = result!!
//        }
//
//    }

}