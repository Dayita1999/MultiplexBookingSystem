package com.multiplex.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiplex.Model.Show;

public interface ShowDAO extends JpaRepository<Show, Long> {

}
