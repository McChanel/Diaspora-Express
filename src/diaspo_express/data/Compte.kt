package diaspo_express.data

import diaspo_express.repository.Entity

sealed class StatutExpedition {
    object EnCours : StatutExpedition()
    object Annulee : StatutExpedition()
    object Expediee : StatutExpedition()
}
sealed class StatutAnnonce {
    object EnCours : StatutAnnonce()
    object Verifiee : StatutAnnonce()
    object Active : StatutAnnonce()
    object Annulee : StatutAnnonce()
}

sealed class StatutCompte {
    data object Actif : StatutCompte()
    data object Suspendu : StatutCompte()
    data object Banni : StatutCompte()
    companion object {
        fun fromString(s: String): StatutCompte {
            return when(s){
                "Actif"-> Actif
                "Suspendu"-> Suspendu
                "Banni"-> Banni
                else -> throw IllegalArgumentException("unknown syntax: $s")
            }
        }
    }
}

fun StatutCompte.toStringValue(): String{
    return when(this){
        StatutCompte.Actif -> "Actif"
        StatutCompte.Suspendu -> "Suspendu"
        StatutCompte.Banni -> "Banni"
    }
}
open class Compte(
    val id: String,
    var email: String,

    var motDePasse: String,
    var telephone: String,
    var statut: StatutCompte,
): Entity {

    override fun entityToString(): String {
        return "id: $id, email: ${email}, motDePasse: $motDePasse, telephone: $telephone, statut: ${statut.toStringValue()}"
    }

    init {
        require(email.isNotBlank()) { "Email obligatoire" }
        require(email.contains("@")) { "Email invalide" }
        require(motDePasse.length >= 6) { "Mot de passe trop court" }
        require(telephone.isNotBlank()) { "Téléphone obligatoire" }
    }
}