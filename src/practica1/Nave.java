package practica1;

import java.util.Arrays;

public class Nave {
  private Familia[][] nave = new Familia[5][5];



  public Nave() {

  }

  public void setNave(Familia[][] nave) {
    this.nave = nave;
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

  public void secuestrarMujeresDiagonalPpal(){
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        if (i == j){
          for (int k = 0; k < 4; k++){
            if (nave[i][j].getFamily()[k].getGender().equalsIgnoreCase("femenino")){
              nave[i][j].getFamily()[k] = null;
            }
          }
        }
      }
    }
  }
  public void secuestrarHombresDiagonalSecundaria(){
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        if (i + j == 4){
          for (int k = 0; k < 4; k++){
            if (nave[i][j].getFamily()[k].getGender().equalsIgnoreCase("masculino")){
              nave[i][j].getFamily()[k] = null;
            }
          }
        }
      }
    }
  }

  public void secuestrasMenoresDiagonales(){
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        if ((i + j == 4) || (i==j)){
          for (int k = 0; k < 4; k++){
            if (nave[i][j].getFamily()[k].getEdad() < 18){
              nave[i][j].getFamily()[k] = null;
            }
          }
        }
      }
    }
  }

}
