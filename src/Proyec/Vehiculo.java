package Proyec;

/**
 *
 * @author Luis Mariño
 */
public abstract class Vehiculo {

    protected String modelo;
    protected String matricula;
    protected String color;
    protected boolean activo = true;
    protected double precio;

    public Vehiculo(String modelo, String matricula, String color, double precio) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.color = color;
        this.precio = precio;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void emisiones() {
        System.out.print("El informe de emisiones zero: ");
    }

    public void informacion() {
        System.out.print("Vehiculo{" + "modelo=" + this.modelo + ", matricula=" + this.matricula + ", color=" + this.color + ", precio=" + this.precio + ", activo=" + this.activo + '}');
    }

    public void permiso() {
        System.out.print("El modelo del carro es :" + this.modelo + ", la matricula del carro es: " + this.matricula);
    }

    public void normativa(){};

    public abstract void generaFacturaVenta();
    
    public abstract void tipoPrecio();
    
    public abstract void cambioPrecio();

}
