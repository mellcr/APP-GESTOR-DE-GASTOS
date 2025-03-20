using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SazonWareBO;

namespace SazonWareWA
{
    public partial class MantenimientoGasto : System.Web.UI.Page
    {
        private GastoBO gastoBO;

        public MantenimientoGasto()
        {
            gastoBO = new GastoBO();
        }
        protected void Page_Load(object sender, EventArgs e)
        {

        }
    }
}