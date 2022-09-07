package icu.dxlta

import io.javalin.Javalin


/** entry point */
fun main(args: Array<String>) {
    Main.main();
}

object Main {

    @JvmStatic val app : Javalin = Javalin.create().start(constants.HTTP_PORT);

    @JvmStatic fun main () {

        app.get("/") { ctx ->
            ctx.res.contentType = "text/html"
            ctx.result(website.INDEX)
        }
    }



}