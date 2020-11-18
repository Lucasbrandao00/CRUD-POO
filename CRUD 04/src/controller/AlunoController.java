package controller;

import helper.HelperDB;
import modal.Aluno;

import  java.util.ArrayList ;
import  java.util.List ;
import  java.util.Scanner ;


public class AlunoController implements interAluno {

    // Lista de Alunos
     private List<Aluno> alunos =  new  ArrayList<Aluno> ();

    @Override
    public String criarAluno(Aluno aluno) {

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
        HelperDB helperDB = HelperDB.getInstance();
        return null;
    }

    @Override
    public String recuperarAluno(String cpf) {

        HelperDB helperDB = HelperDB.getInstance();
        return helperDB.buscaAluno(cpf);
    }

    @Override
    public String atualizarAluno(Aluno aluno) {

        for (Aluno item : alunos){
            if (aluno.getCpf().equals(item.getCpf())){
                item.setName(aluno.getName());
                item.setCurso(aluno.getCurso());
            }
        }
        return null;
    }

    @Override
    public boolean deletarAluno(String cpf) {

        HelperDB helperDB = HelperDB.getInstance();
        return helperDB.deletarAluno(cpf);

    }
}
