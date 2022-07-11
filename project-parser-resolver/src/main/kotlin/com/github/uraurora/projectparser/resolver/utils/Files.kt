package com.github.uraurora.projectparser.resolver.utils

import org.apache.commons.io.FileUtils
import java.nio.file.Files
import java.nio.file.Path

fun Path.exists(): Boolean {
    return Files.exists(this)
}

fun Path.isDirectory(): Boolean {
    return Files.isDirectory(this)
}

fun Path.isRegularFile(): Boolean {
    return Files.isRegularFile(this)
}

fun Path.delete(): Boolean {
    return if (exists()) FileUtils.deleteQuietly(toFile()) else true
}