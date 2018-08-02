package org.meng.blog.repository;

import org.meng.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public abstract class Repository implements JpaRepository <User, Integer> {

}
