package ZIP;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compactador {
    static final int tamanhoBuffer=4096;

    public static void compactarZip(String arqSaida, String arqEntrada)throws IOException{
        int cont;
        byte[] dados=new byte[tamanhoBuffer];

        BufferedInputStream origem=null;
        FileInputStream streamEntrada=null;
        FileOutputStream destino=null;
        ZipOutputStream saida=null;
        ZipEntry entry=null;

        try {
            destino=new FileOutputStream(new File(arqSaida));
            saida=new ZipOutputStream(new BufferedOutputStream(destino));
            File file=new File(arqEntrada);
            streamEntrada=new FileInputStream(file);
            origem=new BufferedInputStream(streamEntrada,tamanhoBuffer);
            entry=new ZipEntry(file.getName());
            saida.putNextEntry(entry);

            while ((cont=origem.read(dados,0,tamanhoBuffer))!=-1){
                saida.write(dados,0,cont);
            }
            origem.close();
            saida.close();

        }catch (IOException e){
            throw new IOException(e.getMessage());
        }
    }
}
