package com.multiplex.Service;

import org.mapstruct.Mapper;

import com.multiplex.Model.Hall;

@Mapper
public interface IHallService {

	public Hall addHallDetails(Hall hall);

}
