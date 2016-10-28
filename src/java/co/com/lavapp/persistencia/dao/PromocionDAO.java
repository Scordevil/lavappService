/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Promocion_TO;
import java.util.List;

/**
 *
 * @author VaioDevelopment
 */
public interface PromocionDAO {
    
    public List<Promocion_TO> consultarPromociones() throws Exception;
    public Promocion_TO consultarPromocion(Promocion_TO promocion) throws Exception;
    public void registrarPromocion(Promocion_TO promocion) throws Exception;
    public void editarPromocion(Promocion_TO promocion) throws Exception;
    public void eliminarPromocion(Promocion_TO promocion) throws Exception;
}
