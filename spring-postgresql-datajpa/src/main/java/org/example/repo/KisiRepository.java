package org.example.repo;

import org.example.entitiy.Address;
import org.example.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KisiRepository extends JpaRepository<User,Long> {
}
