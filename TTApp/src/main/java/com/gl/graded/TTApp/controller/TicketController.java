package com.gl.graded.TTApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.graded.TTApp.dto.TicketDto;
import com.gl.graded.TTApp.entity.Ticket;
import com.gl.graded.TTApp.service.TicketService;

@Controller
public class TicketController {

	// inject service layer dependency
	TicketService ticketService;

	@Autowired
	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	// mapping to fetch all the products in the database
	@GetMapping("/allTickets")
	public String products(Model model) {
		List<TicketDto> tickets = ticketService.findAllTickets();
		model.addAttribute("ticketAttribute", tickets);
		return "allTickets";
	}

	@GetMapping("/ticket/new")
	public String createTicket(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticketAttribute", ticket);
		return "CreateTicket";
	}

	// save the product details
	@PostMapping("/saveTicket")
	public String saveTicket(@ModelAttribute("ticketAttribute") Ticket ticket) {
		ticketService.saveProduct(ticket);
		return "redirect:/allTickets";
	}

	// mapping for delete functionality
	@GetMapping("/tickets/delete/{id}")
	public String deleteTicket(@PathVariable int id) {
		ticketService.deleteTicket(id);
		return "redirect:/allTickets";
	}

	// mapping for update returning the form
	@GetMapping("/tickets/edit/{id}")
	public String editTicketForm(@PathVariable int id, Model model) {
		model.addAttribute("ticketAttribute", ticketService.getTicketById(id));
		return "updateTicket";
	}

	@PostMapping("/updateTicket/{id}")
	// 2 --> path variable, form data, model(to get data from vl to cl)
	public String updateTicket(@PathVariable int id, @ModelAttribute("ticketAttribute") Ticket ticket) {

		// find the existing product
		Ticket existingTicket = ticketService.getTicketById(id);
		existingTicket.setTicketId(id);
		existingTicket.setTicketTitle(ticket.getTicketTitle());
		existingTicket.setDescription(ticket.getDescription());
		existingTicket.setContent(ticket.getContent());
		// existingTicket.setCreatedOn(ticket.getCreatedOn());
		ticketService.saveProduct(existingTicket);
		return "redirect:/allTickets";

	}

	@RequestMapping("/search")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<Ticket> listTickets = ticketService.listAll(keyword);
		model.addAttribute("ticketAttribute", listTickets);
		model.addAttribute("keyword", keyword);
		return "allTickets";
	}

	@GetMapping("/tickets/{id}")
	public String viewPost(@PathVariable int id, Model model) {
		Ticket ticketDto = ticketService.getTicketById(id);
		model.addAttribute("ticketAttribute", ticketDto);
		return "viewTicket";
	}

}
