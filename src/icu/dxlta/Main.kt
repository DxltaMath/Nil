package icu.dxlta

import icu.dxlta.constants.Args
import icu.dxlta.constants.Constants
import io.javalin.Javalin


/** entry point */
fun main (args: Array<String>) {

    Nil.startCaching(Args(args))
    Main.main();
}

object Main {


    @JvmStatic val app : Javalin = Javalin.create().start(Constants.HTTP_PORT);

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
            ctx.result(Constants.VERSION)
        }



    }

    /** Add website pages to the server. */
    @JvmStatic fun website () {

        app.get("/") { ctx ->
            ctx.res.contentType = "text/html"
            ctx.result(icu.dxlta.constants.Website.INDEX)
        }

        app.get("/index.html") { ctx ->
            ctx.redirect("/")
        }

        app.get("/style.css") { ctx ->
            ctx.res.contentType = "text/css"
            ctx.result(icu.dxlta.constants.Website.STYLE)
        }
    }

    /** Add redirect pages to the server. */
    @JvmStatic fun redirects () {

        app.get("/license") { ctx ->
            ctx.redirect(Constants.LICENSE_LINK)
        }

    }



}