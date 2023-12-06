package com.zzz.pgn.sfishelper.db.ui

import com.intellij.openapi.ui.DialogWrapper
import java.awt.Dimension
import java.awt.FlowLayout
import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.StringSelection
import java.awt.datatransfer.Transferable
import javax.swing.*


class TokenShowDialog() : DialogWrapper(true) {
    private var token: String? = null

    constructor(token: String) : this() {
        title = "Usm SSO Token"
        this.token = token
        this.setSize(300, 200)
        init()
    }

    override fun createCenterPanel(): JComponent {
        val dialogPanel = JPanel(FlowLayout())
        val label = JLabel("Token:")
        label.preferredSize = Dimension(50, 100)
        dialogPanel.add(label)

        val textF = JTextField()
//        textF.setSize(200,100)
        textF.isEditable = false
        textF.text = token
        dialogPanel.add(textF)

        val btn = JButton("copy")
        btn.preferredSize = Dimension(40, 30)
        btn.addActionListener {
            val clip: Clipboard = Toolkit.getDefaultToolkit().systemClipboard
            val tText: Transferable = StringSelection(token)
            clip.setContents(tText, null)
//            println("Token copied:$token")
        }
        dialogPanel.add(btn)
        return dialogPanel
    }

    override fun createSouthPanel(): JComponent {
        val dialogPanel = JPanel(FlowLayout())
        val btn = JButton("Close")
        btn.addActionListener {
            this.close(0)
        }
        dialogPanel.add(btn)
        return dialogPanel
    }
}
