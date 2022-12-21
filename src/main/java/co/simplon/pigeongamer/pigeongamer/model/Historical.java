package co.simplon.pigeongamer.pigeongamer.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@OneToMany
	@JoinColumn(name = "id_product")
	private Product product;
	
	@OneToOne
	@JoinColumn(name = "id_supplier")
	private Supplier supplier;
}

