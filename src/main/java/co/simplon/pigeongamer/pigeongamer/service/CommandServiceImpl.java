package co.simplon.pigeongamer.pigeongamer.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.pigeongamer.pigeongamer.model.Command;
import co.simplon.pigeongamer.pigeongamer.model.Product;
import co.simplon.pigeongamer.pigeongamer.repository.CommandRepository;
import co.simplon.pigeongamer.pigeongamer.repository.ProductRepository;

@Service
public class CommandServiceImpl implements CommandService{
	@Autowired
	private CommandRepository commandRepository;
	
	@Autowired
	private ProductRepository productRepository;

	/**
	 * Retrieves a list of all commands.
	 *
	 * @return A list of all commands.
	 */
	@Override
	public List < Command > getAllCommands() {
	    return commandRepository.findAll();
	}
	
	/**
	 * Retrieves the {@link Command} with the given ID from the repository.
	 *
	 * @param id_command the ID of the command to retrieve
	 * @return the {@link Command} with the given ID, or {@code null} if no such command exists
	 * @throws RuntimeException if no command is found for the given ID
	 */
	@Override
	public Command getCommandById(long id_command) {
	    Optional < Command > optional = commandRepository.findById(id_command);
	    Command command = null;
	    if (optional.isPresent()) {
	    	command = optional.get();
	    } else {
	        throw new RuntimeException(" Command not found for id :: " + id_command);
	    }
	    return command;
	}

	/**
	 * Saves a new {@link Command} to the repository, consisting of the given list of {@link Product}s.
	 * Also updates the stock of each product by decrementing it by 1.
	 *
	 * @param productList the list of products to include in the command
	 */
	@Override
	public void saveCommand(List<Product> productList) {
		Command command = new Command();
		// date
		LocalDate localDate = LocalDate.now();
		command.setCommand_date(localDate);
		
		command.setListProduct( productList.stream().collect(Collectors.toSet()));
	    
		for (Product product : productList) {
		  int newStock = product.getProduct_stock() - 1;
		  product.setProduct_stock(newStock);
		  productRepository.save(product);
		}

		Command c = commandRepository.save(command);
		System.out.println(",,,,,,,,,,,,,,,,,,,,");
		System.out.println(c.getId_command());
		System.out.println(",,,,,,,,,,,,,,,,,,,,");
		
	}
	
}
