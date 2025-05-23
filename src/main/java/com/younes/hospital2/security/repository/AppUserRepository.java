package com.younes.hospital2.security.repository;

import com.younes.hospital2.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository  extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
