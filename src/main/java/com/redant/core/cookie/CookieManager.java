package com.redant.core.cookie;

import com.redant.core.DataHolder;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.cookie.Cookie;

import java.util.Map;
import java.util.Set;

/**
 * Cookie管理器
 * @author gris.wang
 * @since 2017/11/6
 */
public class CookieManager {

    /**
     * 获取HttpRequest中的Cookies
     * @return
     */
    public static Set<Cookie> getCookies(){
        HttpRequest request = (HttpRequest)DataHolder.get(DataHolder.HolderType.REQUEST);
        return CookieHelper.getCookies(request);
    }

    /**
     * 设置Cookie
     * @param cookie
     */
    public static void setCookie(Cookie cookie){
        HttpResponse response = (HttpResponse)DataHolder.get(DataHolder.HolderType.RESPONSE);
        CookieHelper.setCookie(response,cookie);
    }

    /**
     * 设置所有的Cookie
     */
    public static void setCookies(){
        HttpRequest request = (HttpRequest)DataHolder.get(DataHolder.HolderType.REQUEST);
        HttpResponse response = (HttpResponse)DataHolder.get(DataHolder.HolderType.RESPONSE);
        CookieHelper.setCookies(request,response);
    }

    /**
     * 添加一个Cookie
     * @param name  cookie名字
     * @param value cookie值
     */
    public static void addCookie(String name,String value){
        HttpResponse response = (HttpResponse)DataHolder.get(DataHolder.HolderType.RESPONSE);
        CookieHelper.addCookie(response,name,value,null);
    }

    /**
     * 添加一个Cookie
     * @param name  cookie名字
     * @param value cookie值
     * @param domain cookie所在域
     */
    public static void addCookie(String name,String value,String domain){
        HttpResponse response = (HttpResponse)DataHolder.get(DataHolder.HolderType.RESPONSE);
        CookieHelper.addCookie(response,name,value,domain,0);
    }


    /**
     * 添加一个Cookie
     * @param name  cookie名字
     * @param value cookie值
     * @param maxAge cookie生命周期  以秒为单位
     */
    public static void addCookie(String name,String value,long maxAge){
        HttpResponse response = (HttpResponse)DataHolder.get(DataHolder.HolderType.RESPONSE);
        CookieHelper.addCookie(response,name,value,null,maxAge);
    }


    /**
     * 添加一个Cookie
     * @param name  cookie名字
     * @param value cookie值
     * @param domain cookie所在域
     * @param maxAge cookie生命周期  以秒为单位
     */
    public static void addCookie(String name,String value,String domain,long maxAge){
        HttpResponse response = (HttpResponse)DataHolder.get(DataHolder.HolderType.RESPONSE);
        CookieHelper.addCookie(response,name,value,domain,maxAge);
    }

    /**
     * 将cookie封装到Map里面
     * @return
     */
    public static Map<String,Cookie> getCookieMap(){
        HttpRequest request = (HttpRequest)DataHolder.get(DataHolder.HolderType.REQUEST);
        return CookieHelper.getCookieMap(request);
    }

    /**
     * 根据名字获取Cookie
     * @param name cookie名字
     * @return
     */
    public static Cookie getCookie(String name){
        HttpRequest request = (HttpRequest)DataHolder.get(DataHolder.HolderType.REQUEST);
        return CookieHelper.getCookie(request,name);
    }

    /**
     * 获取Cookie的值
     * @param name cookie名字
     * @return
     */
    public static String getCookieValue(String name){
        HttpRequest request = (HttpRequest)DataHolder.get(DataHolder.HolderType.REQUEST);
        return CookieHelper.getCookieValue(request,name);
    }

    /**
     * 删除一个Cookie
     * @param name
     * @return
     */
    public static boolean deleteCookie(String name) {
        HttpRequest request = (HttpRequest)DataHolder.get(DataHolder.HolderType.REQUEST);
        HttpResponse response = (HttpResponse)DataHolder.get(DataHolder.HolderType.RESPONSE);
        return CookieHelper.deleteCookie(request,response,name);
    }


}