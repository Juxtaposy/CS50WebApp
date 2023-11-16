package cs50.bracket.service;

import cs50.bracket.controller.request.UserLogin;
import cs50.bracket.controller.request.UserRegister;
import cs50.bracket.controller.response.UserResponse;
import cs50.bracket.domain.User;
import cs50.bracket.exception.UserAlreadyExistsException;
import cs50.bracket.exception.UserDoesNotExistException;
import cs50.bracket.exception.UserPasswordsDoNotMatchException;
import cs50.bracket.exception.UserWrongLoginOrPasswordException;
import cs50.bracket.mapper.UserMapper;
import cs50.bracket.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse registerUser(UserRegister userRegister){

        if (userRepository.findByLogin(userRegister.getLogin()).isEmpty()) {
            if (userRegister.checkPassword()) {
                User user = userRepository.save(userMapper.toUser(userRegister));
                return userMapper.toUserResponse(user);
            } else {
                throw new UserPasswordsDoNotMatchException();
            }
        }
        else {
            throw new UserAlreadyExistsException();
        }
    }

    public UserResponse loginUser(UserLogin userLogin){
        Optional<User> user = userRepository.findByLogin(userLogin.getLogin());
        if (user.isEmpty()){
            throw new UserDoesNotExistException();
        }
        else if (userLogin.getPassword().equals(user.get().getPassword())) {
            return userMapper.toUserResponse(user.get());
        }
        else {
            throw new UserWrongLoginOrPasswordException();
        }
    }
}
