package com.kerpach.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kerpach.components.entity.Position;
import com.kerpach.components.entity.request.PositionRequest;
import com.kerpach.components.interfaces.IPosition;

@Service
public class PositionService {

	@Autowired
	private IPosition iPosition;

	public void createPosition(PositionRequest positionRequest) {
		iPosition.createPosition(positionRequest);
	}

	public Position findPositionById(Integer id) {
		return iPosition.findPositionById(id);
	}

	public Collection<Position> findAllPosition() {
		return iPosition.findAllPosition();
	}

	public void deletePosition(Integer id) {
		iPosition.deletePosition(id);
	}

	public void updatePosition(Position position) {
		iPosition.updatePosition(position);
	}
}
