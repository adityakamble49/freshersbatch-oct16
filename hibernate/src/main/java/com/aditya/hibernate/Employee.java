package com.aditya.hibernate;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "getAllEmployee", query = "from Employee")

})
@Entity
@Table(name = "EMP")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "commission")
    private Integer commission;

    @Column(name = "role")
    private String role;

    @Column(name = "dept_no")
    private String deptNo;

    @Column(name = "hired_date")
    private Date hiredDate;

    @Column(name = "manager_id  ")
    private Integer managerID;

    public Employee() {
    }

    public Employee(Long id, String name, Integer salary, Integer commission,
            String role, String deptNo, Date hiredDate, Integer managerID) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.commission = commission;
        this.role = role;
        this.deptNo = deptNo;
        this.hiredDate = hiredDate;
        this.managerID = managerID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public Integer getManagerID() {
        return managerID;
    }

    public void setManagerID(Integer managerID) {
        this.managerID = managerID;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
                + ", commission=" + commission + ", role=" + role + ", deptNo="
                + deptNo + ", hiredDate=" + hiredDate + ", managerID="
                + managerID + "]";
    }

}
