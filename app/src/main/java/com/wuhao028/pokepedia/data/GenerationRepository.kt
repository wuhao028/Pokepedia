package com.wuhao028.pokepedia.data

class GenerationRepository private constructor(private val generationDao: GenerationDao) {

    fun getGeneration(name: String) = generationDao.getGeneration(name)

    fun getGenerations() = generationDao.getGenerations()


    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: GenerationRepository? = null

        fun getInstance(generationDao: GenerationDao) =
            instance ?: synchronized(this) {
                instance ?: GenerationRepository(generationDao).also { instance = it }
            }
    }

}