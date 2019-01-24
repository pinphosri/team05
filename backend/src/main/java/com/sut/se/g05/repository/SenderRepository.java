package com.sut.se.g05.repository;

import com.sut.se.g05.entity.Sender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestController
@CrossOrigin (origins = "http: //localhost:4200")
public interface SenderRepository extends JpaRepository<Sender, Long> {

}