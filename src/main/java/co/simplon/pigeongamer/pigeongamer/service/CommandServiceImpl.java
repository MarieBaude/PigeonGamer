package co.simplon.pigeongamer.pigeongamer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.pigeongamer.pigeongamer.model.Command;
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
	public void saveCommand(Command command) {
		this.commandRepository.save(command);
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
	public void saveCommand(long id_command) {
		// TODO Auto-generated method stub
		
	}
}
