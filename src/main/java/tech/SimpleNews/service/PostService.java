package tech.SimpleNews.service;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.SimpleNews.constant.Status;
import tech.SimpleNews.domain.Post;
import tech.SimpleNews.dto.request.AddPostDto;
import tech.SimpleNews.repository.PostRepository;
import tech.SimpleNews.repository.UserApplyRepository;
import tech.SimpleNews.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final UserApplyRepository userApplyRepository;
    //+ naver api 서비스 로직

    public void add(Long userId, AddPostDto addPostDto){
        Post newPost = Post.builder()
            .user(userRepository.findById(userId).get())
            .title(addPostDto.getTitle())
            .content(addPostDto.getContent())
            .createdAt(LocalDateTime.now())
            .requestAt(addPostDto.getRequestAt())
            .locationX(addPostDto.getLocationX())
            .locationY(addPostDto.getLocationY())
            .address("로직을통한 주소추출")
            .status(Status.PENDING)
            .build();

        postRepository.save(newPost);
    }
}
