package co.simplon.pigeongamer.pigeongamer.service;

import java.util.List;

import co.simplon.pigeongamer.pigeongamer.model.Command;
import co.simplon.pigeongamer.pigeongamer.model.Product;

public interface CommandService {
	List < Command > getAllCommands();
    void saveCommand(Command command);
    Command getCommandById(long id_command);
	void saveCommand(long id_command);
}
