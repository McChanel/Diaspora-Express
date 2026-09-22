package diaspo_express.repository

import diaspo_express.data.StatutCompte
import diaspo_express.data.Utilisateur
import diaspo_express.data.toStringValue


class UtilisateurRepository: BaseRepository<Utilisateur>() {
    override fun entityName(): String {
        return "utilisateurs"
    }
    // return "id: $id, email: ${email}, motDePasse: $motDePasse, telephone: $telephone, statut: $statut";

    override fun stringToEntity(line: String): Utilisateur {
        val elements = line.split(", ")
        val id = elements[0].split(": ")[1]
        val email = elements[1].split(": ")[1]
        val motDePasse = elements[2].split(": ")[1]
        val telephone = elements[3].split(": ")[1]
        val statut = elements[4].split(": ")[1]
        return Utilisateur(id, email, motDePasse, telephone, StatutCompte.fromString(statut))
    }

    override fun entityToString(entity: Utilisateur): String {
        return "id: ${entity.id}, email: ${entity.email}, motDePasse: ${entity.motDePasse}, telephone: ${entity.telephone}, statut: ${entity.statut.toStringValue()}"
    }
}
