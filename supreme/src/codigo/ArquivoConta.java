package codigo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author rafael
 */
public class ArquivoConta {
    private static String conta;
    private String mesa;
    private String data;
    private String hora;
    private static String nomearquivo;
    private static Calendar c = Calendar.getInstance();
    private static Date d = c.getTime();
    
    public ArquivoConta(){
        //Inicia alguns dos atributos da classe
        this.mesa = "Mesa "+telas.Mesa.numMesa;
        this.data = DateFormat.getDateInstance(DateFormat.FULL).format(d);
        this.hora = DateFormat.getTimeInstance().format(d);
        nomearquivo = this.mesa+" ("+this.data+" "+this.hora+")";
    }
    
    public static void CriaArquivo(){
//        FormataConta.setContafinal(); //Formata a conta para a ficha final
//        conta = FormataConta.getContafinal(); //Pega a conta formatada
        try{
            File arq = new File("BDContas/"+nomearquivo+".txt"); //Cria arquivo, se já existir, será sobreescrito
            FileWriter fw = new FileWriter(arq); 
            BufferedWriter bw = new BufferedWriter(fw);  
            bw.write(conta); //Reescreve a conta atualizada no arquivo
            bw.flush();  
            bw.close(); //Fecha para salvar
        } catch (IOException ex) {}   
    }
}
