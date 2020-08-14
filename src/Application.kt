package com.mcevoy.ktor.learning

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.request.receiveText
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing {
        get("/") {
            call.respondText("My name is Luke McEvoy ... I am trying to learn Ktor & HTTP",
            contentType = ContentType.Text.Plain)
        }

        var whoAmI = "You're first on line ... Enter your name"
        get("/whoami") {
            call.respondText(whoAmI, contentType = ContentType.Text.Plain)
        }

        post("whoami") {
            whoAmI = call.receiveText()
            call.respondText("Who am I has changed to ... $whoAmI",
                contentType = ContentType.Text.Plain)
        }
    }
}