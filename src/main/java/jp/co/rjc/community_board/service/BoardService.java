package jp.co.rjc.community_board.service;

import jp.co.rjc.community_board.domain.entity.BoardThread;
import jp.co.rjc.community_board.domain.entity.BoardThreadComment;
import jp.co.rjc.community_board.domain.repository.BoardThreadCommentRepository;
import jp.co.rjc.community_board.domain.repository.BoardThreadRepository;
import jp.co.rjc.community_board.web.form.BoardThreadCommentForm;
import jp.co.rjc.community_board.web.form.BoardThreadForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    public BoardThreadRepository boardThreadRepository;
    @Autowired
    public BoardThreadCommentRepository boardThreadCommentRepository;

    public List<BoardThread> getBoardThreadList() {
        List<BoardThread> boardThreadList = boardThreadRepository.findAll();
        List<BoardThreadComment> boardThreadCommentList = boardThreadCommentRepository.findAll();

        for (BoardThread boardThread : boardThreadList) {
            for (BoardThreadComment boardThreadComment : boardThreadCommentList) {
                if (boardThread.equals(boardThreadComment.getBoardThread())) {
                    boardThread.getBoardThreadCommentList().add(boardThreadComment);
                }
            }
        }
        return boardThreadList;
    }
    public void addBoardThread(BoardThreadForm boardThreadForm) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        BoardThread boardThread = new BoardThread();
        boardThread.setTitle(boardThreadForm.getTitle());
        boardThread.setContents(boardThreadForm.getContents());
        boardThread.setCreatedUser(userDetails.getUsername());
        boardThread.setCreatedAt(new Date());
        boardThread.setDeleteFlg(false);
        boardThreadRepository.save(boardThread);
    }

    public void deleteBoardThread(Long threadId) {
        Optional<BoardThread> boardThread = boardThreadRepository.findById(threadId);
        if (!boardThread.isPresent()) {
            throw new RuntimeException("エラーが発生しました");
        }
        boardThreadCommentRepository.deleteAll(boardThread.get().getBoardThreadCommentList());
        boardThreadRepository.deleteById(threadId);
    }

    public void addBoardThreadComment(Long threadId, BoardThreadCommentForm boardThreadCommentForm) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        Optional<BoardThread> boardThread = boardThreadRepository.findById(threadId);
        if (!boardThread.isPresent()) {
            throw new RuntimeException("エラーが発生しました");
        }

        BoardThreadComment boardThreadComment = new BoardThreadComment();
        boardThreadComment.setBoardThread(boardThread.get());
        boardThreadComment.setComments(boardThreadCommentForm.getComments());
        boardThreadComment.setCreatedUser(userDetails.getUsername());
        boardThreadComment.setCreatedAt(new Date());
        boardThreadComment.setDeleteFlg(false);
        boardThreadCommentRepository.save(boardThreadComment);
    }

    public void deleteBoardThreadComment(Long threadCommentId) {
        boardThreadCommentRepository.deleteById(threadCommentId);
    }

}
