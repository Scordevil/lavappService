/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.FormaPago_TO;

/**
 *
 * @author VaioDevelopment
 */
public interface FormaPagoDAO {
    
    public FormaPago_TO consultarFormaPago(FormaPago_TO formaPago) throws Exception;
    
}
