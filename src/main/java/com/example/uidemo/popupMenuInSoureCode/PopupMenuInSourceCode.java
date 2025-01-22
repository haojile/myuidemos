package com.example.uidemo.popupMenuInSoureCode;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.components.JBTextArea;

import javax.swing.*;
import java.awt.*;

public class PopupMenuInSourceCode extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        Project project = e.getProject();
        DataContext dataContext = e.getDataContext();

        // Object obj = e.getDataContext().getData("EDITORS_WITH_OFFSETS_DATA_KEY");
        Object obj = e.getDataContext().getData("EDITORS_WITH_OFFSETS_DATA_KEY");

        // VirtualFile ProjectFileDirectory = e.getDataContext().getData("context.ProjectFileDirectory");
        VirtualFile ProjectFileDirectory = e.getDataContext().getData(PlatformDataKeys.PROJECT_FILE_DIRECTORY);

        openPopupWindow();
    }

    void openPopupWindow(){
        JDialog dialog = new JDialog();
        dialog.setTitle("Insert code demo");
        dialog.setSize(300, 150);
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textarea = new JBTextArea();
        textarea.setText("void test(){\n" +
                "    // some code, for example:\n" +
                "    System.out.println();\n" +
                "}");
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(new JLabel(" "), BorderLayout.CENTER);
        bottomPanel.add(new JButton("Insert"), BorderLayout.EAST);
        panel.add(textarea,BorderLayout.CENTER);
        panel.add(bottomPanel,BorderLayout.SOUTH);
        dialog.getContentPane().add(panel);

        dialog.setLocationRelativeTo(null);

        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true); // 显示对话框
        System.out.println("clicked");
    }
}
