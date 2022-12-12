package tema4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    
    private Connection conexion;

    public void abrirConexion(String bd, String servidor, String usuario,
            String password) {
        try {
            String url = String.format("jdbc:mariadb://%s:3306/%s", servidor, bd);
            // Establecemos la conexión con la BD
            this.conexion = DriverManager.getConnection(url, usuario, password);
            if (this.conexion != null) {
                System.out.println("Conectado a " + bd + " en " + servidor);
            } else {
                System.out.println("No conectado a " + bd + " en " + servidor);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getLocalizedMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("Código error: " + e.getErrorCode());
        }
    }

    public void cerrarConexion() {
        try {
            this.conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getLocalizedMessage());
        }
    }

    //Ejercicio 1
    public void consultaAlumnosCadena (String cadena){
        abrirConexion("add", "localhost", "root", "");

        try (Statement st = this.conexion.createStatement()){
            String query = "select * from alumnos where nombre like '%" + cadena + "%'";
            ResultSet rs = st.executeQuery(query);

            int contador = 0;
            while (rs.next()){
                System.out.println(rs.getInt("codigo") + ". " +  rs.getString("nombre") + " " + rs.getString("apellidos"));
                contador++;
            }
            System.out.println("Tu búsqueda ha devuelto " + contador + " resultado(s)");
        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }

    //Ejercicio 2
    public void altaAlumno(String nombre, String apellidos, int altura, int aula){
        abrirConexion("add", "localhost", "root", "");

        try (Statement st = this.conexion.createStatement()){
            
        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }

    public void altaAsinatura(int cod, String nombre){
        abrirConexion("add", "localhost", "root", "");

        try (Statement st = this.conexion.createStatement()){
            
        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }

    //Ejercicio 3
    public void bajaAlumno(int codigo){
        abrirConexion("add", "localhost", "root", "");

        try (Statement st = this.conexion.createStatement()){
            
        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }

    public void bajaAsignatura(int cod){
        abrirConexion("add", "localhost", "root", "");

        try (Statement st = this.conexion.createStatement()){
            
        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }
}
