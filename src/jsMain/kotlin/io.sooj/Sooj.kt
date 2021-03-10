package io.sooj

import androidx.compose.runtime.Composable
import compose.web.renderComposable
import io.sooj.platform.DEV
import io.sooj.router.Router
import io.sooj.utils.buildApiJson
import kotlinx.browser.document
import kotlinx.browser.window

fun sooj(app: @Composable Component.() -> Unit) {
    if (window.onload == null) {
        window.onload = {
            Sooj.init(app)
        }
        return
    }
    Sooj.init(app)
}

object Sooj {

    val apiJson = buildApiJson()

    var runAfterInitialized: ArrayList<() -> Unit>? = arrayListOf()

    fun init(app: @Composable Component.() -> Unit) {
        DEV = isDev

        val router = Router(windowRoute)
        window.onpopstate = {
            router.changeRoute(windowRoute)
        }

        renderComposable(document.body!!) {
            Component(router, 0).apply {
                app()
            }
        }

//        if (DEV) {
//            document.documentElement!!.replaceWith(document.create(rootBuildContext).html {
//                html(app)
//            })
//        }
//        else {
//            skipnContext.resources.init(byId("skipn-res").getAttribute("data-res")!!)
//
//            createHTML(rootBuildContext).html {
//                html(app)
//            }
//        }

//        createSkipnContext { skipnContext ->
//            context = skipnContext
//
//            DEV = byId("skipn-main-script").getAttribute("data-dev") == "true"
//
//            window.onpopstate = {
//                val route = "${window.location.pathname}${window.location.search}"
//                context.router.changeRoute(route)
//            }
//
//            val rootBuildContext = BuildContext.createRoot(skipnContext)
//
//            if (DEV) {
//                document.documentElement!!.replaceWith(document.create(rootBuildContext).html {
//                    html(app)
//                })
//            }
//            else {
//                skipnContext.resources.init(byId("skipn-res").getAttribute("data-res")!!)
//
//                createHTML(rootBuildContext).html {
//                    html(app)
//                }
//            }
//        }
//        runAfterInitialized!!.forEach {
//            it()
//        }
//        runAfterInitialized = null
    }

    private val isDev get() = (document.getElementById("sooj") ?: error("Sooj entry element with id 'sooj' is missing from index.html"))
        .getAttribute("data-dev") == "true"
    private val windowRoute get() = "${window.location.pathname}${window.location.search}"
}