package com.sut.se.g05.repository;

import com.example.demo.entity.Bankemp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface BankempRepository extends JpaRepository<Bankemp, Long> {
    Bankemp findBybankempid (Long bankempid);
}
