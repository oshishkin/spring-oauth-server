package com.wemboo.rest;


import java.security.Principal;

import com.wemboo.db.User;
import com.wemboo.oauth.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserRestController {

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    private MyUserDetailsService userDetailsService;    
    
    @GetMapping("/api/user")
    public User user(Principal principal) {
        return userDetailsService.getUserEntityByUsername(principal.getName());
    }

    @RequestMapping(method=RequestMethod.GET, value = "/api/encodepassword/{password}",                         
    produces = MediaType.APPLICATION_JSON_VALUE )
    public String encodePassword(@PathVariable("password") String password) {

        return passwordEncoder.encode(password);
    }

    @RequestMapping(method=RequestMethod.GET, value = "/api/code",                         
    produces = MediaType.APPLICATION_JSON_VALUE )
    public String getCode(@RequestParam("code") String code) {

        return code;
    }

}
