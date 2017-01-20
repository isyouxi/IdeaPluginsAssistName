package xyz.isyouxi.renameplugin.model;

import java.util.List;

/**
 * Created by is_yo on 2017/1/20.
 */
public class BasicBean {
    /**
     * phonetic : hā ha
     * explains : ["ha","ha-ha","haw-haw"]
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
