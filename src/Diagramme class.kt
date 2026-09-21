import kotlin.compareTo

class `Diagramme class` {
}
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
class Compte(
    val id: String,
    var email: String,
    var motDePasse: String,
    var telephone: String
){
    init {
        require(email.isNotBlank()) { "Email obligatoire" }
        require(email.contains("@")) { "Email invalide" }
        require(motDePasse.length >= 6) { "Mot de passe trop court" }
        require(telephone.isNotBlank()) { "Téléphone obligatoire" }
    }
}