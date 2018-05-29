package com.example.arthur.myapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.arthur.myapplication.model.Tarefa
import kotlinx.android.synthetic.main.activity_nova_tarefa.*

class NovaTarefaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_tarefa)

        button_Enviar.setOnClickListener{
            val nome = editText_Nome.text.toString()
            val descricao = editText_Descricao.text.toString()
            val datainicio = editText_DataInicio.text.toString()
            val datafim = editText_DataFim.text.toString()
            val tarefa = Tarefa(nome, descricao, datainicio, datafim, false)
            val intent = Intent()
            intent.putExtra("tarefa", tarefa)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

}
