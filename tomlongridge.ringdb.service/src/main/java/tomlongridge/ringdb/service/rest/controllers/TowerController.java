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

import tomlongridge.ringdb.service.dao.TowerDAO;
import tomlongridge.ringdb.service.domain.Tower;

@Controller
@RequestMapping("/towers")
public class TowerController {

	@Autowired
	private TowerDAO towerDAO;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Tower> get(@PathVariable long id) {
		
		Tower tower = towerDAO.retrieve(id);
		
		ResponseEntity<Tower> response;
		if (tower != null) {
			tower.add(linkTo(methodOn(CountyController.class).get(tower.getCounty().getID())).withRel("county"));
			response = new ResponseEntity<Tower>(tower, HttpStatus.OK);
		} else {
			response = new ResponseEntity<Tower>(HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
	
}
