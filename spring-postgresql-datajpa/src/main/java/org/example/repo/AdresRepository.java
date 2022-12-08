package org.example.repo;

import org.example.entitiy.Address;
import org.example.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;

public interface AdresRepository extends JpaRepository<Address,Long> {
}
