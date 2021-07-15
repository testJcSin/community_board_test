package jp.co.rjc.community_board.web.form;

import org.springframework.stereotype.Component;

@Component
public class BoardThreadCommentForm {

    private String comments;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
