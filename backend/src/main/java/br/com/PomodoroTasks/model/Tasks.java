package br.com.PomodoroTasks.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
public class Tasks extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	@NotEmpty
	private String description;
	@NotNull
	private int priority;
	
	
	public Tasks() {
		
	}
	public Tasks(@NotEmpty String description, @NotNull int priority) {
		super();
		this.description = description;
		this.priority = priority;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
}
