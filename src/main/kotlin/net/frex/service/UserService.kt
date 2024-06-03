package net.frex.service

import org.apache.catalina.User

interface UserService {
    suspend fun registerUser(params: CreateUserParams): net.frex.model.User?
    suspend fun findUserByEmail(email: String) : net.frex.model.User?
}
