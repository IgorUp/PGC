package controller;

import controller.dto.Response;
import controller.dto.UserShortDto;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 20.11.16.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Response<User>> userGet(@PathVariable Long id) {
        User user = userService.get(id);
        return ResponseEntity.ok(Response.success(user));
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.POST)
    @ResponseBody
    private ResponseEntity userPost(@RequestBody User user) {
        userService.create(user);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.PUT)
    @ResponseBody
    private ResponseEntity userPut(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        userService.update(user);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.DELETE)
    @ResponseBody
    private ResponseEntity userDel(@RequestBody User user) {
        userService.delete(user);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Response<List<User>>> roleList() {
        List<User> list = userService.list();
        return ResponseEntity.ok(Response.success(list));
    }

    @RequestMapping(value = "/api/usersinfo", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Response<List<UserShortDto>>> roleDtoList() {
        List<User> users = userService.list();
        if (users != null) {
            List<UserShortDto> list = new ArrayList<UserShortDto>(users.size());
            for (User user : users) {
                list.add(new UserShortDto(user));
            }

            return ResponseEntity.ok(Response.success(list));
        }
        return new ResponseEntity(Response.error("Nothing found"), HttpStatus.NOT_FOUND);
    }

}
