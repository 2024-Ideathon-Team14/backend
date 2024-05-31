package tech.SimpleNews.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JoinDto {
    private String nickname;
    private String username;
    private String password;
}
