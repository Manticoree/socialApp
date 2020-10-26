package com.app.socialapp.mvp.ui.fragment.dialog.bottom.addcategory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.socialapp.R
import com.app.socialapp.mvp.ui.fragment.dialog.bottom.BaseBottomFragment
import com.jakewharton.rxbinding4.view.clicks
import kotlinx.android.synthetic.main.bottom_fragment_category.*

class AddCategoryFragment : BaseBottomFragment(), AddCategoryContract.View {

    lateinit var presenter: AddCategoryContract.Presenter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.bottom_fragment_category, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = AddCategoryPresenter(this)
        presenter.onAddInCategory()
    }

    override fun addInCategory() {
        mBtnAddInBD.clicks().subscribe {
            presenter.setCategory(tietAddCategory.text.toString())
        }
    }

}