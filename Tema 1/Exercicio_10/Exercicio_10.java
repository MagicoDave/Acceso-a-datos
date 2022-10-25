package Exercicio_10;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Exercicio_10 {

    public static String pathSalida = System.getProperty("user.home") + "/Documents/obxectos.dat";
    public static File ficheiro = new File(pathSalida);

    public static void altaPersoa(int codigo, String nome, double altura) throws IOException {

        FileOutputStream fos = null;
        ObjectOutputStream out = null;

        try {

            fos = new FileOutputStream(ficheiro, true);
            if (ficheiro.length() == 0){
                out = new ObjectOutputStream(fos);
            } else {
                out = new AppendingObjectOutputStream(fos);
            }

            Persoa persoa = new Persoa(codigo, nome, altura);
            out.writeObject(persoa);

        } finally {
            if (out != null)
                out.close();
            if (fos != null)
                fos.close();
        }

    }

    public static void altaDepart(int codigo, String nome, Persoa[] empleados) throws IOException{

        FileOutputStream fos = null;
        ObjectOutputStream out = null;

        try {
            fos = new FileOutputStream(ficheiro, true);
            if (ficheiro.length() == 0){
                out = new ObjectOutputStream(fos);
            } else {
                out = new AppendingObjectOutputStream(fos);
            }

            Depart depart = new Depart(codigo, nome, empleados);
            out.writeObject(depart);

        } finally {
            if (out != null)
                out.close();
            if (fos != null)
                fos.close();
        }
    }

    public static void borrarPersoa(int codigo) throws IOException, ClassNotFoundException{
        ArrayList<Object> lista = new ArrayList<Object>();
        Object obj;

        try (FileInputStream fin = new FileInputStream(ficheiro);
                ObjectInputStream in = new ObjectInputStream(fin)) {
            while (true) {
                obj = in.readObject();
                if (obj.getClass() != Persoa.class || ((Persoa) obj).getCodigo() != codigo) {
                    lista.add(obj);
                }
            }
        } catch (EOFException e) {
            //e.printStackTrace();
        }

        try (FileOutputStream fos = new FileOutputStream(ficheiro, false);
                ObjectOutputStream out = new ObjectOutputStream(fos)) {
            for (Object o : lista) {
                out.writeObject(o);
            }
        } catch (EOFException e) {
            //e.printStackTrace();
        }
    }

    public static void borrarDepart(int codigo) throws IOException, ClassNotFoundException{
        ArrayList<Object> lista = new ArrayList<Object>();
        Object obj;

        try (FileInputStream fin = new FileInputStream(ficheiro);
                ObjectInputStream in = new ObjectInputStream(fin)) {
            while (true) {
                obj = in.readObject();
                if (obj.getClass() != Depart.class || ((Depart) obj).getCodigo() != codigo) {
                    lista.add(obj);
                }
            }
        } catch (EOFException e) {
            //e.printStackTrace();
        }

        try (FileOutputStream fos = new FileOutputStream(ficheiro, false);
                ObjectOutputStream out = new ObjectOutputStream(fos)) {
            for (Object o : lista) {
                out.writeObject(o);
            }
        } catch (EOFException e) {
            //e.printStackTrace();
        }
    }

    public static void mostrarPersoa(int codigo) throws IOException, ClassNotFoundException{
        try (FileInputStream fin = new FileInputStream(ficheiro);
                ObjectInputStream in = new ObjectInputStream(fin)) {
            Object obj;
            while (true) {
                obj = in.readObject();
                if (obj.getClass() == Persoa.class) {
                    if (((Persoa) obj).getCodigo() == codigo) {
                        System.out.printf("Nome: %s\nCodigo: %d\nAltura: %f",
                                ((Persoa) obj).getNome(), ((Persoa) obj).getCodigo(), ((Persoa) obj).getAltura());
                    }
                }
            }
        } catch (EOFException e) {
            System.out.println("\n***********");
        }
    }

    public static void mostrarDepart(int codigo) throws IOException, ClassNotFoundException{
        try (FileInputStream fin = new FileInputStream(ficheiro);
                ObjectInputStream in = new ObjectInputStream(fin)) {
            Object obj;
            while (true) {
                obj = in.readObject();
                if (obj.getClass() == Depart.class) {
                    if (((Depart) obj).getCodigo() == codigo) {
                        System.out.printf("Nome: %s\nCodigo: %d\nNúmero de empleados: %d",
                                ((Depart) obj).getNome(), ((Depart) obj).getCodigo(),
                                ((Depart) obj).getEmpleados().length);
                    }
                }
            }
        } catch (EOFException e) {
            System.out.println("\n***********");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        // altaPersoa(0, "Pedro", 1.6);
        // altaPersoa(1, "Marta", 1.7);
        // altaPersoa(2, "Mario", 1.8);
        // altaPersoa(3, "Sheyla", 1.9);

        // Persoa[] empleados = { new Persoa(4, "Marcos", 2), new Persoa(5, "Francisco", 2.1) };

        // altaDepart(0, "Recursos humanos", empleados);

        borrarPersoa(2);
        borrarDepart(0);

        mostrarPersoa(0);
        mostrarPersoa(1);
        mostrarPersoa(2);
        mostrarPersoa(3);

        mostrarDepart(0);
    }
}

class AppendingObjectOutputStream extends ObjectOutputStream {
    public AppendingObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();// do not write a header
    }
}
