package kr.sfox.alpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.sfox.alpha.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
