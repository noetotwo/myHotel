package com.mySSM.pojo;

public class Client {
    /**
     *客户ID
     */
    private int Id;
    /**
     *客户名字
     */
    private String Name;
    /**
     *客户性别
     */
    private String Sex;
    /**
     *客户身份证
     */
    private String Card;
    /**
     * 客户手机号
     */
    private String Phone;
    /**
     * 会员级别
     */
    private String VIPType;
    /**
     * 电子邮箱
     */
    private String Email;
    /**
     *客户注册时间
     */
    private String RegisterTime;
    /**
     *客户积分
     */
    private int integral;

    public Client() {
    }

    public Client(String name, String sex, String card, String phone, String email) {
        Name = name;
        Sex = sex;
        Card = card;
        Phone = phone;
        Email = email;
    }

    public Client(String name, String sex, String card, String phone, String VIP_Type, String email, String register_Time) {
        Name = name;
        Sex = sex;
        Card = card;
        Phone = phone;
        this.VIPType = VIP_Type;
        Email = email;
        RegisterTime = register_Time;
    }

    public Client(int id, String name, String sex, String card, String phone, String VIP_Type, String email, String register_Time, int integral) {
        Id = id;
        Name = name;
        Sex = sex;
        Card = card;
        Phone = phone;
        this.VIPType = VIP_Type;
        Email = email;
        RegisterTime = register_Time;
        this.integral = integral;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getCard() {
        return Card;
    }

    public void setCard(String card) {
        Card = card;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getVIPType() {
        return VIPType;
    }

    public void setVIPType(String VIPType) {
        this.VIPType = VIPType;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getRegisterTime() {
        return RegisterTime;
    }

    public void setRegisterTime(String registerTime) {
        RegisterTime = registerTime;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    @Override
    public String toString() {
        return "Client{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Card='" + Card + '\'' +
                ", Phone='" + Phone + '\'' +
                ", VIP_Type='" + VIPType + '\'' +
                ", Email='" + Email + '\'' +
                ", Register_Time='" + RegisterTime + '\'' +
                ", integral=" + integral +
                '}';
    }
}

