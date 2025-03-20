
package pe.mibanco.soft.gasto.dao;
import java.util.ArrayList;
import pe.mibanco.soft.gasto.model.Gasto;

/*
 *
 * @author mell1
 */
public interface GastoDAO {
    public Integer insertar(Gasto gasto);

    public Integer modificar(Gasto gasto);

    public Integer eliminar(Gasto gasto);

    public ArrayList<Gasto> listarTodos();

    public Gasto obtenerPorId(Integer idGasto);
    
    public ArrayList<Gasto> listarPorMes(Integer mes, Integer anhio);
}
