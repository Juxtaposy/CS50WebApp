package cs50.bracket.mapper;

import cs50.bracket.controller.request.UserRegister;
import cs50.bracket.controller.response.UserResponse;
import cs50.bracket.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(UserRegister userRegister) {
        return new User(userRegister.getLogin(), userRegister.getPassword());
    }

    public UserResponse toUserResponse(User user){
        return new UserResponse(user.getId(), user.getLogin());
    }
}
