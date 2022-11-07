
package tema3;

import javax.json.JsonObject;

import tema3.Libreria.Coordinadas;

//import javax.json.JsonObject;

public class Application {
  public static void main(String[] args) {

    JsonObject prueba = Libreria.verPrediccionLocalidade("vigo");
    //JsonObject prueba = Libreria.verPrediccionNLocalidadesCercanas(4, -8, 42);
    //JsonObject prueba = Libreria.verPrediccionCoordinadas(41.9561, -7.974);

    System.out.println(Libreria.getNome(prueba));
    System.out.println(Libreria.getId(prueba));

    Coordinadas coordinadasCidade = Libreria.getCoordinadas(prueba);
    System.out.println("Coordinadas de " + Libreria.getNome(prueba) + 
      ":\n\tLongitude: " + coordinadasCidade.lon + 
    "\n\tLatitude: " + coordinadasCidade.lat);
    
    System.out.println(Libreria.getPrediccion(prueba));

  }
}
