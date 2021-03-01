package io.sooj

object BrowserOnly : Exception(
    "Browser only function should not be called on the server!" +
    "Please ensure that a function that is Browser only does not get invoked on the server!"
)