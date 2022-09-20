package icu.dxlta

import icu.dxlta.constants.Constants
import icu.dxlta.constants.Website
import io.javalin.Javalin


/** entry point */
fun main (args: Array<String>) {

    Nil.startCaching(Args(args))
    Main.main();
}

object Main {


    @JvmStatic val app : Javalin = Javalin.create { config ->

    }.start(Constants.HTTP_PORT);

    /** The main server runner. */
    @JvmStatic fun main () {

        app.before { ctx ->
            ctx.header("Access-Control-Allow-Origin", "*")
            ctx.header("Cache-Control", "No-Store")
            println(ctx.ip())
        }

        website()
        redirects()

        app.get("/main*js") { ctx ->
            ctx.redirect("/app/main.js")
        }
        app.get("/app/main*js") { ctx ->
            ctx.contentType("text/javascript");
            ctx.result(Nil.getPatchedFile())
        }

        app.get("/version") { ctx ->
            ctx.contentType("text/plain");
            ctx.result(Constants.VERSION)
        }

        app.get("/mjs") { ctx ->
            ctx.contentType("text/plain");
            ctx.result(Nil.getMainJsUrl())
        }



    }

    /** Add website pages to the server. */
    @JvmStatic fun website () {

        app.get("/") { ctx ->
            ctx.contentType("text/html");
            ctx.result(Website.INDEX)
        }

        app.get("/index.html") { ctx ->
            ctx.redirect("/")
        }

        app.get("/style.css") { ctx ->
            ctx.contentType("text/css");
            ctx.result(Website.STYLE)
        }
    }

    /** Add redirect pages to the server. */
    @JvmStatic fun redirects () {

        app.get("/license") { ctx ->
            ctx.redirect(Constants.LICENSE_LINK)
        }

    }



}