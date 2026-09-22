
package diaspo_express.data

import java.util.Date


data class AgentAdministrateur(
    val date: Date,
    var statut: StatutCompte,
    var agent: Agent,
    var administrateur: Administrateur,
)