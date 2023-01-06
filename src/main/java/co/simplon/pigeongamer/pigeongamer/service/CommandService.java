package co.simplon.pigeongamer.pigeongamer.service;

import java.util.List;

import co.simplon.pigeongamer.pigeongamer.model.Command;
import co.simplon.pigeongamer.pigeongamer.model.Product;

/**
 * Provides services for managing commands.
 */
public interface CommandService {
	/**
     * Retrieves a list of all commands.
     *
     * @return A list of all commands.
     */
	List < Command > getAllCommands();
	
	 /**
     * Retrieves a command by its ID.
     *
     * @param id_command The ID of the command to retrieve.
     * @return The command with the specified ID, or null if no such command exists.
     */
    Command getCommandById(long id_command);
    
    /**
     * Saves a new command.
     *
     * @param productList The list of products in the command.
     */
    void saveCommand(List<Product> productList);
}
