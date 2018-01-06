package com.matrix.cloud.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matrix.cloud.microservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
}
