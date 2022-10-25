import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Exercicio_9 {
    
    public static ArrayList<Integer> codigos = new ArrayList<Integer>();
    public static ArrayList<String> nomes = new ArrayList<String>();
    public static ArrayList<Double> alturas = new ArrayList<Double>();

    public static String pathSalida = System.getProperty("user.home") + "/Documents/alumnos.dat";
    public static File ficheiro = new File(pathSalida);

    static void altaAlumno(int codigo, String nome, double altura){

        try (DataOutputStream dout = new DataOutputStream (new FileOutputStream(ficheiro, true))) {
            dout.writeInt(codigo);
            dout.writeUTF(nome);
            dout.writeDouble(altura);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void consultarAlumno(int codigo){

        try (DataInputStream din = new DataInputStream(new FileInputStream(ficheiro))) {
            while (true) {
                int auxInt = din.readInt();
                String auxString = din.readUTF();
                double auxDouble = din.readDouble();
                if (auxInt == codigo){
                    System.out.printf("Código: %d\n\tNome: %s\n\tAltura: %.2fm\n\n", auxInt, auxString, auxDouble);
                    break;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void modificarAlumno(int codigoOrixinal, int codigoNovo, String nomeNovo, double alturaNova){

        try (DataInputStream din = new DataInputStream(new FileInputStream(ficheiro))) {

            while (true){
                int auxInt = din.readInt();
                String auxString = din.readUTF();
                double auxDouble = din.readDouble();
                if (auxInt != codigoOrixinal){
                    codigos.add(auxInt);
                    nomes.add(auxString);
                    alturas.add(auxDouble);
                }
            }   

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (DataOutputStream dout = new DataOutputStream (new FileOutputStream(ficheiro, false))) {
            
            for (int i = 0; i < codigos.size(); i++) {
                dout.writeInt(codigos.get(i));
                dout.writeUTF(nomes.get(i));
                dout.writeDouble(alturas.get(i));
            }

            dout.writeInt(codigoNovo);
                dout.writeUTF(nomeNovo);
                dout.writeDouble(alturaNova);
        } catch (Exception e) {
            e.printStackTrace();
        }

       // altaAlumno(codigoNovo, nomeNovo, alturaNova);
    }

    static void borrarAlumno(int codigo){

        try (DataInputStream din = new DataInputStream(new FileInputStream(ficheiro))) {

            while (true){
                int auxInt = din.readInt();
                String auxString = din.readUTF();
                double auxDouble = din.readDouble();
                if (auxInt != codigo){
                    codigos.add(auxInt);
                    nomes.add(auxString);
                    alturas.add(auxDouble);
                }
            }   

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (DataOutputStream dout = new DataOutputStream (new FileOutputStream(ficheiro, false))) {
            
            for (int i = 0; i < codigos.size(); i++) {
                dout.writeInt(codigos.get(i));
                dout.writeUTF(nomes.get(i));
                dout.writeDouble(alturas.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //altaAlumno(1, "Dave", 1.79);
        // altaAlumno(2, "Pepe", 1.60);
        // altaAlumno(3, "Marcos", 1.85);
        //modificarAlumno(1, 1, "Dave el nuevo", 1.80);
        //borrarAlumno(1);
        //consultarAlumno(1);
        
        
    }
}
