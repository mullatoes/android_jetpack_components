package com.example.seniorandroiddev.room.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seniorandroiddev.room.db.Subscriber
import com.example.seniorandroiddev.room.db.SubscriberRepository
import com.example.seniorandroiddev.room.event.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SubscriberViewModel(
    private val repository: SubscriberRepository
) : ViewModel() {

    val subscribers = repository.subscribers

    val inputName = MutableLiveData<String>()
    val inputEmail = MutableLiveData<String>()

    private var isUpdateOrDelete = false
    private lateinit var subscriberToDelete: Subscriber

    private val statusMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>>
        get() = statusMessage



    val saveOrUpdateButtonText = MutableLiveData<String>()
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate() {

        if (isUpdateOrDelete) {
            subscriberToDelete.name = inputName.value.toString()
            subscriberToDelete.email = inputEmail.value.toString()
            update(subscriberToDelete)
        } else {
            val name = inputName.value
            val email = inputEmail.value
            val subscriber = Subscriber(0, name!!, email!!)
            insert(subscriber)

            inputName.value = ""
            inputEmail.value = ""
        }
    }

    fun clearAllOrDelete() {
        if (isUpdateOrDelete) {
            delete(subscriberToDelete)
        } else {
            clearAll()
        }
    }

    fun insert(subscriber: Subscriber) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(subscriber)
            withContext(Dispatchers.Main){
                statusMessage.value = Event("Subscriber inserted successfully")
            }
        }
    }

    fun update(subscriber: Subscriber) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(subscriber)
            withContext(Dispatchers.Main){
                statusMessage.value = Event("Subscriber updated successfully")
            }
        }
    }

    fun delete(subscriber: Subscriber) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(subscriber)

            withContext(Dispatchers.Main) {
                inputName.value = ""
                inputEmail.value = ""

                isUpdateOrDelete = false
                saveOrUpdateButtonText.value = "Save"
                clearAllOrDeleteButtonText.value = "Clear All"
                statusMessage.value = Event("Subscriber deleted successfully")
            }
        }
    }

    fun clearAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()

            withContext(Dispatchers.Main){
                statusMessage.value = Event("All subscribers deleted successfully")
            }
        }
    }

    fun initUpdateAndDelete(subscriber: Subscriber) {
        inputName.value = subscriber.name
        inputEmail.value = subscriber.email

        isUpdateOrDelete = true
        subscriberToDelete = subscriber
        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }

}