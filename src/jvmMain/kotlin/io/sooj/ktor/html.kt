package io.sooj.ktor

import androidx.compose.runtime.Composable
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.util.cio.*
import io.ktor.utils.io.*
import io.sooj.Component
import io.sooj.html.HTMLStreamBuilder
import io.sooj.router.Router

/**
 * Represents an [OutgoingContent] using `kotlinx.html` builder.
 */
class ServerRenderContent(
    private val uri: String,
    private val app: @Composable Component.() -> Unit
) : OutgoingContent.WriteChannelContent() {

    override val status = HttpStatusCode.OK
    override val contentType: ContentType
        get() = ContentType.Text.Html.withCharset(Charsets.UTF_8)

    override suspend fun writeTo(channel: ByteWriteChannel) {
        channel.bufferedWriter().use { stream ->
            stream.append("<!DOCTYPE html>\n")

            val builder = HTMLStreamBuilder(
                stream,
                prettyPrint = false
            )
            Component(builder, Router(uri), 0).apply {
//                app()
            }
        }
    }
}

/**
 * Responds to a client with a HTML response, using specified [block] to build an HTML page
 */
suspend fun ApplicationCall.respondServerRenderedContent(app: @Composable Component.() -> Unit) {
    respond(ServerRenderContent(request.uri, app))
}