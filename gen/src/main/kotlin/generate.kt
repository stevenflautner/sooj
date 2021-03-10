import androidx.compose.runtime.Composable
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.UNIT
import com.squareup.kotlinpoet.asTypeName
import io.github.enjoydambience.kotlinbard.*
import io.sooj.modifiers.onInput
import model.Attr
import model.Tag
import model.attrs

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

fun FileSpecBuilder.generateTags() {
    val compClass = ClassName("io.sooj", "Component")

    addImport("io.sooj", "tag")
    addImport("io.sooj.modifiers", "Event")
    addImport("io.sooj.modifiers", "onInput")

    Tag.values.distinctBy { it.tagName }.forEach { tag ->
        addFunction(tag.tagName) {
            receiver(compClass)
            addAnnotation(Composable::class)

            addParameter("classes", String::class.asTypeName().nullable) {
                defaultValue("%L", null)
            }

            for (attr in tag.supportedAttributes) {
//                val filteredModifiers = attr.modifiers.filter {
//                    isInline && it === KModifier.NOINLINE
//                }
                when (attr) {
                    is Attr.Custom -> {
                        addParameter(attr.functionName, attr.className) {
                            defaultValue("%L", null)
                        }
                    }
                    else -> {
                        addParameter(attr.functionName, attr.className) {
                            if (attr.defaultValue != null) {
                                defaultValue(attr.defaultValue)
                            }
                        }
                    }
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

            addParameter("mod", Modifier::class) {
                defaultValue("%L", Modifier)
            }

//            val contentReceier = tag.childrenContext()?.contextClassName

            addParameter(
                "content", LambdaTypeName.get(
                    receiver = compClass,
                    returnType = UNIT
                ).copy(annotations = listOf(
                    buildAnnotation(Composable::class),
                ))
            ) {
                defaultValue("%L", "{}")
            }

            val modifierRef = StringBuilder("mod")

            modifierRef.append(".classes(classes)")

            tag.supportedAttributes.forEach {
                modifierRef.append(
                    when (it) {
                        is Attr.Custom -> {
                            if (tag.tagName == "input" && it.name == "onInput")
                                ".${it.functionName}(${it.functionName} as Event)"
                            else ".${it.functionName}(${it.functionName})"
                        }
                        else -> ".${it.functionName}(${it.functionName})"
                    }
                )
            }

            addStatement("""tag("${tag.tagName}", $modifierRef, content = content)""")
        }
    }
}