package com.farras.lsb.ch3.repository;

import com.farras.lsb.ch3.entitiy.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserManagementRepository extends JpaRepository<UserAccount, Long> {

    public UserAccount findByUsername(String username);

}
