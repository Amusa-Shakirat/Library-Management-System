package com.example.Library_Management_System.controller;


import com.example.Library_Management_System.model.Users;
import com.example.Library_Management_System.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {


    @Autowired
    private UsersService usersService;

    @PostMapping("/addUser")
    public ResponseEntity<Users> save(@RequestBody @Valid Users users){
        return new ResponseEntity<>(usersService.addUser(users).getBody(),HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {

        return usersService.deleteUser(id);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable long id, @Valid @RequestBody Users users ){
        return ResponseEntity.ok(usersService.updateUser(id, users));
    }

    @GetMapping(value = "/retrieveUser/all")
    @ResponseBody
    public ResponseEntity<List<Users>> getAllUsers(){
        return ResponseEntity.ok(usersService.getAllUsers().getBody());
    }

    @GetMapping("/retrieveUser/{id}")
    public ResponseEntity<Users> findByById( @PathVariable long id ){
        return new ResponseEntity<>(usersService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping("/retrieveUser/name/{fullName}")
    public ResponseEntity<Users> findByFullName( @PathVariable String fullName){
        return new ResponseEntity<>(usersService.findUserByFullName(fullName), HttpStatus.OK);
    }

    @GetMapping("/retrieveUser/mail/{email}")
    public ResponseEntity<Users> findByEmail( @PathVariable String email){
        return new ResponseEntity<>(usersService.findUserByEmail(email), HttpStatus.OK);
    }

}
//    addUser, deleteUser, updateUser, findUserById,
//    findUserByFullName, findUserByEmail