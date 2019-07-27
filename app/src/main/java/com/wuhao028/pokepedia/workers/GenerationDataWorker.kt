package com.wuhao028.pokepedia.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.wuhao028.pokepedia.data.AppDatabase
import com.wuhao028.pokepedia.data.Generation
import com.wuhao028.pokepedia.data.Pokemon
import com.wuhao028.pokepedia.utilities.GENERATION_DATA_FILENAME
import com.wuhao028.pokepedia.utilities.POKEMON_DATA_FILENAME
import kotlinx.coroutines.coroutineScope

class GenerationDataWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    private val TAG by lazy { PokemonDatabaseWorker::class.java.simpleName }

    override suspend fun doWork(): Result = coroutineScope {

        try {
            applicationContext.assets.open(GENERATION_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val plantType = object : TypeToken<List<Generation>>() {}.type
                    val plantList: List<Generation> = Gson().fromJson(jsonReader, plantType)
                    Log.d("@@","@@ add all 01 ")

                    val database = AppDatabase.getInstance(applicationContext)
                    database.generationDao().insertAll(plantList)
                    Result.success()
                }
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }
}