package com.jsdx.restful;

import com.jsdx.user.User;
import com.jsdx.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Restful风格的接口调用示例
 * Created with IDEA
 * USER:ckzippo
 * Date:11/29/16
 * TIME:3:36 PM
 */
@RestController
@RequestMapping("/api")
public class RestfulController {
    @Autowired
    UserService userService;

    /**
     * 获取所有user
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public ResponseEntity<List<User>> getUsers() {
        List<User> userList =  userService.select();
        if (userList.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
        }
    }

    /**
     * 根据ID获取用户
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        User user = userService.get(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
    }

    /**
     * 插入一个用户
     * @param user
     * @param uriComponentsBuilder
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder) {
        if(userService.insert(user)) {
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    /**
     * 根据ID, 更新用户信息
     * @param id
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        User current =  userService.get(id);
        if (current == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        current.setUserName(user.getUserName());
        current.setPassword(user.getPassword());
        current.setMobile(user.getMobile());
        current.setEmail(user.getEmail());

        if (userService.update(current)) {
            return new ResponseEntity<User>(current, HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
        User user = userService.get(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        if (userService.delete(id)) {
            return new ResponseEntity<User>(HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
    }
}
