package com.github.uraurora.projectparser.resolver.aggregate

import com.github.javaparser.JavaParser
import com.github.uraurora.projectparser.core.utils.forEachPrintln
import com.github.uraurora.projectparser.core.utils.println
import com.github.uraurora.projectparser.core.utils.toPath
import com.github.uraurora.projectparser.resolver.utils.*
import org.junit.Test
import java.util.*
import kotlin.math.max


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
    @Test fun testPrimeFilter(){
        26.primeFilter().forEachPrintln()


        2.qmi(5, 31).println()

//        625.factorialDivide().forEachPrintln()

//        625.invAggregate(1000000007).forEachPrintln()

        (56 gcd 64).println()
        (56 lcm 64).println()

        (28 inv 13).println()

        val q = Array(1010){IntArray(110){0} }
        for(i in 1..1000){
            var tmp = 0
            for(j in 1..3){
                q[i][j] = q[i-1][j] + q[i-1][j-1] + 1
                tmp = max(tmp, q[i][j])
            }
            if(tmp > 100) {
                i.println()
                break
            }
        }
    }
}