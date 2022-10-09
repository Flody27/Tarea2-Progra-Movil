package com.datoautos.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.datoautos.model.AutosDatos

@Dao
interface AutosDatosDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAutosDatos(AutosDatos : AutosDatos)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateAutosDatos(AutosDatos : AutosDatos)

    @Delete
    suspend fun deleteAutosDatos(AutosDatos : AutosDatos)

    @Query("SELECT *  FROM AutosDatos")
    fun getAutosDatos() : LiveData<List<AutosDatos>>
}