package co.simplon.pigeongamer.pigeongamer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.pigeongamer.pigeongamer.model.Command;
import co.simplon.pigeongamer.pigeongamer.model.Product;

@Repository
public interface CommandRepository extends JpaRepository <Command, Long> {

}
