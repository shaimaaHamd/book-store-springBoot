package com.bs.bs.api.controller;

import com.bs.bs.config.JwtUtils;
import com.bs.bs.entity.Category;
import com.bs.bs.entity.Role;
import com.bs.bs.entity.UserEntity;
import com.bs.bs.model.UserDetailsImpl;
import com.bs.bs.model.enums.ECategory;
import com.bs.bs.model.enums.ERole;
import com.bs.bs.model.payload.request.LoginRequest;
import com.bs.bs.model.payload.request.SignupRequest;
import com.bs.bs.model.payload.response.JwtResponse;
import com.bs.bs.model.payload.response.MessageResponse;
import com.bs.bs.repository.RoleRepository;
import com.bs.bs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    /**
     * API which responsible to signin with username&password the same ones after you used in signing up ex:
     {
     "username": "test",
     "password": "test123"
     }
     * It takes userName & password as request body
     * return user details includes jwt
     */

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        //it gets User’s information such as username,password, authorities from an Authentication object.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        // used to set the current UserDetails in SecurityContext using setAuthentication(authentication)
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // call generateJwtToken method and set authentication of current user as parameter
        String jwt = jwtUtils.generateJwtToken(authentication);

        // used to get the current UserDetails
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // used to convert set of roles of current user to Collection of authorities
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    /**
     * API which is responsible for signing up by passing the attributes in the RequestBody ex:
     {
     "username": "test",
     "email": "test@gmail.com",
     "role": ["admin"],
     "password": "test123"
     }
     * @param signUpRequest
     * @return ResponseEntity
     */


    @PostMapping(value = "/signup/{roles}" )
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest,@PathVariable("roles") List<ERole> eRoles) {
        //check if username exist
        if (userRepository.existsByUserName(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        //check if email exist
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        UserEntity user = new UserEntity(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));
        List<Role> roles =new ArrayList<>();
        for (ERole eRole: eRoles) {
            Role role= roleRepository.findByName(eRole).get();
            roles.add(role);
        }
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
