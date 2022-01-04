package com.bs.bs.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * User entity which create users table in db
 * It has 5 fields: id, username, email, password, roles.
 * username and email must be unique
 * */
@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "userName"),
                @UniqueConstraint(columnNames = "email")
        })
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    private String userName;

    @Email
    private String email;

    @NotBlank
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<Role> roles = new ArrayList<>();

    public UserEntity(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }


    public UserEntity() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String firstName) {
        this.userName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
