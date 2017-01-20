package xyz.isyouxi.renameplugin.ui;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.List;

public class ReNamePop extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JList list1;
    private Editor editor;
    private List<String> datas;

    public ReNamePop(Editor editor, Project project) {

        this.editor = editor;
        setContentPane(contentPane);
        setModal(true);

        setSize(400, 400);

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {


                if (e.getValueIsAdjusting()) return;

                String selectedItem = (String) list1.getSelectedValue();


                SelectionModel selectionModel = editor.getSelectionModel();
                CaretModel caretModel = editor.getCaretModel();
                Document document = editor.getDocument();


                int startOffset = selectionModel.getSelectionStart();
                int endOffset = selectionModel.getSelectionEnd();


                //对文档进行操作部分代码，需要放入Runnable接口中实现，由IDEA在内部将其通过一个新线程执行
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        //selectionModel.removeSelection();
                        document.deleteString(startOffset, endOffset);
                        document.insertString(startOffset, selectedItem);
                        selectionModel.setSelection(startOffset, startOffset + selectedItem.length());
                        caretModel.moveToOffset(startOffset + selectedItem.length());
                    }
                };
                //加入任务，由IDEA调度执行这个任务
                WriteCommandAction.runWriteCommandAction(project, runnable);

            }
        });

    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
//        ReNamePop dialog = new ReNamePop(editor);
//        dialog.pack();
//        dialog.setVisible(true);
//        System.exit(0);
    }

    public void setMyDatas(List<String> mList) {
        this.datas = mList;
        DefaultListModel listModel = new DefaultListModel();

        for (String ss :
                mList) {
            listModel.addElement(ss);
        }
        list1.setListData(listModel.toArray());
    }
}
