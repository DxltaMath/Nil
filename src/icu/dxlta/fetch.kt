package icu.dxlta

import java.net.URL
import java.util.*

fun fetch (url : String) : String {
    return Scanner(URL(url).openStream(), "UTF-8").useDelimiter("\\A").next()
}