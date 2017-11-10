package telas;
/**
 *
 * @author Rafael
 */
public class Cardapio extends javax.swing.JFrame {

    public Cardapio(String nome, int[] itens) {
        initComponents();
        confirmaPedido.setVisible(false);
        tituloCP.setText(nome);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CP = new javax.swing.JPanel();
        CPVoltar = new javax.swing.JButton();
        CPConclui = new javax.swing.JButton();
        tituloCP = new javax.swing.JLabel();
        Item1 = new javax.swing.JLabel();
        descItem1 = new javax.swing.JLabel();
        Item2 = new javax.swing.JLabel();
        descItem2 = new javax.swing.JLabel();
        Item3 = new javax.swing.JLabel();
        descItem3 = new javax.swing.JLabel();
        descItem4 = new javax.swing.JLabel();
        Item4 = new javax.swing.JLabel();
        Item5 = new javax.swing.JLabel();
        descItem5 = new javax.swing.JLabel();
        qtdeItem1 = new javax.swing.JSpinner();
        qtdeItem2 = new javax.swing.JSpinner();
        qtdeItem3 = new javax.swing.JSpinner();
        qtdeItem4 = new javax.swing.JSpinner();
        qtdeItem5 = new javax.swing.JSpinner();
        valorItem1 = new javax.swing.JLabel();
        valorItem2 = new javax.swing.JLabel();
        valorItem3 = new javax.swing.JLabel();
        valorItem4 = new javax.swing.JLabel();
        valorItem5 = new javax.swing.JLabel();
        tituloPrecos = new javax.swing.JLabel();
        tituloItens = new javax.swing.JLabel();
        tituloQtde = new javax.swing.JLabel();
        btItem1 = new javax.swing.JToggleButton();
        btItem2 = new javax.swing.JToggleButton();
        btItem3 = new javax.swing.JToggleButton();
        btItem4 = new javax.swing.JToggleButton();
        btItem5 = new javax.swing.JToggleButton();
        confirmaPedido = new javax.swing.JPanel();
        textoConfirmaPedido = new javax.swing.JLabel();
        btConfirmaPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SUPREME - Cardápio");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        CP.setBackground(new java.awt.Color(255, 255, 255));
        CP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CP.setEnabled(false);
        CP.setPreferredSize(new java.awt.Dimension(680, 400));

        CPVoltar.setBackground(new java.awt.Color(255, 255, 255));
        CPVoltar.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        CPVoltar.setText("Voltar");
        CPVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPVoltarActionPerformed(evt);
            }
        });

        CPConclui.setBackground(new java.awt.Color(255, 255, 255));
        CPConclui.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        CPConclui.setText("Concluir Pedido");
        CPConclui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPConcluiActionPerformed(evt);
            }
        });

        tituloCP.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        tituloCP.setText("Título CP");

        Item1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Item1.setText("Item 1");

        descItem1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        descItem1.setText("Descrição Item 1");

        Item2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Item2.setText("Item 2");

        descItem2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        descItem2.setText("Descrição Item 2");

        Item3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Item3.setText("Item 3");

        descItem3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        descItem3.setText("Descrição Item 3");

        descItem4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        descItem4.setText("Descrição Item 4");

        Item4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Item4.setText("Item 4");

        Item5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Item5.setText("Item 5");

        descItem5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        descItem5.setText("Descrição Item 5");

        qtdeItem1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        qtdeItem1.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        qtdeItem1.setToolTipText("");
        qtdeItem1.setValue(1);

        qtdeItem2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        qtdeItem2.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        qtdeItem2.setToolTipText("");
        qtdeItem2.setValue(1);

        qtdeItem3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        qtdeItem3.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        qtdeItem3.setToolTipText("");
        qtdeItem3.setValue(1);

        qtdeItem4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        qtdeItem4.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        qtdeItem4.setToolTipText("");
        qtdeItem4.setValue(1);

        qtdeItem5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        qtdeItem5.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        qtdeItem5.setToolTipText("");
        qtdeItem5.setValue(1);

        valorItem1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        valorItem1.setText("Preço Item 1");

        valorItem2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        valorItem2.setText("Preço Item 2");

        valorItem3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        valorItem3.setText("Preço Item 3");

        valorItem4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        valorItem4.setText("Preço Item 4");

        valorItem5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        valorItem5.setText("Preço Item 5");

        tituloPrecos.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        tituloPrecos.setText("Preço (un.)");

        tituloItens.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        tituloItens.setText("Item");

        tituloQtde.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        tituloQtde.setText("Qtde.");

        btItem1.setBackground(new java.awt.Color(51, 51, 51));
        btItem1.setBorderPainted(false);
        btItem1.setPreferredSize(new java.awt.Dimension(50, 50));

        btItem2.setBackground(new java.awt.Color(51, 51, 51));
        btItem2.setBorderPainted(false);
        btItem2.setPreferredSize(new java.awt.Dimension(50, 50));

        btItem3.setBackground(new java.awt.Color(51, 51, 51));
        btItem3.setBorderPainted(false);
        btItem3.setPreferredSize(new java.awt.Dimension(50, 50));

        btItem4.setBackground(new java.awt.Color(51, 51, 51));
        btItem4.setBorderPainted(false);
        btItem4.setPreferredSize(new java.awt.Dimension(50, 50));

        btItem5.setBackground(new java.awt.Color(51, 51, 51));
        btItem5.setBorderPainted(false);
        btItem5.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout CPLayout = new javax.swing.GroupLayout(CP);
        CP.setLayout(CPLayout);
        CPLayout.setHorizontalGroup(
            CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CPLayout.createSequentialGroup()
                        .addComponent(CPVoltar)
                        .addGap(141, 141, 141)
                        .addComponent(CPConclui)
                        .addGap(0, 231, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CPLayout.createSequentialGroup()
                        .addGroup(CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btItem3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btItem4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btItem5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descItem1)
                            .addComponent(Item1)
                            .addComponent(tituloItens)
                            .addComponent(descItem2)
                            .addComponent(Item3)
                            .addComponent(descItem3)
                            .addComponent(Item4)
                            .addComponent(descItem4)
                            .addComponent(Item5)
                            .addComponent(descItem5)
                            .addComponent(Item2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(CPLayout.createSequentialGroup()
                                    .addComponent(valorItem5)
                                    .addGap(29, 29, 29)
                                    .addComponent(qtdeItem5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(CPLayout.createSequentialGroup()
                                    .addComponent(valorItem4)
                                    .addGap(29, 29, 29)
                                    .addComponent(qtdeItem4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(CPLayout.createSequentialGroup()
                                    .addComponent(valorItem3)
                                    .addGap(29, 29, 29)
                                    .addComponent(qtdeItem3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(CPLayout.createSequentialGroup()
                                    .addComponent(valorItem2)
                                    .addGap(29, 29, 29)
                                    .addComponent(qtdeItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CPLayout.createSequentialGroup()
                                .addGroup(CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tituloPrecos)
                                    .addComponent(valorItem1))
                                .addGap(29, 29, 29)
                                .addGroup(CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tituloQtde)
                                    .addComponent(qtdeItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tituloCP)
                .addGap(289, 289, 289))
        );
        CPLayout.setVerticalGroup(
            CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloCP, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addGroup(CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CPLayout.createSequentialGroup()
                        .addComponent(tituloItens)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(CPLayout.createSequentialGroup()
                                .addGroup(CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(CPLayout.createSequentialGroup()
                                        .addComponent(Item1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(descItem1))
                                    .addComponent(btItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Item2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descItem2))
                            .addComponent(btItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(CPLayout.createSequentialGroup()
                                .addComponent(Item3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descItem3))
                            .addComponent(btItem3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(CPLayout.createSequentialGroup()
                                .addComponent(Item4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descItem4))
                            .addComponent(btItem4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(CPLayout.createSequentialGroup()
                                .addComponent(Item5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descItem5))
                            .addComponent(btItem5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CPVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CPConclui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(CPLayout.createSequentialGroup()
                        .addGroup(CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tituloPrecos)
                            .addComponent(tituloQtde))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorItem1)
                            .addComponent(qtdeItem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorItem2)
                            .addComponent(qtdeItem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorItem3)
                            .addComponent(qtdeItem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorItem4)
                            .addComponent(qtdeItem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorItem5)
                            .addComponent(qtdeItem5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        confirmaPedido.setBackground(new java.awt.Color(255, 255, 255));
        confirmaPedido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        textoConfirmaPedido.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        textoConfirmaPedido.setText("Pedido finalizado com sucesso!");

        btConfirmaPedido.setBackground(new java.awt.Color(255, 255, 255));
        btConfirmaPedido.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btConfirmaPedido.setText("OK");
        btConfirmaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmaPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout confirmaPedidoLayout = new javax.swing.GroupLayout(confirmaPedido);
        confirmaPedido.setLayout(confirmaPedidoLayout);
        confirmaPedidoLayout.setHorizontalGroup(
            confirmaPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmaPedidoLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(confirmaPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confirmaPedidoLayout.createSequentialGroup()
                        .addComponent(btConfirmaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confirmaPedidoLayout.createSequentialGroup()
                        .addComponent(textoConfirmaPedido)
                        .addGap(29, 29, 29))))
        );
        confirmaPedidoLayout.setVerticalGroup(
            confirmaPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmaPedidoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(textoConfirmaPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btConfirmaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(157, 157, 157)
                    .addComponent(confirmaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(158, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(112, 112, 112)
                    .addComponent(confirmaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(112, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
        
    private void CPVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPVoltarActionPerformed
        dispose();
        //Mesa.Cardapios.setVisible(true);
    }//GEN-LAST:event_CPVoltarActionPerformed

    private void CPConcluiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPConcluiActionPerformed
        //Verifica os itens selecionados e adiciona os mesmos na conta
//        if(btItem1.isSelected()) {
//            Mesa.conta.setTxtconta(Item1.getText()+"   "+valorItem1.getText()+"   "+qtdeItem1.getValue());
//            //Descomentar a linha abaixo quando os valores dos itens existirem
//            //Mesa.conta.setTotalConta(Integer.parseInt(valorItem1.getText()));
//        }
//        if(btItem2.isSelected()) {
//            Mesa.conta.setTxtconta(Item2.getText()+"   "+valorItem2.getText()+"   "+qtdeItem2.getValue());
//            //Descomentar a linha abaixo quando os valores dos itens existirem
//            //Mesa.conta.setTotalConta(Integer.parseInt(valorItem2.getText()));
//        }
//        if(btItem3.isSelected()) {
//            Mesa.conta.setTxtconta(Item3.getText()+"   "+valorItem3.getText()+"   "+qtdeItem3.getValue());
//            //Descomentar a linha abaixo quando os valores dos itens existirem
//            //Mesa.conta.setTotalConta(Integer.parseInt(valorItem3.getText())); 
//        }
//        if(btItem4.isSelected()) {
//            Mesa.conta.setTxtconta(Item4.getText()+"   "+valorItem4.getText()+"   "+qtdeItem4.getValue());
//            //Descomentar a linha abaixo quando os valores dos itens existirem
//            //Mesa.conta.setTotalConta(Integer.parseInt(valorItem4.getText()));
//        }
//        if(btItem5.isSelected()) {
//            Mesa.conta.setTxtconta(Item5.getText()+"   "+valorItem5.getText()+"   "+qtdeItem5.getValue());
//            //Descomentar a linha abaixo quando os valores dos itens existirem
//            //Mesa.conta.setTotalConta(Integer.parseInt(valorItem5.getText()));
//        }
        
        CP.setVisible(false);
        confirmaPedido.setVisible(true);
    }//GEN-LAST:event_CPConcluiActionPerformed

    private void btConfirmaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmaPedidoActionPerformed
        confirmaPedido.setVisible(false);
        //Printa o resumo modificado na tela inicial
//        Mesa.resumo.setText(Mesa.conta.getTxtconta());
//        Mesa.resumo.setText(Mesa.resumo.getText()+"\nValor Total: R$"+Mesa.conta.getTotalConta());
        Mesa.Home.setVisible(true);
        dispose();
    }//GEN-LAST:event_btConfirmaPedidoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CP;
    private javax.swing.JButton CPConclui;
    private javax.swing.JButton CPVoltar;
    private javax.swing.JLabel Item1;
    private javax.swing.JLabel Item2;
    private javax.swing.JLabel Item3;
    private javax.swing.JLabel Item4;
    private javax.swing.JLabel Item5;
    private javax.swing.JButton btConfirmaPedido;
    private javax.swing.JToggleButton btItem1;
    private javax.swing.JToggleButton btItem2;
    private javax.swing.JToggleButton btItem3;
    private javax.swing.JToggleButton btItem4;
    private javax.swing.JToggleButton btItem5;
    public static javax.swing.JPanel confirmaPedido;
    private javax.swing.JLabel descItem1;
    private javax.swing.JLabel descItem2;
    private javax.swing.JLabel descItem3;
    private javax.swing.JLabel descItem4;
    private javax.swing.JLabel descItem5;
    private javax.swing.JSpinner qtdeItem1;
    private javax.swing.JSpinner qtdeItem2;
    private javax.swing.JSpinner qtdeItem3;
    private javax.swing.JSpinner qtdeItem4;
    private javax.swing.JSpinner qtdeItem5;
    private javax.swing.JLabel textoConfirmaPedido;
    private javax.swing.JLabel tituloCP;
    private javax.swing.JLabel tituloItens;
    private javax.swing.JLabel tituloPrecos;
    private javax.swing.JLabel tituloQtde;
    private javax.swing.JLabel valorItem1;
    private javax.swing.JLabel valorItem2;
    private javax.swing.JLabel valorItem3;
    private javax.swing.JLabel valorItem4;
    private javax.swing.JLabel valorItem5;
    // End of variables declaration//GEN-END:variables
}
