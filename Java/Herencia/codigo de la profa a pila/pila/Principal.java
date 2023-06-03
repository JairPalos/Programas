package pila;// paquete de la clase
import javax.swing.JOptionPane;// importa la libreria para utilizar  los dialogos con interfaz

public class Principal{// se crea la clase principal
	public static void main(String [] args){// se crea la clase main
		int opcion=0, elemento=0;// se crean con variables enteras incializada en cero para pasarles un valor
		Pila colas=new Pila();// se crea una variable de objeto Pila
		do{// inicio del do-while
			try{//inicio del try
				opcion=Integer.parseInt(JOptionPane.showInputDialog(null,// muestra un mensaje en pantalla pero a la vez guarda el valor en opcion
						"1. Insertar elementos a la pila \n"// muestra un mensaje en pantalla
					+ "2.Quitar elementos de la pila \n"// muestra un mensaje en pantalla
					+ "3.¿La cola esta vacia? \n"// muestra un mensaje en pantalla
					+ "4.¿Cual es el elemeto que esta al inicio? \n"// muestra un mensaje en pantalla
					+	"5.¿Cual es el elemeto que esta al final? \n"// muestra un mensaje en pantalla
					+ "6.¿Cual es el tamanio de la pila?\n"// muestra un mensaje en pantalla
					+ "7.Salir", "Menu de Operaciones de la pila",// muestra un mensaje en pantalla
					JOptionPane.QUESTION_MESSAGE));// muestra un mensaje en pantalla
				switch(opcion){//inicio del switch
				case 1:// en el caso 2
					elemento=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el elemento: ",// muestra un mensaje en pantalla pero a la vez guarda el valor en elemento
						"Insertando en la Pila", JOptionPane.QUESTION_MESSAGE));// muestra un mensaje en pantalla pero a la vez guarda el valor en elemeto
					colas.insertar(elemento);// se llama al metodo insertar del objeto cola
					break;// rompe el switch
				case 2:// en el caso dos
					if(!colas.estaVacia()){// si esta vacia la cola
						JOptionPane.showMessageDialog(null,"Elemento quitado es: " + colas.quitar(),// si es verdadero llama el metodo quitar y manda un mensaje
							"Quitando Elemento de la Cola", JOptionPane.INFORMATION_MESSAGE);// si es verdadero llama el metodo quitar y manda un mensaje
					}else{//sino
						JOptionPane.showMessageDialog(null,"La pila esta vacia ", "Pila vacia", JOptionPane.INFORMATION_MESSAGE);//mansa un jensaje diciendo que esta vacia
					}// final del else
					break;// rompe el switch
				case 3://en el caso tres
					if(colas.estaVacia()){// si esta vacia la cola
						JOptionPane.showMessageDialog(null,"La Pila esta vacia", "Pila Vacia",// si es verdadero manda un mensaje de que esta vacia
							JOptionPane.INFORMATION_MESSAGE);// si es verdadero manda un mensaje de que esta vacia
					} else {// sino
						JOptionPane.showMessageDialog(null, "La pila no esta Vacia", "Pila con elementos",// si es verdadero manda un mensaje de que no esta vacia
							JOptionPane.INFORMATION_MESSAGE);// si es verdadero manda un mensaje de que no esta vacia
					}// final del else
					break;// rompe el switch
				case 4:// en el caso cuatro
					if(!colas.estaVacia()){// si es diferente de vacia cola es decir si es falso
						JOptionPane.showMessageDialog(null, "El elemento ubicado al inicio de la pila es: " + colas.inicioCola(),// muestra el inicio de la pila mas un mensaje
							"Valor del Inicio de la Cola", JOptionPane.INFORMATION_MESSAGE);// muestra el inicio de la pila mas un mensaje
					}else{//sino
						JOptionPane.showMessageDialog(null,"La Pila esta vacia", "Pila Vacia",//manda un mesaje de que esta vacia
							JOptionPane.INFORMATION_MESSAGE);//manda un mesaje de que esta vacia
					}// final del else
					break;// rompe el switch
				case 5:// en el caso cinco
						if(!colas.estaVacia()){// si es diferente de vacia cola es decir si es falso
							JOptionPane.showMessageDialog(null, "El elemento ubicado al inicio de la Pila es: " + colas.finalCola(),// muestra el inicio de la pila mas un mensaje
								"Valor del Inicio de la Pila", JOptionPane.INFORMATION_MESSAGE);// muestra el inicio de la pila mas un mensaje
						}else{//sino
							JOptionPane.showMessageDialog(null,"La Pila esta vacia", "Pila Vacia",// muestra  un mensaje
								JOptionPane.INFORMATION_MESSAGE);// muestra  un mensaje
						}//final del else
						break;//rompe el switch
				case 6:// en el caso seis
					JOptionPane.showMessageDialog(null, "El tamanio de la Pila es: " + colas.tamanioCola(), "Dimension de la Pila",// muestra un mensaje con el tamaño de la pila
						JOptionPane.INFORMATION_MESSAGE);// muestra un mensaje con el tamaño de la pila
					break;// rompe el switch
				case 7:// en el caso siete
					JOptionPane.showMessageDialog(null, "Aplicacion Terminada","Fin", JOptionPane.INFORMATION_MESSAGE);// muestra un mensaje que es el fin
					break;// muestra un mensaje que es el fin
				default://SINO
					JOptionPane.showMessageDialog(null, "La opcion seleccionada es incorrecta","Alerta", JOptionPane.INFORMATION_MESSAGE);// muestra un mensaje que es  incorrecta la opcion
				}//final del switch

			}//fin del try
				catch(NumberFormatException n){// inicio del catch con la exepcion
					JOptionPane.showMessageDialog(null, "Error" + n.getMessage());// muestra un mensaje
				}//fin del catch
		}//fin del do
			while(opcion!=7);// si es diferente de 7
	}//Fin de la funcipon principal

}//Clase
