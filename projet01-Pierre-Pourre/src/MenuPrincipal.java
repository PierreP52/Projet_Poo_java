import java.util.*;

public class MenuPrincipal {
	
	MenuPrincipal(){
		
	}
	Scanner sc = new Scanner(System.in);
	
	public void demarrerMenuPrincipal(ListeCours lstCours, ListeEtudiant lstEtudiant) {
		int choix;
		
		do {
		
		System.out.println();
		System.out.println("1- Lister les cours encore disponibles");
		System.out.println("2- Lister les étudiants inscrits à un cours donné");
		System.out.println("3- Lister les cours d’un étudiant");
		System.out.println("4- Modification d’une inscription :");
		System.out.println("5- Quitter");
		System.out.println();
		System.out.println("Veuillez entrer un choix");
		
			try {
				choix = sc.nextInt();
	
				switch (choix) {
				
					case 1 : 
						listerCoursDisponibles(lstCours);
						break;
						
					case 2 : 
						listerEtudiants(lstCours,lstEtudiant);
						break;
					
					case 3 :
						
						listerCours(lstCours,lstEtudiant);
						break;
					
					case 4 :
						
						afficherSousMenu(lstCours,lstEtudiant);
						break;
					
					case 5 :
						
						
						if(confirmerQuitter()== true) {
							System.exit(0);
						}
						else {
							break;
						}
						
					
					default:
		                System.out.println("Choix invalide. Veuillez réessayer.");
		                System.out.println();
		                break;
					}
						
				} catch(InputMismatchException e) {
			            System.out.println("Entrée invalide.");
			            sc.nextLine();
					}
			
		
		}while(true);
		
	}
	
	private void listerCoursDisponibles(ListeCours lstCours) {
		
		for(Cours element : lstCours.getlstCours()) {
			
			if (element != null && element.getIntNbreEtudiants() < element.getIntNbreMax())   {
				
				System.out.println("Cours disponible :\n" + element.toString());
				System.out.println();
			}
			
		}
	}
	
	private void listerEtudiants (ListeCours lstCours, ListeEtudiant lstEtudiant) {
		String numCours;
		
		System.out.println("Veuillez entrez le numéro du cours");
		numCours = sc.next();
		
		Cours element = lstCours.trouver(numCours);
			if(element != null) {
				element.afficherListeEtudiant();
			}
			else {
				System.out.println("Ce numéro n'existe pas!");
			}
	}
	
	private void listerCours(ListeCours lstCours, ListeEtudiant lstEtudiant) {
		int numEtudiant;
		
		System.out.println("Veuillez entrez le numéro de DA de l'étudiant");
		numEtudiant = sc.nextInt();

		
		if(lstEtudiant.trouver(numEtudiant)== null) {
			System.out.println("Ce numéro n'existe pas");	
		}
		else {
			Etudiant element = lstEtudiant.trouver(numEtudiant);
			element.afficherListeCours();
		}
		
	}
	
	private void afficherSousMenu(ListeCours lstCours, ListeEtudiant lstEtudiant) {
		int choix;
		boolean continuer = true;
		do {

			System.out.println("1- annulation d'un cours");
			System.out.println("2- inscription à un cours");
			System.out.println("3- retour au menu principal");
			System.out.println();
			
			try {
				choix = sc.nextInt();
				sc.nextLine();
					switch (choix) {
					
						case 1 : 
							annulerCours( lstCours,  lstEtudiant);
							break;
							
						case 2 : 
							ajouterCours(lstCours,  lstEtudiant);
							break;
						
						case 3 : 
							continuer = false; // Sortir de la boucle
							break;
						
						default : 
							System.out.println("veuillez rentrer un choix valide.");
							System.out.println();
							
							break;
					}

			} catch (InputMismatchException e) {
	            System.out.println("Numéro invalide.");
	            sc.nextLine();
			}
		}while(continuer);
	}
	
