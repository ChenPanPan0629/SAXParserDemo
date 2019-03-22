package com.example.panda.saxparserdemo;

import java.util.List;

/**
 * Created by panpan on 2019/03/20.
 */

public class OutListBean {
    private String type;
    private List<InnerListBean> listBeans;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<InnerListBean> getListBeans() {
        return listBeans;
    }

    public void setListBeans(List<InnerListBean> listBeans) {
        this.listBeans = listBeans;
    }
}
