package com.gl.graded.TTApp.service;

import java.util.List;
import com.gl.graded.TTApp.dto.TicketDto;
import com.gl.graded.TTApp.entity.Ticket;


public interface TicketService {
 
	List<TicketDto> findAllTickets();
	void saveProduct(Ticket ticket);
    void deleteTicket(int id);
    Ticket getTicketById(int id);
    List<Ticket> listAll(String keyword);
   
    
}
