package controladores;

import interfaces.Crudinterfaces;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static main.Comienzo.metodos;
import modelo.Ticketes;

public class TicketesController implements Crudinterfaces {

    public static ArrayList<Ticketes> lista = new ArrayList();
    Metodos metodos = new Metodos();

    public String ingresardatos(String text, String title) {
        return JOptionPane.showInputDialog(null, text,
                title, JOptionPane.QUESTION_MESSAGE);
    }

    @Override
    public void Crear() {

        int idviaje;
        int cantidad;
        double precioventa;
        String fechaventa;
        double totalventa;
        double totaliva;
        double totalventatotal;

        try {
            idviaje = Integer.parseInt(ingresardatos("Ingrese el ID del viaje", "Ingresar datos"));
        } catch (Exception e) {
            metodos.msg("Este campo solo acepta numeros enteros");
            idviaje = Integer.parseInt(ingresardatos("Ingrese el ID del viaje", "Ingresar datos"));
        }

        try {
            cantidad = Integer.parseInt(ingresardatos("Ingrese la cantidad del viaje", "Ingresar datos"));
        } catch (Exception e) {
            metodos.msg("Este campo solo acepta numeros enteros");
            cantidad = Integer.parseInt(ingresardatos("Ingrese la cantidad del viaje", "Ingresar datos"));
        }

        try {
            precioventa = Double.parseDouble(ingresardatos("Ingrese el precio unitario", "Ingresar datos"));
        } catch (Exception e) {
            metodos.msg("Este campo solo acepta numeros enteros o decimales");
            precioventa = Double.parseDouble(ingresardatos("Ingrese el precio unitario", "Ingresar datos"));
        }

        fechaventa = ingresardatos("Ingrese la fecha de venta", "Ingresar datos");

        try {
            totalventa = Double.parseDouble(JOptionPane.showInputDialog(null, "Total del viaje sin impuestos", (cantidad * precioventa)));
        } catch (Exception e) {
            metodos.msg("Este campo solo acepta numeros enteros o decimales");
            totalventa = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el total del viaje", (cantidad * precioventa)));
        }

        try {
            totaliva = Double.parseDouble(JOptionPane.showInputDialog(null, "Total de IVA", (totalventa * 0.13)));
        } catch (Exception e) {
            metodos.msg("Este campo solo acepta numeros enteros o decimales");
            totaliva = Double.parseDouble(JOptionPane.showInputDialog(null, "Total de IVA", (totalventa * 0.13)));
        }

        try {
            totalventatotal = Double.parseDouble(JOptionPane.showInputDialog(null, "Total de la venta", (totalventa + totaliva)));
        } catch (Exception e) {
            metodos.msg("Este campo solo acepta numeros enteros o decimales");
            totalventatotal = Double.parseDouble(JOptionPane.showInputDialog(null, "Total de la venta con impuestos incluidos", (totalventa + totaliva)));
        }

        Ticketes t = new Ticketes(idviaje, cantidad, precioventa, fechaventa, totalventa, totaliva, totalventatotal);

        lista.add(t);

        metodos.msg("Tickete guardado con exito. Informacion del tickete:\n \nID tickete: " + (lista.size()) + "\nID viaje: " + idviaje
                + "\nCantidad: " + cantidad + "\nPrecio venta unitario: " + precioventa + "\nFecha: " + fechaventa + "\nTotal venta: " + totalventa
                + "\nIVA: " + totaliva + "\nTotal con impuestos: " + totalventatotal);
    }

