package com.kerpach.components.interfaces;

import java.util.Collection;

import com.kerpach.components.entity.Position;
import com.kerpach.components.entity.request.PositionRequest;

public interface IPosition {

	public void createPosition(PositionRequest positionRequest);
	
	public Position findPositionById(Integer id);
	
	public Collection<Position> findAllPosition();
	
	public void deletePosition(Integer id);
	
	public void updatePosition(Position position);
}
