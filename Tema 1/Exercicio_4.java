import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Exercicio_4 {
    
    public static void caracterMaisUsado (File ficheiro){
        int caracterLeido = 0;
        Caracter caracterMaisUsado = new Caracter();
        ArrayList<Character> aux = new ArrayList<Character>();
        ArrayList<Caracter> listaCaracteres = new ArrayList<Caracter>();


        try (FileReader fr = new FileReader(ficheiro)) {
            while ((caracterLeido = fr.read()) != -1) {
                if (!aux.contains((char) caracterLeido)){
                    aux.add((char) caracterLeido);
                    Caracter c = new Caracter((char) caracterLeido, 1);
                    listaCaracteres.add(c);
                } else {
                    for (Caracter c : listaCaracteres){
                        if (c.letra == (char) caracterLeido){
                            c.num++;
                        }
                    }
                }
            }


        } catch (Exception e) {
            // TODO: handle exception
        }

        for (Caracter c : listaCaracteres){
            if (c.num>caracterMaisUsado.num){
                caracterMaisUsado.letra = c.letra;
                caracterMaisUsado.num = c.num;
            }
        }

        System.out.println("O caracter mais usado é " + caracterMaisUsado.letra + ", total: " + caracterMaisUsado.num);

    }

    private static class Caracter {
        public char letra;
        public int num;

        public Caracter (char letra, int num){
            this.letra = letra;
            this.num = num;
        }

        public Caracter (){
            this.letra = 0;
            this.num = 0;
        }
    }

    public static void main(String[] args) {
        
        File ficheiro = new File("C:/Users/David Casalderrey/Documents/awdad.txt");
        caracterMaisUsado(ficheiro);
    }

    
}
