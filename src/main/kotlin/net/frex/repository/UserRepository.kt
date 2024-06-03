package net.frex.repository

import net.frex.service.CreateUserParams
import net.frex.utils.BaseResponse

interface UserRepository {

    suspend fun registerUser(params: CreateUserParams) : BaseResponse<Any>

    suspend fun loginUser(email: String, password: String) : BaseResponse<Any>

}