    @Override
    public void Modificar() {
        int id = -9;
        String tickete = "";
        String tickete2 = "";
        boolean bandera = false;

        int idviaje;
        int cantidad;
        double precioventa;
        String fechaventa;
        double totalventa;
        double totaliva;
        double totalventatotal;

        try {
            id = Integer.parseInt(ingresardatos("Por favor digite el ID del tickete a modificar", "Modificar viaje"));
            bandera = true;
        } catch (Exception e) {
            metodos.msg("Este campo solo acepta numeros enteros");
            bandera = false;
        }

        if (bandera == true) {
            try {
                tickete += "\nID tickete: " + (id);
                tickete += " * ID Viaje: " + lista.get(id - 1).getIdviaje();
                tickete += " * Cantidad: " + lista.get(id - 1).getCantidad();
                tickete += " * Precio unitario: " + lista.get(id - 1).getPrecioventa();
                tickete += " * Fecha: " + lista.get(id - 1).getFechaventa();
                tickete += " * Total de la venta: " + lista.get(id - 1).getTotalventa();
                tickete += " * IVA: " + lista.get(id - 1).getTotaliva();
                tickete += " * Total con impuestos: " + lista.get(id - 1).getTotalventatotal();
                bandera = true;
            } catch (Exception e) {
                metodos.msg("No existe un auto con ese ID");
                bandera = false;
            }
        }

        if (bandera == true) {
            int modificar = JOptionPane.showOptionDialog(null, "Usted desea modificar el siguiente tickete?\n" + tickete,
                    "Modificar tickete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, null, null);

            switch (modificar) {
                case 0:
                    try {
                    idviaje = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del viaje", lista.get(id - 1).getIdviaje()));
                } catch (Exception e) {
                    metodos.msg("Este campo solo acepta numeros enteros");
                    idviaje = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del viaje", lista.get(id - 1).getIdviaje()));
                }

                try {
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad:", lista.get(id - 1).getCantidad()));
                } catch (Exception e) {
                    metodos.msg("Este campo solo acepta numeros enteros");
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad:", lista.get(id - 1).getCantidad()));
                }
                
                try {
                    precioventa = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de la venta del tickete", lista.get(id-1).getPrecioventa()));
                } catch (Exception e) {
                }metodos.msg("Este campo solo acepta numeros enteros o decimales");
                precioventa = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de la venta del tickete", lista.get(id-1).getPrecioventa()));
                
                fechaventa = JOptionPane.showInputDialog("Ingrese la fecha de venta", lista.get(id-1).getFechaventa());
                
                try {
                    totalventa = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el total de la venta", (cantidad * precioventa)));
                } catch (Exception e) {
                    metodos.msg("Este campo solo acepta numeros enteros o decimales");
                    totalventa = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el total de la venta", (cantidad * precioventa)));
                }
                
                try {
                    totaliva = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el total de IVA", (totalventa * 0.13)));
                } catch (Exception e) {
                    metodos.msg("Este campo solo acepta numeros enteros o decimales");
                    totaliva = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el total de IVA", (totalventa * 0.13)));
                }                
                
                try {
                    totalventatotal = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el total de la venta con impuestos incluidos", (totalventa + totaliva)));
                } catch (Exception e) {
                    metodos.msg("Este campo solo acepta numeros enteros o decimales");
                    totalventatotal = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el total de la venta con impuestos incluidos", (totalventa + totaliva)));
                }
                
                tickete2 += "\nID tickete: " + id;
                tickete2 += " * ID Viaje: " + idviaje;
                tickete2 += " * Cantidad: " + cantidad;
                tickete2 += " * Precio unitario: " + precioventa;
                tickete2 += " * Fecha venta: " + fechaventa;
                tickete2 += " * Total de la venta: " + totalventa;
                tickete2 += " * IVA: " + totaliva;
                tickete2 += " * Total con impuestos: " + totalventatotal;                
               
                int modificar2 = JOptionPane.showOptionDialog(null, "Usted desea modificar el siguiente viaje?\n" + tickete + "\nCon estos nuevos datos?\n" + tickete2,
                        "Modificar viaje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, null, null);
                switch (modificar2) {
                    case 0:
                        lista.get(id - 1).setIdviaje(idviaje);
                        lista.get(id - 1).setCantidad(cantidad);
                        lista.get(id - 1).setPrecioventa(precioventa);
                        lista.get(id - 1).setFechaventa(fechaventa);
                        lista.get(id - 1).setTotalventa(totalventa);
                        lista.get(id - 1).setTotaliva(totaliva);
                        lista.get(id - 1).setTotalventatotal(totalventatotal);

                        metodos.msg("Viaje modificado con exito");
                        break;
                    default:
                        metodos.msg("No se ha modificado ningun elemento");
                }
                break;
                case 1:
                    metodos.msg("No se ha modificado ningun viaje");
                    break;
                default:
                    metodos.msg("No se ha elegido una opcion correcta");
            }
        }

    }

    @Override
    public void Ver() {

        int id = -9;
        String tickete = "";
        boolean bandera = false;

        try {
            id = Integer.parseInt(ingresardatos("Por favor digite el ID del tickete a buscar", "Buscar tickete"));
            bandera = true;
        } catch (Exception e) {
            metodos.msg("Este campo solo acepta numeros enteros");
            bandera = false;
        }

        if (bandera == true) {
            try {
                tickete += "\nID tickete: " + (id);
                tickete += "\nID Viaje: " + lista.get(id - 1).getIdviaje();
                tickete += "\nCantidad: " + lista.get(id - 1).getCantidad();
                tickete += "\nPrecio unitario: " + lista.get(id - 1).getPrecioventa();
                tickete += "\nFecha: " + lista.get(id - 1).getFechaventa();
                tickete += "\nTotal de la venta: " + lista.get(id - 1).getTotalventa();
                tickete += "\nIVA: " + lista.get(id - 1).getTotaliva();
                tickete += "\nTotal con impuestos: " + lista.get(id - 1).getTotalventatotal();
                bandera = true;
            } catch (Exception e) {
                metodos.msg("No existe un auto con ese ID");
                bandera = false;
            }
        }

        if (bandera == true) {
            metodos.msg(tickete);
        }
    }

    @Override
    public void Eliminar() {

        int id = -9;
        String tickete = "";
        boolean bandera = false;

        try {
            id = Integer.parseInt(ingresardatos("Por favor digite el ID del tickete a buscar", "Buscar tickete"));
            bandera = true;
        } catch (Exception e) {
            metodos.msg("Este campo solo acepta numeros enteros");
            bandera = false;
        }

        if (bandera == true) {
            try {
                tickete += "\nID tickete: " + (id);
                tickete += "\nID Viaje: " + lista.get(id - 1).getIdviaje();
                tickete += "\nCantidad: " + lista.get(id - 1).getCantidad();
                tickete += "\nPrecio unitario: " + lista.get(id - 1).getPrecioventa();
                tickete += "\nFecha: " + lista.get(id - 1).getFechaventa();
                tickete += "\nTotal de la venta: " + lista.get(id - 1).getTotalventa();
                tickete += "\nIVA: " + lista.get(id - 1).getTotaliva();
                tickete += "\nTotal con impuestos: " + lista.get(id - 1).getTotalventatotal();
                bandera = true;
            } catch (Exception e) {
                metodos.msg("No existe un auto con ese ID");
                bandera = false;
            }
        }

        if (bandera == true) {
            int eliminar = JOptionPane.showOptionDialog(null, "Usted desea anular el siguiente tickete?\n" + tickete,
                    "Anular tickete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, null, null);

            switch (eliminar) {
                case 0:
                    metodos.msg("Se ha eliminado el siguiente registro: \n" + tickete);
                    lista.remove((id - 1));
                    break;
                case 1:
                    metodos.msg("No se ha eliminado ningun tickete");
                    break;
                default:
                    metodos.msg("No se ha elegido una opcion correcta");
            }
        }
    }

    public void Informe() {
        String ticketes = "*******   INFORME DE TICKETES   *******\n";

        for (int i = 0; i < lista.size(); i++) {

            ticketes += "\nID tickete: " + (i + 1);
            ticketes += " * ID Viaje: " + lista.get(i).getIdviaje();
            ticketes += " * Cantidad: " + lista.get(i).getCantidad();
            ticketes += " * Precio unitario: " + lista.get(i).getPrecioventa();
            ticketes += " * Fecha: " + lista.get(i).getFechaventa();
            ticketes += " * Total de la venta: " + lista.get(i).getTotalventa();
            ticketes += " * IVA: " + lista.get(i).getTotaliva();
            ticketes += " * Total con impuestos: " + lista.get(i).getTotalventatotal();
        }

        metodos.msg(ticketes);

    }

    public void Menu() {

        String[] opciones = {"Nuevo", "Modificar", "Ver", "Anular", "Informe", "Volver"};

        int opcion = -1;
        while (opcion != opciones.length - 1) {
            opcion = metodos.menuBotones("Seleccione una opción", "Sub Menú Ticketes", opciones, "Volver");
            switch (opcion) {
                case 0:
                    Crear();
                    break;
                case 1:
                    Modificar();
                    break;
                case 2:
                    Ver();
                    break;
                case 3:
                    Eliminar();
                    break;
                case 4:
                    Informe();
                    break;
                default:
                    metodos.msg("Volviendo al menu anterior");
            }
        }

    }

}
