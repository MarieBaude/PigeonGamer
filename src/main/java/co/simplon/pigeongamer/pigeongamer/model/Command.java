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

	/**
	 * @return the id_command
	 */
	public long getId_command() {
		return id_command;
	}

	/**
	 * @param id_command the id_command to set
	 */
	public void setId_command(long id_command) {
		this.id_command = id_command;
	}

	/**
	 * @return the command_date
	 */
	public LocalDate getCommand_date() {
		return command_date;
	}

	/**
	 * @param command_date the command_date to set
	 */
	public void setCommand_date(LocalDate command_date) {
		this.command_date = command_date;
	}

	/**
	 * @return the command_delivery
	 */
	public LocalDate getCommand_delivery() {
		return command_delivery;
	}

	/**
	 * @param command_delivery the command_delivery to set
	 */
	public void setCommand_delivery(LocalDate command_delivery) {
		this.command_delivery = command_delivery;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
