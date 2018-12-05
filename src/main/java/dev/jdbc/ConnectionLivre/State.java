package dev.jdbc.ConnectionLivre;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class State {
	
	public static void main(String[] args)
	{
		readData();
	}
	static final Integer TAILLE_MAX = 10;
	public static void readData()
	{
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Veuillez saisir le SELECT");
//		String selectchoosen = sc.nextLine();
//		System.out.println("Veuillez saisir le FROM parmi les tables suivantes : ");
//		String fromchoosen = sc.nextLine();
		try
		{
			conn = Connect.getConnection();

			// Création d'un objet Statement permettant de réaliser des requêtes sur la base de données
			statement = conn.createStatement();
			
			// L'objet ResultSet contient le résultat de la requête SQL
//			resultSet = statement.executeQuery("SELECT "+selectchoosen+" FROM "+fromchoosen);
			resultSet = statement.executeQuery("SELECT * FROM livre");
			// On récupère les MetaData dans le ResultSet
			ResultSetMetaData resultMetaData = resultSet.getMetaData();
			
			System.out.println("\r\n====");
			
			// On affiche le nom des colonnes
			for (int i = 1; i <= resultMetaData.getColumnCount(); i++){
				String result = resultMetaData.getColumnName(i);
				
				if(resultMetaData.getColumnName(i).length() > TAILLE_MAX) {
					result = resultMetaData.getColumnName(i).substring(0, TAILLE_MAX);
				}
				
				else if(resultMetaData.getColumnName(i).length() < TAILLE_MAX ) {
					for (int j = resultMetaData.getColumnName(i).length(); j <= TAILLE_MAX; j++) {
						result = result+" ";
					}
				}
					
				if (resultMetaData.getColumnName(i).equals("titre") || resultMetaData.getColumnName(i).equals("categorie")) {
					System.out.print("\t" + result.toUpperCase());
				
				}
				else {
					System.out.print("\t" + result.toUpperCase());
				}
			}
			
			
			System.out.println();
			
			while (resultSet.next()){
				for (int i = 1; i <= resultMetaData.getColumnCount(); i++) {
					String result = resultSet.getString(i);
					
					if(resultSet.getString(i) == null) {
						System.out.print("\tVide      ");
						break;
					}
					else if(resultSet.getString(i).length() < TAILLE_MAX) {
						for (int j = resultSet.getString(i).length(); j <= TAILLE_MAX; j++) {
							result = result+" ";
						}
					}
					else if(resultSet.getString(i).length() > TAILLE_MAX) {
						result = resultSet.getString(i).substring(0, TAILLE_MAX);
					}
					
					if (resultMetaData.getColumnName(i).equals("titre") || resultMetaData.getColumnName(i).equals("categorie")) {
						System.out.print("\t" + result);
					}
					
					else {
						System.out.print("\t" + result);				
						}
			}
							System.out.println();
			}
			
			System.out.println("\r\n====");
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				conn.close();
			}
			catch (SQLException e)
			{
				// do nothing
				e.printStackTrace();
			}
			
		}
	}
}