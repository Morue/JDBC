package dev.jdbc.ConnectionLivre;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prepare
{
	public static void main(String[] args)
	{
		readData(1, 2);
	}
	
	public static void readData(Integer id1, Integer id2)
	{
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		try
		{
			conn = Connect.getConnection();
			
			// On crée la requête
			String query = "SELECT * FROM livre WHERE id = ? OR id = ?";
			
			
			// On crée l'objet avec la requête en paramètre
			preparedStatement = conn.prepareStatement(query);
			
			// On remplace le premier paramètre (dans cette requête il n'y a qu'un seul paramètre) par le nom de la classe
			preparedStatement.setInt(1, id1);
			preparedStatement.setInt(2, id2);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// On affiche la requête exécutée
			System.out.println(preparedStatement.toString());
			
			
			while (resultSet.next())
			{
				System.out.print("\t" + resultSet.getInt("id") + "\t\t" + resultSet.getString("titre") +  "\t\t" + resultSet.getString("categorie") + "\t\t" + resultSet.getInt("id_auteur") + "\t\t" + resultSet.getInt("id_editeur") + "\t\t" + resultSet.getInt("id_genre") + "\t\t" + resultSet.getInt("id_categorie") +"\r\n");
			}
			
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				// ne rien faire
				e.printStackTrace();
			}
		}
	}
}
