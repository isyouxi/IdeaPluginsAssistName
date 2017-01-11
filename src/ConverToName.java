import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import model.QueryResult;
import org.jetbrains.annotations.Nullable;
import pic.Translator;

/**
 * Created by is_yo on 2017/1/6.
 */
public class ConverToName extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        Editor editor = anActionEvent.getData(PlatformDataKeys.EDITOR);
        Project project = anActionEvent.getData(PlatformDataKeys.PROJECT);

        SelectionModel selectionModel = editor.getSelectionModel();
        CaretModel caretModel = editor.getCaretModel();
        Document document = editor.getDocument();


        String selectedText = selectionModel.getSelectedText();
        int startOffset = selectionModel.getSelectionStart();
        int endOffset = selectionModel.getSelectionEnd();
//        document.deleteString(startOffset,endOffset);


        //对文档进行操作部分代码，需要放入Runnable接口中实现，由IDEA在内部将其通过一个新线程执行
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //selectionModel.removeSelection();
                document.deleteString(startOffset, endOffset);
                String newStr = genNewName(selectedText);
                document.insertString(startOffset, newStr);
                selectionModel.setSelection(startOffset, startOffset + newStr.length());
                caretModel.moveToOffset(startOffset + newStr.length());
            }

        };

        //加入任务，由IDEA调度执行这个任务
        WriteCommandAction.runWriteCommandAction(project, runnable);

        Translator.getInstance().query("haha", new Translator.Callback() {
            @Override
            public void onQuery(@Nullable String query, @Nullable QueryResult result) {

            }
        });


    }

    private String genNewName(String selectedText) {


        return "Hello";
    }

    @Override
    public void update(AnActionEvent e) {
        Editor editor = e.getData(PlatformDataKeys.EDITOR);
        SelectionModel selectionModel = editor.getSelectionModel();

        CaretModel caretModel = editor.getCaretModel();
        int caretCount = caretModel.getCaretCount();


        e.getPresentation().setEnabled(editor != null && selectionModel.hasSelection() && caretCount == 1);
        //  如果没有字符串被选中，那么无需显示该Action
        //  e.getPresentation().setVisible();


    }

}
