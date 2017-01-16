package com.kerpach.components.interfaces;

import java.util.Collection;

import com.kerpach.components.entity.Worker;
import com.kerpach.components.entity.request.WorkerRequest;

public interface IWorker {
	
	public void createWorker(WorkerRequest workerRequest);
	
	public Worker findWorkerById(Integer id);
	
	public Collection<Worker> findAllWorker();
	
	public void deleteWorker(Integer id);
	
	public void updateWorker(Worker worker);
}
