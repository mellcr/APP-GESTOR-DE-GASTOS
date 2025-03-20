
package softgastotester;
import pe.mibanco.soft.config.DBManagerEncrip;
import pe.mibanco.soft.gasto.bo.GastoBO;
import pe.mibanco.soft.gasto.model.Gasto;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import pe.mibanco.soft.util.Cifrado;
import java.util.Calendar;

/*
 * @author mell1
 */
public class SoftGastoTester {

    public static void main(String[] args) throws ParseException {
        //String claveOriginal = "retomibanco17"; // Tu clave real
        //String claveCifrada = Cifrado.cifrarMD5(claveOriginal);
        //System.out.println("Contraseña cifrada: " + claveCifrada);
        
        //testConexionDB();
        //testInsertarGasto();
        //testModificarGasto();
        //testListarGastos();
        //testObtenerGastoPorId();
        //testEliminarGasto();
        
        
        //
        testListarGastosPorMes();
    }
    
    private static void testConexionDB() {
        DBManagerEncrip dbManager = DBManagerEncrip.getInstance();
        Connection conexion = dbManager.getConnection();
        if (conexion != null) {
            System.out.println("Conexion a la base de datos exitosa.");
        } else {
            System.out.println("Error al conectar con la base de datos.");
        }
    }
    

    private static void testInsertarGasto() throws ParseException {
        GastoBO gastoBO = new GastoBO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha= sdf.parse("2025-3-20");
        Integer idGasto = gastoBO.insertar("PrimeVideo", "Pago mensual", fecha, 120.00);
        if (idGasto != null) {
            System.out.println("Gasto insertado con ID: " + idGasto);
        } else {
            System.out.println("Error al insertar gasto.");
        }
    }

    private static void testModificarGasto() throws ParseException {
        GastoBO gastoBO = new GastoBO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha= sdf.parse("2025-11-20");
        
        Integer resultado = gastoBO.modificar(2, "Alquiler", "Pago mensual", fecha, 1250.00);
        if (resultado != null && resultado > 0) {
            System.out.println("Gasto modificado correctamente.");
        } else {
            System.out.println("Error al modificar gasto.");
        }
    }

    private static void testEliminarGasto() {
        GastoBO gastoBO = new GastoBO();
        Integer resultado = gastoBO.eliminar(gastoBO.obtenerPorId(4));
        if (resultado != null && resultado > 0) {
            System.out.println("Gasto eliminado correctamente.");
        } else {
            System.out.println("Error al eliminar el gasto.");
        }
    }

    private static void testListarGastos() {
        GastoBO gastoBO = new GastoBO();
        ArrayList<Gasto> gastos = gastoBO.listarTodos();
        if (gastos != null && !gastos.isEmpty()) {
            System.out.println("Lista de gastos:");
            for (Gasto gasto : gastos) {
                System.out.println(gasto.toString());
            }
        } else {
            System.out.println("No hay gastos registrados.");
        }
    }
    
    private static void testObtenerGastoPorId() {
        GastoBO gastoBO = new GastoBO();
        Gasto gasto = gastoBO.obtenerPorId(1);
        if (gasto != null) {
            System.out.println("Gasto encontrado: " + gasto);
        } else {
            System.out.println("No se encontró el gasto con ID especificado.");
        }
    }
    
    private static void testListarGastosPorMes() {
        GastoBO gastoBO = new GastoBO();
        int mes = 3;  // Marzo
        int anio = 2025;

        ArrayList<Gasto> gastos = gastoBO.listarGastosPorMes(mes, anio);

        if (gastos != null && !gastos.isEmpty()) {
            System.out.println("Gastos en " + mes + "/" + anio + ":");
            for (Gasto gasto : gastos) {
                System.out.println(gasto);
            }
        } else {
            System.out.println("No hay gastos registrados en este mes.");
        }
    }
}
