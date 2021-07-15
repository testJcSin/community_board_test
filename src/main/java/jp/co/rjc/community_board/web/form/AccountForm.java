package jp.co.rjc.community_board.web.form;

import org.springframework.stereotype.Component;

@Component
public class AccountForm {

	private String username;

	private String mailAddress;

	private String password;

	public String getUsername() {
        return username;
    }

	public void setUsername(String username) {
        this.username = username;
    }

	public String getMailAddress() {
        return mailAddress;
    }

	public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

	public String getPassword() {
        return password;
    }

	public void setPassword(String password) {
        this.password = password;
    }

}
