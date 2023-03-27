package com.jonas.proxy.static_proxy;

import com.jonas.proxy.target.Movie;

/**
 * 静态代理，类似于拦截器，在某个操作的前后进行处理
 */
public class MovieStaticProxy implements Movie {

    private Movie movie;

    public MovieStaticProxy(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void play() {
        playStart();
        movie.play();
        playEnd();
    }

    public void playStart() {
        System.out.println("电影开始前正在播放广告");
    }

    public void playEnd() {
        System.out.println("电影结束了，接续播放广告");
    }
}
