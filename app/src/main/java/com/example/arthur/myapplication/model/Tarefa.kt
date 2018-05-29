package com.example.arthur.myapplication.model

import java.io.Serializable

data class Tarefa(var nome: String, var descricao: String, var dataInicio: String, var dataFim: String, var Status: Boolean): Serializable{
    override fun toString(): String {
        var aux: String = ""
        if(Status){
            aux = "Tarefa Realizada"
        }
        if(!Status){
            aux = "Tarefa Nao Realizada"
        }

        return "$nome " +
                "\nData: $dataInicio - $dataFim " +
                "\nDescriçao: $descricao" +
                "\nStatus: $aux"

    }
}