package com.app.socialapp.mvp.ui.fragment.mycategories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.socialapp.R
import com.app.socialapp.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_category.*

class MyCategoriesFragment : BaseFragment(), MyCategoriesContract.View {

    lateinit var presenter: MyCategoriesContract.Presenter

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_category, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = MyCategoriesPresenter(this)
    }

    override fun visibilityCategory(text: Int, button: Int, recView: Int) {
        mtvCategory.visibility = text
        mBtnAddCategory.visibility = button
        rvCategory.visibility = recView
    }

    override fun showCategoryList() {
        visibilityCategory(View.GONE, View.GONE, View.VISIBLE)
    }

    override fun showAddCategory() {
        visibilityCategory(View.VISIBLE, View.VISIBLE, View.GONE)
    }

    override fun addCategory() {

    }

    override fun clickAddCategory() {

    }
}