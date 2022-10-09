package com.datoautos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.datoautos.databinding.DatosAutosFilaBinding
import com.datoautos.model.AutosDatos

class AutosDatosAdapter : RecyclerView.Adapter<AutosDatosAdapter.AutosDatosViewHolder>()
{

    inner class AutosDatosViewHolder(private val itemBinding: DatosAutosFilaBinding):
        RecyclerView.ViewHolder(itemBinding.root){

        fun bind(autosDatos: AutosDatos)
        {
            itemBinding.tvMarca.text = autosDatos.marcaAuto
            itemBinding.tvModelo.text = autosDatos.modeloAuto
            itemBinding.tvMotor.text = autosDatos.motorInfo
            itemBinding.tvCaballos.text = autosDatos.caballosMotor.toString()
            itemBinding.tvVelocidad.text = autosDatos.velocidadMaxima.toString()

        }
    }

    //La lista donde estan los objetos Lugar a dibujarse
    private var listaAutoDatos = emptyList<AutosDatos>()



    //Esta funcion crea cajitas para cada lugar en memoria
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):AutosDatosViewHolder {

        val itemBinding = DatosAutosFilaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return AutosDatosViewHolder(itemBinding)
    }

    //Esta funcion toma un lugar y lo envia a dibujar
    override fun onBindViewHolder(holder: AutosDatosViewHolder, position: Int) {

        val AutoDato = listaAutoDatos[position]
        holder.bind(AutoDato)
    }

    // Esta funcion devuelve la cantidad de cajitas a dibujar
    override fun getItemCount(): Int {
        return listaAutoDatos.size
    }

    fun setlistaAutoDatos(autosDatos: List<AutosDatos>)
    {
        this.listaAutoDatos = autosDatos
        notifyDataSetChanged()
    }

}