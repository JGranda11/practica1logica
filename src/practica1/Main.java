package practica1;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    String nombre, genero;
    List<PersonaMuerta> personasMuertas = new ArrayList<>();
    int edad, eventoAnillo;
    String[] nombresHombres = {"Juan", "Pedro", "Manuel", "Luis", "Carlos", "Jorge", "Miguel", "José", "David", "Francisco", "Alejandro", "Mario", "Rafael", "Daniel", "Sergio", "Fernando", "Gabriel", "Antonio", "Ernesto", "Andrés", "Javier", "Adrián", "Diego", "Pablo", "Alfredo", "Eduardo", "Héctor", "Ignacio", "Gustavo", "Roberto", "Raúl", "Óscar", "Tomás", "César", "Abel", "Benjamín", "Emilio", "Hugo", "Israel", "Jaime", "Josué", "Julio", "Leo", "Marco", "Max", "Nicolás", "Ramiro", "Ricardo", "Sebastián", "Víctor"};
    String[] nombresMujeres = {"María", "Ana", "Sofía", "Luisa", "Carmen", "Lucía", "Marta", "Isabel", "Laura", "Patricia", "Paula", "Adriana", "Valeria", "Fernanda", "Valentina", "Camila", "Mónica", "Daniela", "Gabriela", "Carolina", "Liliana", "Claudia", "Rosa", "Elena", "Silvia", "Verónica", "Lorena", "Esther", "Natalia", "Pilar", "Alicia", "Beatriz", "Sara", "Diana", "Emily", "Gloria", "Aurora", "Julia", "Jimena", "Regina", "Miriam", "Ximena", "Irene", "Olga", "Rosario", "Vanessa", "Cecilia", "Angélica", "Elvira", "Rocío"};
    Familia[] familias = new Familia[25];
    Persona[] personas = new Persona[100];
    Nave nave = new Nave();


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

    int j = 0;
    for (int i = 0; i<25; i++){
        familias[i] = new Familia(personas[j], personas[j+1], personas[j+2], personas[j+3]);
        j=j+4;
    }

    j = 0;
    for (int i = 0; i < 5; i++){
      for (int k = 0; k < 5; k++){
        nave.ingresarFamilia(i, k, familias[j]);
        j++;
      }
    }

    eventoAnillo = rand.nextInt(101);

    System.out.println("\n-----Resumen inicial de la nave-----\n");

    nave.mostrarNave();

    System.out.println("********************************************************************************");
    System.out.println("               Salida de la nave del planeta Gama(planeta origen) ");
    System.out.println("********************************************************************************\n");

    System.out.println("En el anillo de Gama, están asociados: Evento 1, Evento 4, Evento 7\n");

    if(eventoAnillo <= 20){
      nave.colisionarConAsteroide("Saliendo de Gamma hacia Sigma");
    }else if(eventoAnillo > 20 && eventoAnillo <= 50){
      nave.tormentaSolar();
    }else if(eventoAnillo >50 && eventoAnillo <= 80){
      nave.secuestrasMenoresDiagonales();
      System.out.println("Todos los menores de edad de las 2 diagonales fueron secuestrados por esclavistas");
    }else{
      System.out.println("La nave salió de Gamma sana y salva");
    }


    eventoAnillo = rand.nextInt(101);
    System.out.println();
    System.out.println("********************************************************************************");
    System.out.println("               Entrada de la nave al planeta Sigma(planeta destino) ");
    System.out.println("********************************************************************************\n");
    System.out.println("En el anillo de Sigma, están asociados: Evento 1, Evento 3, Evento 5\n");
    if(eventoAnillo <= 15){
      nave.colisionarConAsteroide("Entrando a Sigma");
    }else if(eventoAnillo > 15 && eventoAnillo <= 45){
      nave.fugaDeAire();
    }else if(eventoAnillo > 45 && eventoAnillo <= 85){
      nave.secuestrarMujeresDiagonalPpal();
      System.out.println("Todas las mujeres de la diagonal principal han sido secuestradas por piratas");
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

  }
}


