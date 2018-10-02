package principal;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("OK");
        
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não importado! Importe o driver.");
        }
        
        String url = "jdbc:postgresql://localhost:5432/si201801";
        String usuario = "postgres";
        String senha = "postgres";
        // cx armazena o ponteiro de conexão.
        Connection cx = DriverManager.getConnection(url, usuario, senha);
        
        // Instruções para inserir dados
        //String sql = "insert into pessoas(codigo, nome, endereco) values (?, ?, ?)";
        
        //PreparedStatement ps = cx.prepareStatement( sql );
        //ps.setInt(1, 2);
        //ps.setString(2, "Felipe da Silva");
        //ps.setString(3, "Rua das Margaridas, 112");
        //ps.execute();
        
        // Instruções para buscar/consultar dados
        String query = "select * from pessoas";
        
        PreparedStatement ps2 = cx.prepareStatement( query );
        ResultSet rs = ps2.executeQuery();
        
        while( rs.next() ) {
            System.out.println("Nome: " + rs.getString("nome") );
        }
        rs.close();
        ps2.close();
    }
}
