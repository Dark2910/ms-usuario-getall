package com.eespindola.ms.getall.service;

import com.eespindola.ms.getall.models.dto.Result;
import com.eespindola.ms.getall.models.dto.UsuarioResponse;

public interface UsuarioService {

    Result<UsuarioResponse> consultarUsuarios(Result<Void> request);

}
