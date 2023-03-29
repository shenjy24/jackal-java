package com.jonas.proxy.target;

public class IronManVIPMovie implements VIPMovie {
    @Override
    public void vipPlay() {
        System.out.println("VI影厅正在播放的电影是《钢铁侠》");
    }
}
