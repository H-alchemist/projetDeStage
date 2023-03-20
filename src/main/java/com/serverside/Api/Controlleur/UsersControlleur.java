package com.serverside.Api.Controlleur;


import com.serverside.Api.Dao.UserDao;
import com.serverside.Api.Model.LoginInfo;
import com.serverside.Api.Model.Transaction;
import com.serverside.Api.Model.Users_data;
import com.serverside.Api.Reposetries.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class UsersControlleur {


    @Autowired
    UserDao userdao;


    @PostMapping("/users/post")
    public ResponseEntity<?> addUser(@RequestBody Users_data u){

         try {
             return new ResponseEntity<Users_data>(userdao.add(u), HttpStatus.OK);
         }catch (Exception e){
             return new ResponseEntity<String>("440" , HttpStatus.OK);
         }
    }
    @GetMapping("/users/getAll")
    public List<Users_data> getAllT(){


        return userdao.getAll();
    }
    @GetMapping("/users/getOne/{id}")
    public Users_data getOne(@PathVariable Long id){
       return userdao.getOne(id);
    }

    @PostMapping("/users/postLoginInfo")
    public ResponseEntity<String> addUser(@RequestBody LoginInfo u){


            return new ResponseEntity<String>(userdao.getByEmail(u), HttpStatus.OK);



    }









}
