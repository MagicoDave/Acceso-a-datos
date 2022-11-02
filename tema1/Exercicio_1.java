import java.io.File;

public class Exercicio_1 {
    
    public static void info(File directorio) {
        
        if (directorio.isDirectory()){
            for (File ficheiro:directorio.listFiles()){
                System.out.printf("%s\n", ficheiro.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        
        String documents = System.getProperty("user.home") + "/Documents/";
        File aux = new File(documents);

        info(aux);
    }
}
