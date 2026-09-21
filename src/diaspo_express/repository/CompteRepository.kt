package diaspo_express.repository

import diaspo_express.data.Compte
import diaspo_express.data.StatutCompte


class CompteRepository: BaseRepository<Compte>() {
    override fun entityName(): String {
        return "comptes"
    }
    // return "id: $id, email: ${email}, motDePasse: $motDePasse, telephone: $telephone, statut: $statut";

    override fun stringToEntity(line: String): Compte {
        val elements = line.split(", ")
        val id = elements[0].split(": ")[1]
        val email = elements[1].split(": ")[1]
        val motDePasse = elements[2].split(": ")[1]
        val telephone = elements[3].split(": ")[1]
        val statut = elements[4].split(": ")[1]
        val compte = Compte(id, email, motDePasse, telephone, StatutCompte.fromString(statut))
        return compte
    }
}

fun main() {
    /*val compte1 = Compte("0001", "test1@email.com", "pass000123", "+237690000", StatutCompte.Actif )
    val compte2 = Compte("0002", "test2@email.com", "pass000123", "+237691111", StatutCompte.Actif )
    var listCompte = mutableListOf<Compte>(compte1, compte2)
    val persitence = CompteRepository();

    persitence.saveData(   listCompte )*/
    val persitence = CompteRepository()
    val listCompte = persitence.loadData()
    for (item in listCompte) {
    println(item.entityToString())
    }

}
