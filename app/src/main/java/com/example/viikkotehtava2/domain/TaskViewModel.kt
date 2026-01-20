package com.example.viikkotehtava2.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class TaskViewModel: ViewModel() {
    var tasks by mutableStateOf(listOf<Task>())
    init {
    tasks = mockData
    }
    fun addTask(newTask:Task){
        tasks = addTask(tasks,newTask)
    }
    fun toggleDone(id:Int){
        tasks = toggleDone(tasks, id)
    }
    fun filterByDone(done: Boolean)
    {
        tasks = filterByDone(tasks, done)
    }
    fun sortByDueDate(){
        tasks = sortByDueDate(tasks)
    }
    fun removeTask(id:Int){
        tasks = removeTask(tasks, id)
    }
}