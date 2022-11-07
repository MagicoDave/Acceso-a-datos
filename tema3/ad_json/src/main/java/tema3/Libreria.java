package tema3;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.json.JsonArray;
import javax.json.JsonObject;

public class Libreria {

    static class Coordinadas{
        
        public double lon;
        public double lat;

        public Coordinadas (double lon, double lat){
            this.lon = lon;
            this.lat = lat;
        }
    }

    //Exercicio 1
    public static JsonObject verPrediccionLocalidade(String localidade) {      
        String ruta = "http://api.openweathermap.org/data/2.5/weather?q=" + localidade + "&lang=es&APPID=a975f935caf274ab016f4308ffa23453&units=metric";
        System.out.println(ruta);
        return Jsonn.leeJSON(ruta).asJsonObject();
    }

    //Exercicio 2
    public static JsonObject verPrediccionCoordinadas(double lon, double lat) {
        String ruta = "http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon="+ lon +"&APPID=8f8dccaf02657071004202f05c1fdce0&units=metric";
        System.out.println(ruta);
        return Jsonn.leeJSON(ruta).asJsonObject();
    }

    //Exercicio 3
    public static JsonObject verPrediccionNLocalidadesCercanas(int n, double lon, double lat) {
        String ruta = "http://api.openweathermap.org/data/2.5/find?lat=" + lat + "&lon=" + lon + "&cnt=" + n + "&APPID=a975f935caf274ab016f4308ffa23453&units=metric";
        System.out.println(ruta);
        return Jsonn.leeJSON(ruta).asJsonObject();
    }

    //Exercicio 4
    public static double getId(JsonObject obj){
        return obj.getJsonNumber("id").doubleValue();
    }

    //Exercicio 5
    public static String getNome(JsonObject obj){
        return obj.getString("name");
    }

    //Exercicio 6
    public static Coordinadas getCoordinadas(JsonObject obj){
        return new Coordinadas(obj.getJsonObject("coord").getJsonNumber("lon").doubleValue(), 
        obj.getJsonObject("coord").getJsonNumber("lat").doubleValue()
        );

    }

    //Exercicio 7
    public static String getPrediccion(JsonObject obj){

        JsonArray aux = obj.getJsonArray("weather");
        String pronostico = "";

        for (int i = 0; i < aux.size(); i++) {
            pronostico = aux.getJsonObject(i).getString("description");
        }

        return "Data: " + unixTimeToString(obj.getJsonNumber("dt").longValue()) + 
        "\nTemperatura: " +  obj.getJsonObject("main").getJsonNumber("temp") + "º" +
        "\nHumidade: " + obj.getJsonObject("main").getJsonNumber("humidity") + "%" + 
        "\nProbabilidade de ceo con nubes: " + obj.getJsonObject("clouds").getJsonNumber("all").doubleValue() + "%" +
        "\nVelocidade do vento: " + obj.getJsonObject("wind").getJsonNumber("speed").doubleValue() + "m/s" +
        "\nPrognostico do tempo: " + pronostico;
    }

    public static String unixTimeToString(long unixTime){
        final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Instant.ofEpochSecond(unixTime).atZone(ZoneId.of("GMT+1")).format(formatter);
    }

    //Exercicio 8
    public static String getPredicciones(JsonObject obj){
        return null;
    }
}
