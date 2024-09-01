package gsa.webland.ecommercex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gsa.webland.ecommercex.model.User;
import gsa.webland.ecommercex.repository.UserRepository;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    
    public List<User> getAllUser(){
        return  userRepository.findAll();
    }

    public User  getUserById (Long id){
        User user=userRepository.findById(id)
        .orElseThrow(
            ()->new  RuntimeException("Aucun user trouvé")
        );
        return user;
    }

    public  User saveUser(User user){
        User newUser=  userRepository.save(user);
        return newUser;
        
    }

    public User updateUser(Long id, User user){
        User userToUpdate=userRepository.findById(id)
        .orElseThrow(
            ()->  new RuntimeException("user inexistant")
        );
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());

        return userRepository.save(userToUpdate);

    }

    public void  deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
