
package tema3;

import javax.json.JsonObject;

import tema3.Libreria.Coordinadas;

//import javax.json.JsonObject;

public class Application {
  public static void main(String[] args) {

    // JsonObject prueba = Libreria.verPrediccionLocalidade("vigo");
    // JsonObject prueba = Libreria.verPrediccionNLocalidadesCercanas(4, -8.7226, 42.2328);
    // JsonObject prueba = Libreria.verPrediccionCoordinadas(41.9561, -7.974);

    JsonObject prueba = Jsonn.leeJSON("https://app.ticketmaster.com/discovery/v2/events/Z698xZG2ZaGt4.json?apikey=AMXR5Rf8zlr7oGucsebGKvDCLOQmGUGE").asJsonObject();

    // System.out.println(Libreria.getNome(prueba));
    // System.out.println(Libreria.getId(prueba));
    // Coordinadas coordinadasCidade = Libreria.getCoordinadas(prueba);
    // System.out.println("Coordinadas de " + Libreria.getNome(prueba) + 
    //   ":\n\tLongitude: " + coordinadasCidade.lon + 
    // "\n\tLatitude: " + coordinadasCidade.lat);
    // System.out.println(Libreria.getPrediccion(prueba));
    // System.out.println(Libreria.getPrediccionesCercanasA("vigo", 4));
    
    // System.out.println(Libreria.getTriviaInformatica(20));
    
    System.out.println(Libreria.getTipoEventosPais("music", "ES", true, true, true));
    //System.out.println(Libreria.getInfoEventoLocalizacion(prueba));
    //System.out.println(Libreria.getInfoEventoDetallada(prueba));

  }   
}
