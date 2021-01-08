package com.webdiary.entity;

import java.util.Date;

public class Customer {
    private Integer customerId;

    private String customerName;

    private Integer loginCount;

    private Date lastLoginTime;

    private byte[] customerPassword;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public byte[] getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(byte[] customerPassword) {
        this.customerPassword = customerPassword;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", customerId=").append(customerId);
        sb.append(", customerName=").append(customerName);
        sb.append(", loginCount=").append(loginCount);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", customerPassword=").append(customerPassword);
        sb.append("]");
        return sb.toString();
    }
}