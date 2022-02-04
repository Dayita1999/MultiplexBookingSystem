package com.multiplex.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiplex.Model.User;

public interface UserDAO extends JpaRepository<User, Long> {

}
