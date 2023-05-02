package com.playdata.springbootprojectre.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //쓰면 CRUD 메서드를 자동 제공
public interface PostsRepository extends JpaRepository<Posts,Long> { //필요한 메서드를 만들어 주기 때문에 인터페이스로 남음
}
