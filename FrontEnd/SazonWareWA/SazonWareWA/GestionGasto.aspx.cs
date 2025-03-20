using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SazonWareWA
{
    public partial class GestionGasto : System.Web.UI.Page
    {
        public GestionGasto()
        {

        }
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                MantenimientoGasto mantenimiento = new MantenimientoGasto();
                //mantenimiento.LlenarMes(" - ", ddlMes);
                //mantenimiento.LlenarAnios(" - ", ddlAnio);
            }
        }

        protected void lbBuscarLocal_Click(object sender, EventArgs e)
        {
            string script = "window.onload = function() { showModalFormLocal() };";
            ClientScript.RegisterStartupScript(GetType(), "", script, true);
        }

        protected void lbBuscarRecurso_Click(object sender, EventArgs e)
        {
            string script = "window.onload = function() { showModalFormRecurso() };";
            ClientScript.RegisterStartupScript(GetType(), "", script, true);
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("mantenimiento_kardex.aspx");
        }

        protected void btnGenerar_Click(object sender, EventArgs e)
        {

        }

        protected void ModalLocal_lbBuscarLocal_Click(object sender, EventArgs e)
        {

        }

        protected void ModalLocal_gvClientes_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {

        }

        protected void ModalLocal_lbSeleccionar_Click(object sender, EventArgs e)
        {

        }

        protected void ModalRecurso_lbBuscarRecurso_Click(object sender, EventArgs e)
        {

        }

        protected void ModalRecurso_lbBuscarRecurso_Click1(object sender, EventArgs e)
        {

        }

        protected void ModalRecurso_lbSeleccionar_Click(object sender, EventArgs e)
        {

        }

        protected void ModalRecurso_gvClientes_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {

        }




    }
}