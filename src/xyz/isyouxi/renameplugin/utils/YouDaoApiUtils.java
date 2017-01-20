package xyz.isyouxi.renameplugin.utils;

import com.google.gson.Gson;
import xyz.isyouxi.renameplugin.model.Translate;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.TreeMap;

/**
 * Created by is_yo on 2017/1/19.
 */
public class YouDaoApiUtils {


    public static void toQuery(String text, QueryCallBack<Translate> acb) {


        MyUrlObj mUtl = generateQueryUrl(text);
        String result = null;
        try {
            result = MyHttpUtils.getInstance().toGet(mUtl.url, mUtl.pamar);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("toGet result:" + result);

        Gson gson = new Gson();

        Translate translateJson = gson.fromJson(result, Translate.class);

        if (translateJson.getErrorCode() == 0) {
            acb.success(translateJson);
        } else {
            acb.fail(translateJson.getErrorCode() + "", translateJson.getQuery(), translateJson);
        }
    }

    private static MyUrlObj generateQueryUrl(String text) {
        String BaseUrl = "http://fanyi.youdao.com/openapi.do";
        TreeMap<String, String> tm = new TreeMap<>();
        tm.put("keyfrom", "IPAssistName");
        tm.put("key", "2116160229");
        tm.put("type", "data");
        tm.put("doctype", "json");
        tm.put("version", "1.1");
        tm.put("q", text);


        return new MyUrlObj(BaseUrl, tm);


    }


    static class MyUrlObj {
        String url;
        TreeMap<String, String> pamar;

        public MyUrlObj(String url, TreeMap<String, String> pamar) {
            this.url = url;
            this.pamar = pamar;
        }
    }


}






