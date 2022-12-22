package co.simplon.pigeongamer.pigeongamer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.pigeongamer.pigeongamer.model.Product;
import co.simplon.pigeongamer.pigeongamer.model.Supplier;
import co.simplon.pigeongamer.pigeongamer.repository.ProductRepository;
import co.simplon.pigeongamer.pigeongamer.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public List<Supplier> getAllProducts() {
		return supplierRepository.findAll();
	}

	@Override
	public void saveSupplier(Supplier supplier) {
		this.supplierRepository.save(supplier);
	}

	@Override
	public Supplier getSupplierById(long id_supplier) {
		Optional<Supplier> optional = supplierRepository.findById(id_supplier);
		Supplier supplier = null;
		if (optional.isPresent()) {
			supplier = optional.get();
		} else {
			throw new RuntimeException(" Product not found for id :: " + id_supplier);
		}
		return supplier;
	}

	@Override
	public void deleteSupplierById(long id_supplier) {
		this.supplierRepository.deleteById(id_supplier);
	}

}
