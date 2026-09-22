package diaspo_express.data

class Administrateur(
    id: String,
    email: String,

    motDePasse: String,
    telephone: String,
    statut: StatutCompte,
): Compte(id, email, motDePasse, telephone, statut) {


}