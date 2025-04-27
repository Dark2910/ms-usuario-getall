package com.eespindola.ms.getall.jpa.Mapper;

import com.eespindola.ms.getall.jpa.Entities.UsuarioJPA;
import com.eespindola.ms.getall.models.UsuarioML;
import com.eespindola.ms.getall.utils.Constantes;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;

public class UsuarioMapper {

    public static @NotNull UsuarioML Map(@NotNull UsuarioJPA usuarioJPA){
        UsuarioML usuarioML = new UsuarioML();

        usuarioML.setIdUsuario(usuarioJPA.getIdUsuario());
        usuarioML.setFolio(usuarioJPA.getFolio());
        usuarioML.setNombre(usuarioJPA.getNombre());
        usuarioML.setApellidoPaterno(usuarioJPA.getApellidoPaterno());
        usuarioML.setApellidoMaterno(usuarioJPA.getApellidoMaterno());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constantes.DATE_FORMAT);
        String fecha = simpleDateFormat.format(usuarioJPA.getFechaNacimiento()).toString();

        usuarioML.setFechaNacimiento(fecha);

        usuarioML.setUsername(usuarioJPA.getUsername());
        usuarioML.setEmail(usuarioJPA.getEmail());
        usuarioML.setPassword(usuarioJPA.getPassword());
        usuarioML.setStatus(usuarioJPA.getStatus());

        return usuarioML;
    }
}
