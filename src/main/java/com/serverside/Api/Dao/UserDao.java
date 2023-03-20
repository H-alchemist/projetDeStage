package com.serverside.Api.Dao;


import com.serverside.Api.Model.LoginInfo;
import com.serverside.Api.Model.Transaction;
import com.serverside.Api.Model.Users_data;
import com.serverside.Api.Reposetries.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import static org.hibernate.internal.util.StringHelper.isBlank;
import static org.hibernate.internal.util.StringHelper.nullIfEmpty;

@Service
public class UserDao {


    @Autowired
    UsersRepo userR ;
    CheckingData checkingData =new CheckingData();


// add user
    public Users_data add(Users_data u){
        String p=u.getPassword();
                Long x= checkingData.generateId_code();
        if (x != null && !isBlank(String.valueOf(x))) {
             x= checkingData.generateId_code();
        }

      u.setId_code(x);
        u.setPassword(checkingData.hashString(p));

      Users_data y=  userR.save(u);
      y.setPassword("null");
      return y;

    }

    public List<Users_data> getAll(){

        return userR.findAll();

    }

    public Users_data getOne(Long id){
       return userR.findById(id).get();
    }


// find by email
    public String getByEmail(LoginInfo e){

     if (userR.findByEmail(e.getEmail()).isEmpty()==false){

            String x = checkingData.hashString(e.getPassword());
            System.out.println(x);
            String y = userR.findByEmail(e.getEmail()).get().getPassword();
         System.out.println(y);
            if (x.equals(y)) {
                return "200";
            }else
                return "440";
        }
        else
        {
            return "600";
        }

    }




    public boolean getTime(Users_data u){

      Timestamp x =  userR.findById(u.getId_code()).get().getJwt_date();


      if(x.getDay()>u.getJwt_date().getDay() && x.getTime()>u.getJwt_date().getTime()){


          return false;


      }else{
          return true;
      }




    }









}
