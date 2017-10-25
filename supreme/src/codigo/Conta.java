package codigo;
/**
 *
 * @author rafael
 */
public class Conta {

    private static double totalConta;
    private static String txtconta;

    public void iniciaConta(){ //Inicia a String txtconta para não aparecer o texto "null" na tela Principal
        txtconta  = "Mesa: "+telas.Mesa.numMesa+"\nItens:    Preço:      Qtde:\n-------------------------------------";
        FormataConta f = new FormataConta(totalConta, txtconta);
    }
    
    public double getTotalConta() {
        return totalConta;
    }
    
    public void setTotalConta(double t) {
        totalConta += t;
    }  

    public String getTxtconta() {
        return txtconta;
    }

    public void setTxtconta(String txt) {
        txtconta += "\n"+txt;
    }
    
    public void Formata(){//chama o método que formata a conta para exibição
        FormataConta f = new FormataConta(totalConta, txtconta);
    }   
}
