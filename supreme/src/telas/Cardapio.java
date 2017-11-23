package telas;

import codigo.Conexao;
import java.awt.CardLayout;
import java.util.ArrayList;

public class Cardapio extends javax.swing.JPanel {
    // <editor-fold defaultstate="collapsed" desc="Classe CARDÁPIO">                          
    ArrayList<ArrayList<String>> tabela = new ArrayList();

    java.awt.Container ctn = null;
        
    public Cardapio(Conexao conn, java.awt.Container ctn) {
        this.ctn = ctn;
        tabela = conn.retornar_query(
            "SELECT itm_codigo,itm_nome,itm_descricao,itm_tipo,itm_valor FROM t_itens WHERE itm_tipo='BEBIDAS';"
        );
		
        initComponents();
    }
    
    public javax.swing.JPanel getPanel(){
        return this.panel_cardapio;
    }
    
    java.awt.Container getContentPane(){
        return this.ctn;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
		
        quantidade = tabela.size();
        
        itens = new java.util.ArrayList<javax.swing.JPanel>();
        preco_item = new java.util.ArrayList<javax.swing.JLabel>();
        qtd_item = new java.util.ArrayList<javax.swing.JSpinner>();
        nome_item = new java.util.ArrayList<javax.swing.JLabel>();
        check_item = new java.util.ArrayList<javax.swing.JToggleButton>();
        desc_item = new java.util.ArrayList<javax.swing.JLabel>();
        
        panel_principal = new javax.swing.JPanel();
        panel_cardapio = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        javax.swing.JPanel lista_itens = new javax.swing.JPanel();
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane();
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setOpaque(false);
	scroll.getVerticalScrollBar().setUnitIncrement(16);
        
        
        for(int i = 0; i < quantidade; i++){
            itens.add(new javax.swing.JPanel());
            check_item.add(new javax.swing.JToggleButton());
            preco_item.add(new javax.swing.JLabel());
            qtd_item.add(new javax.swing.JSpinner());
            nome_item.add(new javax.swing.JLabel());
            desc_item.add(new javax.swing.JLabel());
			
            itens.get(i).setOpaque(false);
        }
        
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();


        panel_principal.setBackground(new java.awt.Color(0, 0, 127));
        panel_principal.setLayout(new java.awt.CardLayout());

        panel_cardapio.setBackground(new java.awt.Color(0, 0, 127));

        jPanel2.setBackground(new java.awt.Color(244, 244, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(620, 394));

        jLabel1.setFont(new java.awt.Font("Caladea", 3, 36)); // NOI18N
        jLabel1.setText("Bebidas");

        lista_itens.setOpaque(false);
        lista_itens.setAutoscrolls(true);
        
	java.text.NumberFormat formatter = new java.text.DecimalFormat("#0.00");
		
        for(int i = 0; i<quantidade; i++){

            check_item.get(i).setPreferredSize(new java.awt.Dimension(48, 48));
            check_item.get(i).setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check.png"))); // NOI18N
			
            double valor = Double.parseDouble(tabela.get(i).get(4));
			
            preco_item.get(i).setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
            preco_item.get(i).setText("R$ "+formatter.format(valor));

            qtd_item.get(i).setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
            qtd_item.get(i).setModel(new javax.swing.SpinnerNumberModel(1, 1, 9, 1));
            qtd_item.get(i).setEditor(new javax.swing.JSpinner.NumberEditor(qtd_item.get(i), ""));

            nome_item.get(i).setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
            nome_item.get(i).setText(tabela.get(i).get(1));

            desc_item.get(i).setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
            desc_item.get(i).setText(tabela.get(i).get(2));
        }

        java.util.ArrayList<javax.swing.GroupLayout> itemLayout = new java.util.ArrayList();
        
        for(int i = 0; i < quantidade; i++){
        
            itemLayout.add(new javax.swing.GroupLayout(itens.get(i)));
            itens.get(i).setLayout(itemLayout.get(i));
            itemLayout.get(i).setHorizontalGroup(
                itemLayout.get(i).createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(itemLayout.get(i).createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(check_item.get(i), javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(itemLayout.get(i).createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nome_item.get(i), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(desc_item.get(i), javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
                    .addContainerGap()
                    .addComponent(preco_item.get(i))
                    .addGap(10, 10, 10)
                    .addComponent(qtd_item.get(i), javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            itemLayout.get(i).setVerticalGroup(
                itemLayout.get(i).createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(itemLayout.get(i).createSequentialGroup()
                    .addContainerGap()
                    .addGroup(itemLayout.get(i).createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemLayout.get(i).createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(qtd_item.get(i), javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(itemLayout.get(i).createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(itemLayout.get(i).createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(check_item.get(i), javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(itemLayout.get(i).createSequentialGroup()
                                    .addComponent(nome_item.get(i), javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(21, 21, 21)))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(itemLayout.get(i).createSequentialGroup()
                            .addComponent(preco_item.get(i), javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemLayout.get(i).createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(desc_item.get(i))
                    .addGap(14, 14, 14))
            );
        }
        
        javax.swing.GroupLayout lista_itensLayout = new javax.swing.GroupLayout(lista_itens);
		lista_itens.setLayout(lista_itensLayout);
		
		
		// GRUPO HORIZONTAL
		javax.swing.GroupLayout.SequentialGroup hGroup = lista_itensLayout.createSequentialGroup();
		
        javax.swing.GroupLayout.ParallelGroup pGroupH = lista_itensLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
		
		hGroup.addGroup(pGroupH);
		
        for(int i = 0; i< quantidade; i++){
			if(i == quantidade-1){
				pGroupH.addComponent(itens.get(i), javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
			}
			else{
				pGroupH.addComponent(itens.get(i), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
			}
        }
		
		// GRUPO VERTICAL
		
		javax.swing.GroupLayout.ParallelGroup vGroup = lista_itensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
		
        javax.swing.GroupLayout.SequentialGroup sGroupV = lista_itensLayout
            .createSequentialGroup();
		
		vGroup.addGroup(sGroupV);
		
        for(int i = 0; i< quantidade; i++){
			sGroupV.addComponent(itens.get(i), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
			if(i == quantidade-1){
				//sGroupV.addGap(0, 100, Short.MAX_VALUE);
			}
        }
		
        
        lista_itensLayout.setHorizontalGroup(
            lista_itensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lista_itensLayout.createSequentialGroup()
                .addGroup(hGroup)
                .addContainerGap())
        );
        lista_itensLayout.setVerticalGroup(vGroup);
        
        scroll.setViewportView(lista_itens);

        jLabel2.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel2.setText("Item");

        jLabel3.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel3.setText("Preço (un.)");

        jLabel4.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel4.setText("Quantidade");

        jLabel5.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel5.setText("Adicionar?");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel5)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Faça seu Pedido");

        jButton3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton3.setText("Voltar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton4.setText("Concluir Pedido");
        jButton4.setEnabled(false);

        javax.swing.GroupLayout panel_cardapioLayout = new javax.swing.GroupLayout(panel_cardapio);
        panel_cardapio.setLayout(panel_cardapioLayout);
        panel_cardapioLayout.setHorizontalGroup(
            panel_cardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(panel_cardapioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panel_cardapioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_cardapioLayout.setVerticalGroup(
            panel_cardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cardapioLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(panel_cardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panel_principal.add(panel_cardapio, "panel_comCadastro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        //pack();
    }// </editor-fold>                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        CardLayout tela = (CardLayout)panel_principal.getLayout();
        //tela.show(panelPrincipal, "Home");
    }                                        

    // Variables declaration - do not modify                     
    private int quantidade = 1;
    
    private java.util.ArrayList<javax.swing.JPanel> itens;
    private java.util.ArrayList<javax.swing.JLabel> preco_item;
    private java.util.ArrayList<javax.swing.JSpinner> qtd_item;
    private java.util.ArrayList<javax.swing.JLabel> nome_item;
    private java.util.ArrayList<javax.swing.JToggleButton> check_item;
    private java.util.ArrayList<javax.swing.JLabel> desc_item;
    
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel lista_itens;
    private javax.swing.JPanel panel_cardapio;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JScrollPane scroll;
    // </editor-fold>
}
