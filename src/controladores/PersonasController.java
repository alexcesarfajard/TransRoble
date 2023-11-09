
package controladores;

import interfaces.Crudinterfaces;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Personas;

public class PersonasController implements Crudinterfaces {
    
     public static List<Personas> lista = new ArrayList();
    
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
        int nid;
        String nombre;
        int telefono;
        String correo;
        
        try{
            nid = Integer.parseInt(ingresardatos("Ingrese el id de la persona", "Ingresar datos de la persona"));
        } catch (Exception e){
            mostrarmensaje("Este campo solo acepta numeros enteros", "Error");
            nid = Integer.parseInt(ingresardatos("Ingrese el id de la persona", "Ingresar datos de la persona"));
        }
         nombre = ingresardatos("Ingrese el nombre de la persona", "Ingresar datos de la persona");
         correo = ingresardatos("Ingrese el correo de la persona", "Ingresar datos de la persona");
        
          try{
            telefono = Integer.parseInt(ingresardatos("Ingrese el numero de telefono", "Ingresar datos de la persona"));
        } catch (Exception e){
            mostrarmensaje("Este campo solo acepta numeros enteros", "Error");
            telefono = Integer.parseInt(ingresardatos("Ingrese el numero de telefono", "Ingresar datos de la persona"));
        }
         
         Personas b = new Personas(nid, nombre, telefono, correo);

        lista.add(b);
    }

    @Override
    public void Modificar() {
        boolean esValido = false;

        int idPersonas = -1;
        int indexPersonas = -1;
        try {
            idPersonas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la persona"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingreso un ID no válido");
        }
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNid() == idPersonas) {
                indexPersonas = i;
                break;
            }

        }
        if (indexPersonas != -1) {
            String personaNombre = lista.get(indexPersonas).getNombre();
            int personaTelefono = lista.get(indexPersonas).getTelefono();
            String personaCorreo = lista.get(indexPersonas).getCorreo();

            personaNombre = JOptionPane.showInputDialog("Ingrese el nombre de la persona a cambiar", personaNombre);

                 try{
            personaTelefono = Integer.parseInt(ingresardatos("Ingrese el numero de telefono", "Ingresar datos de la persona"));
        } catch (Exception e){
            mostrarmensaje("Este campo solo acepta numeros enteros", "Error");
             personaTelefono = Integer.parseInt(ingresardatos("Ingrese el numero de telefono", "Ingresar datos de la persona"));
        }
        
         personaCorreo = JOptionPane.showInputDialog("Ingrese el correo de la persona a cambiar", personaCorreo);

            lista.get(indexPersonas).setNombre(personaNombre);
            lista.get(indexPersonas).setTelefono(personaTelefono);
            lista.get(indexPersonas).setCorreo(personaCorreo);
            System.out.println(lista);

            JOptionPane.showMessageDialog(null, "Cambio realizado satisfactoriamente");
        }
    }

    @Override
    public void Ver() {
       int idPersonas;
        try {
            idPersonas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID de la persona"));
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getNid() == idPersonas) {
                    JOptionPane.showConfirmDialog(null, lista.get(i));
                    break;
                }

            }

        } catch (Exception e) {
        }          
   
    }

    @Override
    public void Eliminar() {
      int nid = Integer.parseInt(metodos.getCadena("Ingrese el id de la persona: "));
      if (metodos.SIoNo("Realmente desea eliminar la persona?","Atención")==0){
            lista.remove(traerListPersonas(nid));
            
        }  
    }
    
      public int traerListPersonas(int nid) {
        Personas personas = new Personas();
        int i = 0;
        for (Personas b : lista) {
            if (b.getNid() == nid) {
                break;
            }
            i = i + 1;
        }
        return i;
    }
    
  
    public void Menu() {

        String[] opciones = {"Crear", "Modificar", "Ver", "Eliminar",  "Volver"};

        int opcion = -1;
        while (opcion != opciones.length - 1) {
            opcion = metodos.menuBotones("Seleccione una opción", "Sub Menú personas", opciones, "Volver");
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
