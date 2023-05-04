package com.playdata.springbootprojectre.domain.posts;

import com.playdata.springbootprojectre.web.dto.PostsListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //쓰면 CRUD 메서드를 자동 제공
public interface PostsRepository extends JpaRepository<Posts,Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc(); //필요한 메서드를 만들어 주기 때문에 인터페이스로 남음
}
