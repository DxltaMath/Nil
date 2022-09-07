package icu.dxlta

import java.net.URI
import java.net.URL
import java.util.*

/** Get text from an online resource */
fun fetch (url : URL) : String {
    return Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next()
}

fun fetch (url : String) : String {
    return fetch(URL(url))
}

fun fetch (url : URI) : String {
    return fetch(url.toURL())
}
