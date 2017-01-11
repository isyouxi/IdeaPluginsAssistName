package model;

import java.util.List;

/**
 * Created by is_yo on 2017/1/9.
 */
public class QueryResult {


    /**
     * translation : ["How are you"]
     * basic : {"phonetic":"nǐ hǎo","explains":["hello；hi"]}
     * query : 你好
     * errorCode : 0
     * web : [{"value":["Hello","How do you do","hi"],"key":"你好"},{"value":["How are you","How Do You Do","Harvey, how are you Harvey"],"key":"你好吗"},{"value":["Teacher Kim Bong-du","My Teacher Mr Kim","Seonsaeng Kim Bong-du"],"key":"老师你好"}]
     */

    private BasicBean basic;
    private String query;


    /**
     *  errorCode：
     *  0 - 正常
     *  20 - 要翻译的文本过长
     *  30 - 无法进行有效的翻译
     *  40 - 不支持的语言类型
     *  50 - 无效的key
     *  60 - 无词典结果，仅在获取词典结果生效
     */
    private int errorCode;
    private List<String> translation;
    private List<WebBean> web;

    public BasicBean getBasic() {
        return basic;
    }

    public void setBasic(BasicBean basic) {
        this.basic = basic;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public List<String> getTranslation() {
        return translation;
    }

    public void setTranslation(List<String> translation) {
        this.translation = translation;
    }

    public List<WebBean> getWeb() {
        return web;
    }

    public void setWeb(List<WebBean> web) {
        this.web = web;
    }

    public static class BasicBean {
        /**
         * phonetic : nǐ hǎo
         * explains : ["hello；hi"]
         */

        private String phonetic;
        private List<String> explains;

        public String getPhonetic() {
            return phonetic;
        }

        public void setPhonetic(String phonetic) {
            this.phonetic = phonetic;
        }

        public List<String> getExplains() {
            return explains;
        }

        public void setExplains(List<String> explains) {
            this.explains = explains;
        }
    }

    public static class WebBean {
        /**
         * value : ["Hello","How do you do","hi"]
         * key : 你好
         */

        private String key;
        private List<String> value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }
    }
}
