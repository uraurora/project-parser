package com.github.uraurora.projectparser.core.aggregate

import com.github.uraurora.projectparser.core.utils.fromJson
import com.github.uraurora.projectparser.core.utils.println
import com.github.uraurora.shouldBe
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.eclipse.aether.artifact.DefaultArtifact
import org.junit.Test
import java.nio.file.Files.lines
import java.nio.file.Paths

class MavenModuleTest {

    @Test
    fun test() {
        DefaultArtifact("com.sankuai:ss:1.2.4").version shouldBe "1.2.4"
    }

    @Test
    fun gsonTest() {
        var g = Gson()
        val p1 = Paths.get("/Users/gaoxiaodong/Downloads/wedding-mobileapi-web有流量接口.json")
        val p2 = Paths.get("/Users/gaoxiaodong/Downloads/wedding-mobileapi-web.json")
        val p3 = Paths.get("/Users/gaoxiaodong/Downloads/wedding-mobileapi-web全量.json")

        val l1 = g.fromJson<List<Api>>(lines(p1).findFirst().orElse(""), object : TypeToken<List<Api>>() {}.type)
        val filterRaw: List<ApiInfo> = lines(p2).findFirst().orElse("")
                .fromJson(object : TypeToken<List<ApiInfo>>() {}.javaClass)

        val allRaw: List<ApiInfo> = lines(p3).findFirst().orElse("")
                .fromJson(object : TypeToken<List<ApiInfo>>() {}.type)

        // 有流量接口
        val apis = l1.map { it.interface_name.subSequence(it.interface_name.lastIndexOf("/") + 1 until it.interface_name.length) }
        apis
                .distinct()
                .apply { size.println() }
                .forEach { it.println() }

        // 无流量
        allRaw
                .distinct()
                .filter { !apis.contains(it.json.api) }
                .map { Info(api = it.json.api, desc = it.json.desc, creator = it.json.owners) }
                .apply { println(size) }
                .forEach { it.println() }

//        filterRaw
//                .filter { apis.contains(it.json.api) }
//                .map { Info(api = it.json.api, desc = it.json.desc, creator = it.json.owners) }
//                .forEach { it.println() }

    }

    data class Api(val interface_name: String)

    data class ApiInfo(val json: Desc) {
        data class Desc(val api: String, val desc: String, val owners: List<String>)
        data class Item(val item: Int)
    }

    data class Info(val api: String, val desc: String, val creator: List<String>, val fbi: String="", val poi: String = ""){
        override fun toString(): String {
            return "|$api|$desc|${creator.joinToString { it }}|$fbi|$poi|"
        }
    }
}