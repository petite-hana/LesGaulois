package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		assert force > 0;

		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[Equipement.values().length];
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}

	public void sEquiper(Equipement equipement) {
		if (nbEquipement == 2) {
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			return;
		}

		if (equipements[equipement.ordinal()] != null) {
			System.out.println("Le soldat " + nom + " possède déjà un " + equipement.nom + " !");
			return;
		}

		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.nom + " !");
		equipements[equipement.ordinal()] = equipement;
		nbEquipement++;
	}

	// FONCTION MAIN
	public static void main(String[] args) {
		Romain romain = new Romain("Minus", 3);

		romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.BOUCLIER);
		romain.sEquiper(Equipement.BOUCLIER);

		romain.parler("Je suis un romain");
		romain.recevoirCoup(1);
		romain.recevoirCoup(3);
	}
}