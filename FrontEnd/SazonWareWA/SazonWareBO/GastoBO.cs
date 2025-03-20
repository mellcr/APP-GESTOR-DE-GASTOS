using SazonWareBO.ServicioWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SazonWareBO
{
    public class GastoBO : BaseBO
    {
        public BindingList<gasto> listarTodos()
        {
            gasto[] arreglo = WsGasto.listarGastos();
            if (arreglo == null)
            {
                return new BindingList<gasto>();
            }
            return new BindingList<gasto>(arreglo);
        }

        public int insertar(string titulo, string motivo, DateTime fecha, Double monto)
        {
            return this.WsGasto.insertarGasto( titulo, motivo, fecha, monto);
        }

        public int modificar(int idGasto, string titulo, string motivo, DateTime fecha, Double monto)
        {
            return this.WsGasto.modificarGasto(idGasto, titulo, motivo, fecha, monto);
        }

        public int eliminar(int idGasto)
        {
            return this.WsGasto.eliminarGasto(idGasto);
        }

        public gasto obtenerPorId(int idGasto)
        {
            return this.WsGasto.obtenerGastoPorId(idGasto);
        }

        public BindingList<gasto> buscarGastoFecha(int mes, int anhio)
        {
            gasto[] arreglo = this.WsGasto.listarGastosPorMes(mes,anhio);
            return new BindingList<gasto>(arreglo);
        }
    }
}
