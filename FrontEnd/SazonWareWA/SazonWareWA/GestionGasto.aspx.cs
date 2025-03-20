using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SazonWareBO;

namespace SazonWareWA
{
    public partial class GestionGasto : System.Web.UI.Page
    {
        private GastoBO gastoBO;
        private int idGasto;
        private bool esta_modificando;
        private bool esta_viendo;
        public GestionGasto()
        {
            gastoBO = new GastoBO();
        }
        protected void Page_Init(object sender, EventArgs e)
        {
            if (Session["idGasto"] != null)
            {
                this.idGasto = (int)Session["idGasto"];
            }

            string accion = Request.QueryString["accion"];
            if (accion == "modificar")
            {
                esta_modificando = true;
                lblTitulo.Text = "Modificar Gastos";
                if (!IsPostBack)
                {
                    cargarDatosBDGastos();
                }
            }
            else if (accion == "ver")
            {
                esta_viendo = true;
                lblTitulo.Text = "Visualizar Datos Gastos";
                cargarDatosBDGastos();
                mostrarDatosLectura();
            }
            else
            {
                lblTitulo.Text = "Registrar Gasto";
            }
        }
        public void mostrarDatosLectura()
        {

        }
        private void cargarDatosBDGastos()
        {

        }

        protected void Page_Load(object sender, EventArgs e)
        {

            if (!IsPostBack)
            {
                if (!IsPostBack) // Para que solo se ejecute la primera vez
                {
                    txtFecha.Text = DateTime.Now.ToString("yyyy-MM-dd"); // Formato compatible con input type="date"
                }
            }
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("MantenimientoGasto.aspx");
        }

        protected void btnGenerar_Click(object sender, EventArgs e)
        {
            try
            {
                int idGasto = 0;
                if (this.esta_modificando)
                {
                    idGasto = int.Parse(txtIdGasto.Text);
                }

                string tituloGasto = txtNombreGasto.Text;
                Double monto = Double.Parse(txtMonto.Text);
                DateTime fecha = DateTime.Parse(txtFecha.Text);
                string motivo = textMotivo.Text;

                if (this.esta_modificando)
                {
                    gastoBO.modificar(idGasto, tituloGasto, motivo, fecha, monto);
                }
                else
                {
                    gastoBO.insertar(tituloGasto, motivo, fecha, monto);
                }

                // Redirige al mantenimiento después de guardar
                Response.Redirect("MantenimientoGasto.aspx");
            }
            catch
            {
                MostrarMensajeError("Ocurrió un error al guardar el gasto.");
            }
        }
        private bool ValidarCampos()
        {
            if (string.IsNullOrWhiteSpace(txtNombreGasto.Text)) return MostrarErrorCampo("Título del Gasto");
            if (!decimal.TryParse(txtMonto.Text, out _)) return MostrarErrorCampo("Monto");
            if (!DateTime.TryParse(txtFecha.Text, out _)) return MostrarErrorCampo("Fecha");
            return true;
        }

        private bool MostrarErrorCampo(string campo)
        {
            MostrarMensajeError($"El campo {campo} es obligatorio o tiene un formato incorrecto.");
            return false;
        }

        private void MostrarMensajeError(string mensaje)
        {
            lblMensajeError.Text = mensaje;
            ScriptManager.RegisterStartupScript(this, GetType(), "mostrarModal", "$('#errorModal2').modal('show');", true);
        }

    }
}