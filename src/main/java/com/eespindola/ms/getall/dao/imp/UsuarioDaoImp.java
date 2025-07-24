package com.eespindola.ms.getall.dao.imp;

import com.eespindola.ms.getall.dao.UsuarioDao;
import com.eespindola.ms.getall.mapper.UsuarioMapper;
import com.eespindola.ms.getall.models.UsuarioMl;
import com.eespindola.ms.getall.utils.ConstantesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UsuarioDaoImp implements UsuarioDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsuarioDaoImp(
            @Qualifier(ConstantesUtils.JDBC_DATA_SOURCE) DataSource dataSource
//            @Qualifier(ConstantesUtil.JDBC_CONNECTION) JdbcTemplate jdbc
    ) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
//        this.jdbcTemplate = jdbc;
    }

    @Override
    public List<UsuarioMl> getAll() {
        String query = ConstantesUtils.USUARIO_GET_ALL;
        return  jdbcTemplate.query(query, new UsuarioMapper());
    }
}
