package com.programmingfree.springservice.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.programmingfree.dao.TaskManagerService;
import com.programmingfree.springservice.domain.Task;

//@RequestMapping(value="/abc")
@RestController
public class TaskManagerController {
	
	
	
	TaskManagerService taskmanagerservice=new TaskManagerService();
	
	 @RequestMapping(value="/tasks",method = RequestMethod.GET,headers="Accept=application/json")
	 public List<Task> getAllTasks() {	
		 System.out.println("TaskManagerController.getAllTasks()............... ");
		 
	  List<Task> tasks=taskmanagerservice.getAllTasks();
	  System.out.println("@@@@@@@@@@@@@@@!!");
	  return tasks;
	
	 }
	 
	 
	 @RequestMapping(value="/tasks/archive/{taskIds}",method = RequestMethod.POST,headers="Accept=application/json")
	 public List<Task> archiveAllTasks(@PathVariable int[] taskIds) {	
		 for(int i=0;i<taskIds.length;i++){
			 taskmanagerservice.archiveTask(taskIds[i]);	
			 
		 }
	  List<Task> tasks=taskmanagerservice.getAllTasks();
	  return tasks;
	
	 }
	 
	 @RequestMapping(value="/tasks/{taskId}/{taskStatus}",method = RequestMethod.POST,headers="Accept=application/json")
	 public List<Task> changeTaskStatus(@PathVariable int taskId,@PathVariable String taskStatus) throws ParseException {	
		 taskmanagerservice.changeTaskStatus(taskId,taskStatus);		 
		 return taskmanagerservice.getAllTasks();
		 
	 }
	 
	@RequestMapping(value = "/tasks/insert/{taskName}/{taskDesc}/{taskPriority}/{taskStatus}/{taskId}", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Task> addTask(@PathVariable String taskName, @PathVariable String taskDesc,
			@PathVariable String taskPriority, @PathVariable String taskStatus) throws ParseException {
		
		System.out.println("TaskManagerController.addTask()");
		System.out.println(taskName);
		System.out.println(taskDesc);
		System.out.println(taskPriority);
		System.out.println(taskStatus);
		

		Task task = new Task();
		task.setTaskName(taskName);
		task.setTaskDescription(taskDesc);
		task.setTaskPriority(taskPriority);
		task.setTaskStatus(taskStatus);
		taskmanagerservice.addTask(task);
		
		return taskmanagerservice.getAllTasks();

	}	 	 	 
}