package practica1;

public class Main {
  public static void main(String[] args) {
    Persona p1 = new Persona("Juan", "Masculino",23);
    Persona p2 = new Persona("Juan Jose", "Masculino",23);
    Persona p3 = new Persona("Maria", "Femenino",23);
    Persona p4 = new Persona("Juan", "Masculino",23);

    Familia family = new Familia(p1, p2, p3, p4);
    System.out.println(family.toString());

    Nave nave = new Nave(family);

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.println(nave.getNave()[i][j].getFamily().toString());
      }
    }

  }
}
