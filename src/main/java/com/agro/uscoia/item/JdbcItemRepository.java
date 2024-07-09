package com.agro.uscoia.item;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcItemRepository implements ItemRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	String READ_SQL_PAIS = "SELECT pai_id as id, pai_nombre as nombre"
			+ " FROM pais as item"
			+ " ORDER BY pai_nombre";

	String READ_SQL_DEPARTAMENTO = "SELECT dep_id as id, dep_nombre as nombre"
			+ " FROM departamento as item"
			+ " ORDER BY dep_nombre";

	String READ_SQL_EMPRESA = "SELECT emp_id as id, emp_nombre as nombre"
			+ " FROM empresa as item"
			+ " WHERE emp_estado = 1"
			+ " ORDER BY emp_nombre";

	String READ_SQL_ALMACEN = "SELECT alm_id as id, alm_nombre as nombre"
			+ " FROM almacen as item"
			+ " WHERE alm_estado = 1"
			+ " ORDER BY alm_nombre";

	String READ_SQL_ALMACEN_ID = "SELECT alm_id as id, alm_nombre as nombre"
			+ " FROM almacen as al, sede  as s"
			+ " WHERE al.alm_sede_id = s.sed_id"
			+ " AND s.sed_empresa_id = $ID$"
			+ " AND alm_estado = 1"
			+ " ORDER BY alm_nombre";

	String READ_SQL_PRODUCCION = "SELECT pro_id as id, pro_nombre as nombre"
			+ " FROM produccion as item"
			+ " WHERE pro_estado = 1"
			+ " ORDER BY pro_nombre";

	String READ_SQL_PRODUCCION_ID = "SELECT pro_id as id, pro_nombre as nombre"
			+ "FROM produccion as pro, espacio as esp"
			+ "WHERE pro.pro_espacio_id = esp.esp_id"
			+ "AND esp.esp_id =$ID$"
			+ "AND pro_estado = 1"
			+ " ORDER BY pro_nombre";

	String READ_SQL_PRODUCTO_PRESENTACION = "SELECT prp_producto_id AS id, pre_nombre || ' ' || prp_cantidad || ' ' || uni_nombre || ' (' || mar_nombre || ') ' AS nombre"
			+ " FROM producto_presentacion, unidad, producto, marca, presentacion"
			+ " WHERE prp_unidad_id = uni_id"
			+ " AND prp_producto_id = pro_id"
			+ " AND prp_marca_id = mar_id"
			+ " AND prp_presentacion_id = pre_id"
			+ " ORDER BY prp_id ASC";

	String READ_SQL_PRODUCTO_PRESENTACION_ID = "SELECT prp_producto_id AS id, pre_nombre || ' ' || prp_cantidad || ' ' || uni_nombre || ' (' || mar_nombre || ') ' AS nombre"
			+ " FROM producto_presentacion, unidad, producto, marca, presentacion"
			+ " WHERE prp_unidad_id = uni_id"
			+ " AND prp_producto_id = pro_id"
			+ " AND prp_marca_id = mar_id"
			+ " AND prp_presentacion_id = pre_id"
			+ " AND prp_producto_id =$ID$"
			+ " ORDER BY prp_id ASC";

	String READ_SQL_TIPO_MOVIMIENTO = "SELECT tim_id AS id, tim_nombre AS nombre"
			+ " FROM tipo_movimiento"
			+ " ORDER BY tim_id ASC";

	String READ_SQL_TIPO_MOVIMIENTO_ID = "SELECT tim_id AS id, tim_nombre AS nombre"
			+ " FROM tipo_movimiento"
			+ " WHERE tim_id = $ID$"
			+ " ORDER BY tim_id ASC";

	public String getSQL(String entidad, long id) {
		String SQL = "";
		HashMap<String, String> map = new HashMap<>();
		if (id != 0) {
			entidad = entidad + "_id";
		}
		map.put("pais", READ_SQL_PAIS);
		map.put("departamento", READ_SQL_DEPARTAMENTO);
		map.put("empresa", READ_SQL_EMPRESA);
		map.put("almacen", READ_SQL_ALMACEN);
		map.put("almacen_id", READ_SQL_ALMACEN_ID);
		map.put("produccion", READ_SQL_PRODUCCION);
		map.put("produccion_id", READ_SQL_PRODUCCION_ID);
		map.put("producto_presentacion", READ_SQL_PRODUCTO_PRESENTACION);
		map.put("producto_presentacion_id", READ_SQL_PRODUCTO_PRESENTACION_ID);
		map.put("tipo_movimiento", READ_SQL_TIPO_MOVIMIENTO);
		map.put("tipo_movimiento_id", READ_SQL_TIPO_MOVIMIENTO_ID);

		SQL = map.get(entidad);
		return SQL = SQL.replace("$ID$", String.valueOf(id));

	}

	@Override
	public List<Item> read(String entidad, Long id) {
		return jdbcTemplate.query(getSQL(entidad, id), BeanPropertyRowMapper.newInstance(Item.class));
	}
}
