package cs50.bracket.service;

import cs50.bracket.controller.request.BracketRequest;
import cs50.bracket.controller.response.BracketResponse;
import cs50.bracket.domain.Bracket;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse create(Userequest userRequest){
        User user = userRepository.save(userMapper.toUser(userRequest));
        return userMapper.toUserResponse(user);
    }
}
