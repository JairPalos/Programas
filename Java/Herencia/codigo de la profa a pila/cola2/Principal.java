package cola2;
import javax.swing.JOptionPane;

public class Principal{
	public static void main(String [] args){
		int opcion=0, elemento=0;
		Cola colas=new Cola();
		do{
			try{
				opcion=Integer.parseInt(JOptionPane.showInputDialog(null,
					"1. Insertar elementos a la cola \n"
					+ "2.Quitar elementos de la cola \n"
					+ "3.¿La cola esta vacia? \n"
					+ "4.¿Cual es el elemeto que esta al inicio? \n"
					+ "5.¿Cual es el tamanio de la cola?\n"
					+ "6.Salir", "Menu de Operaciones de la Cola",
					JOptionPane.QUESTION_MESSAGE));
				switch(opcion){
				case 1:
					elemento=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el elemento: ",
						"Insertando en la Cola", JOptionPane.QUESTION_MESSAGE));
					colas.insertar(elemento);
					break;
				case 2:
					if(!colas.estaVacia()){
						JOptionPane.showMessageDialog(null,"Elemento quitado es: " + colas.quitar(),
							"Quitando Elemento de la Cola", JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null,"La cola esta vacia ", "Cola vacia", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case 3:
					if(colas.estaVacia()){
						JOptionPane.showMessageDialog(null,"La Cola esta vacia", "Cola Vacia",
							JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "La cola no esta Vacia", "Cola con elementos",
							JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case 4:
					if(!colas.estaVacia()){
						JOptionPane.showMessageDialog(null, "El elemento ubicado al inicio de la cola es: " + colas.inicioCola(),
							"Valor del Inicio de la Cola", JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null,"La Cola esta vacia", "Cola Vacia",
							JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case 5:
					JOptionPane.showMessageDialog(null, "El tamanio de la cola es: " + colas.tamanioCola(), "Dimension de la Cola",
						JOptionPane.INFORMATION_MESSAGE);
					break;
				case 6:
					JOptionPane.showMessageDialog(null, "Aplicacion Terminada","Fin", JOptionPane.INFORMATION_MESSAGE);
					break;
				default:
					JOptionPane.showMessageDialog(null, "La opcion seleccionada es incorrecta","Alerta", JOptionPane.INFORMATION_MESSAGE);
				}

			}//fin del try
				catch(NumberFormatException n){
					JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
				}//fin del catch
		}//fin del do
			while(opcion!=6);
	}//Fin de la funcipon principal

}//Clase
