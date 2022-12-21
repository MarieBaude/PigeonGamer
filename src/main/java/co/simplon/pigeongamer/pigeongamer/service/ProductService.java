package co.simplon.pigeongamer.pigeongamer.service;

import java.util.List;

import co.simplon.pigeongamer.pigeongamer.model.Product;

public interface ProductService {
	List < Product > getAllProducts();
    void saveProduct(Product product);
    Product getProductById(long id_product);
    void deleteProductById(long id_product);
}
