package Exercicio_10;
import java.io.Serializable;

public class Persoa implements Serializable{
    
    //TODO Puedo reutilizar esta clase para hacer Persona en el ejercicio 10

    private int codigo;
    private String nome;
    private double salario;

    public void setCodigo (int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }

    public void setNome (String nome){
        this.nome = nome;
    }

    public String getNome (){
        return nome;
    }

    public void setAltura (double salario){
        this.salario = salario;
    }

    public double getAltura (){
        return salario;
    }

    public Persoa (int codigo, String nome, double altura){
        setCodigo(codigo);
        setAltura(altura);
        setNome(nome);
    }
}
