package com.kerpach.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kerpach.components.entity.Worker;
import com.kerpach.components.entity.request.WorkerRequest;
import com.kerpach.components.interfaces.IWorker;

@Service
public class WorkerService {

	@Autowired
	private IWorker iWorker;

	public void createWorker(WorkerRequest positionRequest) {
		iWorker.createWorker(positionRequest);
	}

	public Collection<Worker> getTest1(){
		return iWorker.getTest1();
	}
	
	public Worker findWorkerById(Integer id) {
		return iWorker.findWorkerById(id);
	}

	public Collection<Worker> findAllWorker() {
		return iWorker.findAllWorker();
	}

	public void deleteWorker(Integer id) {
		iWorker.deleteWorker(id);
	}

	public void updateWorker(Worker worker) {
		iWorker.updateWorker(worker);
	}
	
}
