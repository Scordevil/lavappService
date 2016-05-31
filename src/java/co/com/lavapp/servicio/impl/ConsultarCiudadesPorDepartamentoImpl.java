/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Ciudad_TO;
import co.com.lavapp.modelo.dto.Departamento_TO;
import co.com.lavapp.persistencia.dao.CiudadDAO;
import co.com.lavapp.persistencia.dao.impl.CiudadDAOImpl;
import co.com.lavapp.servicio.ConsultarCiudadesPorDepartamento;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Desarrollo_Planit
 */
@Stateless
@Path("/consultarCiudadesPorDepartamento")
public class ConsultarCiudadesPorDepartamentoImpl implements ConsultarCiudadesPorDepartamento{

    @Override
    public List<Ciudad_TO> consultarCiudadesPorDepartamento(@QueryParam("idDepartamento") int idDepartamento) throws Exception {
        Departamento_TO departamento = new Departamento_TO(idDepartamento);
        CiudadDAO ciudadDao = new CiudadDAOImpl();
        return ciudadDao.consultarCiudadesPorDepartamento(departamento);
    }
    
}
