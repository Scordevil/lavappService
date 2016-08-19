/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Departamento_TO;
import co.com.lavapp.persistencia.dao.DepartamentoDAO;
import co.com.lavapp.persistencia.dao.impl.DepartamentoDAOImpl;
import co.com.lavapp.servicio.BuscarDepartamentos;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Desarrollo_Planit
 */
@Stateless
@Path("/buscarDepartamentos")
public class BuscarDepartamentosImpl implements BuscarDepartamentos{

    @GET
    @Produces({"application/json"})
    @Override
    public List<Departamento_TO> buscarDepartamentos(@QueryParam("valor") String valor) throws Exception {
        DepartamentoDAO departamentoDao = new DepartamentoDAOImpl();
        return departamentoDao.buscarDepartamentos(valor);
    }
    
}
