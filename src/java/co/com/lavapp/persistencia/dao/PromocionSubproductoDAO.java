/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Promocion_TO;
import co.com.lavapp.modelo.dto.SubProducto_TO;

/**
 *
 * @author VaioDevelopment
 */
public interface PromocionSubproductoDAO {
    
    public void asociarPromocionSubProducto(Promocion_TO promocion, SubProducto_TO subProducto) throws Exception;
    public void eliminarPromocion(Promocion_TO promocion, SubProducto_TO subproducto) throws Exception;
    
}
