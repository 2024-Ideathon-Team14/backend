package tech.SimpleNews.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResLoginDto {
    private Long userId;
    private String nickname;
}
