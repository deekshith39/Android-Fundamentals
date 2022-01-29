package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    var todos: List<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView
        val cbDone: CheckBox

        init {
            tvTitle = itemView.findViewById(R.id.tvTitle)
            cbDone = itemView.findViewById(R.id.cbDone)
        }
    }

    // These are the mandatory three functions of the recycler view

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        // This is for the specific item of the recycler view which deals with the inflation of the card layout as an item for an item for the RecyclerView
        // This function is basically called when the recycler function needs a new viewHolder for an item which has to be visible
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false) // attach to root is false because we don't want to a attach layout to the root

        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        // It takes the data from the todolists mentioned above(constructor paramater) and set it to the corresponding attributes of the Todo class.
        // TodoViewHolder is used to access the views of the textview and checkbox in our example
        // position: current position of the particular item
        holder.apply {
            tvTitle.text = todos[position].title
            cbDone.isChecked = todos[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        // returns how many items we have in our recycler view
        return todos.size
    }
}