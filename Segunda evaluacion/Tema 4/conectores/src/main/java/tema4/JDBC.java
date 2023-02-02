package tema4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    
    private Connection conexion;
    private PreparedStatement ps=null;

    public void abrirConexion(String bd, String servidor, String usuario,
            String password) {
        try {
            String url = String.format("jdbc:mariadb://%s:3306/%s", servidor, bd);
            // Establecemos la conexión con la BD
            this.conexion = DriverManager.getConnection(url + "?useServerPrepStmts=true", usuario, password);
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
            String query = "INSERT INTO alumnos (nombre, apellidos, altura, aula) VALUES ('" + nombre + "','" + apellidos + "'," + altura +"," + aula + ")";
            
            int filasAfectadas = st.executeUpdate(query);
            System.out.println("Filas insertadas: " + filasAfectadas);
        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }

    public void altaAsinatura(int cod, String nombre){
        abrirConexion("add", "localhost", "root", "");

        try (Statement st = this.conexion.createStatement()){
            String query = "INSERT INTO asignaturas VALUES (" + cod + ",'" + nombre + "')";
            
            int filasAfectadas = st.executeUpdate(query);
            System.out.println("Filas insertadas: " + filasAfectadas);
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
            String query = "DELETE FROM alumnos WHERE codigo="+codigo;
            
            int filasAfectadas = st.executeUpdate(query);
            System.out.println("Filas insertadas: " + filasAfectadas);
        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }

    public void bajaAsignatura(int cod){
        abrirConexion("add", "localhost", "root", "");

        try (Statement st = this.conexion.createStatement()){
            String query = "DELETE FROM asignaturas WHERE COD="+cod;
            
            int filasAfectadas = st.executeUpdate(query);
            System.out.println("Filas insertadas: " + filasAfectadas);
        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }

    //Ejercicio 4
    public void modificarAlumno (int codigo, String nombre, String apellidos, int altura, int aula){
        abrirConexion("add", "localhost", "root", "");

        try (Statement st = this.conexion.createStatement()) {
            String query = "UPDATE alumnos SET nombre='"+nombre+"', apellidos='"+apellidos+"', altura="+altura+", aula="+aula+" WHERE codigo="+codigo;
            
            int filasAfectadas = st.executeUpdate(query);
            System.out.println("Filas insertadas: " + filasAfectadas);
        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }

    public void modificarAsignatura (int cod, String nombre){
        abrirConexion("add", "localhost", "root", "");

        try (Statement st = this.conexion.createStatement()) {
            String query = "UPDATE asignaturas SET nombre='"+nombre+"' WHERE COD="+cod;

            int filasAfectadas = st.executeUpdate(query);
            System.out.println("Filas insertadas: " + filasAfectadas);
        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }

    //Ejercicio 5
    public void aulasPobladas(){
        abrirConexion("add", "localhost", "root", "");

        try (Statement st = this.conexion.createStatement()){
            String query = "SELECT DISTINCT nombreAula FROM aulas LEFT JOIN alumnos ON aulas.numero = alumnos.aula";
            ResultSet rs = st.executeQuery(query);

            int contador = 0;
            while (rs.next()){
                System.out.println(rs.getString("nombreAula"));
                contador++;
            }
            System.out.println("Tu búsqueda ha devuelto " + contador + " resultado(s)");
        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
            e.getStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void alumnosConAprovado(){
        abrirConexion("add", "localhost", "root", "");

        try (Statement st = this.conexion.createStatement()){
            String query = "SELECT alumnos.nombre, asignaturas.NOMBRE, notas.NOTA FROM notas LEFT JOIN alumnos ON notas.alumno = alumnos.codigo LEFT JOIN asignaturas ON notas.asignatura = asignaturas.COD WHERE notas.nota >= 5";
            ResultSet rs = st.executeQuery(query);

            int contador = 0;
            while (rs.next()){
                System.out.println(rs.getString("alumnos.nombre") + " " + rs.getString("asignaturas.NOMBRE") + ": " + rs.getInt("notas.nota"));
                contador++;
            }
            System.out.println("Tu búsqueda ha devuelto " + contador + " resultado(s)");
        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
            e.getStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void asignaturasSinAlumnos(){
        abrirConexion("add", "localhost", "root", "");

        try (Statement st = this.conexion.createStatement()){
            String query = "SELECT DISTINCT asignaturas.NOMBRE FROM asignaturas EXCEPT SELECT DISTINCT asignaturas.NOMBRE FROM asignaturas LEFT JOIN notas ON asignaturas.COD = notas.asignatura WHERE notas.asignatura IS NOT NULL";
            ResultSet rs = st.executeQuery(query);

            int contador = 0;
            while (rs.next()){
                System.out.println(rs.getString("NOMBRE"));
                contador++;
            }
            System.out.println("Tu búsqueda ha devuelto " + contador + " resultado(s)");
        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
            e.getStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    //Ejercicio 6
    public boolean patronNombreAlturaAlumno(int codigoAlumno, String patron, int altura){
        abrirConexion("add", "localhost", "root", "");

        try (Statement st = this.conexion.createStatement()){
            String query = "SELECT codigo FROM alumnos WHERE nombre LIKE \"" + patron + "\" AND codigo = " + codigoAlumno + " AND altura > " + altura;
            ResultSet rs = st.executeQuery(query);

            if (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
            e.getStackTrace();
        } finally {
            cerrarConexion();
        }

        return false;
    }

    public boolean patronNombreAlturaAlumnoPS(int codigoAlumno, String patron, int altura){
        abrirConexion("add", "localhost", "root", "");

        try (Statement st = this.conexion.createStatement()){
            String query = "SELECT codigo FROM alumnos WHERE nombre LIKE ? AND codigo = ? AND altura > ?";
            if (this.ps == null){
                this.ps = this.conexion.prepareStatement(query);
            }
            ps.setString(1, patron);
            ps.setInt(2, codigoAlumno);
            ps.setInt(3, altura);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
            e.getStackTrace();
        } finally {
            cerrarConexion();
        }
        return false;
    }
}
