package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Follow;

/**
 * @author Hansong Y
 *
 * Dao (DB 연결, 트랜잭션등의 관리, SQL 실행결과를  자바객체로 변환 ResultSet과 동일)
 */
@Repository
@Transactional
public interface FollowRepository extends JpaRepository<Follow, Integer> {
    @Query("SELECT DISTINCT x FROM User x LEFT JOIN FETCH x.follows f WHERE x.username <> ?1 ORDER BY x.username")
    List<Follow> findAllOrderByName(String username);

    @Query("SELECT x FROM Follow x ORDER BY x.id")
    Page<Follow> findAllOrderByName(Pageable pageable);
    @Modifying
    @Query("DELETE FROM Follow x WHERE x.follower_id = ?1 and x.followed_id = ?2")
    void deleteFollow_id(String follower_id, String followed_id);
    
    
}

