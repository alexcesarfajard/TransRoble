package controladores;

import interfaces.Crudinterfaces;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Viajes;

public class ViajesController implements Crudinterfaces {

    public static ArrayList<Viajes> lista = new ArrayList();
    Metodos metodos = new Metodos();

    public String ingresardatos(String text, String title) {
        return JOptionPane.showInputDialog(null, text,
                title, JOptionPane.QUESTION_MESSAGE);
    }

    @Override
    public void Crear() {
        String numplaca;
        int idchofer;
        String fechaviaje;
        String destino;
        int capacidadpasajeros;
        double preciotickete;

        numplaca = ingresardatos("Ingrese el numero de la placa", "Ingrese el numero de la placa");

        try {
            idchofer = Integer.parseInt(ingresardatos("Ingrese el ID del chofer", "Ingrese el ID del chofer"));
        } catch (Exception e) {
            metodos.msg("Este campo solo acepta numeros enteros");
            idchofer = Integer.parseInt(ingresardatos("Ingrese el ID del chofer", "Ingrese el ID del chofer"));
        }

        fechaviaje = ingresardatos("Ingrese la fecha del viaje", "Ingrese la fecha del viaje");
        destino = ingresardatos("Ingrese el destino del viaje", "Ingrese el destino del viaje");

        try {
            capacidadpasajeros = Integer.parseInt(ingresardatos("Ingrese la capacidad de pasajeros", "Ingrese la capacidad de pasajeros"));
        } catch (Exception e) {
            metodos.msg("Este campo solo acepta numeros enteros");
            capacidadpasajeros = Integer.parseInt(ingresardatos("Ingrese la capacidad de pasajeros", "Ingrese la capacidad de pasajeros"));
        }

        try {
            preciotickete = Double.parseDouble(ingresardatos("Ingrese el precio del tickete", "Ingrese el precio del tickete"));
        } catch (Exception e) {
            metodos.msg("Este campo solo acepta numeros, nada de letras");
            preciotickete = Double.parseDouble(ingresardatos("Ingrese el precio del tickete", "Ingrese el precio del tickete"));
        }

        Viajes v = new Viajes(numplaca, idchofer, fechaviaje, destino, capacidadpasajeros, preciotickete);
        lista.add(v);

        metodos.msg("Viaje creado con exito con el ID: " + lista.size());
    }

