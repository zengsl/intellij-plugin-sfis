package com.zzz.pgn.sfishelper.db.action

import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.zzz.pgn.sfishelper.db.SSOToken
import com.zzz.pgn.sfishelper.db.ui.TokenShowDialog
import org.apache.commons.io.input.ReversedLinesFileReader
import java.nio.charset.StandardCharsets
import java.util.regex.Pattern

class GetDbToken : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {

        val ssoToken = getSSOToken()
        if (ssoToken == null) {
            NotificationGroupManager.getInstance()
                    .getNotificationGroup("GetToken")
                    .createNotification("SsoToken未检索到, 请重新通过堡垒机获取", NotificationType.WARNING)
                    .notify(e.project)
            return
        }
        val (token, text) = ssoToken
        TokenShowDialog(token).show()
//        Messages.showInfoMessage("SSOToken: $token", "Caret Parameters Inside The Editor")
    }

    private fun getSSOToken(): SSOToken? {

        val regex = "(\")?(SSO|Sso)Token(\")?:(\\s)?\"(\\w*)\""
        val compile = Pattern.compile(regex)
        val userHome = System.getProperty("user.home")
        val filePath = "$userHome/Library/USM/sso/log/2023.12.log"
        var ssoToken = ""
        var expression = ""
        ReversedLinesFileReader.builder().setPath(filePath).setCharset(StandardCharsets.UTF_8).get().use { reader ->
            var i = 0
            val size = 20
            var readLine = ""
            while (i < size && reader.readLine().also { readLine = it } != null) {
                i++
                val matcher = compile.matcher(readLine)
                println(readLine)
                if (matcher.find()) {
                    expression = matcher.group(0)
                    ssoToken = matcher.group(5)
                    return SSOToken(ssoToken, expression)
                }
            }
        }

        return null
    }

}