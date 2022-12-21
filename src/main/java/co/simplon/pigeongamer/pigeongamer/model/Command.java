package co.simplon.pigeongamer.pigeongamer.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "command")
public class Command {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_command;
	
	@Column(name = "command_date")
	private LocalDate command_date;
	
	@Column(name = "command_delivery")
	private LocalDate command_delivery;
	
	@OneToMany
	@JoinColumn(name = "id_product")
	private Product product;
}
