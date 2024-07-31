package br.com.java.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.data.vo.v1.PersonVO;
import br.com.java.exceptions.ResourceNotFoundException;
import br.com.java.repositories.PersonRepository;

@Service // Cuida da instanciação
public class PersonService {
	
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<PersonVO> findAll() {
		logger.info("Finding All people!");
		
		return repository.findAll() ;
	}

	public PersonVO findById(Long id) {
		logger.info("Finding one person!");
		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}
	
	public PersonVO create(PersonVO person) {
		logger.info("Creating one person!");
		
		return repository.save(person);
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("Updating one person!");
		
		PersonVO entity = repository.findById(person.getId())
								.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person!");
		
		PersonVO entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		repository.delete(entity);
	}
}