	private void annulerCours(ListeCours lstCours, ListeEtudiant lstEtudiant) {
		
		
		System.out.println("Entrez un numéro d'étudiant");
		
		if (sc.hasNextInt()) {
			int numEtudiant = sc.nextInt();
			sc.nextLine();
			System.out.println("Entrez un numéro du cours");
			String numCours = sc.next();

			if(lstCours.trouver(numCours)== null) {
				System.out.println("Ce numéro de cours n'existe pas");
				System.out.println();
			}
			else {
				Cours elementCours = lstCours.trouver(numCours);
				System.out.println("Le numéro du cours" + elementCours.getStrSigle() + " existe!");
				System.out.println();
				
				if(lstEtudiant.trouver(numEtudiant)== null) {
					System.out.println("Ce numéro d'étudiant n'existe pas");
					System.out.println();
				}
				else {
					Etudiant elementEtudiant = lstEtudiant.trouver(numEtudiant);
					System.out.println("Le numéro étudiant " + elementEtudiant.getIntNumDa() + " existe!");
					System.out.println();
					
					
					elementEtudiant.supprimerCours(elementCours);
				}
			}
		} else {
			System.out.println("Numéro d'étudiant invalide. Veuillez entrer un entier.");
			sc.nextLine();
			System.out.println();
		}
		
	}	
		
	private void ajouterCours(ListeCours lstCours, ListeEtudiant lstEtudiant) {
			
		System.out.println("Entrez un numéro d'étudiant");
		
		if (sc.hasNextInt()) {
			
		
			int numEtudiant = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Entrez un numéro du cours");
			String numCours = sc.nextLine();
			
	
			
			if(lstCours.trouver(numCours)== null) {
				System.out.println("Ce numéro de cours n'existe pas.");	
				System.out.println();
			}
			else {
				Cours elementCours = lstCours.trouver(numCours);
				System.out.println("Le numéro du cours" + elementCours.getStrSigle() + " existe!");
				System.out.println();
				
				if(elementCours.getIntNbreEtudiants()>= elementCours.getIntNbreMax()) {
					System.out.println("le cours est complet. Impossible de rajouter de nouvel étudiant.");
					System.out.println();
					
				}
				else {
					if(lstEtudiant.trouver(numEtudiant)== null) {
						System.out.println("Ce numéro d'étudiant n'existe pas \n");	
						System.out.println();
					}
					else {
						Etudiant elementEtudiant = lstEtudiant.trouver(numEtudiant);
						System.out.println("Le numéro l'étudiant " +elementEtudiant.getIntNumDa() + " existe!");
						System.out.println();
						
						if(elementEtudiant.getIntNbreCours() >= 5 ) {
							System.out.println("L'étudiant a déja 5 cours, il ne peut pas en avoir d'autres");
							System.out.println();
							
						}
						else {
							elementEtudiant.ajouterCours(elementCours);
							
						}
					}
				}
			}
		}
		else {
			System.out.println("Numéro d'étudiant invalide. Veuillez entrer un entier.");
			sc.nextLine();
			System.out.println();
		}
	}
	
	private boolean confirmerQuitter() {
		String reponse = "";
		boolean answer = true;
		
		HashSet<String> reponseValidePo = new HashSet<String>();
		reponseValidePo.add("oui");
		reponseValidePo.add("o");
		
		HashSet<String> reponseValideNeg = new HashSet<String>();
		reponseValideNeg.add("non");
		reponseValideNeg.add("n");
		
		while(!reponseValidePo.contains(reponse.toLowerCase()) && !reponseValideNeg.contains(reponse.toLowerCase())) {
			System.out.println("Voulez-vous quittez le programme?");
			reponse = sc.next();
			
			if(reponseValidePo.contains(reponse.toLowerCase())) {
				answer = true;
				
			}
			else if(reponseValideNeg.contains(reponse.toLowerCase())) {
				answer = false;
				
			}
			else {
				System.out.println("Veuillez recommencer.");
			}
		}
		return answer;
		
	}
	
}
