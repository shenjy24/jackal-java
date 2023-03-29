package com.jonas.proxy;

import com.jonas.proxy.cglib_proxy.MovieMethodInterceptor;
import com.jonas.proxy.dynamic_proxy.MovieInvocationHandler;
import com.jonas.proxy.static_proxy.MovieStaticProxy;
import com.jonas.proxy.target.*;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyMain {

    public static void testStaticProxy() {
        Movie movie = new CaptainAmericaMovie();
        Movie proxy = new MovieStaticProxy(movie);
        proxy.play();
    }

    public static void testDynamicProxy() {
        // VIP 影厅《钢铁侠》
        IronManVIPMovie ironManVIPMovie = new IronManVIPMovie();
        InvocationHandler invocationHandler = new MovieInvocationHandler(ironManVIPMovie);
        VIPMovie proxy = (VIPMovie) Proxy.newProxyInstance(IronManVIPMovie.class.getClassLoader(),
                IronManVIPMovie.class.getInterfaces(), invocationHandler);
        proxy.vipPlay();

        // 普通影厅《美国队长》
        CaptainAmericaMovie captainAmericaMovie = new CaptainAmericaMovie();
        InvocationHandler invocationHandler1 = new MovieInvocationHandler(captainAmericaMovie);
        Movie dynamicProxy1 = (Movie) Proxy.newProxyInstance(CaptainAmericaMovie.class.getClassLoader(),
                CaptainAmericaMovie.class.getInterfaces(), invocationHandler1);
        dynamicProxy1.play();
    }

    public static void testCglibProxy() {
        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        //设置目标类的字节码文件
        enhancer.setSuperclass(CaptainAmerica2Movie.class);
        //设置回调函数
        enhancer.setCallback(new MovieMethodInterceptor());
        //这里的creat方法就是正式创建代理类
        CaptainAmerica2Movie captainAmerica2Movie = (CaptainAmerica2Movie)enhancer.create();
        //调用代理类的play方法
        captainAmerica2Movie.play();
        System.out.println("cglib动态代理《美国队长2》："+captainAmerica2Movie.getClass());
    }

    public static void main(String[] args) {
        testCglibProxy();
    }
}
