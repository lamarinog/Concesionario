package Proyec;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Luis Mariño
 */
public class Concesionario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        Scanner inStr = new Scanner(System.in);
        Vehiculo[] conce = new Vehiculo[50];
        Incidencia[] inci = new Incidencia[50];
        ejemplos(conce);
        int opcion = 0;
        while (opcion != 12) {
            opcion = menu(in);
            switch (opcion) {
                case 1:
                    altaCoche(conce, in, inStr);
                    break;
                case 2:
                    generarPermiso(conce, inStr);
                    break;
                case 3:
                    informeEmisiones(conce, inStr);
                    break;
                case 4:
                    generarGlobalPermiso(conce);
                    break;
                case 5:
                    gestionVenta(conce, inStr);
                    break;
                case 6:
                    mostrarActivos(conce, inStr);
                    break;
                case 7:
                    cambioNormativaKw(conce);
                    break;
                case 8:
                    //abrirIncidencia(conce, inStr);
                    incidencia_clase(conce, inStr, inci, in);
                    break;
                case 9:
                    //mostrarIncidencias(conce, inStr);
                    mostrarIncidenciaClase(conce, inStr, inci);
                    break;
                case 10:
                    borrarCoche(conce, inStr);
                    break;
                case 11:
                    mostrarArray(conce);
                    break;
                case 12:
                    System.out.println("Se finaliza el programa.");
                    break;
                default:
                    System.out.println("Elija una opcion correcta.");
                    break;
            }
        }
    }

    //MENU DE NUESTRO PROGRAMA
    public static int menu(Scanner in) {
        System.out.println("1. Dar de alta vehiculos.");
        System.out.println("2. Generar el permiso de circulación de un vehículo.");
        System.out.println("3. Informe de Emisiones.");
        System.out.println("4. Generar permiso de circulación global.");
        System.out.println("5. Gestionar Venta de un coche.");
        System.out.println("6. Mostrar coches activos o de baja.");
        System.out.println("7. Cambio de normativa.");
        System.out.println("8. Abrir incidencia.");
        System.out.println("9. Mostrar incidencias.");
        System.out.println("10. Borrar coche por matricula.");
        System.out.println("11. Mostrar todos los coches.");
        System.out.println("12. Salir.");
        System.out.println("Elija la opción a realizar: ");
        int opcion = in.nextInt();
        return opcion;
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

    //ABRIR INCIDENCIA Y SI ESTA ABIERTA NO PODER COLOCAR TIEMPO DE INCIDENCIA
    public static void abrirIncidencia(Vehiculo[] data, Scanner inStr) {
        Vehiculo coche = buscar_mat(data, inStr);
        String cadenaP = coche.getIncidencia();
        if (cadenaP == null) {
            cadenaP = "";
        }
        String cadena = "";
        if (coche != null) {
            boolean abierta = true;
            boolean resueltoB = false;
            while (abierta) {
                cadena = Boolean.toString(abierta);
                System.out.println("Ingresar incidencia: ");
                String incidencia = inStr.nextLine();
                System.out.println("Se resolvio la incidencia: ");
                System.out.println("Si o No");
                String resuelto = inStr.nextLine();
                while (!(resuelto.equalsIgnoreCase("si") || resuelto.equalsIgnoreCase("no"))) {
                    System.out.println("Solo se permite si o no: ");
                    resuelto = inStr.nextLine();
                }
                if (resuelto.equalsIgnoreCase("si")) {
                    abierta = false;
                    resueltoB = true;
                    cadena = "false";
                    cadena += "," + incidencia;
                } else {
                    System.out.println("Se deja en StandBy hasta que se finalice la incidencia");
                    cadena += "," + incidencia + ",pendiente" + ";";
                    cadenaP += cadena;
                    coche.setIncidencia(cadenaP);
                    abierta = false;
                }
            }
            if (resueltoB) {
                System.out.println("Ingresar las horas que se usaron para resolver la incidencia: ");
                String horas = inStr.nextLine();
                cadena += "," + horas + ";";
                cadenaP += cadena;
                coche.setIncidencia(cadenaP);
            }
        } else {
            System.out.println("No existe la matricula");
        }
    }

    //MOSTRAR TODAS LAS INCIDENCIAS POR MATRICULA
    public static void mostrarIncidencias(Vehiculo[] data, Scanner inStr) {
        Vehiculo coche = buscar_mat(data, inStr);
        if (coche != null) {
            String[] incidencias = coche.getIncidencia().split(";");
            for (int i = 0; i < incidencias.length; i++) {
                String[] incidencia = incidencias[i].split(",");
                System.out.println(Arrays.toString(incidencia));
            }
        } else {
            System.out.println("No existe la matricula");
        }
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

    //INGRESAR INCIDENCIA AL ARRAY, SE GUARDA LA MATRICULA
    public static void incidencia_clase(Vehiculo[] data, Scanner inStr, Incidencia[] incidencias, Scanner in) {
        Vehiculo coche = buscar_mat(data, inStr);
        String resuelto = "";
        boolean agregar = false;
        if (coche != null) {
            for (int i = 0; i < incidencias.length; i++) {
                if (incidencias[i] == null) {
                    incidencias[i] = new Incidencia();
                    incidencias[i].setId_incidencia((i + 1));
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

    //MOSTRAR INCIDENCIAS POR MATRICULA
    public static void mostrarIncidenciaClase(Vehiculo[] data, Scanner inStr, Incidencia[] incidencias) {
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
}
