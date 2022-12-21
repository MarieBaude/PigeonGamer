package co.simplon.pigeongamer.pigeongamer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_supplier;
	
	@Column(name = "product_name")
	private String supplier_name;
}
