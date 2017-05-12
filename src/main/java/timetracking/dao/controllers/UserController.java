package timetracking.dao.controllers;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import timetracking.dao.repositories.ProjectRepository;
import timetracking.dao.repositories.UserRepository;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/search/existsByLogin", method = RequestMethod.GET)
    public ResponseEntity savePerson(@Param("login") String login) {
        ObjectNode json = JsonNodeFactory.instance.objectNode();
        json.put("isExist", userRepository.existsByLogin(login));

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

}