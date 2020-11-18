package controller;

import modal.Aluno;

public interface interAluno {
   String  criarAluno(Aluno aluno);           //C REATE
   String recuperarAluno(String cpf);         //R EAD
   String atualizarAluno(Aluno aluno);        //U PDATE
   boolean deletarAluno(String cpf);           //D ELETE
}
