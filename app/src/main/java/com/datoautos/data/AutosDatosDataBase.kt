package com.datoautos.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.datoautos.model.AutosDatos

@Database(entities = [AutosDatos::class], version = 1, exportSchema = false)
abstract  class AutosDatosDataBase: RoomDatabase() {

    abstract fun AutosDatosDao() : AutosDatosDao

    companion object {
        @Volatile
        private var INSTANCE: AutosDatosDataBase? = null
        fun getDatabase(context: Context) : AutosDatosDataBase  {
            val local = INSTANCE
            if(local != null) {
                return local
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AutosDatosDataBase::class.java,
                    "AutosDatos_Database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}