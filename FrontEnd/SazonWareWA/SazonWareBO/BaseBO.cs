using SazonWareBO.ServicioWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SazonWareBO
{
    public class BaseBO
    {
        //                 nombreWS
        private ServicioWS.ServicioWSClient wsGasto;

        public BaseBO()
        {
            this.WsGasto = new ServicioWS.ServicioWSClient();
 
        }

        public ServicioWSClient WsGasto { get => wsGasto; set => wsGasto = value; }
    }
}
