package com.github.uraurora.projectparser.resolver.aggregate

import com.github.javaparser.JavaParser
import com.github.javaparser.symbolsolver.JavaSymbolSolver
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver
import java.nio.file.Path

/**
 * @program : project-parser
 * @author : sei
 * @date : 2022-07-11 15:19
 * @description :
 */
class ModuleResolver(path: Path) {

    lateinit var symbolSolver: JavaSymbolSolver

    lateinit var parser: JavaParser

    init {
        symbolSolver = JavaSymbolSolver(CombinedTypeSolver())
    }

    fun resolve() {
    }

}