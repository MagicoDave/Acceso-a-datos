import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Exercicio_9 {
    
    public static ArrayList<Integer> codigos = new ArrayList<Integer>();
    public static ArrayList<String> nombres = new ArrayList<String>();
    public static ArrayList<Double> alturas = new ArrayList<Double>();

    public static String pathSalida = System.getProperty("user.home") + "/Documents/alumnos.dat";
    public static File ficheiro = new File(pathSalida);

    static void altaAlumno(int codigo, String nombre, double altura){

        try (DataOutputStream dout = new DataOutputStream (new FileOutputStream(ficheiro, true))) {
            dout.writeInt(codigo);
            dout.writeUTF(nombre);
            dout.writeDouble(altura);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void consultarAlumno(int codigo){

        try (DataInputStream din = new DataInputStream(new FileInputStream(ficheiro))) {
            System.out.printf("Código: %d\n\tNome: %s\n\tAltura: %.2fm\n\n", din.readInt(), din.readUTF(), din.readDouble());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    static void modificarAlumno(int codigo){

    }

    static void borrarAlumno(int codigo){

    }

    public static void main(String[] args) {
        altaAlumno(1, "Dave", 1.79);
        consultarAlumno(1);
    }
}
