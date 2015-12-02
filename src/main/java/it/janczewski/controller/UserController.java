package it.janczewski.controller;

import it.janczewski.model.User;
import it.janczewski.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User retrieveUserByName(@RequestParam(value = "name", defaultValue = "none") String name){
        return userService.findUserByName(name);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.addUser(user.getName());
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> listUsers(){
        return userService.listUsers();
    }
}
