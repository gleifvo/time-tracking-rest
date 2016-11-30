package timetracking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import timetracking.dao.models.User;
import timetracking.dao.repositories.UserRepository;

@Controller
@RequestMapping("/test")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public User test() {
        return userRepository.findByLogin("login");
    }
}