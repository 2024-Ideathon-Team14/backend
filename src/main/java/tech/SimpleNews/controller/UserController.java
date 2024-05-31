package tech.SimpleNews.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.SimpleNews.dto.request.JoinDto;
import tech.SimpleNews.dto.request.LoginDto;
import tech.SimpleNews.dto.response.ResLoginDto;
import tech.SimpleNews.service.UserService;

@Tag(name = "User", description = "유저 회원가입 및 로그인 페이지 관련 API 입니다.")
@CrossOrigin
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(
        summary = "회원가입", description = "회원가입"
    )
    @ApiResponse(
        responseCode = "200", description = "정상 회원가입 완료"
    )
    @PostMapping("/join")
    public ResponseEntity<ResLoginDto> join(@RequestBody JoinDto joinDto){
        ResLoginDto resLoginDto = userService.doJoin(joinDto);
        return ResponseEntity.ok().body(resLoginDto);
    }

    @Operation(
        summary = "로그인", description = "로그인"
    )
    @ApiResponse(
        responseCode = "200", description = "정상 로그인 완료"
    )
    @PostMapping("/login")
    public ResponseEntity<ResLoginDto> login(@RequestBody LoginDto loginDto){
        ResLoginDto resLoginDto = userService.doLogin(loginDto);
        return ResponseEntity.ok().body(resLoginDto);
    }
}
