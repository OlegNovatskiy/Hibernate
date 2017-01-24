package com.kerpach.controller;

import java.util.Collection;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kerpach.components.entity.Worker;
import com.kerpach.components.entity.request.WorkerRequest;
import com.kerpach.components.services.WorkerDAO;
import com.kerpach.services.WorkerService;

@Configuration
@RestController
@RequestMapping("/worker")
public class WorkerController {

	@Autowired
	private WorkerService workerService;

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public Collection<Worker> addWorker() {
		// DetachedCriteria query =
		// DetachedCriteria.forClass(Worker.class).add(Property.forName("fnameWorker").like("no",
		// MatchMode.ANYWHERE));

		WorkerDAO dao = new WorkerDAO();
		Collection<Worker> w =workerService.getTest1();
		return w;
	}

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
