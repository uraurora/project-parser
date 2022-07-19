package com.github.uraurora.projectparser.core

import java.nio.file.Path

/**
 * @program : project-parser
 * @author : sei
 * @date : 2022-07-05 21:30
 * @description : module interface, describe a module of java project
 */
interface IModule : ICompilable, IDeployable, ICommandExecutable, IVersion {

    fun name(): String

    fun path(): Path

    fun sourcePaths(): List<Path>

    fun testPaths(): List<Path>

    fun resourcePaths(): List<Path>

    fun testResourcePaths(): List<Path>

    fun defaultSourcePath(): Path {
        return path().resolve(SOURCE)
    }

    fun defaultTestSourcePath(): Path {
        return path().resolve(TEST_SOURCE)
    }

    fun defaultResourcesPath(): Path {
        return path().resolve(RESOURCES)
    }

    fun defaultTestResourcesPath(): Path {
        return path().resolve(TEST_RESOURCES)
    }

    companion object {
        const val SRC = "src"

        const val MAIN = "$SRC/main"

        const val SOURCE = "$MAIN/java"

        const val KOTLIN_SOURCE = "$MAIN/kotlin"

        const val RESOURCES = "$MAIN/resources"

        const val TEST = "$SRC/test"

        const val TEST_SOURCE = "$TEST/java"

        const val TEST_RESOURCES = "$TEST/resources"
    }

}