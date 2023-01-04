package co.simplon.pigeongamer.pigeongamer.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "command")
public class Command {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_command;
	
	@Column(name = "command_date")
	private LocalDate command_date;
	
	@ManyToMany
	private Set<Product> listProduct;

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
	 * @return the listProduct
	 */
	public Set<Product> getListProduct() {
		return listProduct;
	}

	/**
	 * @param listProduct the listProduct to set
	 */
	public void setListProduct(Set<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
	}
	
	
}
