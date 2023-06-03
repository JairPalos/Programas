import javax.swing.JOptionPane;// se importa la libreria a utulizar

public class ColaArray // se crea el constructor
{
    private int MAX;//Se crea una variable entera
    private int[] COLA;//Se crea un areeglo entera
    private int FRENTE;//Se crea una variable entera
    private int FINAL;//Se crea una variable entera

    public ColaArray()
    {// se crea la funcion para la cola del arreglo
        this.MAX = 100;// se compar// se compara numeroa numero
        this.FRENTE = 0;// se compara numero
        this.FINAL = 0;// se compara numero
        this.COLA = new int[this.MAX+1];// se compara numero
    }// cierra

    public ColaArray(int MAX)
    {// se crea  una funcion de cola para los datos
        this.MAX = MAX;// se compara numero
        this.FRENTE = 0;// se compara numero
        this.FINAL = 0;  // se compara numero
        this.COLA = new int[this.MAX+1];// se compara numero
    }

    public boolean IsColaLlena()
    {// se crea una funcion para ver si la cola esta llena
        if(this.FINAL == this.MAX)// si la cola tiene el el maximo del final
        {
            return true;// regersa que si esta lleno
        }
        else// sino
        {
            return false;// regresa falso
        }
    }

    public boolean IsColaVacia()// se crea una funcion para  saber si la cola esta vacia
    {
        if(this.FRENTE == this.FINAL)// si el valor de la cola esta en el incio
        {
            return true;// manda verdadero que si esta vacia
        }
        else// sino
        {
            return false;// regres falso entendnendo que tine datos
        }
    }

    public void InsertarCola()//se crea la funcion pra insertar cola
    {
        if(this.IsColaLlena())// si la funciion is cola
        {
            JOptionPane.showMessageDialog(null,"LA COLA ESTA LLENA");// si es verdadero manda
        }
        else
        {
            int ITEM;

            ITEM = Integer.parseInt(JOptionPane.showInputDialog(null,"INGRESE EL ITEM A AGREGAR"));//si esta vacia

            this.FINAL++;// incrementa el final
            this.COLA[FINAL] = ITEM;// carga el valor a cola

        }
    }

    public void EliminarCola()// se crea una funcion para eliminar colas
    {
        if(this.FRENTE == this.FINAL)// si el valor de de inicio es igual al final
        {
            JOptionPane.showMessageDialog(null,"LA COLA ESTA VACIA");// la cola esta vacia
        }
        else// sino
        {
            for(int i=FRENTE;i < FINAL - 1;i++)// se cre un buncle para recorrer la cola
            {
                COLA[i] = COLA[i+1];// se ingresa ese valor
            }

            FINAL--;// se decrementa el final
        }
    }

    public void MostrarCola()// se crea una funciom para MOSTRAR la cola
    {
        if(this.IsColaVacia())// si el valor de cola vacia
        {
            JOptionPane.showMessageDialog(null,"LA COLA ESTA VACIA\n NO HAY DATOS QUE MOSTRAR","MOSTRAR DATOS",JOptionPane.WARNING_MESSAGE);
        }// si el verdadero muestra que la cola esta vacia
        else
        {
            String MOSTRAR = "";// crea un string para pprder mostar

            for(int i=FRENTE+1;i<=FINAL;i++)// recorre el arreglo
            {
                MOSTRAR = MOSTRAR + COLA[i]+"\n";// imprime el valor de la cola
            }

            JOptionPane.showMessageDialog(null,"TOTAL ES : "+this.FINAL+"\n"+"LOS DATOS DE LA COLA SON : \n"+MOSTRAR,"MOSTRAR DATOS",JOptionPane.INFORMATION_MESSAGE);
        }// muestra el valores de la cola
    }

    public void VaciarCola()// se crea una funcio para eliminar los valores de la cola
    {
        FRENTE = 0;//se limpia final
        FINAL = 0;//se limpia enfrente
    }
}
