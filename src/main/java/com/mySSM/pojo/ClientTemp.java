package com.mySSM.pojo;

public class ClientTemp {

    /**
     * 表ID
     */
    private int id;
    /**
     *客户ID
     */
    private int CId;
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
    private String VIP_Type;
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
    /**
     * 改变的时间
     */
    private String time;

    private ClientTemp() {
    }

    public ClientTemp(int id, int CId, String name, String sex, String card, String phone, String VIP_Type, String email, String registerTime, int integral, String time) {
        this.id = id;
        this.CId = CId;
        Name = name;
        Sex = sex;
        Card = card;
        Phone = phone;
        this.VIP_Type = VIP_Type;
        Email = email;
        RegisterTime = registerTime;
        this.integral = integral;
        this.time = time;
    }

    public Client getClient(){
        return new Client(CId,Name,Sex,Card,Phone,VIP_Type,Email,RegisterTime,integral);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCId() {
        return CId;
    }

    public void setCId(int CId) {
        this.CId = CId;
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

    public String getVIP_Type() {
        return VIP_Type;
    }

    public void setVIP_Type(String VIP_Type) {
        this.VIP_Type = VIP_Type;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ClientTemp{" +
                "id=" + id +
                ", CId=" + CId +
                ", Name='" + Name + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Card='" + Card + '\'' +
                ", Phone='" + Phone + '\'' +
                ", VIP_Type='" + VIP_Type + '\'' +
                ", Email='" + Email + '\'' +
                ", RegisterTime='" + RegisterTime + '\'' +
                ", integral=" + integral +
                ", time='" + time + '\'' +
                '}';
    }
}
