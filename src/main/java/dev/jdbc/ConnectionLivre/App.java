package dev.jdbc.ConnectionLivre;

import java.util.Scanner;

import dao.DAOLivre;

public class App{
    public static void main( String[] args ){
    	
    	String livre;
    	int id;
    	Scanner scan = new Scanner(System.in);
    	boolean end= false;
    	
    	while (!end) {
    		System.out.println("Que voulez vous faire ? \r\n"
        			+ "--1--lister tous les livres \r\n"
        			+ "--2--Updater un livre \r\n"
        			+ "--3--delete un livre \r\n"
        			+ "--4--creer un livre \r\n"
        			+ "--5--Fin du programme");
    		
        	int choix = Integer.parseInt(scan.nextLine());
        	
        	switch (choix) {
    		case 1:
    			DAOLivre.getAllCategorie();
    			break;
    			
    		case 2:
    			System.out.println("saisir l'id du livre a modifier");
    			id  = Integer.parseInt(scan.nextLine());
    			System.out.println("saisir le nouveau nom du livre");
    			livre = scan.nextLine();
    			try {
    				DAOLivre.updateCategorie(id,livre);
    		       } catch (Exception e) {
    		    	   System.out.println(e.getMessage());
    		       }
    			break;
    			
    		case 3:
    			System.out.println("saisir l'id du livre à supprimer");
    			id  = Integer.parseInt(scan.nextLine());
    			try {
    				DAOLivre.deleteCategorie(id);
				} catch (Exception e) {
					 System.out.println(e.getMessage());
				}
    			break;
    			
    		case 4:
    			
    			System.out.println("saisir le nouveau livre");
    			livre = scan.nextLine();
    			try {
    				DAOLivre.insertCategorie(livre);
    		       } catch (Exception e) {
    		    	   System.out.println(e.getMessage());
    		       }
    			break;
    			
    		case 5:
    			default:
    			System.out.println("Salut, bisous");
    			end = true;
    			break;
    		}
			
		}      
       
       scan.close();
    } 
    
    
}

