package cs50.bracket.controller;

import cs50.bracket.controller.request.UserLogin;
import cs50.bracket.controller.request.UserRegister;
import cs50.bracket.controller.response.UserResponse;
import cs50.bracket.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/user")
public class UserApi {

    private final UserService userService;

    UserApi(UserService userService) { this.userService = userService; }
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRegister userRegister){
        UserResponse userResponse = userService.registerUser(userRegister);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody UserLogin userLogin){
        UserResponse userResponse = userService.loginUser(userLogin);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userResponse);
    }

}
