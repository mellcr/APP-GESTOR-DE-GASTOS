using SazonWareBO;
using SazonWareBO.ServicioWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SazonWareWA
{
    /* 
     * ------------------------------------------------
     * Nombre Completo: MELL ALESSANDRA CARBAJAL ROMAN
     *  DNI: 76284769
     * ------------------------------------------------
     */
    public partial class RegistrarPlato : System.Web.UI.Page
    {
        private BindingList<ingrediente> gastos;
        private BindingList<ingrediente> ingredientesPlato;
        private GastoBO gastoBO;

        public RegistrarPlato()
        {
            gastoBO = new GastoBO();
            //videojuegoBO = new VideojuegoBO();
        }
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                gastos = gastoBO.listarTodos();
                ddlIngredientes.DataSource = gastos;
                ddlIngredientes.DataTextField = "nombre";
                ddlIngredientes.DataValueField = "idIngrediente";
                ViewState["gastos"] = new BindingList<ingrediente>(gastos); 
                ddlIngredientes.DataBind();
            }

            if (ViewState["ingredientesPlato"] == null)
                ingredientesPlato = new BindingList<ingrediente>();
            else
                ingredientesPlato = (BindingList<ingrediente>)ViewState["ingredientesPlato"];
            dgvIngredientes.DataSource = ingredientesPlato;
            dgvIngredientes.DataBind();

            ddlIngredientes_SelectedIndexChanged(sender, e);
            Cargar_Foto(sender, e);
        }

        protected void Cargar_Foto(object sender, EventArgs e)
        {
            if (IsPostBack && fileUploadFotoPlato.PostedFile != null && fileUploadFotoPlato.HasFile)
            {
                string extension = System.IO.Path.GetExtension(fileUploadFotoPlato.FileName);
                if (extension.ToLower() == ".jpg" || extension.ToLower() == ".jpeg" || extension.ToLower() == ".png" || extension.ToLower() == ".gif")
                {
                    string filename = Guid.NewGuid().ToString() + extension;
                    string filePath = Server.MapPath("~/Uploads/") + filename;
                    fileUploadFotoPlato.SaveAs(Server.MapPath("~/Uploads/") + filename);
                    imgFotoPlato.ImageUrl = "~/Uploads/" + filename;
                    imgFotoPlato.Visible = true;
                    FileStream fs = new FileStream(filePath, FileMode.Open, FileAccess.Read);
                    BinaryReader br = new BinaryReader(fs);
                    Session["foto"] = br.ReadBytes((int)fs.Length);
                    fs.Close();
                }
                else
                {
                    Response.Write("Por favor, selecciona un archivo de imagen válido.");
                }
            }
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("Home.aspx");
        }

        protected void ddlIngredientes_SelectedIndexChanged(object sender, EventArgs e)
        {
            int idIngrediente = Int32.Parse(ddlIngredientes.SelectedValue);
            gastos = (BindingList<ingrediente>)ViewState["gastos"];

            ingrediente ingrediente = gastos.SingleOrDefault(x => x.idIngrediente == idIngrediente);
            txtDescripcion.Text = ingrediente.descripcion;
        }

        protected void lbAgregar_Click(object sender, EventArgs e)
        {
            int idIngrediente = Int32.Parse(ddlIngredientes.SelectedValue);
            gastos = (BindingList<ingrediente>)ViewState["gastos"];
            ingrediente ingrediente = gastos.SingleOrDefault(x => x.idIngrediente == idIngrediente);
            ingredientesPlato.Add(ingrediente);
            ViewState["ingredientesPlato"] = ingredientesPlato;
            dgvIngredientes.DataSource = ingredientesPlato;
            dgvIngredientes.DataBind();
        }

        protected void btnEliminar_Click(object sender, EventArgs e)
        {
            int idIngrediente = Int32.Parse(((LinkButton)sender).CommandArgument);
            ingredientesPlato = (BindingList<ingrediente>)ViewState["ingredientesPlato"];
            ingrediente ingrediente = ingredientesPlato.SingleOrDefault(x => x.idIngrediente == idIngrediente);
            ingredientesPlato.Remove(ingrediente);
            ViewState["ingredientesPlato"] = ingredientesPlato;
            dgvIngredientes.DataSource = ingredientesPlato;
            dgvIngredientes.DataBind();
        }
    }
}