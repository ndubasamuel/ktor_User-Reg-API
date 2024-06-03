package net.frex.service

import net.frex.db.DatabaseFactory.dbQuery
import net.frex.db.UserTable
import net.frex.model.User
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.statements.InsertStatement

class UserServiceImpl : UserService {
    override suspend fun registerUser(params: CreateUserParams): User? {
        var statement: InsertStatement<Number>? = null

        dbQuery {
            statement = UserTable.insert {
                it [email] = params.email
                it [password] = params.password //Password Encryption
                it [fullName] = params.fullName

            }

        }
        return rowToUser(statement?.resultedValues?.get(0))
    }

    override suspend fun findUserByEmail(email: String): User? {
        val user = dbQuery {
            UserTable.select{UserTable.email.eq(email)}
                .map { rowToUser(it) }.singleOrNull()
        }
        return user
    }

    private fun rowToUser(row: ResultRow?): User? {
        return if(row == null) null
        else User(
            id = row[UserTable.id],
            fullName = row[UserTable.fullName],
            email = row[UserTable.email],
            phoneNumber = row[UserTable.phoneNumber],
            password = row[UserTable.password],
            createdAt = row[UserTable.createdAt].toString(),

        )
    }
}