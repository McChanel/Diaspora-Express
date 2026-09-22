package diaspo_express.data

class Agent(
    id: String,
    email: String,

    motDePasse: String,
    telephone: String,
    statut: StatutCompte,
): Compte(id, email, motDePasse, telephone, statut) {


}