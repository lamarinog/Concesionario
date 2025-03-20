package Proyec;

import java.util.Scanner;

/**
 *
 * @author Luis Mariño
 */
public class Combustion extends Vehiculo {

    Scanner inStr = new Scanner(System.in);
    private double cilindrada;
    private String tipo_motor;
    private double consumo;
    private double potencia;

    public Combustion(String modelo, String matricula, String color, double precio, double cilindrada, String tipo_motor, double consumo, double potencia) {
        super(modelo, matricula, color, precio);
        this.cilindrada = cilindrada;
        this.setTipo_motor(tipo_motor);
        this.consumo = consumo;
        this.potencia = potencia;
    }

    public Combustion() {
        super();
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getTipo_motor() {
        return tipo_motor;
    }

    public void setTipo_motor(String tipo_motor) {
        while (!tipo_motor.equalsIgnoreCase("diesel") && !tipo_motor.equalsIgnoreCase("gasolina")) {
            System.out.println("Solo se admiten tipos de motor de gasolina o diesel.");
            System.out.println("Ingrese el tipo de motor: ");
            tipo_motor = inStr.nextLine();
        }
        this.tipo_motor = tipo_motor.toLowerCase();

    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    @Override
    public void informacion() {
        super.informacion();
        System.out.println("Combustion{" + "cilindrada=" + this.cilindrada + ", tipo_motor=" + this.tipo_motor + ", consumo=" + this.consumo + ", potencia=" + this.potencia
                + "}");
    }

//    @Override
//    public void emisiones() {
//        super.emisiones();
//        System.out.println("no se puede generar ya que es un vehiculo de combustion con tipo de motor: " + this.tipo_motor);
//    }
    @Override
    public void permiso() {
        super.permiso();
        System.out.println(", la potencia de carga es: " + this.cilindrada);
    }

    @Override
    public void generaFacturaVenta() {
        System.out.println("Se genera la factura, el precio es: " + this.precio + " €");
    }

    @Override
    public void tipoPrecio() {
        System.out.println("El tipo es combustion y el precio es " + this.precio + " €");
    }

    @Override
    public void cambioPrecio() {
        System.out.println("El precio en euros es: " + this.precio + " €");
        System.out.println("El precio en yenes es: " + (this.precio * 161.32) + " ¥");
    }
}
