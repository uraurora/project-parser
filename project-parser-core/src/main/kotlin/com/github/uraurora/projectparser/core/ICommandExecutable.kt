package com.github.uraurora.projectparser.core

import java.nio.file.Path

/**
 * @program : project-parser
 * @author : sei
 * @date : 2022-07-06 17:49
 * @description : command executable means can use cli tool to execute command
 */
interface ICommandExecutable {

    fun executePath(): Path

}