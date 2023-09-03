package com.farras.lsb.ch3.repository;

import com.farras.lsb.ch3.entitiy.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<UserAccount, Long> {
    UserAccount findByUsername(String userName);
}
