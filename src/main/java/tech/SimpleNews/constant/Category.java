package tech.SimpleNews.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    WALK("먹이주기"),
    FEED("산책"),
    CARE("돌봄");

    private final String name;
}
