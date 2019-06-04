package com.leepuvier.learn.controller;

import com.leepuvier.learn.entry.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users/swagger")
public class UserSwaggerController {

    private Map<Integer, User> users = Collections.synchronizedMap( new HashMap<Integer, User>());

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getUserList(){
        return new ArrayList<User>(users.values());
    }

    @ApiOperation(value = "新增用户", notes = "依据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user",required = true, dataType = "User")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
        users.put(user.getId(), user);
        return "Add User Success";
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserInfo(@PathVariable Integer id){
        return users.get(id);
    }

    @ApiOperation(value = "更新用户信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID",required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable Integer id, @RequestBody User user){
        User userInfo = users.get(id);
        userInfo.setUser_id(user.getUser_id());
        userInfo.setNickname(user.getNickname());
        users.put(id, userInfo);
        return "Update User Success";
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer id){
        return "Delete User Success";
    }
}
