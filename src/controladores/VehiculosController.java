package controladores;

import interfaces.Crudinterfaces;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Vehiculos;

public class VehiculosController implements Crudinterfaces {

    public static List<Vehiculos> lista = new ArrayList();
    Metodos metodos = new Metodos();

    public String ingresardatos(String text, String title) {
        return JOptionPane.showInputDialog(null, text,
                title, JOptionPane.QUESTION_MESSAGE);
    }

    public void mostrarmensaje(String autosagregados, String title) {
        JOptionPane.showMessageDialog(null, autosagregados, title,
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void Crear() {
        int placa;
        String marca;
        String estilo;
        String modelo;
        int capacidad;

        try {
            placa = Integer.parseInt(ingresardatos("Ingrese la placa del vehiculo", "Ingresar datos del vehiculo"));
        } catch (Exception e) {
            mostrarmensaje("Este campo solo acepta numeros enteros", "Error");
            placa = Integer.parseInt(ingresardatos("Ingrese la placa del vehiculo", "Ingresar datos del vehiculo"));
        }
        marca = ingresardatos("Ingrese la marca del vehiculo", "Ingresar datos del vehiculo");
        estilo = ingresardatos("Ingrese el estilo del vehiculo", "Ingresar datos del vehiculo");
        modelo = ingresardatos("Ingrese el modelo del vehiculo", "Ingresar datos del vehiculo");

        try {
            capacidad = Integer.parseInt(ingresardatos("Ingrese la capacidad del vehiculo", "Ingresar datos del vehiculo"));
        } catch (Exception e) {
            mostrarmensaje("Este campo solo acepta numeros enteros", "Error");
            capacidad = Integer.parseInt(ingresardatos("Ingrese la capacidad del vehiculo", "Ingresar datos del vehiculo"));
        }

        Vehiculos b = new Vehiculos(placa, marca, estilo, modelo, capacidad);

        lista.add(b);
    }

    @Override
    public void Modificar() {
        boolean esValido = false;

        int idVehiculos = -1;
        int indexVehiculos = -1;
        try {
            idVehiculos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del vehiculo"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingreso un ID no válido");
        }
        
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getPlaca() == idVehiculos) {
                indexVehiculos = i;
                break;
            }

        }
        if (indexVehiculos != -1) {
            int placa = lista.get(indexVehiculos).getPlaca();
            String marca = lista.get(indexVehiculos).getMarca();
            String estilo = lista.get(indexVehiculos).getEstilo();
            String modelo = lista.get(indexVehiculos).getModelo();
            int capacidad = lista.get(indexVehiculos).getCapacidad();

            try {
                placa = Integer.parseInt(ingresardatos("Ingrese la nueva placa del vehiculo", "Ingresar datos del vehiculo"));
            } catch (Exception e) {
                mostrarmensaje("Este campo solo acepta numeros enteros", "Error");
                placa = Integer.parseInt(ingresardatos("Ingrese la nueva placa del vehiculo", "Ingresar datos del vehiculo"));
            }
            marca = JOptionPane.showInputDialog("Ingrese la nueva marca", marca);
            estilo = JOptionPane.showInputDialog("Ingrese el nuevo estilo", estilo);
            modelo = JOptionPane.showInputDialog("Ingrese el nuevo modelo", modelo);
            try {
                capacidad = Integer.parseInt(ingresardatos("Ingrese la nueva capacidad del vehiculo", "Ingresar datos del vehiculo"));
            } catch (Exception e) {
                mostrarmensaje("Este campo solo acepta numeros enteros", "Error");
                placa = Integer.parseInt(ingresardatos("Ingrese la nueva capacidad del vehiculo", "Ingresar datos del vehiculo"));
            }

            lista.get(indexVehiculos).setPlaca(placa);
            lista.get(indexVehiculos).setMarca(marca);
            lista.get(indexVehiculos).setEstilo(estilo);
            lista.get(indexVehiculos).setModelo(modelo);
            lista.get(indexVehiculos).setCapacidad(capacidad);
            System.out.println(lista);

            JOptionPane.showMessageDialog(null, "Cambio realizado satisfactoriamente");
        }
    }

    @Override
    public void Ver() {
        int idPersonas;
        try {
            idPersonas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la placa del vehiculo"));
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getPlaca() == idPersonas) {
                    JOptionPane.showConfirmDialog(null, lista.get(i));
                    break;
                }
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void Eliminar() {
        int placa = Integer.parseInt(metodos.getCadena("Ingrese la placa del vehiculo: "));
        if (metodos.SIoNo("Realmente desea eliminar la placa?", "Atención") == 0) {
            lista.remove(traerListVehiculos(placa));
        }
    }

    public int traerListVehiculos(int placa) {
        Vehiculos vehiculos = new Vehiculos();
        int i = 0;
        for (Vehiculos b : lista) {
            if (b.getPlaca() == placa) {
                break;
            }
            i = i + 1;
        }
        return i;
    }

    public void Menu() {

        String[] opciones = {"Crear", "Modificar", "Ver", "Eliminar", "Volver"};

        int opcion = -1;
        while (opcion != opciones.length - 1) {
            opcion = metodos.menuBotones("Seleccione una opción", "Sub Menú Vehiculos", opciones, "Volver");
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
            }
        }
    }

}
