package pe.mibanco.soft.gasto.bo;
import java.util.ArrayList;
import java.util.Date;
import pe.mibanco.soft.gasto.dao.GastoDAO;
import pe.mibanco.soft.gasto.daoImpl.GastoDAOImpl;
import pe.mibanco.soft.gasto.model.Gasto;


/**
 * Implementación del Business Object para la gestión de gastos
 */
public class GastoBO {
    private final GastoDAO gastoDAO;

    public GastoBO() {
        this.gastoDAO = new GastoDAOImpl();
    }

    public Integer insertar(String titulo, String motivo, Date fecha, Double monto) {
        Gasto gasto = new Gasto(null, titulo, motivo, fecha, monto);
        return gastoDAO.insertar(gasto);
    }

    public Integer modificar(Integer idGasto, String titulo, String motivo, Date fecha, Double monto) {
        Gasto gasto = new Gasto(idGasto, titulo, motivo, fecha, monto);
        return gastoDAO.modificar(gasto);
    }

    public ArrayList<Gasto> listarTodos() {
        return gastoDAO.listarTodos();
    }

    public Gasto obtenerPorId(Integer idGasto) {
        return gastoDAO.obtenerPorId(idGasto);
    }
    
    public Integer eliminar(Gasto gasto) {
        return gastoDAO.eliminar(gasto);
    }
    
    public ArrayList<Gasto> listarGastosPorMes(Integer mes, Integer anio) {
        GastoDAOImpl gastoDAO = new GastoDAOImpl();
        return gastoDAO.listarPorMes(mes, anio);
    }
}