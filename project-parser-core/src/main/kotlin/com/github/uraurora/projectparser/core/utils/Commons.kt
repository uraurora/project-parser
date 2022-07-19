package com.github.uraurora.projectparser.core.utils

import com.github.uraurora.projectparser.core.utils.JsonHelper.GSON
import com.google.gson.Gson
import mu.KLogger
import mu.KotlinLogging
import java.lang.reflect.Type

//<editor-fold desc="io">
fun <E> E.println() {
    println(this)
}

fun <E> E.print() {
    print(this)
}
//</editor-fold>

/**
 * see [KLogger] and [KotlinLogging]
 * create logger instance for internal logger initial
 */
fun <T : Any?> T.logger(): KLogger {
    return KotlinLogging.logger {}
}

/**
 * see [KLogger] and [KotlinLogging]
 * create logger instance for internal logger initial
 * the logger can be named
 */
fun <T : Any?> T.logger(name: String): KLogger {
    return KotlinLogging.logger(name)
}

fun <T : Collection<Any>> T.forEachPrintln() {
    this.forEach { it.println() }
}

fun <T : Collection<Any>> T.forEachPrintln(mapper: (Any) -> String) {
    this.forEach { mapper(it).println() }
}

//<editor-fold desc="json">
object JsonHelper {
    val GSON: Gson = Gson()
}

/**
 * parse a json str to a object by [Type]
 * use [Gson] as the json parser
 */
fun <E> String.fromJson(type: Type): E {
    return GSON.fromJson(this, type)
}

/**
 * parse a object to json str
 * use [Gson] as the json parser
 */
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

inline fun <T, A, B> Pair<A, B>.transform(mapper: (Pair<A, B>) -> T): T {
    return mapper(this)
}

infix fun <E : Comparable<E>> E.compareTo(other: E): Int {
    return this.compareTo(other)
}