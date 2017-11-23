/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import codigo.Conexao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Bruno Noleto
 */
public class Login extends javax.swing.JFrame {
    private final Conexao conn = new Conexao();
    
    /**
     * Creates new form Login1
     */
    public Login() {
        initComponents();
    }
    
    public Conexao getConexao(){
        return this.conn;
    }
    
    public void novaConexao(JTextField campo_usuario, JPasswordField campo_senha){
        conn.conectar(campo_usuario.getText(), campo_senha.getPassword());
        System.out.println(conn.getStatus());
        caixa_status.setText(conn.getStatus());
        if(!conn.conectado){
            caixa_status.setForeground(Color.red);
        }
        else{
            caixa_status.setForeground(Color.blue);
            this.dispose();
        }
    }
    
    public void verificarUsuario(){
        novaConexao(campo_usuario, campo_senha);
            if(conn.conectado){
                conn.comando_sql("USE bdsupreme2;");
                ArrayList<ArrayList<String>> query = conn.retornar_query("SELECT * FROM tipo_usuario WHERE usuario = '"+campo_usuario.getText()+"';");
                String categoria_usuario = query.get(0).get(1);
                if(categoria_usuario.compareTo("CAIXA") == 0){
                    Caixa telaCaixa= new Caixa();
                    telaCaixa.initConexao(conn);
                    telaCaixa.setVisible(true);
                }
                else if(categoria_usuario.compareTo("COZINHA") == 0){
                    Cozinha telaCozinha= new Cozinha();
                    telaCozinha.initConexao(conn);
                    telaCozinha.setVisible(true);
                }
                else{
                    Mesa telaMesa= new Mesa();
                    telaMesa.initConexao(conn);
                    telaMesa.setVisible(true);
                }
                
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    Dimension resolucao = Toolkit.getDefaultToolkit().getScreenSize();
    int altura = (int)resolucao.getHeight();
    int largura = (int)resolucao.getWidth();
    int tamanhoX = 311;
    int tamanhoY = 220;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        campo_usuario = new javax.swing.JTextField();
        campo_senha = new javax.swing.JPasswordField();
        label_usuario = new javax.swing.JLabel();
        label_senha = new javax.swing.JLabel();
        caixa_status = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        bt_login = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        titulo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Acesso Restrito");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 153));
        setBounds((largura-tamanhoX)/2,(altura-tamanhoY)/2 , tamanhoX, tamanhoY);
        setResizable(false);
        setSize(new java.awt.Dimension(311, 235));
        setType(java.awt.Window.Type.POPUP);

        panel_principal.setBackground(new java.awt.Color(244, 244, 255));

        campo_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campo_usuarioKeyPressed(evt);
            }
        });

        campo_senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campo_senhaKeyPressed(evt);
            }
        });

        label_usuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        label_usuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_usuario.setText("Usuário");

        label_senha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        label_senha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_senha.setText("Senha");

        caixa_status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        caixa_status.setText(" ");

        titulo.setBackground(new java.awt.Color(0, 0, 126));
        titulo.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Autenticação de Usuário");
        titulo.setOpaque(true);
        titulo.setPreferredSize(new java.awt.Dimension(141, 28));

        bt_login.setBackground(new java.awt.Color(0, 0, 76));
        bt_login.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_login.setForeground(new java.awt.Color(244, 244, 255));
        bt_login.setText("Realizar Login");
        bt_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loginActionPerformed(evt);
            }
        });

        bt_cancelar.setBackground(new java.awt.Color(0, 0, 76));
        bt_cancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_cancelar.setForeground(new java.awt.Color(244, 244, 255));
        bt_cancelar.setText("Cancelar");
        bt_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        titulo1.setBackground(new java.awt.Color(0, 0, 126));
        titulo1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        titulo1.setForeground(new java.awt.Color(255, 255, 255));
        titulo1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        titulo1.setOpaque(true);
        titulo1.setPreferredSize(new java.awt.Dimension(141, 28));

        javax.swing.GroupLayout panel_principalLayout = new javax.swing.GroupLayout(panel_principal);
        panel_principal.setLayout(panel_principalLayout);
        panel_principalLayout.setHorizontalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bt_cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_login)
                .addContainerGap())
            .addComponent(titulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addGap(0, 85, Short.MAX_VALUE)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_usuario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_senha, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 85, Short.MAX_VALUE))
            .addComponent(caixa_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_principalLayout.createSequentialGroup()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_usuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_senha))
                .addGap(6, 6, 6)
                .addComponent(caixa_status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_cancelar)
                    .addComponent(bt_login))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
        verificarUsuario();
    }//GEN-LAST:event_bt_loginActionPerformed

    private void campo_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_usuarioKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            verificarUsuario();
        }
    }//GEN-LAST:event_campo_usuarioKeyPressed

    private void campo_senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_senhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            verificarUsuario();
        }
    }//GEN-LAST:event_campo_senhaKeyPressed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bt_cancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
         /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_login;
    private javax.swing.JLabel caixa_status;
    private javax.swing.JPasswordField campo_senha;
    private javax.swing.JTextField campo_usuario;
    private javax.swing.JLabel label_senha;
    private javax.swing.JLabel label_usuario;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    // End of variables declaration//GEN-END:variables
}
