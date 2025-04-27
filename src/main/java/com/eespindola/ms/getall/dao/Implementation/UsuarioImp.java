package com.eespindola.ms.getall.dao.Implementation;

import com.eespindola.ms.getall.dao.Mapper.UsuarioMapper;
import com.eespindola.ms.getall.dao.UsuarioDAO;
import com.eespindola.ms.getall.utils.Constantes;
import com.eespindola.ms.getall.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioImp implements UsuarioDAO {

    @Autowired
    @Qualifier(Constantes.HIKARI_CONNECTION)
    private JdbcTemplate jdbcTemplate;

    @Override
    public Result GetAll() {
        Result result = new Result();

        String query = Constantes.USUARIO_GET_ALL;

        try {
            result.objects = jdbcTemplate.query(query, new UsuarioMapper());
            result.isCorrect = true;

        } catch (Exception e){
            result.isCorrect = true;
            result.exception = e;
            result.message = e.getLocalizedMessage();
        }
        return  result;
    }
}
