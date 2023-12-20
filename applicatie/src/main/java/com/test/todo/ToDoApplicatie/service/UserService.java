package com.test.todo.ToDoApplicatie.service;

import com.test.todo.ToDoApplicatie.entity.ToDoUser;
import com.test.todo.ToDoApplicatie.model.RegisterUserDTO;
import com.test.todo.ToDoApplicatie.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserService implements UserDetailsService {

    @Resource
    UserRepository userRepository;

    @Resource
    PasswordEncoder passwordEncoder;

    public void createUser(RegisterUserDTO registerUserDTO) {
        ToDoUser user = new ToDoUser();
        user.setUsername(registerUserDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByusername(username);
    }
}
