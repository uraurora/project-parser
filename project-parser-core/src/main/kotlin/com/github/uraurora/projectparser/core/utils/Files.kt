package com.github.uraurora.projectparser.core.utils

import org.apache.commons.io.FileUtils
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.Path

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

fun String.toFile(): File = File(this)

fun String.toPath(): Path = Paths.get(this)