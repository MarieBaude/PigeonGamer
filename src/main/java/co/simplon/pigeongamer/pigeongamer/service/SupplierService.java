package co.simplon.pigeongamer.pigeongamer.service;

import java.util.List;

import co.simplon.pigeongamer.pigeongamer.model.Product;
import co.simplon.pigeongamer.pigeongamer.model.Supplier;

public interface SupplierService {
	List < Supplier > getAllProducts();
    void saveSupplier(Supplier supplier);
    Supplier getSupplierById(long id_supplier);
    void deleteSupplierById(long id_supplier);
}
