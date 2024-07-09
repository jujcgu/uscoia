package com.agro.uscoia.item;

import java.util.List;

public interface ItemRepository {

	public List<Item> read(String entidad, Long id);

}
