package tech.SimpleNews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.SimpleNews.domain.UserApply;

@Repository
public interface UserApplyRepository extends JpaRepository<UserApply,Long> {

}
