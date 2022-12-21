package co.simplon.pigeongamer.pigeongamer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.pigeongamer.pigeongamer.model.Product;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long>{


}
