<%@ Page Title="" Language="C#" MasterPageFile="~/SoftMiBanco.Master" AutoEventWireup="true" CodeBehind="MantenimientoGasto.aspx.cs" Inherits="SazonWareWA.MantenimientoGasto" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mantenimiento - Gastos
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="estilo.css" rel="stylesheet">
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <h1>Listado de Gastos</h1>
    </div>
    <div style="border-top: 1px solid #dcdcdc; margin: 10px 0; width: 100%;"></div>
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
                <asp:LinkButton ID="lbBuscarRecurso" CssClass="btn btn-info btn-sm" runat="server" Text="<i class='fa fa-search'></i>" OnClick="lbBuscarRecurso_Click"/>
            </div>
        </div>
    </div>
    <!-- Tabla -->
    <div class="container row">
        <asp:GridView ID="gdvLocal" runat="server" AllowPaging="true" PageSize="15" OnPageIndexChanging="gdvLocal_PageIndexChanging" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
            <Columns>
                <asp:BoundField HeaderText="Titulo" DataField="titulo" />
                <asp:BoundField HeaderText="Motivo" DataField="motivo" />
                <asp:BoundField HeaderText="Fecha" DataField="fecha" />

                <asp:BoundField HeaderText="Dirección del Local" DataField="direccion" />
                <asp:TemplateField>
                    <ItemTemplate>
                        <asp:LinkButton ID="lbModificar" runat="server" CssClass="btn btn-sm btn-primary me-1" Text="<i class='fas fa-edit'></i>" CommandArgument='<%# Eval("IdLocal") %>' />
                        <asp:LinkButton ID="lblVisualizar" runat="server" CssClass="btn btn-sm btn-primary me-1" Text="<i class='fas fa-eye'></i>" CommandArgument='<%# Eval("IdLocal") %>' />
                        <asp:LinkButton ID="lbEliminar" runat="server" CssClass="btn btn-sm btn-danger" Text="<i class='fas fa-trash-alt'></i>" CommandArgument='<%# Eval("IdLocal") %>' />
                    </ItemTemplate>
                </asp:TemplateField>
            </Columns>
        </asp:GridView>
        <div class="container row">
        </div>
    </div>
</asp:Content>
