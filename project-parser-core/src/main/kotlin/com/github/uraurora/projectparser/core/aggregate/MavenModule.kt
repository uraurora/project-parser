package com.github.uraurora.projectparser.core.aggregate

import org.apache.maven.artifact.Artifact
import org.apache.maven.model.Model
import java.io.File
import java.nio.file.Path

/**
 * @program : project-parser
 * @author : sei
 * @date : 2022-07-07 10:54
 * @description : maven module
 */
class MavenModule(val name: String, val path: Path) {

    lateinit var artifact: Artifact

    lateinit var model: Model

    lateinit var pom : File

}