package jp.co.rjc.community_board.domain.repository;

import jp.co.rjc.community_board.domain.entity.BoardThread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardThreadRepository extends JpaRepository<BoardThread, Long> {

}
