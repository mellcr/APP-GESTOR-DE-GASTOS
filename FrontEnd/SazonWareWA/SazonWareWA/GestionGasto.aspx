<%@ Page Title="" Language="C#" MasterPageFile="~/SoftMiBanco.Master" AutoEventWireup="true" CodeBehind="GestionGasto.aspx.cs" Inherits="SazonWareWA.GestionGasto" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Generación - Kardex
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <script src="Scripts/lib/gestionar_kardex.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <h2>Creación reporte de Kardex</h2>
        <div style="border-top: 1px solid #dcdcdc; margin: 10px 0; width: 100%;"></div>
        <!-- Local -->
        <div class="mb-2 card">
            <div class="card-header">
                <h5>Detalle del Local</h5>
            </div>
            <div class="card-body">
                <div class="mb-2 row">
                    <asp:Label ID="lblIdLocal" runat="server" Text="Id del Local:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-3">
                        <asp:TextBox ID="txtIdLocal" runat="server" Enabled="false" CssClass="form-control" />
                    </div>
                </div>
                <div class="mb-2 row align-items-center">
                    <asp:Label ID="lblNombreLocal" runat="server" Text="Nombre del Local:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-5 d-flex align-items-center">
                        <asp:TextBox ID="txtNombreLocal" runat="server" Enabled="false" CssClass="form-control me-2" />
                        <asp:LinkButton ID="lbBuscarLocal" CssClass="btn btn-info btn-sm" runat="server" Text="<i class='fa fa-search'></i>" OnClick="lbBuscarLocal_Click" />
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Producto -->
        <div class="mb-2 card">
            <div class="card-header">
                <h5>Detalle del Producto</h5>
            </div>
            <div class="card-body">
                <div class="mb-2 row">
                    <asp:Label ID="LblIdRecurso" runat="server" Text="Id del Recurso:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-3">
                        <asp:TextBox ID="txtIdRecurso" runat="server" Enabled="false" CssClass="form-control" />
                    </div>
                </div>
                <div class="mb-2 row align-items-center">
                    <asp:Label ID="lblNombreRecurso" runat="server" Text="Nombre del Recurso:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-5 d-flex align-items-center">
                        <asp:TextBox ID="txtNombreRecurso" runat="server" Enabled="false" CssClass="form-control me-2" />
                        <asp:LinkButton ID="lbBuscarRecurso" CssClass="btn btn-info btn-sm" runat="server" Text="<i class='fa fa-search'></i>" OnClick="lbBuscarRecurso_Click" />
                    </div>
                </div>
            </div>
        </div>

        <!-- Periodo -->
        <div class="mb-2 card">
            <div class="card-header">
                <h5>Detalle del Periodo</h5>
            </div>
            <div class="card-body">
                <!-- Columna para los filtros de mes y año -->
                <div class="col-md-8 d-flex align-items-center">
                    <label for="ddlMes" class="col-sm-2 col-form-label me-3">Seleccione un mes:</label>
                    <asp:DropDownList ID="ddlMes" runat="server" CssClass="form-control me-5">
                        <asp:ListItem Text="Mes" Value="" Selected="True" Enabled="False"></asp:ListItem>
                    </asp:DropDownList>
                    <label for="ddlAnio" class="col-sm-2 col-form-label me-3">Seleccione un año:</label>
                    <asp:DropDownList ID="ddlAnio" runat="server" CssClass="form-control me-3">
                        <asp:ListItem Text="Año" Value="" Selected="True" Enabled="False"></asp:ListItem>
                    </asp:DropDownList>
                </div>
            </div>
        </div>
        <!-- Descripcion -->
        <div class="mb-2 card">
            <div class="card-header">
                <h5>Descripción del reporte</h5>
            </div>
            <div class="card-body">
                <div class="mb-3">
                  <textarea class="form-control" id="textDescripcion" rows="3" placeholder="Escribe aquí los comentarios o detalles adicionales..."></textarea>
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
    <!-- Selección de local -->
    <div class="modal" id="form-modal-local">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Búsqueda de Local</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="container row pb-3 pt-3">
                                <div class="row align-items-center">
                                    <div class="col-auto">
                                        <asp:Label CssClass="form-label" runat="server" Text="Ingresar nombre:"></asp:Label>
                                    </div>
                                    <div class="col-sm-3">
                                        <asp:TextBox CssClass="form-control" ID="ModalLocal_txtNombreLocal" runat="server"></asp:TextBox>
                                    </div>
                                    <div class="col-sm-2">
                                        <asp:LinkButton ID="ModalLocal_lbBuscarLocal" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar" OnClick="ModalLocal_lbBuscarLocal_Click" />
                                    </div>
                                </div>
                            </div>
                            <div class="container row">
                                <asp:GridView ID="ModalLocal_gvClientes" runat="server" AllowPaging="true" PageSize="5" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" OnPageIndexChanging="ModalLocal_gvClientes_PageIndexChanging">
                                    <Columns>
                                        <asp:BoundField HeaderText="Id" DataField="IdLocal" />
                                        <asp:BoundField HeaderText="Nombre" DataField="Nombre" />
                                        <asp:BoundField HeaderText="Tipo de Local" DataField="tipoLocal" />
                                        <asp:TemplateField>
                                            <ItemTemplate>
                                                <asp:LinkButton ID="ModalLocal_lbSeleccionar" class="btn btn-success" runat="server" Text="<i class='fa-solid fa-check ps-2'></i> Seleccionar" OnClick="ModalLocal_lbSeleccionar_Click" CommandArgument='<%# Eval("IdLocal") %>' />
                                            </ItemTemplate>
                                        </asp:TemplateField>
                                    </Columns>
                                </asp:GridView>
                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>
    <!-- Selección de recurso -->
    <div class="modal" id="form-modal-recurso">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Búsqueda de Recurso</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="container row pb-3 pt-3">
                                <div class="row align-items-center">
                                    <div class="col-auto">
                                        <asp:Label CssClass="form-label" runat="server" Text="Ingresar nombre:"></asp:Label>
                                    </div>
                                    <div class="col-sm-3">
                                        <asp:TextBox CssClass="form-control" ID="ModalRecurso_txtNombreRecurso" runat="server"></asp:TextBox>
                                    </div>
                                    <div class="col-sm-2">
                                        <asp:LinkButton ID="ModalRecurso_lbBuscarRecurso" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar" OnClick="ModalRecurso_lbBuscarRecurso_Click1" />
                                    </div>
                                </div>
                            </div>
                            <div class="container row">
                                <asp:GridView ID="ModalRecurso_gvClientes" runat="server" AllowPaging="true" PageSize="5" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" OnPageIndexChanging="ModalRecurso_gvClientes_PageIndexChanging">
                                    <Columns>
                                        <asp:BoundField HeaderText="Id" DataField="IdRecurso" />
                                        <asp:BoundField HeaderText="Nombre" DataField="Nombre" />
                                        <asp:TemplateField>
                                            <ItemTemplate>
                                                <asp:LinkButton ID="ModalRecurso_lbSeleccionar" class="btn btn-success" runat="server" Text="<i class='fa-solid fa-check ps-2'></i> Seleccionar" OnClick="ModalRecurso_lbSeleccionar_Click" CommandArgument='<%# Eval("IdRecurso") %>' />
                                            </ItemTemplate>
                                        </asp:TemplateField>
                                    </Columns>
                                </asp:GridView>
                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>
</asp:Content>