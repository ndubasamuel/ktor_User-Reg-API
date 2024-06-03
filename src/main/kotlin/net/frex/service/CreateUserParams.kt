package net.frex.service

data class CreateUserParams(
    val fullName: String,
    val email: String,
    val password: String
)