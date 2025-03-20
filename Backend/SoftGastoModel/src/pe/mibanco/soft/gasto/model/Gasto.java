package pe.mibanco.soft.gasto.model;
import java.io.Serializable;
import java.util.Date;

/*
 *
 * @author mell1
 */

public class Gasto implements Serializable {
    // Atributos
    private Integer idGasto;
    private String titulo;
    private String motivo;
    private Date fecha;
    private Double monto;
    private Boolean activo;

    // Constructor con parámetros
    public Gasto(Integer idGasto, String titulo, String motivo, Date fecha, 
            Double monto) {
        this.idGasto = idGasto;
        this.titulo = titulo;
        this.motivo = motivo;
        this.fecha = fecha;
        this.monto = monto;
        this.activo=true;
    }

    // Constructor vacío
    public Gasto() {
        this.activo=true;
    }

    // Getters y Setters
    public Integer getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(Integer idGasto) {
        this.idGasto = idGasto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
    
    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    // Método para actualizar los valores de un gasto existente
    public void actualizarGasto(Gasto nuevoGasto) {
        this.titulo = nuevoGasto.getTitulo();
        this.motivo = nuevoGasto.getMotivo();
        this.fecha = nuevoGasto.getFecha();
        this.monto = nuevoGasto.getMonto();
    }

    // Método toString para representar el gasto en texto
    @Override
    public String toString() {
        return "Gasto{" +
                "idGasto=" + idGasto +
                ", titulo='" + titulo + '\'' +
                ", motivo='" + motivo + '\'' +
                ", fecha=" + fecha +
                ", monto=" + monto +
                '}';
    }
}