package com.agro.uscoia.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping
public class ItemController {

	@Autowired
	ItemRepository itemRepository;

	@GetMapping(value = { "/{entidad}", "/{entidad}/{id}" })
	public ResponseEntity<List<Item>> getAllItems(@PathVariable("entidad") String entidad,
			@PathVariable(name = "id", required = false) Long id) {

		try {
			ArrayList<Item> items = new ArrayList<>();

			id = (id == null) ? 0 : id;

			System.out.println("ID: " + id);

			itemRepository.read(entidad, id).forEach(items::add);

			if (items.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(items, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
