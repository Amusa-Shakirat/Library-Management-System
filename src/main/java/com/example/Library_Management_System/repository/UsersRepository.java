package com.example.Library_Management_System.repository;

import com.example.Library_Management_System.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByFullName(String fullName);

    Optional<Users> findByEmail(String email);



}

//    addUser, deleteUser, updateUser, findUserById,
//    findUserByFullName, findUserByEmail