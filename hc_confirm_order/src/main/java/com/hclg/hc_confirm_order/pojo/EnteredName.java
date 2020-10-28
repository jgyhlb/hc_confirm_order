package com.hclg.hc_confirm_order.pojo;

public class EnteredName {
    private Integer id;
    private String name;

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

    @Override
    public String toString() {
        return "EnteredName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
