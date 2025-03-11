package Proyec;

import java.util.Scanner;

/**
 *
 * @author Luis Mariño
 */
public class Electrico extends Vehiculo {

    Scanner in = new Scanner(System.in);
    private double capacidad_bat;
    private double consumo_elec;
    private double autonomia;
    private double potencia_carga;

    public Electrico(String modelo, String matricula, String color, double capacidad_bat, double consumo_elec, double autonomia, double potencia_carga) {
        super(modelo, matricula, color);
        this.setCapacidad_bat(capacidad_bat);
        this.consumo_elec = consumo_elec;
        this.setAutonomia(autonomia);
        this.potencia_carga = potencia_carga;
    }

    public Electrico() {
        super();
    }

    public double getCapacidad_bat() {
        return capacidad_bat;
    }

    public void setCapacidad_bat(double capacidad_bat) {
        while (capacidad_bat < 100) {
            System.out.println("La capacidad de bateria no puede ser menor a 100.");
            System.out.println("Ingrese la nueva capacidad de batería: ");
            capacidad_bat = in.nextDouble();
        }
        this.capacidad_bat = capacidad_bat;

    }

    public double getConsumo_elec() {
        return consumo_elec;
    }

    public void setConsumo_elec(double consumo_elec) {
        this.consumo_elec = consumo_elec;
    }

    public double getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(double autonomia) {
        while (autonomia < 0) {
            System.out.println("No se permiten autonomias negativas.");
            System.out.println("Ingresar la autonomia correcta: ");
            autonomia = in.nextDouble();
        }
        this.autonomia = autonomia;

    }

    public double getPotencia_carga() {
        return potencia_carga;
    }

    public void setPotencia_carga(double potencia_carga) {
        this.potencia_carga = potencia_carga;
    }

    @Override
    public void informacion() {
        super.informacion();
        System.out.println("Electrico{" + "capacidad_bat=" + this.capacidad_bat + ", consumo_elec=" + this.consumo_elec + ", autonomia=" + this.autonomia + ", potencia_carga=" + this.potencia_carga
                + "}");
    }

    @Override
    public void normativa() {
        this.potencia_carga = (this.potencia_carga * 1000);
    }

    @Override
    public void emisiones() {
        super.emisiones();
        System.out.println("se puede generar.");
    }

    @Override
    public void permiso() {
        super.permiso();
        System.out.println(", la potencia de carga es: " + this.potencia_carga);
    }

}
