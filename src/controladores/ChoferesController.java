
package controladores;

import interfaces.Crudinterfaces;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Choferes;

public class ChoferesController implements Crudinterfaces {
    
    public static List<Choferes> lista = new ArrayList();
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
      int cid;
        String licencia;
       
         try{
            cid = Integer.parseInt(ingresardatos("Ingrese el id del chofer", "Ingresar datos del chofer"));
        } catch (Exception e){
            mostrarmensaje("Este campo solo acepta numeros enteros", "Error");
            cid = Integer.parseInt(ingresardatos("Ingrese el id del chofer", "Ingresar datos del chofer"));
        }
         licencia = ingresardatos("Ingrese la licencia del chofer", "Ingresar datos del chofer");
         
         Choferes b = new Choferes(cid, licencia);

        lista.add(b); 
    }

    @Override
    public void Modificar() {
             boolean esValido = false;

        int idchofer = -1;
        int indexchofer = -1;
        try {
            idchofer = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del chofer"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingreso un ID no válido");
        }
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCid() == idchofer) {
                indexchofer = i;
                break;
            }

        }
        if (indexchofer != -1) {
            String licencia = lista.get(indexchofer).getLicencia();
          
           licencia = JOptionPane.showInputDialog("Ingrese el nuevo numero de licencia", licencia);
           
            
            lista.get(indexchofer).setLicencia(licencia);
           
           JOptionPane.showMessageDialog(null, "Modificación realizada con exito.");
        } 
    }

    @Override
    public void Ver() {
       int idChoferes;
        try {
            idChoferes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del chofer"));
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getCid() == idChoferes) {
                    JOptionPane.showConfirmDialog(null, lista.get(i));
                    break;
                }

            }

        } catch (Exception e) {
        }  
    }

    @Override
    public void Eliminar() {
       int cid = Integer.parseInt(metodos.getCadena("Ingrese el id del chofer: "));
      if (metodos.SIoNo("Realmente desea eliminar al chofer?","Atención")==0){
            lista.remove(traerListChoferes(cid));
        } 
    }

       public int traerListChoferes(int cid) {
        Choferes choferes = new Choferes();
        int i = 0;
        for (Choferes b : lista) {
            if (b.getCid() == cid) {
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
            opcion = metodos.menuBotones("Seleccione una opción", "Sub Menú choferes", opciones, "Volver");
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
