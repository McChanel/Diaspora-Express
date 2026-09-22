package diaspo_express.repository

import diaspo_express.data.Administrateur
import diaspo_express.data.StatutCompte
import diaspo_express.data.toStringValue


class AdministrateurRepository: BaseRepository<Administrateur>("administrateurs") {
    // return "id: $id, email: ${email}, motDePasse: $motDePasse, telephone: $telephone, statut: $statut";

    override fun stringToEntity(line: String): Administrateur {
        val elements = line.split(", ")
        val id = elements[0].split(": ")[1]
        val email = elements[1].split(": ")[1]
        val motDePasse = elements[2].split(": ")[1]
        val telephone = elements[3].split(": ")[1]
        val statut = elements[4].split(": ")[1]
        return Administrateur(id, email, motDePasse, telephone, StatutCompte.fromString(statut))
    }
    override fun entityToString(entity: Administrateur): String {
        return "id: ${entity.id}, email: ${entity.email}, motDePasse: ${entity.motDePasse}, telephone: ${entity.telephone}, statut: ${entity.statut.toStringValue()}"
    }

    fun getById(id: String): Administrateur {
        return getAll().first { it.id == id }
    }
}
