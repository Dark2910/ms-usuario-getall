package com.eespindola.ms.getall.controller;

import com.eespindola.ms.getall.dao.Implementation.UsuarioImp;
import com.eespindola.ms.getall.jpa.UsuarioRepository;
import com.eespindola.ms.getall.utils.Result;
import com.eespindola.ms.getall.models.UsuarioML;
import com.eespindola.ms.getall.utils.FolioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@RestController
@RequestMapping("/usuarioAPI")
public class UsuarioRestController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioImp usuarioDAO;

    @PostMapping
    public Result<UsuarioML> GetAll(@RequestHeader(value = "folioRequest", required = false) String folioRequest){

        folioRequest = (folioRequest == null || folioRequest.isEmpty() || folioRequest.isBlank())? FolioRequest.CrearFolioRequest() : folioRequest;

        Result<UsuarioML> result = new Result<>();

        try {

//            List<UsuarioJPA> usuariosJPA = usuarioRepository.findAll();
//            List<UsuarioML> usuariosML = new ArrayList<>();
//
//            for(UsuarioJPA usuarioJPA : usuariosJPA){
//               usuariosML.add(UsuarioMapper.Map(usuarioJPA));
//            }

            result.objects = usuarioDAO.GetAll().objects;
            result.message = MessageFormat.format("Folio: {0}", folioRequest);
            result.isCorrect = true;

        } catch (Exception e){
            result.isCorrect = false;
            result.exception = e;
            result.message = e.getLocalizedMessage();
        }
        return result;
    }


}
