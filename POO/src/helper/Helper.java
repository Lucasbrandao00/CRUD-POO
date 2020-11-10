package helper;

import modal.Aluno;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Helper {
    private final String caminho = "alunos.csv";
    private final String spr = ",";
    private static Helper instancia = null;

    public static Helper getInstance(){

        if (instancia == null)
            instancia = new Helper();
        return instancia;
    }

    public void salvarCSV(Aluno aluno){
        StringBuilder builder = new StringBuilder();
        builder.append(aluno.getName())
                .append(spr)
                .append(aluno.getCpf())
                .append(spr)
                .append(aluno.getCurso())
                .append(spr)
                .append(aluno.getMatricula());

        try {
            FileWriter fileWriter = new FileWriter(caminho, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(builder.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }

    public String lerCSV(){
        File file = new File(caminho);

        try {
            return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (FileNotFoundException exception){
            return null;
        } catch (IOException exception){
            exception.printStackTrace();
        }
        return null;
    }

    public Boolean apagarCSV(){
        File file = new File(caminho);
        return file.delete();
        
        //Não conseguir fazer o UPDATE :( //
    }
}
