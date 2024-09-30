package personnages;

public class Chef {
	private String nom;
	private int force;
	private Village village;

	public Chef(String nom, int force, Village village) {
		this.nom = nom;
		this.force = force;
		this.village = village;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return String.format("Le chef %s du village %s : ", nom, village.getNom());
	}

	public void frapper(Romain romain) {
		System.out.printf("%s envoie un grand coup dans la mâchoire de %s%n", nom, romain.getNom());
		romain.recevoirCoup(force / 3);
	}
}