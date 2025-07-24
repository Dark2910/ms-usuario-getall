package com.eespindola.ms.getall.service.imp;

import com.eespindola.ms.getall.dao.UsuarioDao;
import com.eespindola.ms.getall.jpa.UsuarioRepository;
import com.eespindola.ms.getall.mapper.UsuarioMapper;
import com.eespindola.ms.getall.models.UsuarioMl;
import com.eespindola.ms.getall.models.dto.Result;
import com.eespindola.ms.getall.models.dto.UsuarioDto;
import com.eespindola.ms.getall.service.UsuarioService;
import com.eespindola.ms.getall.utils.FolioUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioDao usuarioDAO;

    @Autowired
    public UsuarioServiceImpl (
            UsuarioRepository repository,
            UsuarioDao dao
    ){
        this.usuarioRepository = repository;
        this.usuarioDAO = dao;
    }

    @Override
    public Result<UsuarioDto> consultarUsuarios(Result<Void> request) {

        Result<UsuarioDto> response = new Result<>();
        response.setFolioRequest(Objects.requireNonNullElse(request.getFolioRequest(), FolioUtils.createFolioRequest()));

        try {
//            List<UsuarioJPA> listaUsuariosJPA = usuarioRepository.findAll();
//            List<UsuarioResponse> listaUsuariosResponse = listaUsuariosJPA.stream()
//                    .map(UsuarioMapper::toUsuarioResponse)
//                            .collect(Collectors.toList());

            List<UsuarioMl> listaUsuariosML = usuarioDAO.getAll();
            List<UsuarioDto> listaUsuariosResponse = listaUsuariosML.stream()
                    .map(UsuarioMapper::toUsuarioDto)
                    .toList();

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
