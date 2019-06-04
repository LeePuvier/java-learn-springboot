package com.leepuvier.learn.entry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {


    User findByPhone(String phone);

    User findByNickname(String nickname);

}
