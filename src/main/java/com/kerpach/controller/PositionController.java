package com.kerpach.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kerpach.components.entity.Position;
import com.kerpach.components.entity.request.PositionRequest;
import com.kerpach.services.PositionService;

@Configuration
@RestController
@RequestMapping("/position")
public class PositionController {
	
	@Autowired
	private PositionService positionService;	
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String addPosition(@RequestBody PositionRequest positionRequest){
		 positionService.createPosition(positionRequest);
		return "Position was add";
	}
	
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public Position findPositionById(@PathVariable("id") Integer id){
		return positionService.findPositionById(id);
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public Collection<Position> findAllPositions(){
		return positionService.findAllPosition();
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deletePosition(@PathVariable ("id") Integer id){
		positionService.deletePosition(id);
		return "Delete position #" + id.toString();
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String updatePosition(@RequestBody Position position){
		Position oldposition = findPositionById(position.getId());
		positionService.updatePosition(position);
		return "Update position:\n" + oldposition.toString() + " -> " + position.toString();
	}
	
}
