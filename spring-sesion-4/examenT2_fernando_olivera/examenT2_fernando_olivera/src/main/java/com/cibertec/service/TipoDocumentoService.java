package com.cibertec.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // <-- ¡ESTA ANOTACIÓN ES CRUCIAL!
import com.cibertec.entity.TipoDocumento;
import com.cibertec.repository.TipoDocumentoRepository;

@Service // <--- Asegúrate de que esta línea exista
public class TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    public List<TipoDocumento> getAll() {
        return tipoDocumentoRepository.findAll();
    }
}
