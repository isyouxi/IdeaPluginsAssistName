package xyz.isyouxi.renameplugin.action;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupEx;
import com.intellij.codeInsight.lookup.LookupManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import xyz.isyouxi.renameplugin.ui.ReNameDialog;

import java.util.List;

/**
 * Created by is_yo on 2017/1/11.
 */
public class ReNameAction extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        Editor editor = anActionEvent.getData(PlatformDataKeys.EDITOR);
        if (editor == null)
            return;
        SelectionModel selectionModel = editor.getSelectionModel();
        CaretModel caretModel = editor.getCaretModel(); //光标
        String selectedText = selectionModel.getSelectedText();



        System.out.println("new ReNameDialog");

        ReNameDialog reNameDialog = new ReNameDialog();





//        reNameDialog.show();


//        List<LookupElement> replaceLookup = new ArrayList<LookupElement>();
//        replaceLookup.add(new LookupElement() {
//            @NotNull
//            @Override
//            public String getLookupString() {
//                return "text1";
//            }
//        });
//
//
//        replaceLookup.add(new LookupElement() {
//            @NotNull
//            @Override
//            public String getLookupString() {
//                return "text2";
//            }
//        });
//
//        replaceLookup.add(new LookupElement() {
//            @NotNull
//            @Override
//            public String getLookupString() {
//                return "text3";
//            }
//        });
//        doShowDia(editor, replaceLookup);


    }

    private void doShowDia(Editor editor, List<LookupElement> replaceLookup) {
        LookupElement[] items = replaceLookup.toArray(new LookupElement[replaceLookup.size()]);
        final LookupEx lookup = LookupManager.getInstance(editor.getProject()).showLookup(editor, items);
    }
}
