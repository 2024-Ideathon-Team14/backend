package tech.SimpleNews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.SimpleNews.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

}
