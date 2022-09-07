package icu.dxlta

/** The actual DeltaMath script patcher. */
object Nil {

    /** Latest unmodified main.js */
    @JvmStatic private var latestVanillaFile : String? = null;

    /** Latest patched main.js */
    @JvmStatic private var latestPatchedFile : String? = null;

    /** Latest main.js URL */
    @JvmStatic private var latestMainJsUrl : String? = null;




    @JvmStatic fun getMainJsUrl () : String {

        if (latestMainJsUrl !== null) {
            return latestMainJsUrl as String;
        } else {
            val html : String = fetch("https://www.deltamath.com/app/")
            val output : String = Regex("""/main\..{0,40}\.js/g""").find(html)?.value + "";

            latestMainJsUrl = output;
            return output;
        }
    }

}