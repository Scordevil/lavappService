/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Promocion_TO;
import co.com.lavapp.modelo.dto.SubProducto_TO;
import java.util.List;

/**
 *
 * @author VaioDevelopment
 */
public interface PromocionSubproductoDAO {
    
    public int asociarPromocionSubProducto(Promocion_TO promocion, SubProducto_TO subProducto) throws Exception;
    public int eliminarAsociacionPromocionSubProducto(Promocion_TO promocion, SubProducto_TO subproducto) throws Exception;
    public int consultarPromocionSubProductoYaAsociada(Promocion_TO promocion, SubProducto_TO subproducto) throws Exception;
    public List<SubProducto_TO> consultarSubProductosSegunPromocion(Promocion_TO promocion) throws Exception;
            

}
