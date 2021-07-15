package jp.co.rjc.community_board.domain.repository;

import jp.co.rjc.community_board.domain.entity.BoardThreadComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardThreadCommentRepository extends JpaRepository<BoardThreadComment, Long> {

}
