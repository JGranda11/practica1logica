package practica1;

import java.util.Arrays;

public class Familia {
  private Persona [] family;

  public Familia (Persona[] arreglo){
    family = new Persona[4];
    family = arreglo;
  }

  public void agregarPersonas(Persona persona){
    for (int i = 0; i < 4; i++) {
      family[i] = persona;
    }
  }
  public Persona[] getFamily() {
    return family;
  }

  public void setFamily(Persona[] family) {
    this.family = family;
  }

  @Override
  public String toString() {
    return "Familia{" +
            "family=" + Arrays.toString(family) +
            '}';
  }
}
