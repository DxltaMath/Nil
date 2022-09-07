package icu.dxlta

import java.net.URI
import java.net.URL
import java.util.*


fun fetch (url : String) : String {
    return Scanner(URL(url).openStream(), "UTF-8").useDelimiter("\\A").next()
}

fun fetch (url : URL) : String {
    return Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next()
}

fun fetch (url : URI) : String {
    return Scanner(url.toURL().openStream(), "UTF-8").useDelimiter("\\A").next()
}