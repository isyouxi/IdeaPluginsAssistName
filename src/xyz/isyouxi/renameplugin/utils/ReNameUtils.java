package xyz.isyouxi.renameplugin.utils;

import org.jetbrains.annotations.NotNull;
import xyz.isyouxi.renameplugin.model.Translate;
import xyz.isyouxi.renameplugin.model.WebBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by is_yo on 2017/1/20.
 */
public class ReNameUtils {


    @NotNull
    public static List<String> generateReNames(Translate result) {
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


        //规则:
        //变量 常量 Java
        //lower Camel Case 小驼峰
        //upper Camel Case\Pascal 大驼峰


        return mList;
    }
}
