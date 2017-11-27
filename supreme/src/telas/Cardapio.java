package telas;

import java.awt.Color;
import java.util.ArrayList;

public class Cardapio extends javax.swing.JPanel {
    // <editor-fold defaultstate="collapsed" desc="Classe CARDÁPIO">                          
    private ArrayList<ArrayList<String>> tabela = new ArrayList();
    
    private int quantidade = 1;
    
    private codigo.Conexao conn = new codigo.Conexao();
    private java.util.ArrayList<javax.swing.JPanel> itens = new java.util.ArrayList<>();
    private java.util.ArrayList<javax.swing.JLabel> preco_item = new java.util.ArrayList<>();
    private java.util.ArrayList<javax.swing.JSpinner> qtd_item = new java.util.ArrayList<>();
    private java.util.ArrayList<javax.swing.JLabel> nome_item = new java.util.ArrayList<>();
    private java.util.ArrayList<javax.swing.JToggleButton> check_item = new java.util.ArrayList<>();
    private java.util.ArrayList<javax.swing.JLabel> desc_item = new java.util.ArrayList<>();
    
    private javax.swing.JPanel lista_itens = new javax.swing.JPanel();;
    private javax.swing.JScrollPane scroll = new javax.swing.JScrollPane();;
        
    public Cardapio(codigo.Conexao conex, String tipo) {
        this.conn = conex;
        this.tabela = conn.retornar_query(
            "SELECT itm_codigo,itm_nome,itm_descricao,itm_tipo,itm_valor,itm_status FROM t_itens WHERE itm_tipo='"+tipo.toUpperCase()+"' ORDER BY itm_nome;"
        );
		
        initComponents();
    }
    
    javax.swing.JScrollPane getPanel(){
        return this.scroll;
    }
    
    public ArrayList<ArrayList<String>> getSelecionados(){
        ArrayList<ArrayList<String>> selecionados = new ArrayList();
        for(int i = 0; i<quantidade;i++){
            if(check_item.get(i).isSelected()){
                ArrayList colunas = new ArrayList();
                colunas.add(check_item.get(i).getName());
                colunas.add(qtd_item.get(i).getValue().toString());
                selecionados.add(colunas);
                System.out.println("sel: "+check_item.get(i).getName()+" / "+qtd_item.get(i).getValue().toString());
            }
        }
        return selecionados;
    }
    
    public void resetSelecionados(){
        for(int i = 0; i<quantidade;i++){
            check_item.get(i).setSelected(false);
        }
    }
                  
    private void initComponents() {
		
        quantidade = tabela.size();
        
        scroll.setBackground(new java.awt.Color(244, 244, 255));
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setViewportBorder(null);
        scroll.setOpaque(true);
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
        
        lista_itens.setBackground(new java.awt.Color(244, 244, 255));
        lista_itens.setOpaque(true);
        lista_itens.setAutoscrolls(true);
        
	java.text.NumberFormat formatter = new java.text.DecimalFormat("#0.00");
		
        for(int i = 0; i<quantidade; i++){
            
            itens.get(i).setBackground(new java.awt.Color(244, 244, 255));

            check_item.get(i).setPreferredSize(new java.awt.Dimension(48, 48));
            check_item.get(i).setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check.png"))); // NOI18N
            check_item.get(i).setName(tabela.get(i).get(0));
			
            double valor = Double.parseDouble(tabela.get(i).get(4));
			
            preco_item.get(i).setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
            preco_item.get(i).setText("R$ "+formatter.format(valor));

            qtd_item.get(i).setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
            qtd_item.get(i).setModel(new javax.swing.SpinnerNumberModel(1, 1, 9, 1));
            qtd_item.get(i).setEditor(new javax.swing.JSpinner.NumberEditor(qtd_item.get(i), ""));

            nome_item.get(i).setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
            nome_item.get(i).setText(tabela.get(i).get(1));

            desc_item.get(i).setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
            desc_item.get(i).setText(tabela.get(i).get(2));
            
            if(tabela.get(i).get(5).compareTo("0") == 0){
                check_item.get(i).setEnabled(false);
                preco_item.get(i).setForeground(Color.gray);
                qtd_item.get(i).setEnabled(false);
                nome_item.get(i).setForeground(Color.gray);
                
                desc_item.get(i).setForeground(Color.gray);
                desc_item.get(i).setText("(Item não disponível)");
            }
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
                        .addComponent(desc_item.get(i), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(preco_item.get(i))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(qtd_item.get(i), javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            itemLayout.get(i).setVerticalGroup(
                itemLayout.get(i).createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(itemLayout.get(i).createSequentialGroup()
                        .addContainerGap()
                        .addGroup(itemLayout.get(i).createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(itemLayout.get(i).createSequentialGroup()
                                .addComponent(nome_item.get(i))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemLayout.get(i).createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(qtd_item.get(i), javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(itemLayout.get(i).createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(check_item.get(i), javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(itemLayout.get(i).createSequentialGroup()
                                .addGroup(itemLayout.get(i).createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(desc_item.get(i))
                                    .addComponent(preco_item.get(i), javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
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
        //pack();
    }                 

    // </editor-fold>
}
