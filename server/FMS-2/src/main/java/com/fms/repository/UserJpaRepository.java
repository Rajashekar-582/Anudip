package com.fms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.model.User;
import com.fms.enums.UserRole;
@Repository

public interface UserJpaRepository extends JpaRepository<User, Long> {
    User findByUserRole(UserRole User);
    User findByUserEmail(UserRole admin);
}