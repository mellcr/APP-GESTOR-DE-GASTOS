<%@ Page Title="" Language="C#" MasterPageFile="~/SoftMiBanco.Master" AutoEventWireup="true" CodeBehind="GestionGasto.aspx.cs" Inherits="SazonWareWA.GestionGasto" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Generación - Gastos
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <script src="Scripts/lib/gestionar_kardex.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <h2>
            <!-- Cambiar el titulo dependiendo de si se registran o muestran datos -->
            <asp:Label ID="lblTitulo" runat="server"></asp:Label>
        </h2>
        <div style="border-top: 1px solid #dcdcdc; margin: 10px 0; width: 100%;"></div>

        <!-- Detalle del Gasto -->
        <div class="mb-2 card">
            <div class="card-header">
                <h5>Detalle del Gasto</h5>
            </div>
            <div class="card-body">
                <div class="mb-2 row">
                    <asp:Label ID="LblIdGasto" runat="server" Text="Id del Gasto:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-3">
                        <asp:TextBox ID="txtIdGasto" runat="server" Enabled="false" CssClass="form-control" />
                    </div>
                </div>
                <div class="mb-2 row align-items-center">
                    <asp:Label ID="lblNombreGasto" runat="server" Text="Titulo del Gasto:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-4">
                        <asp:TextBox ID="txtNombreGasto" runat="server" Enabled="true" CssClass="form-control" />
                    </div>
                </div>
                <div class="mb-2 row">
                    <asp:Label ID="lblMonto" runat="server" Text="Monto:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-3">
                        <asp:TextBox ID="txtMonto" runat="server" Enabled="true" CssClass="form-control" />
                    </div>
                </div>
                <div class="mb-2 row">
                    <asp:Label ID="lblFecha" runat="server" Text="Fecha:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-3">
                        <asp:TextBox ID="txtFecha" runat="server" CssClass="form-control" TextMode="Date" />
                    </div>
                </div>
                <div class="mb-2 row">
                    <asp:Label ID="lblMotivo" runat="server" Text="Motivo:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-6">
                        <textarea class="form-control" id="textMotivo" rows="3" placeholder="Escribe aquí el motivo o detall adicional..."></textarea>
                    </div>
                </div>
            </div>
        </div>

        <!-- Botones -->
        <div>
            <asp:Button ID="btnGenerar" runat="server" CssClass="float-end btn btn-primary me-2" Text="  Generar  " OnClick="btnGenerar_Click" />
            <asp:LinkButton ID="lbRegresar" runat="server" CssClass="float-end btn btn-secondary me-2" Text="<i class='fa fa-arrow-left me-1'></i> Regresar" OnClick="lbRegresar_Click" />
        </div>
    </div>
    <!-- Modal -->
    <asp:ScriptManager runat="server"></asp:ScriptManager>
    <!-- Modal para Mensaje de error -->
    <div class="modal fade" id="errorModal2" tabindex="-1" aria-labelledby="errorModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header bg-danger text-white">
                    <h5 class="modal-title" id="errorModalLabel">
                        <i class="bi bi-exclamation-triangle-fill me-2"></i>Mensaje de Error
                        </h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:Label ID="lblMensajeError" runat="server" Text="Mensaje de ejemplo..." CssClass="form-text text-danger"></asp:Label>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>
</asp:Content>
