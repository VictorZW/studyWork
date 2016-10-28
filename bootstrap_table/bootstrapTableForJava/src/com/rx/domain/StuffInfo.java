package com.rx.domain;

/**
 * Created by iwwenbo on 2016/9/1.
 * 员工信息实体类
 */
public class StuffInfo {
    //员工id
    private int id;
    //员工姓名
    private String name ;
    //员工年龄
    private int age;
    //员工部门
    private String department;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
