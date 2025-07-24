package com.eespindola.ms.getall.mapper;

import com.eespindola.ms.getall.jpa.entities.UsuarioJpa;
import com.eespindola.ms.getall.models.UsuarioMl;
import com.eespindola.ms.getall.models.dto.UsuarioDto;
import com.eespindola.ms.getall.utils.ConstantesUtils;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsuarioMapper implements RowMapper<UsuarioMl> {

    @Override
    public UsuarioMl mapRow(ResultSet rs, int rowNum) throws SQLException {
        UsuarioMl usuarioML = new UsuarioMl();

        usuarioML.setIdUsuario(rs.getInt(1));
        usuarioML.setFolioId(rs.getString(2));
        usuarioML.setNombre(rs.getString(3));
        usuarioML.setApellidoPaterno(rs.getString(4));
        usuarioML.setApellidoMaterno(rs.getString(5));
        usuarioML.setFechaNacimiento(getFechaNacimiento(rs.getDate(6)));
        usuarioML.setUsername(rs.getString(7));
        usuarioML.setEmail(rs.getString(8));
        usuarioML.setPassword(rs.getString(9));
        usuarioML.setStatus(rs.getString(10));

        return usuarioML;
    }
    private static String getFechaNacimiento(Date fecha) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ConstantesUtils.DATE_FORMAT);
        return simpleDateFormat.format(fecha);
    }

    public static UsuarioDto toUsuarioDto(UsuarioJpa usuarioJPA){
        UsuarioDto usuarioResponse = new UsuarioDto();

        usuarioResponse.setIdUsuario(usuarioJPA.getIdUsuario());
        usuarioResponse.setFolioId(usuarioJPA.getFolio());
        usuarioResponse.setNombre(usuarioJPA.getNombre());
        usuarioResponse.setApellidoPaterno(usuarioJPA.getApellidoPaterno());
        usuarioResponse.setApellidoMaterno(usuarioJPA.getApellidoMaterno());
        usuarioResponse.setFechaNacimiento(usuarioJPA.getFechaNacimiento().toString());
        usuarioResponse.setUsername(usuarioJPA.getUsername());
        usuarioResponse.setEmail(usuarioJPA.getEmail());
        usuarioResponse.setPassword(usuarioJPA.getPassword());
        usuarioResponse.setStatus(usuarioJPA.getStatus());

        return usuarioResponse;
    }

    public static UsuarioDto toUsuarioDto(UsuarioMl usuarioML){
        UsuarioDto usuarioResponse = new UsuarioDto();

        usuarioResponse.setIdUsuario(usuarioML.getIdUsuario());
        usuarioResponse.setFolioId(usuarioML.getFolioId());
        usuarioResponse.setNombre(usuarioML.getNombre());
        usuarioResponse.setApellidoPaterno(usuarioML.getApellidoPaterno());
        usuarioResponse.setApellidoMaterno(usuarioML.getApellidoMaterno());
        usuarioResponse.setFechaNacimiento(usuarioML.getFechaNacimiento());
        usuarioResponse.setUsername(usuarioML.getUsername());
        usuarioResponse.setEmail(usuarioML.getEmail());
        usuarioResponse.setPassword(usuarioML.getPassword());
        usuarioResponse.setStatus(usuarioML.getStatus());

        return usuarioResponse;
    }

}
