package com.gl.graded.TTApp.mapper;

import com.gl.graded.TTApp.dto.TicketDto;
import com.gl.graded.TTApp.entity.Ticket;


public class TicketMapper {

	public static TicketDto mapToTicketDto(Ticket ticket) {

		TicketDto ticketDto = TicketDto.builder().ticketId(ticket.getTicketId()).
				ticketTitle(ticket.getTicketTitle()).description(ticket.getDescription()).
				createdOn(ticket.getCreatedOn()).build();
		return ticketDto;

	}


	public static Ticket mapTicketDtoToTicket(TicketDto ticketDto) {

		Ticket ticket = Ticket.builder().ticketId(ticketDto.getTicketId()).
				ticketTitle(ticketDto.getTicketTitle()).description(ticketDto.getDescription()).
				createdOn(ticketDto.getCreatedOn()).build();

		return ticket;
	}
}
