package com.entity;

public class Types {

    private Integer typeId;
    private String typeName;

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
        this.typeId = typeId;
        this.typeName = typeName;
    }

    /**
     * 重写toString方法
     * @return
     * @Override
     */
    @Override
    public String toString() {
        return "Types{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }


    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
