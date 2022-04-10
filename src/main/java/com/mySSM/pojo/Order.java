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
    private int suiteId;
    /**
     *订单时间
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
    /**
     * 订单状态
     */
    private String OrderState;
    /**
     * 订单备注
     */
    private String Remark;

    public Order() {
    }

    public Order(int clientId, String enterTime, String suite_Type, String billingAdmin, int suitePrice, String orderState, String remark) {
        ClientId = clientId;
        EnterTime = enterTime;
        Suite_Type = suite_Type;
        this.billingAdmin = billingAdmin;
        SuitePrice = suitePrice;
        OrderState = orderState;
        Remark = remark;
    }

    public Order(int clientId, int suiteId, String enterTime, String suite_Type, String billingAdmin, int suitePrice, String orderState, String remark) {
        ClientId = clientId;
        this.suiteId = suiteId;
        EnterTime = enterTime;
        Suite_Type = suite_Type;
        this.billingAdmin = billingAdmin;
        SuitePrice = suitePrice;
        OrderState = orderState;
        Remark = remark;
    }

    public Order(int id, int clientId, int suiteId, String enterTime, String exitTime, String suite_Type, String billingAdmin, String checkAdmin, int suitePrice, int checkPrice, String orderState, String remark) {
        Id = id;
        ClientId = clientId;
        this.suiteId = suiteId;
        EnterTime = enterTime;
        ExitTime = exitTime;
        Suite_Type = suite_Type;
        this.billingAdmin = billingAdmin;
        this.checkAdmin = checkAdmin;
        SuitePrice = suitePrice;
        this.checkPrice = checkPrice;
        OrderState = orderState;
        Remark = remark;
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

    public int getSuiteId() {
        return suiteId;
    }

    public void setSuiteId(int suiteId) {
        this.suiteId = suiteId;
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

    public String getOrderState() {
        return OrderState;
    }

    public void setOrderState(String orderState) {
        OrderState = orderState;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Id=" + Id +
                ", ClientId=" + ClientId +
                ", OrderId=" + suiteId +
                ", EnterTime='" + EnterTime + '\'' +
                ", ExitTime='" + ExitTime + '\'' +
                ", Suite_Type='" + Suite_Type + '\'' +
                ", billingAdmin='" + billingAdmin + '\'' +
                ", checkAdmin='" + checkAdmin + '\'' +
                ", SuitePrice=" + SuitePrice +
                ", checkPrice=" + checkPrice +
                ", OrderState='" + OrderState + '\'' +
                ", Remark='" + Remark + '\'' +
                '}';
    }
}
