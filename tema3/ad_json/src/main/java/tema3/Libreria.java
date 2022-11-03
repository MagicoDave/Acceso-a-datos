package tema3;

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

    public static JsonObject verPrediccionLocalidade(String localidade) {

        String ruta = "http://api.openweathermap.org/data/2.5/weather?q=" + localidade + "&lang=es&APPID=a975f935caf274ab016f4308ffa23453&units=metric";
        return Jsonn.leeJSON(ruta).asJsonObject();
    }

    public static JsonObject verPrediccionCoordinadas(double lon, double lat) {

        return null;
    }

    public static JsonObject verPrediccionNLocalidadesCercanas(int n, double lon, double lat) {

        return null;
    }

    public static String getNome(JsonObject obj){
        return obj.getString("name");
    }

    public static Coordinadas getCoordinadas(JsonObject obj){
        return new Coordinadas(obj.getJsonObject("coord").getJsonNumber("lon").doubleValue(), 
        obj.getJsonObject("coord").getJsonNumber("lon").doubleValue()
        );

    }
}
