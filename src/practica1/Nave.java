package practica1;

import java.util.Arrays;

public class Nave {
  private Familia[][] nave = new Familia[5][5];

  public Nave(Familia familia) {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j <5; j++) {
        nave[i][j] = familia;
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
