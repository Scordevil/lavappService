/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Color_TO;
import java.util.List;

/**
 *
 * @author VaioDevelopment
 */
public interface ColorDAO {

    public List<Color_TO> consultarColores() throws Exception;

    public Color_TO consultarColor(Color_TO color) throws Exception;

}
