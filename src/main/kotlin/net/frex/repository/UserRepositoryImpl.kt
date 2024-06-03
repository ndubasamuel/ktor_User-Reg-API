package net.frex.repository

import net.frex.service.CreateUserParams
import net.frex.service.UserService
import net.frex.utils.BaseResponse

class UserRepositoryImpl(private val userService: UserService) : UserRepository {



    override suspend fun registerUser(params: CreateUserParams) : BaseResponse<Any> {

        return if (isEmailExist(params.email)) {
            BaseResponse.ErrorResponse(message = "Email Already Registered")
        } else {
            val user = userService.registerUser(params)
            if(user != null){

//                @Generate an authentication token
                BaseResponse.SuccessResponse(data = user)
            } else {
                BaseResponse.ErrorResponse()
            }
        }

    }
    override suspend fun loginUser(email: String, password: String) : BaseResponse<Any> {
        TODO()

    }

    private suspend fun isEmailExist(email: String): Boolean{
        return userService.findUserByEmail(email) != null
    }
}