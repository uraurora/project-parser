package com.github.uraurora.projectparser.core.aggregate

import com.github.uraurora.projectparser.core.utils.logger
import java.nio.file.Path

/**
 * @program : project-parser
 * @author : sei
 * @date : 2022-07-06 17:15
 * @description : abstract project class
 */
abstract class AbstractProject(val projectPath: Path) {
    companion object {
        val logger = logger()
    }
}