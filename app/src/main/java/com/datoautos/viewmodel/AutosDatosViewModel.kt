package com.datoautos.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.datoautos.data.AutosDatosDataBase
import com.datoautos.model.AutosDatos
import com.datoautos.repository.AutosDatosRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AutosDatosViewModel(application: Application) : AndroidViewModel(application)  {

    private val AutosDatosRepository: AutosDatosRepository
    val getAutosDatos: LiveData<List<AutosDatos>>

    init {
        val lugarDao = AutosDatosDataBase.getDatabase(application).AutosDatosDao()
        AutosDatosRepository = AutosDatosRepository(lugarDao)
        getAutosDatos = AutosDatosRepository.getAutosDatos
    }

    fun saveAutosDatos(AutosDatos: AutosDatos){
        viewModelScope.launch(Dispatchers.IO) {
            AutosDatosRepository.saveAutosDatos(AutosDatos) }
    }

    fun deleteAutosDatos(AutosDatos: AutosDatos){
        viewModelScope.launch(Dispatchers.IO) {
            AutosDatosRepository.deleteAutosDatos(AutosDatos) }
    }

}