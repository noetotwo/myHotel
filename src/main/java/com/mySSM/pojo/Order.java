package com.mySSM.pojo;

public class Order {
    /**
     *订单ID
     */
    private int Id;
    /**
     *客户ID
     */
    private int ClientId;
    /**
     *房间ID
     */
    private int OrderId;
    /**
     *入住时间
     */
    private String EnterTime;
    /**
     *退房时间
     */
    private String ExitTime;
    /**
     *房间类型
     */
    private String Suite_Type;
    /**
     * 开单管理员
     */
    private String billingAdmin;
    /**
     *结单管理员
     */
    private String checkAdmin;
    /**
     *房间价格
     */
    private int  SuitePrice;
    /**
     *最后结单房间价格
     */
    private int checkPrice;

    public Order() {
    }

    public Order(int clientId, int orderId, String enterTime, String suite_Type, String billingAdmin, int suitePrice) {
        ClientId = clientId;
        OrderId = orderId;
        EnterTime = enterTime;
        Suite_Type = suite_Type;
        this.billingAdmin = billingAdmin;
        SuitePrice = suitePrice;
    }

    public Order(int clientId, int orderId, String enterTime, String exitTime, String suite_Type, String billingAdmin, String checkAdmin, int suitePrice, int checkPrice) {
        ClientId = clientId;
        OrderId = orderId;
        EnterTime = enterTime;
        ExitTime = exitTime;
        Suite_Type = suite_Type;
        this.billingAdmin = billingAdmin;
        this.checkAdmin = checkAdmin;
        SuitePrice = suitePrice;
        this.checkPrice = checkPrice;
    }

    public Order(int id, int clientId, int orderId, String enterTime, String exitTime, String suite_Type, String billingAdmin, String checkAdmin, int suitePrice, int checkPrice) {
        Id = id;
        ClientId = clientId;
        OrderId = orderId;
        EnterTime = enterTime;
        ExitTime = exitTime;
        Suite_Type = suite_Type;
        this.billingAdmin = billingAdmin;
        this.checkAdmin = checkAdmin;
        SuitePrice = suitePrice;
        this.checkPrice = checkPrice;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public String getEnterTime() {
        return EnterTime;
    }

    public void setEnterTime(String enterTime) {
        EnterTime = enterTime;
    }

    public String getExitTime() {
        return ExitTime;
    }

    public void setExitTime(String exitTime) {
        ExitTime = exitTime;
    }

    public String getSuite_Type() {
        return Suite_Type;
    }

    public void setSuite_Type(String suite_Type) {
        Suite_Type = suite_Type;
    }

    public String getBillingAdmin() {
        return billingAdmin;
    }

    public void setBillingAdmin(String billingAdmin) {
        this.billingAdmin = billingAdmin;
    }

    public String getCheckAdmin() {
        return checkAdmin;
    }

    public void setCheckAdmin(String checkAdmin) {
        this.checkAdmin = checkAdmin;
    }

    public int getSuitePrice() {
        return SuitePrice;
    }

    public void setSuitePrice(int suitePrice) {
        SuitePrice = suitePrice;
    }

    public int getCheckPrice() {
        return checkPrice;
    }

    public void setCheckPrice(int checkPrice) {
        this.checkPrice = checkPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Id=" + Id +
                ", ClientId=" + ClientId +
                ", OrderId=" + OrderId +
                ", EnterTime='" + EnterTime + '\'' +
                ", ExitTime='" + ExitTime + '\'' +
                ", Suite_Type='" + Suite_Type + '\'' +
                ", billingAdmin='" + billingAdmin + '\'' +
                ", checkAdmin='" + checkAdmin + '\'' +
                ", SuitePrice=" + SuitePrice +
                ", checkPrice=" + checkPrice +
                '}';
    }
}
