package com.mySSM.pojo;

public class Order {
    /**
     *订单ID
     */
    private Integer Id;
    /**
     * 客户名字
     */
    private String name;
    /**
     * 客户性别
     */
    private String sex;
    /**
     * 客户身份证
     */
    private String card;
    /**
     * 客户手机号
     */
    private String phone;
    /**
     * 房间号
     */
    private String suiteNum;
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
    private String SuiteType;
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
    private Integer suitePrice;
    /**
     *最后结单房间价格
     */
    private Integer checkPrice;
    /**
     * 订单状态
     */
    private String state;
    /**
     * 订单备注
     */
    private String Remark;

    public Order() {
    }

    public Order(String name, String sex, String card, String phone, String suiteNum, String enterTime, String suite_Type, String billingAdmin, Integer suitePrice, String orderState, String remark) {
        this.name = name;
        this.sex = sex;
        this.card = card;
        this.phone = phone;
        this.suiteNum = suiteNum;
        EnterTime = enterTime;
        SuiteType = suite_Type;
        this.billingAdmin = billingAdmin;
        this.suitePrice = suitePrice;
        state = orderState;
        Remark = remark;
    }

    public Order(Integer id, String name, String sex, String card, String phone, String suiteNum, String enterTime, String exitTime, String suite_Type, String billingAdmin, String checkAdmin, Integer suitePrice, Integer checkPrice, String orderState, String remark) {
        Id = id;
        this.name = name;
        this.sex = sex;
        this.card = card;
        this.phone = phone;
        this.suiteNum = suiteNum;
        EnterTime = enterTime;
        ExitTime = exitTime;
        SuiteType = suite_Type;
        this.billingAdmin = billingAdmin;
        this.checkAdmin = checkAdmin;
        this.suitePrice = suitePrice;
        this.checkPrice = checkPrice;
        state = orderState;
        Remark = remark;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSuiteNum() {
        return suiteNum;
    }

    public void setSuiteNum(String suiteNum) {
        this.suiteNum = suiteNum;
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

    public String getSuiteType() {
        return SuiteType;
    }

    public void setSuiteType(String suiteType) {
        SuiteType = suiteType;
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

    public Integer getSuitePrice() {
        return suitePrice;
    }

    public void setSuitePrice(Integer suitePrice) {
        this.suitePrice = suitePrice;
    }

    public Integer getCheckPrice() {
        return checkPrice;
    }

    public void setCheckPrice(Integer checkPrice) {
        this.checkPrice = checkPrice;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", card='" + card + '\'' +
                ", phone='" + phone + '\'' +
                ", suiteNum='" + suiteNum + '\'' +
                ", EnterTime='" + EnterTime + '\'' +
                ", ExitTime='" + ExitTime + '\'' +
                ", SuiteType='" + SuiteType + '\'' +
                ", billingAdmin='" + billingAdmin + '\'' +
                ", checkAdmin='" + checkAdmin + '\'' +
                ", suitePrice=" + suitePrice +
                ", checkPrice=" + checkPrice +
                ", state='" + state + '\'' +
                ", Remark='" + Remark + '\'' +
                '}';
    }
}
