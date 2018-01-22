package com.lanou3g.bean;

/**
 * Created by fwj on 2018/1/19.
 */
public class Employee {
    private int id;
    private String name;
    private Integer age;
    private String department;
    private String entrytime;
    private String address;
    private Integer phnumber;

    public Employee() {
    }

    public Employee(int id, String name, Integer age, String department, String entrytime, String address, Integer phnumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.entrytime = entrytime;
        this.address = address;
        this.phnumber = phnumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(String entrytime) {
        this.entrytime = entrytime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhnumber() {
        return phnumber;
    }

    public void setPhnumber(Integer phnumber) {
        this.phnumber = phnumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (age != null ? !age.equals(employee.age) : employee.age != null) return false;
        if (department != null ? !department.equals(employee.department) : employee.department != null) return false;
        if (entrytime != null ? !entrytime.equals(employee.entrytime) : employee.entrytime != null) return false;
        if (address != null ? !address.equals(employee.address) : employee.address != null) return false;
        if (phnumber != null ? !phnumber.equals(employee.phnumber) : employee.phnumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (entrytime != null ? entrytime.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phnumber != null ? phnumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", entrytime='" + entrytime + '\'' +
                ", address='" + address + '\'' +
                ", phnumber=" + phnumber +
                '}';
    }
}
