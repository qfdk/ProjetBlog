package org.meng.blog.respository;

import org.meng.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User,Integer> {

    
}
