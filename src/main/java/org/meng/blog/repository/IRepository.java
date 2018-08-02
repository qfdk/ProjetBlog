package org.meng.blog.repository;

import org.meng.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepository extends JpaRepository<User,Integer> {
}
