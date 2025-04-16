package com.tot.util.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tot.util.module.Users;

public interface UserRepository extends JpaRepository<Users,Integer> {
}
