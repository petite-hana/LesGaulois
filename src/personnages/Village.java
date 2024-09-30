package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom) {
		this.nom = nom;
	}

	public Village(String nom, int nbVillageoisMax) {
		this.nom = nom;
		this.nbVillageois = nbVillageoisMax;
		this.villageois = new Gaulois[nbVillageoisMax];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois++] = gaulois;
	}

	public Gaulois trouverHabitant(int index) {
		return villageois[index];
	}

	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = trouverHabitant(i);
			System.out.println(" - " + gaulois.getNom());
		}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
//		2.e: on a une erreur car on est hors tableau
//		Gaulois gaulois = village.trouverHabitant(30);
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);

		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);

//		2.e: on obtient asterix (def juste au dessus)
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);

		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(obelix);

		village.afficherVillageois();
	}
}