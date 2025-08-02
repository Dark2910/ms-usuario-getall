package com.eespindola.ms.getall.service;

import com.eespindola.ms.getall.models.dto.Result;
import com.eespindola.ms.getall.models.dto.UsuarioDto;

public interface UsuarioService {

    Result<UsuarioDto> consultarUsuarios();

}
