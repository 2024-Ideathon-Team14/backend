package tech.SimpleNews.dummy;


import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tech.SimpleNews.repository.PostRepository;
import tech.SimpleNews.repository.UserRepository;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitData {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void initData(){

    }
}
