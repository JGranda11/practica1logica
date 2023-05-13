package practica1;

import java.util.Arrays;

public class Nave {
  private Familia[][] nave = new Familia[5][5];

  public void setNave(Familia[][] nave) {
    this.nave = nave;
  }

  public Nave() {

  }

  public Familia[][] getNave() {
    return nave;
  }

  public void ingresarFamilia(int i, int j, Familia familia) {
    this.nave[i][j] = familia;
  }


  public void mostrarFamilias() {
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        nave[i][j].mostrarFamilia();
      }
    }
  }
}
