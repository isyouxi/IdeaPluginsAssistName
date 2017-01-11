package pic;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ServiceManager;
import model.QueryResult;
import org.jetbrains.annotations.Nullable;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by is_yo on 2017/1/9.
 */
public class Translator {

    public void query(String query, Callback callback) {

        ApplicationManager.getApplication().executeOnPooledThread(new QueryRequest(query, callback));
    }


    public static Translator getInstance() {
        return ServiceManager.getService(Translator.class);
    }

    /**
     * 翻译回调接口
     */
    public interface Callback {
        /**
         * 翻译结束后的回调方法
         *
         * @param query  查询字符串
         * @param result 翻译结果
         */
        void onQuery(@Nullable String query, @Nullable QueryResult result);
    }


    private final class QueryRequest implements Runnable {
        private final String mQuery;
        private final Callback mCallback;

        QueryRequest(String query, Callback callback) {
            mQuery = query;
            mCallback = callback;
        }

        @Override
        public void run() {
            final String query = mQuery;
            final String url = getQueryUrl(query);
        }
    }

    //http://fanyi.youdao.com/openapi.do?keyfrom=IPAssistName&key=2116160229&type=data&doctype=json&version=1.1&q=%E4%BD%A0%E5%A5%BD
    static final String BASIC_URL = "http://fanyi.youdao.com/openapi.do";
    static final String apiKeyName = "IPAssistName";
    static final String apiKeyValue = "2116160229";

    static String getQueryUrl(String query) {
        String encodedQuery = "";
        try {
            encodedQuery = URLEncoder.encode(query, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /*Settings settings = Settings.getInstance();

        String apiKeyName;
        String apiKeyValue;
        if (settings.isUseDefaultKey()) {
            apiKeyName = DEFAULT_API_KEY_NAME;
            apiKeyValue = DEFAULT_API_KEY_VALUE;
        } else {
            apiKeyName = settings.getApiKeyName();
            apiKeyValue = settings.getApiKeyValue();

            if (Utils.isEmptyOrBlankString(apiKeyName) || Utils.isEmptyOrBlankString(apiKeyValue)) {
                apiKeyName = DEFAULT_API_KEY_NAME;
                apiKeyValue = DEFAULT_API_KEY_VALUE;
            }
        }*/

        return BASIC_URL + "?type=data&doctype=json&version=1.1&keyfrom=" + apiKeyName + "&key=" +
                apiKeyValue + "&q=" + encodedQuery;
    }
}
