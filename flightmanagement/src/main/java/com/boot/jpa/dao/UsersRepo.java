package com.boot.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.jpa.entites.Users;

public interface UsersRepo extends CrudRepository<Users,Integer> {

}

