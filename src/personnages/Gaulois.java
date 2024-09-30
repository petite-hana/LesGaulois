package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

	private int nbTrophees = 0;
	private Equipement trophees[] = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.printf("%s« %s »%n", prendreParole(), texte);
	}

	private String prendreParole() {
		return String.format("Le gaulois %s : ", nom);
	}

	public void frapper(Romain romain) {
		System.out.printf("%s envoie un grand coup dans la mâchoire de %s%n", nom, romain.getNom());
		Equipement[] trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; i < trophees.length && trophees[i] != null; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophees[i];
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler(String.format("Merci Druide, je sens que ma force est %d fois décuplée.", forcePotion));
	}

	@Override
	public String toString() {
		return String.format("Gaulois [nom=%s, force=%d, effetPotion=%d]", nom, force, effetPotion);
	}

	// FONCTION MAIN
	public static void main(String[] args) {
		Druide druide = new Druide("Druidix", 5, 10);
		Gaulois gaulois = new Gaulois("Gaulux", 3);
		Romain romain = new Romain("Rominus", 3);

		int force = druide.preparerPotion();
		gaulois.boirePotion(force);

		gaulois.parler("Je suis un gaulois");
		gaulois.frapper(romain);
	}
}