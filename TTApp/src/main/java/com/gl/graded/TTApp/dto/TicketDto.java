package com.gl.graded.TTApp.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDto {

	private int ticketId;
	private String ticketTitle;
	private String description;
	private LocalDateTime createdOn;
	private String content;
}
