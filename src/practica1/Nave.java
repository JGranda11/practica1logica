package practica1;

import java.util.Arrays;

public class Nave {
  private Familia[][] nave = new Familia[5][5];

  public Nave(Familia[] familia) {
    int contador = 0;
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        nave[i][j]= familia[contador];
        contador++;
      }
    }
  }

  public Familia[][] getNave() {
    return nave;
  }

  public void setNave(Familia[][] nave) {
    this.nave = nave;
  }

  @Override
  public String toString() {
    return "Nave{" +
            "nave=" + Arrays.toString(nave) +
            '}';
  }
}
