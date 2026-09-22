package diaspo_express.repository

import diaspo_express.data.Administrateur
import diaspo_express.data.Agent
import diaspo_express.data.StatutCompte
import diaspo_express.data.toStringValue


class AgentRepository: BaseRepository<Agent>("agents") {

    override fun stringToEntity(line: String): Agent {
        val elements = line.split(", ")
        val id = elements[0].split(": ")[1]
        val email = elements[1].split(": ")[1]
        val motDePasse = elements[2].split(": ")[1]
        val telephone = elements[3].split(": ")[1]
        val statut = elements[4].split(": ")[1]
        return Agent(id, email, motDePasse, telephone, StatutCompte.fromString(statut))
    }

    override fun entityToString(entity: Agent): String {
        return "id: ${entity.id}, email: ${entity.email}, motDePasse: ${entity.motDePasse}, telephone: ${entity.telephone}, statut: ${entity.statut.toStringValue()}"
    }

    fun getById(id: String): Agent {
        return getAll().first { it.id == id }
    }
}

fun sauvegarde(){
    val agentRepository = AgentRepository()
    agentRepository.add(Agent(
        "agent001",
        "ag001@email.com",
        "pass1234",
        "69001",
        StatutCompte.Actif,
    ))
    agentRepository.add(Agent(
        "agent002",
        "ag002@email.com",
        "pass1234",
        "69001",
        StatutCompte.Actif,
    ))
    agentRepository.saveData()
}

fun chargement(){
    val agentRepository = AgentRepository()
    agentRepository.loadData()
    val listAgent = agentRepository.getAll()
    for (agent in listAgent) {
        println(">>> ${agentRepository.entityToString(agent)}")
    }
}

fun main() {
    chargement()
}