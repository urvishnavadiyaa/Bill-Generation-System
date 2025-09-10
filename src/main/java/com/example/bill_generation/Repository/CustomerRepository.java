package com.example.bill_generation.Repository;


import com.example.bill_generation.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "SELECT * FROM customer WHERE local_date = :today", nativeQuery = true)
    List<Customer> findByLocalDate(@Param("today") LocalDate today);

}
