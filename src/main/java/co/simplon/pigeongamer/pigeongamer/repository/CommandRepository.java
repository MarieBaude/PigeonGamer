package co.simplon.pigeongamer.pigeongamer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.pigeongamer.pigeongamer.model.Command;

@Repository
public interface CommandRepository extends JpaRepository <Command, Long> {

}
