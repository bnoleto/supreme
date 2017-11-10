package telas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Rafael
 */
public class Cozinha extends javax.swing.JFrame {
    
    private codigo.Conexao conn = new codigo.Conexao();
    private ArrayList<ArrayList<String>> Pedidos; //Primitiva
    private ArrayList<ArrayList<String>> tabelaPedidos = new ArrayList(); //Matriz modificada (tela)
    
    public Cozinha() {
        initComponents();
        fillTable();
    }
    
    public void fillTable(){
        conn.conectar("test", "12345".toCharArray()); //troque ou crie este usuário para testar//
        conn.comando_sql("USE bdsupreme2;");
        ArrayList<ArrayList<String>> codItens;
        
        Pedidos = conn.retornar_query(
            "SELECT ped_codigo, itm_codigo, itm_qtde, ped_data, ped_hora FROM t_pedido_itens WHERE ped_status LIKE 'ABERTO';"
        );
        
        for(int i=0; i<Pedidos.size(); i++){
            String itm_codigo = Pedidos.get(i).get(1);
            String ped_codigo = Pedidos.get(i).get(0);
            //Reetorna o item pertencente ao itm_codigo;
            codItens = conn.retornar_query(
                "SELECT itm_nome FROM t_itens WHERE itm_codigo LIKE "+itm_codigo+";"
            );  
            //Copia da array para a tabela principal
            tabelaPedidos.add(Pedidos.get(i));
            ///Adiciona o NOME do item na posição (5) da tabela
            tabelaPedidos.get(i).add(codItens.get(0).get(0)); 
            
            String ped_mesa = conn.retornar_query(
                "SELECT ped_mesa FROM t_pedidos WHERE ped_codigo LIKE "+ped_codigo+";"
            ).get(0).get(0);
            //Adiciona o numero da mesa às linhas da tabela na ULTIMA posição (6)
            tabelaPedidos.get(i).add(ped_mesa);
        }
        
        DefaultTableModel model = (DefaultTableModel) tablePedidos.getModel();
        tablePedidos.setRowSorter(new TableRowSorter(model));
        
        for(ArrayList<String> ars: tabelaPedidos){ 
            model.addRow(new Object[]{ ars.get(5), ars.get(2), ars.get(6) });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TelaCozinha = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        finalizaPedido = new javax.swing.JButton();
        cancelaPedido = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePedidos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SUPREME - Cozinha");

        TelaCozinha.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cozinha");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);

        finalizaPedido.setBackground(new java.awt.Color(102, 248, 157));
        finalizaPedido.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        finalizaPedido.setText("Concluído");
        finalizaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizaPedidoActionPerformed(evt);
            }
        });

        cancelaPedido.setBackground(new java.awt.Color(255, 51, 51));
        cancelaPedido.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        cancelaPedido.setForeground(new java.awt.Color(255, 255, 255));
        cancelaPedido.setText("Cancelar Pedido");
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
        tablePedidos.setFillsViewportHeight(true);
        tablePedidos.setRowHeight(22);
        tablePedidos.setSelectionBackground(new java.awt.Color(0, 153, 0));
        jScrollPane1.setViewportView(tablePedidos);
        if (tablePedidos.getColumnModel().getColumnCount() > 0) {
            tablePedidos.getColumnModel().getColumn(0).setMinWidth(200);
            tablePedidos.getColumnModel().getColumn(1).setMinWidth(60);
            tablePedidos.getColumnModel().getColumn(1).setMaxWidth(60);
            tablePedidos.getColumnModel().getColumn(2).setMinWidth(100);
            tablePedidos.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        jLabel2.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lista de Pedidos:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Opções:");

        jLabel4.setBackground(new java.awt.Color(0, 153, 153));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText(" Copyright © S.U.P.R.E.M.E");
        jLabel4.setToolTipText("");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.setOpaque(true);

        javax.swing.GroupLayout TelaCozinhaLayout = new javax.swing.GroupLayout(TelaCozinha);
        TelaCozinha.setLayout(TelaCozinhaLayout);
        TelaCozinhaLayout.setHorizontalGroup(
            TelaCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TelaCozinhaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(TelaCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(TelaCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelaPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(finalizaPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        TelaCozinhaLayout.setVerticalGroup(
            TelaCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaCozinhaLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TelaCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TelaCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(TelaCozinhaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(finalizaPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
                        .addComponent(cancelaPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                        .addGap(253, 253, 253)))
                .addGap(20, 20, 20)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaCozinha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TelaCozinha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Action do botão que finaliza o pedido
    private void finalizaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizaPedidoActionPerformed
        int indice = tablePedidos.getSelectedRow();
        if(indice != -1){
            String ped_codigo = Pedidos.get(indice).get(0);
            String itm_codigo = Pedidos.get(indice).get(1);
            //Atualiza status do pedido para CONCLUIDO
            conn.comando_sql(
                "UPDATE t_pedido_itens SET ped_status = 'CONCLUIDO' "
              + "WHERE ped_codigo LIKE "+ped_codigo+" AND itm_codigo LIKE "+itm_codigo+";"
            );

            //Remove Linha da conta da tabela de pedidos
            ((DefaultTableModel)tablePedidos.getModel()).removeRow(indice);
            Pedidos.remove(indice);
            tabelaPedidos.remove(indice);   
        }
    }//GEN-LAST:event_finalizaPedidoActionPerformed

    private void cancelaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelaPedidoActionPerformed
        int indice = tablePedidos.getSelectedRow();
        System.out.println(indice);
        if(indice != -1){
            String ped_codigo = Pedidos.get(indice).get(0);
            String itm_codigo = Pedidos.get(indice).get(1);
            //Atualiza status do pedido para CANCELADO
            conn.comando_sql(
                "UPDATE t_pedido_itens SET ped_status = 'CANCELADO' "
              + "WHERE ped_codigo LIKE "+ped_codigo+" AND itm_codigo LIKE "+itm_codigo+";"
            );

            //Remove Linha da conta da tabela de pedidos
            ((DefaultTableModel)tablePedidos.getModel()).removeRow(indice);
            Pedidos.remove(indice);
            tabelaPedidos.remove(indice);
        }   
    }//GEN-LAST:event_cancelaPedidoActionPerformed

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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cozinha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TelaCozinha;
    private javax.swing.JButton cancelaPedido;
    private javax.swing.JButton finalizaPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePedidos;
    // End of variables declaration//GEN-END:variables
}
