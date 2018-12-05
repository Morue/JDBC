package dev.jdbc.Model;

public class Livre {
	
	 private int id; 
	 private String titre;
	 private String categorie;
	 private int id_auteur;
	 private int id_editeur;
	 private int id_genre;
	 private int id_categorie;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public int getId_auteur() {
		return id_auteur;
	}
	public void setId_auteur(int id_auteur) {
		this.id_auteur = id_auteur;
	}
	public int getId_editeur() {
		return id_editeur;
	}
	public void setId_editeur(int id_editeur) {
		this.id_editeur = id_editeur;
	}
	public int getId_genre() {
		return id_genre;
	}
	public void setId_genre(int id_genre) {
		this.id_genre = id_genre;
	}
	public int getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}
	 
	 
}
