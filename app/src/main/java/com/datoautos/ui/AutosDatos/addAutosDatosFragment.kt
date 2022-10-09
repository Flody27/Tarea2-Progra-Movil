package com.datoautos.ui.AutosDatos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.datoautos.R
import com.datoautos.databinding.FragmentAddAutosDatosBinding
import com.datoautos.model.AutosDatos
import com.datoautos.viewmodel.AutosDatosViewModel
import kotlin.time.Duration.Companion.milliseconds

class addAutosDatosFragment : Fragment() {

    private lateinit var autosDatosViewModel: AutosDatosViewModel
    private var _binding: FragmentAddAutosDatosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        autosDatosViewModel =
            ViewModelProvider(this).get(AutosDatosViewModel::class.java)
        _binding = FragmentAddAutosDatosBinding.inflate(inflater, container, false)

        binding.btAddDatoAuto.setOnClickListener {
            addAutosDatos()
        }

        return binding.root
    }

    private fun addAutosDatos() {
        val marca =  binding.txtMarca.text.toString()
        val modelo = binding.txtModelo.text.toString()
        val motorInfo = binding.txtMotorInfo.text.toString()
        val caballos = binding.txtCaballos.text.toString().toInt()
        val velocidadMax = binding.txtVelocidad.text.toString().toInt()
        if(isNull(marca,modelo,motorInfo,caballos,velocidadMax)){
            val autoDatos = AutosDatos(0,marca,modelo,motorInfo,caballos,velocidadMax)
            autosDatosViewModel.saveAutosDatos(autoDatos)
            Toast.makeText(requireContext(),getString(R.string.msg_add_autos_datos),Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addAutosDatosFragment_to_nav_auto_datos)
        }else{
            Toast.makeText(requireContext(),getString(R.string.msg_falta_datos),Toast.LENGTH_SHORT).show()
        }

    }

    private fun isNull(marca:String,modelo:String,motorInfo:String,caballos:Int,velocidadMax:Int):Boolean{
        return !(marca.isEmpty() || modelo.isEmpty() || motorInfo.isEmpty() || caballos.equals(null) || velocidadMax.equals(null));
    }


}