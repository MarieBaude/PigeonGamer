package co.simplon.pigeongamer.pigeongamer.service;

import java.util.List;

import co.simplon.pigeongamer.pigeongamer.model.Command;
import co.simplon.pigeongamer.pigeongamer.model.Product;

public interface CommandService {
	List < Command > getAllCommands();
    Command getCommandById(long id_command);
    void saveCommand(List<Long> productList);
	}
