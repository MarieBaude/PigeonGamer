package co.simplon.pigeongamer.pigeongamer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.pigeongamer.pigeongamer.model.Product;
import co.simplon.pigeongamer.pigeongamer.repository.ProductRepository;

@Service
public class ProductServicelmpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * Retrieves a list of all products.
	 *
	 * @return a list of all products
	 */
	@Override
    public List < Product > getAllProducts() {
        return productRepository.findAll();
    }
	
	/**
	 * Saves a product to the repository.
	 *
	 * @param product the product to be saved
	 */
    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    /**
     * Retrieves a product by its id.
     *
     * @param id_product the id of the product to retrieve
     * @return the product with the given id
     * @throws RuntimeException if a product with the given id does not exist
     */

    @Override
    public Product getProductById(long id_product) {
        Optional < Product > optional = productRepository.findById(id_product);
        Product product = null;
        if (optional.isPresent()) {
        	product = optional.get();
        } else {
            throw new RuntimeException(" Product not found for id :: " + id_product);
        }
        return product;
    }

    /**
     * Deletes a product from the repository by its id.
     *
     * @param id_product the id of the product to delete
     */

    @Override
    public void deleteProductById(long id_product) {
        this.productRepository.deleteById(id_product);
    }
}
