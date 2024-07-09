package com.agro.uscoia.producto.presentacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcProductoPresentacionRepository implements ProductoPresentacionRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    String READ_SQL_PRODUCTO_PRESENTACION = "SELECT  prp_producto_id AS id, pro_nombre AS nombre, pre_nombre AS presentacion, prp_cantidad AS cantidad, uni_nombre AS unidad , mar_nombre AS marca"
            + " FROM producto_presentacion, unidad, producto, marca, presentacion"
            + " WHERE prp_unidad_id = uni_id"
            + " AND prp_producto_id = pro_id"
            + " AND prp_marca_id = mar_id"
            + " AND prp_presentacion_id = pre_id"
            + " ORDER BY prp_id ASC";

    @Override
    public List<ProductoPresentacion> read() {
        return jdbcTemplate.query(READ_SQL_PRODUCTO_PRESENTACION,
                BeanPropertyRowMapper.newInstance(ProductoPresentacion.class));
    }
}
