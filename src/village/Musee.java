package village;

import personnages.Equipement;
import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		trophees[nbTrophee++] = new Trophee(gaulois, equipement);
	}

	public String extraireInstructionsOCaml() {
		StringBuilder builder = new StringBuilder().append("let musee = [");
		for (int i = 0; i < nbTrophee; i++) {
			if (i != 0) {
				builder.append(";\n");
			}
			builder.append(String.format("\"%s\", \"%s\"", trophees[i].donnerNom(), trophees[i].getEquipement()));
		}
		builder.append("]");

		return builder.toString();
	}
}
