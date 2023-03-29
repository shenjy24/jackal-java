package com.jonas.proxy.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MovieInvocationHandler implements InvocationHandler {

    private Object object;

    public MovieInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        playStart();
        Object invoke = method.invoke(object, args);
        playEnd();
        return invoke;
    }

    public void playStart() {
        System.out.println("电影开始前正在播放广告");
    }
    public void playEnd() {
        System.out.println("电影结束了，接续播放广告");
    }
}
