package com.github.uraurora.projectparser.resolver.utils

import com.github.javaparser.JavaParser
import com.github.javaparser.ast.Node
import java.nio.file.Path

fun JavaParser.walk(path: Path): Map<Path, Node> {
    return mapOf()
}


