package com.example.seniorandroiddev.coroutines.repository

import com.example.seniorandroiddev.coroutines.model.User
import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUsers(): List<User> {
        delay(5000)

        return listOf(
            User(id = 1, name = "Hilda"),
            User(id = 2, name = "Nkatha"),
            User(id = 3, name = "Peter"),
            User(id = 4, name = "Nancy"),
            User(id = 5, name = "Frida"),
        );
    }
}