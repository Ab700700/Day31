package com.example.repoexercise.Service;

import com.example.repoexercise.Api.ApiExceptions;
import com.example.repoexercise.Model.User;
import com.example.repoexercise.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> getUsers(){
        return repository.findAll();
    }

    public void addUser(User user){
        repository.save(user);
    }

    public String updateUser(Integer id, User user){
        User u = repository.findUserById(id);
        if(u == null) throw new ApiExceptions("User not found");
        user.setId(id);
        repository.save(user);
        return "User updated";
    }

    public String deleteUser(Integer id){
        User user = repository.findUserById(id);
        if(user == null) throw  new ApiExceptions("User not found");
        repository.delete(user);
        return "User deleted";
    }

    public String checkusername(Integer id, String username , String password){
        User user = repository.findUserById(id);
        if(user == null) throw new ApiExceptions("User not found");
        if(user.getPassword().equals(password) && user.getUsername().equals(username)) return "Checked";
        else return "password or username is wrong";
    }

    public User getByEmail(String email){
        User u = repository.findUserByEmail(email);
        if(u == null) throw new ApiExceptions("Not found");
        return u;
    }

    public List<User> getByRole(String role){
        List<User> users= repository.findUsersByRole(role);
        if(users.isEmpty()) throw new ApiExceptions("No one is there");
        return users;
    }

    public List<User> getByAge(Integer age){
        List<User> users = repository.findUsersByAgeGreaterThanEqual(age);
        if(users.size()==0) throw  new ApiExceptions("Not found");
        return users;
    }



}
