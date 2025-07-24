package com.eespindola.ms.getall.controller;

import com.eespindola.ms.getall.models.dto.Result;
import com.eespindola.ms.getall.models.dto.UsuarioDto;
import com.eespindola.ms.getall.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarioAPI")
public class UsuarioRestController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioRestController(
            UsuarioService service
    ) {
        this.usuarioService = service;
    }

    @PostMapping
    public Result<UsuarioDto> getAll(@RequestHeader(value = "folioRequest", required = false) String folioRequest, @RequestBody Result<Void> request){

//        folioRequest = (folioRequest == null || folioRequest.isEmpty() || folioRequest.isBlank())? FolioRequest.CrearFolioRequest() : folioRequest;

        return usuarioService.consultarUsuarios(request);
    }


}
