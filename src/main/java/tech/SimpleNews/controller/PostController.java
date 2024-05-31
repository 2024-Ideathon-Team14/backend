package tech.SimpleNews.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.SimpleNews.dto.request.AddPostDto;
import tech.SimpleNews.dto.response.ResPostDto;
import tech.SimpleNews.dto.response.ResPostListDto;
import tech.SimpleNews.service.PostService;

@Tag(name = "Post", description = "메인 페이지 관련 API 입니다.")
@CrossOrigin
@RestController
@RequestMapping("/api/{userId}/post")
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
    public ResponseEntity<?> addPost(@PathVariable("userId") Long userId, AddPostDto addPostDto){
        postService.add(userId,addPostDto);
        return ResponseEntity.ok().body(null);
    }

    @Operation(
        summary = "유저 주변 게시글 리스트", description = "유저 주변의 게시글을 반환한다."
    )
    @ApiResponse(
        responseCode = "200", description = "게시글 리스트 정상 반환"
    )
    @GetMapping
    public ResponseEntity<ResPostListDto> allPostNearByUser(@PathVariable("userId") Long userId){

        return ResponseEntity.ok().body(new ResPostListDto());
    }

    @Operation(
        summary = "게시글 상세 보기", description = "게시글 상세 보기"
    )
    @ApiResponse(
        responseCode = "200", description = "게시글 상세 정보 정상 반환"
    )
    @GetMapping("/{postId}")
    public ResponseEntity<ResPostDto> detailPost(@PathVariable("userId") Long userId, @PathVariable("postId") Long postId){
        return ResponseEntity.ok().body(new ResPostDto());
    }


    @Operation(
        summary = "게시글 삭제", description = "게시글 삭제"
    )
    @ApiResponse(
        responseCode = "200", description = "게시글 정상 삭제 완료"
    )
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable("userId") Long userId, @PathVariable("postId") Long postId){

        return ResponseEntity.ok().body(null);
    }

    @Operation(
        summary = "게시글 상태 변경", description = "게시글 작성자가 게시글의 상태를 변경한다 \n PENDING(미요청) \n IN_PROGRESS(요청진행중) \n COMPLETED(요청완료)"
    )
    @ApiResponse(
        responseCode = "200", description = "게시글 상세 정보 정상 반환"
    )
    @PostMapping("/{postId}/apply")
    public ResponseEntity<?> applyPost(@PathVariable("userId") Long userId, @PathVariable("postId") Long postId){

        return ResponseEntity.ok().body(null);
    }
}
