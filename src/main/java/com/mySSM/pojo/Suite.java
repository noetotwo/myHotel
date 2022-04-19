package com.mySSM.pojo;

public class Suite {
    /**
     * 房间ID
     */
    private int id;
    /**
     * 房间门牌号
     */
    private int roomNum;
    /**
     * 房间类型
     */
    private String SType;
    /**
     * 房间价格
     */
    private int Price;
    /**
     * 房间状态
     */
    private String State;
    /**
     * 房间图片
     */
    private String Img;
    /**
     * 房间介绍
     */
    private String Introduce;

    /**
     * 没有无参构造器会报
     * org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.reflection.ReflectionException: Error instantiating class com.mySSM.pojo.Suite with invalid types () or values (). Cause: java.lang.NoSuchMethodException: com.mySSM.pojo.Suite.<init>()
     */
    public Suite() {
    }

    public Suite(int roomNum, String SType, int price, String state, String img, String introduce) {
        this.roomNum = roomNum;
        this.SType = SType;
        Price = price;
        State = state;
        Img = img;
        Introduce = introduce;
    }

    public Suite(int id, int roomNum, String SType, int price, String state, String img, String introduce) {
        this.id = id;
        this.roomNum = roomNum;
        this.SType = SType;
        Price = price;
        State = state;
        Img = img;
        Introduce = introduce;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public String getSType() {
        return SType;
    }

    public void setSType(String SType) {
        this.SType = SType;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public String getIntroduce() {
        return Introduce;
    }

    public void setIntroduce(String introduce) {
        Introduce = introduce;
    }

    @Override
    public String toString() {
        return "Suite{" +
                "Id=" + id +
                ", roomNum=" + roomNum +
                ", SType='" + SType + '\'' +
                ", Price=" + Price +
                ", State='" + State + '\'' +
                ", Img='" + Img + '\'' +
                ", Introduce='" + Introduce + '\'' +
                '}';
    }
}

