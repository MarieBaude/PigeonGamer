package co.simplon.pigeongamer.pigeongamer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.pigeongamer.pigeongamer.model.Product;
import co.simplon.pigeongamer.pigeongamer.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository <Supplier, Long>{
 

}
