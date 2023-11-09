
package controladores;

import interfaces.Crudinterfaces;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Usuarios;

public class UsuariosController implements Crudinterfaces {
    
    public static List<Usuarios> lista = new ArrayList();
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
       int uid;
        String codigo;
        String clave;
     
        
        try{
            uid = Integer.parseInt(ingresardatos("Ingrese el id del usuario", "Ingresar datos del usuario"));
        } catch (Exception e){
            mostrarmensaje("Este campo solo acepta numeros enteros", "Error");
            uid = Integer.parseInt(ingresardatos("Ingrese el id del usuario", "Ingresar datos del usuario"));
        }
         codigo = ingresardatos("Ingrese el codigo del usuario", "Ingresar datos del usuario");
         clave = ingresardatos("Ingrese la clave del usuario", "Ingresar datos del usuario");
       
         
         Usuarios b = new Usuarios(uid, codigo, clave);

        lista.add(b); 
    }

    @Override
    public void Modificar() {
           boolean esValido = false;

        int idusuario = -1;
        int indexusuario = -1;
        try {
            idusuario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingreso un ID no válido");
        }
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getUid() == idusuario) {
                indexusuario = i;
                break;
            }

        }
        if (indexusuario != -1) {
            String codigo = lista.get(indexusuario).getCodigo();
            String clave = lista.get(indexusuario).getClave();
          
           codigo = JOptionPane.showInputDialog("Ingrese el nuevo codigo de usuario", codigo);
           clave = JOptionPane.showInputDialog("Ingrese la nueva clave del usuario", clave);
            
            lista.get(indexusuario).setCodigo(codigo);
            lista.get(indexusuario).setClave(clave);
            
            JOptionPane.showMessageDialog(null, "Modificación realizada con exito.");
        }   
    }

    @Override
    public void Ver() {
       int idUsuarios;
        try {
            idUsuarios = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del usuario"));
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getUid() == idUsuarios) {
                    JOptionPane.showConfirmDialog(null, lista.get(i));
                    break;
                }

            }

        } catch (Exception e) {
        }  
    }

    @Override
    public void Eliminar() {
       int uid = Integer.parseInt(metodos.getCadena("Ingrese el id del usuario: "));
      if (metodos.SIoNo("Realmente desea eliminar el usuario?","Atención")==0){
            lista.remove(traerListUsuarios(uid));
        } 
    }
    
       public int traerListUsuarios(int uid) {
        Usuarios usuarios = new Usuarios();
        int i = 0;
        for (Usuarios b : lista) {
            if (b.getUid() == uid) {
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
            opcion = metodos.menuBotones("Seleccione una opción", "Sub Menú Usuarios", opciones, "Volver");
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
