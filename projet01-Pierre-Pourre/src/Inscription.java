
public class Inscription {
	
	public static void main(String[] args) {
		 	ListeCours listeCours = new ListeCours();

	        // Création de quelques objets Cours et ajout à la liste
	        Cours cours1 = new Cours("CSCI101", "Introduction à l'informatique", 0, 30);
	        Cours cours2 = new Cours("MATH202", "Algèbre linéaire", 0, 30);
	        Cours cours3 = new Cours("PHYS301", "Physique quantique", 0, 30);
	        Cours cours4 = new Cours("ENG101", "English Composition", 0, 30);
	        Cours cours5 = new Cours("ART203", "Introduction a l'Arts", 0, 30);
	        Cours cours6 = new Cours("HIST301", "Anciennes Civilisations", 0, 30);

	        listeCours.ajouterCours(cours1);
	        listeCours.ajouterCours(cours2);
	        listeCours.ajouterCours(cours3);
	        listeCours.ajouterCours(cours4);
	        listeCours.ajouterCours(cours5);
	        listeCours.ajouterCours(cours6);
	        
	        ListeEtudiant listeEtudiants = new ListeEtudiant();
	        // Création de quelques objets Etudiant et ajout à la liste
	        Etudiant etudiant1 = new Etudiant(1, "John Doe", "Informatique", "2021");
	        Etudiant etudiant2 = new Etudiant(2, "Jane Smith", "Biologie", "2022");
	        Etudiant etudiant3 = new Etudiant(3, "Alice Johnson", "Physique", "2020");
	        Etudiant etudiant4 = new Etudiant(4, "Ice Son", "Physique", "2023");
	        Etudiant etudiant5 = new Etudiant(5, "Dupont Iki", "Biologie", "2020");
	        Etudiant etudiant6 = new Etudiant(6, "Raouel Janis", "Informatique", "2019");
	        Etudiant etudiant7 = new Etudiant(7, "Zelda Link", "Informatique", "2022");
	        
	        listeEtudiants.inserer(etudiant1);
	        listeEtudiants.inserer(etudiant2);
	        listeEtudiants.inserer(etudiant3);
	        listeEtudiants.inserer(etudiant4);
	        listeEtudiants.inserer(etudiant5);
	        listeEtudiants.inserer(etudiant6);
	        listeEtudiants.inserer(etudiant7);

	        MenuPrincipal menuPrincipal = new MenuPrincipal();
			menuPrincipal.demarrerMenuPrincipal(listeCours, listeEtudiants);
	}
}
