package Proyec;

import static Proyec.Concesionario.*;
import java.util.Scanner;

/**
 *
 * @author Blanca
 */
public class incidenciaFunc {

    public static void incidencia_clase(Vehiculo[] data, Incidencia[] inci) {
        Scanner in = new Scanner(System.in);
        Scanner inStr = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 11) {
            System.out.println("1. Abrir incidencias.");
            System.out.println("2. Modificar incidencias.");
            System.out.println("3. Cerrar incidencias.");
            System.out.println("4. Borrar incidencias.");
            System.out.println("5. Volver al menu principal.");
            opcion = in.nextInt();
            switch (opcion) {
                case 1:
                    abrir_incidencia(data, inStr, inci, in);
                    break;
                case 2:
                    modificar_incidencia(data, inStr, inci, in);
                    break;
                case 3:
                    cerrar_incidencia(data, inStr, inci, in);
                    break;
                case 4:
                    borrar_incidencia(data, inStr, inci, in);
                    break;
                case 5:
                    mostrar_incidencia(data, inStr, inci);
                    break;
                case 6:
                    System.out.println("Se regresa al menu principal.");
                    menu(data, inci);
                    break;
                default:
                    System.out.println("Elija una opcion correcta.");
                    break;
            }
        }

    }

    //INGRESAR INCIDENCIA AL ARRAY, SE GUARDA LA MATRICULA
    public static void abrir_incidencia(Vehiculo[] data, Scanner inStr, Incidencia[] incidencias, Scanner in) {
        Vehiculo coche = buscar_mat(data, inStr);
        String resuelto = "";
        boolean agregar = false;
        if (coche != null) {
            for (int i = 0; i < incidencias.length; i++) {
                if (incidencias[i] == null) {
                    incidencias[i] = new Incidencia();
                    incidencias[i].setId_incidencia((i));
                    incidencias[i].setMatricula(coche.getMatricula());
                    System.out.println("Ingrese la incidencia: ");
                    incidencias[i].setIncidencia(inStr.nextLine());
                    System.out.println("Se finalizo la incidencia? Si o No");
                    resuelto = inStr.nextLine();
                    while (!(resuelto.equalsIgnoreCase("si") || resuelto.equalsIgnoreCase("no"))) {
                        System.out.println("Solo se permite si o no: ");
                        resuelto = inStr.nextLine();
                    }
                    if (resuelto.equalsIgnoreCase("si")) {
                        incidencias[i].setResuelto(true);
                        System.out.println("Cuanto tiempo demoro en minutos de resolver la incidencia: ");
                        incidencias[i].setTiempo(in.nextInt());
                    } else {
                        System.out.println("Queda pendiente el incidente.");
                    }
                    agregar = true;
                    System.out.println("Se agrego la incidencia");
                    i = incidencias.length;
                }
            }
            if (!agregar) {
                System.out.println("El array de incidencias esta lleno.");
            }
        } else {
            System.out.println("No se encontro la matricula.");
        }
    }

    //CERRAR INCIDENCIA ABIERTA POR ID
    public static void cerrar_incidencia(Vehiculo[] data, Scanner inStr, Incidencia[] incidencias, Scanner in) {
        mostrar_incidencia(data, inStr, incidencias);
        System.out.println("Elija el id a cerrar incidencia: ");
        int id = in.nextInt();
        incidencias[id].setResuelto(true);
        System.out.println("Ingrese el tiempo que se utilizo para resolver la incidencia: ");
        int minutos = in.nextInt();
        incidencias[id].setTiempo(minutos);
    }

    //MOSTRAR INCIDENCIAS POR MATRICULA
    public static void mostrar_incidencia(Vehiculo[] data, Scanner inStr, Incidencia[] incidencias) {
        Vehiculo coche = buscar_mat(data, inStr);
        boolean encontrar = false;
        if (coche != null) {
            for (int i = 0; i < incidencias.length; i++) {
                if (incidencias[i] != null) {
                    if (coche.getMatricula().equalsIgnoreCase(incidencias[i].getMatricula())) {
                        System.out.println(incidencias[i].toString());
                        encontrar = true;
                    }
                }
            }
            if (!encontrar) {
                System.out.println("No tiene incidencias este vehiculo aun.");
            }
        } else {
            System.out.println("No se encontro la matricula.");
        }
    }

    public static void borrar_incidencia(Vehiculo[] data, Scanner inStr, Incidencia[] incidencias, Scanner in) {
        mostrar_incidencia(data, inStr, incidencias);
        System.out.println("Elija el id a borrar incidencia: ");
        int id = in.nextInt();
        incidencias[id] = null;
        System.out.println("Se borro la incidencia");
    }

    public static void modificar_incidencia(Vehiculo[] data, Scanner inStr, Incidencia[] incidencias, Scanner in) {
        mostrar_incidencia(data, inStr, incidencias);
        System.out.println("Elija el id a modificar incidencia: ");
        int id = in.nextInt();
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("1. Modificar horas");
            System.out.println("1. Modificar problema");
            System.out.println("3. Volver al menu de incidencias");
            switch (opcion) {
                case 1:
                    System.out.println("Indicar modificacion de horas en minutos: ");
                    int minutos = in.nextInt();
                    incidencias[id].setTiempo(minutos);
                    break;
                case 2:
                    System.out.println("Indicar el nuevo problema: ");
                    String problema = inStr.nextLine();
                    incidencias[id].setIncidencia(problema);
                    break;
                case 3:
                    System.out.println("Se regresa al menu de incidencias.");
                    incidencia_clase(data, incidencias);
                    break;
                default:
                    System.out.println("Elija una opcion correcta.");
            }
        }
    }
}
