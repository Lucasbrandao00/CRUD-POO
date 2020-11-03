package teste;

import controller.AlunoController;
import modal.Aluno;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int quantidadeAlunos;
        String opMenu, quantidade, contador;

        Aluno aluno = new Aluno();
        Scanner scanner = new Scanner(System.in);
        AlunoController alunoController = new AlunoController();

        do {
            System.out.println("==Digite 1 para adicionar novo aluno==");
            System.out.println("==Digite 2 para recuperar aluno==");
            System.out.println("==Digite 3 para atualizar aluno==");
            System.out.println("==Digite 4 para deletar aluno==");
            System.out.println("==Digite 0 para Sair==");
            opMenu = scanner.nextLine();

            switch (opMenu) {
                case "0":
                    System.out.println("Default");
                    break;
                case "1":
                    System.out.println("Quantos alunos deseja adicionar?");
                    quantidade = scanner.nextLine();
                    quantidadeAlunos = Integer.parseInt(quantidade);

                    for (int i = 0; i < quantidadeAlunos; i++) {
                        Aluno nAluno = new Aluno();

                        System.out.println("Nome do Aluno: ");
                        nAluno.setName(scanner.nextLine());
                        System.out.println("CPF do Aluno: ");
                        nAluno.setCpf(scanner.nextLine());
                        System.out.println("Curso do Aluno: ");
                        nAluno.setCurso(scanner.nextLine());

                        alunoController.criarAluno(nAluno);
                    }
                    break;
                case "2":
                    contador = alunoController.recuperarAluno(aluno.getCpf());
                    if (contador != null) {
                        System.out.println("Arquivo encontrado com sucesso:");
                        System.out.println(contador);
                    } else
                        System.out.println("O arquivo não existe");
                    break;
                case "3":
                    if (alunoController.recuperarAluno(aluno.getCpf()) != null) {
                        alunoController.deletarAluno(aluno);

                        System.out.println("Quantos alunos deseja adicionar?");
                        quantidade = scanner.nextLine();
                        quantidadeAlunos = Integer.parseInt(quantidade);

                        for (int i = 0; i < quantidadeAlunos; i++) {
                            aluno = new Aluno();

                            System.out.println("Informe o Nome: ");
                            aluno.setName(scanner.nextLine());
                            System.out.println("Informe o CPF: ");
                            aluno.setCpf(scanner.nextLine());
                            System.out.println("Informe o Curso: ");
                            aluno.setCurso(scanner.nextLine());
                            alunoController.atualizarAluno(aluno);
                            System.out.println("O aluno foi adicionado com sucesso");
                        }
                        System.out.println("Arquivo alunos foi alterado.");
                    } else
                        System.out.println("O arquivo não existe!");
                    break;
                case "4":
                    if (alunoController.deletarAluno(aluno))
                        System.out.println("Arquivo alunos foi deletado;.");
                    else
                        System.out.println("O arquivo não existe");
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        } while (!opMenu.equals("0"));
    }
}


