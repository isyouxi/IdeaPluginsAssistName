import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

/**
 * Created by is_yo on 2017/1/6.
 */
public class HelloAction2 extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        Editor editor = anActionEvent.getData(PlatformDataKeys.EDITOR);
        if (editor == null)
            return;

        SelectionModel selectionModel = editor.getSelectionModel();
        String selectedText = selectionModel.getSelectedText();
//        CaretModel caretModel = editor.getCaretModel();

        sayHello(selectedText);
    }

    private void sayHello(String selectedText) {
        Messages.showMessageDialog(String.format("Hello,你选中的文本是: %s", selectedText), "Information", Messages.getInformationIcon());
    }
}
