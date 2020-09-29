package com.company;

public interface interAluno {
   Aluno criarAluno();     //C REATE
   Aluno recuperarAluno(String cpf);         //R EAD
   void atuzalizarAluno(Aluno aluno);        //U PDATE
   Boolean deletarAluno(String cpf);            //D ELETE
}
