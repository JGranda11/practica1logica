package practica2y3;

import practica1.Familia;
import practica1.Nave;
import practica1.Persona;
import practica1.PersonaMuerta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    //Variables para almacenar datos de las personas en la función generadora
    String nombre, genero;
    int edad;

    //Arreglo que guardará la información de cada persona fallecida durante el viaje
    List<PersonaMuerta> personasMuertas = new ArrayList<>();

    //Variable que nos permitirá manejar más adelante qué evento se ejecutará
    int eventoAnillo;

    //Arreglos de nombres para la función generadora
    String[] nombresHombres = {"Juan", "Pedro", "Manuel", "Luis", "Carlos", "Jorge", "Miguel", "José", "David", "Francisco", "Alejandro", "Mario", "Rafael", "Daniel", "Sergio", "Fernando", "Gabriel", "Antonio", "Ernesto", "Andrés", "Javier", "Adrián", "Diego", "Pablo", "Alfredo", "Eduardo", "Héctor", "Ignacio", "Gustavo", "Roberto", "Raúl", "Óscar", "Tomás", "César", "Abel", "Benjamín", "Emilio", "Hugo", "Israel", "Jaime", "Josué", "Julio", "Leo", "Marco", "Max", "Nicolás", "Ramiro", "Ricardo", "Sebastián", "Víctor"};
    String[] nombresMujeres = {"María", "Ana", "Sofía", "Luisa", "Carmen", "Lucía", "Marta", "Isabel", "Laura", "Patricia", "Paula", "Adriana", "Valeria", "Fernanda", "Valentina", "Camila", "Mónica", "Daniela", "Gabriela", "Carolina", "Liliana", "Claudia", "Rosa", "Elena", "Silvia", "Verónica", "Lorena", "Esther", "Natalia", "Pilar", "Alicia", "Beatriz", "Sara", "Diana", "Emily", "Gloria", "Aurora", "Julia", "Jimena", "Regina", "Miriam", "Ximena", "Irene", "Olga", "Rosario", "Vanessa", "Cecilia", "Angélica", "Elvira", "Rocío"};

    //Arreglo de familias. Acá se guardan las 100 personas de la nave divididas por familias
    Familia[] familias = new Familia[25];

    //Arreglo de personas
    Persona[] personas = new Persona[100];

    //Objeto nave
    Nave nave = new Nave();


    //Función que nos permite generar personas aleatorias con nombres aleatorios del arreglo y edad en
    Random rand = new Random();
    for (int i = 0; i < 100; i++) {

      if (rand.nextInt() % 2 == 0) {
        nombre = nombresHombres[rand.nextInt(50)];
        genero = "masculino";
      } else {
        nombre = nombresMujeres[rand.nextInt(50)];
        genero = "femenino";
      }

      edad = rand.nextInt(81);
      personas[i] = new Persona(nombre, genero, edad);
    }

    //Variable auxiliar para dividir las personas por familias
    int j = 0;

    //Ciclo for que nos permite almacenar el valor de personas dividido por familias
    for (int i = 0; i<25; i++){
        familias[i] = new Familia(personas[j], personas[j+1], personas[j+2], personas[j+3]);
        j=j+4;
    }

    //Usamos la misma variable j en 0 para pasar cada familia a una cabina de la nave
    j = 0;
    for (int i = 0; i < 5; i++){
      for (int k = 0; k < 5; k++){
        nave.ingresarFamilia(i, k, familias[j]);
        j++;
      }
    }

    //Generamos un número random entre 0 a 100 para conocer que evento será el que se ejecutará

    eventoAnillo = rand.nextInt(101);

    System.out.println("\n-----Resumen inicial de la nave-----\n");

    nave.mostrarNave();

    System.out.println("********************************************************************************");
    System.out.println("               Salida de la nave del planeta Gamma(planeta origen) ");
    System.out.println("********************************************************************************\n");

    System.out.println("En el anillo de Gama, están asociados: Evento 1, Evento 4, Evento 7\n");


    //Si el número random se encuentra entre 0 y 20 ocurre el choque con meteorito. 20% de probabilidad
    if(eventoAnillo <= 20){
      nave.colisionarConAsteroide("Saliendo de Gamma hacia Sigma");

      //Si el número random se encuentra entre 20 y 50 ocurre una tormenta solar. 30% de probabilidad
    }else if(eventoAnillo > 20 && eventoAnillo <= 50){
      nave.tormentaSolar();

      //Si el número se encuentra entre 50 y 80 ocurre un ataque de piratas con un 30% de probabilidad
    }else if(eventoAnillo >50 && eventoAnillo <= 80){
      nave.secuestrasMenoresDiagonales();
      System.out.println("Todos los menores de edad de las 2 diagonales fueron secuestrados por esclavistas");

      //Sino, si se encuentra entre 80 y 100, no pasa nada. 20% de probabilidad.
    }else{
      System.out.println("La nave salió de Gamma sana y salva");
    }


    //Generamos otro entero random para escoger el evento que pasará entrando a Sigma
    eventoAnillo = rand.nextInt(101);
    System.out.println();
    System.out.println("********************************************************************************");
    System.out.println("               Entrada de la nave al planeta Sigma(planeta destino) ");
    System.out.println("********************************************************************************\n");
    System.out.println("En el anillo de Sigma, están asociados: Evento 1, Evento 3, Evento 5\n");

    //Si el número está entre 0 y 15 puede ocurrir un choque con un asteroide. 15% de probabilidad
    if(eventoAnillo <= 15){
      nave.colisionarConAsteroide("Entrando a Sigma");

      //Si se encuentra entre 15 y 45 puede ocurrir la fuga de aire. 30% de probabilidad
    }else if(eventoAnillo > 15 && eventoAnillo <= 45){
      nave.fugaDeAire();

      //Si se encuentra entre 45 y 48 puede ocurrir el araque de piratas que secuestra a las mujeres. 40% de probabilida
    }else if(eventoAnillo > 45 && eventoAnillo <= 85){
      nave.secuestrarMujeresDiagonalPpal();
      System.out.println("Todas las mujeres de la diagonal principal han sido secuestradas por piratas");

      //Si no, está entre 85 y 100, no ocurre nada. 15% de probabilidad
    }else{
      System.out.println("La nave entró a Sigma sana y salva");
    }



    System.out.println("\n-----Resumen final personas fallecidas-----\n");
    int i = 0;
    personasMuertas=nave.getPersonasFallecidas();
    for ( PersonaMuerta p : personasMuertas) {
      System.out.println((i+1) +" "+ p.toString());
      i++;
    }

    System.out.println("\n\n-----Resumen final de personas que quedan en la nave-----");
    nave.mostrarNave();

    List<Lado> lados = Arrays.asList(
            new Lado(1, 2, 1), new Lado(1, 8, 2), new Lado(2, 3, 4),
            new Lado(2, 4, 1), new Lado(2, 7, 3), new Lado(3, 5, 3),
            new Lado(3, 6, 3), new Lado(4, 9, 3), new Lado(5, 4, 6),
            new Lado(5, 6, 2), new Lado(7, 8, 1), new Lado(9, 6, 2),
            new Lado(9, 10, 5));

    Grafo grafo = new Grafo(lados);

    Grafo.printGraph(grafo);

    personasMuertas.clear();
    Rover rover = new Rover();

    for (int k = 0; k < 5; k++) {
      for (int l = 0; l < 5; l++) {
        if((nave.getNave()[k][l].familiaViva()) && (rover.getCabinas().size()<9)){
          rover.agregarFamilia(nave.getNave()[k][l]);
        }
      }
    }

    int nodoAViajar = 0;
    int cantidadAdyacentes = 0;
    int nodoActual = rand.nextInt(10)+1;

    System.out.println("El rover ha aterrizado en el nodo " + nodoActual);

    int cantidadDePersonas = 0;

    for (Familia familia : rover.getCabinas()) {
      cantidadDePersonas += familia.numeroDePersonasVivas();
    }

    System.out.println("cantidad de personas " + cantidadDePersonas);
    int peso;
    int consumoDeOxígeno;
    //Instrucciones para realizar el recorrido
    while((nodoActual != 8) && (nodoActual != 10) && (nodoActual != 6)){

      cantidadAdyacentes = grafo.getAdjList().get(nodoActual).size();
      nodoAViajar = rand.nextInt(cantidadAdyacentes);

      peso = grafo.getAdjList().get(nodoActual).get(nodoAViajar).peso;
      nodoActual = grafo.getAdjList().get(nodoActual).get(nodoAViajar).valor;

      System.out.println("El rover ha viajado al nodo " + nodoActual);



      consumoDeOxígeno = peso * cantidadDePersonas;

      rover.setUnidadesOxigeno(rover.getUnidadesOxigeno()-consumoDeOxígeno);

      if(rover.getUnidadesOxigeno()<10){
        rover.tirarFamiliaABorda(nodoActual);
      }

      System.out.println("El consumo de oxígeno en este trayecto fue: " + consumoDeOxígeno);
    }

    System.out.println(rover.getUnidadesOxigeno());

    if((nodoActual == 8) || (nodoActual == 10) ){
      System.out.println("\nEl rover quedó atrapado en el valle del nodo " + nodoActual);
    }else{
      System.out.println("El rover llegó a la base...");
    }

    cantidadDePersonas = 0;

    for (Familia familia : rover.getCabinas()) {
      cantidadDePersonas += familia.numeroDePersonasVivas();
    }

    System.out.println("Cantidad de personas final " + cantidadDePersonas);

    for (Familia f: rover.getFamiliasLanzadas()
         ) {
      f.mostrarFamiliaLanzada();
    }

    //Implementación árbol

    List<LadoArbol> ladosArbol = Arrays.asList(new LadoArbol(1, 2), new LadoArbol(2, 5),
            new LadoArbol(5, 18), new LadoArbol(2, 6), new LadoArbol(6, 11),
            new LadoArbol(2, 7), new LadoArbol(7, 17), new LadoArbol(1, 3),
            new LadoArbol(3, 8), new LadoArbol(8, 12), new LadoArbol(8, 13),
            new LadoArbol(1, 4), new LadoArbol(4, 9), new LadoArbol(9, 16),
            new LadoArbol(4, 10), new LadoArbol(10, 14));

    Arbol arbol = new Arbol(ladosArbol);

    Arbol.mostrarArbol(arbol);

    float[] promedios = new float[7];

    float acumuladoFactores = 0;
    boolean randomArbol = rand.nextBoolean();
    for (int k = 0; k < 100; k++) {
      nodoActual = 1;
      float contadorMuertos = 0.0F;

      while(nodoActual != 18){
        nodoAViajar = arbol.adjList.get(nodoActual).get(0);
        for (Familia f: rover.getCabinas()
             ) {
          for (Persona p : f.getFamily()
               ) {
            if((p.getEdad() % nodoActual == 0) && (nodoActual != 1)){
              randomArbol = rand.nextBoolean();
              if(randomArbol){
                contadorMuertos++;
              }
            }
          }
        }
        //System.out.println("Contador muertos. " + contadorMuertos);
        nodoActual = nodoAViajar;
        double indice = 0.0;
        if(contadorMuertos!=0){
          indice = 18.0/contadorMuertos;
        }

        //System.out.println("Indice de muertos: " + indice);
        acumuladoFactores+=indice;
      }
    }
    System.out.println("Indice de ganancia promedio para esta ruta: "+(acumuladoFactores)/100);
    promedios[0] = (acumuladoFactores)/100;
    System.out.println(promedios[0]);

    System.out.println("Ruta 2");

    for (int k = 0; k < 1; k++) {
      nodoActual = 1;

      nodoAViajar = arbol.adjList.get(nodoActual).get(0);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);

      nodoActual = nodoAViajar;

      nodoAViajar = arbol.adjList.get(nodoActual).get(1);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);

      nodoActual = nodoAViajar;

      nodoAViajar = arbol.adjList.get(nodoActual).get(0);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);
    }

    System.out.println("Ruta 3");

    for (int k = 0; k < 1; k++) {
      nodoActual = 1;

      nodoAViajar = arbol.adjList.get(nodoActual).get(0);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);

      nodoActual = nodoAViajar;

      nodoAViajar = arbol.adjList.get(nodoActual).get(2);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);

      nodoActual = nodoAViajar;

      nodoAViajar = arbol.adjList.get(nodoActual).get(0);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);
    }

    System.out.println("Ruta 4");

    for (int k = 0; k < 1; k++) {
      nodoActual = 1;

      nodoAViajar = arbol.adjList.get(nodoActual).get(1);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);

      nodoActual = nodoAViajar;

      nodoAViajar = arbol.adjList.get(nodoActual).get(0);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);

      nodoActual = nodoAViajar;

      nodoAViajar = arbol.adjList.get(nodoActual).get(0);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);
    }

    System.out.println("Ruta 4");

    for (int k = 0; k < 1; k++) {
      nodoActual = 1;

      nodoAViajar = arbol.adjList.get(nodoActual).get(1);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);

      nodoActual = nodoAViajar;

      nodoAViajar = arbol.adjList.get(nodoActual).get(0);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);

      nodoActual = nodoAViajar;

      nodoAViajar = arbol.adjList.get(nodoActual).get(1);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);
    }

    System.out.println("Ruta 5");

    for (int k = 0; k < 1; k++) {
      nodoActual = 1;

      nodoAViajar = arbol.adjList.get(nodoActual).get(1);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);

      nodoActual = nodoAViajar;

      nodoAViajar = arbol.adjList.get(nodoActual).get(0);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);

      nodoActual = nodoAViajar;

      nodoAViajar = arbol.adjList.get(nodoActual).get(1);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);
    }

    System.out.println("Ruta 6");

    for (int k = 0; k < 1; k++) {
      nodoActual = 1;

      nodoAViajar = arbol.adjList.get(nodoActual).get(2);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);

      nodoActual = nodoAViajar;

      nodoAViajar = arbol.adjList.get(nodoActual).get(0);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);

      nodoActual = nodoAViajar;

      nodoAViajar = arbol.adjList.get(nodoActual).get(0);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);
    }

    System.out.println("Ruta 7");

    for (int k = 0; k < 1; k++) {
      nodoActual = 1;

      nodoAViajar = arbol.adjList.get(nodoActual).get(2);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);

      nodoActual = nodoAViajar;

      nodoAViajar = arbol.adjList.get(nodoActual).get(1);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);

      nodoActual = nodoAViajar;

      nodoAViajar = arbol.adjList.get(nodoActual).get(0);
      System.out.println("El rover ha viajado al nodo " + nodoAViajar);
    }
  }
}