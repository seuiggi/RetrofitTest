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
import com.seuiggi.retrofittest.databinding.FragmentExtendedListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ExtendedListFragment : Fragment() {

    private lateinit var binding: FragmentExtendedListBinding
    private val viewModel: DataViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_extended_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.extendedListRecyclerView.setHasFixedSize(true)

        CoroutineScope(Dispatchers.Main).launch {
            viewModel.getListAsSorted(75, 75, 151).collect {
                binding.extendedListRecyclerView.adapter = DataListAdapter(it)
                binding.extendedListProgressBar.visibility = View.GONE
            }
        }
    }
}