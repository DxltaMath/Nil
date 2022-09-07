import io.javalin.Javalin

fun main (args : Array<String>) {

    val app = Javalin.create().start(constants.HTTP_PORT)
    app.get("/") { ctx ->

        ctx.res.contentType = "text/html"
        ctx.result(website.INDEX)
    }
}