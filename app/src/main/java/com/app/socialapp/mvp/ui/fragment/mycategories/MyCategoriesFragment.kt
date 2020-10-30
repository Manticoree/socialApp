package com.app.socialapp.mvp.ui.fragment.mycategories

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.R
import com.app.socialapp.adapter.CategoryAdapter
import com.app.socialapp.fragment.BaseFragment
import com.jakewharton.rxbinding4.view.clicks
import eu.davidea.flexibleadapter.FlexibleAdapter
import kotlinx.android.synthetic.main.fragment_category.*

class MyCategoriesFragment : BaseFragment(), MyCategoriesContract.View {

    lateinit var presenter: MyCategoriesContract.Presenter
    private lateinit var navController: NavController
    private lateinit var adapter: FlexibleAdapter<CategoryAdapter>

    companion object {
        private const val ARG_PAGE: String = "ARG_PAGE"
        fun newInstance(page: Int): MyCategoriesFragment {
            val args = Bundle()
            args.putInt(ARG_PAGE, page)
            val fragment = MyCategoriesFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_category, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        presenter = MyCategoriesPresenter(this)
        presenter.getCategories()
        presenter.onClickAddCategory()
    }

    override fun visibilityCategory(text: Int, button: Int, recView: Int) {
        mtvCategory.visibility = text
        mBtnAddCategory.visibility = button
        rvCategory.visibility = recView
    }

    override fun showCategoryList() {
        visibilityCategory(View.GONE, View.VISIBLE, View.VISIBLE)
    }

    override fun showAddCategory() {
        visibilityCategory(View.VISIBLE, View.VISIBLE, View.GONE)
    }

    override fun addCategory() {
        navController.navigate(R.id.action_host_to_addcategory)
    }

    override fun clickAddCategory() {
        mBtnAddCategory.clicks()
                .subscribe {
                    presenter.onAddCategory()
                }
    }

    override fun showRecyclerView(initList: List<CategoryAdapter>) {
        Log.i("initList: ", initList.toString())
        rvCategory.setHasFixedSize(true)
        val manager: RecyclerView.LayoutManager = LinearLayoutManager(
                activity,
                LinearLayoutManager.VERTICAL,
                false
        )
        rvCategory.layoutManager = manager
        adapter = FlexibleAdapter(initList)
        rvCategory.adapter = adapter
    }

}