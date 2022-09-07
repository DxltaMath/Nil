package icu.dxlta

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
            ctx.res.addHeader("Cache-Control", "No-Store")
            println(ctx.req.remoteAddr)
        }

        website()
        redirects()

        app.get("/mjsurl") { ctx ->
            ctx.result(Nil.getMainJsUrl())
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