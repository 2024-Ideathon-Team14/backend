package tech.SimpleNews.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLocaDto {
    private double longitude;
    private double latitude;
}
