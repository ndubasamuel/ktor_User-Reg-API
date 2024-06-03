package net.frex.routes

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import net.frex.repository.UserRepository
import net.frex.service.CreateUserParams

fun Application.authRoutes(repository: UserRepository){


    routing {
        route("/auth") {
            post("/register") {
                val params = call.receive<CreateUserParams>()
                val result = repository.registerUser(params)
                call.respond(result.statusCode, result)
            }
        }
    }
}