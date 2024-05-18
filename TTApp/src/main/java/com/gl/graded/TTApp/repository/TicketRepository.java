package com.gl.graded.TTApp.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.gl.graded.TTApp.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	@Query("SELECT t FROM Ticket t WHERE t.ticketTitle LIKE %?1%" + " OR t.description LIKE %?1%")
	public List<Ticket> search(String keyword);

	
}
