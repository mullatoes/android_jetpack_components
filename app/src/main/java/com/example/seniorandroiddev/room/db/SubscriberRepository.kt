package com.example.seniorandroiddev.room.db

class SubscriberRepository(
    private val dao: SubscriberDao
) {
    val subscribers =
        dao.getAllSubscribers() //no need for suspend... room does all the background processing

    suspend fun insert(subscriber: Subscriber) {
        dao.insertSubscriber(subscriber)
    }

    suspend fun update(subscriber: Subscriber) {
        dao.updateSubscriber(subscriber)
    }

    suspend fun delete(subscriber: Subscriber) {
        dao.deleteSubscriber(subscriber)
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }
}