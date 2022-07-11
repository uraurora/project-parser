package com.github.uraurora.projectparser.resolver.utils

import org.eclipse.aether.artifact.Artifact
import org.eclipse.aether.graph.Dependency

fun Artifact.directDependencies(): List<Dependency>{
    return listOf()
}