package com.jsdx.restful;

import com.jsdx.user.User;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Restful client Demo
 * Created with IDEA
 * USER:ckzippo
 * Date:11/30/16
 * TIME:9:31 AM
 */
public class RestfulClientTest {

    private static final String REST_SERVICE_URL = "http://localhost:8080/api";

    /**
     * Get 所有用户
     */
    private static void listAllUsers() {
        System.out.println("====list all users=====");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> userMap = restTemplate.getForObject(REST_SERVICE_URL + "/user/", List.class);

        if (userMap != null) {
            for (LinkedHashMap<String, Object> map :
                    userMap) {
                System.out.println("User: id = " + map.get("id") + " userName: "
                        + map.get("userName") + " password : " + map.get("password")
                        + " mobile: " + map.get("mobile") + " email: " + map.get("email"));
            }
        } else {
            System.out.println("no user exist");
        }
    }

    /**
     * 根据ID获取用户信息
     * @param id
     */
    private static void getUser(int id) {
        System.out.println("===get user by id===");
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(REST_SERVICE_URL + "/user/" + String.valueOf(id), User.class);
        System.out.println(user);
    }

    /**
     * 新增用户
     * @param user
     */
    private static void createUser(User user) {
        System.out.println("====create user=====");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation(REST_SERVICE_URL + "/user/", user, User.class);
    }

    /**
     * 更新用户
     * @param id
     * @param user
     */
    private static void updateUser(int id, User user) {
        System.out.println("====update user====");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(REST_SERVICE_URL + "/user/" + String.valueOf(id), user);
    }
    /**
     * 根据ID删除用户
     * @param id
     */
    private static void deleteUser(int id) {
        System.out.println("====delete user====");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URL + "/user/" + String.valueOf(id));
    }

    public static void main(String[] args) {
        listAllUsers();
        getUser(19);
        User user = new User();
        user.setUserName("111");
        user.setPassword("wowowo");
        user.setEmail("456@789.com");
        user.setMobile("1234567890");
       // createUser(user);
        updateUser(5, user);
        deleteUser(16);
    }
}
