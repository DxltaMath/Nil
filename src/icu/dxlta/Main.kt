package icu.dxlta

import icu.dxlta.constants.VERSION
import io.javalin.Javalin


/** entry point */
fun main(args: Array<String>) {
    Main.main();
}

object Main {

    @JvmStatic val app : Javalin = Javalin.create().start(constants.HTTP_PORT);

    /** The main server runner. */
    @JvmStatic fun main () {

        app.before { ctx ->
            ctx.res.addHeader("Access-Control-Allow-Origin", "*")
            ctx.res.addHeader("Cache-Control", "No-Store")
            println(ctx.req.remoteAddr)
        }

        website()
        redirects()

        app.get("/main*js") { ctx ->
            ctx.redirect("/app/main.js")
        }
        app.get("/app/main*js") { ctx ->
            ctx.res.contentType = "text/javascript"
            ctx.result(Nil.getPatchedFile())
        }

        app.get("/version") { ctx ->
            ctx.res.contentType = "text/plain"
            ctx.result(VERSION)
        }



    }

    /** Add website pages to the server. */
    @JvmStatic fun website () {

        app.get("/") { ctx ->
            ctx.res.contentType = "text/html"
            ctx.result(website.INDEX)
        }

        app.get("/index.html") { ctx ->
            ctx.redirect("/")
        }

        app.get("/style.css") { ctx ->
            ctx.res.contentType = "text/css"
            ctx.result(website.STYLE)
        }
    }

    /** Add redirect pages to the server. */
    @JvmStatic fun redirects () {

        app.get("/license") { ctx ->
            ctx.redirect(constants.LICENSE_LINK)
        }

    }



}