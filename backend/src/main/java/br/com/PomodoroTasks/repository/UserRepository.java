package br.com.PomodoroTasks.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.PomodoroTasks.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	User findByUsername(String username);
}
