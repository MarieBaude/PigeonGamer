package co.simplon.pigeongamer.pigeongamer.model.DTOS;


public class ProductDTO {
 
    private long id_product;
    private String product_name;
	private String product_stock;
	private String product_img;
	private String product_price;
	private String product_desc;
	/**
	 * @return the id_product
	 */
	public long getId_product() {
		return id_product;
	}
	/**
	 * @param id_product the id_product to set
	 */
	public void setId_product(long id_product) {
		this.id_product = id_product;
	}
	/**
	 * @return the product_name
	 */
	public String getProduct_name() {
		return product_name;
	}
	/**
	 * @param product_name the product_name to set
	 */
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	/**
	 * @return the product_stock
	 */
	public String getProduct_stock() {
		return product_stock;
	}
	/**
	 * @param product_stock the product_stock to set
	 */
	public void setProduct_stock(String product_stock) {
		this.product_stock = product_stock;
	}
	/**
	 * @return the product_img
	 */
	public String getProduct_img() {
		return product_img;
	}
	/**
	 * @param product_img the product_img to set
	 */
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	/**
	 * @return the product_price
	 */
	public String getProduct_price() {
		return product_price;
	}
	/**
	 * @param product_price the product_price to set
	 */
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	/**
	 * @return the product_desc
	 */
	public String getProduct_desc() {
		return product_desc;
	}
	/**
	 * @param product_desc the product_desc to set
	 */
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	
	
}