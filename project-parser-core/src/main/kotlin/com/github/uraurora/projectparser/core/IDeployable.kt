package com.github.uraurora.projectparser.core

/**
 * @program : project-parser
 * @author : sei
 * @date : 2022-07-06 17:05
 * @description : means module or project can be deployed
 */
interface IDeployable {

    fun deploy(): Unit

}