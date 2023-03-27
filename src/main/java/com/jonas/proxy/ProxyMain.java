package com.jonas.proxy;

import com.jonas.proxy.static_proxy.MovieStaticProxy;
import com.jonas.proxy.target.CaptainAmericaMovie;
import com.jonas.proxy.target.Movie;

public class ProxyMain {

    public static void testStaticProxy() {
        Movie movie = new CaptainAmericaMovie();
        Movie proxy = new MovieStaticProxy(movie);
        proxy.play();
    }

    public static void main(String[] args) {
        testStaticProxy();
    }
}
