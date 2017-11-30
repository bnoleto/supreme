package telas;

import codigo.Conexao;
import java.awt.Color;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Caixa extends javax.swing.JFrame{
    //private String codigo, valor, cpf; //Dados da conta selecionada
    private codigo.Conexao conn = null; //conexao com o banco de dados
    private int selecionado = 0;

    private ArrayList<ArrayList<String>> tabelaContas = new ArrayList(); //Armazena as informações mostradas na tabela
    private NumberFormat nf = NumberFormat.getCurrencyInstance(); //Formata valor na moeda do sistema
    private DefaultTableModel model;
    
    public Caixa(Conexao conex) {
        this.conn = conex;
        initComponents();
        fillTable();
        
    }
    
    public void initConexao(Conexao conex){
        
    }

    //Função que preenche a tabela da tela
    public void fillTable(){
        //reset da tabela
        tabelaContas.removeAll(tabelaContas); 
        model = (DefaultTableModel) tableContas.getModel();
        model.setRowCount(0);
        
        //Loga no banco
        tabelaContas = conn.retornar_query(
            "SELECT conta_codigo,conta_mesa,conta_valor,conta_cpf,conta_abertura,conta_fechamento FROM t_contas WHERE conta_status LIKE 'FECHADO'\n" +
            "ORDER BY conta_fechamento ASC;"
        );
        
        //Adiciona os dados à tabela, criando uma linha para cada conta
        //com seus respectivos dados em suas respectivas linhas
        for(ArrayList<String> ars: tabelaContas){ 
            model.addRow(new Object[]{ ars.get(0), ars.get(1), nf.format(Double.parseDouble(ars.get(2))) });
        }
        
        fechaConta.setEnabled(!tabelaContas.isEmpty());
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
        bt_gerarNF = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();

        Dialog.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Dialog.setTitle("S.U.P.R.E.M.E Dialog");
        Dialog.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Dialog.setMinimumSize(new java.awt.Dimension(421, 183));
        Dialog.setModal(true);
        Dialog.setResizable(false);
        Dialog.setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(243, 255, 251));
        jPanel1.setToolTipText("Clique em OK para fechar.");

        textoDialogo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoDialogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoDialogo.setText("Texto Dialogo");

        dialogButton.setBackground(new java.awt.Color(0, 102, 102));
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
            .addComponent(textoDialogo, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dialogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(textoDialogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(dialogButton)
                .addContainerGap(34, Short.MAX_VALUE))
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SUPREME " +Login.versao_supreme);
        setMinimumSize(new java.awt.Dimension(800, 587));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Principal.setBackground(new java.awt.Color(243, 255, 251));
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
        tableContas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Valor Recebido:");

        troco.setEditable(false);
        troco.setBackground(new java.awt.Color(243, 255, 251));
        troco.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        troco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        troco.setBorder(null);
        troco.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Valor da Conta:");

        valorConta.setEditable(false);
        valorConta.setBackground(new java.awt.Color(243, 255, 251));
        valorConta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        valorConta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        valorConta.setBorder(null);
        valorConta.setFocusable(false);

        finaliza.setBackground(new java.awt.Color(0, 102, 102));
        finaliza.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        finaliza.setForeground(new java.awt.Color(255, 255, 255));
        finaliza.setText("Finalizar");
        finaliza.setEnabled(false);
        finaliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizaActionPerformed(evt);
            }
        });

        fechaConta.setBackground(new java.awt.Color(0, 102, 102));
        fechaConta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fechaConta.setForeground(new java.awt.Color(255, 255, 255));
        fechaConta.setText("Ir para finalização");
        fechaConta.setEnabled(false);
        fechaConta.setName("nao fechou"); // NOI18N
        fechaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaContaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Contas fechadas:");

        mostraConta.setEditable(false);
        mostraConta.setBackground(new java.awt.Color(255, 253, 219));
        mostraConta.setColumns(20);
        mostraConta.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        mostraConta.setRows(5);
        mostraConta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        mostraConta.setEnabled(false);
        mostraConta.setFocusable(false);
        jScrollPane2.setViewportView(mostraConta);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Resumo da conta:");

        titulo.setBackground(new java.awt.Color(0, 153, 153));
        titulo.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Caixa");
        titulo.setBorder(null);
        titulo.setOpaque(true);

        rodape.setBackground(new java.awt.Color(0, 153, 153));
        rodape.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rodape.setForeground(new java.awt.Color(255, 255, 255));
        rodape.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rodape.setText(conn.getStatus());
        rodape.setBorder(null);
        rodape.setOpaque(true);

        valorInsuficiente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        valorInsuficiente.setForeground(new java.awt.Color(255, 0, 0));
        valorInsuficiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorInsuficiente.setText("Valor insuficiente!");

        valorRecebido.setEditable(false);
        valorRecebido.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        valorRecebido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        valorRecebido.setText("0");
        valorRecebido.setEnabled(false);
        valorRecebido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                valorRecebidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                valorRecebidoKeyTyped(evt);
            }
        });

        bt_gerarNF.setBackground(new java.awt.Color(0, 102, 102));
        bt_gerarNF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_gerarNF.setForeground(new java.awt.Color(255, 255, 255));
        bt_gerarNF.setText("Gerar Nota Fiscal");
        bt_gerarNF.setEnabled(false);
        bt_gerarNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_gerarNFActionPerformed(evt);
            }
        });

        bt_cancelar.setBackground(new java.awt.Color(102, 0, 0));
        bt_cancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        bt_cancelar.setText("Cancelar");
        bt_cancelar.setEnabled(false);
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PrincipalLayout = new javax.swing.GroupLayout(Principal);
        Principal.setLayout(PrincipalLayout);
        PrincipalLayout.setHorizontalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fechaConta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(bt_gerarNF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valorConta)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(troco, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valorRecebido)
                    .addComponent(finaliza, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valorInsuficiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
            .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rodape, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PrincipalLayout.setVerticalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorInsuficiente, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(troco)
                        .addGap(81, 81, 81)
                        .addComponent(bt_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fechaConta, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(bt_gerarNF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(finaliza, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(rodape, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        valorInsuficiente.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fechaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaContaActionPerformed
        selecionado = tableContas.getSelectedRow();
        
        fechaConta.setEnabled(false); //Impede que o botão seja clicado novamente        
        bt_cancelar.setEnabled(true);
        //Se alguma conta estiver selecionada
        if(tableContas.getSelectedRow()!= -1 && !tabelaContas.isEmpty()){
            float valor = Float.parseFloat(tabelaContas.get(selecionado).get(2));
            String cpf = tabelaContas.get(selecionado).get(3);
            tableContas.setEnabled(false); //Impede a alteração da seleção após o clique
            fechaConta.setName("fechou");
            
            //atualizarResumo(); //Inicializa variáveis com informações da conta
            
            //libera e preenche os campos à direita
            valorConta.setText(nf.format(valor));
            valorRecebido.setEnabled(true);
            valorRecebido.setEditable(true);
        }
    }//GEN-LAST:event_fechaContaActionPerformed

    private void finalizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizaActionPerformed
        //Muda status da conta no BD
        int codigo=Integer.parseInt(tabelaContas.get(selecionado).get(0));
        conn.comando_sql("UPDATE t_contas SET conta_status='FINALIZADO',conta_finalizacao=CURRENT_TIMESTAMP WHERE conta_codigo = "+codigo+";");

        //Abre dialogo
        textoDialogo.setText("Transação finalizada com sucesso!");
        Dialog.setVisible(true);
        
        mostraConta.setText("");
        //bloqueia ações impróprias
        bt_cancelar.setEnabled(false);
        fechaConta.setEnabled(false);
        finaliza.setEnabled(false);
        valorRecebido.setEnabled(false);
        bt_gerarNF.setEnabled(true);
    }//GEN-LAST:event_finalizaActionPerformed

    private void tableContasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContasMouseClicked
        if(tableContas.isEnabled()){
             if(tableContas.getSelectedRow() != -1 && !tabelaContas.isEmpty()){
                selecionado = tableContas.getSelectedRow();
                fechaConta.setEnabled(true);
                atualizarResumo();
            }
        }
    }//GEN-LAST:event_tableContasMouseClicked

    private void valorRecebidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorRecebidoKeyReleased
        int indice = tableContas.getSelectedRow();
        
        
        if(Character.isDigit(evt.getKeyChar()) && valorRecebido.getText().compareTo("0"+evt.getKeyChar()) == 0){
            valorRecebido.setText(String.valueOf(evt.getKeyChar()));
        }
        
        String numero = valorRecebido.getText();
        numero = numero.replace(',', '.');
        
        
        double vConta = Double.parseDouble(tabelaContas.get(indice).get(2));
        double vr = Double.parseDouble(numero);
        double tAux = vr-vConta;
        //Se valor recebido for maior que o valor da conta
        if(vr>=vConta){
            //Caso ja tenha sido mudado para true, volta a ser false
            //valorInsuficiente.setVisible(false);
            valorInsuficiente.setText(" ");
            //Printa o valor recebido formatado no campo
            //valorRecebido.setText(nf.format(vr));
            //Impede a edição do valor após o mesmo ser maior ou igual ao valor da conta
            //valorRecebido.setEditable(false);
            //Printa o valor do troco formatado no campo
            jLabel2.setText("Troco:");
            troco.setForeground(Color.BLACK);
            troco.setText(nf.format(tAux));
            //Libera o botão Finalizar
            finaliza.setEnabled(true);
        }else{ //Se não
            valorInsuficiente.setVisible(true);
            valorInsuficiente.setText("Valor Insuficiente!");
            finaliza.setEnabled(false);
            jLabel2.setText("Faltam:");
            troco.setForeground(Color.red);
            tAux=Math.abs(tAux);
            troco.setText(nf.format(tAux));
            
        }   
        
    }//GEN-LAST:event_valorRecebidoKeyReleased

    private void dialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogButtonActionPerformed
        Dialog.dispose();
    }//GEN-LAST:event_dialogButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Login login = new Login();
        login.setVisible(true);
        try {
            conn.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void bt_gerarNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_gerarNFActionPerformed
        if(bt_gerarNF.getText().compareTo("Gerar Nota Fiscal") == 0){
            bt_gerarNF.setText("Voltar ao início");
            jLabel5.setText("Resumo da conta:");            
            valorConta.setText("");

            gerarNF();

        }
        else{
            bt_gerarNF.setText("Gerar Nota Fiscal");
            resetarCaixa();
        }
    }//GEN-LAST:event_bt_gerarNFActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        resetarCaixa();
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void valorRecebidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorRecebidoKeyTyped
        String campo = valorRecebido.getText()+evt.getKeyChar();
        int quantidade = 0;
        
        
        if(valorRecebido.getText().length() == 0){
            valorRecebido.setText("0");
        }
        
        if(!(String.valueOf(evt.getKeyChar()).matches("[0-9]") || String.valueOf(evt.getKeyChar()).compareTo(",") == 0 )){
            evt.consume();
        }
        else{
            for(int i = 0; i<campo.length();i++){
                if(campo.charAt(i) == ','){
                    quantidade++;
                }
            }
            if(quantidade > 1){
                evt.consume();
            }
        }

    }//GEN-LAST:event_valorRecebidoKeyTyped
    /*
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
    }*/
    
    private String getDataEHora(){
        //Adquire data e hora do sistema
        Date d = Calendar.getInstance().getTime();
        SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm:ss");
        
        return sdfD.format(d) + " " + sdfH.format(d);
    }
    
    public void atualizarResumo(){
        
        StringBuilder sb = new StringBuilder();
        java.text.NumberFormat formatter = new java.text.DecimalFormat("#0.00");
        
        int codConta = Integer.parseInt(tabelaContas.get(selecionado).get(0));

        sb.append("----------------------------------------\n");
        //sb.append(String.format("%-40s", "ABERTURA: " + dataHoraAbertura)+"\n");
        sb.append(String.format("%-25s", "ITEM")+"VALOR UN. "+"QTDE.\n");
        sb.append(String.format("%40s", "SUBTOTAL")+"\n");
        sb.append("========================================\n");
        
        ArrayList<ArrayList<String>> conta = conn.retornar_query(
                "SELECT t_pedido_itens.itm_codigo,t_pedido_itens.itm_qtde,t_pedidos.ped_codigo, t_pedidos_contas.conta_codigo FROM t_pedido_itens\n" +
                "INNER JOIN t_pedidos ON t_pedido_itens.ped_codigo=t_pedidos.ped_codigo\n" +
                "INNER JOIN t_pedidos_contas ON t_pedidos.ped_codigo = t_pedidos_contas.ped_codigo\n" +
                "WHERE conta_codigo = "+codConta+";"
        );
        
        for(int i = 0; i< conta.size(); i++){
 
            int codItem = Integer.parseInt(conta.get(i).get(0));
            int qtdItem = Integer.parseInt(conta.get(i).get(1));
            
            float valorUnit = Float.parseFloat(conn.retornar_valor(codItem, "itm_valor", "itm_codigo", "t_itens"));
            String nomeItem = conn.retornar_valor(codItem, "itm_nome", "itm_codigo", "t_itens");
            sb.append(String.format("%-25s", nomeItem.toUpperCase()) + String.format("%9s", "" + formatter.format(valorUnit)) +String.format("%6s", qtdItem)+"\n");
            sb.append(String.format("%40s", "" + formatter.format(valorUnit*qtdItem))+"\n");
        }
        float totalConta = Float.parseFloat(tabelaContas.get(selecionado).get(2));
        
        sb.append("========================================\n");
        sb.append(String.format("%-20s", "CÓD. CONTA: " + String.format("%06d", codConta)) + String.format("%20s", "VALOR TOTAL: " + formatter.format(totalConta)) + "\n\n");
        
        //valor = "R$ "+formatter.format(totalConta);

        mostraConta.setText(sb.toString());
    }
    
    public void gerarNF(){
        
        mostraConta.setEnabled(true);
        
        StringBuilder sb = new StringBuilder();
        java.text.NumberFormat formatter = new java.text.DecimalFormat("#0.00");
        
        int codConta = Integer.parseInt(tabelaContas.get(selecionado).get(0));
        sb.append("  CINCO AMIGOS COMERCIO DE ALIMENTOS E  \n");
        sb.append("BEBIDAS LTDA.  CNPJ: 73.926.503/0001-66 \n");
        sb.append("    AVENIDA DOS DESESPERADOS Nº 404     \n");
        sb.append("   APUCARANA-PARANÁ   IE: 9564139912    \n");
        sb.append("                                        \n");
        sb.append("----------------------------------------\n");
        sb.append("                                        \n");
        sb.append("        NOTA FISCAL DO CONSUMIDOR       \n");
        sb.append("                                        \n");
        sb.append("----------------------------------------\n");
        //sb.append(String.format("%-40s", "ABERTURA: " + dataHoraAbertura)+"\n");
        sb.append(String.format("%-25s", "ITEM  NOME")+"VALOR UN.  QTD."+"\n");
        sb.append("                  CÓDIGO        SUBTOTAL\n");
        sb.append("========================================\n");
        
        /*
        String.format("%-6s", i+".") // i
        String.format("%-19s", nomeItem.toUpperCase()) // nome do item
        String.format("%9s", "" + formatter.format(valorUnit)) // valor unitário
        String.format("%6s", qtdItem) // quantidade do item
        String.format("%24s", codItem) // código do item
        String.format("%16s", formatter.format(valorUnit*qtdItem)) // subtotal
        */
        ArrayList<ArrayList<String>> conta = conn.retornar_query(
                "SELECT t_pedido_itens.itm_codigo,t_pedido_itens.itm_qtde,t_pedidos.ped_codigo, t_pedidos_contas.conta_codigo FROM t_pedido_itens\n" +
                "INNER JOIN t_pedidos ON t_pedido_itens.ped_codigo=t_pedidos.ped_codigo\n" +
                "INNER JOIN t_pedidos_contas ON t_pedidos.ped_codigo = t_pedidos_contas.ped_codigo\n" +
                "WHERE conta_codigo = "+codConta+";"
        );
        
        int qtdTotal = 0;
        for(int i = 0; i< conta.size(); i++){
 
            int codItem = Integer.parseInt(conta.get(i).get(0));
            int qtdItem = Integer.parseInt(conta.get(i).get(1));
            
            float valorUnit = Float.parseFloat(conn.retornar_valor(codItem, "itm_valor", "itm_codigo", "t_itens"));
            String nomeItem = conn.retornar_valor(codItem, "itm_nome", "itm_codigo", "t_itens");
            sb.append(String.format("%-6s", i+1+".")+String.format("%-19s", nomeItem.toUpperCase())+String.format("%9s", "" + formatter.format(valorUnit))+String.format("%6s", qtdItem)+"\n");
            sb.append(String.format("%24s", codItem)+String.format("%16s", formatter.format(valorUnit*qtdItem))+"\n");
            qtdTotal+=qtdItem;
        }
        float totalConta = Float.parseFloat(tabelaContas.get(selecionado).get(2));
        String cpf = tabelaContas.get(selecionado).get(3);
        
        sb.append("========================================\n");
        sb.append(String.format("%-20s", "CÓD. CONTA: " + String.format("%06d", codConta)) + String.format("%20s", "VALOR TOTAL: " + formatter.format(totalConta)) + "\n");
        sb.append("Quantidade total de itens:"+String.format("%14s", qtdTotal)+ "\n");
        sb.append("Forma de pagamento:             DINHEIRO\n\n");
        sb.append("CPF DO CONTRIBUINTE: " + cpf+"\n");
        sb.append("      Este documento foi gerado em:     \n");
        sb.append("           "+ getDataEHora()+"\n\n");
        sb.append("        OBRIGADO E VOLTE SEMPRE!\n\n");
        sb.append(String.format("%40s", "SUPREME "+Login.versao_supreme));
        
        
        //valor = "R$ "+formatter.format(totalConta);

        mostraConta.setText(sb.toString());
    }
    /*
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
    }*/
    
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
                Caixa c = new Caixa(new Conexao());
                c.setVisible(true);
                //Atualização dos itens da tabela a cada intervalo de 10 segundos.
                final long TEMPO = 20000; //20 Segundos
                Timer timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    public void run() {
                        c.fillTable();
                    }
                },TEMPO, TEMPO);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Dialog;
    private javax.swing.JPanel Principal;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_gerarNF;
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

    private void resetarCaixa() {
        
        selecionado = 0;
        mostraConta.setText("");
        mostraConta.setEnabled(false);
        bt_cancelar.setEnabled(false);
        
        tableContas.setEnabled(true);
        fechaConta.setName("nao fechou");

        //libera e preenche os campos à direita
        valorConta.setText(" ");
        valorRecebido.setEnabled(false);
        valorRecebido.setText("0");
        valorRecebido.setEditable(false);
        valorInsuficiente.setText(" ");
        troco.setText(" ");
        jLabel5.setText("Resumo da conta:");
        bt_gerarNF.setEnabled(false);
        
        fillTable();
        
    }
}
