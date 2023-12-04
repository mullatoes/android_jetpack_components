package com.example.seniorandroiddev

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(

) : ViewModel() {

    var count = MutableLiveData<Int>()
    private var startingTotal = 120

    val totalData: LiveData<Int>
        get() = count

    init {
        count.value = startingTotal
    }


    fun updateCount() {
        count.value = (count.value)?.plus(100)
    }

}