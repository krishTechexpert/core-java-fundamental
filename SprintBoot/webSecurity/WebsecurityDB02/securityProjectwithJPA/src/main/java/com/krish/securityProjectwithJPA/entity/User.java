package com.krish.securityProjectwithJPA.entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;

    @ManyToMany
    @JoinTable(
            name="user_roles",// name of new Join Table
            joinColumns = @JoinColumn(name="user_id"),//FK of user,first column
            inverseJoinColumns = @JoinColumn(name="role_id")// FK of role,second table
    )
    private Set<Role> roles;
    public User(){
    }

    public User(long id, String username, String password, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
