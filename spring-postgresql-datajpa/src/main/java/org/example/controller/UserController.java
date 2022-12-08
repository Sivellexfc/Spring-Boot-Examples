package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.entitiy.User;
import org.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping
    public ResponseEntity<UserDto> kaydet(@RequestBody UserDto userdto){
        return ResponseEntity.ok(userService.save(userdto));
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> listAll(){
        return ResponseEntity.ok(userService.getAll());
    }
}
