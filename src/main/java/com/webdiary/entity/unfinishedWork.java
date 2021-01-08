package com.webdiary.entity;

import java.util.Date;

public class unfinishedWork {
    private Integer unfinishedId;

    private String unfinishedTitle;

    private Date createTime;

    private Date deadline;

    private Integer customerId;

    private byte[] unfinishedContent;

    public Integer getUnfinishedId() {
        return unfinishedId;
    }

    public void setUnfinishedId(Integer unfinishedId) {
        this.unfinishedId = unfinishedId;
    }

    public String getUnfinishedTitle() {
        return unfinishedTitle;
    }

    public void setUnfinishedTitle(String unfinishedTitle) {
        this.unfinishedTitle = unfinishedTitle == null ? null : unfinishedTitle.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public byte[] getUnfinishedContent() {
        return unfinishedContent;
    }

    public void setUnfinishedContent(byte[] unfinishedContent) {
        this.unfinishedContent = unfinishedContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", unfinishedId=").append(unfinishedId);
        sb.append(", unfinishedTitle=").append(unfinishedTitle);
        sb.append(", createTime=").append(createTime);
        sb.append(", deadline=").append(deadline);
        sb.append(", customerId=").append(customerId);
        sb.append(", unfinishedContent=").append(unfinishedContent);
        sb.append("]");
        return sb.toString();
    }
}