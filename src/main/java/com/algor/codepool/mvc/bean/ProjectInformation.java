package com.algor.codepool.mvc.bean;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "PROJECT_INFORMATION")
public class ProjectInformation {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PRO_NAME")
    private String proName;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "DEADLINE")
    private Date deadline;

    @Column(name = "OVER_TIME")
    private Date overTime;

    @Column(name = "TECH_POINTS")
    private String techPoints;

    public ProjectInformation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public String getTechPoints() {
        return techPoints;
    }

    public void setTechPoints(String techPoints) {
        this.techPoints = techPoints;
    }

}
