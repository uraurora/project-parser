package com.github.uraurora.projectparser.core.aggregate

import com.github.uraurora.projectparser.core.IModule
import com.github.uraurora.projectparser.core.IVersion
import com.github.uraurora.projectparser.core.utils.logger
import org.eclipse.aether.artifact.Artifact
import org.eclipse.aether.version.Version
import java.io.File
import java.nio.file.Path

/**
 * @program : project-parser
 * @author : sei
 * @date : 2022-07-07 10:54
 * @description : maven module
 */
open class MavenModule(path: Path) : AbstractModule(path), IModule {

    companion object {
        val logger = logger()
    }

    lateinit var sourcePaths: List<Path>


    init {

    }

    override fun sourcePaths(): List<Path> {
        TODO("Not yet implemented")
    }

    override fun testPaths(): List<Path> {
        TODO("Not yet implemented")
    }

    override fun resourcePaths(): List<Path> {
        TODO("Not yet implemented")
    }

    override fun testResourcePaths(): List<Path> {
        TODO("Not yet implemented")
    }

    override fun compile() {
        TODO("Not yet implemented")
    }

    override fun deploy() {
        TODO("Not yet implemented")
    }

    override fun executePath(): Path {
        TODO("Not yet implemented")
    }

}