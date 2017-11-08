package telas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Rafael
 */
public class Cozinha extends javax.swing.JFrame {
    
    private codigo.Conexao conn = new codigo.Conexao();
    private ArrayList<ArrayList<String>> tabelaPedidos = new ArrayList();
    
    public Cozinha() {
        initComponents();
        fillTable();
    }
    
    public void fillTable(){
        conn.conectar("test", "12345".toCharArray()); //troque ou crie este usuário para testar//
        conn.comando_sql("USE bdsupreme2;");	
        tabelaPedidos = conn.retornar_query(
            "SELECT ped_codigo, ped_nome, ped_mesa FROM t_pedidos WHERE ped_status LIKE 'ABERTO'"
        );
        
        DefaultTableModel model = (DefaultTableModel) tablePedidos.getModel();
        tablePedidos.setRowSorter(new TableRowSorter(model));
        
        for(ArrayList<String> ars: tabelaPedidos){ 
            model.addRow(new Object[]{ ars.get(0), ars.get(1), ars.get(2) });
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SUPREME - Cozinha");

        TelaCozinha.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setText("Lista de Pedidos");

        finalizaPedido.setBackground(new java.awt.Color(102, 255, 102));
        finalizaPedido.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        finalizaPedido.setText("Concluído");
        finalizaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizaPedidoActionPerformed(evt);
            }
        });

        cancelaPedido.setBackground(new java.awt.Color(255, 51, 51));
        cancelaPedido.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        cancelaPedido.setText("Cancelar Pedido");
        cancelaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelaPedidoActionPerformed(evt);
            }
        });

        tablePedidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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
        jScrollPane1.setViewportView(tablePedidos);
        if (tablePedidos.getColumnModel().getColumnCount() > 0) {
            tablePedidos.getColumnModel().getColumn(0).setMinWidth(200);
            tablePedidos.getColumnModel().getColumn(1).setMinWidth(60);
            tablePedidos.getColumnModel().getColumn(1).setMaxWidth(60);
            tablePedidos.getColumnModel().getColumn(2).setMinWidth(100);
            tablePedidos.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        javax.swing.GroupLayout TelaCozinhaLayout = new javax.swing.GroupLayout(TelaCozinha);
        TelaCozinha.setLayout(TelaCozinhaLayout);
        TelaCozinhaLayout.setHorizontalGroup(
            TelaCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaCozinhaLayout.createSequentialGroup()
                .addGroup(TelaCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TelaCozinhaLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(TelaCozinhaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(TelaCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cancelaPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(finalizaPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        TelaCozinhaLayout.setVerticalGroup(
            TelaCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaCozinhaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TelaCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TelaCozinhaLayout.createSequentialGroup()
                        .addComponent(finalizaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(cancelaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TelaCozinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TelaCozinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Action do botão que finaliza o pedido
    private void finalizaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizaPedidoActionPerformed
        
    }//GEN-LAST:event_finalizaPedidoActionPerformed

    private void cancelaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelaPedidoActionPerformed
        // TODO add your handling code here:
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePedidos;
    // End of variables declaration//GEN-END:variables
}
