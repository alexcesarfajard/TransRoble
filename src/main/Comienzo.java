package main;

import controladores.ChoferesController;
import controladores.Metodos;
import controladores.PersonasController;
import controladores.TicketesController;
import controladores.UsuariosController;
import controladores.VehiculosController;
import controladores.ViajesController;

public class Comienzo {

    public static PersonasController personasController = new PersonasController();
    public static Metodos metodos = new Metodos();
    public static UsuariosController usuariosController = new UsuariosController();
    public static ChoferesController choferesController = new ChoferesController();
    public static VehiculosController vehiculosController = new VehiculosController();
    public static ViajesController viajescontroller = new ViajesController();
    public static TicketesController ticketescontroller = new TicketesController();

    public static void main(String[] args) {
        boolean ingreso = false;
        ingreso = login();
        if (ingreso == true) {
            Menu();
        }
        //Menu();
    }

    private static boolean login() {
        boolean ingreso = false;

        String[] opcLogin = {"Iniciar sesion", "Salir"};
        int opcion = -1;
        boolean bandera = false;
        int usuario = 101;
        int passwd = 99887766;

        int usuario1 = 0;
        int passwd1 = 0;

        do {
            opcion = metodos.menuBotones("Seleccione una opcion", "Ingreso a la aplicacion", opcLogin, "Salir");

            switch (opcion) {
                case 0:
                    try {
                    usuario1 = Integer.parseInt(metodos.ingresardatos("Por favor ingrese su codigo de usuario"));
                } catch (Exception e) {
                    metodos.msg("Este campo solo acepta numeros");
                    usuario1 = Integer.parseInt(metodos.ingresardatos("Por favor ingrese su codigo de usuario"));
                }

                try {
                    passwd1 = Integer.parseInt(metodos.ingresardatos("Por favor ingrese la contraseña"));
                } catch (Exception e) {
                    metodos.msg("Este campo solo acepta numeros");
                    passwd1 = Integer.parseInt(metodos.ingresardatos("Por favor ingrese la contraseña"));
                }

                if (usuario == usuario1 && passwd == passwd1) {
                    metodos.msg("Bienvenido usuario!!");
                    bandera = true;
                    ingreso = true;
                } else {
                    metodos.msg("La contraseña o el usuario son incorrectos, por favor vuelva a intentarlo");
                    ingreso = false;
                }
                break;
                default:
                    metodos.msg("Gracias por su visita...");
                    bandera = true;
                    break;
            }
        } while (bandera == false);

        return ingreso;
    }

    private static void Menu() {
        String[] opciones = {"Administrativo", "Ventas", "Salir"};
        int opc = -1;

        do {
            opc = metodos.menuBotones("Seleccione una opcion", "Menu de ventas", opciones, "Salir");

            switch (opc) {
                case 0:
                    MenuAdministrativo();
                    break;
                case 1:
                    MenuVentas();
                    break;
                default:
                    if (metodos.SIoNo("Realmente desea salir?", "Atención") == 1) {
                        opc = -1;
                    } else {
                        metodos.msg("Gracias por su vista...");
                    }
            }

        } while (opc != 2);
    }

    private static void MenuVentas() {
        String[] opciones = {"Viajes", "Ticketes", "Volver"};
        int opc = -1;

        do {
            opc = metodos.menuBotones("Seleccione una opcion", "Menu de ventas", opciones, "Volver");

            switch (opc) {
                case 0:
                    viajescontroller.Menu();
                    break;
                case 1:
                    ticketescontroller.Menu();
                    break;
                default:
                    metodos.msg("Volviendo al menu anterior");
                    opc = 2;
            }

        } while (opc != 2);
    }

    private static void MenuAdministrativo() {
        String[] opciones = {"Personas", "Usuarios", "Choferes", "Vehiculos", "Volver"};
        int opcion = -1;

        while (opcion != opciones.length - 1) {
            opcion = metodos.menuBotones("Seleccione una opción", "Menu principal", opciones, "Volver");
            switch (opcion) {
                case 0:
                    personasController.Menu();
                    break;
                case 1:
                    usuariosController.Menu();
                    break;
                case 2:
                    choferesController.Menu();
                    break;
                case 3:
                    vehiculosController.Menu();
                    break;
                default:
                    metodos.msg("Volviendo al menu anterior");
            }
        }
    }
}
