
public class ListeCours {
	private Cours lstCours[] = new Cours[50]; //pour stocker les cours
	private int intNbreElements; //nombre de cours dans le tableau
	
	public ListeCours () {
		
	}
	
	public Cours trouver(String strSigle) {
		
		
			for(Cours element : lstCours ) {
				if (element != null && element.getStrSigle().equals(strSigle)) {
					return element;
				}
			}
			return null;
		
	}
	
	public Cours [] getlstCours() {
		return lstCours;
	}

	public void ajouterCours(Cours cours1) {
        if (intNbreElements < lstCours.length) {
            lstCours[intNbreElements] = cours1;
            intNbreElements++;
            System.out.println("Le cours a été ajouté avec succès !");
            System.out.println();
        } else {
            System.out.println("Le nombre maximum de cours est atteint. Impossible d'ajouter un nouveau cours.");
            System.out.println();
        }
    }
}
