package com.eespindola.ms.getall.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioResponse {

    private int idUsuario;
    private String folioId;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String username;
    private String email;
    private String password;
    private String status;

}
