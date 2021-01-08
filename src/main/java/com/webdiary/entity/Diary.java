package com.webdiary.entity;

import java.util.Date;

public class Diary {
    private Integer diaryId;

    private String diaryTitle;

    private Integer customerId;

    private Date createTime;

    private byte[] diaryContent;

    public Integer getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(Integer diaryId) {
        this.diaryId = diaryId;
    }

    public String getDiaryTitle() {
        return diaryTitle;
    }

    public void setDiaryTitle(String diaryTitle) {
        this.diaryTitle = diaryTitle == null ? null : diaryTitle.trim();
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public byte[] getDiaryContent() {
        return diaryContent;
    }

    public void setDiaryContent(byte[] diaryContent) {
        this.diaryContent = diaryContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", diaryId=").append(diaryId);
        sb.append(", diaryTitle=").append(diaryTitle);
        sb.append(", customerId=").append(customerId);
        sb.append(", createTime=").append(createTime);
        sb.append(", diaryContent=").append(diaryContent);
        sb.append("]");
        return sb.toString();
    }
}