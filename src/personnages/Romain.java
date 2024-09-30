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
		System.out.printf("%s« %s »%n", prendreParole(), texte);
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public Equipement[] recevoirCoup(int forceCoup) {
//		précondition
		assert force > 0;

		Equipement[] equipementEjecte = null;
		int oldForce = force;
		force -= calculResistanceEquipement(forceCoup);
		if (force > 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}

//		post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

	public void sEquiper(Equipement equipement) {
		if (nbEquipement == equipements.length) {
			System.out.printf("Le soldat %s est déjà bien protégé !%n", nom);
			return;
		}

		if (equipements[equipement.ordinal()] != null) {
			System.out.printf("Le soldat %s possède déjà un %s !%n", nom, equipement);
			return;
		}

		System.out.printf("Le soldat %s s'équipe avec un %s !%n", nom, equipement);
		equipements[equipement.ordinal()] = equipement;
		nbEquipement++;
	}

	public boolean aEquipement(Equipement equipement) {
		return equipements[equipement.ordinal()] != null;
	}

	private int calculResistanceEquipement(int forceCoup) {
		StringBuilder texteBuilder = new StringBuilder();
		texteBuilder.append(String.format("Ma force est de %d, et la force du coup est de %d", this.force, forceCoup));
		int resistanceEquipement = 0;

		if (nbEquipement != 0) {
			if (aEquipement(Equipement.BOUCLIER)) {
				resistanceEquipement += Equipement.BOUCLIER.getResistance();
			} else if (aEquipement(Equipement.CASQUE)) {
				resistanceEquipement += Equipement.CASQUE.getResistance();
			}

			texteBuilder
					.append("\nMais heureusement, grace à mon équipement sa force est diminué de ")
					.append(resistanceEquipement)
					.append("!");
		}

		parler(texteBuilder.toString());
		return forceCoup - resistanceEquipement;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.printf("L'équipement de %s s'envole sous la force du coup.%n", nom);

		int nbEquipementEjecte = 0;
		for (int i = 0; i < equipements.length; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte++] = equipements[i];
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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