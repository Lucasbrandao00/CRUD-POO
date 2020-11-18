package modal;

import java.time.LocalDateTime;
import java.util.Random;

public class Aluno {

    private String cpf;
    private String name;
    private String matricula;
    private String curso;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(int semestre) {

        LocalDateTime data = LocalDateTime.now();

        //Criando o ano
        int ano = data.getYear();

        //Criando o mês
        int mes = data.getMonthValue();

        //Criando o dia
        int dia = data.getDayOfMonth();

        //Criando a hora
        int hora = data.getHour();

        //Criando minuto
        int minuto = data.getMinute();

        //Criando segundos
        int segundos = data.getSecond();

        //Gerando uma matricula aleatória
        Random random = new Random();
        int codigo = random.nextInt(100);

        //Imprimindo YYYYMMDDhhmmss-RR-SS//

        System.out.printf("\nMatricula gerada dia: %d/%d/%d",dia, mes, ano);
        System.out.printf("\n%d%d%d%d%d%d|%d|%d",ano,mes,dia,hora,minuto,segundos, codigo, semestre);
        System.out.printf("\n%d: Ano ", ano);
        System.out.printf("\n%d: Mes ", mes);
        System.out.printf("\n%d: Dia ", dia );
        System.out.printf("\n%d: Hora ", hora );
        System.out.printf("\n%d: Minuto ", minuto );
        System.out.printf("\n%d: Segundos ", segundos );
        System.out.printf("\n%d: Código ", codigo );
        System.out.printf("\n%d: Semestre ", semestre );


    }

    public String getCurso() {

        return curso;
    }

    public void setCurso(String curso) {

        this.curso = curso;
    }

    public String getNome() {
        return null;
    }
}