package com.example.arthur.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.arthur.myapplication.model.Tarefa
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val listTarefas: MutableList<Tarefa> by lazy{ mutableListOf<Tarefa>()}
    private var adapter: ArrayAdapter<Tarefa>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_NovaTarefa.setOnClickListener{
            val intent = Intent(this, NovaTarefaActivity::class.java)
            startActivityForResult(intent, 0)
        }

        ListView_Tarefas.setOnItemClickListener { parent, view, position, id ->
            NOME = listTarefas[position].nome
            DESCRICAO = listTarefas[position].descricao
            DATA_INICIO = listTarefas[position].dataInicio
            DATA_FIM = listTarefas[position].dataFim

            listTarefas.removeAt(position)
            adapter?.notifyDataSetChanged()

            val intent = Intent(this, EditarTarefaActivity::class.java)
            startActivityForResult(intent, 0)
        }

        adapter = ArrayAdapter<Tarefa>(this, android.R.layout.simple_list_item_1, listTarefas)
        ListView_Tarefas.adapter = adapter

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 0 && resultCode == RESULT_OK){
            val tarefa = data?.getSerializableExtra("tarefa") as? Tarefa

            if(tarefa != null) {
                listTarefas.add(tarefa)
                adapter?.notifyDataSetChanged()
            }
        }
    }

    companion object {
        var NOME: String?= null
        var DESCRICAO: String?= null
        var DATA_INICIO: String?= null
        var DATA_FIM: String?= null
    }

}
