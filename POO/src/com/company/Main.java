package com.company;

public class Main {

    public static void main(String[] args) {

        AlunoController alunoController = new AlunoController();

        alunoController.criarAluno();

        Aluno aluno = new Aluno();
        aluno.setCurso("SIS DE INFO");
        aluno.setName("Lucas Brandão");
        aluno.setCpf("05582731148");

       /* System.out.println("\nA matricula gerada é: " + aluno.getMatricula()); */

        //Alterar nome do aluno
        aluno.setName("Lucas atualizado");

        alunoController.atuzalizarAluno(aluno);
        if (aluno == null){
            System.out.println("Aluno não encontrado");
        }else {
            System.out.println("Aluno atualizado: "+ aluno.getName());
        }

        //Deletando o aluno
        Boolean deletou = alunoController.deletarAluno(aluno.getCpf());
        if (deletou){
            System.out.println("Aluno deletado!");
        }else {
            System.out.println("Aluno não encontrado :");
        }
    }
}

