package org.sang.bean;

import java.util.Date;

/**
 * @ClassName AdjustSalary
 * @Description TODO
 * @Auther YCHD-JPC
 * @Date 2019/7/29 17:28
 **/

public class AdjustSalary {

    private int id;

    private int eid;

    private Date asDate;

    private int beforeSalary;

    private int afterSalary;

    private String reason;

    private String remark;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public Date getAsDate() {
        return asDate;
    }

    public void setAsDate(Date asDate) {
        this.asDate = asDate;
    }

    public int getBeforeSalary() {
        return beforeSalary;
    }

    public void setBeforeSalary(int beforeSalary) {
        this.beforeSalary = beforeSalary;
    }

    public int getAfterSalary() {
        return afterSalary;
    }

    public void setAfterSalary(int afterSalary) {
        this.afterSalary = afterSalary;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
