package practica1;

import java.util.Arrays;

public class Familia {
  private Persona [] family= new Persona[4];

  public Familia(Persona persona1,Persona persona2,Persona persona3,Persona persona4 ) {
    family[0]=persona1;
    family[1]=persona2;
    family[2]=persona3;
    family[3]=persona4;
  }

  public Persona[] getFamily() {
    return family;
  }

  public void setFamily(Persona[] family) {
    this.family = family;
  }

  public void mostrarFamilia() {
    System.out.println("Familia ");
    for (int i = 0; i < 4; i++)
      System.out.println(family[i].toString());
  }
}
