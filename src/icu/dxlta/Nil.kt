package icu.dxlta

/** The actual DeltaMath script patcher. */
object Nil {

    /** Latest unmodified main.js */
    @JvmStatic private var latestVanillaFile : String? = null;

    /** Latest patched main.js */
    @JvmStatic private var latestPatchedFile : String? = null;

    /** Latest main.js URL */
    @JvmStatic private var latestMainJsUrl : String? = null;



    /** Gets the latest URL to the main.js */
    @JvmStatic fun getMainJsUrl () : String {
        if (latestMainJsUrl === null) {
            val html : String = fetch("https://www.deltamath.com/app/")
            val output : String = Regex("""main\..{0,40}\.js""").find(html)?.value.toString();
            latestMainJsUrl = output;
        }
        return latestMainJsUrl as String;
    }

}