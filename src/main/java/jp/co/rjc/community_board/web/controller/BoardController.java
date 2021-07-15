package jp.co.rjc.community_board.web.controller;

import jp.co.rjc.community_board.domain.entity.BoardThread;
import jp.co.rjc.community_board.service.BoardService;
import jp.co.rjc.community_board.web.form.BoardThreadCommentForm;
import jp.co.rjc.community_board.web.form.BoardThreadForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "")
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/board/")
    public String list(Model model) {
        List<BoardThread> boardThreadList = boardService.getBoardThreadList();
        model.addAttribute("boardThreadList", boardThreadList);
        return "board/list";
    }

    @RequestMapping(value = "/board/thread/create/")
    public String threadCreate(BoardThreadForm boardThreadForm) {
        boardService.addBoardThread(boardThreadForm);
        return "redirect:/board/";
    }

    @RequestMapping(value = "/board/thread/delete/{threadId}/")
    public String threadDelete(@PathVariable("threadId") Long threadId) {
        boardService.deleteBoardThread(threadId);
        return "redirect:/board/";
    }

    @RequestMapping(value = "/board/thread/{threadId}/comment/create/")
    public String commentCreate(@PathVariable("threadId") Long threadId,
                                BoardThreadCommentForm boardThreadCommentForm) {
        boardService.addBoardThreadComment(threadId, boardThreadCommentForm);
        return "redirect:/board/";
    }

    @RequestMapping(value = "/board/thread/{threadId}/comment/delete/{threadCommentId}/")
    public String commentDelete(@PathVariable("threadId") Long threadId,
                                @PathVariable("threadCommentId") Long threadCommentId) {
        boardService.deleteBoardThreadComment(threadCommentId);
        return "redirect:/board/";
    }

}
