#include <pthread.h>
#include <stdio.h>
#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <sstream>
#include <stdio.h>

using namespace std;

vector<int> numeros;

void *lectura(void* arg) {


  ifstream archivo("vector.txt");

  if (archivo.is_open()) {
    string linea;
    getline(archivo, linea); // Leemos la primera línea del archivo
    stringstream ss(linea); // Creamos un stringstream a partir de la línea leída

    while (getline(ss, linea, ',')) { // Leemos cada número separado por comas
      int num = stoi(linea); // Convertimos la cadena a entero
      numeros.push_back(num); // Agregamos el número al vector
    }

    archivo.close(); // Cerramos el archivo
  } else {
    cout << "No se pudo abrir el archivo." << endl;
  }

  // Imprimimos los números leídos
  cout << "Los numeros leidos son: ";
  for (int num : numeros) {
    cout << num << " ";
  }
  cout << endl;

}

int main(void) {

  pthread_t thread1;

  pthread_create(&thread1, 0,lectura,0);
  pthread_join(thread1, NULL);


  return 0;
}
