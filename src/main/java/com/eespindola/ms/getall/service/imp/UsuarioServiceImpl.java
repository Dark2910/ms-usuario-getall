package com.eespindola.ms.getall.service.imp;

import com.eespindola.ms.getall.dao.UsuarioDAO;
import com.eespindola.ms.getall.jpa.UsuarioRepository;
import com.eespindola.ms.getall.jpa.entities.UsuarioJPA;
import com.eespindola.ms.getall.mapper.UsuarioMapper;
import com.eespindola.ms.getall.models.UsuarioML;
import com.eespindola.ms.getall.models.dto.Result;
import com.eespindola.ms.getall.models.dto.UsuarioResponse;
import com.eespindola.ms.getall.service.UsuarioService;
import com.eespindola.ms.getall.utils.FolioUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioDAO usuarioDAO;

    @Autowired
    public UsuarioServiceImpl (
            UsuarioRepository repository,
            UsuarioDAO dao
    ){
        this.usuarioRepository = repository;
        this.usuarioDAO = dao;
    }

    @Override
    public Result<UsuarioResponse> consultarUsuarios(Result<Void> request) {

        Result<UsuarioResponse> response = new Result<>();
        response.setFolioRequest(Objects.requireNonNullElse(request.getFolioRequest(), FolioUtil.createFolioRequest()));

        try {
//            List<UsuarioJPA> listaUsuariosJPA = usuarioRepository.findAll();
//            List<UsuarioResponse> listaUsuariosResponse = listaUsuariosJPA.stream()
//                    .map(UsuarioMapper::toUsuarioResponse)
//                            .collect(Collectors.toList());

            List<UsuarioML> listaUsuariosML = usuarioDAO.getAll();
            List<UsuarioResponse> listaUsuariosResponse = listaUsuariosML.stream()
                    .map(UsuarioMapper::toUsuarioResponse)
                    .collect(Collectors.toList());

            response.setObjects(listaUsuariosResponse);
            response.setIsCorrect(true);
            response.setMessage("Usuarios consultados correctamente");
        } catch (Exception e){
            response.setIsCorrect(false);
            response.setException(e);
            response.setMessage(e.getLocalizedMessage());
        }
        return response;
    }

}
