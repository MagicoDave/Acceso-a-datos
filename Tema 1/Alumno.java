import java.text.DecimalFormat;

public class Alumno {
    
    //TODO Puedo reutilizar esta clase para hacer Persona en el ejercicio 10

    private int codigo;
    private String nome;
    private double altura;

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

    public void setAltura (double altura){
        DecimalFormat df = new DecimalFormat("#.##");
        this.altura = Double.valueOf(df.format(altura));
    }

    public double getAltura (){
        return altura;
    }

    public Alumno (int codigo, String nome, double altura){
        setCodigo(codigo);
        setAltura(altura);
        setNome(nome);
    }
}
