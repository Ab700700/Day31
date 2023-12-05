package com.example.repoexercise.Controller;

import com.example.repoexercise.Model.User;
import com.example.repoexercise.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ums")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/get")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getFieldError().getDefaultMessage());
        service.addUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("User added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@RequestBody @Valid User user, @PathVariable Integer id,Errors errors){
        if(errors.hasErrors()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getFieldError().getDefaultMessage());
        return ResponseEntity.status(HttpStatus.OK).body(service.updateUser(id,user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteUser(id));
    }

    @GetMapping("/check/{id}/{username}/{password}")
    public ResponseEntity checkPU(@PathVariable Integer id, @PathVariable String username, @PathVariable String password){
        return ResponseEntity.status(HttpStatus.OK).body(service.checkusername(id,username,password));
    }

    @GetMapping("/getemail/{email}")
    public ResponseEntity getByEmail(@PathVariable String email){
        return ResponseEntity.status(HttpStatus.OK).body(service.getByEmail(email));
    }

    @GetMapping("/getrole/{role}")
    public ResponseEntity getByRole(@PathVariable String role){
        return ResponseEntity.status(HttpStatus.OK).body(service.getByRole(role));
    }
    @GetMapping("/getage/{age}")
    public ResponseEntity getByAge(@PathVariable Integer age){
        return ResponseEntity.status(HttpStatus.OK).body(service.getByAge(age));
    }


}
