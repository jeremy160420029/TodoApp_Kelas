package com.example.todoapp160420029.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp160420029.R
import com.example.todoapp160420029.databinding.TodoItemLayoutBinding
import com.example.todoapp160420029.model.Todo

class TodoListAdapter(val todoList:ArrayList<Todo>, val checkTodo : (Todo) -> Unit)
    : RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>(), TodoItemLayoutInterface {
    class TodoViewHolder(var view: TodoItemLayoutBinding): RecyclerView.ViewHolder(view.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder
    {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<TodoItemLayoutBinding>(inflater, R.layout.todo_item_layout, parent, false)
        // OR
//        view = TodoItemLayoutBinding.inflate(inflater, parent,
//            false)

        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int)
    {
        holder.view.todo = todoList[position]
        holder.view.checkListener = this
        holder.view.editListener = this

        holder.view.checkTask.isChecked = false

//        var checktask = holder.view.findViewById<CheckBox>(R.id.checkTask)
//        checktask.text = todoList[position].title
//        checktask.isChecked = false
//
////        checktask.setOnCheckedChangeListener { compoundButton, b ->
////            adapterOnClick(todoList[position])
////        }
//
//        var imgEdit = holder.view.findViewById<ImageView>(R.id.imgEdit)
//        imgEdit.setOnClickListener {
//            val action =
//                TodoListFragmentDirections.actionEditTodoFragment(todoList[position].uuid)
//
//            Navigation.findNavController(it).navigate(action)
//        }
//
//        checktask.setOnCheckedChangeListener { compoundButton, isChecked ->
//            if(isChecked == true) {
//                adapterOnClick(todoList[position])
//            }
//        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    fun updateTodoList(newTodoList: List<Todo>) {
        todoList.clear()
        todoList.addAll(newTodoList)
        notifyDataSetChanged()
    }

    override fun onCheckedChanged(cb: CompoundButton, isChecked: Boolean, obj: Todo) {
        if(isChecked) {
            checkTodo(obj)
        }
    }

    override fun onTodoEditClick(v: View) {
//        val uuid = v.tag.toString().toInt()
//        val action = TodoListFragmentDirections.actionEditTodoFragment(uuid)
//        Navigation.findNavController(v).navigate(action)

        val action = TodoListFragmentDirections.actionEditTodoFragment(v.tag.toString().toInt())

            Navigation.findNavController(v).navigate(action)
    }

}
