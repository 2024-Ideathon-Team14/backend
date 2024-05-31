package tech.SimpleNews.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.SimpleNews.domain.User;
import tech.SimpleNews.dto.request.JoinDto;
import tech.SimpleNews.dto.request.LoginDto;
import tech.SimpleNews.dto.response.ResLoginDto;
import tech.SimpleNews.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResLoginDto doJoin(JoinDto joinDto){
        User newUser = User.builder()
            .nickname(joinDto.getNickname())
            .username(joinDto.getUsername())
            .password(joinDto.getPassword())
            .build();

        userRepository.save(newUser);

        User user = userRepository.findByUsername(joinDto.getUsername()).get();
        return new ResLoginDto(user.getId(), user.getNickname());
    }

    public ResLoginDto doLogin(LoginDto loginDto){
        User user = userRepository.findByUsername(loginDto.getUsername()).get();
        return new ResLoginDto(user.getId(), user.getNickname());
    }
}
