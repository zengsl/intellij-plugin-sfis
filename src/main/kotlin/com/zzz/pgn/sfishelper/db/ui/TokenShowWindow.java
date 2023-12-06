package com.zzz.pgn.sfishelper.db.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * SwingUI designer 是Java版本的，Kotlin调用的话会出现找不到类的异常
 *
 * @author zengsl
 */
@Deprecated
public class TokenShowWindow {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel contentPanel;
    private JButton closeBtn;
    private JTextField tokenText;
    private JButton copyBtn;

    public TokenShowWindow() {
        copyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
