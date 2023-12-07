package com.zz.pgn.sfishelper

import java.util.regex.Pattern
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * https://kotlinlang.org/docs/jvm-test-using-junit.html
 *
 *
 * @author zengsl
 * @date 2023/12/7 13:11
 */
internal class UtilTest {
    @Test
    fun testRegx() {
        val regex = "(\")?(SSO|Sso)Token(\")?:(\\s)?\"(\\w*)\""
        val compile = Pattern.compile(regex)

        val testStr = """
            {Mode:"0", IsGlobalSetting:"0", TunnelToken:"", IPv4:"10.90.100.28", AssetIPv4:"100.112.4.185", Port:"63306", AssetPort:"3306", Protocol:"mysql", ClientName:"", ClientPath:"", Username:"ganzkjj", SsoToken:"6ac1295866741255", DatabaseName:"", AssetUser:"ganzkjj", Batch:"", Hosts:[]common.Host(nil)}
            """.trimIndent()
        val testStr2 = """{"NODE_COMMON": {"Mode": "0", "ClientName": "", "ClientPath": "", "IsGlobalSetting": "0", "Username": "ganzkjj", "IPv4": "10.90.100.28", "Port": "63306", "Protocol": "MySQL", "AssetIPv4": "100.112.4.185", "AssetPort": "3306", "SSOToken": "6ac1295866741255", "AssetUser": "ganzkjj", "AssetName": "gzskjywglxt-\u6570\u636e\u5e93\u670d\u52a1\u5668"}}"""

        val matcher = compile.matcher(testStr)
        assertEquals(true, matcher.find())
        println("Result1: " + matcher.group())
        val matcher2 = compile.matcher(testStr2)
        assertEquals(true, matcher2.find())
        println("Result2: " + matcher2.group())

    }
}