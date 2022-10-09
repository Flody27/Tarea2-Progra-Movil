package com.datoautos.ui.AutosDatos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.datoautos.R
import com.datoautos.adapter.AutosDatosAdapter
import com.datoautos.databinding.FragmentAutosDatosBinding
import com.datoautos.viewmodel.AutosDatosViewModel

class AutosDatosFragment : Fragment() {

    private var _binding: FragmentAutosDatosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val autosDatosViewModel =
            ViewModelProvider(this)[AutosDatosViewModel::class.java]
        _binding = FragmentAutosDatosBinding.inflate(inflater, container, false)


        binding.btFltAddDatoAuto.setOnClickListener{
            findNavController().navigate(R.id.action_nav_auto_datos_to_addAutosDatosFragment )
        }

        val autosDatosAdapter = AutosDatosAdapter()
        val reciclador = binding.reciclador
        reciclador.adapter = autosDatosAdapter
        reciclador.layoutManager= LinearLayoutManager(requireContext())

        autosDatosViewModel.getAutosDatos.observe(viewLifecycleOwner)
        {
                autosDatos -> autosDatosAdapter.setlistaAutoDatos(autosDatos)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}