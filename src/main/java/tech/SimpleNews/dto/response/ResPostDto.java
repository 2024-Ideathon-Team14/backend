package tech.SimpleNews.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.SimpleNews.constant.Status;
import tech.SimpleNews.domain.Post;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResPostDto {

    private String nickname;
    private String title;
    private String content;
    private String category;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime requestAt;
    private String address;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    public ResPostDto(Post post) {
        this.nickname = post.getUser().getNickname();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.category = post.getCategory().getName();
        this.createdAt = post.getCreatedAt();
        this.requestAt = post.getRequestAt();
        this.address = post.getAddress();
        this.status = post.getStatus();
    }
}
