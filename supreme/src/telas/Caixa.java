package telas;

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
public class Caixa extends javax.swing.JFrame{
    private String codigo, mesa, data, hora, valor, cpf; //Dados da conta selecionada
    private codigo.Conexao conn = new codigo.Conexao(); //conexao com o banco de dados
    private ArrayList<ArrayList<String>> infoItens = new ArrayList(); //guarda as informações de cada item de cada pedido
    private String stringItens; //string final dos itens da conta
    private ArrayList<ArrayList<String>> tabelaContas = new ArrayList(); //Armazena as informações mostradas na tabela
    private NumberFormat nf = NumberFormat.getCurrencyInstance(); //Formata valor na moeda do sistema
    private DefaultTableModel model;
    
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
        model = (DefaultTableModel) tableContas.getModel();
        //reset da tabela
        model.setRowCount(0);
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

        Dialog = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        textoDialogo = new javax.swing.JLabel();
        dialogButton = new javax.swing.JButton();
        Principal = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableContas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
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
        valorRecebido = new javax.swing.JTextField();

        Dialog.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Dialog.setTitle("S.U.P.R.E.M.E Dialog");
        Dialog.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Dialog.setMinimumSize(new java.awt.Dimension(421, 183));
        Dialog.setModal(true);
        Dialog.setResizable(false);
        Dialog.setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("Clique em OK para fechar.");

        textoDialogo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        textoDialogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoDialogo.setText("Texto Dialogo");

        dialogButton.setBackground(new java.awt.Color(0, 153, 153));
        dialogButton.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        dialogButton.setForeground(new java.awt.Color(255, 255, 255));
        dialogButton.setText("OK");
        dialogButton.setToolTipText("Clique para continuar.");
        dialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textoDialogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(dialogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(textoDialogo)
                .addGap(26, 26, 26)
                .addComponent(dialogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DialogLayout = new javax.swing.GroupLayout(Dialog.getContentPane());
        Dialog.getContentPane().setLayout(DialogLayout);
        DialogLayout.setHorizontalGroup(
            DialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        DialogLayout.setVerticalGroup(
            DialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Dialog.setLocationRelativeTo(Principal);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SUPREME - Caixa");
        setMinimumSize(new java.awt.Dimension(800, 587));

        Principal.setBackground(new java.awt.Color(255, 255, 255));
        Principal.setMinimumSize(new java.awt.Dimension(800, 587));

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
        tableContas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableContas.setFillsViewportHeight(true);
        tableContas.setRowHeight(20);
        tableContas.setSelectionBackground(new java.awt.Color(0, 153, 0));
        tableContas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableContas.getTableHeader().setReorderingAllowed(false);
        tableContas.setUpdateSelectionOnSort(false);
        tableContas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableContas);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Valor Recebido:");

        troco.setEditable(false);
        troco.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        troco.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Troco:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Valor da Conta:");

        valorConta.setEditable(false);
        valorConta.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        valorConta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        finaliza.setBackground(new java.awt.Color(0, 153, 153));
        finaliza.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        finaliza.setForeground(new java.awt.Color(255, 255, 255));
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
        fechaConta.setEnabled(false);
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

        valorRecebido.setEditable(false);
        valorRecebido.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        valorRecebido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                valorRecebidoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                valorRecebidoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout PrincipalLayout = new javax.swing.GroupLayout(Principal);
        Principal.setLayout(PrincipalLayout);
        PrincipalLayout.setHorizontalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PrincipalLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(fechaConta, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                        .addGap(65, 65, 65)))
                .addGap(36, 36, 36)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(valorInsuficiente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valorConta, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(troco, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valorRecebido, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(finaliza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
            .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rodape, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PrincipalLayout.setVerticalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(valorInsuficiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(troco)
                        .addGap(45, 45, 45)
                        .addComponent(finaliza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(fechaConta, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addComponent(rodape)
                .addGap(0, 0, 0))
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
        //Abre dialogo
        textoDialogo.setText("Transação finalizada com sucesso!");
        Dialog.setVisible(true);
        //Volta enabled na tabela
        tableContas.setEnabled(true);
        //Limpa campos de texto
        valorRecebido.setText("");
        valorConta.setText("");
        troco.setText("");
        mostraConta.setText("");
        //bloqueia ações impróprias
        fechaConta.setEnabled(false);
        mostraConta.setEnabled(false);
        finaliza.setEnabled(false);
    }//GEN-LAST:event_finalizaActionPerformed

    private void tableContasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContasMouseClicked
        if(tableContas.getSelectedRow() != -1){
            setContaInfo(); //Inicializa variáveis com informações da conta selecionada
            mostraConta.setText(formataContaFinal());
            if(!mostraConta.isEnabled()){
                fechaConta.setEnabled(true);
            }
        }
    }//GEN-LAST:event_tableContasMouseClicked

    private void valorRecebidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorRecebidoKeyPressed
        
    }//GEN-LAST:event_valorRecebidoKeyPressed

    private void valorRecebidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorRecebidoKeyReleased
        int indice = tableContas.getSelectedRow();

        double vConta = Double.parseDouble(tabelaContas.get(indice).get(2));
        double vr = Double.parseDouble(valorRecebido.getText());
        double tAux = vr-vConta;
        //Se valor recebido for maior que o valor da conta
        if(vr>=vConta){
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
    }//GEN-LAST:event_valorRecebidoKeyReleased

    private void dialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogButtonActionPerformed
        Dialog.dispose();
    }//GEN-LAST:event_dialogButtonActionPerformed
    
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
                for(int i = 0; i<codItensPedido.size(); i++){
                    Itens = conn.retornar_query("SELECT itm_nome, itm_valor FROM t_itens "
                                                + "WHERE itm_codigo LIKE "+codItensPedido.get(i).get(0)+";");
                    for(int j=0; j<Itens.size(); j++){
                        ArrayList<String> aux = new ArrayList();
                        aux.add(Itens.get(j).get(0)); //nome do item
                        aux.add(codItensPedido.get(i).get(1)); // qtde do mesmo item
                        aux.add(Itens.get(j).get(1)); //valor do item
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
                + "\n---------------------------------------------------------------"+"\nValor Total: "+valor
                +"\n\nVolte sempre!\nS.U.P.R.E.M.E.™ "
                + "\n---------------------------------------------------------------";
        
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
    private javax.swing.JDialog Dialog;
    private javax.swing.JPanel Principal;
    private javax.swing.JButton dialogButton;
    private javax.swing.JButton fechaConta;
    private javax.swing.JButton finaliza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea mostraConta;
    private javax.swing.JLabel rodape;
    private javax.swing.JTable tableContas;
    private javax.swing.JLabel textoDialogo;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField troco;
    private javax.swing.JTextField valorConta;
    private javax.swing.JLabel valorInsuficiente;
    private javax.swing.JTextField valorRecebido;
    // End of variables declaration//GEN-END:variables
}
