package com.vaibhavi.Springsecurity.service;

import com.vaibhavi.Springsecurity.model.UserPrincipal;
import com.vaibhavi.Springsecurity.model.Users;
import com.vaibhavi.Springsecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user=userRepo.findByUsername(username);

        if(user==null){
            System.out.println("user not found");
            throw new UsernameNotFoundException(username);
        }

        return new UserPrincipal(user);
    }


}
