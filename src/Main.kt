import io.javalin.Javalin

fun main (args : Array<String>) {

    val app = Javalin.create().start(x.HTTP_PORT)
    app.get("/") { ctx -> ctx.result("Hello World") }
}