package com.example.arthur.myapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Switch
import com.example.arthur.myapplication.model.Tarefa
import kotlinx.android.synthetic.main.activity_editar_tarefa.*

class EditarTarefaActivity : AppCompatActivity() {

    private var tarefa: Tarefa? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_tarefa)

        editText_Nome.setText(MainActivity.NOME)
        editText_Descricao.setText(MainActivity.DESCRICAO)
        editText_DataInicio.setText(MainActivity.DATA_INICIO)
        editText_DataFim.setText(MainActivity.DATA_FIM)

        button_Editar.setOnClickListener{
            val nome = editText_Nome.text.toString()
            val descricao = editText_Descricao.text.toString()
            val datainicio = editText_DataInicio.text.toString()
            val datafim = editText_DataFim.text.toString()
            val status = switch_tarefa.isChecked


            tarefa = Tarefa(nome, descricao, datainicio, datafim, status)

            val intent = Intent()
            intent.putExtra("tarefa", tarefa)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        button_Deletar.setOnClickListener{

            val intent = Intent()
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }

}
