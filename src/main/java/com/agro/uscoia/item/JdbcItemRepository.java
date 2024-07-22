package com.agro.uscoia.item;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.agro.uscoia.queries.QueryConfig;

@Repository
public class JdbcItemRepository implements ItemRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final QueryConfig queryConfig;

	public JdbcItemRepository(QueryConfig queryConfig) {
		this.queryConfig = queryConfig;
	}

	public String getSQL(String entidad, long id) {
		String SQL = "";
		HashMap<String, String> map = new HashMap<>();
		if (id != 0) {
			if (!entidad.endsWith("_id")) {
				entidad = entidad + "_id";
			}
		}
		map.put("pais", queryConfig.getReadSqlPais());
		map.put("departamento", queryConfig.getReadSqlDepartamento());
		map.put("empresa", queryConfig.getReadSqlEmpresa());
		map.put("almacen", queryConfig.getReadSqlAlmacen());
		map.put("almacen_id", queryConfig.getReadSqlAlmacenId());
		map.put("produccion", queryConfig.getReadSqlProduccion());
		map.put("produccion_id", queryConfig.getReadSqlProduccionId());
		map.put("producto_presentacion", queryConfig.getReadSqlProductoPresentacion());
		map.put("producto_presentacion_id", queryConfig.getReadSqlProductoPresentacionId());
		map.put("tipo_movimiento", queryConfig.getReadSqlTipoMovimiento());
		map.put("tipo_movimiento_id", queryConfig.getReadSqlTipoMovimientoId());
		SQL = map.get(entidad);

		if (SQL != null) {
			return SQL.replace("$ID$", String.valueOf(id));
		} else {
			throw new IllegalArgumentException("No SQL query found for entity: " + entidad);
		}
	}

	@Override
	public List<Item> read(String entidad, Long id) {
		return jdbcTemplate.query(getSQL(entidad, id), BeanPropertyRowMapper.newInstance(Item.class));
	}
}