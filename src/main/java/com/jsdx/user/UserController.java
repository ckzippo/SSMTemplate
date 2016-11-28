package com.jsdx.user;

import com.jsdx.base.BaseController;
import com.jsdx.base.PageEntity;
import com.jsdx.base.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Max on 2016/10/17.
 */
@Controller
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "main/index.jsp";
    }

    @RequestMapping("/user/list")
    public String list(@RequestParam(required = false) Integer page, Model model) {
        PageEntity pageEntity = new PageEntity(page);
        PagingResult<User> results = userService.selectPagination(pageEntity);
        setListPageModel(model, results);
        return "user/user_list.jsp";
    }

    @RequestMapping("/user/add")
    public String add() {
        return "user/user_edit.jsp";
    }

    @RequestMapping("/user/update")
    public String update(@RequestParam Integer id, Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "user/user_edit.jsp";
    }

    @RequestMapping("/user/delete")
    public void delete(@RequestParam Integer id, HttpServletResponse response) {
        userService.delete(id);
        try {
            response.sendRedirect("list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/user/save")
    public void save(@ModelAttribute("user") User user, HttpServletResponse response) {
        boolean result;
        if (user.getId() != null && user.getId() != 0) {
            result = userService.update(user);
        } else {
            result = userService.insert(user);
        }
        try {
            response.sendRedirect("list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
