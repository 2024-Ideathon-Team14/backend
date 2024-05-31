package tech.SimpleNews.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.SimpleNews.dto.request.AddPostDto;
import tech.SimpleNews.dto.request.UserLocaDto;
import tech.SimpleNews.dto.response.ResAddPostDto;
import tech.SimpleNews.dto.response.ResPostDto;
import tech.SimpleNews.dto.response.ResPostListDto;
import tech.SimpleNews.service.PostService;
import tech.SimpleNews.util.NaverApiUtils;

@Tag(name = "Post", description = "메인 페이지 관련 API 입니다.")
@CrossOrigin
@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @Operation(
        summary = "게시물 등록", description = "게시물 등록"
    )
    @ApiResponse(
        responseCode = "200", description = "게시물 정상 등록"
    )
    @PostMapping
    public ResponseEntity<ResAddPostDto> addPost(@RequestParam("userId") Long userId, @RequestBody AddPostDto addPostDto){
        ResAddPostDto resAddPostDto = postService.add(userId, addPostDto);
        return ResponseEntity.ok().body(resAddPostDto);
    }

    @Operation(
        summary = "유저 주변 게시글 리스트", description = "유저 주변의 게시글을 반환한다."
    )
    @ApiResponse(
        responseCode = "200", description = "게시글 리스트 정상 반환"
    )
    @GetMapping
    public ResponseEntity<ResPostListDto> allPostNearByUser(@RequestParam("userId") Long userId,@RequestBody UserLocaDto userLocaDto){
        ResPostListDto resPostListDto = postService.allPostNearByUser(userId, userLocaDto);
        return ResponseEntity.ok().body(resPostListDto);
    }

    @Operation(
        summary = "게시글 상세 보기", description = "게시글 상세 보기"
    )
    @ApiResponse(
        responseCode = "200", description = "게시글 상세 정보 정상 반환"
    )
    @GetMapping("/detail")
    public ResponseEntity<ResPostDto> detailPost(@RequestParam("userId") Long userId, @RequestParam("postId") Long postId){
        ResPostDto resPostDto = postService.detailPost(userId, postId);
        return ResponseEntity.ok().body(resPostDto);
    }


    @Operation(
        summary = "게시글 삭제", description = "게시글 삭제"
    )
    @ApiResponse(
        responseCode = "200", description = "게시글 정상 삭제 완료"
    )
    @DeleteMapping("/detail")
    public ResponseEntity<?> deletePost(@RequestParam("userId") Long userId, @RequestParam("postId") Long postId){
        postService.deletePost(userId,postId);
        return ResponseEntity.ok().body(null);
    }

    @Operation(
        summary = "요청 등록", description = "유저가 타인이 올려놓은 문의 게시글에 요청을 보낸다."
    )
    @ApiResponse(
        responseCode = "200", description = "유저의 게시글 정상 요청"
    )
    @PostMapping("/detail/apply")
    public ResponseEntity<?> applyPost(@RequestParam("userId") Long userId, @RequestParam("postId") Long postId){
        postService.applyPost(userId,postId);
        return ResponseEntity.ok().body(null);
    }
}
