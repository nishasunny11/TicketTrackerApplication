package com.gl.graded.TTApp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.graded.TTApp.dto.TicketDto;
import com.gl.graded.TTApp.entity.Ticket;
import com.gl.graded.TTApp.mapper.TicketMapper;
import com.gl.graded.TTApp.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketRepository ticketRepository;

	@Autowired
	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public List<TicketDto> findAllTickets() {
		List<Ticket> tickets = ticketRepository.findAll();
		// return products.stream().map((product)->
		// ProductMapper.mapToProductDto(product)).collect(Collectors.toList());
		// we are coverting the list of products to productdto
		return tickets.stream().map(TicketMapper::mapToTicketDto).collect(Collectors.toList());

	}

	@Override
	public void saveProduct(Ticket ticket) {
		ticketRepository.save(ticket);

	}

	@Override
	public void deleteTicket(int id) {
		ticketRepository.deleteById(id);
	}

	@Override
	public Ticket getTicketById(int id) {
		return ticketRepository.findById(id).get();
	}

	public List<Ticket> listAll(String keyword) {
		if (keyword != null) {
			return ticketRepository.search(keyword);
		}
		return ticketRepository.findAll();
	}

	
}
