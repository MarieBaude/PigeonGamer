package co.simplon.pigeongamer.pigeongamer.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historical")
public class Historical {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_historical;
	
	@Column(name = "historical_command_date")
	private LocalDate historical_command_date;
	
	@Column(name = "historical_command_delivery")
	private LocalDate historical_command_delivery;
	
	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "id_supplier")
	private Supplier supplier;

	/**
	 * @return the id_historical
	 */
	public long getId_historical() {
		return id_historical;
	}

	/**
	 * @param id_historical the id_historical to set
	 */
	public void setId_historical(long id_historical) {
		this.id_historical = id_historical;
	}

	/**
	 * @return the historical_command_date
	 */
	public LocalDate getHistorical_command_date() {
		return historical_command_date;
	}

	/**
	 * @param historical_command_date the historical_command_date to set
	 */
	public void setHistorical_command_date(LocalDate historical_command_date) {
		this.historical_command_date = historical_command_date;
	}

	/**
	 * @return the historical_command_delivery
	 */
	public LocalDate getHistorical_command_delivery() {
		return historical_command_delivery;
	}

	/**
	 * @param historical_command_delivery the historical_command_delivery to set
	 */
	public void setHistorical_command_delivery(LocalDate historical_command_delivery) {
		this.historical_command_delivery = historical_command_delivery;
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

	/**
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
}

