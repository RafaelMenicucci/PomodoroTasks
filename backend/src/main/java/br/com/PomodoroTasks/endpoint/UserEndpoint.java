package br.com.PomodoroTasks.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.PomodoroTasks.model.Tasks;
import br.com.PomodoroTasks.model.User;
import br.com.PomodoroTasks.repository.TasksRepository;
import br.com.PomodoroTasks.repository.UserRepository;

@RestController
@RequestMapping("/")
@CrossOrigin
public class UserEndpoint {

	private final UserRepository userDAO;
	private final TasksRepository taskDAO;
	
	@Autowired
	public UserEndpoint (UserRepository userDAO, TasksRepository taskDAO) {
		this.userDAO = userDAO;
		this.taskDAO = taskDAO;
	}
	
	@RequestMapping("register")
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody User user){
		return new ResponseEntity<>(userDAO.save(user), HttpStatus.CREATED);
	}
	
	@GetMapping("users")
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(userDAO.findAll(), HttpStatus.OK);
	}

	
	@PostMapping("tasks")
	public ResponseEntity<?> saveTasks(@RequestBody Tasks task){
		return new ResponseEntity<>(taskDAO.save(task), HttpStatus.CREATED);
	}
	
	@GetMapping("tasks")
	public ResponseEntity<?> listAllTasks(){
		return new ResponseEntity<>(taskDAO.findAll(), HttpStatus.OK);
	}
}
