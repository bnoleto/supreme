package telas;

import codigo.Conexao;
import java.awt.CardLayout;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Mesa extends javax.swing.JFrame {
    
    // <editor-fold defaultstate="collapsed" desc="Classe MESA (principal)">                          
    private String cpf = "";
    public static int numMesa, codConta;
    private BigDecimal valorConta = new BigDecimal("0.00");
    private BigDecimal valorPedido = new BigDecimal("0.00");
    private String dataHoraAbertura = null;
    private codigo.Conexao conn = new codigo.Conexao(); //conexao com o banco de dados
    private DefaultComboBoxModel defaultComboBox;
    Cardapio bebidas = null;
    Cardapio refeicoes = null;
    Cardapio lanches = null;
    Cardapio sobremesas = null;
    private Object[][] tabela_selecionados = null;
    String telaAnterior = "";
    
    javax.swing.JScrollPane cardapioAtual = new javax.swing.JScrollPane();
    
    public Mesa(Conexao conex) {
        
        this.conn = conex;
        bebidas = new Cardapio(conn,"BEBIDAS");
        refeicoes = new Cardapio(conn,"REFEIÇÕES");
        lanches = new Cardapio(conn,"LANCHES");
        sobremesas = new Cardapio(conn,"SOBREMESAS");
        initComponents();
        fillComboSelectMesa();
    }

    // retornará a quantidade de itens que estão selecionados.
    public int qtdSelecionados(){
        
        int quantidade = 0;
        
        for(int i = 0; i< bebidas.getSelecionados().size(); i++){
            quantidade++;
        }
        for(int i = 0; i< lanches.getSelecionados().size(); i++){
            quantidade++;
        }
        for(int i = 0; i< refeicoes.getSelecionados().size(); i++){
            quantidade++;
        }
        for(int i = 0; i< sobremesas.getSelecionados().size(); i++){
            quantidade++;
        }
        return quantidade;
    }
    
    public void limparFooters(){
        footerBebidas.setText("");
        footerSobremesas.setText("");
        footerLanches.setText("");
        footerRefeicoes.setText("");
    }
    
    private void finalizarConta() {
        conn.comando_sql("UPDATE t_contas SET conta_status='FECHADO',conta_fechamento=CURRENT_TIMESTAMP WHERE conta_codigo="+codConta+";");
        showCard("FinalMessage");
        resetarMesa();
        
    }
    
    void resetarMesa(){
        
        valorConta = BigDecimal.ZERO;
        valorPedido = BigDecimal.ZERO;
        telaAnterior = "";
        limparFooters();
        liberarMesa();
        
        fecharConta.setEnabled(false);
        
        bebidas.resetSelecionados();
        refeicoes.resetSelecionados();
        lanches.resetSelecionados();
        sobremesas.resetSelecionados();
        
    }
    
    // Irá liberar a mesa no banco de dados
    public void liberarMesa(){
        conn.comando_sql("UPDATE t_mesas SET mesa_status = 0 WHERE mesa_codigo = "+numMesa+";");
    }
    
    public void atualizarResumo(){
        
        StringBuilder sb = new StringBuilder();
        java.text.NumberFormat formatter = new java.text.DecimalFormat("#0.00");
        
        
        
        sb.append(String.format("%-40s", "ABERTURA: " + dataHoraAbertura)+"\n");
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
        
        sb.append("========================================\n");
        sb.append(String.format("%-20s", "CÓD. CONTA: " + String.format("%06d", codConta)) + String.format("%20s", "VALOR TOTAL: " + formatter.format(valorConta)) + "\n\n");
        sb.append("              BOM APETITE!              \n");
        

        showResumo.setText(sb.toString());
    }
    
    public Object[][] retornarSelecionados(){
        
        int linhas = bebidas.getSelecionados().size()+ lanches.getSelecionados().size() + refeicoes.getSelecionados().size() + sobremesas.getSelecionados().size() ;
        
        Object[][] tabela = new Object[linhas][5];
        int i = 0;
        
        valorPedido = BigDecimal.ZERO;
        
        for(int j = 0; j<bebidas.getSelecionados().size();j++){
            int cod = Integer.parseInt(bebidas.getSelecionados().get(j).get(0));
            BigDecimal valor = new BigDecimal(conn.retornar_valor(cod, "itm_valor","itm_codigo", "t_itens"));
            BigDecimal qtd = new BigDecimal(bebidas.getSelecionados().get(j).get(1));
            
            BigDecimal subtotal = valor.multiply(qtd).setScale(2, RoundingMode.HALF_EVEN);
            BigDecimal bd = valorPedido.add(subtotal).setScale(2, RoundingMode.HALF_EVEN);
            valorPedido = bd;
            
            java.text.NumberFormat formatter = new java.text.DecimalFormat("#0.00");
            
            tabela[i][0] = conn.retornar_valor(cod, "itm_tipo","itm_codigo", "t_itens");
            tabela[i][1] = conn.retornar_valor(cod, "itm_nome","itm_codigo", "t_itens");
            tabela[i][2] = "R$ "+formatter.format(valor);
            tabela[i][3] = bebidas.getSelecionados().get(j).get(1);
            tabela[i][4] = "R$ "+formatter.format(subtotal.floatValue());
            
            i++;
        }
        for(int j = 0; j<lanches.getSelecionados().size();j++){
            int cod = Integer.parseInt(lanches.getSelecionados().get(j).get(0));
            BigDecimal valor = new BigDecimal(conn.retornar_valor(cod, "itm_valor","itm_codigo", "t_itens"));
            BigDecimal qtd = new BigDecimal(lanches.getSelecionados().get(j).get(1));
            
            BigDecimal subtotal = valor.multiply(qtd).setScale(2, RoundingMode.HALF_EVEN);
            BigDecimal bd = valorPedido.add(subtotal).setScale(2, RoundingMode.HALF_EVEN);
            valorPedido = bd;
            
            java.text.NumberFormat formatter = new java.text.DecimalFormat("#0.00");
            
            tabela[i][0] = conn.retornar_valor(cod, "itm_tipo","itm_codigo", "t_itens");
            tabela[i][1] = conn.retornar_valor(cod, "itm_nome","itm_codigo", "t_itens");
            tabela[i][2] = "R$ "+formatter.format(valor);
            tabela[i][3] = lanches.getSelecionados().get(j).get(1);
            tabela[i][4] = "R$ "+formatter.format(subtotal.floatValue());
            
            i++;
        }
        for(int j = 0; j<refeicoes.getSelecionados().size();j++){
            int cod = Integer.parseInt(refeicoes.getSelecionados().get(j).get(0));
            BigDecimal valor = new BigDecimal(conn.retornar_valor(cod, "itm_valor","itm_codigo", "t_itens"));
            BigDecimal qtd = new BigDecimal(refeicoes.getSelecionados().get(j).get(1));
            
            BigDecimal subtotal = valor.multiply(qtd).setScale(2, RoundingMode.HALF_EVEN);
            BigDecimal bd = valorPedido.add(subtotal).setScale(2, RoundingMode.HALF_EVEN);
            valorPedido = bd;
            
            java.text.NumberFormat formatter = new java.text.DecimalFormat("#0.00");
            
            tabela[i][0] = conn.retornar_valor(cod, "itm_tipo","itm_codigo", "t_itens");
            tabela[i][1] = conn.retornar_valor(cod, "itm_nome","itm_codigo", "t_itens");
            tabela[i][2] = "R$ "+formatter.format(valor);
            tabela[i][3] = refeicoes.getSelecionados().get(j).get(1);
            tabela[i][4] = "R$ "+formatter.format(subtotal.floatValue());
            
            i++;
        }
        for(int j = 0; j<sobremesas.getSelecionados().size();j++){
            int cod = Integer.parseInt(sobremesas.getSelecionados().get(j).get(0));
            BigDecimal valor = new BigDecimal(conn.retornar_valor(cod, "itm_valor","itm_codigo", "t_itens"));
            BigDecimal qtd = new BigDecimal(sobremesas.getSelecionados().get(j).get(1));
            
            BigDecimal subtotal = valor.multiply(qtd).setScale(2, RoundingMode.HALF_EVEN);
            BigDecimal bd = valorPedido.add(subtotal).setScale(2, RoundingMode.HALF_EVEN);
            valorPedido = bd;
            
            java.text.NumberFormat formatter = new java.text.DecimalFormat("#0.00");
            
            tabela[i][0] = conn.retornar_valor(cod, "itm_tipo","itm_codigo", "t_itens");
            tabela[i][1] = conn.retornar_valor(cod, "itm_nome","itm_codigo", "t_itens");
            tabela[i][2] = "R$ "+formatter.format(valor);
            tabela[i][3] = sobremesas.getSelecionados().get(j).get(1);
            tabela[i][4] = "R$ "+formatter.format(subtotal.floatValue());
            
            i++;
        }
        
        for(i=0;i<linhas;i++){
                System.out.println(tabela[i][0]+" || "+tabela[i][1]+" || "+tabela[i][2]+" || "+tabela[i][3]+" || "+tabela[i][4]);
        }
        
        this.tabela_selecionados = tabela;
        return tabela;
        
    }
    
    public void reconstruirTabela(){
        retornarSelecionados();
        
        tabela_itens.setModel(new javax.swing.table.DefaultTableModel(tabela_selecionados,
            new String [] {
                "Tipo", "Produto", "Valor Unitário", "Quantidade", "Subtotal"
            }));
        
        tabela_itens.setDefaultEditor(Object.class, null);
        tabela_itens.getColumnModel().getColumn(0).setPreferredWidth(125);
        tabela_itens.getColumnModel().getColumn(1).setPreferredWidth(300);
        tabela_itens.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabela_itens.getColumnModel().getColumn(3).setPreferredWidth(83);
        tabela_itens.getColumnModel().getColumn(4).setPreferredWidth(100);
        
        java.text.NumberFormat formatter = new java.text.DecimalFormat("#0.00");
        
        jLabel1.setText("Total deste pedido: R$ " + formatter.format(valorPedido));
        
 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        SelectMesaProvavel = new javax.swing.JPanel();
        headerSelectMesa = new javax.swing.JLabel();
        footerSelectMesa = new javax.swing.JLabel();
        comboBoxSelectMesa = new javax.swing.JComboBox<>();
        textoSelectMesa = new javax.swing.JLabel();
        selectMesaButton = new javax.swing.JButton();
        TelaInicial = new javax.swing.JPanel();
        headerTelaInicial = new javax.swing.JLabel();
        footerTelaInicial = new javax.swing.JLabel();
        Iniciar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Home = new javax.swing.JPanel();
        headerHome = new javax.swing.JLabel();
        footerHome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        showResumo = new javax.swing.JTextArea();
        headerResumo = new javax.swing.JLabel();
        novoPedido = new javax.swing.JButton();
        fecharConta = new javax.swing.JButton();
        headerOptions = new javax.swing.JLabel();
        Close = new javax.swing.JPanel();
        headerClose = new javax.swing.JLabel();
        footerClose = new javax.swing.JLabel();
        cancelClose = new javax.swing.JButton();
        textoConfirmaFecha = new javax.swing.JLabel();
        confirmClose = new javax.swing.JButton();
        CPF = new javax.swing.JPanel();
        questCPF = new javax.swing.JPanel();
        headerCPF = new javax.swing.JLabel();
        footerCPF = new javax.swing.JLabel();
        questCPFText = new javax.swing.JLabel();
        yesCPF = new javax.swing.JButton();
        noCPF = new javax.swing.JButton();
        getCPF = new javax.swing.JPanel();
        headerCPF1 = new javax.swing.JLabel();
        footerCPF1 = new javax.swing.JLabel();
        getCPFText = new javax.swing.JLabel();
        showCPF = new javax.swing.JTextField();
        teclas = new javax.swing.JPanel();
        cpf6 = new javax.swing.JButton();
        cpf9 = new javax.swing.JButton();
        cpf8 = new javax.swing.JButton();
        cpf7 = new javax.swing.JButton();
        cpf5 = new javax.swing.JButton();
        cpf4 = new javax.swing.JButton();
        cpf3 = new javax.swing.JButton();
        cpf2 = new javax.swing.JButton();
        cpf1 = new javax.swing.JButton();
        cpf0 = new javax.swing.JButton();
        cpfErase = new javax.swing.JButton();
        cpfFinish = new javax.swing.JButton();
        invalidCPF = new javax.swing.JPanel();
        headerCPF2 = new javax.swing.JLabel();
        footerCPF2 = new javax.swing.JLabel();
        invalidCPFText = new javax.swing.JLabel();
        cpfTryAgain = new javax.swing.JButton();
        FinalMessage = new javax.swing.JPanel();
        headerFinalMessage = new javax.swing.JLabel();
        footerFinalMessage = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bt_concluido = new javax.swing.JButton();
        Categories = new javax.swing.JPanel();
        menuCardapio = new javax.swing.JPanel();
        headerCategories = new javax.swing.JLabel();
        footerCategories = new javax.swing.JLabel();
        Cat1 = new javax.swing.JButton();
        Cat3 = new javax.swing.JButton();
        Cat4 = new javax.swing.JButton();
        Cat2 = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        cardapioBebidas = new javax.swing.JPanel();
        headerBebidas = new javax.swing.JLabel();
        footerBebidas = new javax.swing.JLabel();
        bt_voltar_bebidas = new javax.swing.JButton();
        bt_confirmar_bebidas = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lista_itens = new javax.swing.JScrollPane();
        cardapioRefeicoes = new javax.swing.JPanel();
        headerRefeicoes = new javax.swing.JLabel();
        footerRefeicoes = new javax.swing.JLabel();
        bt_voltar_refeicoes = new javax.swing.JButton();
        bt_confirmar_refeicoes = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lista_itens1 = new javax.swing.JScrollPane();
        cardapioSobremesas = new javax.swing.JPanel();
        headerSobremesas = new javax.swing.JLabel();
        footerSobremesas = new javax.swing.JLabel();
        bt_voltar_sobremesas = new javax.swing.JButton();
        bt_confirmar_sobremesas = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lista_itens2 = new javax.swing.JScrollPane();
        cardapioLanches = new javax.swing.JPanel();
        headerLanches = new javax.swing.JLabel();
        footerLanches = new javax.swing.JLabel();
        bt_voltar_lanches = new javax.swing.JButton();
        bt_confirmar_lanches = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lista_itens3 = new javax.swing.JScrollPane();
        confirmacaoPedido = new javax.swing.JPanel();
        headerConfirmacao = new javax.swing.JLabel();
        footerConfirmacao = new javax.swing.JLabel();
        backButton1 = new javax.swing.JButton();
        bt_confirmar4 = new javax.swing.JButton();
        pane_tabela_itens = new javax.swing.JScrollPane();
        tabela_itens = new javax.swing.JTable();
        tabela_itens.setFillsViewportHeight(true);
        jLabel1 = new javax.swing.JLabel();
        Aviso_aguardandoPedido = new javax.swing.JPanel();
        headerFinalMessage1 = new javax.swing.JLabel();
        footerFinalMessage1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        bt_voltar = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SUPREME " +Login.versao_supreme);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        setForeground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(720, 480));
        setName(""); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(720, 480));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        panelPrincipal.setInheritsPopupMenu(true);
        panelPrincipal.setMinimumSize(new java.awt.Dimension(720, 480));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(720, 480));
        panelPrincipal.setLayout(new java.awt.CardLayout());

        SelectMesaProvavel.setBackground(new java.awt.Color(244, 244, 255));
        SelectMesaProvavel.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        SelectMesaProvavel.setInheritsPopupMenu(true);
        SelectMesaProvavel.setMinimumSize(new java.awt.Dimension(720, 480));

        headerSelectMesa.setBackground(new java.awt.Color(0, 0, 127));
        headerSelectMesa.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerSelectMesa.setForeground(new java.awt.Color(255, 255, 255));
        headerSelectMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerSelectMesa.setText("Selecione a sua mesa");
        headerSelectMesa.setToolTipText("");
        headerSelectMesa.setOpaque(true);

        footerSelectMesa.setBackground(new java.awt.Color(0, 0, 127));
        footerSelectMesa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        footerSelectMesa.setForeground(new java.awt.Color(255, 255, 255));
        footerSelectMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        footerSelectMesa.setText("Conectado ao servidor "+conn.url+" com sucesso!");
        footerSelectMesa.setToolTipText("");
        footerSelectMesa.setOpaque(true);

        comboBoxSelectMesa.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        comboBoxSelectMesa.setMaximumRowCount(6);
        comboBoxSelectMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSelectMesaActionPerformed(evt);
            }
        });

        textoSelectMesa.setFont(new java.awt.Font("Caladea", 3, 30)); // NOI18N
        textoSelectMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoSelectMesa.setText("Sr. "+conn.getNome()+", informe o número desta mesa:");

        selectMesaButton.setBackground(new java.awt.Color(0, 0, 76));
        selectMesaButton.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        selectMesaButton.setForeground(new java.awt.Color(244, 244, 255));
        selectMesaButton.setText("Prosseguir");
        selectMesaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selectMesaButton.setMinimumSize(new java.awt.Dimension(170, 80));
        selectMesaButton.setPreferredSize(new java.awt.Dimension(170, 80));
        selectMesaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectMesaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SelectMesaProvavelLayout = new javax.swing.GroupLayout(SelectMesaProvavel);
        SelectMesaProvavel.setLayout(SelectMesaProvavelLayout);
        SelectMesaProvavelLayout.setHorizontalGroup(
            SelectMesaProvavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerSelectMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(footerSelectMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SelectMesaProvavelLayout.createSequentialGroup()
                .addComponent(textoSelectMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(SelectMesaProvavelLayout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addGroup(SelectMesaProvavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectMesaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxSelectMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SelectMesaProvavelLayout.setVerticalGroup(
            SelectMesaProvavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SelectMesaProvavelLayout.createSequentialGroup()
                .addComponent(headerSelectMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(textoSelectMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboBoxSelectMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectMesaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(footerSelectMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPrincipal.add(SelectMesaProvavel, "SelectMesa");

        TelaInicial.setBackground(new java.awt.Color(244, 244, 255));
        TelaInicial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TelaInicial.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        TelaInicial.setInheritsPopupMenu(true);
        TelaInicial.setMinimumSize(new java.awt.Dimension(720, 480));

        headerTelaInicial.setBackground(new java.awt.Color(0, 0, 127));
        headerTelaInicial.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerTelaInicial.setForeground(new java.awt.Color(255, 255, 255));
        headerTelaInicial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerTelaInicial.setText("Mesa " + numMesa);
        headerTelaInicial.setToolTipText("");
        headerTelaInicial.setOpaque(true);

        footerTelaInicial.setBackground(new java.awt.Color(0, 0, 127));
        footerTelaInicial.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        footerTelaInicial.setForeground(new java.awt.Color(255, 255, 255));
        footerTelaInicial.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        footerTelaInicial.setText(" ");
        footerTelaInicial.setToolTipText("");
        footerTelaInicial.setOpaque(true);

        Iniciar.setBackground(new java.awt.Color(0, 0, 76));
        Iniciar.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        Iniciar.setForeground(new java.awt.Color(244, 244, 255));
        Iniciar.setText("Iniciar");
        Iniciar.setToolTipText("");
        Iniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Iniciar.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        Iniciar.setMinimumSize(new java.awt.Dimension(250, 100));
        Iniciar.setPreferredSize(new java.awt.Dimension(250, 100));
        Iniciar.setSelected(true);
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Caladea", 3, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Seja bem-vindo ao nosso restaurante!");

        javax.swing.GroupLayout TelaInicialLayout = new javax.swing.GroupLayout(TelaInicial);
        TelaInicial.setLayout(TelaInicialLayout);
        TelaInicialLayout.setHorizontalGroup(
            TelaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerTelaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(footerTelaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(TelaInicialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TelaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TelaInicialLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
                .addContainerGap())
        );
        TelaInicialLayout.setVerticalGroup(
            TelaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaInicialLayout.createSequentialGroup()
                .addComponent(headerTelaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addComponent(Iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(footerTelaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPrincipal.add(TelaInicial, "TelaInicial");

        Home.setBackground(new java.awt.Color(244, 244, 255));
        Home.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Home.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        Home.setInheritsPopupMenu(true);
        Home.setMinimumSize(new java.awt.Dimension(720, 480));
        Home.setPreferredSize(new java.awt.Dimension(720, 480));

        headerHome.setBackground(new java.awt.Color(0, 0, 127));
        headerHome.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerHome.setForeground(new java.awt.Color(255, 255, 255));
        headerHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerHome.setText("Mesa ##");
        headerHome.setToolTipText("");
        headerHome.setOpaque(true);

        footerHome.setBackground(new java.awt.Color(0, 0, 127));
        footerHome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        footerHome.setForeground(new java.awt.Color(255, 255, 255));
        footerHome.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        footerHome.setText(" ");
        footerHome.setToolTipText("");
        footerHome.setOpaque(true);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        showResumo.setEditable(false);
        showResumo.setColumns(1);
        showResumo.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        showResumo.setRows(5);
        showResumo.setAutoscrolls(false);
        showResumo.setFocusable(false);
        showResumo.setRequestFocusEnabled(false);
        showResumo.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(showResumo);

        headerResumo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        headerResumo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerResumo.setText("Resumo:");

        novoPedido.setBackground(new java.awt.Color(0, 0, 76));
        novoPedido.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        novoPedido.setForeground(new java.awt.Color(244, 244, 255));
        novoPedido.setText("Novo Pedido");
        novoPedido.setToolTipText("");
        novoPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        novoPedido.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        novoPedido.setMinimumSize(new java.awt.Dimension(250, 100));
        novoPedido.setPreferredSize(new java.awt.Dimension(250, 100));
        novoPedido.setSelected(true);
        novoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoPedidoActionPerformed(evt);
            }
        });

        fecharConta.setBackground(new java.awt.Color(0, 0, 76));
        fecharConta.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        fecharConta.setForeground(new java.awt.Color(244, 244, 255));
        fecharConta.setText("Fechar Conta");
        fecharConta.setToolTipText("");
        fecharConta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fecharConta.setEnabled(false);
        fecharConta.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        fecharConta.setMinimumSize(new java.awt.Dimension(250, 100));
        fecharConta.setPreferredSize(new java.awt.Dimension(250, 100));
        fecharConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharContaActionPerformed(evt);
            }
        });

        headerOptions.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        headerOptions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerOptions.setText("Opções:");

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(footerHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(novoPedido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerOptions, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fecharConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(headerResumo, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addComponent(headerHome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(headerResumo)
                    .addComponent(headerOptions))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGap(0, 59, Short.MAX_VALUE)
                        .addComponent(novoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(fecharConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 74, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(footerHome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPrincipal.add(Home, "Home");

        Close.setBackground(new java.awt.Color(244, 244, 255));
        Close.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        Close.setInheritsPopupMenu(true);
        Close.setMinimumSize(new java.awt.Dimension(720, 480));

        headerClose.setBackground(new java.awt.Color(0, 0, 127));
        headerClose.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerClose.setForeground(new java.awt.Color(255, 255, 255));
        headerClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerClose.setText("Fechar Conta");
        headerClose.setToolTipText("");
        headerClose.setOpaque(true);

        footerClose.setBackground(new java.awt.Color(0, 0, 127));
        footerClose.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        footerClose.setForeground(new java.awt.Color(255, 255, 255));
        footerClose.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        footerClose.setText(" ");
        footerClose.setToolTipText("");
        footerClose.setOpaque(true);

        cancelClose.setBackground(new java.awt.Color(0, 0, 76));
        cancelClose.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        cancelClose.setForeground(new java.awt.Color(244, 244, 255));
        cancelClose.setText("Cancelar");
        cancelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelClose.setMinimumSize(new java.awt.Dimension(170, 80));
        cancelClose.setPreferredSize(new java.awt.Dimension(170, 80));
        cancelClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelCloseActionPerformed(evt);
            }
        });

        textoConfirmaFecha.setFont(new java.awt.Font("Caladea", 3, 30)); // NOI18N
        textoConfirmaFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoConfirmaFecha.setText("Confirma o fechamento de sua conta?");

        confirmClose.setBackground(new java.awt.Color(0, 0, 76));
        confirmClose.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        confirmClose.setForeground(new java.awt.Color(244, 244, 255));
        confirmClose.setText("Confirmar");
        confirmClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmClose.setMinimumSize(new java.awt.Dimension(170, 80));
        confirmClose.setPreferredSize(new java.awt.Dimension(170, 80));
        confirmClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CloseLayout = new javax.swing.GroupLayout(Close);
        Close.setLayout(CloseLayout);
        CloseLayout.setHorizontalGroup(
            CloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(footerClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(textoConfirmaFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(CloseLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(confirmClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addComponent(cancelClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(172, 172, 172))
        );
        CloseLayout.setVerticalGroup(
            CloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CloseLayout.createSequentialGroup()
                .addComponent(headerClose, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(textoConfirmaFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addGroup(CloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(footerClose, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        panelPrincipal.add(Close, "Close");

        CPF.setBackground(new java.awt.Color(255, 255, 255));
        CPF.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        CPF.setInheritsPopupMenu(true);
        CPF.setMinimumSize(new java.awt.Dimension(720, 480));
        CPF.setPreferredSize(new java.awt.Dimension(720, 480));
        CPF.setLayout(new java.awt.CardLayout());

        questCPF.setBackground(new java.awt.Color(244, 244, 255));
        questCPF.setMinimumSize(new java.awt.Dimension(720, 480));

        headerCPF.setBackground(new java.awt.Color(0, 0, 127));
        headerCPF.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerCPF.setForeground(new java.awt.Color(255, 255, 255));
        headerCPF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerCPF.setText("CPF");
        headerCPF.setToolTipText("");
        headerCPF.setOpaque(true);

        footerCPF.setBackground(new java.awt.Color(0, 0, 127));
        footerCPF.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        footerCPF.setForeground(new java.awt.Color(255, 255, 255));
        footerCPF.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        footerCPF.setText(" ");
        footerCPF.setToolTipText("");
        footerCPF.setOpaque(true);

        questCPFText.setBackground(new java.awt.Color(244, 244, 255));
        questCPFText.setFont(new java.awt.Font("Caladea", 3, 30)); // NOI18N
        questCPFText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        questCPFText.setText("CPF na nota?");
        questCPFText.setMaximumSize(new java.awt.Dimension(18300, 35000));

        yesCPF.setBackground(new java.awt.Color(0, 0, 76));
        yesCPF.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        yesCPF.setForeground(new java.awt.Color(244, 244, 255));
        yesCPF.setText("Sim");
        yesCPF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yesCPF.setMinimumSize(new java.awt.Dimension(100, 80));
        yesCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesCPFActionPerformed(evt);
            }
        });

        noCPF.setBackground(new java.awt.Color(0, 0, 76));
        noCPF.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        noCPF.setForeground(new java.awt.Color(244, 244, 255));
        noCPF.setText("Não");
        noCPF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        noCPF.setMinimumSize(new java.awt.Dimension(100, 80));
        noCPF.setPreferredSize(new java.awt.Dimension(100, 80));
        noCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noCPFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout questCPFLayout = new javax.swing.GroupLayout(questCPF);
        questCPF.setLayout(questCPFLayout);
        questCPFLayout.setHorizontalGroup(
            questCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(footerCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addComponent(questCPFText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(questCPFLayout.createSequentialGroup()
                .addContainerGap(223, Short.MAX_VALUE)
                .addComponent(yesCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(noCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        questCPFLayout.setVerticalGroup(
            questCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(questCPFLayout.createSequentialGroup()
                .addComponent(headerCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(questCPFText, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(questCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(yesCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(footerCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        CPF.add(questCPF, "questCPF");

        getCPF.setBackground(new java.awt.Color(244, 244, 255));
        getCPF.setMinimumSize(new java.awt.Dimension(720, 480));

        headerCPF1.setBackground(new java.awt.Color(0, 0, 127));
        headerCPF1.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerCPF1.setForeground(new java.awt.Color(255, 255, 255));
        headerCPF1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerCPF1.setText("CPF");
        headerCPF1.setToolTipText("");
        headerCPF1.setOpaque(true);

        footerCPF1.setBackground(new java.awt.Color(0, 0, 127));
        footerCPF1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        footerCPF1.setForeground(new java.awt.Color(255, 255, 255));
        footerCPF1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        footerCPF1.setText(" ");
        footerCPF1.setToolTipText("");
        footerCPF1.setOpaque(true);

        getCPFText.setFont(new java.awt.Font("Caladea", 3, 30)); // NOI18N
        getCPFText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getCPFText.setText("Informe seu CPF (apenas números):");
        getCPFText.setMaximumSize(new java.awt.Dimension(48000, 35000));

        showCPF.setEditable(false);
        showCPF.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        showCPF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        showCPF.setMinimumSize(new java.awt.Dimension(400, 50));
        showCPF.setPreferredSize(new java.awt.Dimension(400, 50));

        teclas.setBackground(new java.awt.Color(244, 244, 255));

        cpf6.setBackground(new java.awt.Color(0, 0, 76));
        cpf6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cpf6.setForeground(new java.awt.Color(244, 244, 255));
        cpf6.setText("6");
        cpf6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cpf6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf6.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf6.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf6.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        cpf9.setBackground(new java.awt.Color(0, 0, 76));
        cpf9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cpf9.setForeground(new java.awt.Color(244, 244, 255));
        cpf9.setText("9");
        cpf9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cpf9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf9.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf9.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf9.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        cpf8.setBackground(new java.awt.Color(0, 0, 76));
        cpf8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cpf8.setForeground(new java.awt.Color(244, 244, 255));
        cpf8.setText("8");
        cpf8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cpf8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf8.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf8.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf8.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        cpf7.setBackground(new java.awt.Color(0, 0, 76));
        cpf7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cpf7.setForeground(new java.awt.Color(244, 244, 255));
        cpf7.setText("7");
        cpf7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cpf7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf7.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf7.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf7.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        cpf5.setBackground(new java.awt.Color(0, 0, 76));
        cpf5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cpf5.setForeground(new java.awt.Color(244, 244, 255));
        cpf5.setText("5");
        cpf5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cpf5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf5.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf5.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf5.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        cpf4.setBackground(new java.awt.Color(0, 0, 76));
        cpf4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cpf4.setForeground(new java.awt.Color(244, 244, 255));
        cpf4.setText("4");
        cpf4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cpf4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf4.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf4.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf4.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        cpf3.setBackground(new java.awt.Color(0, 0, 76));
        cpf3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cpf3.setForeground(new java.awt.Color(244, 244, 255));
        cpf3.setText("3");
        cpf3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cpf3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf3.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf3.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf3.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        cpf2.setBackground(new java.awt.Color(0, 0, 76));
        cpf2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cpf2.setForeground(new java.awt.Color(244, 244, 255));
        cpf2.setText("2");
        cpf2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cpf2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf2.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf2.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf2.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        cpf1.setBackground(new java.awt.Color(0, 0, 76));
        cpf1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cpf1.setForeground(new java.awt.Color(244, 244, 255));
        cpf1.setText("1");
        cpf1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cpf1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf1.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf1.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf1.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        cpf0.setBackground(new java.awt.Color(0, 0, 76));
        cpf0.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cpf0.setForeground(new java.awt.Color(244, 244, 255));
        cpf0.setText("0");
        cpf0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cpf0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf0.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf0.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf0.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        cpfErase.setBackground(new java.awt.Color(0, 0, 76));
        cpfErase.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cpfErase.setForeground(new java.awt.Color(244, 244, 255));
        cpfErase.setText("Apagar");
        cpfErase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cpfErase.setMaximumSize(new java.awt.Dimension(111342, 123139));
        cpfErase.setMinimumSize(new java.awt.Dimension(145, 60));
        cpfErase.setPreferredSize(new java.awt.Dimension(145, 60));
        cpfErase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfEraseActionPerformed(evt);
            }
        });

        cpfFinish.setBackground(new java.awt.Color(0, 0, 76));
        cpfFinish.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cpfFinish.setForeground(new java.awt.Color(244, 244, 255));
        cpfFinish.setText("Finalizar");
        cpfFinish.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cpfFinish.setMaximumSize(new java.awt.Dimension(1252342, 323429));
        cpfFinish.setMinimumSize(new java.awt.Dimension(145, 60));
        cpfFinish.setPreferredSize(new java.awt.Dimension(145, 60));
        cpfFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfFinishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout teclasLayout = new javax.swing.GroupLayout(teclas);
        teclas.setLayout(teclasLayout);
        teclasLayout.setHorizontalGroup(
            teclasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teclasLayout.createSequentialGroup()
                .addGroup(teclasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(teclasLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(teclasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpf4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpf1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpf7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(teclasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cpfErase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(teclasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(teclasLayout.createSequentialGroup()
                        .addComponent(cpf0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cpfFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(teclasLayout.createSequentialGroup()
                        .addComponent(cpf2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cpf3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(teclasLayout.createSequentialGroup()
                        .addGroup(teclasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cpf5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpf8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(teclasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpf9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpf6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        teclasLayout.setVerticalGroup(
            teclasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teclasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(teclasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpf7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpf8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpf9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(teclasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpf4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpf5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpf6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(teclasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpf2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpf1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpf3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(teclasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpf0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfErase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout getCPFLayout = new javax.swing.GroupLayout(getCPF);
        getCPF.setLayout(getCPFLayout);
        getCPFLayout.setHorizontalGroup(
            getCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerCPF1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(footerCPF1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(getCPFText, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addGroup(getCPFLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(getCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(teclas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, getCPFLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(showCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        getCPFLayout.setVerticalGroup(
            getCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(getCPFLayout.createSequentialGroup()
                .addComponent(headerCPF1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getCPFText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(showCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(teclas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(footerCPF1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        CPF.add(getCPF, "getCPF");

        invalidCPF.setBackground(new java.awt.Color(244, 244, 255));
        invalidCPF.setMinimumSize(new java.awt.Dimension(720, 480));
        invalidCPF.setPreferredSize(new java.awt.Dimension(720, 480));

        headerCPF2.setBackground(new java.awt.Color(0, 0, 127));
        headerCPF2.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerCPF2.setForeground(new java.awt.Color(255, 255, 255));
        headerCPF2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerCPF2.setText("CPF");
        headerCPF2.setToolTipText("");
        headerCPF2.setOpaque(true);

        footerCPF2.setBackground(new java.awt.Color(0, 0, 127));
        footerCPF2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        footerCPF2.setForeground(new java.awt.Color(255, 255, 255));
        footerCPF2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        footerCPF2.setText(" ");
        footerCPF2.setToolTipText("");
        footerCPF2.setOpaque(true);

        invalidCPFText.setBackground(new java.awt.Color(244, 244, 255));
        invalidCPFText.setFont(new java.awt.Font("Caladea", 3, 30)); // NOI18N
        invalidCPFText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidCPFText.setText("CPF Inválido!");

        cpfTryAgain.setBackground(new java.awt.Color(0, 0, 76));
        cpfTryAgain.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cpfTryAgain.setForeground(new java.awt.Color(244, 244, 255));
        cpfTryAgain.setText("Tentar novamente");
        cpfTryAgain.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cpfTryAgain.setMaximumSize(new java.awt.Dimension(229123123, 12313139));
        cpfTryAgain.setMinimumSize(new java.awt.Dimension(240, 87));
        cpfTryAgain.setPreferredSize(new java.awt.Dimension(240, 87));
        cpfTryAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfTryAgainActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout invalidCPFLayout = new javax.swing.GroupLayout(invalidCPF);
        invalidCPF.setLayout(invalidCPFLayout);
        invalidCPFLayout.setHorizontalGroup(
            invalidCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerCPF2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(footerCPF2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(invalidCPFText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addGroup(invalidCPFLayout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(cpfTryAgain, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        invalidCPFLayout.setVerticalGroup(
            invalidCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(invalidCPFLayout.createSequentialGroup()
                .addComponent(headerCPF2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(invalidCPFText, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(cpfTryAgain, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(footerCPF2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        CPF.add(invalidCPF, "invalidCPF");

        panelPrincipal.add(CPF, "CPF");

        FinalMessage.setBackground(new java.awt.Color(244, 244, 255));
        FinalMessage.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        FinalMessage.setInheritsPopupMenu(true);
        FinalMessage.setMinimumSize(new java.awt.Dimension(720, 480));
        FinalMessage.setPreferredSize(new java.awt.Dimension(720, 480));

        headerFinalMessage.setBackground(new java.awt.Color(0, 0, 127));
        headerFinalMessage.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerFinalMessage.setForeground(new java.awt.Color(255, 255, 255));
        headerFinalMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerFinalMessage.setText("Pagamento");
        headerFinalMessage.setToolTipText("");
        headerFinalMessage.setOpaque(true);

        footerFinalMessage.setBackground(new java.awt.Color(0, 0, 127));
        footerFinalMessage.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        footerFinalMessage.setForeground(new java.awt.Color(255, 255, 255));
        footerFinalMessage.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        footerFinalMessage.setText(" ");
        footerFinalMessage.setToolTipText("");
        footerFinalMessage.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("Caladea", 3, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Por favor, compareça ao caixa para finalizar o pagamento.");

        jLabel7.setFont(new java.awt.Font("Caladea", 3, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Agradecemos aos nossos clientes pela preferência.");

        jLabel9.setFont(new java.awt.Font("Caladea", 3, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Quase lá...");

        bt_concluido.setBackground(new java.awt.Color(0, 0, 76));
        bt_concluido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_concluido.setForeground(new java.awt.Color(244, 244, 255));
        bt_concluido.setText("Concluído");
        bt_concluido.setToolTipText("Clique aqui para fazer um novo pedido!");
        bt_concluido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_concluido.setMaximumSize(new java.awt.Dimension(2050, 4500));
        bt_concluido.setMinimumSize(new java.awt.Dimension(110, 35));
        bt_concluido.setPreferredSize(new java.awt.Dimension(110, 35));
        bt_concluido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_concluidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FinalMessageLayout = new javax.swing.GroupLayout(FinalMessage);
        FinalMessage.setLayout(FinalMessageLayout);
        FinalMessageLayout.setHorizontalGroup(
            FinalMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(footerFinalMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerFinalMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addGroup(FinalMessageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FinalMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, FinalMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_concluido, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        FinalMessageLayout.setVerticalGroup(
            FinalMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FinalMessageLayout.createSequentialGroup()
                .addComponent(headerFinalMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(bt_concluido, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(footerFinalMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPrincipal.add(FinalMessage, "FinalMessage");

        Categories.setLayout(new java.awt.CardLayout());

        menuCardapio.setBackground(new java.awt.Color(244, 244, 255));
        menuCardapio.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        menuCardapio.setInheritsPopupMenu(true);
        menuCardapio.setMinimumSize(new java.awt.Dimension(720, 480));
        menuCardapio.setPreferredSize(new java.awt.Dimension(720, 480));

        headerCategories.setBackground(new java.awt.Color(0, 0, 127));
        headerCategories.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerCategories.setForeground(new java.awt.Color(255, 255, 255));
        headerCategories.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerCategories.setText("Categorias");
        headerCategories.setToolTipText("");
        headerCategories.setOpaque(true);

        footerCategories.setBackground(new java.awt.Color(0, 0, 127));
        footerCategories.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        footerCategories.setForeground(new java.awt.Color(255, 255, 255));
        footerCategories.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        footerCategories.setText(" ");
        footerCategories.setToolTipText("");
        footerCategories.setOpaque(true);

        Cat1.setBackground(new java.awt.Color(0, 0, 76));
        Cat1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        Cat1.setForeground(new java.awt.Color(244, 244, 255));
        Cat1.setText("Refeições");
        Cat1.setToolTipText("Clique aqui para fazer um novo pedido!");
        Cat1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cat1.setMaximumSize(new java.awt.Dimension(2050, 4500));
        Cat1.setMinimumSize(new java.awt.Dimension(250, 100));
        Cat1.setPreferredSize(new java.awt.Dimension(250, 100));
        Cat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cat1ActionPerformed(evt);
            }
        });

        Cat3.setBackground(new java.awt.Color(0, 0, 76));
        Cat3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        Cat3.setForeground(new java.awt.Color(244, 244, 255));
        Cat3.setText("Sobremesas");
        Cat3.setToolTipText("Clique aqui para fazer um novo pedido!");
        Cat3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cat3.setMaximumSize(new java.awt.Dimension(2050, 4500));
        Cat3.setMinimumSize(new java.awt.Dimension(250, 100));
        Cat3.setPreferredSize(new java.awt.Dimension(250, 100));
        Cat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cat3ActionPerformed(evt);
            }
        });

        Cat4.setBackground(new java.awt.Color(0, 0, 76));
        Cat4.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        Cat4.setForeground(new java.awt.Color(244, 244, 255));
        Cat4.setText("Lanches");
        Cat4.setToolTipText("Clique aqui para fazer um novo pedido!");
        Cat4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cat4.setMaximumSize(new java.awt.Dimension(2050, 4500));
        Cat4.setMinimumSize(new java.awt.Dimension(250, 100));
        Cat4.setPreferredSize(new java.awt.Dimension(250, 100));
        Cat4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cat4ActionPerformed(evt);
            }
        });

        Cat2.setBackground(new java.awt.Color(0, 0, 76));
        Cat2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        Cat2.setForeground(new java.awt.Color(244, 244, 255));
        Cat2.setText("Bebidas");
        Cat2.setToolTipText("Clique aqui para fazer um novo pedido!");
        Cat2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cat2.setMaximumSize(new java.awt.Dimension(2050, 4500));
        Cat2.setMinimumSize(new java.awt.Dimension(250, 100));
        Cat2.setPreferredSize(new java.awt.Dimension(250, 100));
        Cat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cat2ActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(0, 0, 76));
        backButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backButton.setForeground(new java.awt.Color(244, 244, 255));
        backButton.setText("Voltar");
        backButton.setToolTipText("Clique aqui para fazer um novo pedido!");
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.setMaximumSize(new java.awt.Dimension(2050, 4500));
        backButton.setMinimumSize(new java.awt.Dimension(110, 35));
        backButton.setPreferredSize(new java.awt.Dimension(110, 35));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuCardapioLayout = new javax.swing.GroupLayout(menuCardapio);
        menuCardapio.setLayout(menuCardapioLayout);
        menuCardapioLayout.setHorizontalGroup(
            menuCardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(footerCategories, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerCategories, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuCardapioLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(menuCardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cat1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(Cat3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(menuCardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cat2, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(Cat4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(menuCardapioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuCardapioLayout.setVerticalGroup(
            menuCardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuCardapioLayout.createSequentialGroup()
                .addComponent(headerCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(menuCardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cat1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cat2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(menuCardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cat3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cat4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(footerCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        Categories.add(menuCardapio, "Categories.menuCardapio");

        cardapioBebidas.setBackground(new java.awt.Color(244, 244, 255));
        cardapioBebidas.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        cardapioBebidas.setInheritsPopupMenu(true);
        cardapioBebidas.setMinimumSize(new java.awt.Dimension(720, 480));

        headerBebidas.setBackground(new java.awt.Color(0, 0, 127));
        headerBebidas.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerBebidas.setForeground(new java.awt.Color(255, 255, 255));
        headerBebidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerBebidas.setText("Bebidas");
        headerBebidas.setToolTipText("");
        headerBebidas.setOpaque(true);

        footerBebidas.setBackground(new java.awt.Color(0, 0, 127));
        footerBebidas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        footerBebidas.setForeground(new java.awt.Color(255, 0, 0));
        footerBebidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        footerBebidas.setToolTipText("");
        footerBebidas.setOpaque(true);

        bt_voltar_bebidas.setBackground(new java.awt.Color(0, 0, 76));
        bt_voltar_bebidas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_voltar_bebidas.setForeground(new java.awt.Color(244, 244, 255));
        bt_voltar_bebidas.setText("Voltar");
        bt_voltar_bebidas.setToolTipText("Clique aqui para fazer um novo pedido!");
        bt_voltar_bebidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_voltar_bebidas.setMaximumSize(new java.awt.Dimension(2050, 4500));
        bt_voltar_bebidas.setMinimumSize(new java.awt.Dimension(110, 35));
        bt_voltar_bebidas.setPreferredSize(new java.awt.Dimension(110, 35));
        bt_voltar_bebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar_bebidasActionPerformed(evt);
            }
        });

        bt_confirmar_bebidas.setBackground(new java.awt.Color(0, 0, 76));
        bt_confirmar_bebidas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_confirmar_bebidas.setForeground(new java.awt.Color(244, 244, 255));
        bt_confirmar_bebidas.setText("Concluído");
        bt_confirmar_bebidas.setToolTipText("Clique aqui para fazer um novo pedido!");
        bt_confirmar_bebidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_confirmar_bebidas.setMaximumSize(new java.awt.Dimension(2050, 4500));
        bt_confirmar_bebidas.setMinimumSize(new java.awt.Dimension(110, 35));
        bt_confirmar_bebidas.setPreferredSize(new java.awt.Dimension(110, 35));
        bt_confirmar_bebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmar_bebidasActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel8.setText("Adicionar?");

        jLabel3.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel3.setText("Item");

        jLabel4.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel4.setText("Preço (un.)");

        jLabel5.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel5.setText("Quantidade");

        lista_itens.setBackground(new java.awt.Color(244, 244, 255));
        lista_itens.setBorder(null);
        lista_itens.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        lista_itens = bebidas.getPanel();

        javax.swing.GroupLayout cardapioBebidasLayout = new javax.swing.GroupLayout(cardapioBebidas);
        cardapioBebidas.setLayout(cardapioBebidasLayout);
        cardapioBebidasLayout.setHorizontalGroup(
            cardapioBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(footerBebidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerBebidas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(cardapioBebidasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(cardapioBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardapioBebidasLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 427, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel5)
                        .addGap(30, 30, 30))
                    .addGroup(cardapioBebidasLayout.createSequentialGroup()
                        .addComponent(bt_voltar_bebidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_confirmar_bebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addComponent(lista_itens)
        );
        cardapioBebidasLayout.setVerticalGroup(
            cardapioBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardapioBebidasLayout.createSequentialGroup()
                .addComponent(headerBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardapioBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lista_itens, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardapioBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_voltar_bebidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_confirmar_bebidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(footerBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        Categories.add(cardapioBebidas, "cardapioBebidas");

        cardapioRefeicoes.setBackground(new java.awt.Color(244, 244, 255));
        cardapioRefeicoes.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        cardapioRefeicoes.setInheritsPopupMenu(true);
        cardapioRefeicoes.setMinimumSize(new java.awt.Dimension(720, 480));

        headerRefeicoes.setBackground(new java.awt.Color(0, 0, 127));
        headerRefeicoes.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerRefeicoes.setForeground(new java.awt.Color(255, 255, 255));
        headerRefeicoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerRefeicoes.setText("Refeições");
        headerRefeicoes.setToolTipText("");
        headerRefeicoes.setOpaque(true);

        footerRefeicoes.setBackground(new java.awt.Color(0, 0, 127));
        footerRefeicoes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        footerRefeicoes.setForeground(new java.awt.Color(255, 0, 0));
        footerRefeicoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        footerRefeicoes.setToolTipText("");
        footerRefeicoes.setOpaque(true);

        bt_voltar_refeicoes.setBackground(new java.awt.Color(0, 0, 76));
        bt_voltar_refeicoes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_voltar_refeicoes.setForeground(new java.awt.Color(244, 244, 255));
        bt_voltar_refeicoes.setText("Voltar");
        bt_voltar_refeicoes.setToolTipText("Clique aqui para fazer um novo pedido!");
        bt_voltar_refeicoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_voltar_refeicoes.setMaximumSize(new java.awt.Dimension(2050, 4500));
        bt_voltar_refeicoes.setMinimumSize(new java.awt.Dimension(110, 35));
        bt_voltar_refeicoes.setPreferredSize(new java.awt.Dimension(110, 35));
        bt_voltar_refeicoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar_refeicoesActionPerformed(evt);
            }
        });

        bt_confirmar_refeicoes.setBackground(new java.awt.Color(0, 0, 76));
        bt_confirmar_refeicoes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_confirmar_refeicoes.setForeground(new java.awt.Color(244, 244, 255));
        bt_confirmar_refeicoes.setText("Concluído");
        bt_confirmar_refeicoes.setToolTipText("Clique aqui para fazer um novo pedido!");
        bt_confirmar_refeicoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_confirmar_refeicoes.setMaximumSize(new java.awt.Dimension(2050, 4500));
        bt_confirmar_refeicoes.setMinimumSize(new java.awt.Dimension(110, 35));
        bt_confirmar_refeicoes.setPreferredSize(new java.awt.Dimension(110, 35));
        bt_confirmar_refeicoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmar_refeicoesActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel10.setText("Adicionar?");

        jLabel11.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel11.setText("Item");

        jLabel12.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel12.setText("Preço (un.)");

        jLabel13.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel13.setText("Quantidade");

        lista_itens1.setBackground(new java.awt.Color(244, 244, 255));
        lista_itens1.setBorder(null);
        lista_itens1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        lista_itens1 = refeicoes.getPanel();

        javax.swing.GroupLayout cardapioRefeicoesLayout = new javax.swing.GroupLayout(cardapioRefeicoes);
        cardapioRefeicoes.setLayout(cardapioRefeicoesLayout);
        cardapioRefeicoesLayout.setHorizontalGroup(
            cardapioRefeicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(footerRefeicoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerRefeicoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(cardapioRefeicoesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(cardapioRefeicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardapioRefeicoesLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel13)
                        .addGap(30, 30, 30))
                    .addGroup(cardapioRefeicoesLayout.createSequentialGroup()
                        .addComponent(bt_voltar_refeicoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_confirmar_refeicoes, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addComponent(lista_itens1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        cardapioRefeicoesLayout.setVerticalGroup(
            cardapioRefeicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardapioRefeicoesLayout.createSequentialGroup()
                .addComponent(headerRefeicoes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardapioRefeicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lista_itens1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardapioRefeicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_voltar_refeicoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_confirmar_refeicoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(footerRefeicoes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        Categories.add(cardapioRefeicoes, "cardapioRefeicoes");

        cardapioSobremesas.setBackground(new java.awt.Color(244, 244, 255));
        cardapioSobremesas.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        cardapioSobremesas.setInheritsPopupMenu(true);
        cardapioSobremesas.setMinimumSize(new java.awt.Dimension(720, 480));

        headerSobremesas.setBackground(new java.awt.Color(0, 0, 127));
        headerSobremesas.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerSobremesas.setForeground(new java.awt.Color(255, 255, 255));
        headerSobremesas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerSobremesas.setText("Sobremesas");
        headerSobremesas.setToolTipText("");
        headerSobremesas.setOpaque(true);

        footerSobremesas.setBackground(new java.awt.Color(0, 0, 127));
        footerSobremesas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        footerSobremesas.setForeground(new java.awt.Color(255, 0, 0));
        footerSobremesas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        footerSobremesas.setToolTipText("");
        footerSobremesas.setOpaque(true);

        bt_voltar_sobremesas.setBackground(new java.awt.Color(0, 0, 76));
        bt_voltar_sobremesas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_voltar_sobremesas.setForeground(new java.awt.Color(244, 244, 255));
        bt_voltar_sobremesas.setText("Voltar");
        bt_voltar_sobremesas.setToolTipText("Clique aqui para fazer um novo pedido!");
        bt_voltar_sobremesas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_voltar_sobremesas.setMaximumSize(new java.awt.Dimension(2050, 4500));
        bt_voltar_sobremesas.setMinimumSize(new java.awt.Dimension(110, 35));
        bt_voltar_sobremesas.setPreferredSize(new java.awt.Dimension(110, 35));
        bt_voltar_sobremesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar_sobremesasActionPerformed(evt);
            }
        });

        bt_confirmar_sobremesas.setBackground(new java.awt.Color(0, 0, 76));
        bt_confirmar_sobremesas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_confirmar_sobremesas.setForeground(new java.awt.Color(244, 244, 255));
        bt_confirmar_sobremesas.setText("Concluído");
        bt_confirmar_sobremesas.setToolTipText("Clique aqui para fazer um novo pedido!");
        bt_confirmar_sobremesas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_confirmar_sobremesas.setMaximumSize(new java.awt.Dimension(2050, 4500));
        bt_confirmar_sobremesas.setMinimumSize(new java.awt.Dimension(110, 35));
        bt_confirmar_sobremesas.setPreferredSize(new java.awt.Dimension(110, 35));
        bt_confirmar_sobremesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmar_sobremesasActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel14.setText("Adicionar?");

        jLabel15.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel15.setText("Item");

        jLabel16.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel16.setText("Preço (un.)");

        jLabel17.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel17.setText("Quantidade");

        lista_itens2.setBackground(new java.awt.Color(244, 244, 255));
        lista_itens2.setBorder(null);
        lista_itens2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        lista_itens2 = sobremesas.getPanel();

        javax.swing.GroupLayout cardapioSobremesasLayout = new javax.swing.GroupLayout(cardapioSobremesas);
        cardapioSobremesas.setLayout(cardapioSobremesasLayout);
        cardapioSobremesasLayout.setHorizontalGroup(
            cardapioSobremesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(footerSobremesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerSobremesas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(cardapioSobremesasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(cardapioSobremesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardapioSobremesasLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 427, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel17)
                        .addGap(30, 30, 30))
                    .addGroup(cardapioSobremesasLayout.createSequentialGroup()
                        .addComponent(bt_voltar_sobremesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_confirmar_sobremesas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addComponent(lista_itens2)
        );
        cardapioSobremesasLayout.setVerticalGroup(
            cardapioSobremesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardapioSobremesasLayout.createSequentialGroup()
                .addComponent(headerSobremesas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardapioSobremesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lista_itens2, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardapioSobremesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_voltar_sobremesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_confirmar_sobremesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(footerSobremesas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        Categories.add(cardapioSobremesas, "cardapioSobremesas");

        cardapioLanches.setBackground(new java.awt.Color(244, 244, 255));
        cardapioLanches.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        cardapioLanches.setInheritsPopupMenu(true);
        cardapioLanches.setMinimumSize(new java.awt.Dimension(720, 480));

        headerLanches.setBackground(new java.awt.Color(0, 0, 127));
        headerLanches.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerLanches.setForeground(new java.awt.Color(255, 255, 255));
        headerLanches.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLanches.setText("Lanches");
        headerLanches.setToolTipText("");
        headerLanches.setOpaque(true);

        footerLanches.setBackground(new java.awt.Color(0, 0, 127));
        footerLanches.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        footerLanches.setForeground(new java.awt.Color(255, 0, 0));
        footerLanches.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        footerLanches.setToolTipText("");
        footerLanches.setOpaque(true);

        bt_voltar_lanches.setBackground(new java.awt.Color(0, 0, 76));
        bt_voltar_lanches.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_voltar_lanches.setForeground(new java.awt.Color(244, 244, 255));
        bt_voltar_lanches.setText("Voltar");
        bt_voltar_lanches.setToolTipText("Clique aqui para fazer um novo pedido!");
        bt_voltar_lanches.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_voltar_lanches.setMaximumSize(new java.awt.Dimension(2050, 4500));
        bt_voltar_lanches.setMinimumSize(new java.awt.Dimension(110, 35));
        bt_voltar_lanches.setPreferredSize(new java.awt.Dimension(110, 35));
        bt_voltar_lanches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar_lanchesActionPerformed(evt);
            }
        });

        bt_confirmar_lanches.setBackground(new java.awt.Color(0, 0, 76));
        bt_confirmar_lanches.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_confirmar_lanches.setForeground(new java.awt.Color(244, 244, 255));
        bt_confirmar_lanches.setText("Concluído");
        bt_confirmar_lanches.setToolTipText("Clique aqui para fazer um novo pedido!");
        bt_confirmar_lanches.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_confirmar_lanches.setMaximumSize(new java.awt.Dimension(2050, 4500));
        bt_confirmar_lanches.setMinimumSize(new java.awt.Dimension(110, 35));
        bt_confirmar_lanches.setPreferredSize(new java.awt.Dimension(110, 35));
        bt_confirmar_lanches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmar_lanchesActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel18.setText("Adicionar?");

        jLabel19.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel19.setText("Item");

        jLabel20.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel20.setText("Preço (un.)");

        jLabel21.setFont(new java.awt.Font("Caladea", 2, 12)); // NOI18N
        jLabel21.setText("Quantidade");

        lista_itens3.setBackground(new java.awt.Color(244, 244, 255));
        lista_itens3.setBorder(null);
        lista_itens3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        lista_itens3 = lanches.getPanel();

        javax.swing.GroupLayout cardapioLanchesLayout = new javax.swing.GroupLayout(cardapioLanches);
        cardapioLanches.setLayout(cardapioLanchesLayout);
        cardapioLanchesLayout.setHorizontalGroup(
            cardapioLanchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(footerLanches, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerLanches, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(cardapioLanchesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(cardapioLanchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardapioLanchesLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 427, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel21)
                        .addGap(30, 30, 30))
                    .addGroup(cardapioLanchesLayout.createSequentialGroup()
                        .addComponent(bt_voltar_lanches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_confirmar_lanches, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addComponent(lista_itens3)
        );
        cardapioLanchesLayout.setVerticalGroup(
            cardapioLanchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardapioLanchesLayout.createSequentialGroup()
                .addComponent(headerLanches, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardapioLanchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lista_itens3, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardapioLanchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_voltar_lanches, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_confirmar_lanches, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(footerLanches, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        Categories.add(cardapioLanches, "cardapioLanches");

        confirmacaoPedido.setBackground(new java.awt.Color(244, 244, 255));
        confirmacaoPedido.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        confirmacaoPedido.setInheritsPopupMenu(true);
        confirmacaoPedido.setMinimumSize(new java.awt.Dimension(720, 480));

        headerConfirmacao.setBackground(new java.awt.Color(0, 0, 127));
        headerConfirmacao.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerConfirmacao.setForeground(new java.awt.Color(255, 255, 255));
        headerConfirmacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerConfirmacao.setText("Confira mais uma vez o seu pedido...");
        headerConfirmacao.setToolTipText("");
        headerConfirmacao.setOpaque(true);

        footerConfirmacao.setBackground(new java.awt.Color(0, 0, 127));
        footerConfirmacao.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        footerConfirmacao.setForeground(new java.awt.Color(255, 255, 255));
        footerConfirmacao.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        footerConfirmacao.setText(" ");
        footerConfirmacao.setToolTipText("");
        footerConfirmacao.setOpaque(true);

        backButton1.setBackground(new java.awt.Color(0, 0, 76));
        backButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backButton1.setForeground(new java.awt.Color(244, 244, 255));
        backButton1.setText("Voltar");
        backButton1.setToolTipText("Clique aqui para fazer um novo pedido!");
        backButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton1.setMaximumSize(new java.awt.Dimension(2050, 4500));
        backButton1.setMinimumSize(new java.awt.Dimension(110, 35));
        backButton1.setPreferredSize(new java.awt.Dimension(110, 35));
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });

        bt_confirmar4.setBackground(new java.awt.Color(0, 102, 51));
        bt_confirmar4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_confirmar4.setForeground(new java.awt.Color(244, 244, 255));
        bt_confirmar4.setText("Realizar pedido!");
        bt_confirmar4.setToolTipText("Clique aqui para fazer um novo pedido!");
        bt_confirmar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_confirmar4.setMaximumSize(new java.awt.Dimension(2050, 4500));
        bt_confirmar4.setMinimumSize(new java.awt.Dimension(110, 35));
        bt_confirmar4.setPreferredSize(new java.awt.Dimension(110, 35));
        bt_confirmar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmar4ActionPerformed(evt);
            }
        });

        pane_tabela_itens.setBackground(new java.awt.Color(244, 244, 255));
        pane_tabela_itens.setBorder(null);

        tabela_itens.getTableHeader().setBackground(new java.awt.Color(244, 244, 255));
        tabela_itens.setBackground(new java.awt.Color(244, 244, 255));
        tabela_itens.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tabela_itens.setModel(new javax.swing.table.DefaultTableModel(retornarSelecionados(),
            new String [] {
                "Tipo", "Produto", "Valor Unitário", "Quantidade", "Valor Total"
            }));
            tabela_itens.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            tabela_itens.setRowHeight(32);
            tabela_itens.setRowSelectionAllowed(false);
            tabela_itens.getTableHeader().setResizingAllowed(false);
            tabela_itens.getTableHeader().setReorderingAllowed(false);
            tabela_itens.getColumnModel().getColumn(0).setPreferredWidth(125);
            tabela_itens.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabela_itens.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabela_itens.getColumnModel().getColumn(3).setPreferredWidth(83);
            tabela_itens.getColumnModel().getColumn(4).setPreferredWidth(100);
            pane_tabela_itens.setViewportView(tabela_itens);

            jLabel1.setFont(new java.awt.Font("Caladea", 3, 24)); // NOI18N
            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText("Total deste pedido: R$" + valorPedido);

            javax.swing.GroupLayout confirmacaoPedidoLayout = new javax.swing.GroupLayout(confirmacaoPedido);
            confirmacaoPedido.setLayout(confirmacaoPedidoLayout);
            confirmacaoPedidoLayout.setHorizontalGroup(
                confirmacaoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(footerConfirmacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerConfirmacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                .addGroup(confirmacaoPedidoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pane_tabela_itens)
                    .addContainerGap())
                .addGroup(confirmacaoPedidoLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(backButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_confirmar4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15))
                .addGroup(confirmacaoPedidoLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            confirmacaoPedidoLayout.setVerticalGroup(
                confirmacaoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(confirmacaoPedidoLayout.createSequentialGroup()
                    .addComponent(headerConfirmacao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(pane_tabela_itens, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                    .addGroup(confirmacaoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_confirmar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(11, 11, 11)
                    .addComponent(footerConfirmacao, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0))
            );

            Categories.add(confirmacaoPedido, "Categories.confirmacaoPedido");

            panelPrincipal.add(Categories, "Categories");

            Aviso_aguardandoPedido.setBackground(new java.awt.Color(244, 244, 255));
            Aviso_aguardandoPedido.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
            Aviso_aguardandoPedido.setInheritsPopupMenu(true);
            Aviso_aguardandoPedido.setMinimumSize(new java.awt.Dimension(720, 480));

            headerFinalMessage1.setBackground(new java.awt.Color(0, 0, 127));
            headerFinalMessage1.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
            headerFinalMessage1.setForeground(new java.awt.Color(255, 255, 255));
            headerFinalMessage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            headerFinalMessage1.setText("Operação não permitida");
            headerFinalMessage1.setToolTipText("");
            headerFinalMessage1.setOpaque(true);

            footerFinalMessage1.setBackground(new java.awt.Color(0, 0, 127));
            footerFinalMessage1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
            footerFinalMessage1.setForeground(new java.awt.Color(255, 255, 255));
            footerFinalMessage1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
            footerFinalMessage1.setText(" ");
            footerFinalMessage1.setToolTipText("");
            footerFinalMessage1.setOpaque(true);

            jLabel22.setFont(new java.awt.Font("Caladea", 3, 24)); // NOI18N
            jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel22.setText("Não é possível fechar a conta enquanto");

            jLabel23.setFont(new java.awt.Font("Caladea", 3, 24)); // NOI18N
            jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel23.setText("Tente novamente após receber seu(s) pedido(s).");

            jLabel24.setFont(new java.awt.Font("Caladea", 3, 24)); // NOI18N
            jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel24.setText("Desculpe...");

            bt_voltar.setBackground(new java.awt.Color(0, 0, 76));
            bt_voltar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            bt_voltar.setForeground(new java.awt.Color(244, 244, 255));
            bt_voltar.setText("Voltar");
            bt_voltar.setToolTipText("");
            bt_voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            bt_voltar.setMaximumSize(new java.awt.Dimension(2050, 4500));
            bt_voltar.setMinimumSize(new java.awt.Dimension(110, 35));
            bt_voltar.setPreferredSize(new java.awt.Dimension(110, 35));
            bt_voltar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bt_voltarActionPerformed(evt);
                }
            });

            jLabel25.setFont(new java.awt.Font("Caladea", 3, 24)); // NOI18N
            jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel25.setText("aguarda a entrega dos pedidos.");

            javax.swing.GroupLayout Aviso_aguardandoPedidoLayout = new javax.swing.GroupLayout(Aviso_aguardandoPedido);
            Aviso_aguardandoPedido.setLayout(Aviso_aguardandoPedidoLayout);
            Aviso_aguardandoPedidoLayout.setHorizontalGroup(
                Aviso_aguardandoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(footerFinalMessage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerFinalMessage1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                .addGroup(Aviso_aguardandoPedidoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(Aviso_aguardandoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Aviso_aguardandoPedidoLayout.createSequentialGroup()
                            .addGap(266, 266, 266)
                            .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
            );
            Aviso_aguardandoPedidoLayout.setVerticalGroup(
                Aviso_aguardandoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Aviso_aguardandoPedidoLayout.createSequentialGroup()
                    .addComponent(headerFinalMessage1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(59, 59, 59)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel25)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(75, 75, 75)
                    .addComponent(bt_voltar, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(footerFinalMessage1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
            );

            panelPrincipal.add(Aviso_aguardandoPedido, "Aviso_aguardando");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents
    
    //Função para troca de cards (name = nome do card)
    private void showCard(String name){
        CardLayout card = (CardLayout)panelPrincipal.getLayout();
        card.show(panelPrincipal, name);
    }
    
    private void showCardapio(java.awt.event.ActionEvent evt){
        CardLayout card = (CardLayout)Categories.getLayout();
        JButton dummy = (JButton) evt.getSource();
        headerBebidas.setText(dummy.getText());
        card.show(Categories, "Categories.listaCardapio");
    }
    
    private void novoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoPedidoActionPerformed
        showCard("Categories");
        CardLayout card = (CardLayout)Categories.getLayout();
        card.show(Categories, "Categories.menuCardapio");
    }//GEN-LAST:event_novoPedidoActionPerformed

    //Método que age como ActionListener de TODOS os botões do teclado do CPF
    //CUIDADO PARA NÃO CRIAR ACTION LISTENERS SEPARADOS!
    private void tecladoCPF(java.awt.event.ActionEvent evt) {                                         
        if(evt.getSource() == cpf0){    cpf = showCPF.getText()+"0";    }
        if(evt.getSource() == cpf1){    cpf = showCPF.getText()+"1";    }
        if(evt.getSource() == cpf2){    cpf = showCPF.getText()+"2";    }
        if(evt.getSource() == cpf3){    cpf = showCPF.getText()+"3";    }
        if(evt.getSource() == cpf4){    cpf = showCPF.getText()+"4";    }
        if(evt.getSource() == cpf5){    cpf = showCPF.getText()+"5";    }
        if(evt.getSource() == cpf6){    cpf = showCPF.getText()+"6";    }
        if(evt.getSource() == cpf7){    cpf = showCPF.getText()+"7";    }
        if(evt.getSource() == cpf8){    cpf = showCPF.getText()+"8";    }
        if(evt.getSource() == cpf9){    cpf = showCPF.getText()+"9";    }
        showCPF.setText(cpf);
    }   
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        
        showCard("Home");
    }//GEN-LAST:event_backButtonActionPerformed

    private void cancelCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelCloseActionPerformed

        showCard("Home");
    }//GEN-LAST:event_cancelCloseActionPerformed

    private void confirmCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmCloseActionPerformed
        showCard("CPF");
    }//GEN-LAST:event_confirmCloseActionPerformed

    private void yesCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesCPFActionPerformed
        CardLayout card = (CardLayout)CPF.getLayout();
        card.show(CPF, "getCPF");
    }//GEN-LAST:event_yesCPFActionPerformed

    private void noCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noCPFActionPerformed
        finalizarConta();
    }//GEN-LAST:event_noCPFActionPerformed

    private void cpfTryAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfTryAgainActionPerformed
        showCPF.setText("");
        CardLayout card = (CardLayout)CPF.getLayout();
        card.show(CPF, "getCPF");
    }//GEN-LAST:event_cpfTryAgainActionPerformed

    private void selectMesaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectMesaButtonActionPerformed
        //Recebe o número selecionado na comboBox
        numMesa = Integer.parseInt(comboBoxSelectMesa.getSelectedItem().toString());
        headerTelaInicial.setText("Mesa "+ numMesa);
        showCard("TelaInicial");
        
    }//GEN-LAST:event_selectMesaButtonActionPerformed

    private void comboBoxSelectMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSelectMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSelectMesaActionPerformed

    private void Cat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cat2ActionPerformed
        CardLayout card = (CardLayout)Categories.getLayout();
        card.show(Categories, "cardapioBebidas");

    }//GEN-LAST:event_Cat2ActionPerformed

    private void bt_voltar_bebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar_bebidasActionPerformed
        limparFooters();
        CardLayout card = (CardLayout)Categories.getLayout();
        card.show(Categories, "Categories.menuCardapio");
    }//GEN-LAST:event_bt_voltar_bebidasActionPerformed

    private void bt_confirmar_bebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmar_bebidasActionPerformed
        if(qtdSelecionados() > 0){
            reconstruirTabela();

            telaAnterior = "cardapioBebidas";
            CardLayout card = (CardLayout)Categories.getLayout();
            card.show(Categories, "Categories.confirmacaoPedido");
            limparFooters();
        }
        else{
            footerBebidas.setText("Por favor selecione pelo menos 1 produto!");
        }
        
        
    }//GEN-LAST:event_bt_confirmar_bebidasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        liberarMesa();
        finalizarConta();
        Login login = new Login();
        login.setVisible(true);
        try {
            conn.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void Cat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cat1ActionPerformed
        CardLayout card = (CardLayout)Categories.getLayout();
        card.show(Categories, "cardapioRefeicoes");
    }//GEN-LAST:event_Cat1ActionPerformed

    private void Cat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cat3ActionPerformed
        CardLayout card = (CardLayout)Categories.getLayout();
        card.show(Categories, "cardapioSobremesas");
    }//GEN-LAST:event_Cat3ActionPerformed

    private void Cat4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cat4ActionPerformed
        CardLayout card = (CardLayout)Categories.getLayout();
        card.show(Categories, "cardapioLanches");
    }//GEN-LAST:event_Cat4ActionPerformed

    private void bt_voltar_refeicoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar_refeicoesActionPerformed
        limparFooters();
        CardLayout card = (CardLayout)Categories.getLayout();
        card.show(Categories, "Categories.menuCardapio");
    }//GEN-LAST:event_bt_voltar_refeicoesActionPerformed

    private void bt_confirmar_refeicoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmar_refeicoesActionPerformed
        if(qtdSelecionados() > 0){
            telaAnterior = "cardapioRefeicoes";
            reconstruirTabela();

            CardLayout card = (CardLayout)Categories.getLayout();
            card.show(Categories, "Categories.confirmacaoPedido");
            limparFooters();
        }
        else{
            footerRefeicoes.setText("Por favor selecione pelo menos 1 produto!");
        }
    }//GEN-LAST:event_bt_confirmar_refeicoesActionPerformed

    private void bt_voltar_sobremesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar_sobremesasActionPerformed
        limparFooters();
        CardLayout card = (CardLayout)Categories.getLayout();
        card.show(Categories, "Categories.menuCardapio");
    }//GEN-LAST:event_bt_voltar_sobremesasActionPerformed

    private void bt_confirmar_sobremesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmar_sobremesasActionPerformed
        if(qtdSelecionados() > 0){
            telaAnterior = "cardapioSobremesas";
            reconstruirTabela();

            CardLayout card = (CardLayout)Categories.getLayout();
            card.show(Categories, "Categories.confirmacaoPedido");
            limparFooters();
        }
        else{
            footerSobremesas.setText("Por favor selecione pelo menos 1 produto!");
        }
    }//GEN-LAST:event_bt_confirmar_sobremesasActionPerformed

    private void bt_voltar_lanchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar_lanchesActionPerformed
        limparFooters();
        CardLayout card = (CardLayout)Categories.getLayout();
        card.show(Categories, "Categories.menuCardapio");
    }//GEN-LAST:event_bt_voltar_lanchesActionPerformed

    private void bt_confirmar_lanchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmar_lanchesActionPerformed
        if(qtdSelecionados() > 0){
            telaAnterior = "cardapioLanches";
            reconstruirTabela();

            CardLayout card = (CardLayout)Categories.getLayout();
            card.show(Categories, "Categories.confirmacaoPedido");
            limparFooters();
        }
        else{
            footerLanches.setText("Por favor selecione pelo menos 1 produto!");
        }
    }//GEN-LAST:event_bt_confirmar_lanchesActionPerformed

    private void cpfEraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfEraseActionPerformed
        cpf = null;
        showCPF.setText(cpf);
    }//GEN-LAST:event_cpfEraseActionPerformed

    private void cpfFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfFinishActionPerformed
        if(cpf == null || cpf.length()>11 || cpf.length()<11){
            CardLayout card = (CardLayout)CPF.getLayout();
            card.show(CPF, "invalidCPF");
        }else{
            conn.comando_sql("UPDATE t_contas SET conta_cpf="+cpf+" WHERE conta_codigo="+codConta+";");
            finalizarConta();
        }
    }//GEN-LAST:event_cpfFinishActionPerformed

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        CardLayout card = (CardLayout)Categories.getLayout();
        card.show(Categories, telaAnterior);
    }//GEN-LAST:event_backButton1ActionPerformed

    public String getData(){
        Date d = Calendar.getInstance().getTime();
        SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
        return sdfD.format(d); //data formatada em string
    }
    
    public String getHora(){
        Date d = Calendar.getInstance().getTime();
        SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm:ss");
        return sdfH.format(d); //hora formatada em string
    }
    
    private void bt_confirmar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmar4ActionPerformed
        conn.comando_sql("INSERT INTO t_pedidos (`ped_valor`, `ped_mesa`, `ped_data`, `ped_hora`) VALUES ('"
                + valorPedido +"', '"
                + numMesa +"', '"
                + getData() + "', '"
                + getHora() + "');");
        
        int codPedido = 0;
        
        try {
            codPedido = Integer.parseInt(conn.retornar_ultima_celula("t_pedidos", "ped_codigo"));
        } catch (SQLException ex) {
            Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        //valorConta+=valorPedido;
        BigDecimal soma = valorConta.add(valorPedido).setScale(2, RoundingMode.HALF_EVEN);
        valorConta = soma;
        
        for(int i = 0; i<bebidas.getSelecionados().size();i++){
            conn.comando_sql("INSERT INTO t_pedido_itens (`itm_codigo`, `ped_codigo`, `itm_qtde`, `ped_status`, `ped_data`, `ped_hora`) VALUES ('" 
                + bebidas.getSelecionados().get(i).get(0) + "', '"
                + codPedido +"', '"
                + bebidas.getSelecionados().get(i).get(1) + "', '"
                + "ABERTO" + "', '"
                + getData() + "', '"
                + getHora() + "');");
        }
        bebidas.resetSelecionados();
        for(int i = 0; i<lanches.getSelecionados().size();i++){
            conn.comando_sql("INSERT INTO t_pedido_itens (`itm_codigo`, `ped_codigo`, `itm_qtde`, `ped_status`, `ped_data`, `ped_hora`) VALUES ('" 
                + lanches.getSelecionados().get(i).get(0) + "', '"
                + codPedido +"', '"
                + lanches.getSelecionados().get(i).get(1) + "', '"
                + "ABERTO" + "', '"
                + getData() + "', '"
                + getHora() + "');");
        }
        lanches.resetSelecionados();
        for(int i = 0; i<sobremesas.getSelecionados().size();i++){
            conn.comando_sql("INSERT INTO t_pedido_itens (`itm_codigo`, `ped_codigo`, `itm_qtde`, `ped_status`, `ped_data`, `ped_hora`) VALUES ('" 
                + sobremesas.getSelecionados().get(i).get(0) + "', '"
                + codPedido +"', '"
                + sobremesas.getSelecionados().get(i).get(1) + "', '"
                + "ABERTO" + "', '"
                + getData() + "', '"
                + getHora() + "');");
        }
        sobremesas.resetSelecionados();
        for(int i = 0; i<refeicoes.getSelecionados().size();i++){
            conn.comando_sql("INSERT INTO t_pedido_itens (`itm_codigo`, `ped_codigo`, `itm_qtde`, `ped_status`, `ped_data`, `ped_hora`) VALUES ('" 
                + refeicoes.getSelecionados().get(i).get(0) + "', '"
                + codPedido +"', '"
                + refeicoes.getSelecionados().get(i).get(1) + "', '"
                + "ABERTO" + "', '"
                + getData() + "', '"
                + getHora() + "');");
        }
        refeicoes.resetSelecionados();
        
        conn.comando_sql("INSERT INTO t_pedidos_contas (`ped_codigo`, `conta_codigo`) VALUES ('"
                + codPedido + "', '"
                + codConta + "');");
        
        conn.comando_sql("UPDATE t_contas SET conta_valor="+valorConta+" WHERE `conta_codigo`='"+codConta+"';");
        fecharConta.setEnabled(true);
        atualizarResumo();
        
        showCard("Home");
        
        
    }//GEN-LAST:event_bt_confirmar4ActionPerformed

    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarActionPerformed
        //Faz o update do status da mesa no banco
        conn.comando_sql("UPDATE t_mesas SET mesa_status = 1 WHERE mesa_codigo = "+numMesa+";");
        
        createConta();
        
        //Altera o header da tela Home adicionando o número da mesa
        headerHome.setText("Mesa "+numMesa);
        atualizarResumo();
        showCard("Home");
    }//GEN-LAST:event_IniciarActionPerformed

    private void fecharContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharContaActionPerformed
        ArrayList<ArrayList<String>> conta = conn.retornar_query(
                "SELECT t_pedido_itens.itm_codigo,t_pedido_itens.itm_qtde,t_pedidos.ped_codigo, t_pedidos_contas.conta_codigo, ped_status FROM t_pedido_itens " +
                "INNER JOIN t_pedidos ON t_pedido_itens.ped_codigo=t_pedidos.ped_codigo " +
                "INNER JOIN t_pedidos_contas ON t_pedidos.ped_codigo = t_pedidos_contas.ped_codigo " +
                "WHERE conta_codigo = "+codConta+" AND ped_status ='ABERTO';"
        );
        if(!conta.isEmpty()){
            showCard("Aviso_aguardando");
        }
        else{
            showCard("Close");
        }
        
    }//GEN-LAST:event_fecharContaActionPerformed

    private void bt_concluidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_concluidoActionPerformed
        showCard("TelaInicial");
    }//GEN-LAST:event_bt_concluidoActionPerformed

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltarActionPerformed
        showCard("Home");
    }//GEN-LAST:event_bt_voltarActionPerformed
    
    
    //-------------BEGIN SQL--------------//
    
        //Adiciona uma nova conta ao banco de dados.
    private void createConta(){ 	
        //Cria uma nova conta na tabela t_contas
        conn.comando_sql("INSERT INTO t_contas(conta_valor, conta_mesa, conta_status, conta_data, conta_hora)" 
                       + "VALUES ("+valorConta+","+numMesa+",'ABERTO','"+getData()+"','"+getHora()+"');");
        /*
        //Pega o código gerado pelo banco para esta conta
        ArrayList<ArrayList<String>> codigo = conn.retornar_query("SELECT conta_codigo FROM t_contas "
                          + "WHERE conta_mesa LIKE "+numMesa+" AND conta_status LIKE 'ABERTO';");
        codConta = Integer.parseInt(codigo.get(0).get(0));*/
        
        try {
            codConta = Integer.parseInt(conn.retornar_ultima_celula("t_contas", "conta_codigo"));
        } catch (SQLException ex) {
            Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
        
        dataHoraAbertura = conn.retornar_valor(codConta, 
                "DATE_FORMAT( `conta_abertura` , '%d/%c/%Y %H:%i:%s' )",
                "conta_codigo",
                "t_contas");
    }
    
    //Função que preenche a comboBox do SelectMesa
    private void fillComboSelectMesa(){
        ArrayList<ArrayList<String>> numList;
        numList = conn.retornar_query("SELECT mesa_codigo FROM t_mesas WHERE mesa_status = 0");
        ArrayList<String> aux = new ArrayList();
        for(ArrayList<String> s: numList){
            aux.add(s.get(0));
        }
        
        defaultComboBox = new DefaultComboBoxModel(aux.toArray());
        comboBoxSelectMesa.setModel(defaultComboBox);
    }
    
    //-------------END SQL--------------//
    
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
            java.util.logging.Logger.getLogger(Mesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
  /*      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mesa().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Aviso_aguardandoPedido;
    private javax.swing.JPanel CPF;
    private javax.swing.JButton Cat1;
    private javax.swing.JButton Cat2;
    private javax.swing.JButton Cat3;
    private javax.swing.JButton Cat4;
    private javax.swing.JPanel Categories;
    private javax.swing.JPanel Close;
    private javax.swing.JPanel FinalMessage;
    private javax.swing.JPanel Home;
    private javax.swing.JButton Iniciar;
    private javax.swing.JPanel SelectMesaProvavel;
    private javax.swing.JPanel TelaInicial;
    private javax.swing.JButton backButton;
    private javax.swing.JButton backButton1;
    private javax.swing.JButton bt_concluido;
    private javax.swing.JButton bt_confirmar4;
    private javax.swing.JButton bt_confirmar_bebidas;
    private javax.swing.JButton bt_confirmar_lanches;
    private javax.swing.JButton bt_confirmar_refeicoes;
    private javax.swing.JButton bt_confirmar_sobremesas;
    private javax.swing.JButton bt_voltar;
    private javax.swing.JButton bt_voltar_bebidas;
    private javax.swing.JButton bt_voltar_lanches;
    private javax.swing.JButton bt_voltar_refeicoes;
    private javax.swing.JButton bt_voltar_sobremesas;
    private javax.swing.JButton cancelClose;
    private javax.swing.JPanel cardapioBebidas;
    private javax.swing.JPanel cardapioLanches;
    private javax.swing.JPanel cardapioRefeicoes;
    private javax.swing.JPanel cardapioSobremesas;
    private javax.swing.JComboBox<String> comboBoxSelectMesa;
    private javax.swing.JButton confirmClose;
    private javax.swing.JPanel confirmacaoPedido;
    private javax.swing.JButton cpf0;
    private javax.swing.JButton cpf1;
    private javax.swing.JButton cpf2;
    private javax.swing.JButton cpf3;
    private javax.swing.JButton cpf4;
    private javax.swing.JButton cpf5;
    private javax.swing.JButton cpf6;
    private javax.swing.JButton cpf7;
    private javax.swing.JButton cpf8;
    private javax.swing.JButton cpf9;
    private javax.swing.JButton cpfErase;
    private javax.swing.JButton cpfFinish;
    private javax.swing.JButton cpfTryAgain;
    private javax.swing.JButton fecharConta;
    private javax.swing.JLabel footerBebidas;
    private javax.swing.JLabel footerCPF;
    private javax.swing.JLabel footerCPF1;
    private javax.swing.JLabel footerCPF2;
    private javax.swing.JLabel footerCategories;
    private javax.swing.JLabel footerClose;
    private javax.swing.JLabel footerConfirmacao;
    private javax.swing.JLabel footerFinalMessage;
    private javax.swing.JLabel footerFinalMessage1;
    private javax.swing.JLabel footerHome;
    private javax.swing.JLabel footerLanches;
    private javax.swing.JLabel footerRefeicoes;
    private javax.swing.JLabel footerSelectMesa;
    private javax.swing.JLabel footerSobremesas;
    private javax.swing.JLabel footerTelaInicial;
    private javax.swing.JPanel getCPF;
    private javax.swing.JLabel getCPFText;
    private javax.swing.JLabel headerBebidas;
    private javax.swing.JLabel headerCPF;
    private javax.swing.JLabel headerCPF1;
    private javax.swing.JLabel headerCPF2;
    private javax.swing.JLabel headerCategories;
    private javax.swing.JLabel headerClose;
    private javax.swing.JLabel headerConfirmacao;
    private javax.swing.JLabel headerFinalMessage;
    private javax.swing.JLabel headerFinalMessage1;
    private javax.swing.JLabel headerHome;
    private javax.swing.JLabel headerLanches;
    private javax.swing.JLabel headerOptions;
    private javax.swing.JLabel headerRefeicoes;
    private javax.swing.JLabel headerResumo;
    private javax.swing.JLabel headerSelectMesa;
    private javax.swing.JLabel headerSobremesas;
    private javax.swing.JLabel headerTelaInicial;
    private javax.swing.JPanel invalidCPF;
    private javax.swing.JLabel invalidCPFText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane lista_itens;
    private javax.swing.JScrollPane lista_itens1;
    private javax.swing.JScrollPane lista_itens2;
    private javax.swing.JScrollPane lista_itens3;
    private javax.swing.JPanel menuCardapio;
    private javax.swing.JButton noCPF;
    private javax.swing.JButton novoPedido;
    private javax.swing.JScrollPane pane_tabela_itens;
    protected javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel questCPF;
    private javax.swing.JLabel questCPFText;
    private javax.swing.JButton selectMesaButton;
    private javax.swing.JTextField showCPF;
    private javax.swing.JTextArea showResumo;
    private javax.swing.JTable tabela_itens;
    private javax.swing.JPanel teclas;
    private javax.swing.JLabel textoConfirmaFecha;
    private javax.swing.JLabel textoSelectMesa;
    private javax.swing.JButton yesCPF;
    // End of variables declaration//GEN-END:variables

// </editor-fold> 
}
