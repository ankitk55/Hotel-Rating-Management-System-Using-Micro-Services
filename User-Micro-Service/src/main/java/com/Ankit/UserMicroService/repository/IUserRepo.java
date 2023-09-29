package com.Ankit.UserMicroService.repository;

import com.Ankit.UserMicroService.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<UserEntity,Long> {
}
