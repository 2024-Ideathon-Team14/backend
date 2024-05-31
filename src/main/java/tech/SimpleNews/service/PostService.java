package tech.SimpleNews.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.SimpleNews.constant.Status;
import tech.SimpleNews.domain.Post;
import tech.SimpleNews.domain.User;
import tech.SimpleNews.domain.UserApply;
import tech.SimpleNews.dto.request.AddPostDto;
import tech.SimpleNews.dto.request.UserLocaDto;
import tech.SimpleNews.dto.response.ResAddPostDto;
import tech.SimpleNews.dto.response.ResPostDto;
import tech.SimpleNews.dto.response.ResPostListDto;
import tech.SimpleNews.repository.PostRepository;
import tech.SimpleNews.repository.UserApplyRepository;
import tech.SimpleNews.repository.UserRepository;
import tech.SimpleNews.util.NaverApiUtils;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final UserApplyRepository userApplyRepository;
//    private final NaverApiUtils naverApiUtils;
    //+ naver api 서비스 로직

    public ResAddPostDto add(Long userId, AddPostDto addPostDto){
        Post newPost = Post.builder()
            .user(userRepository.findById(userId).get())
            .title(addPostDto.getTitle())
            .content(addPostDto.getContent())
            .createdAt(LocalDateTime.now())
            .requestAt(addPostDto.getRequestAt())
            .longitude(addPostDto.getLongitude())
            .latitude(addPostDto.getLatitude())
            .address("test address")
            .status(Status.PENDING)
            .build();

        postRepository.save(newPost);
        Post post = postRepository.findByUserAndTitle(userRepository.findById(userId).get(),
            addPostDto.getTitle()).get();

        return new ResAddPostDto(post.getId());
    }

    public ResPostListDto allPostNearByUser(Long userId, UserLocaDto userLocaDto){
        //naver api 로직
        //...
        ResPostListDto resPostListDto = new ResPostListDto(new ArrayList<>());
        postRepository.findAll().forEach(
            post -> {
                resPostListDto.getResPostDtoList().add(
                    new ResPostDto(
                        post
                    )
                );
            }
        );
        return resPostListDto;
    }

    public ResPostDto detailPost(Long userId, Long postId){
        Post post = postRepository.findById(postId).get();
        return new ResPostDto(post);
    }

    public void deletePost(Long userId, Long postId){
        Optional<Post> optionalPost = postRepository.findByIdAndUser(postId,
            userRepository.findById(userId).get());
        if(optionalPost.isPresent()){
            postRepository.deleteById(optionalPost.get().getId());
        }
    }

    public void applyPost(Long userId, Long postId){
        User user = userRepository.findById(userId).get();
        Post post = postRepository.findById(postId).get();
        UserApply newUserApply = UserApply.builder()
            .user(user)
            .post(post)
            .build();
        userApplyRepository.save(newUserApply);
    }
}
