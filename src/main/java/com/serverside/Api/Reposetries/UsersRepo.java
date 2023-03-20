package com.serverside.Api.Reposetries;

import com.serverside.Api.Model.Users_data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users_data,Long> {

   Optional<Users_data> findByEmail(String email);

}
