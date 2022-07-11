package com.github.uraurora.projectparser.core.aggregate

import com.github.uraurora.projectparser.core.IVersion
import org.eclipse.aether.artifact.Artifact
import org.eclipse.aether.version.Version
import java.io.File
import java.nio.file.Path
import java.util.regex.Pattern

/**
 * @program : project-parser
 * @author : sei
 * @date : 2022-07-07 11:18
 * @description : abstract module
 */
abstract class AbstractModule(val path: Path) {

    lateinit var artifact: Artifact

    lateinit var buildFile: File

    init {

    }

    fun name(): String {
        return ""
    }

    fun path(): Path {
        return path
    }

    open fun version(): String {

        TODO("Not yet implemented")
    }

    open fun compareTo(other: Version?): Int {
        TODO("Not yet implemented")
    }

}