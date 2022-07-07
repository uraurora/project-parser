package com.github.uraurora.projectparser.core

import org.eclipse.aether.version.Version
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * @program : project-parser
 * @author : sei
 * @date : 2022-07-07 11:37
 * @description : module artifact version
 */
interface IVersion : Version{

    fun version(): String

    fun isSnapshot(): Boolean {
        return version().endsWith(SNAPSHOT) || SNAPSHOT_TIMESTAMP.matcher(version()).matches()
    }

    fun baseVersion(): String? {
        val version = version()
        return if (version.startsWith("[") || version.startsWith("(")) {
            version
        } else {
            val m: Matcher = SNAPSHOT_TIMESTAMP.matcher(version)
            if (m.matches()) {
                if (m.group(1) != null) {
                    m.group(1) + SNAPSHOT
                } else {
                    SNAPSHOT
                }
            } else {
                version
            }
        }
    }

    companion object {

        const val SNAPSHOT = "SNAPSHOT"

        val SNAPSHOT_TIMESTAMP: Pattern = Pattern.compile("^(.*-)?([0-9]{8}\\.[0-9]{6}-[0-9]+)$")

        const val SNAPSHOT_POM_REGEX = "^(.*-)?([0-9]{8}\\.[0-9]{6}-[0-9]+)(.pom)+$"
    }

}