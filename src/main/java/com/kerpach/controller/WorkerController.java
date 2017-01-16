package com.kerpach.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kerpach.components.entity.Worker;
import com.kerpach.components.entity.request.WorkerRequest;
import com.kerpach.services.WorkerService;

@Configuration
@RestController
@RequestMapping("/worker")
public class WorkerController {

	@Autowired
	private WorkerService workerService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addWorker(@RequestBody WorkerRequest workerRequest) {
		workerService.createWorker(workerRequest);
		return "Worker was add";
	}

	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public Worker findWorkerById(@PathVariable("id") Integer id) {
		return workerService.findWorkerById(id);
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public Collection<Worker> findAllWorker() {
		return workerService.findAllWorker();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteWorker(@PathVariable("id") Integer id) {
		workerService.deleteWorker(id);
		return "Delete Worker #" + id.toString();
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String updateWorker(@RequestBody Worker worker) {
		Worker oldworker = findWorkerById(worker.getId());
		workerService.updateWorker(worker);
		return "Update Worker:\n" + oldworker.toString() + " -> " + worker.toString();
	}

}
