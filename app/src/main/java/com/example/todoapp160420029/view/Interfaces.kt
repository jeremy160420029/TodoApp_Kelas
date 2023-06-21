package com.example.todoapp160420029.view

import android.view.View
import android.widget.CompoundButton
import com.example.todoapp160420029.model.Todo

interface TodoItemLayoutInterface {
    fun onCheckedChanged(cb: CompoundButton,
                         isChecked:Boolean,
                         obj: Todo
    )

    fun onTodoEditClick(v: View)
}