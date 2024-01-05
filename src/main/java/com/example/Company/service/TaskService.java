package com.example.Company.service;

import com.example.Company.entity.Employee;
import com.example.Company.entity.Task;
import com.example.Company.repository.EmployeeRepository;
import com.example.Company.repository.TaskRepository;
import com.example.Company.request.TaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Task createTask(TaskRequest taskRequest){

        Task task =new Task();

        Optional<Employee> employee =employeeRepository.findById(taskRequest.getEmployeeId());

        task.setEmployeeMap(employee.get());
        task.setName(taskRequest.getName());
        task.setDescription(taskRequest.getDescription());
        task.setStatus(taskRequest.getStatus());
        task.setCreatedDate(taskRequest.getCreatedDate());
        task.setCreatedUser(taskRequest.getCreatedUser());
        task.setModifiedDate(taskRequest.getModifiedDate());
        task.setModifiedUser(taskRequest.getModifiedUser());

        return taskRepository.save(task);

    }

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long taskId){
        Optional<Task> optionalTask= taskRepository.findById(taskId);
        return optionalTask.get();
    }

    public Task updateTask(Long taskId,Task task){
    //    Task exisitingTask =taskRepository.findById(task.getTaskId()).get();

        Task exisitingTask =taskRepository.findById(taskId).get();

        exisitingTask.setName(task.getName());
        exisitingTask.setDescription(task.getDescription());
        exisitingTask.setStatus(task.getStatus());
        exisitingTask.setCreatedDate(task.getCreatedDate());
        exisitingTask.setCreatedUser(task.getCreatedUser());
        exisitingTask.setModifiedDate(task.getModifiedDate());
        exisitingTask.setModifiedUser(task.getModifiedUser());

        Task updatedTask =taskRepository.save(exisitingTask);

        return updatedTask;
    }

    public String deleteTask(Long taskId){
        Optional<Task> task=taskRepository.findById(taskId);
        if(task.isPresent()){
            taskRepository.deleteById(taskId);
            return "Successfully Deleted";
        }else{
            return "Not Found";
        }
    }
}
