package com.eespindola.ms.getall.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioML {

    @JsonProperty("idUsuario")
    private int idUsuario;

    @JsonProperty("folio")
    private String folio;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("apellidoPaterno")
    private String apellidoPaterno;

    @JsonProperty("apellidoMaterno")
    private String apellidoMaterno;

    @JsonProperty("fechaNacimiento")
    private String fechaNacimiento;

    @JsonProperty("username")
    private String username;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("status")
    private String status;

}
