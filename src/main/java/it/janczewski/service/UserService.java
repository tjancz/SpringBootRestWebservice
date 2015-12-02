package it.janczewski.service;

import it.janczewski.model.User;
import it.janczewski.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(String name){
        User user = new User();
        user.setName(name);
        user.setSurname("Surname of "+name);
        user.setAge(32);
        userRepository.save(user);
    }

    public User findUserByName(String name){
        List<User> foundUsers = userRepository.findByName(name);
        if (foundUsers.isEmpty()) {
            throw new RuntimeException("User not found");
            //TODO this should be some custom made exception and exception handling! - but it is only a demo TJ :)
        }
        return foundUsers.get(0);
    }

    public List<User> listUsers(){
        return (List<User>) userRepository.findAll();
    }
}
