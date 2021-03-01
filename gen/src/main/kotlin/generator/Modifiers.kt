package generator

import Modifier
import androidx.compose.runtime.Composable
import attrs
import com.squareup.kotlinpoet.*
import io.github.enjoydambience.kotlinbard.*
import io.sooj.tag
import model.Context
import model.Tag
import snakeCaseToCamelCase

fun FileSpecBuilder.generateAttrs() {
    attrs.forEach {
        addFunction(it.name) {
            receiver(Modifier::class)
            returns(Modifier::class)


            addParameter(it.name, ClassName("", it.paramType.simpleName!!).copy(nullable = true))

            addStatement("""return then(%T("${it.name}", ${it.name}))""", ClassName("io.sooj.modifiers", "AttrModifier"))
        }
    }
}
//@Composable
//fun div(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}) {
//    tag(modifier, "div", content = content)
//}
typealias ContentLambda = () -> Unit

fun FileSpecBuilder.generateTags() {
    addImport("io.sooj", "tag")

    Tag.values.distinctBy { it.tagName }.forEach { tag ->
        addFunction(tag.tagName) {
//            receiver(tag.callingContext::class)
            addAnnotation(Composable::class)

            for (attr in tag.supportedAttributes) {
//                val filteredModifiers = attr.modifiers.filter {
//                    isInline && it === KModifier.NOINLINE
//                }
                addParameter(attr.functionName, attr.className) {
                    if (attr.defaultValue != null) {
                        defaultValue(attr.defaultValue)
                    }
//                    addModifiers(filteredModifiers)
                }
//                addParameter(
//                    ParameterSpec.builder(attr.functionName, attr.className).apply {
//                        if (attr.defaultValue != null) {
//                            defaultValue(attr.defaultValue)
//                        }
//                        addModifiers(filteredModifiers)
//                    }.build()
//                )
            }

            addParameter("modifier", Modifier::class) {
                defaultValue("%L", Modifier)
            }

//            val contentReceier = tag.childrenContext()?.contextClassName

            addParameter(
                "content", LambdaTypeName.get(
//                receiver = contentReceier,
                    returnType = UNIT
                ).copy(annotations = listOf(
                    buildAnnotation(Composable::class),
                ))
            ) {

                defaultValue("%L", "{}")
            }

            var modifierRef = "modifier"

            tag.supportedAttributes.forEach {
                modifierRef += ".${it.functionName}(${it.functionName})"
            }

            addStatement("""tag("${tag.tagName}", $modifierRef, content = content)""")
        }
    }
}
//fun Modifier.value(value: Any?) : Modifier =
//    then(AttrModifier("value", value))

///**
// * Represents an attribute modifier
// * While the HTML parameter for an attribute is always String,
// * giving a parameter a corresponding value and then convert it
// * to string is better
// */
//class AttrModifier(val name: String, val paramType: KClass<*>)
//
//val attrs = listOf(
//    AttrModifier("value", Any::class)
//)

fun Tag.childrenContext(): Context? = when (this) {
    is Tag.Normal -> childrenContext
    is Tag.Void -> null
}