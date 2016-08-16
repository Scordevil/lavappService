/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Factura_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface FacturaDAO {
    
    public Factura_TO registrarFactura(Factura_TO factura) throws Exception;
    public Factura_TO eliminarFactura(Factura_TO factura) throws Exception;
    public Factura_TO consultarFacturaPedido(Pedido_TO pedido) throws Exception;
    public List<Factura_TO> consultarFacturas() throws Exception;
            
}
