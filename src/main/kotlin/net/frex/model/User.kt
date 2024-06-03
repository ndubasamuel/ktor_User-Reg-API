package net.frex.model

import net.frex.db.UserTable
import net.frex.db.UserTable.autoIncrement

data class User(
    val id: Int,
    val fullName : String,
    val email : String,
    val phoneNumber : Int,
    val password : String,
    val authToken: String? = null,
    val createdAt: String
)