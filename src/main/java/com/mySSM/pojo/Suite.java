package com.mySSM.pojo;

public class Suite {
    /**
     * 房间ID
     */
    private Integer Id;
    /**
     * 房间门牌号
     */
    private int room_num;
    /**
     * 房间类型
     */
    private String S_Type;
    /**
     * 房间价格
     */
    private String Price;
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


    public Suite() {
    }

    public Suite(Integer id, int room_num, String s_Type, String price, String state, String img, String introduce) {
        Id = id;
        this.room_num = room_num;
        S_Type = s_Type;
        Price = price;
        State = state;
        Img = img;
        Introduce = introduce;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public int getRoom_num() {
        return room_num;
    }

    public void setRoom_num(int room_num) {
        this.room_num = room_num;
    }

    public String getS_Type() {
        return S_Type;
    }

    public void setS_Type(String s_Type) {
        S_Type = s_Type;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
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
                "Id=" + Id +
                ", room_num=" + room_num +
                ", S_Type='" + S_Type + '\'' +
                ", Price='" + Price + '\'' +
                ", State='" + State + '\'' +
                ", Img='" + Img + '\'' +
                ", Introduce='" + Introduce + '\'' +
                '}';
    }
}
