/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Departamento_TO;
import co.com.lavapp.persistencia.dao.DepartamentoDAO;
import co.com.lavapp.persistencia.dao.impl.DepartamentoDAOImpl;
import co.com.lavapp.servicio.EliminarDepartamento;
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
@Path("/eliminarDepartamento")
public class EliminarDepartamentoImpl implements EliminarDepartamento {

    @GET
    @Produces({"application/json"})
    @Override
    public Departamento_TO eliminarDepartamento(@QueryParam("idDepartamento") int idDepartamento) throws Exception {
        Departamento_TO departamento = new Departamento_TO(idDepartamento);
        DepartamentoDAO departamentoDao = new DepartamentoDAOImpl();
        return departamentoDao.eliminarDepartamento(departamento);
    }
}
