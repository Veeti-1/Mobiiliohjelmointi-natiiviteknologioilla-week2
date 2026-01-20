package com.example.viikkotehtava2.ui.theme

import android.R.attr.checked
import android.text.BoringLayout
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viikkotehtava2.domain.TaskViewModel
import com.example.viikkotehtava2.domain.*

@Composable
fun viewModelHomeScreen(viewModel: TaskViewModel = viewModel()) {
    Column(modifier = Modifier.padding(horizontal = 40.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Row(modifier = Modifier.padding(top = 22.dp)) {
            Button(onClick = {

                viewModel.filterByDone(done = true)
            }) { Text(text = "Show only done tasks") }

            Button(onClick = {
                viewModel.sortByDueDate()
            }) { Text(text = "Sort by dueDate") }


        }
        LazyColumn() {  viewModel.tasks.forEach { task ->

            item {
                Row() {
                    Text(
                        text = "Title: ${task.title}",

                        modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)
                    )
                    var check: Boolean
                    if (task.done) {
                        check = true
                    } else {
                        check = false
                    }
                    Button(onClick = {
                        viewModel.removeTask(task.id)
                        println("id: " + task.id)
                    })
                    { Text(text = "Remove") }
                    Button(onClick = { viewModel.toggleDone(task.id) }) {
                        if (!task.done) {
                            Text(text = "Done")
                        } else {
                            Text(text = "undo")
                        }
                    }
                    Checkbox(
                        checked = check,
                        onCheckedChange = null,
                        modifier = Modifier.padding(top = 14.dp)
                    )
                }


            }
        }
            item {
                Row(modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)) {
                    var text by remember { mutableStateOf("Title") }
                    TextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { ("Title") },
                        modifier = Modifier.width(200.dp).height(50.dp),


                        )
                    Button(onClick = {

                        val nextid = (viewModel.tasks.maxOfOrNull { it.id } ?: 0) + 1
                        val newTask = Task(
                            id = nextid,
                            title = "${text} ${nextid}",
                            description = "added a new task via button",
                            priority = (1..5).random(),
                            dueDate = "2026-1-6",
                            done = false,
                        )

                        viewModel.addTask(newTask)
                        println("id" + nextid)
                    }) { Text(text = "add task") }
                }
            }
            }

        }


}





