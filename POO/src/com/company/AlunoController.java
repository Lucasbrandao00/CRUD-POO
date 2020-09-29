package com.company;

import  java.util.ArrayList ;
import  java.util.List ;
import  java.util.Scanner ;


public class AlunoController implements interAluno{

    // Lista de Alunos
     private List<Aluno> alunos =  new  ArrayList<Aluno> ();

    @Override
    public Aluno criarAluno() {

        Aluno aluno =  new   Aluno ();

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
        alunos.add(aluno);

        return aluno;
    }

    @Override
    public Aluno recuperarAluno(String cpf) {

        for (Aluno aluno : alunos){
            if (cpf.equals(aluno.getCpf())){
                return aluno;
            }
        }

        return null;
    }

    @Override
    public void atuzalizarAluno(Aluno aluno) {

        for (Aluno item : alunos){
            if (aluno.getCpf().equals(item.getCpf())){
                item.setName(aluno.getName());
                item.setCurso(aluno.getCurso());
            }
        }
    }

    @Override
    public Boolean deletarAluno(String cpf) {

        Aluno alunoRecuperado = recuperarAluno(cpf);
        if (alunoRecuperado != null){
            alunos.remove(alunoRecuperado);
            return true;

        }
        return false;
    }

    private void salvarEntidade(Aluno aluno) {
        alunos.add(aluno);
    }

}
