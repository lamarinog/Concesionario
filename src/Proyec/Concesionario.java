package Proyec;

import java.util.Scanner;
import static Proyec.incidenciaFunc.*;

/**
 *
 * @author Luis Mariño
 */
public class Concesionario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vehiculo[] conce = new Vehiculo[50];
        Incidencia[] inci = new Incidencia[50];
        ejemplos(conce);
        menu(conce, inci);
    }

    //MENU DE NUESTRO PROGRAMA
    public static void menu(Vehiculo[] data, Incidencia[] inci) {
        Scanner in = new Scanner(System.in);
        Scanner inStr = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 11) {
            System.out.println("1. Dar de alta vehiculos.");
            System.out.println("2. Generar el permiso de circulación de un vehículo.");
            System.out.println("3. Informe de Emisiones.");
            System.out.println("4. Generar permiso de circulación global.");
            System.out.println("5. Gestionar Venta de un coche.");
            System.out.println("6. Mostrar coches activos o de baja.");
            System.out.println("7. Cambio de normativa.");
            System.out.println("8. Incidencias.");
            System.out.println("9. Borrar coche por matricula.");
            System.out.println("10. Mostrar todos los coches.");
            System.out.println("11. Salir.");
            System.out.println("Elija la opción a realizar: ");
            opcion = in.nextInt();
            switch (opcion) {
                case 1:
                    altaCoche(data, in, inStr);
                    break;
                case 2:
                    generarPermiso(data, inStr);
                    break;
                case 3:
                    informeEmisiones(data, inStr);
                    break;
                case 4:
                    generarGlobalPermiso(data);
                    break;
                case 5:
                    gestionVenta(data, inStr);
                    break;
                case 6:
                    mostrarActivos(data, inStr);
                    break;
                case 7:
                    cambioNormativaKw(data);
                    break;
                case 8:
                    incidencia_clase(data, inci);
                    break;
                case 9:
                    borrarCoche(data, inStr);
                    break;
                case 10:
                    mostrarArray(data);
                    break;
                case 11:
                    System.out.println("Se finaliza el programa.");
                    break;
                default:
                    System.out.println("Elija una opcion correcta.");
                    break;
            }
        }
    }

    //EJEMPLOS DE VEHICULOS
    public static void ejemplos(Vehiculo[] data) {
        data[0] = new Combustion("A1", "1", "verde", 5.3, "diesel", 80, 75);
        data[1] = new Electrico("A3", "2", "rojo", 120, 85, 35, 45);
    }

    //MENU PARA DAR DE ALTA VEHICULO
    public static int menu_alta(Scanner in) {
        int tipo = 0;
        boolean check = true;
        while (check) {
            System.out.println("Elegir el tipo de vehiculo para dar de alta.");
            System.out.println("1. Combustible.");
            System.out.println("2. Electrico.");
            tipo = in.nextInt();
            if (tipo == 1 || tipo == 2) {
                check = false;
            } else {
                System.out.println("Elegir 1 o 2.");
            }
        }
        return tipo;
    }

    //METODO PARA DAR DE ALTA UN VEHICULO YA SEA COMBUSTION O ELECTRICO
    public static void altaCoche(Vehiculo[] data, Scanner in, Scanner inStr) {
        int tipo = menu_alta(in);
        boolean alta = false;
        String[] colores = {"rojo", "verde", "azul", "dorado", "gris", "negro", "blanco"};
        String[] modelos = {"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10",};
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                if (tipo == 1) {
                    Combustion carro = new Combustion();
                    carro.setColor(colores[(int) (Math.random() * colores.length)]);
                    System.out.println("Ingrese la matricula: ");
                    carro.setMatricula(inStr.nextLine());
                    carro.setModelo(modelos[(int) (Math.random() * modelos.length)]);
                    carro.setCilindrada(Math.random() * 3);
                    System.out.println("Ingrese el tipo de motor: ");
                    carro.setTipo_motor(inStr.nextLine());
                    carro.setConsumo(Math.random() * 100);
                    carro.setPotencia(Math.random() * 100);
                    data[i] = carro;
                    alta = true;
                    i = data.length;
                    System.out.println(carro.toString());
                } else if (tipo == 2) {
                    Electrico carro = new Electrico();
                    carro.setColor(colores[(int) (Math.random() * colores.length)]);
                    System.out.println("Ingrese la matricula: ");
                    carro.setMatricula(inStr.nextLine());
                    carro.setModelo(modelos[(int) (Math.random() * modelos.length)]);
                    carro.setCapacidad_bat(Math.random() * 200);
                    carro.setConsumo_elec(Math.random() * 100);
                    carro.setAutonomia(Math.random() * 50 - 30);
                    carro.setPotencia_carga(Math.random() * 100);
                    data[i] = carro;
                    alta = true;
                    i = data.length;
                    System.out.println(carro.toString());
                }
            }
        }
        if (!alta) {
            System.out.println("El array esta lleno.");
        } else {
            System.out.println("Se ha ingresado correctamente el vehiculo.");
        }
    }

    //MOSTRAR ARRAY COMPLETO
    public static void mostrarArray(Vehiculo[] data) {
        boolean vacio = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                data[i].informacion();
                vacio = false;
            }
        }
        if (vacio) {
            System.out.println("El array esta vacio.");
        }
    }

    //GENERAR PERMISO POR MEDIO DE LA MATRICULA
    public static void generarPermiso(Vehiculo[] data, Scanner inStr) {
        Vehiculo carro = buscar_mat(data, inStr);
        if (carro != null) {
            carro.permiso();
        } else {
            System.out.println("No existe la matricula para generar el permiso.");
        }
    }

    //COMPARAR MATRICULA INGRESADA POR TECLADA CON EL DEL ARRAY
    public static Vehiculo buscar_mat(Vehiculo[] data, Scanner inStr) {
        System.out.println("Indique la matricula del vehiculo que se quiere obtener la informacion: ");
        String matricula = inStr.nextLine();
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                if (matricula.equalsIgnoreCase(data[i].getMatricula())) {
                    return data[i];
                }
            }
        }
        return null;
    }

    //INFORME DE EMISIONES 0 DE VEHICULOS ELECTRICOS
    public static void informeEmisiones(Vehiculo[] data, Scanner inStr) {
        Vehiculo carro = buscar_mat(data, inStr);
        if (carro != null) {
            carro.emisiones();
        } else {
            System.out.println("No existe la matricula.");
        }
    }

    //GENERAR PERMISO A TODOS LOS VEHICULOS
    public static void generarGlobalPermiso(Vehiculo[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                data[i].permiso();
            }
        }
        System.out.println("Se ha generado el permiso de todos los carros.");
    }

    //GESTIONAR LA VENTA DE UN VEHICULO Y DAR DE BAJA
    public static void gestionVenta(Vehiculo[] data, Scanner inStr) {
        Vehiculo coche = buscar_mat(data, inStr);
        if (coche != null) {
            coche.setActivo(false);
            coche.informacion();
        }
    }

    //MOSTRAR VEHICULOS QUE ESTAN DE ALTA Y BAJA
    public static void mostrarActivos(Vehiculo[] data, Scanner inStr) {
        System.out.println("Ingrese si quiere ver los carros que estan de alta o baja: ");
        String activo = inStr.nextLine();
        boolean activo1 = false;
        while (!(activo.equalsIgnoreCase("alta") || activo.equalsIgnoreCase("baja"))) {
            System.out.println("Ingrese alta o baja: ");
            activo = inStr.nextLine();
        }
        if (activo.equalsIgnoreCase("alta")) {
            activo1 = true;
        } else if (activo.equalsIgnoreCase("baja")) {
            activo1 = false;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                if (activo1 == data[i].getActivo()) {
                    data[i].informacion();
                }
            }
        }
    }

    //CAMBIAR DE KW A W EN VEHICULOS ELECTRICOS
    //SI CAMBIAMOS DE KW A MW LOS NUMEROS SALDRIAN MUY PEQUEÑOS, TODOS A 0 CON DECIMALES
    public static void cambioNormativaKw(Vehiculo[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                //metodo no estatico
                data[i].normativa();
                //metodo estatico que hace lo mismo
                //((Electrico) data[i]).setPotencia_carga(((Electrico) data[i]).getPotencia_carga() * 1000);              
            }
        }
        System.out.println("Se ha realizado el cambio de la normativa de KW a W");
    }

    //BORRAR COCHE POR MATRICULA
    public static void borrarCoche(Vehiculo[] data, Scanner inStr) {
        System.out.println("Indique la matricula del vehiculo que se quiere borrar: ");
        String matricula = inStr.nextLine();
        boolean borrar = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                if (matricula.equalsIgnoreCase(data[i].getMatricula())) {
                    data[i] = null;
                    i = data.length;
                    borrar = true;
                    System.out.println("Se ha borrado el vehiculo.");
                }
            }
        }
        if (!borrar) {
            System.out.println("No se encontro el vehiculo.");
        }
    }
}
