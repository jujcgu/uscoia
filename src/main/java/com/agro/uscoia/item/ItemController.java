package com.agro.uscoia.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
@RequestMapping("/api/v1")
public class ItemController {

	@Autowired
	ItemRepository itemRepository;

	@GetMapping(value = { "/items/{entidad}", "/items/{entidad}/{id}" })
	public ResponseEntity<List<Item>> getAllItems(@PathVariable("entidad") String entidad,
			@PathVariable(name = "id", required = false) Long id) {

		try

		{
			ArrayList<Item> items = new ArrayList<Item>();

			id = id == null ? 0 : id;

			System.out.println(id);

			itemRepository.read(entidad, id).forEach(items::add);

			if (items.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(items, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("error: "+ id);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
