package com.caronas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caronas.model.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
  
  User findById(int id);

}
