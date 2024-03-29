package com.boot3.controller;

import com.boot3.data.dto.request.UserRecordReqDTO;
import com.boot3.data.dto.request.UserSaveReqDTO;
import com.boot3.data.dto.response.UserDTO;
import com.boot3.data.dto.response.UserRecordDTO;
import com.boot3.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name="User Controller", description="User Controller 구현하기")
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    @Operation(description = "UserList 조회하기")
    public List<UserRecordDTO> userList(){
        return userService.getUserList();
    }


    @GetMapping("/user/{userId}")
    @Operation(description = "특정 사용자 조회하기")
    public UserRecordDTO userInfo(@PathVariable String userId){

        UserRecordReqDTO dto = new UserRecordReqDTO(userId);
        return userService.getUserInfo(dto);
    }

    @GetMapping("/user/{userId}/qdsl")
    @Operation(description = "특정 사용자 조회하기")
    public UserDTO userInfoByQuerydsl(@PathVariable String userId){

        UserRecordReqDTO dto = new UserRecordReqDTO(userId);
        return userService.userInfoByQuerydsl(dto);
    }


    @PostMapping("/user")
    @Operation(description = "사용자 등록하기")
    public void saveUserInfo(@Validated @RequestBody UserSaveReqDTO userSaveReqDTO){
        userService.saveUserInfo(userSaveReqDTO);
    }
}
