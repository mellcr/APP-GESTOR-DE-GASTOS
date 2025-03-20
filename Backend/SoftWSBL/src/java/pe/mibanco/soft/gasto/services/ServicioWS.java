
package pe.mibanco.soft.gasto.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.mibanco.soft.gasto.bo.GastoBO;
import pe.mibanco.soft.gasto.model.Gasto;

@WebService(serviceName = "ServicioWS")
public class ServicioWS {
    
    private final GastoBO gastoBO;
    
    public ServicioWS() {
        this.gastoBO = new GastoBO();
    }
    
    @WebMethod(operationName = "insertarGasto")
    public Integer insertarGasto(@WebParam(name = "titulo") String titulo,
                                 @WebParam(name = "motivo") String motivo,
                                 @WebParam(name = "fecha") Date fecha,
                                 @WebParam(name = "monto") Double monto) {
        try {
            return gastoBO.insertar(titulo, motivo, fecha, monto);
        } catch (Exception ex) {
            Logger.getLogger(ServicioWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @WebMethod(operationName = "modificarGasto")
    public Integer modificarGasto(@WebParam(name = "idGasto") Integer idGasto,
                                  @WebParam(name = "titulo") String titulo,
                                  @WebParam(name = "motivo") String motivo,
                                  @WebParam(name = "fecha") Date fecha,
                                  @WebParam(name = "monto") Double monto) {
        try {
            return gastoBO.modificar(idGasto, titulo, motivo, fecha, monto);
        } catch (Exception ex) {
            Logger.getLogger(ServicioWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @WebMethod(operationName = "listarGastos")
    public ArrayList<Gasto> listarGastos() {
        try {
            return gastoBO.listarTodos();
        } catch (Exception ex) {
            Logger.getLogger(ServicioWS.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    
    @WebMethod(operationName = "obtenerGastoPorId")
    public Gasto obtenerGastoPorId(@WebParam(name = "idGasto") Integer idGasto) {
        try {
            return gastoBO.obtenerPorId(idGasto);
        } catch (Exception ex) {
            Logger.getLogger(ServicioWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @WebMethod(operationName = "eliminarGasto")
    public Integer eliminarGasto(@WebParam(name = "idGasto") Integer idGasto) {
        try {
            Gasto gasto = gastoBO.obtenerPorId(idGasto);
            return gasto != null ? gastoBO.eliminar(gasto) : 0;
        } catch (Exception ex) {
            Logger.getLogger(ServicioWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @WebMethod(operationName = "listarGastosPorMes")
    public ArrayList<Gasto> listarGastosPorMes(@WebParam(name = "mes") Integer mes,
                                               @WebParam(name = "anio") Integer anio) {
        try {
            return gastoBO.listarGastosPorMes(mes, anio);
        } catch (Exception ex) {
            Logger.getLogger(ServicioWS.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
}
