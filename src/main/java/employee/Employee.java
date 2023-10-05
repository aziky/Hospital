
package employee;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pcm23
 */
public class Employee {
    private String ID;
    private String name;
    private String phone;
    private Date bDate;
    private String role;
    private Date hireDate;
    private int salary;
    private int contractTime;
    private Date resignDate;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public Employee() {
    }

    public Employee(String ID, String name, String phone, Date bDate, String role, Date hireDate, int salary,
            int contractTime, Date resignDate) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.bDate = bDate;
        this.role = role;
        this.hireDate = hireDate;
        this.salary = salary;
        this.contractTime = contractTime;
        this.resignDate = resignDate;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Date getbDate() {
        return bDate;
    }

    public String getRole() {
        return role;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public int getContractTime() {
        return contractTime;
    }

    public Date getResignDate() {
        return resignDate;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setContractTime(int contractTime) {
        this.contractTime = contractTime;
    }

    public void setResignDate(Date resignDate) {
        this.resignDate = resignDate;
    }

    @Override
    public String toString() {
        if (resignDate == null) {
            return ID + ", " + name + ", " + phone + ", " + sdf.format(bDate) + ", " + role + ", " +
                    sdf.format(hireDate) + ", " + salary + ", " + contractTime + ", " + resignDate;
        }

        return ID + ", " + name + ", " + phone + ", " + sdf.format(bDate) + ", " + role + ", " +
                sdf.format(hireDate) + ", " + salary + ", " + contractTime + ", " + null;

    }

}
