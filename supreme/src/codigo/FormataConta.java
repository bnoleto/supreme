package codigo;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author rafael
 */
public class FormataConta {
    
    private static String data;
    private static String hora;
    public static String cpf;
    private String valor;
    private String itens;
    private static String contaformatada;
    private static String contafinal;
    
    public FormataConta(double v, String i){
        //Inicia os atributos de itens e valor (ja formatado em reais), e tambem a conta formatada para exibiçao.
        BigDecimal vt = new BigDecimal(v);
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        this.valor = "\nValor Total: "+nf.format(vt);
        this.itens = i;
        contaformatada = this.itens + "\n-------------------------------------"+this.valor;
    }

    public static String getContaFormatada() {
        return contaformatada;
    }  

    public static String getContafinal() {
        return contafinal;
    }

    public static void setContafinal() {
        //Formata a conta que sera gravada no arquivo, com data, hora, cpf, itens e valor final.
        Date d = Calendar.getInstance().getTime();
        SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm:ss");
	System.out.println("Data formatada: "+sdfD.format(data));
        data = sdfD.format(d);
        hora = sdfH.format(d);
        if (cpf == null) { //Se o cpf nao foi informado
            contafinal = "-------------CUPOM FISCAL------------\nData: "+data+"\nHora do fechamento da conta: "+hora+"\nCPF do contribuinte: Não informado\n\n"+contaformatada;
        }else{// Se o cpf foi informado
            contafinal = "-------------CUPOM FISCAL------------\nData: "+data+"\nHora do fechamento da conta: "+hora+"\nCPF do contribuinte: "+cpf+"\n\n"+contaformatada;
        }        
    }
}