package com.example.fwajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class TestController {
    @Autowired
    private UserRepository userRepo;


    @GetMapping(value = "/")
    public String hello(){
        return "Hello from final app";
    }

    @GetMapping(value = "/user/{userId}")
    public User getUser(@PathVariable(value = "userId") Integer userId) throws Exception{
        System.out.println("UserID is:" + userId);
        Optional<User> user = userRepo.findById(userId);

        if(user.isPresent()){
            System.out.println("Item returned is:" + user.get());
            return user.get();
        }else{
            throw new Exception("User not found");
        }
    }

    @PutMapping(value = "/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        System.out.println("User is:" + user);
        User createdUser = userRepo.save(user);
        System.out.println("Created user:" + createdUser);
        return createdUser;
    }



    @PostMapping(value = "/item")
    public String userData(@RequestBody String message){
        System.out.println("message is:" + message);
        return message;
    }


}