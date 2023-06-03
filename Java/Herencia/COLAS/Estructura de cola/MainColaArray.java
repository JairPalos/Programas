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
        int Opcion;// se crea un int

        do// se empieza un do while
        {
          Opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1. INGRESAR DATOS\n"+
                    "2. OBSERVAR DATOS DE LA COLA 1\n"+
                    "3. PASAR LA COLA A - COLA B\n"+
                    "4. OBSERVAR SEGUNDA COLA \n"+
                    "5. SALIR\n"+
                    "--------------------------------------------------------\n"+
                    "INGRESE LA OPCION [1 - 5]","MENU COLA",JOptionPane.QUESTION_MESSAGE));

            switch(Opcion)// incia
            {
                case 1: Cola.InsertarCola();break;//casoa
                case 2: Cola.MostrarCola();break;// caso c
                case 3: Cola.copy(); break;
                case 4:
                        if(Cola.colaNoCopiada()){
                            JOptionPane.showMessageDialog(null,"LA COLA A NO HA SIDO MOVIDA A COLA B","MOSTRAR DATOS",JOptionPane.WARNING_MESSAGE);
                            break;// caso d
                        }else{
                            Cola.MostrarCola2();
                            break;
                        }
                case 5: System.exit(0);break;// caso e
                default: JOptionPane.showMessageDialog(null,"INGRESE UNA OPCION VALIDA \n","ERROR OPCION",JOptionPane.WARNING_MESSAGE);break;
            }
        }
        while(true);// termina el while
    }
}
