package controller;

import helper.Helper;
import modal.Aluno;

import java.io.File;
import java.io.FileInputStream;
import  java.util.ArrayList ;
import  java.util.List ;
import  java.util.Scanner ;


public class AlunoController implements interAluno {

    // Lista de Alunos
     private List<Aluno> alunos =  new  ArrayList<Aluno> ();

    @Override
    public void criarAluno(Aluno aluno) {

        //UTILIZANDO O SCANNER PARA EMTRADA DE DADOS
        Scanner scanner =  new   Scanner (System.in);

        System. out . println("Informe o CPF:");
        aluno.setCpf(scanner. nextLine ());
        System. out . println("Informe o nome:");
        aluno.setName (scanner. nextLine ());
        System. out . println("Informe o curso:");
        aluno.setCurso(scanner. nextLine ());
        aluno.setMatricula (10);


        //Adicionando o aluno na lista
        Helper helper = Helper.getInstance();
        helper.salvarCSV(aluno);


    }

    @Override
    public String recuperarAluno(String cpf) {

        Helper helper = Helper.getInstance();
        return helper.lerCSV();
    }

    @Override
    public void atualizarAluno(Aluno aluno) {

        for (Aluno item : alunos){
            if (aluno.getCpf().equals(item.getCpf())){
                item.setName(aluno.getName());
                item.setCurso(aluno.getCurso());
            }
        }
    }

    @Override
    public Boolean deletarAluno(Aluno aluno) {

        Helper helper = Helper.getInstance();
        return helper.apagarCSV();
    }
}
