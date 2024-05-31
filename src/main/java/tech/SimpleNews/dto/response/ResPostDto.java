package tech.SimpleNews.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.SimpleNews.constant.Status;

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
}
