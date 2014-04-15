package tomlongridge.ringdb.service.rest.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tomlongridge.ringdb.service.dao.CountyDAO;
import tomlongridge.ringdb.service.domain.County;

@Controller
@RequestMapping("/counties")
public class CountyController {

	@Autowired
	private CountyDAO countyDAO;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<County> get(@PathVariable long id) {
		
		County county = countyDAO.retrieve(id);
		
		ResponseEntity<County> response;
		if (county != null) {
			county.add(linkTo(methodOn(CountryController.class).get(county.getCountry().getID())).withRel("country"));
			response = new ResponseEntity<County>(county, HttpStatus.OK);
		} else {
			response = new ResponseEntity<County>(HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
	
}
