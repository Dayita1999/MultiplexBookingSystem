package com.multiplex.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiplex.Model.Movie;

public interface MovieDAO extends JpaRepository<Movie,Long>{

}
