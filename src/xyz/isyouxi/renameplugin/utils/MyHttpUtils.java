package xyz.isyouxi.renameplugin.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by is_yo on 2017/1/19.
 */
public class MyHttpUtils {


    private static class SingletonHolder {
        private static final MyHttpUtils INSTANCE = new MyHttpUtils();
    }

    private MyHttpUtils() {


    }

    public static final MyHttpUtils getInstance() {
        return SingletonHolder.INSTANCE;
    }


    public String toGet(String utl, TreeMap<String, String> params) throws IOException {
        StringBuffer queryUrl = new StringBuffer();
        queryUrl.append(utl);

        if (params != null) {
            StringBuffer sb = new StringBuffer();
            Set<Map.Entry<String, String>> entries = params.entrySet();
            if (!entries.isEmpty()) {
                sb.append("?");
            }
            for (Map.Entry<String, String> entry :
                    entries) {
                sb.append(entry.getKey() + "=" + entry.getValue() + "&");
            }
            if (!entries.isEmpty()) {
                sb.delete(sb.length() - 1, sb.length());
            }
            queryUrl.append(sb);
        }

        String result = "muyou";
        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
            HttpGet httpget = new HttpGet(queryUrl.toString());

            HttpResponse response = httpclient.execute(httpget);


            byte[] filebt = readStream(response.getEntity().getContent());
            System.out.println(filebt.length);


            result = new String(filebt, StandardCharsets.UTF_8);
            System.out.println("Login form get: " + response.getStatusLine());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }


    public static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();
        return outSteam.toByteArray();
    }
}
