package com.sqlpy.readwritesplit.demo.entitys;

public class Person {
    private Integer id;
    private String name;
    private Integer age;

    public Person(String name,Integer age) {
        this.name = name;
        this.age = age;
    }

    // 留一下空的构造器让框架有机会 new 出来，并用 set 来初始化。
    public Person() {
        this.id = 0;
        this.name = "";
        this.age = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
