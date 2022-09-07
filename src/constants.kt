object x {

     /** Override your own DMIx version here, if not, Nil will use the latest DMIx version. (updated manually by DxltaMath admins)
      * CAUTION: DMIx will prompt to update if the version does not math this one's version. */
     const val VERSION : String = "0.2.0"


    /** Override, if not it'll default to 80.
     * CAUTION: Remember that server port 80 is the default http port, and port 443 is the default HTTPS port. */
    const val HTTP_PORT : Int = 80


    /** Override your own dGUI bundle URL here, if not, Nil will use the official dGUI URL. (controlled by DxltaMath admins)
     * CAUTION: dGUIs have complete access. Only use dGUIs that you trust. */
    const val GUI_LINK : String = "https://raw.githubusercontent.com/DxltaMath/dGUI/master/dist/bundle.js"

    /** Set this to true if you would like to unminify main.js
     * CAUTION: this will HEAVILY increase the filesize of main.js- use for debugging ONLY. */
    const val UNMINIFY_SOURCE : Boolean = false

    /** Insert your own contents of index.html here, if not Nil's normal index.html will be used.
     * CAUTION: Remember that this is the exported main page of the site. Be wise. */

}