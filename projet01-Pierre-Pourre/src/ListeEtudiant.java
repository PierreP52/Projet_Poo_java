
public class ListeEtudiant {
	private Etudiant lstEtudiants[]= new Etudiant[100]; //pour stocker les étudiants
	private int intNbreElements; //nombre d’étudiants dans le tableau
	
	public ListeEtudiant() {
		
	}
	
	public void inserer (Etudiant objEtudiant) {
		
		int positionVide = -1;
        for (int i = 0; i < lstEtudiants.length; i++) {
            if (lstEtudiants[i] == null && intNbreElements < i) {
                positionVide = i;
                break;
            }
        }

        if (positionVide != -1) {
            
        	objEtudiant.setIntNumDa(positionVide);
        	// Ajouter l'objetEtudiant à la position vide
        	lstEtudiants[positionVide] = objEtudiant;
            System.out.println("L'étudiant a été ajouter avec succés!");
            System.out.println();
            intNbreElements++;
        } 
        else {
            System.out.println("Le nombre maximum d'étudiants est atteint. Impossible d'ajouter un nouvel étudiant.");
            System.out.println();
        }
	}
	
	public Etudiant trouver(int intNumDA) {
		
		for(Etudiant element : lstEtudiants ) {
			if (element != null && element.getIntNumDa() == intNumDA) {
				return element;
			}
		}
		return null;
	}
}
