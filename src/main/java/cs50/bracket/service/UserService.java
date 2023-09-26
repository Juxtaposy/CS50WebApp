package cs50.bracket.service;

import cs50.bracket.controller.request.UserRequest;
import cs50.bracket.controller.response.UserResponse;
import cs50.bracket.domain.User;
import cs50.bracket.exception.UserPasswordsDoNotMatchException;
import cs50.bracket.mapper.UserMapper;
import cs50.bracket.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse create(UserRequest userRequest){
        if (userRequest.checkPassword()){
            User user = userRepository.save(userMapper.toUser(userRequest));
            return userMapper.toUserResponse(user);
        }
        else {
            throw new UserPasswordsDoNotMatchException();
        }
    }
}
