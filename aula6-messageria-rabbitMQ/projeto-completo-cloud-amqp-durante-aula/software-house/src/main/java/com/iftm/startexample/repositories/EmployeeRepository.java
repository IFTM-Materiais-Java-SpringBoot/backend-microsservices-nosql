package com.iftm.startexample.repositories;

import models.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {

    @Query("{wage: {$gt: ?0}}")
    public Optional<List<Employee>> findEmployeesWithWageAboveValue(double value);
}
