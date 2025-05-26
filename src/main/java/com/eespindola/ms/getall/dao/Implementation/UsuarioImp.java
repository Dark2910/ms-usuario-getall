package com.eespindola.ms.getall.dao.Implementation;

import com.eespindola.ms.getall.dao.Mapper.UsuarioMapper;
import com.eespindola.ms.getall.dao.UsuarioDAO;
import com.eespindola.ms.getall.utils.Constantes;
import com.eespindola.ms.getall.models.dto.Result;
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
            result.setObjects( jdbcTemplate.query(query, new UsuarioMapper()));
            result.setIsCorrect(true);

        } catch (Exception e){
            result.setIsCorrect(false);
            result.setException(e);
            result.setMessage(e.getLocalizedMessage());
        }
        return  result;
    }
}
