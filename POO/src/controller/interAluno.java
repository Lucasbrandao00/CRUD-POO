package controller;

import modal.Aluno;

public interface interAluno {
   void  criarAluno(Aluno aluno);                        //C REATE
   String recuperarAluno(String cpf);         //R EAD
   void atualizarAluno(Aluno aluno);        //U PDATE
   Boolean deletarAluno(Aluno aluno);         //D ELETE
}
