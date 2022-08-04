package com.github.uraurora.projectparser.resolver.aggregate

import com.github.javaparser.JavaParser
import com.github.uraurora.projectparser.core.utils.*
import com.github.uraurora.projectparser.resolver.utils.*
import org.junit.Test
import java.util.*
import kotlin.math.max
import kotlin.math.min


class ModuleResolverTest {

    @Test
    fun resolve() {
        val path = "/Users/gaoxiaodong/project/wed-cpc-web/src/main/java/com/dianping/cpc/bean/AdParam.java"
                .toPath()
        var parser = JavaParser()
        val result = parser.parse(path)
        val component = result
                .takeIf { it.isSuccessful }
                .let { it?.result }
                .let { it?.get() }
        path.toAbsolutePath().println()
        component
                ?.dataKeys
                ?.forEachPrintln()
        println("=========")
        component
                ?.allComments
                ?.forEachPrintln()
        println("=========")
        component
                ?.primaryTypeName
                ?.get()
                ?.println()
        println("=========")
        component
                ?.packageDeclaration
                ?.get()
                ?.println()
    }


    @ExperimentalStdlibApi
    @Test
    fun testPrimeFilter() {
        26.primeFilter().forEachPrintln()


        2.qmi(5, 31).println()

//        625.factorialDivide().forEachPrintln()

//        625.invAggregate(1000000007).forEachPrintln()

        (56 gcd 64).println()
        (56 lcm 64).println()

        (28 inv 13).println()

        val q = Array(1010) { IntArray(110) { 0 } }
        for (i in 1..1000) {
            var tmp = 0
            for (j in 1..3) {
                q[i][j] = q[i - 1][j] + q[i - 1][j - 1] + 1
                tmp = max(tmp, q[i][j])
            }
            if (tmp > 100) {
                i.println()
                break
            }
        }
    }


    @Test
    fun testPick() {
        val n = 5
        val N = 10
        val q = Array(N) { IntArray(N) { 0 } }
        val dp = Array(2 * N) { Array(N) { IntArray(N) { 0 } } }

        for (i in 1..n)
            for (j in 1..n) {
                q[i][j] = j
            }

        for (k in 2..2 * n)
            for (i1 in 1..n)
                for (i2 in 1..n) {
                    val j1 = k - i1;
                    val j2 = k - i2
                    if (j1 in 1..n && j2 in 1..n) {
                        val t = if (q[i1][j1] == q[i2][j2]) q[i1][j1] else q[i1][j1] + q[i2][j2]
                        var x = max(dp[k][i1][i2], dp[k - 1][i1][i2] + t)
                        x = max(x, dp[k - 1][i1 - 1][i2 - 1] + t)
                        x = max(x, dp[k - 1][i1][i2 - 1] + t)
                        x = max(x, dp[k - 1][i1 - 1][i2] + t)
                        dp[k][i1][i2] = x
                    }
                }
        dp[n + n][n][n].println()
    }

    @Test
    fun testLongestPath() {
        val N = 20
        val n = 10
        val h = IntArray(N) { -1 }
        val ne = IntArray(N) { -1 }
        val w = IntArray(N) { 0 }
        val e = IntArray(N) { 0 }
        val f = IntArray(N) { -1 }
        val p = BooleanArray(N) { false }
        val pq = PriorityQueue<Pair<Int, Int>> { o1, o2 ->
            if(o2.second - o1.second == 0) o1.first - o2.second
            else o2.second - o1.second
        }
        var idx = 0


        val q = listOf(
                Triple(1,2,1),
                Triple(1,3,2),
                Triple(2,4,3),
                Triple(2,5,4),
                Triple(3,6,5),
                Triple(3,7,6)
        )
        fun add(a: Int, b: Int, c: Int) {
            e[idx] = b; w[idx] = c; ne[idx] = h[a]; h[a] = idx++
        }

        fun dfs(node:Int):Int{
            if(f[node] != -1) return f[node]
            var res = 0

            var i = h[node]
            while (i != -1) {
                res = max(res, dfs(e[i]) + w[i])
                i = ne[i]
            }
            pq.add(node to res)
            f[node] = res; return res
        }

        for((a, b, c) in q){
            add(a, b, c)
            p[b] = true
        }
        var root = 1
        while(p[root]) root++
        dfs(root)
        var res = 0
        var i = h[root]
        while (i != -1) {
            res += f[i]
            i = ne[i]
        }
        print(res)
    }

}