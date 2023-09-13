package com.iftm.startexample.models.dtos;

import com.iftm.startexample.models.Employee;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.util.Objects;

public class EmployeeDTO implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private String level;
    private double wage;
    private String intanceId;

    public EmployeeDTO() { }

    public EmployeeDTO(String firstName, String lastName, String level, double wage, String intanceId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
        this.wage = wage;
        this.intanceId = intanceId;
    }

    public EmployeeDTO(Employee employee) {
        if(employee.getId() != null)
            this.id = employee.getId().toString();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.level = employee.getLevel();
        this.wage = employee.getWage();
    }

    public Employee toEmployee() {
        ObjectId id = null;
        if(this.id != null)
            id = new ObjectId(this.id);

        return new Employee(id,
                this.firstName,
                this.lastName,
                this.level,
                this.wage);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getIntanceId() {
        return intanceId;
    }

    @Value("${eureka.instance.instance-id}")
    public void setIntanceId(String intanceId) {
        this.intanceId = intanceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO that = (EmployeeDTO) o;
        return Double.compare(that.wage, wage) == 0 && Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(level, that.level) && Objects.equals(intanceId, that.intanceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, level, wage, intanceId);
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", level='" + level + '\'' +
                ", wage=" + wage +
                ", intanceId='" + intanceId + '\'' +
                '}';
    }
}
