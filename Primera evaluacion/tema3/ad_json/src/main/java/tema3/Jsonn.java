package tema3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.net.ssl.HttpsURLConnection;

public class Jsonn {
    
    public static JsonValue leeJSON(String ruta) {
        try {
            if (ruta.toLowerCase().startsWith("http://")) {
                return leerHttp(ruta);
            } else if (ruta.toLowerCase().startsWith("https://")) {
                return leerHttps(ruta);
            } else {
                return leerFichero(ruta);
            }
        } catch (IOException e) {
            System.out.println("Erro procesando documento Json " +
                    e.getLocalizedMessage());
            return null;
        }
    }

    public static JsonValue leerFichero(String ruta) throws FileNotFoundException {
        try (JsonReader reader = Json.createReader(new FileReader(ruta))) {
            return reader.read();
        }
    }

    public static JsonValue leerHttp(String direccion) throws IOException {
        URL url = new URL(direccion);
        try (InputStream is = url.openStream();
                JsonReader reader = Json.createReader(is)) {
            return reader.read();
        }
    }

    public static JsonValue leerHttps(String direccion) throws IOException {
        URL url = new URL(direccion);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        try (InputStream is = conn.getInputStream();
                JsonReader reader = Json.createReader(is)) {
            return reader.read();
        } finally {
            conn.disconnect();
        }
    }
}
