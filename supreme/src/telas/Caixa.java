package telas;

import java.awt.Color;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Rafael
 */
public class Caixa extends javax.swing.JFrame {
    private String codigo, mesa, data, hora, valor, cpf; //Dados da conta selecionada
    private codigo.Conexao conn = new codigo.Conexao(); //conexao com o banco de dados
    private ArrayList<ArrayList<String>> infoItens = new ArrayList(); //guarda as informações de cada item de cada pedido
    private String stringItens; //string final dos itens da conta
    private ArrayList<ArrayList<String>> tabelaContas = new ArrayList(); //Armazena as informações mostradas na tabela
    private NumberFormat nf = NumberFormat.getCurrencyInstance(); //Formata valor na moeda do sistema
    
    public Caixa() {
        initComponents();
        fillTable();
    }

    //Função que preenche a tabela da tela
    public void fillTable(){
        //Loga no banco
        conn.conectar("test", "12345".toCharArray()); //troque ou crie este usuário para testar//
        //Comandos SQL para pegar as contas 
        conn.comando_sql("USE bdsupreme2;");	
        tabelaContas = conn.retornar_query(
            "SELECT conta_codigo, conta_mesa, conta_valor, conta_data, conta_hora, conta_cpf "
            + "FROM t_contas WHERE conta_status LIKE 'FECHADO';"
        );
        //model e rowsorter da tabela
        DefaultTableModel model = (DefaultTableModel) tableContas.getModel();
        tableContas.setRowSorter(new TableRowSorter(model));
        
        //Adiciona os dados à tabela, criando uma linha para cada conta
        //com seus respectivos dados em suas respectivas linhas
        for(ArrayList<String> ars: tabelaContas){ 
            model.addRow(new Object[]{ ars.get(0), ars.get(1), nf.format(Double.parseDouble(ars.get(2))) });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Principal = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableContas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        valorRecebido = new javax.swing.JTextField();
        troco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        valorConta = new javax.swing.JTextField();
        finaliza = new javax.swing.JButton();
        fechaConta = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        mostraConta = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        rodape = new javax.swing.JLabel();
        valorInsuficiente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SUPREME - Caixa");

        Principal.setBackground(new java.awt.Color(255, 255, 255));

        tableContas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tableContas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Mesa", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableContas.setAutoscrolls(false);
        tableContas.setFillsViewportHeight(true);
        tableContas.setRowHeight(20);
        tableContas.setSelectionBackground(new java.awt.Color(0, 153, 0));
        tableContas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableContas.getTableHeader().setReorderingAllowed(false);
        tableContas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableContas);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Valor Recebido:");

        valorRecebido.setEditable(false);
        valorRecebido.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        valorRecebido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorRecebidoFocusLost(evt);
            }
        });

        troco.setEditable(false);
        troco.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Troco:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Valor da Conta:");

        valorConta.setEditable(false);
        valorConta.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        finaliza.setBackground(new java.awt.Color(51, 255, 51));
        finaliza.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        finaliza.setText("Finalizar");
        finaliza.setEnabled(false);
        finaliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizaActionPerformed(evt);
            }
        });

        fechaConta.setBackground(new java.awt.Color(255, 255, 255));
        fechaConta.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        fechaConta.setText("Fechar Conta");
        fechaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaContaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Contas Finalizadas:");

        mostraConta.setEditable(false);
        mostraConta.setBackground(new java.awt.Color(255, 253, 219));
        mostraConta.setColumns(20);
        mostraConta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        mostraConta.setRows(5);
        mostraConta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        mostraConta.setEnabled(false);
        jScrollPane2.setViewportView(mostraConta);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Resumo da conta:");

        titulo.setBackground(new java.awt.Color(0, 153, 153));
        titulo.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Caixa");
        titulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        titulo.setOpaque(true);

        rodape.setBackground(new java.awt.Color(0, 153, 153));
        rodape.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rodape.setForeground(new java.awt.Color(255, 255, 255));
        rodape.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        rodape.setText("Copyright © S.U.P.R.E.M.E ");
        rodape.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        rodape.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        rodape.setOpaque(true);

        valorInsuficiente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        valorInsuficiente.setForeground(new java.awt.Color(255, 0, 0));
        valorInsuficiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorInsuficiente.setText("Valor Recebido é insuficiente!");

        javax.swing.GroupLayout PrincipalLayout = new javax.swing.GroupLayout(Principal);
        Principal.setLayout(PrincipalLayout);
        PrincipalLayout.setHorizontalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(PrincipalLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(fechaConta, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                        .addGap(70, 70, 70))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PrincipalLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(finaliza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PrincipalLayout.createSequentialGroup()
                        .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(valorInsuficiente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valorConta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valorRecebido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(troco, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))))
            .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rodape, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PrincipalLayout.setVerticalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorConta)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorRecebido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorInsuficiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(troco)
                        .addGap(45, 45, 45)
                        .addComponent(finaliza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(fechaConta, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addComponent(rodape, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        valorInsuficiente.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fechaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaContaActionPerformed
        //Se alguma conta estiver selecionada
        if(tableContas.getSelectedRow()!= -1){
            tableContas.setEnabled(false); //Impede a alteração da seleção após o clique
            fechaConta.setEnabled(false); //Impede que o botão seja clicado novamente
            setContaInfo(); //Inicializa variáveis com informações da conta 

            //libera e preenche os campos à direita
            mostraConta.setEnabled(true);
            valorConta.setText(valor);
            valorRecebido.setEnabled(true);
            valorRecebido.setEditable(true);
            troco.setEnabled(true);
        }
    }//GEN-LAST:event_fechaContaActionPerformed

    private void finalizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizaActionPerformed
        //Muda status da conta no BD
        conn.comando_sql("UPDATE t_contas SET conta_status = 'FINALIZADO' WHERE conta_codigo = "+codigo+";");
        //Remove Linha da conta da tabela de contas
        ((DefaultTableModel)tableContas.getModel()).removeRow(tableContas.getSelectedRow());
    }//GEN-LAST:event_finalizaActionPerformed

    private void tableContasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContasMouseClicked
        setContaInfo(); //Inicializa variáveis com informações da conta selecionada
        mostraConta.setText(formataContaFinal());
    }//GEN-LAST:event_tableContasMouseClicked

    //Após o valor recebido ser informado
    private void valorRecebidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorRecebidoFocusLost
        int indice = tableContas.getSelectedRow();
        double vAux = Double.parseDouble(tabelaContas.get(indice).get(2));
        double vr = Double.parseDouble(valorRecebido.getText());
        double tAux = vr-vAux;
        //Se valor recebido for maior que o valor da conta
        if(vAux<=vr){
            //Caso ja tenha sido mudado para true, volta a ser false
            valorInsuficiente.setVisible(false);
            //Printa o valor recebido formatado no campo
            valorRecebido.setText(nf.format(vr));
            //Impede a edição do valor após o mesmo ser maior ou igual ao valor da conta
            valorRecebido.setEditable(false);
            //Printa o valor do troco formatado no campo
            troco.setText(nf.format(tAux));
            //Libera o botão Finalizar
            finaliza.setEnabled(true);
        }else{ //Se não
            valorInsuficiente.setVisible(true);
        }
        
        
    }//GEN-LAST:event_valorRecebidoFocusLost
    
    //Inicializa as variáveis da conta selecionada com os valores recebidos do banco
    private void setContaInfo(){
        int indice = tableContas.getSelectedRow();
        if(indice != -1){
            double vAux = Double.parseDouble(tabelaContas.get(indice).get(2));
            //Inicializa variáveis de coluna
            codigo = tabelaContas.get(indice).get(0);
            mesa = tabelaContas.get(indice).get(1);
            valor = nf.format(vAux);
            data = tabelaContas.get(indice).get(3);
            hora = tabelaContas.get(indice).get(4);
            cpf = tabelaContas.get(indice).get(5);

            //Inicializa a lista de itens
            ArrayList<ArrayList<String>> codItensPedido;  //Armazena os codigos dos itens de cada pedido 
            ArrayList<ArrayList<String>> codPedidosConta; //Armazena os codigos dos pedidos referentes à conta
            ArrayList<ArrayList<String>> Itens;  //Armazena os codigos dos itens de cada pedido 
            infoItens.removeAll(infoItens); //Reset dos itens

            //SELECTS necessários para obtenção dos dados
            codPedidosConta = conn.retornar_query("SELECT t_pedidos_ped_codigo FROM t_pedidos_contas "
                                                + "WHERE t_contas_conta_codigo LIKE '"+codigo+"';");
            for(ArrayList<String> cods: codPedidosConta){
                codItensPedido = conn.retornar_query("SELECT itm_codigo, itm_qtde FROM t_pedido_itens "
                                                    + "WHERE ped_codigo LIKE '"+cods.get(0)+"';");
                for(ArrayList<String> itms: codItensPedido){
                    Itens = conn.retornar_query("SELECT itm_nome, itm_valor FROM t_itens "
                                                + "WHERE itm_codigo LIKE "+itms.get(0)+";");
                    for(int i=0; i<Itens.size(); i++){
                        ArrayList<String> aux = new ArrayList();
                        aux.add(Itens.get(i).get(0)); //nome do item
                        aux.add(codItensPedido.get(i).get(1)); // qtde do mesmo item
                        aux.add(Itens.get(i).get(1)); //valor do item
                        infoItens.add(aux); //Add to itens
                    }
                }
            }
            //Formatação dos itens em String para amostragem
            stringItens = ""; //reseta e impede de imprimir 'null' no começo
            for(ArrayList<String> ar: infoItens){
                stringItens+="\n"+ar.get(0)+"\t"+ar.get(1)+"\t"+nf.format(Double.parseDouble(ar.get(2)));
            }
        }
    }
    
    private void getDataEHora(){
        //Adquire data e hora do sistema
        Date d = Calendar.getInstance().getTime();
        SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm:ss");
        data = sdfD.format(d);
        hora = sdfH.format(d);
        //Fim data e hora
    }
    
    private String formataContaFinal(){
        String ContaFinal = "";
        String CF = "Item\t\tQtde.\tValor"
                +"\n---------------------------------------------------------------"+stringItens 
                + "\n---------------------------------------------------------------"+"\nValor Total: "+valor;
        
        if (cpf == null) { //Se o cpf nao foi informado
            ContaFinal = "----------------------CUPOM FISCAL----------------------"
                    + "\nData: "+data+"\nHora do fechamento da conta: "+hora+""
                    + "\nCPF do contribuinte: Não informado\n\n"+CF;
        }else{// Se o cpf foi informado
            ContaFinal = "----------------------CUPOM FISCAL----------------------"
                    + "\nData: "+data+"\nHora do fechamento da conta: "+hora+""
                    + "\nCPF do contribuinte: "+cpf+"\n\n"+CF;
        }  
        return ContaFinal;
    }
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Principal;
    private javax.swing.JButton fechaConta;
    private javax.swing.JButton finaliza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea mostraConta;
    private javax.swing.JLabel rodape;
    private javax.swing.JTable tableContas;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField troco;
    private javax.swing.JTextField valorConta;
    private javax.swing.JLabel valorInsuficiente;
    private javax.swing.JTextField valorRecebido;
    // End of variables declaration//GEN-END:variables
}
