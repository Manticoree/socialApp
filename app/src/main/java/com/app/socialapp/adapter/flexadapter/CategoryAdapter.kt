package com.app.socialapp.adapter.flexadapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.R
import com.app.socialapp.domain.entities.db.ItemCategory
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter(private val itemCategory: ItemCategory) :
        AbstractFlexibleItem<CategoryAdapter.CategoryHolder>() {

    override fun bindViewHolder(
            adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?,
            holder: CategoryHolder?,
            position: Int,
            payloads: MutableList<Any>?
    ) {
        holder?.bind(itemCategory)
    }

    override fun equals(other: Any?): Boolean {
        return if (other is ItemCategory) {
            other == itemCategory
        } else {
            false
        }
    }

    override fun createViewHolder(
            view: View,
            adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>
    ): CategoryHolder = CategoryHolder(view, adapter)

    override fun getLayoutRes(): Int = R.layout.item_category

    override fun hashCode(): Int = itemCategory.hashCode()

    inner class CategoryHolder(
            view: View,
            adapter: FlexibleAdapter<out IFlexible<*>>
    ) : FlexibleViewHolder(view, adapter) {

        fun bind(itemCategory: ItemCategory) {
            itemView.mtvCategoryName.text = itemCategory.name
        }

    }

}