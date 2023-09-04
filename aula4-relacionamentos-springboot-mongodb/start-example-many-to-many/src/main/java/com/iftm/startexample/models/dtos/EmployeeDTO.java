package com.iftm.startexample.models.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iftm.startexample.models.Employee;
import com.iftm.startexample.models.Sector;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EmployeeDTO implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private String level;
    private double wage;
    @JsonBackReference
    private List<SectorDTO> sectors;

    public EmployeeDTO() { }

    public EmployeeDTO(String firstName, String lastName, String level, double wage, List<SectorDTO> sectors) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
        this.wage = wage;
        this.sectors = sectors;
    }

    public EmployeeDTO(Employee employee) {
        if(employee.getId() != null)
            this.id = employee.getId().toString();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.level = employee.getLevel();
        this.wage = employee.getWage();
//        if(employee.getSectors() != null)
//            this.sectors = employee.getSectors().stream().map(sector -> {
//                return new SectorDTO(sector);
//            }).collect(Collectors.toList());
    }

    public Employee toEmployee() {
        ObjectId id = null;
        if(this.id != null)
            id = new ObjectId(this.id);

        List<Sector> sectors = null;
        if(this.sectors != null)
            sectors = this.sectors.stream().map(employeeDTO -> {
                        return employeeDTO.toSector();
                    }
            ).collect(Collectors.toList());

        return new Employee(id,
                this.firstName,
                this.lastName,
                this.level,
                this.wage,
                sectors);
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

    @JsonIgnore
    public List<SectorDTO> getSectors() {
        return sectors;
    }

    public void setSectors(List<SectorDTO> sectors) {
        this.sectors = sectors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO that = (EmployeeDTO) o;
        return Double.compare(that.wage, wage) == 0 && Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(level, that.level) && Objects.equals(sectors, that.sectors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, level, wage, sectors);
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", level='" + level + '\'' +
                ", wage=" + wage +
                ", sectors=" + sectors +
                '}';
    }
}
