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
import timetracking.dao.repositories.TaskRepository;

@RestController
@RequestMapping("/api/tasks/")
public class TaskController {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @RequestMapping(value = "/search/existsByName", method = RequestMethod.GET)
    public ResponseEntity existByName(@Param("name") String name) {
        ObjectNode json = JsonNodeFactory.instance.objectNode();
        json.put("isExist", taskRepository.existsByName(name));

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

}