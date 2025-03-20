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
                LlenarMes("Mes", ddlMes);
                LlenarAnios("Año", ddlAnio);
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

        public void LlenarAnios(string porDefecto, DropDownList ddl)
        {
            ddl.Items.Clear();
            ddl.Items.Add(new ListItem(porDefecto, ""));

            int anhoActual = DateTime.Now.Year;
            for (int anho = anhoActual - 10; anho <= anhoActual; anho++)
            {
                ddl.Items.Add(new ListItem(anho.ToString(), anho.ToString()));
            }
        }

        public void LlenarMes(string porDefecto, DropDownList ddl)
        {
            ddl.Items.Clear();
            ddl.Items.Add(new ListItem(porDefecto, ""));
            ddl.Items.Add(new ListItem("Enero", "1"));
            ddl.Items.Add(new ListItem("Febrero", "2"));
            ddl.Items.Add(new ListItem("Marzo", "3"));
            ddl.Items.Add(new ListItem("Abril", "4"));
            ddl.Items.Add(new ListItem("Mayo", "5"));
            ddl.Items.Add(new ListItem("Junio", "6"));
            ddl.Items.Add(new ListItem("Julio", "7"));
            ddl.Items.Add(new ListItem("Agosto", "8"));
            ddl.Items.Add(new ListItem("Septiembre", "9"));
            ddl.Items.Add(new ListItem("Octubre", "10"));
            ddl.Items.Add(new ListItem("Noviembre", "11"));
            ddl.Items.Add(new ListItem("Diciembre", "12"));
        }
    }
}