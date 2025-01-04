package com.example.techexactlyassingments.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.techexactlyassingments.adapters.ApplicationsFragAdapter
import com.example.techexactlyassingments.databinding.FragmentApplicationsBinding
import com.example.techexactlyassingments.viewmodels.ApplicationsViewModel


class ApplicationsListFragment : Fragment() {
    private lateinit var binding: FragmentApplicationsBinding
    private lateinit var adapter: ApplicationsFragAdapter
    private lateinit var viewModel: ApplicationsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentApplicationsBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(ApplicationsViewModel::class.java)
        adapter = ApplicationsFragAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        viewModel.obsList.observe(viewLifecycleOwner) { result ->
            when {
                result.loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                result.error != null -> {
                    Toast.makeText(requireContext(), result.error?.message, Toast.LENGTH_LONG).show()
                }

                result.data != null -> {
                    result.data?.data?.app_list?.let { appList ->
                        adapter.updateList(appList)
                    }
                    binding.progressBar.visibility = View.GONE
                }
            }
        }


        binding.Search.addTextChangedListener {
            val query = it.toString()
            adapter.filter(query)
        }



        return binding.root
    }
}


