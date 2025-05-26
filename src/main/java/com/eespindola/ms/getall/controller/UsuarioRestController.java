package com.eespindola.ms.getall.controller;

import com.eespindola.ms.getall.dao.Implementation.UsuarioImp;
import com.eespindola.ms.getall.jpa.UsuarioRepository;
import com.eespindola.ms.getall.models.dto.Result;
import com.eespindola.ms.getall.models.UsuarioML;
import com.eespindola.ms.getall.utils.FolioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;

@RestController
@RequestMapping("/usuarioAPI")
public class UsuarioRestController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioImp usuarioDAO;

    @PostMapping
    public Result<UsuarioML> GetAll(@RequestHeader(value = "folioRequest", required = false) String folioRequest, @RequestBody Result<Void> request){

//        folioRequest = (folioRequest == null || folioRequest.isEmpty() || folioRequest.isBlank())? FolioRequest.CrearFolioRequest() : folioRequest;

        Result<UsuarioML> result = new Result<>();

        try {

//            List<UsuarioJPA> usuariosJPA = usuarioRepository.findAll();
//            List<UsuarioML> usuariosML = new ArrayList<>();
//
//            for(UsuarioJPA usuarioJPA : usuariosJPA){
//               usuariosML.add(UsuarioMapper.Map(usuarioJPA));
//            }

            result.setObjects(usuarioDAO.GetAll().getObjects());
//            result.message = MessageFormat.format("Folio: {0}", folioRequest);
            result.setFolio(request.getFolio());
            result.setIsCorrect(true);

        } catch (Exception e){
            result.setIsCorrect(false);
            result.setException(e);
            result.setMessage(e.getLocalizedMessage());
        }
        return result;
    }


}
