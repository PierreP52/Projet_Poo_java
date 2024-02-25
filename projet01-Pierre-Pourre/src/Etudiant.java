
public class Etudiant {
	
	private int intNumDA ; //pour identification unique de l’étudiant
	private String strPrenomNom;//prenom et nom de l’étudiant
	private String programme;//Programme auquel l’étudiant est inscrit
	private String strDateAdmission;//en format AAAA
	private Cours tabCours[]=new Cours[5];//l’étudiant peut être
										 //inscrit à 5 cours au maximum
	private int intNbreCours ; // nombre de cours effectivement suivis par l’étudiant
	
	public Etudiant (int intNumDA, String strPrenomNom, String programme, String strDateAdmission) { //Ce constructeur initialise les variables d’instance aux valeurs des arguments.
		
		this.intNumDA = intNumDA;
		this.strPrenomNom = strPrenomNom;
		this.programme = programme;
		this.strDateAdmission = strDateAdmission;
	}
	
	public String toString() {
		
		return "Numéro :" + intNumDA + "\n Prénom et Nom : " + strPrenomNom + "\n Programme : " + programme + "\n Date d'admission : " + strDateAdmission;
	}
	
	public void afficherListeCours() {
		
			if(intNbreCours == 0) {
				System.out.println("L'étudiant n'est inscrit a aucun cours!");
			}
			else {
				for(int i = 0; i < tabCours.length; i++) {
					if (tabCours [i] != null) {
						System.out.println(tabCours[i]);
						
					}
					
					
			}
		}
	}
	
	public void ajouterCours(Cours c) {
		
		boolean estDejainscrit = false;
		
		for(Cours element : tabCours) {
			if(element != null && element.equals(c)) {
				estDejainscrit = true;
				System.out.println("L'étudiant est déja inscrit a ce cours!");
				break;
			}	
		}
		if (estDejainscrit == false) {
		        // Recherche d'une position vide dans le tableau
		        int positionVide = -1;
		        for (int i = 0; i < tabCours.length; i++) {
		            if (tabCours[i] == null) {
		                positionVide = i;
		                break;
		            }
		        }
	
		        if (positionVide != -1) {
		            // Ajouter le cours à la position vide
		            tabCours[positionVide] = c;
		            System.out.println("Le cours a été ajouté avec succès !");
		            c.ajouterEtudiant(this);
		            intNbreCours ++;
		        } 
		        else {
		            System.out.println("Le nombre maximum de cours est atteint. Impossible d'ajouter un nouveau cours.");
		        }
		    }
	}
	
	public void supprimerCours (Cours c) {
		
		
		for(int i = 0; i < tabCours.length; i++) {
			if(tabCours[i] != null && tabCours[i].equals(c)) {
				tabCours[i] = null;
				// si le cours n'est pas présent dans le tableau
				System.out.println("Annulation de l'inscription de l'étudiant a ce cours!");
				System.out.println();
				c.supprimerEtudiant(this);
				intNbreCours--;
				break;
			}else {
				System.out.println("L'étudiant n'est pas inscrit a ce cours!");
				System.out.println();	
			}
		}
		
	}
	
	public void setIntNumDa(int numDa) {
		intNumDA = numDa;
	}
	
	public int getIntNumDa() {
		return intNumDA;
	}
	public int getIntNbreCours() {
		return intNbreCours;
	}
}

	