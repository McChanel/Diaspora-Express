package diaspo_express.repository

import diaspo_express.data.Administrateur
import diaspo_express.data.AgentAdministrateur
import diaspo_express.data.StatutCompte
import diaspo_express.data.toStringValue
import java.util.Date


class AgentAdministrateurRepository(var adminRepo: AdministrateurRepository, var agentRepository: AgentRepository): BaseRepository<AgentAdministrateur>( "agent_administrateurs") {

    override fun stringToEntity(line: String): AgentAdministrateur {
        val elements = line.split(", ")
        val date = elements[0].split(": ")[1]
        val idAgent = elements[1].split(": ")[1]
        val idAdministrateur = elements[2].split(": ")[1]
        val statut = elements[3].split(": ")[1]
        return AgentAdministrateur(Date(date.toLong()), StatutCompte.fromString(statut), agentRepository.getById(idAgent), adminRepo.getById( idAdministrateur) )
    }
    override fun entityToString(entity: AgentAdministrateur): String {
        return "date: ${entity.date.time}, statut: ${entity.statut.toStringValue()}, idAgent: ${entity.agent.id}, idAdministrateur: ${entity.administrateur.id}"
    }
}
