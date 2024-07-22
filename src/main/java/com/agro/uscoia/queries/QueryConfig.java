package com.agro.uscoia.queries;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:queries.properties")
public class QueryConfig {

    @Value("${READ_SQL_PAIS}")
    private String readSqlPais;

    @Value("${READ_SQL_DEPARTAMENTO}")
    private String readSqlDepartamento;

    @Value("${READ_SQL_EMPRESA}")
    private String readSqlEmpresa;

    @Value("${READ_SQL_ALMACEN}")
    private String readSqlAlmacen;

    @Value("${READ_SQL_ALMACEN_ID}")
    private String readSqlAlmacenId;

    @Value("${READ_SQL_PRODUCCION}")
    private String readSqlProduccion;

    @Value("${READ_SQL_PRODUCCION_ID}")
    private String readSqlProduccionId;

    @Value("${READ_SQL_PRODUCTO_PRESENTACION}")
    private String readSqlProductoPresentacion;

    @Value("${READ_SQL_PRODUCTO_PRESENTACION_ID}")
    private String readSqlProductoPresentacionId;

    @Value("${READ_SQL_TIPO_MOVIMIENTO}")
    private String readSqlTipoMovimiento;

    @Value("${READ_SQL_TIPO_MOVIMIENTO_ID}")
    private String readSqlTipoMovimientoId;

    public String getReadSqlPais() {
        return readSqlPais;
    }

    public String getReadSqlDepartamento() {
        return readSqlDepartamento;
    }

    public String getReadSqlEmpresa() {
        return readSqlEmpresa;
    }

    public String getReadSqlAlmacen() {
        return readSqlAlmacen;
    }

    public String getReadSqlAlmacenId() {
        return readSqlAlmacenId;
    }

    public String getReadSqlProduccion() {
        return readSqlProduccion;
    }

    public String getReadSqlProduccionId() {
        return readSqlProduccionId;
    }

    public String getReadSqlProductoPresentacion() {
        return readSqlProductoPresentacion;
    }

    public String getReadSqlProductoPresentacionId() {
        return readSqlProductoPresentacionId;
    }

    public String getReadSqlTipoMovimiento() {
        return readSqlTipoMovimiento;
    }

    public String getReadSqlTipoMovimientoId() {
        return readSqlTipoMovimientoId;
    }

}
