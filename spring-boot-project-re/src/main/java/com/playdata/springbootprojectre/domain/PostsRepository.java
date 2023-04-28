package com.playdata.springbootprojectre.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //쓰면 CRUD 메서드를 자동 제공
public interface PostsRepository extends JpaRepository<Posts,Long> {
}
