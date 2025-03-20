
package pe.mibanco.soft.gasto.daoImpl;

import pe.mibanco.soft.gasto.dao.GastoDAO;
import pe.mibanco.soft.db.DAOImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import pe.mibanco.soft.gasto.model.Gasto;

/**
 * Implementación de GastoDAO
 */
public class GastoDAOImpl extends DAOImpl implements GastoDAO {
    private Gasto gasto;
    private String sqlFiltro;

    public GastoDAOImpl() {
        super("Gasto");
        this.gasto = null;
    }

    @Override
    public Integer insertar(Gasto gasto) {
        this.gasto = gasto;
        this.retornarLlavePrimaria = true;
        Integer idGasto = super.insertar();
        this.retornarLlavePrimaria = false;
        return idGasto;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idGasto, titulo, motivo, fecha, monto, activo";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.gasto.getIdGasto());
        this.incluirParametroString(2, this.gasto.getTitulo());
        this.incluirParametroString(3, this.gasto.getMotivo());
        this.incluirParametroDate(4, this.gasto.getFecha());
        this.incluirParametroDouble(5, this.gasto.getMonto());
        this.incluirParametroBoolean(6, this.gasto.getActivo());
    }

    @Override
    public Integer modificar(Gasto gasto) {
        this.gasto = gasto;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "titulo=?, motivo=?, fecha=?, monto=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idGasto=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, this.gasto.getTitulo());
        this.incluirParametroString(2, this.gasto.getMotivo());
        this.incluirParametroDate(3, this.gasto.getFecha());
        this.incluirParametroDouble(4, this.gasto.getMonto());
        this.incluirParametroInt(5, this.gasto.getIdGasto());
    }

    @Override
    public Integer eliminar(Gasto gasto) {
        this.gasto = gasto;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.gasto.getIdGasto());
    }

    @Override
    public ArrayList<Gasto> listarTodos() {
        return (ArrayList<Gasto>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idGasto, titulo, motivo, fecha, monto";
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.gasto = new Gasto();
        this.gasto.setIdGasto(resultSet.getInt("idGasto"));
        this.gasto.setTitulo(resultSet.getString("titulo"));
        this.gasto.setMotivo(resultSet.getString("motivo"));
        this.gasto.setFecha(resultSet.getDate("fecha"));
        this.gasto.setMonto(resultSet.getDouble("monto"));
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.gasto);
    }

    @Override
    public Gasto obtenerPorId(Integer idGasto) {
        this.gasto = new Gasto();
        this.gasto.setIdGasto(idGasto);
        super.obtenerPorId();
        return this.gasto;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.gasto.getIdGasto());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.gasto = null;
    }
    
    @Override
    protected String obtenerPredicadoParaListado(){
        if (this.sqlFiltro != null)
            return this.sqlFiltro;
        return super.obtenerPredicadoParaListado();
    }
    
    @Override
    public ArrayList<Gasto> listarPorMes(Integer mes, Integer anhio){
        String cadena = super.obtenerPredicadoParaListado();
        if (mes != null && anhio != null)
            this.sqlFiltro = cadena + " AND MONTH(fecha) = " + mes + 
                    " AND YEAR(fecha) = " + anhio;
        ArrayList<Gasto> gastos = this.listarTodos();
        this.sqlFiltro = null;
        return gastos;        
    }

}
