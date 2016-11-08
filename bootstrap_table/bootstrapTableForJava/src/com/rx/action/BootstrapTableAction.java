package com.rx.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by iwwenbo on 2016/8/29.
 * 功能：表格
 */
public class BootstrapTableAction extends ActionSupport {

    private String  jsonData;

    /**
     * 异步加载表格数据的方法
     * @return  表格数据json
     */
    public String getTableData() {
        jsonData="data";
        System.out.println("获取表格数据中。。。。");
        return "success";
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
