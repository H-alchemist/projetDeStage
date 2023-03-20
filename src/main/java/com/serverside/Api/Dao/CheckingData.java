package com.serverside.Api.Dao;


import com.serverside.Api.Model.Users_data;
import com.serverside.Api.Reposetries.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Random;



public class CheckingData {



    public Long generateId_code(){
        Random random = new Random();

        // generate a random number with 8 digits
        Long randomNum = random.nextLong(900000000) + 10000000;
        return randomNum;
    }


    public  String hashString(String u){
        String NewPassw = "";
        try {

            String passwWall = u + "wall";

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] bytes = md.digest(passwWall.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString(bytes[i] & 0xff));
            }
            NewPassw = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return NewPassw;

    }

    public Timestamp compareTimeMap(Users_data u){

        return u.getJwt_date();

    }
}
