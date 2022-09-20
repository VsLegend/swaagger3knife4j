package com.example.swagger3knife4j.controller;

import com.example.swagger3knife4j.domain.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.example.swagger3knife4j.constants.PathConstants.PRIVATE_PATH;

/**
 * @Author Wang Junwei
 * @Date 2022/9/20 15:01
 * @Description
 */

@Tag(name = "用户接口")
@RestController
@RequestMapping(PRIVATE_PATH + "/user")
public class UserController {

    @GetMapping("/getOneUser")
    @Operation(summary = "随机获取一个用户")
    public User getOneUser() {
        return new User("姓名", "13899999999");
    }

    @PostMapping("/getOriginUser")
    @Operation(summary = "随机获取一个用户")
    public User getOneUser(@RequestBody User user) {
        return user;
    }

    @GetMapping("/getName/{userName}")
    @Operation(summary = "获取用户名")
    public String getName(@Parameter(required = true, name = "userName", description = "用户名")
                          @PathVariable("userName") String userName) {
        return userName;
    }

}
