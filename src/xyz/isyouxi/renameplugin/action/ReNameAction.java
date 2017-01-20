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
import com.intellij.openapi.project.Project;
import xyz.isyouxi.renameplugin.model.Translate;
import xyz.isyouxi.renameplugin.model.WebBean;
import xyz.isyouxi.renameplugin.ui.ReNamePop;
import xyz.isyouxi.renameplugin.utils.QueryCallBack;
import xyz.isyouxi.renameplugin.utils.YouDaoApiUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by is_yo on 2017/1/11.
 */
public class ReNameAction extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        Editor editor = anActionEvent.getData(PlatformDataKeys.EDITOR);
        Project project = anActionEvent.getData(PlatformDataKeys.PROJECT);
        if (editor == null)
            return;
        SelectionModel selectionModel = editor.getSelectionModel();
        CaretModel caretModel = editor.getCaretModel(); //光标
        String selectedText = selectionModel.getSelectedText();


        QueryCallBack mCallBack = new QueryCallBack<Translate>() {
            @Override
            public void success(Translate result) {
                System.out.println("  获取网络翻译结果成功  ");
                System.out.println("-------- Translation --------");

                List<String> mList = new ArrayList<>();

                mList.add("-------- Translation --------");

                for (String translation :
                        result.getTranslation()) {

                    mList.add(translation);
                    System.out.println(translation);
                }
                System.out.println("-------- webBean --------");


                mList.add("-------- webBean --------");

                for (WebBean webBean :
                        result.getWeb()) {
                    System.out.println(webBean.getKey() + "::");
                    for (String s :
                            webBean.getValue()) {
                        System.out.println(s);
                        mList.add(s);
                    }
                }

                System.out.println("-------- end --------");

                ReNamePop reNameDialog = new ReNamePop(editor,project);
                reNameDialog.setMyDatas(mList);
                reNameDialog.setVisible(true);

            }

            @Override
            public void fail(String errorcode, String str, Translate result) {

            }
        };

        YouDaoApiUtils.toQuery(selectedText, mCallBack);


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
