package com.datoautos.repository

import androidx.lifecycle.LiveData
import com.datoautos.data.AutosDatosDao
import com.datoautos.model.AutosDatos

class AutosDatosRepository(private val AutosDatosDao: AutosDatosDao) {

    suspend fun saveAutosDatos(AutosDatos : AutosDatos){
        if(AutosDatos.id==0){
            AutosDatosDao.addAutosDatos(AutosDatos)
        }else {
            AutosDatosDao.addAutosDatos(AutosDatos)
        }
    }

    suspend fun deleteAutosDatos(AutosDatos : AutosDatos){
        if(AutosDatos.id==0){
            AutosDatosDao.deleteAutosDatos(AutosDatos)
        }
    }

    val getAutosDatos : LiveData<List<AutosDatos>> = AutosDatosDao.getAutosDatos()
}