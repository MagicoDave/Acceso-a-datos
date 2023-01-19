
package tema4;

public class Application {
  public static void main(String[] args) {
    
    JDBC jdbc = new JDBC();
    //jdbc.altaAlumno("Andrzej", "Sapkowski", 171, 20);
    //jdbc.bajaAlumno(11);
    //jdbc.modificarAlumno(12, "Andrzej", "Sapkowski", 171, 20);
    jdbc.consultaAlumnosCadena("e");
    jdbc.aulasPobladas();

  }
}
