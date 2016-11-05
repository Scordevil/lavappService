/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.metodos;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Pedido_TO;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author VaioDevelopment
 */
public class GenerarReportes {

    public String rutaDocumento;
    public ConexionSQL conexion = new ConexionSQL();

    public String getRutaDocumento() {
        return rutaDocumento;
    }

    public void setRutaDocumento(String rutaDocumento) {
       this.rutaDocumento = rutaDocumento;
    }

    //Metodos
    public String getPath() {
        try {
            ExternalContext tmpEC;

            tmpEC = FacesContext.getCurrentInstance().getExternalContext();
            String realPath = tmpEC.getRealPath("/");
            return realPath;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
    
    public String getPathDocumentos() {
        try {
            String path = getPath() + "/resources/documentos/";
            return path;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public void generarOrdenTrabajo(Pedido_TO pedido) throws JRException, IOException {       
        Map parametro = new HashMap();
        parametro.put("idpedido", pedido.getIdPedido());

        File jasper = new File(getPath() + "/resources/reportes/ordenTrabajo.jasper");
        JasperPrint jp = JasperFillManager.fillReport(jasper.getAbsolutePath(), parametro, conexion.getCn());

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=Orden de trabajo N°" + pedido.getIdPedido() + ".pdf");
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jp, stream);

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }
    
    public void generarOrdenTrabajoProveedor(Pedido_TO pedido) throws JRException, IOException {
       
        Map parametro = new HashMap();
        parametro.put("idpedido", pedido.getIdPedido());

        File jasper = new File(getPath() + "/resources/reportes/ordenTrabajoProveedor.jasper");
        JasperPrint jp = JasperFillManager.fillReport(jasper.getAbsolutePath(), parametro, conexion.getCn());

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=Orden de trabajo planta N°" + pedido.getIdPedido() + ".pdf");
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jp, stream);

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void generarOrdenTrabajoEnContexto(Pedido_TO pedido) {
        try {
            String path = getPathDocumentos() + "Orden de trabajo N°" + pedido.getIdPedido() + ".pdf";          
            Map parametro = new HashMap();
            parametro.put("idpedido", pedido.getIdPedido());

            File jasper = new File(getPath() + "/resources/reportes/ordenTrabajo.jasper");
            JasperPrint jp = JasperFillManager.fillReport(jasper.getAbsolutePath(), parametro, conexion.getCn());

            JasperExportManager.exportReportToPdfFile(jp, path);
        } catch (JRException e) {
            e.getMessage();
        }
    }
    
    public void generarOrdenTrabajoProveedorEnContexto(Pedido_TO pedido) {
        try {
            String path = getPathDocumentos() + "Orden de trabajo proveedor N°" + pedido.getIdPedido() + ".pdf";           
            Map parametro = new HashMap();
            parametro.put("idpedido", pedido.getIdPedido());

            File jasper = new File(getPath() + "/resources/reportes/ordenTrabajoProveedor.jasper");
            JasperPrint jp = JasperFillManager.fillReport(jasper.getAbsolutePath(), parametro, conexion.getCn());

            JasperExportManager.exportReportToPdfFile(jp, path);
        } catch (JRException e) {
            e.getMessage();
        }
    }
    
    //Metodos para generar el reporte
    public void generarOrdenTrabajoParaCorreo(Pedido_TO pedido) {
        String ruta = getPathDocumentos() + "Orden de trabajo N°" + pedido.getIdPedido() + ".pdf";
        File fichero = new File(ruta);
        if (!fichero.exists()) {
            generarOrdenTrabajoEnContexto(pedido);
        }
        rutaDocumento = getPathDocumentos() + "Orden de trabajo N°" + pedido.getIdPedido() + ".pdf";
    }
    
    public void generarOrdenTrabajoProveedorParaCorreo(Pedido_TO pedido) {       
        String ruta = getPathDocumentos() + "Orden de trabajo planta N°" + pedido.getIdPedido() + ".pdf";
        File fichero = new File(ruta);
        if (!fichero.exists()) {
            generarOrdenTrabajoProveedorEnContexto(pedido);
        }
        rutaDocumento = getPathDocumentos() + "Orden de trabajo planta N°" + pedido.getIdPedido() + ".pdf";
    }
}
