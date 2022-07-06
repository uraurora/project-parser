package com.github.uraurora.projectparser.core

import java.nio.file.Path

/**
 * @program : project-parser
 * @author : sei
 * @date : 2022-07-05 21:27
 * @description : project interface, to describe a project entity
 */
interface IProject: IModule {

    fun rootModule(): IModule

    fun modules(): List<IModule>

}