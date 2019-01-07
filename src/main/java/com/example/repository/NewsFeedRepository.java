package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Post;

/**
 * @author Hansong Y
 *
 * Dao (DB 연결, 트랜잭션등의 관리, SQL 실행결과를  자바객체로 변환 ResultSet과 동일)
 */
@Repository
@Transactional
public interface NewsFeedRepository extends JpaRepository<Post, Integer> {
    @Query("SELECT DISTINCT x FROM Post x LEFT JOIN FETCH x.follow f WHERE f.follower_id = ?1")
    List<Post> findAllOrderByName(String follower_id);

    @Query("SELECT x FROM Post x ORDER BY x.id")
    Page<Post> findAllOrderByName(Pageable pageable);
}