    @Override
    public void Modificar() {

        int id = -9;
        String viaje = "";
        String viaje2 = "";
        boolean bandera = false;

        String numplaca;
        int idchofer;
        String fechaviaje;
        String destino;
        int capacidadpasajeros;
        double preciotickete;

        try {
            id = Integer.parseInt(ingresardatos("Por favor digite el ID del viaje a modificar", "Modificar viaje"));
            bandera = true;
        } catch (Exception e) {
            metodos.msg("Este campo solo acepta numeros enteros");
            bandera = false;
        }

        if (bandera == true) {
            try {
                viaje += "\nID: " + (id);
                viaje += " * Numero placa: " + lista.get(id - 1).getNumplaca();
                viaje += " * ID chofer: " + lista.get(id - 1).getIdchofer();
                viaje += " * Fecha viaje: " + lista.get(id - 1).getFechaviaje();
                viaje += " * Destino: " + lista.get(id - 1).getDestino();
                viaje += " * Capacidad de pasajeros: " + lista.get(id - 1).getCapacidadpasajeros();
                viaje += " * Precio tickete: " + lista.get(id - 1).getPreciotickete();

                bandera = true;
            } catch (Exception e) {
                metodos.msg("No existe un auto con ese ID");
                bandera = false;
            }
        }

        if (bandera == true) {
            int modificar = JOptionPane.showOptionDialog(null, "Usted desea modificar el siguiente viaje?\n" + viaje,
                    "Modificar viaje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, null, null);

            switch (modificar) {
                case 0:
                    numplaca = JOptionPane.showInputDialog(null, "Ingrese el numero de placa", lista.get(id - 1).getNumplaca());

                    try {
                        idchofer = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del chofer", lista.get(id - 1).getIdchofer()));
                    } catch (Exception e) {
                        metodos.msg("Este campo solo acepta numeros enteros");
                        idchofer = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del chofer", lista.get(id - 1).getIdchofer()));
                    }

                    fechaviaje = JOptionPane.showInputDialog(null, "Ingrese la fecha del viaje", lista.get(id - 1).getFechaviaje());
                    destino = JOptionPane.showInputDialog(null, "Ingrese el destino del viaje", lista.get(id - 1).getDestino());

                    try {
                        capacidadpasajeros = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la capacidad de pasajeros", lista.get(id - 1).getCapacidadpasajeros()));
                    } catch (Exception e) {
                        metodos.msg("Este campo solo acepta numeros enteros");
                        capacidadpasajeros = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la capacidad de pasajeros", lista.get(id - 1).getCapacidadpasajeros()));
                    }

                    try {
                        preciotickete = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el precio del tickete", lista.get(id - 1).getPreciotickete()));
                    } catch (Exception e) {
                        metodos.msg("Este campo solo acepta numeros, nada de letras");
                        preciotickete = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el precio del tickete", lista.get(id - 1).getPreciotickete()));
                    }

                    viaje2 += "\nID: " + (id);
                    viaje2 += " * Numero placa: " + numplaca;
                    viaje2 += " * ID chofer: " + idchofer;
                    viaje2 += " * Fecha viaje: " + fechaviaje;
                    viaje2 += " * Destino: " + destino;
                    viaje2 += " * Capacidad de pasajeros: " + capacidadpasajeros;
                    viaje2 += " * Precio tickete: " + preciotickete;

                    int modificar2 = JOptionPane.showOptionDialog(null, "Usted desea modificar el siguiente viaje?\n" + viaje + "\nCon estos nuevos datos?\n" + viaje2,
                            "Modificar viaje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, null, null);
                    switch (modificar2) {
                        case 0:
                            lista.get(id-1).setNumplaca(numplaca);
                            lista.get(id-1).setIdchofer(idchofer);
                            lista.get(id-1).setFechaviaje(fechaviaje);
                            lista.get(id-1).setDestino(destino);
                            lista.get(id-1).setCapacidadpasajeros(capacidadpasajeros);
                            lista.get(id-1).setPreciotickete(preciotickete);
                            
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
        String viaje = "";
        boolean bandera = false;

        try {
            id = Integer.parseInt(ingresardatos("Por favor digite el ID del viaje a buscar", "Buscar viaje"));
            bandera = true;
        } catch (Exception e) {
            metodos.msg("Este campo solo acepta numeros enteros");
            bandera = false;
        }

        if (bandera == true) {
            try {
                viaje += "\nID: " + (id);
                viaje += " * Numero placa: " + lista.get(id - 1).getNumplaca();
                viaje += " * ID chofer: " + lista.get(id - 1).getIdchofer();
                viaje += " * Fecha viaje: " + lista.get(id - 1).getFechaviaje();
                viaje += " * Destino: " + lista.get(id - 1).getDestino();
                viaje += " * Capacidad de pasajeros: " + lista.get(id - 1).getCapacidadpasajeros();
                viaje += " * Precio tickete: " + lista.get(id - 1).getPreciotickete();

                bandera = true;
            } catch (Exception e) {
                metodos.msg("No existe un auto con ese ID");
                bandera = false;
            }
        }

        if (bandera == true) {
            metodos.msg(viaje);
        }

    }

    @Override
    public void Eliminar() {
        int id = -9;
        String viaje = "";
        boolean bandera = false;

        try {
            id = Integer.parseInt(ingresardatos("Por favor digite el ID del viaje a eliminar", "Eliminar viaje"));
            bandera = true;
        } catch (Exception e) {
            metodos.msg("Este campo solo acepta numeros enteros");
            bandera = false;
        }

        if (bandera == true) {
            try {
                viaje += "\nID: " + (id);
                viaje += " * Numero placa: " + lista.get(id - 1).getNumplaca();
                viaje += " * ID chofer: " + lista.get(id - 1).getIdchofer();
                viaje += " * Fecha viaje: " + lista.get(id - 1).getFechaviaje();
                viaje += " * Destino: " + lista.get(id - 1).getDestino();
                viaje += " * Capacidad de pasajeros: " + lista.get(id - 1).getCapacidadpasajeros();
                viaje += " * Precio tickete: " + lista.get(id - 1).getPreciotickete();

                bandera = true;
            } catch (Exception e) {
                metodos.msg("No existe un auto con ese ID");
                bandera = false;
            }
        }

        if (bandera == true) {
            int eliminar = JOptionPane.showOptionDialog(null, "Usted desea eliminar el siguiente viaje?\n" + viaje,
                    "Eliminar viaje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, null, null);

            switch (eliminar) {
                case 0:
                    metodos.msg("Se ha eliminado el siguiente registro: \n" + viaje);
                    lista.remove((id - 1));
                    break;
                case 1:
                    metodos.msg("No se ha eliminado ningun viaje");
                    break;
                default:
                    metodos.msg("No se ha elegido una opcion correcta");
            }
        }
    }

    public void Menu() {
        String[] opciones = {"Crear", "Modificar", "Ver", "Eliminar", "Volver"};

        int opcion = -1;
        while (opcion != opciones.length - 1) {
            opcion = metodos.menuBotones("Seleccione una opción", "Sub Menú Ventas", opciones, "Volver");
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
                default:
                    metodos.msg("Volviendo al menu anterior");
            }
        }
    }
}
