import javax.swing.JOptionPane;// se crea la libreria

public class MainColaArray// se crea la clase
{
    public static ColaArray Cola;// se declara una cola

    public static void main(String[] ARGUMENTOS)
    {// se crea el main
        int MAX;// se cre unnentero

        MAX = Integer.parseInt(JOptionPane.showInputDialog(null,"INGRESE EL TAMANO DE LA COLA"));// muestra un mensaje
        Cola = new ColaArray(MAX);// se ingresa valores de la cola

        MenuCola();// invocva a la funcion menu
    }

    public static void MenuCola()// se crea la funcion menu
    {
        String Opcion;// se crea un string

        do// se empieza un do while
        {
            Opcion = JOptionPane.showInputDialog(null,
                    "a). INGRESAR DATOS\n"+//muestra el mensaje
                    "b). ELIMINAR DATOS\n"+// muestra el mensaje
                    "c). OBSERVAR DATOS\n"+// muestar el mensaje
                    "d). VACIAR COLA\n"+// muestra el mensaje
                    "e). SALIR\n"+// muestra el mensaje
                    "--------------------------------------------------------\n"+
                    "INGRESE LA OPCION [a - e]","MENU COLA",JOptionPane.QUESTION_MESSAGE);// muestra el mensaje

            switch(Opcion)// incia
            {
                case "a": Cola.InsertarCola();break;//casoa
                case "b": Cola.EliminarCola();break;//caso b
                case "c": Cola.MostrarCola();break;// caso c
                case "d": Cola.VaciarCola();break;// caso d
                case "e": System.exit(0);break;// caso e
                default: JOptionPane.showMessageDialog(null,"INGRESE UNA OPCION VALIDA \n","ERROR OPCION",JOptionPane.WARNING_MESSAGE);break;
            }
        }
        while(true);// termina el while
    }
}
