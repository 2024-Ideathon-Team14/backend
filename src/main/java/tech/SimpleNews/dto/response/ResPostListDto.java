package tech.SimpleNews.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResPostListDto {
    private List<ResPostDto> resPostDtoList;
}
