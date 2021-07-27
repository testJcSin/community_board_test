package jp.co.rjc.community_board.service;

import jp.co.rjc.community_board.domain.entity.User;
import jp.co.rjc.community_board.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserService implements UserDetailsService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;


    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException, RuntimeException {
        if (username.equals("")) {
            throw new RuntimeException("Username is empty");
        }

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found: " + username);
        }

        return user;
    }

    @Transactional
    public void reg1(String username, String password, String mailAddress) {
        log.info("user: {}, password: {}, mail: {}", username, password, mailAddress);
        User user = new User(username, passwordEncoder.encode(password), mailAddress);
        user.setAdmin(true);
        userRepository.save(user);
    }

    @Transactional
    public void reg2(String username, String password, String mailAddress) {
        log.info("user: {}, password: {}, mail: {}", username, password, mailAddress);

        User userCheck = userRepository.findByUsername(username);
        // ユーザーID重複チェック
        if (userCheck != null) {
            return;
        }

        User user = new User(username, passwordEncoder.encode(password), mailAddress);
        userRepository.save(user);
    }

}
