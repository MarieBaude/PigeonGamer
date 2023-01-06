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

@Service
public class CommandServiceImpl implements CommandService{
	@Autowired
	private CommandRepository commandRepository;
	
	@Override
	public List < Command > getAllCommands() {
	    return commandRepository.findAll();
	}
	
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

	@Override
	public void saveCommand(List<Product> productList) {
		Command command = new Command();
		// date
		LocalDate localDate = LocalDate.now();
		command.setCommand_date(localDate);
		
		command.setListProduct( productList.stream().collect(Collectors.toSet()));
	    
		
		//commandRepository.save(command);
		Command c = commandRepository.save(command);
		//System.out.println(commandRepository.save(command));
		System.out.println(",,,,,,,,,,,,,,,,,,,,");
		System.out.println(c.getId_command());
		System.out.println(",,,,,,,,,,,,,,,,,,,,");
		
	}
	
}
