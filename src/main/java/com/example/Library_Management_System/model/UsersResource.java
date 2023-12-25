package com.example.Library_Management_System.model;

import org.springframework.hateoas.RepresentationModel;

public class UsersResource extends RepresentationModel<UsersResource> {

    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
