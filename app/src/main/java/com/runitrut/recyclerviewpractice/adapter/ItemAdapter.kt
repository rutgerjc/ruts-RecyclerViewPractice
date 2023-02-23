package com.runitrut.recyclerviewpractice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.runitrut.recyclerviewpractice.R
import com.runitrut.recyclerviewpractice.model.Affirmation

/* pass in parameter of dataset of type/or/extends List<Affirmation> so that the List<> of type Affirmation has access to
  the actual data class Affirmation  */

/* Add a parameter to the ItemAdapter constructor that is a val called context of type Context.
  Position it as the first parameter in the constructor. */

class ItemAdapter(
    val context: Context, private val dataset: List<Affirmation>
    ):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    /* RecyclerView doesn't interact directly with item views, but deals with ViewHolders instead.
    A ViewHolder represents a single list item view in RecyclerView */
    class ItemViewHolder(private val view:View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    /* The onCreateViewHolder()method is called by the layout manager to create new view holders for
    the RecyclerView (when there are no existing view holders that can be reused).
    Remember that a view holder represents a single list item view.
    The onCreateViewHolder() method takes two parameters and returns a new ViewHolder. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        /* Now adapterLayout holds a reference to the list item view */
        return ItemViewHolder(adapterLayout)
    }

    /* The last method you need to override is onBindViewHolder().
    This method is called by the layout manager in order to replace the contents of a list item view.
    The onBindViewHolder() method has two parameters,
    an ItemViewHolder previously created by the onCreateViewHolder() method,
    and an int that represents the current item position in the list.
    In this method, you will find the right Affirmation object from the data set based on position*/
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
    }
    override fun getItemCount() = dataset.size

}