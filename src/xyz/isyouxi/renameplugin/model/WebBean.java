package xyz.isyouxi.renameplugin.model;

import java.util.List;

/**
 * Created by is_yo on 2017/1/20.
 */
public class WebBean {
    /**
     * value : ["OO","ha","Breez"]
     * key : 哈哈
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
