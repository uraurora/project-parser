package com.github.uraurora.projectparser.resolver.utils

import java.math.BigInteger
import java.util.*

@ExperimentalStdlibApi
fun Int.primeFilter(): List<Int> {
    val f = Array(this + 10) { 0 }
    for (i in 2..this) {
        if (f[i] == 0) {
            var j = 2 * i
            while (j <= this) {
                f[j] = 1
                j += i
            }
        }
    }
    return buildList {
        for ((index, value) in f.withIndex()) {
            if (index in 2..this@primeFilter && value == 0) add(index)
        }
    }
}

fun Int.factorial(): BigInteger {
    var res = BigInteger.ONE
    (2..this).forEach {
        res = res.multiply(BigInteger.valueOf(it.toLong()))
    }
    return res
}

fun Int.qmi(b: Int, p: Int): Long {
    var m: Long = this.toLong()
    var res = 1L
    var k = b
    while (k != 0) {
        if ((k and 1) == 1) res = res * m % p
        k = k shr 1
        m = m * m % p
    }
    return res
}

/**
 * 阶乘的质因数分解，返回质因子->个数的pair列表
 */
@ExperimentalStdlibApi
fun Int.factorialDivide(): List<Pair<Int, Int>> {
    var cnt = 0
    val p = Array(this + 1) { 0 }
    val f = Array(this + 1) { 0 }
    for (i in 2..this) {
        if (f[i] == 0) {
            p[cnt++] = i
            var j = 2 * i
            while (j <= this) {
                f[j] = 1
                j += i
            }
        }
    }
    return buildList {
        (0 until cnt).forEach {
            var n = this@factorialDivide;
            var s = 0
            while (n > 0) {
                s += n / p[it]
                n /= p[it]
            }
            add(Pair(p[it], s))
        }
    }
}

/**
 * 返回打表数据
 */
fun Int.invAggregate(mod: Int): List<Inv> {
    val fact = Array(this + 10) { 1L }
    val inv = Array(this + 10) { 1L }
    val fiv = Array(this + 10) { 1L }
    for (i in 2..this + 1) {
        fact[i] = fact[i - 1] * i % mod
        inv[i] = (mod - mod / i) * inv[mod % i] % mod
        fiv[i] = fiv[i - 1] * inv[i] % mod
    }
    return (2..this + 1).map { Inv(fact = fact[it], inv = inv[it], fiv = fiv[it]) }
}

infix fun Int.gcd(other: Int): Int = if (other == 0) this else other gcd (this % other)

infix fun Int.lcm(other: Int): Int = (this * other) / (this gcd other)

fun Iterable<Int>.gcd(vararg others:Int): Int = this.reduce{ i, j -> i gcd j }


fun Iterable<Int>.lcm(vararg others:Int): Int = this.reduce{ i, j -> i lcm j }

infix fun Int.mod(mod: Int): Int = this % mod

fun exgcd(a: Int, b: Int): Triple<Int, Int, Int>{
    if(b == 0) return Triple(1, 0, a)
    var (x, y, gcd) = exgcd(b, a mod b)
    x = y.also { y = x - (a / b) * y }
    return Triple(x, y, gcd)
}

infix fun Int.inv(mod: Int): Int{
    val (x, _, gcd) = exgcd(this, mod)
    return if (gcd != 1) -1 else (mod + x mod mod) mod mod
}


/**
 * [fact] n! mod p
 * [inv] a^(-1) mod p
 * [fiv] (n!)^(-1) mod p
 */
data class Inv(val fact: Long, val inv: Long, val fiv: Long)