package kim.jiho.jpa.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kim.jiho.jpa.api.service.UserService;
import kim.jiho.jpa.db.entity.User;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 전체 사용자를 검색한다.
     * @return JSON으로 변환된 모든 User List
     */
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
 
    /**
     * userPID를 통해 사용자를 검색한다.
     * @param userPID
     * @return
     */
    @GetMapping(value = "/{userPID}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<User> getUser(@PathVariable("userPID") Long userPID) {
        Optional<User> user = userService.findById(userPID);
        return new ResponseEntity<User>(user.get(), HttpStatus.OK);
    }
 
    /**
     * userPID를 통해 사용자를 삭제한다.
     * @param userPID
     * @return
     */
    @DeleteMapping(value = "/{userPID}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteUser(@PathVariable("userPID") Long userPID) {
        userService.deleteById(userPID);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
 
    /**
     * userPID를 통해 사용자 정보를 수정한다.
     * User 객체의 password와 name을 수정한다.
     * @param userPID
     * @param user
     * @return
     */
    @PutMapping(value = "/{userPID}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<User> updateMember(@PathVariable("userPID") Long userPID, User user) {
        userService.updateById(userPID, user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
 
    /**
     * 새로운 사용자를 등록한다.
     * @param user
     * @return 등록된 사용자의 정보
     */
    @PostMapping
    public ResponseEntity<User> save(User user) {
        return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
    }

}
