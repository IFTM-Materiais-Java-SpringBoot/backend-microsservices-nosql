package dtos;

import models.Employee;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Objects;

public class EmployeeDTO implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private String level;
    private double wage;
    private String cpf;

    public EmployeeDTO() { }

    public EmployeeDTO(String firstName, String lastName, String level, double wage, String cpf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
        this.wage = wage;
        this.cpf = cpf;
    }

    public EmployeeDTO(Employee employee) {
        if(employee.getId() != null)
            this.id = employee.getId().toString();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.level = employee.getLevel();
        this.wage = employee.getWage();
        this.cpf = employee.getCpf();
    }

    public Employee toEmployee() {
        ObjectId id = null;
        if(this.id != null)
            id = new ObjectId(this.id);

        return new Employee(id,
                this.firstName,
                this.lastName,
                this.level,
                this.wage,
                this.cpf);
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO that = (EmployeeDTO) o;
        return Double.compare(that.wage, wage) == 0 && Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(level, that.level) && Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, level, wage, cpf);
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", level='" + level + '\'' +
                ", wage=" + wage +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
