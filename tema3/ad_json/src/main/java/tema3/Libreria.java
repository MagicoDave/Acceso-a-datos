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

        return 
            "Data: " + unixTimeToString(obj.getJsonNumber("dt").longValue()) + 
            "\nTemperatura: " +  obj.getJsonObject("main").getJsonNumber("temp") + "º" +
            "\nHumidade: " + obj.getJsonObject("main").getJsonNumber("humidity") + "%" + 
            "\nProbabilidade de ceo con nubes: " + obj.getJsonObject("clouds").getJsonNumber("all").doubleValue() + "%" +
            "\nVelocidade do vento: " + obj.getJsonObject("wind").getJsonNumber("speed").doubleValue() + "m/s" +
            "\nPrognostico do tempo: " + pronostico
        ;
    }

    public static String unixTimeToString(long unixTime){
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Instant.ofEpochSecond(unixTime).atZone(ZoneId.of("GMT+1")).format(formatter);
    }

    //Exercicio 8
    public static String getPrediccionesCercanasA(String localidade, int numero){

        //Sacar as coordenadas da localidade especificada
        JsonObject joLocalidade = verPrediccionLocalidade(localidade);
        double lon = joLocalidade.getJsonObject("coord").getJsonNumber("lon").doubleValue();
        double lat = joLocalidade.getJsonObject("coord").getJsonNumber("lat").doubleValue();

        //Crear un JsonObject con todas as localizacións a partir dos datos anteriores
        JsonObject aux = verPrediccionNLocalidadesCercanas(numero, lon, lat);

        //Por cada localidade, sacar os datos
        String pronosticos = "";
        JsonArray array = aux.getJsonArray("list");
        for (int i = 0; i < array.size(); i++) {
            pronosticos += "\n" + array.getJsonObject(i).getString("name") + "\n";
            pronosticos += getPrediccion(array.getJsonObject(i));
        }

        return pronosticos;
    }

    //Exercicio 9
    public static String getTriviaInformatica(int cantidad){
        String ruta = "https://opentdb.com/api.php?amount=" + cantidad + "&category=18&difficulty=hard";
        JsonObject aux = Jsonn.leeJSON(ruta).asJsonObject();
        JsonArray array = aux.getJsonArray("results");
        String resultados = "";
        for (int i = 0; i < array.size(); i++) {
            resultados += "\n\nPregunta numero " + i;
            resultados += "\n" + array.getJsonObject(i).getString("question");
            resultados += "\n* " + array.getJsonObject(i).getString("correct_answer");
            JsonArray subarray = array.getJsonObject(i).getJsonArray("incorrect_answers");
            for (int j = 0; j < subarray.size(); j++) {
                resultados += "\n" + subarray.getString(j);
            }
        }
        return resultados;
    }

    //Exercicio 10
    public static String getTipoEventosPais (String classificationName, String countryCode){
        String ruta = "https://app.ticketmaster.com/discovery/v2/events.json?classificationName="+ classificationName +"&countryCode=" + countryCode + "&apikey=AMXR5Rf8zlr7oGucsebGKvDCLOQmGUGE";
        System.err.println(ruta);
        String eventos = "";

        JsonObject ob = Jsonn.leeJSON(ruta).asJsonObject();
        JsonArray array = ob.getJsonObject("_embedded").getJsonArray("events");

        for (int i = 0; i < array.size(); i++) {
            eventos += "\n" + i + ". " + array.getJsonObject(i).getString("name");
        }

        return eventos;
    }

    //Exercicio 11
    public static String getInfoEventoLocalizacion (JsonObject obj){
        String info = "";
        JsonArray venues = obj.getJsonObject("_embedded").getJsonArray("venues");

        for (int i = 0; i < venues.size(); i++) {
            info += "\n\nNome do lugar: " + venues.getJsonObject(i).getString("name");
            info += "\nCidade: " + venues.getJsonObject(i).getJsonObject("city").getString("name");
            info += "\nPaís: " + venues.getJsonObject(i).getJsonObject("country").getString("name");
            info += "\nRúa: " + venues.getJsonObject(i).getJsonObject("adress").getString("name");
        }
        return info;
    }

    public static String getInfoEventoDetallada (JsonObject obj){
        String info = "";
        return info;
    }
}
