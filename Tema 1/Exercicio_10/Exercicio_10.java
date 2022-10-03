package Exercicio_10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Exercicio_10 {

    public static String pathSalida = System.getProperty("user.home") + "/Documents/obxectos.dat";
    public static File ficheiro = new File(pathSalida);
    
    public static void altaPersoa (int codigo, String nome, double altura){
        try (FileOutputStream fos = new FileOutputStream(ficheiro, true);
        ObjectOutputStream out = new ObjectOutputStream(fos)) {
            Persoa persoa = new Persoa(codigo, nome, altura);
            out.writeObject(persoa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void altaDepart (int codigo, String nome, Persoa[] empleados){
        try (FileOutputStream fos = new FileOutputStream(ficheiro, true);
        ObjectOutputStream out = new ObjectOutputStream(fos)) {
            Depart depart = new Depart(codigo, nome, empleados);
            out.writeObject(depart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void borrarPersoa (int codigo){
        try (FileOutputStream fos = new FileOutputStream(ficheiro, false);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        FileInputStream fin = new FileInputStream(ficheiro);
        ObjectInputStream in = new ObjectInputStream(fin)) {
            ArrayList<Object> lista = new ArrayList<Object>();
            Object obj;
            while (true){
                obj = in.readObject();
                if (obj.getClass() != Persoa.class || ((Persoa) obj).getCodigo() == codigo){
                    lista.add(obj);
                }
            
            for (Object o : lista){
                out.writeObject(o);
            }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void borrarDepart (int codigo){
        try (FileOutputStream fos = new FileOutputStream(ficheiro, false);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        FileInputStream fin = new FileInputStream(ficheiro);
        ObjectInputStream in = new ObjectInputStream(fin)) {
            ArrayList<Object> lista = new ArrayList<Object>();
            Object obj;
            while (true){
                obj = in.readObject();
                if (obj.getClass() != Depart.class || ((Depart) obj).getCodigo() == codigo){
                    lista.add(obj);
                }
            
            for (Object o : lista){
                out.writeObject(o);
            }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarPersoa (int codigo){
        try (FileInputStream fin = new FileInputStream(ficheiro);
        ObjectInputStream in = new ObjectInputStream(fin)) {
            Object obj;
            while (true){
                obj = in.readObject();
                if (obj.getClass() == Persoa.class){
                    if (((Persoa) obj).getCodigo() == codigo){
                        System.out.printf("Nome: %s\nCodigo: %d\nAltura: %f", 
                            ((Persoa) obj).getNome(), ((Persoa) obj).getCodigo(), ((Persoa) obj).getAltura());
                    }
                }
                

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarDepart (int codigo){
        try (FileInputStream fin = new FileInputStream(ficheiro);
        ObjectInputStream in = new ObjectInputStream(fin)) {
            Object obj;
            while (true){
                obj = in.readObject();
                if (obj.getClass() == Depart.class){
                    if (((Depart) obj).getCodigo() == codigo){
                        System.out.printf("Nome: %s\nCodigo: %d\nNúmero de empleados: %d", 
                            ((Depart) obj).getNome(), ((Depart) obj).getCodigo(), ((Depart) obj).getEmpleados().length);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
    }
}
