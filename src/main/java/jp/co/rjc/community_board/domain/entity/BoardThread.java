package jp.co.rjc.community_board.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class BoardThread implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String createdUser;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(nullable = false)
    private String updateUser;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(nullable = false)
    private boolean deleteFlg;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BoardThreadComment> boardThreadCommentList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isDeleteFlg() {
        return deleteFlg;
    }

    public void setDeleteFlg(boolean deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    public List<BoardThreadComment> getBoardThreadCommentList() {
        return boardThreadCommentList;
    }

    public void setBoardThreadCommentList(List<BoardThreadComment> boardThreadCommentList) {
        this.boardThreadCommentList = boardThreadCommentList;
    }

}
