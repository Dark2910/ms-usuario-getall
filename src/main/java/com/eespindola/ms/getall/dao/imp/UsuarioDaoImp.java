package com.eespindola.ms.getall.dao.imp;

import com.eespindola.ms.getall.dao.UsuarioDAO;
import com.eespindola.ms.getall.mapper.UsuarioMapper;
import com.eespindola.ms.getall.models.UsuarioML;
import com.eespindola.ms.getall.utils.ConstantesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioDaoImp implements UsuarioDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsuarioDaoImp(
            @Qualifier(ConstantesUtil.HIKARI_CONNECTION) JdbcTemplate jdbc
    ) {
        this.jdbcTemplate = jdbc;
    }

    @Override
    public List<UsuarioML> getAll() {
        String query = ConstantesUtil.USUARIO_GET_ALL;
        return  jdbcTemplate.query(query, new UsuarioMapper());
    }
}
