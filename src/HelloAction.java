import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
/*
 * Created by is_youxi on 2017/1/6.
 */
public class HelloAction extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        Project project = anActionEvent.getData(PlatformDataKeys.PROJECT);
        String userName = askForName(project);
        sayHello(project, userName);
    }

    private String askForName(Project project) {
        return Messages.showInputDialog(project,"What is you name?","Input Your Name",Messages.getQuestionIcon());
    }

    private void sayHello(Project project, String userName) {
        Messages.showMessageDialog(project,String.format("Hello,%s!\n Welcome to This.",userName),"Information",Messages.getInformationIcon());
    }

}
