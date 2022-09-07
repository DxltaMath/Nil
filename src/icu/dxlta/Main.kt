package icu.dxlta

import io.javalin.Javalin


class Main

fun main (args : Array<String>) {

    val app = Javalin.create().start(constants.HTTP_PORT)
    app.get("/") { ctx ->

        ctx.res.contentType = "text/html"
        ctx.result(website.INDEX)
    }
}