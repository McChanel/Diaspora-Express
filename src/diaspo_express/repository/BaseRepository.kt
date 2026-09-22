package diaspo_express.repository

import java.io.File


abstract class BaseRepository<T>(var entityName: String) {
    private val listEntities: MutableList<T> = ArrayList()

    fun saveData(){
        if(listEntities.isNotEmpty()){
            val fileName = "${entityName}.txt"
            File(fileName).bufferedWriter().use { writer ->
                for (entity in listEntities){
                    writer.write(entityToString(entity))
                    writer.newLine()
                }
            }
        }
    }

    fun loadData(){
        listEntities.clear()
        val fileName = "${entityName}.txt"

        if(File(fileName).isFile()){
            File(fileName).forEachLine { line ->
                val entity = stringToEntity(line)
                listEntities.add(entity)
            }
        }
    }

    fun getAll(): MutableList<T> {
        return listEntities
    }

    fun add(entity: T) {
        listEntities.add(entity)
    }

    abstract fun stringToEntity(line: String): T

    abstract fun entityToString(entity: T): String

}
