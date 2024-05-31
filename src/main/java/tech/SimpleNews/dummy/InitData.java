package tech.SimpleNews.dummy;


import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tech.SimpleNews.domain.Post;
import tech.SimpleNews.domain.User;
import tech.SimpleNews.domain.UserApply;
import tech.SimpleNews.repository.PostRepository;
import tech.SimpleNews.repository.UserApplyRepository;
import tech.SimpleNews.repository.UserRepository;

import java.time.LocalDateTime;

import static tech.SimpleNews.constant.Category.*;
import static tech.SimpleNews.constant.Status.PENDING;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitData {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final UserApplyRepository userApplyRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void initData() {
// User 더미 데이터 생성
        User user1 = User.builder().nickname("nickname1").username("user1").password("password1").build();
        User user2 = User.builder().nickname("nickname2").username("user2").password("password2").build();
        User user3 = User.builder().nickname("nickname3").username("user3").password("password3").build();
        User user4 = User.builder().nickname("nickname4").username("user4").password("password4").build();
        User user5 = User.builder().nickname("nickname5").username("user5").password("password5").build();

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);

        // 첫 번째 포스트
        Post firstPost = Post.builder()
                .user(user1)
                .title("강아지 초코 산책시켜 주실분 찾아요!")
                .content("지나가는 사람들 보면 짖고 달려들어요, 다른 보행자 분들 물지 않게 조심해주세요.")
                .createdAt(LocalDateTime.now())
                .requestAt(LocalDateTime.now())
                .locationX(37.3401906)
                .locationY(126.7335293)
                .address("경기도 시흥시 산기대학로 237")
                .status(PENDING)
                .category(WALK)
                .build();

        postRepository.save(firstPost);

        // UserApply 데이터 추가
        UserApply userApply1 = UserApply.builder()
                .user(user4)
                .post(firstPost)
                .build();

        userApplyRepository.save(userApply1);

// 두 번째 포스트

        Post secondPost = Post.builder()
                .user(user2)
                .title("잠깐 집에 있는 뽀삐 밥좀 챙겨주세요")
                .content("겁이 많은 성격이라 사료만 챙겨주세요. 도착하면 연락 주세요")
                .createdAt(LocalDateTime.now())
                .requestAt(LocalDateTime.now())
                .locationX(37.34443782447168)
                .locationY(126.74228070048451)
                .address("경기도 시흥시 정왕동 1619-3")
                .status(PENDING)
                .category(FEED)
                .build();

        postRepository.save(secondPost);

        // UserApply 데이터 추가
        UserApply userApply2 = UserApply.builder()
                .user(user5)
                .post(secondPost)
                .build();

        userApplyRepository.save(userApply2);

// 세 번째 포스트


        Post thirdPost = Post.builder()
                .user(user3)
                .title("강아지 밍키 화장실 청소 부탁해요")
                .content("강아지 배변판 청소해주시면 정말 감사하겠습니다. 배변패드는 새로 채워주세요.")
                .createdAt(LocalDateTime.now())
                .requestAt(LocalDateTime.now())
                .locationX(37.343491048500134)
                .locationY(126.74331603316426)
                .address("경기도 시흥시 정왕동 1594-7번지")
                .status(PENDING)
                .category(CARE)
                .build();

        postRepository.save(thirdPost);
        // UserApply 데이터 추가
        UserApply userApply3 = UserApply.builder()
                .user(user4)
                .post(secondPost)
                .build();

        userApplyRepository.save(userApply3);

// 네 번째 포스트
        Post fourthPost = Post.builder()
                .user(user4)
                .title("강아지 밤비 산책 부탁드려요")
                .content("평소 산책시간에 같이 가주실분 찾습니다. 시간 조율 가능합니다.")
                .createdAt(LocalDateTime.now())
                .requestAt(LocalDateTime.now())
                .locationX(37.34250623304749)
                .locationY(126.74244347706808)
                .address("대한민국 시흥시 대우아파트")
                .status(PENDING)
                .category(WALK)
                .build();

        postRepository.save(fourthPost);

// 다섯 번째 포스트

        Post fifthPost = Post.builder()
                .user(user5)
                .title("강아지 폼이 먹이 주실분")
                .content("우리 폼이에게 하루 두 번 사료 주실 분 구합니다. 3일동안 해외여행을 가서요")
                .createdAt(LocalDateTime.now())
                .requestAt(LocalDateTime.now())
                .locationX(37.34205937473149)
                .locationY(126.73797622084818)
                .address("경기도 시흥시 목감동 789-10")
                .status(PENDING)
                .category(FEED)
                .build();

        postRepository.save(fifthPost);

    }
}
