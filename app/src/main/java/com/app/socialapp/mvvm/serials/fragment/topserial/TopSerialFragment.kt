package com.app.socialapp.mvvm.serials.fragment.topserial

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.app.socialapp.R
import com.app.socialapp.adapter.defaultadapter.MultiTopMoviesAdapter
import com.app.socialapp.binding.viewBinding
import com.app.socialapp.databinding.FragmentListSerialsTmdbBinding
import com.app.socialapp.fragment.BaseFragment

class TopSerialFragment : BaseFragment(R.layout.fragment_list_serials_tmdb), LifecycleOwner {

    private val binding by viewBinding(FragmentListSerialsTmdbBinding::bind)
    private lateinit var viewModel: TopSerialViewModel
    private lateinit var navController: NavController

    companion object {
        private const val ARG_PAGE: String = "ARG_PAGE"
        fun newInstance(page: Int): TopSerialFragment {
            val args = Bundle()
            args.putInt(ARG_PAGE, page)
            val fragment = TopSerialFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TopSerialViewModel::class.java)
        navController = Navigation.findNavController(view)
        binding.apply {
            lifecycleOwner = this@TopSerialFragment
            vmListTopSerials = if (viewModel.serialsLiveData?.value.isNullOrEmpty()) {
                viewModel.apply { viewModel.loadDataInRecView() }
            } else {
                viewModel.apply { viewModel.serialsLiveData?.value }
            }
            adapterMultiTopSerials = MultiTopMoviesAdapter()
        }
    }

}