package com.github.uraurora.projectparser.resolver.utils

import org.eclipse.aether.graph.Dependency

fun Dependency.coordinate(): String {
    return this.toString()
}