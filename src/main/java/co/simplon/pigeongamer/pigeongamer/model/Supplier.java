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
	
	@Column(name = "supplier_name")
	private String supplier_name;
	
	public long getId_supplier() {
		return id_supplier;
	}

	public void setId_supplier(long id_supplier) {
		this.id_supplier = id_supplier;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
}
