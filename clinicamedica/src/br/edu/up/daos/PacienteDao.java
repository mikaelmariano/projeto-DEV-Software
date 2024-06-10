package br.edu.up.daos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import br.edu.up.modelos.Paciente;

public class PacienteDao {
    
    private static String Header = "nome;telefone;email;endereco;cpf;sus;";

    private static String FileName = "/home/joaotrevoso/teste/Paciente.csv";

    public static void IncluirPacienteArquivo(Paciente pessoa){

        var arquivo = new File(FileName);

        try{
        
            if(arquivo.exists()){
            
                var writer = new FileWriter(arquivo,true);
                writer.flush();

                BufferedWriter bw = new BufferedWriter(writer);
                bw.newLine();
                bw.write(pessoa.toCSV());  
            bw.close();

        }else{

            arquivo.createNewFile();
            var writer = new FileWriter(arquivo,true);
            writer.flush();

            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(Header);
            bw.newLine();
            bw.write(pessoa.toCSV());  
        bw.close();
            
        }

        }catch(Exception ex){

           System.out.println("Erro ao gravar no Arquivo");

        }
    }

    public static ArrayList<Paciente> MostrarPacientes(){

        ArrayList<Paciente> Pacientes = new ArrayList<>();

        var arquivo = new File(FileName);

        try{
        
            if(arquivo.exists()){
            
                var reader = new Scanner(arquivo);

                reader.useDelimiter(";");

                while(reader.hasNext()){

                    var a = reader.nextLine();

                }

        }else{

            throw new FileNotFoundException("Arquivo inexistente");
            
        }

        }catch(Exception ex){

           System.out.println(ex.getMessage());

        }

        return null;

    }

}
