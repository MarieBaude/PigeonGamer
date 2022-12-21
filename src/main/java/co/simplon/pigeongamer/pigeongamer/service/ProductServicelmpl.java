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
	
	@Override
    public List < Product > getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public Product getProductById(long id_product) {
        Optional < Product > optional = productRepository.findById(id_product);
        Product employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Product not found for id :: " + id_product);
        }
        return employee;
    }

    @Override
    public void deleteProductById(long id_product) {
        this.productRepository.deleteById(id_product);
    }
}
