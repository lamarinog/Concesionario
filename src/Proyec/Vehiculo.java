package Proyec;

/**
 *
 * @author Blanca
 */
public class Vehiculo {

    protected String modelo;
    protected String matricula;
    protected String color;
    protected boolean activo = true;
    //La incidencia va en String separados por comas sin espacios "incidencia abierta o cerrada, problema, horas"
    //ejemplo {"cerrada,llanta dañada,2"}
    protected String incidencia;

    public Vehiculo(String modelo, String matricula, String color) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.color = color;
    }

    public Vehiculo() {
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean getActivo() {
        return activo;
    }

    public String getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(String incidencia) {
        this.incidencia = incidencia;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
