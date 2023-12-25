package com.example.Library_Management_System.service;


import com.example.Library_Management_System.exceptions.UserNotFoundException;
import com.example.Library_Management_System.model.Users;
import com.example.Library_Management_System.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;


//    addUser, deleteUser, updateUser, findUserById,
//    findUserByFullName, findUserByEmail
    @CacheEvict(value = {"singleUser", "allUsers"}, allEntries = true)
    public ResponseEntity<Users> addUser(Users users){

        return ResponseEntity.ok(usersRepository.save(users));
    }


    @CacheEvict(value = {"singleUser", "allUsers"}, allEntries = true)
    public ResponseEntity <String> deleteUser(long id){
    usersRepository.deleteById(id);
    return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }


    @CacheEvict(value = {"singleUser", "allUsers"}, allEntries = true)
    public Users updateUser(long id, Users users) {
        Users toBeUpdated = usersRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        //Update variables
        assert toBeUpdated != null;
        toBeUpdated.setFullName(users.getFullName());
        toBeUpdated.setAge(users.getAge());
        toBeUpdated.setEmail(users.getEmail());
        toBeUpdated.setAddress(users.getAddress());

        return usersRepository.save(toBeUpdated);
    }


    @Cacheable("allUsers")
    public ResponseEntity<List<Users>> getAllUsers(){
        return ResponseEntity.ok(usersRepository.findAll());
    }

    public Users findUserById(long id){

        return usersRepository.findById(id).orElse(null);
    }

    public Users findUserByFullName(String fullName){

        return usersRepository.findByFullName(fullName).orElse(null);
    }


    public Users findUserByEmail(String email){

        return usersRepository.findByEmail(email).orElse(null);
    }






}
