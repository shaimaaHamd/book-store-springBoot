package com.bs.bs.model.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * model which used on signup request
 */
public class SignupRequest {

    //userName mustn't be blank and string length must be between (3:20)
    @NotBlank
    @Size(min = 3, max = 20)
    private String userName;

    //email mustn't be blank and validation email pattern
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    //userName mustn't be blank and string length must be between (6:40)
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
  
    public String getUsername() {
        return userName;
    }
 
    public void setUsername(String username) {
        this.userName = username;
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

}
