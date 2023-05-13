package practica1;

public class Persona {
  private String name;
  private String gender;
  private int edad;

  public Persona(String name, String gender, int edad) {
    this.name = name;
    this.gender = gender;
    this.edad = edad;
  }

  public Persona() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  @Override
  public String toString() {
    return "Persona{" +
            "name='" + name + '\'' +
            ", gender='" + gender + '\'' +
            ", edad=" + edad +
            '}';
  }
}
