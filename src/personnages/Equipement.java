package personnages;

public enum Equipement {
	CASQUE("casque", 5),
	BOUCLIER("bouclier", 8);

	private String nom;
	private int resistance;

	Equipement(String nom, int resistance) {
		this.nom = nom;
		this.resistance = resistance;
	}

	public int getResistance() {
		return resistance;
	}

	@Override
	public String toString() {
		return nom;
	}
}
