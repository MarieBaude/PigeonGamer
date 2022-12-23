package co.simplon.pigeongamer.pigeongamer.model;

import javax.validation.Valid;

public class SupplierProductForm {
	  @Valid
	  private Supplier supplier;

	  @Valid
	  private Product product;

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
