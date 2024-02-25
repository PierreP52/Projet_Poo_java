
public class Cours {
	private String strSigle; //sigle du cours
	private String strDescription; //description du cours
	private Etudiant[]tabEtudiants; //tableau objet d'étudiant inscrit au cours
	private int intNbreEtudiants; // nombre d'etudiants inscrits au cours
	private int intNbreMax; //nombre maximum d'étudiants pour le cours
	
	public Cours (String strSigle, String strDescription, int intNbreEtudiants, int intNbreMax){
		this.strSigle = strSigle;
		this.strDescription = strDescription;
		this.intNbreEtudiants = intNbreEtudiants;
		this.intNbreMax = 30;
		this.tabEtudiants = new Etudiant[30];
	}
	
	public String toString() {
		return "Sigle du Cours :" + strSigle + "\nDescription : " + strDescription + "\nNombre d’étudiants inscrits : " + intNbreEtudiants + "\nNombre maximum : " + intNbreMax;
	}
	
	public void afficherListeEtudiant() {
		boolean aucunEtudiant = true;
		
		for (Etudiant etudiant : tabEtudiants)	{
			if(etudiant != null) {
				System.out.println(etudiant);
				System.out.println();
				aucunEtudiant = false;
			}
		}
		if(aucunEtudiant) {
			System.out.println("Aucun étudiants est inscrit à ce cours!");
			System.out.println();
		}
		
	}
	public void ajouterEtudiant (Etudiant etu) {
		
		boolean estDejainscrit = false;
		
		for(Etudiant element : tabEtudiants) {
			if(element != null && element.equals(etu)) {
				estDejainscrit = true;
				System.out.println("L'étudiant est déja inscrit a ce cours!");
				System.out.println();
				break;
			}	
		 }
		 if (!estDejainscrit) {
		        // Recherche d'une position vide dans le tableau
		        int positionVide = -1;
		        for (int i = 0; i < tabEtudiants.length; i++) {
		            if (tabEtudiants[i] == null) {
		                positionVide = i;
		                break;
		            }
		        }

		        if (positionVide != -1) {
		            // Ajouter l'étudiant à la position vide
		        	tabEtudiants[positionVide] = etu;
		            System.out.println("L'étudiant a été ajouté au cours avec succès !");
		            System.out.println();
		            intNbreEtudiants ++;
		        } 
		        else {
		            System.out.println("Le nombre maximum d'étudiant est atteint. Impossible d'ajouter un nouvel étudiant.");
		            System.out.println();
		        }
		 }
	}
	
	public void supprimerEtudiant(Etudiant etu) {
		
		for(int i = 0; i < tabEtudiants.length; i++) {
			if(tabEtudiants[i].equals(etu)) {
				tabEtudiants[i] = null;
				System.out.println("Etudiant supprimer de la liste des étudiants suivant ce cours!");
				System.out.println();
				intNbreEtudiants --;
				break;
			}
			else {
				// si le cours n'est pas présent dans le tableau
				System.out.println("L'étudiant n'est pas inscrit a ce cours!");
				System.out.println();
			}
		}
		
		
	}
	public String getStrSigle() {
		return strSigle;
	}
	
	public int getIntNbreEtudiants() {
		return intNbreEtudiants;
	}
	public int getIntNbreMax() {
		return intNbreMax;
	}
}
