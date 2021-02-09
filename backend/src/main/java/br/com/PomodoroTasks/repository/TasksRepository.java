package br.com.PomodoroTasks.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.PomodoroTasks.model.Tasks;

public interface TasksRepository extends CrudRepository<Tasks, Long>{

}
