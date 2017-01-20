package xyz.isyouxi.renameplugin.utils;

/**
 * Created by is_yo on 2017/1/19.
 */
public  interface QueryCallBack<T> {

    void success(T result);

    void fail(String errorcode,String str,T result);
}
