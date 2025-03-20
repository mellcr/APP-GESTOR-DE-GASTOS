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
            if (!IsPostBack)
            {
                gdvLocal.DataSource = gastoBO.listarTodos();
                gdvLocal.DataBind();
            }
        }

        protected void lbBuscarRecurso_Click(object sender, EventArgs e)
        {
            int mes = Int32.Parse(ddlMes.Text);
            int anho = Int32.Parse(ddlAnio.Text);
            gdvLocal.DataSource = gastoBO.buscarGastoFecha(mes, anho);
            gdvLocal.DataBind();
        }

        protected void gdvLocal_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {

        }
    }
}