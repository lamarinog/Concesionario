package Proyec;

import java.util.Scanner;

/**
 *
 * @author Blanca
 */
public class Combustion extends Vehiculo {

    Scanner inStr = new Scanner(System.in);
    private double cilindrada;
    private String tipo_motor;
    private double consumo;
    private double potencia;

    public Combustion(String modelo, String matricula, String color, double cilindrada, String tipo_motor, double consumo, double potencia) {
        super(modelo, matricula, color);
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
    public String toString() {
        return "Combustion{" + "cilindrada=" + cilindrada + ", tipo_motor=" + tipo_motor + ", consumo=" + consumo + ", potencia=" + potencia
                + ", modelo=" + modelo + ", matricula=" + matricula + ", color=" + color + ",  activo=" + activo + "}";
    }

}
