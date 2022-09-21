import java.io.File;

public class Exercicio_1 {
    
    public static void info(File directorio) {
        
        if (directorio.isDirectory()){
            for (File ficheiro:directorio.listFiles()){
                System.out.printf("%s\n", ficheiro.getAbsolutePath());
            }
        }
    }
}
