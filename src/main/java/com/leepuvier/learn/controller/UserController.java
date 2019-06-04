package com.leepuvier.learn.controller;

import com.leepuvier.learn.entry.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getUserList(){

        return new ArrayList<User>(users.values());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user){
        users.put(user.getId(), user);
        return "Add User Success";
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Integer id){
        return users.get(id);
    }

    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
    public String updateUserById(@PathVariable Integer id, @ModelAttribute User user){
        User info = users.get(id);
        info.setNickname(user.getNickname());
        info.setCity(user.getCity());
        users.put(id, info);
        return "Update User Info Success";
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public String deleteUserById(@PathVariable Integer id){
        users.remove(id);
        return "Delete User Info Success";
    }
}
