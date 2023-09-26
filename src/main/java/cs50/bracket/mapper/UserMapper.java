package cs50.bracket.mapper;

import cs50.bracket.controller.request.UserRequest;
import cs50.bracket.controller.response.UserResponse;
import cs50.bracket.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(UserRequest userRequest) {
        return new User(userRequest.getLogin(), userRequest.getPassword());
    }

    public UserResponse toUserResponse(User user){
        return new UserResponse(user.getId(), user.getLogin());
    }
}
