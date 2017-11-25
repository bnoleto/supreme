package telas;

import codigo.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Rafael
 */
public class Cozinha extends javax.swing.JFrame {
    
    private codigo.Conexao conn = new codigo.Conexao();
    private ArrayList<ArrayList<String>> Pedidos = new ArrayList();; //Primitiva
    private ArrayList<ArrayList<String>> tabelaPedidos = new ArrayList(); //Matriz modificada (tela)
    private DefaultTableModel model;
    
    public Cozinha() {
        initComponents();
        
    }
    
    public void initConexao(Conexao conex){
        this.conn = conex;
        fillTable();
    }
    
    public void fillTable(){

        //Armazena os nomes dos itens
        ArrayList<ArrayList<String>> nomeItens = new ArrayList();
        
        //Reset das tabelas
        tabelaPedidos.removeAll(tabelaPedidos); 
        model = (DefaultTableModel) tablePedidos.getModel();
        model.setRowCount(0);
        
        //Preenche tabela primitiva
        Pedidos = conn.retornar_query(
            "SELECT itm_codigo, ped_codigo, itm_qtde, ped_data, ped_hora FROM t_pedido_itens WHERE ped_status LIKE 'ABERTO';"
        );
        
        //Percorre a tabela primitiva obtida do banco de dados
        for(int i=0; i<Pedidos.size(); i++){
            String itm_codigo = Pedidos.get(i).get(0);
            String ped_codigo = Pedidos.get(i).get(1);
            System.out.println(ped_codigo);
            //Reetorna o nome do item referente ao itm_codigo
            nomeItens = conn.retornar_query(
                "SELECT itm_nome FROM t_itens WHERE itm_codigo LIKE "+itm_codigo+";"
            );  
            //Copia da array para a tabela principal
            tabelaPedidos.add(Pedidos.get(i));
            ///Adiciona o NOME do item na posição (5) da tabela
            tabelaPedidos.get(i).add(nomeItens.get(0).get(0)); 
            
            //Retorna o numero da mesa do pedido
            String ped_mesa = conn.retornar_query(
                "SELECT ped_mesa FROM t_pedidos WHERE ped_codigo LIKE "+ped_codigo+";"
            ).get(0).get(0);
            //Adiciona o numero da mesa às linhas da tabela na ULTIMA posição (6)
            tabelaPedidos.get(i).add(ped_mesa);
        }
        
        
        tablePedidos.setRowSorter(new TableRowSorter(model));
        
        for(ArrayList<String> ars: tabelaPedidos){ 
            model.addRow(new Object[]{ ars.get(5), ars.get(2), ars.get(6) });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dialog = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        textoDialogo = new javax.swing.JLabel();
        dialogButton = new javax.swing.JButton();
        TelaCozinha = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        finalizaPedido = new javax.swing.JButton();
        cancelaPedido = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePedidos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rodape = new javax.swing.JLabel();

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

        Dialog.setLocationRelativeTo(TelaCozinha);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SUPREME " +Mesa.versao_supreme);
        setMinimumSize(new java.awt.Dimension(780, 510));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        TelaCozinha.setBackground(new java.awt.Color(255, 255, 255));
        TelaCozinha.setMinimumSize(new java.awt.Dimension(780, 510));

        titulo.setBackground(new java.awt.Color(0, 153, 153));
        titulo.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Cozinha");
        titulo.setBorder(null);
        titulo.setOpaque(true);

        finalizaPedido.setBackground(new java.awt.Color(0, 153, 153));
        finalizaPedido.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        finalizaPedido.setForeground(new java.awt.Color(255, 255, 255));
        finalizaPedido.setText("Concluído");
        finalizaPedido.setToolTipText("Clique para concluir o pedido selecionado.");
        finalizaPedido.setMaximumSize(new java.awt.Dimension(143, 50));
        finalizaPedido.setMinimumSize(new java.awt.Dimension(143, 50));
        finalizaPedido.setPreferredSize(new java.awt.Dimension(143, 50));
        finalizaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizaPedidoActionPerformed(evt);
            }
        });

        cancelaPedido.setBackground(new java.awt.Color(255, 51, 51));
        cancelaPedido.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cancelaPedido.setForeground(new java.awt.Color(255, 255, 255));
        cancelaPedido.setText("Cancelar Pedido");
        cancelaPedido.setToolTipText("Clique para cancelar o pedido selecionado.");
        cancelaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelaPedidoActionPerformed(evt);
            }
        });

        tablePedidos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pedido", "Qtde.", "Mesa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePedidos.setToolTipText("Tabela de pedidos.");
        tablePedidos.setFillsViewportHeight(true);
        tablePedidos.setRowHeight(22);
        tablePedidos.setSelectionBackground(new java.awt.Color(0, 153, 0));
        tablePedidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablePedidos);
        if (tablePedidos.getColumnModel().getColumnCount() > 0) {
            tablePedidos.getColumnModel().getColumn(0).setMinWidth(400);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lista de Pedidos:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Opções:");

        rodape.setBackground(new java.awt.Color(0, 153, 153));
        rodape.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rodape.setForeground(new java.awt.Color(255, 255, 255));
        rodape.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rodape.setText(conn.getStatus());
        rodape.setToolTipText("");
        rodape.setBorder(null);
        rodape.setOpaque(true);

        javax.swing.GroupLayout TelaCozinhaLayout = new javax.swing.GroupLayout(TelaCozinha);
        TelaCozinha.setLayout(TelaCozinhaLayout);
        TelaCozinhaLayout.setHorizontalGroup(
            TelaCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TelaCozinhaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(TelaCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(TelaCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelaPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(finalizaPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        TelaCozinhaLayout.setVerticalGroup(
            TelaCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaCozinhaLayout.createSequentialGroup()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(TelaCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TelaCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                    .addGroup(TelaCozinhaLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(finalizaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(15, 15, 15)
                .addComponent(rodape))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaCozinha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaCozinha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //Action do botão que finaliza o pedido
    private void finalizaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizaPedidoActionPerformed
        int indice = tablePedidos.getSelectedRow();
        //Conclui se algo estiver selecionado
        
        if(indice != -1){
            String ped_codigo = Pedidos.get(indice).get(1);
            String itm_codigo = Pedidos.get(indice).get(0);
            //Atualiza status do pedido para CONCLUIDO
            conn.comando_sql(
                "UPDATE t_pedido_itens SET ped_status = 'CONCLUIDO' "
              + "WHERE ped_codigo LIKE "+ped_codigo+" AND itm_codigo LIKE "+itm_codigo+";"
            );

            //Remove Linha da conta da tabela de pedidos
            ((DefaultTableModel)tablePedidos.getModel()).removeRow(indice);
            //Re-preenche a tabela
            fillTable();
            //Abre tela de dialogo
            textoDialogo.setText("Pedido concluído com sucesso!");
            Dialog.setVisible(true);
        }
    }//GEN-LAST:event_finalizaPedidoActionPerformed

    private void cancelaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelaPedidoActionPerformed
        int indice = tablePedidos.getSelectedRow();
        //Cancela se algo estiver selecionado
        if(indice != -1){
            String ped_codigo = Pedidos.get(indice).get(1);
            String itm_codigo = Pedidos.get(indice).get(0);
            //Atualiza status do pedido para CANCELADO
            conn.comando_sql(
                "UPDATE t_pedido_itens SET ped_status = 'CANCELADO' "
              + "WHERE ped_codigo LIKE "+ped_codigo+" "
              + "AND itm_codigo LIKE "+itm_codigo+";"
            );

            //Remove Linha da conta da tabela de pedidos
            ((DefaultTableModel)tablePedidos.getModel()).removeRow(indice);
            //Abre tela de dialogo
            textoDialogo.setText("Pedido cancelado com sucesso!");
            Dialog.setVisible(true);
            //Remove da tabela os indices;
            Pedidos.remove(indice);
            tabelaPedidos.remove(indice); 
            //Re-preenche a tabela
            fillTable();
        }   
    }//GEN-LAST:event_cancelaPedidoActionPerformed
    
    //Fecha a tela de dialogo
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
            java.util.logging.Logger.getLogger(Cozinha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cozinha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cozinha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cozinha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cozinha c = new Cozinha();
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
    private javax.swing.JPanel TelaCozinha;
    private javax.swing.JButton cancelaPedido;
    private javax.swing.JButton dialogButton;
    private javax.swing.JButton finalizaPedido;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel rodape;
    private javax.swing.JTable tablePedidos;
    private javax.swing.JLabel textoDialogo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
