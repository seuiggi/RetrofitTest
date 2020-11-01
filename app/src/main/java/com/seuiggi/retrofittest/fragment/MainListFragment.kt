package com.seuiggi.retrofittest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.seuiggi.retrofittest.DataViewModel
import com.seuiggi.retrofittest.R
import com.seuiggi.retrofittest.adapter.DataListAdapter
import com.seuiggi.retrofittest.databinding.FragmentMainListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainListFragment : Fragment() {

    private lateinit var binding: FragmentMainListBinding
    private val viewModel: DataViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainListRecyclerView.setHasFixedSize(true)

        CoroutineScope(Dispatchers.Main).launch {
            viewModel.getListAsSorted(75).collect {
                binding.apply {
                    mainListRecyclerView.adapter = DataListAdapter(it)
                    mainListProgressBar.visibility = View.GONE
                }
            }
        }
    }
}