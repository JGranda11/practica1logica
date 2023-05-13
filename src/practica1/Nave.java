package practica1;

import java.util.Arrays;
import java.util.Random;

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


  public void mostrarNave() {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (nave[i][j] == null) {
          System.out.println("Familia en la posición " + i + ", " + j);
          System.out.println("Están muertos todos");
        } else {
          System.out.println("Familia en la posición " + i + ", " + j);
          nave[i][j].mostrarFamilia();
          System.out.println("----------------------------------------\n");
        }

      }
    }
  }

  public void secuestrarMujeresDiagonalPpal() {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (i == j) {
          for (int k = 0; k < 4; k++) {
            if (nave[i][j].getFamily()[k].getGender().equalsIgnoreCase("femenino")) {
              nave[i][j].getFamily()[k] = null;
            }
          }
        }
      }
    }
  }

  public void secuestrarHombresDiagonalSecundaria() {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (i + j == 4) {
          for (int k = 0; k < 4; k++) {
            if (nave[i][j].getFamily()[k].getGender().equalsIgnoreCase("masculino")) {
              nave[i][j].getFamily()[k] = null;
            }
          }
        }
      }
    }
  }

  public void secuestrasMenoresDiagonales() {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if ((i + j == 4) || (i == j)) {
          for (int k = 0; k < 4; k++) {
            if (nave[i][j].getFamily()[k].getEdad() < 18) {
              nave[i][j].getFamily()[k] = null;
            }
          }
        }
      }
    }
  }

  public void tormentaSolar() {
    Random rand = new Random();

    boolean bandera = rand.nextBoolean();
    if (bandera == false) {
      tormentaSolarFila();
    } else {
      tormentaSolarColumna();
    }
  }

  public void tormentaSolarFila() {
    Random rand = new Random();

    boolean fila = rand.nextBoolean();
    if (fila == false) {
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (i == 0) {
            nave[i][j] = null;
          }
        }
      }
    } else {
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (i == 4) {
            nave[i][j] = null;
          }
        }
      }
    }
  }

  public void tormentaSolarColumna() {
    Random rand = new Random();

    boolean columna = rand.nextBoolean();
    if (columna == false) {
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (j == 0) {
            nave[i][j] = null;
          }
        }
      }
    } else {
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (j == 4) {
            nave[i][j] = null;
          }
        }
      }
    }
  }

  public int[] vectorEdades() {
    int[] edades = new int[10];
    int edadActual;
    for (int i = 0; i < 10; i++) {
      edades[i] = 0;
    }
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        for (int k = 0; k < 4; k++) {
          edadActual = nave[i][j].getFamily()[k].getEdad();
          for (int l = 0; l < 10; l++) {
            if (edadActual > edades[l]) {
              for (int m = edades.length - 1; m > l; m--) {
                edades[m] = edades[m - 1];
              }
              edades[l] = edadActual;
              break;
            }
          }
        }
      }
    }

    return edades;
  }

  public void colisionarConAsteroide() {
    Random rand = new Random();

    int cuadrante = rand.nextInt(4);
    if (cuadrante == 0) {
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (i < j) {
            nave[i][j] = null;
          }
        }
      }
    } else if (cuadrante == 1) {
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (i > j) {
            nave[i][j] = null;
          }
        }
      }
    } else if (cuadrante == 2) {
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if ((i + j) < 4) {
            nave[i][j] = null;
          }
        }
      }
    } else if (cuadrante == 3) {
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if ((i + j) > 4) {
            nave[i][j] = null;
          }
        }
      }
    }
  }
}
