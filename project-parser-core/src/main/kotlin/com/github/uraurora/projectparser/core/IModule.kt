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

}