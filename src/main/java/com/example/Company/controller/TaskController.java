package com.example.Company.controller;

import java.util.List;

import com.example.Company.request.TaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Company.entity.Task;
import com.example.Company.service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping
	public Task createTask(@RequestBody TaskRequest taskRequest){
		return taskService.createTask(taskRequest);
	}
	
	@GetMapping
	public List<Task> getAllTask(){
		return taskService.getAllTask();
	}
	
	@GetMapping("/{taskId}")
	public Task getTaskById(@PathVariable Long taskId){
		return taskService.getTaskById(taskId);
	}
	
	@PutMapping("/{taskId}")
	public Task updateTask(@PathVariable Long taskId, @RequestBody Task task) {
		task.setTaskId(taskId);
		return taskService.updateTask(taskId,task);
	}
	
	@DeleteMapping("/{taskId}")
	public String deleteTask(@PathVariable Long taskId){
		return taskService.deleteTask(taskId);
	}

}
