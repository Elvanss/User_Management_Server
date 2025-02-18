package com.management.employee.controller;

import com.management.employee.dto.*;
import com.management.employee.dto.LoginReqDTO;
import com.management.employee.dto.LoginResDTO;
import com.management.employee.dto.ResponseDTO;
import com.management.employee.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController extends BaseController {
    private final AccountService accountService;

    public AuthController(AccountService accountService) {
        this.accountService = accountService;
    }

//    @PostMapping("/")
//    public ResponseEntity<ResponseDTO<UserAccountResDTO>> create(@RequestBody UserAccountReqDTO account){
//        UserAccountResDTO res = accountService.create(account);
//        return ResponseEntity.status(res.getStatus()).body(res);
//    }

    @PostMapping("/authenticate")
    public ResponseEntity<ResponseDTO<LoginResDTO>> login(@RequestBody LoginReqDTO account){
        ResponseDTO<LoginResDTO> res = accountService.login(account);
        return ResponseEntity.status(res.getStatus()).body(res);
    }
}
