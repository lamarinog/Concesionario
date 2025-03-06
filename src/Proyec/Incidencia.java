package Proyec;

/**
 *
 * @author Blanca
 */
public class Incidencia {

    private String matricula;
    private int id_incidencia;
    private String incidencia;
    private int tiempo;//se ingresa el tiempo en minutos
    private boolean resuelto = false;

    public Incidencia() {
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setId_incidencia(int id_incidencia) {
        this.id_incidencia = id_incidencia;
    }

    public void setIncidencia(String incidencia) {
        this.incidencia = incidencia;
    }

    public void setResuelto(boolean resuelto) {
        this.resuelto = resuelto;
    }

    public void setTiempo(int tiempo) {
        if (this.resuelto) {
            this.tiempo = tiempo;
        } else {
            System.out.println("La incidencia aun no esta resuelta.");
        }
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Incidencia{" + "matricula=" + matricula + ", id_incidencia=" + id_incidencia + ", incidencia=" + incidencia + ", tiempo=" + tiempo + ", resuelto=" + resuelto + '}';
    }

}
