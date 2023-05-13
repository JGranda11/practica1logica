package practica1;

public class Main {
  public static void main(String[] args) {
    Persona p1 = new Persona("Juan", "Masculino",23);
    Persona p2 = new Persona("Juan Jose", "Masculino",23);
    Persona p3 = new Persona("Maria", "Femenino",23);
    Persona p4 = new Persona("Juan", "Masculino",23);

    Persona[] arregloPersonas = new Persona[4];
    arregloPersonas[0]=p1;
    arregloPersonas[1]=p2;
    arregloPersonas[2]=p3;
    arregloPersonas[3]=p4;


    Familia objfamilia1 = new Familia(arregloPersonas);
    Familia objfamilia2 = new Familia(arregloPersonas);
    Familia objfamilia3 = new Familia(arregloPersonas);
    Familia objfamilia4 = new Familia(arregloPersonas);

    Familia[] arregloFamilia = new Familia[4];
    arregloFamilia[0] = objfamilia1;
    arregloFamilia[1] = objfamilia2;
    arregloFamilia[2] = objfamilia3;
    arregloFamilia[3] = objfamilia4;




    Nave nave = new Nave(arregloFamilia);


    System.out.println(nave.getNave()[0][0].getFamily()[0].getName());
    System.out.println(nave.getNave()[0][0].getFamily()[2].getName());

    /*for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.println(nave.getNave()[i][j].getFamily());

      }
    }*/

  }
}
