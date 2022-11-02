package Exercicio_10;

import java.io.Serializable;

public class Depart implements Serializable{

    private String nome;
    private int codigo;
    private Persoa[] empleados;

    public void setNome (String nome){
        this.nome = nome;
    }

    public String getNome (){
        return nome;
    }

    public void setCodigo (int codigo){
        this.codigo=codigo;
    }

    public int getCodigo (){
        return codigo;
    }
    
    public void setEmpleados (Persoa[] empleados){
        this.empleados = empleados;
    }

    public Persoa[] getEmpleados() {
        return empleados;
    }

    public Depart(int codigo, String nome, Persoa[] empleados){
        setNome(nome);
        setCodigo(codigo);
        setEmpleados(empleados);
    }
}
