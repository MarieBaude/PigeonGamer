package co.simplon.pigeongamer.pigeongamer.service;

import java.util.List;

import co.simplon.pigeongamer.pigeongamer.model.Product;

/**
 * Defines a service for managing products.
 */
public interface ProductService {
	/**
	 * Retrieves a list of all products.
	 *
	 * @return a list of all products
	 */
	List < Product > getAllProducts();
	
	/**
	 * Saves a new product or updates an existing one.
	 *
	 * @param product the product to save
	 */
    void saveProduct(Product product);
    
	/**
	 * Retrieves the product with the given ID.
	 *
	 * @param id_product the ID of the product to retrieve
	 * @return the product with the given ID, or {@code null} if no such product exists
	 */
    Product getProductById(long id_product);
    
	/**
	 * Deletes the product with the given ID.
	 *
	 * @param id_product the ID of the product to delete
	 */
    void deleteProductById(long id_product);
}
