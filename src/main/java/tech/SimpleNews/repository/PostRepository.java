package tech.SimpleNews.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.SimpleNews.domain.Post;
import tech.SimpleNews.domain.User;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    Optional<Post> findByUserAndTitle(User user, String title);
    Optional<Post> findByIdAndUser(Long postId, User user);
}
