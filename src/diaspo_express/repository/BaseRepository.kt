package diaspo_express.repository

import java.io.File

interface Entity{
    fun entityToString(): String
}

abstract class BaseRepository<T: Entity> {
    fun saveData(listEntities: MutableList<T>){
        if(listEntities.isNotEmpty()){
            val fileName = "${entityName()}.txt"
            File(fileName).bufferedWriter().use { writer ->
                for (entity in listEntities){
                    writer.write(entity.entityToString())
                    writer.newLine()
                }
            }
        }
    }

    fun loadData(): MutableList<T>{
        val listAdmin: MutableList<T> = mutableListOf()
        val fileName = "${entityName()}.txt"

        if(File(fileName).isFile()){
            File(fileName).forEachLine { line ->
                val entity = stringToEntity(line)
                listAdmin.add(entity)
            }
        }
        return listAdmin
    }

    abstract fun entityName(): String

    abstract fun stringToEntity(line: String): T


}
