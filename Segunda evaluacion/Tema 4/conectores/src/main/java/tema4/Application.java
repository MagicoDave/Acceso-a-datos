
package tema4;

public class Application {
  public static void main(String[] args) {
    
    JDBC jdbc = new JDBC();
    //jdbc.altaAlumno("Andrzej", "Sapkowski", 171, 20);
    //jdbc.bajaAlumno(11);
    //jdbc.modificarAlumno(12, "Andrzej", "Sapkowski", 171, 20);
    //jdbc.consultaAlumnosCadena("e");
    //jdbc.aulasPobladas();
    //jdbc.alumnosConAprovado();
    //jdbc.asignaturasSinAlumnos();

    long startTime = System.nanoTime();

    System.out.println(jdbc.patronNombreAlturaAlumno(1, "%hi%", 180));
    System.out.println(jdbc.patronNombreAlturaAlumnoPS(1, "%hi%", 180));

    long endTime = System.nanoTime();
    System.out.println("El programa tardó " + (endTime - startTime) / 1000000 +  "ms en ejecutarse");
    //TODO probar eficiencia
  }
}
