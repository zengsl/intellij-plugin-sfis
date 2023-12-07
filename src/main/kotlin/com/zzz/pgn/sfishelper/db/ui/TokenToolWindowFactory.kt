package com.zzz.pgn.sfishelper.db.ui

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory

class TokenToolWindowFactory: ToolWindowFactory {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val toolWindowContent =  TokenShowWindow()
        val createContent = ContentFactory.getInstance().createContent(toolWindowContent.mainPanel, "", false)
        toolWindow.contentManager.addContent(createContent)
    }
}