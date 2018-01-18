package com.entity;

public class Types {

    private Integer id;
    private String name;

    /**
     * 无参构造
     */
    public Types() {
    }

    /**
     * 有参构造
     * @param typeId
     * @param typeName
     */
    public Types(Integer typeId, String typeName) {
        this.id = typeId;
        this.name = typeName;
    }

    /**
     * 重写toString方法
     * @return
     * @Override
     */

    public String toString() {
        return "Types{" +
                "typeId=" + id +
                ", typeName='" + name + '\'' +
                '}';
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
}
