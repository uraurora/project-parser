package com.github.uraurora.projectparser.resolver.utils

import com.github.uraurora.projectparser.resolver.utils.GsonHelper.GSON
import com.google.gson.Gson
import java.lang.reflect.Type
import java.util.stream.Collectors
import kotlin.reflect.KClass

fun <E> E.println() {
    println(this)
}

fun <E> E.print() {
    print(this)
}

//<editor-fold desc="json">
object GsonHelper {
    val GSON: Gson = Gson()
}

fun <E> String.fromJson(type: Type): E {
    return GSON.fromJson(this, type)
}

fun <E> E.json(): String {
    return GSON.toJson(this)
}
//</editor-fold>

fun <K, V> Map<K, V>.pairs(): List<Pair<K, V>> {
    return entries.map { Pair(it.key, it.value) }
}

fun <K, V> List<Pair<K, V>>.toMap(): Map<K, V> {
    return this.asSequence().toMap()
}