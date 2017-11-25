package telas;

import codigo.Conexao;
import java.awt.CardLayout;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;



public class Mesa extends javax.swing.JFrame {
    
    public static String versao_supreme = "v0.3.0-alpha";
    
    // <editor-fold defaultstate="collapsed" desc="Classe MESA (principal)">                          
    private String cpf = "", dataHoraAbertura, resumo;
    public static int numMesa, codConta;
    private double valorConta = 0.0;
    private codigo.Conexao conn = new codigo.Conexao(); //conexao com o banco de dados
    private NumberFormat nf = NumberFormat.getCurrencyInstance(); //Formata valor na moeda do sistema
    private DefaultComboBoxModel defaultComboBox;
    Cardapio bebidas = null;
    Cardapio refeicoes = null;
    Cardapio lanches = null;
    Cardapio sobremesas = null;
    
    javax.swing.JScrollPane cardapioAtual = new javax.swing.JScrollPane();
    
    public Mesa(Conexao conex) {
        this.conn = conex;
        bebidas = new Cardapio(conn,"BEBIDAS");
        refeicoes = new Cardapio(conn,"REFEIÇÕES");
        lanches = new Cardapio(conn,"LANCHES");
        sobremesas = new Cardapio(conn,"SOBREMESAS");
        initComponents();
    }
    
    public void initConexao(){
        System.out.println("***/: "+conn.getStatus());
        fillComboSelectMesa();
        createConta();
        dataHoraAbertura = getData()+" "+getHora();
        getContaInfo();
        fillComboSelectMesa();
    }
    
    // Irá liberar a mesa no banco de dados
    public void liberarMesa(){
        conn.comando_sql("UPDATE t_mesas SET mesa_status = 0 WHERE mesa_codigo = "+numMesa+";");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        SelectMesaProvavel = new javax.swing.JPanel();
        headerHome2 = new javax.swing.JLabel();
        footerHome2 = new javax.swing.JLabel();
        comboBoxSelectMesa = new javax.swing.JComboBox<>();
        textoSelectMesa = new javax.swing.JLabel();
        selectMesaButton = new javax.swing.JButton();
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
        SelectMesa = new javax.swing.JPanel();
        headerHome1 = new javax.swing.JLabel();
        footerHome1 = new javax.swing.JLabel();
        mesa1 = new javax.swing.JButton();
        mesa2 = new javax.swing.JButton();
        mesa3 = new javax.swing.JButton();
        mesa4 = new javax.swing.JButton();
        mesa5 = new javax.swing.JButton();
        mesa6 = new javax.swing.JButton();
        mesa7 = new javax.swing.JButton();
        mesa8 = new javax.swing.JButton();
        mesa9 = new javax.swing.JButton();
        mesa10 = new javax.swing.JButton();
        mesa11 = new javax.swing.JButton();
        mesa12 = new javax.swing.JButton();
        mesa13 = new javax.swing.JButton();
        mesa14 = new javax.swing.JButton();
        mesa15 = new javax.swing.JButton();
        mesa16 = new javax.swing.JButton();
        mesa17 = new javax.swing.JButton();
        mesa18 = new javax.swing.JButton();
        mesa19 = new javax.swing.JButton();
        mesa20 = new javax.swing.JButton();
        mesa21 = new javax.swing.JButton();
        mesa22 = new javax.swing.JButton();
        mesa23 = new javax.swing.JButton();
        mesa24 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
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
        headerCategories_lista = new javax.swing.JLabel();
        footerCategories_lista = new javax.swing.JLabel();
        bt_voltar = new javax.swing.JButton();
        bt_confirmar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lista_itens = new javax.swing.JScrollPane();
        cardapioRefeicoes = new javax.swing.JPanel();
        headerCategories_lista1 = new javax.swing.JLabel();
        footerCategories_lista1 = new javax.swing.JLabel();
        bt_voltar1 = new javax.swing.JButton();
        bt_confirmar1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lista_itens1 = new javax.swing.JScrollPane();
        cardapioSobremesas = new javax.swing.JPanel();
        headerCategories_lista2 = new javax.swing.JLabel();
        footerCategories_lista2 = new javax.swing.JLabel();
        bt_voltar2 = new javax.swing.JButton();
        bt_confirmar2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lista_itens2 = new javax.swing.JScrollPane();
        cardapioLanches = new javax.swing.JPanel();
        headerCategories_lista3 = new javax.swing.JLabel();
        footerCategories_lista3 = new javax.swing.JLabel();
        bt_voltar3 = new javax.swing.JButton();
        bt_confirmar3 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lista_itens3 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SUPREME "+Mesa.versao_supreme);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        setForeground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(720, 480));
        setName(""); // NOI18N
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

        headerHome2.setBackground(new java.awt.Color(0, 0, 127));
        headerHome2.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerHome2.setForeground(new java.awt.Color(255, 255, 255));
        headerHome2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerHome2.setText("Selecione a sua mesa");
        headerHome2.setToolTipText("");
        headerHome2.setOpaque(true);

        footerHome2.setBackground(new java.awt.Color(0, 0, 127));
        footerHome2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        footerHome2.setForeground(new java.awt.Color(255, 255, 255));
        footerHome2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        footerHome2.setToolTipText("");
        footerHome2.setOpaque(true);

        comboBoxSelectMesa.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
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
            .addComponent(headerHome2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(footerHome2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(headerHome2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(textoSelectMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboBoxSelectMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectMesaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(footerHome2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPrincipal.add(SelectMesaProvavel, "SelectMesa");

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

        showResumo.setEditable(false);
        showResumo.setColumns(1);
        showResumo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        showResumo.setRows(5);
        showResumo.setAutoscrolls(false);
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
                    .addComponent(headerResumo, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addComponent(headerHome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(headerResumo)
                    .addComponent(headerOptions))
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(novoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(fecharConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE))
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
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
        showCPF.setMinimumSize(new java.awt.Dimension(400, 50));
        showCPF.setPreferredSize(new java.awt.Dimension(400, 50));
        showCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCPFActionPerformed(evt);
            }
        });

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
                .addComponent(teclas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, getCPFLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(showCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        FinalMessageLayout.setVerticalGroup(
            FinalMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FinalMessageLayout.createSequentialGroup()
                .addComponent(headerFinalMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(footerFinalMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPrincipal.add(FinalMessage, "FinalMessage");

        SelectMesa.setBackground(new java.awt.Color(255, 255, 255));
        SelectMesa.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        SelectMesa.setInheritsPopupMenu(true);
        SelectMesa.setMinimumSize(new java.awt.Dimension(720, 480));

        headerHome1.setBackground(new java.awt.Color(0, 0, 127));
        headerHome1.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerHome1.setForeground(new java.awt.Color(255, 255, 255));
        headerHome1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerHome1.setText("Selecione a sua mesa");
        headerHome1.setToolTipText("");
        headerHome1.setOpaque(true);

        footerHome1.setBackground(new java.awt.Color(0, 0, 127));
        footerHome1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        footerHome1.setForeground(new java.awt.Color(255, 255, 255));
        footerHome1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        footerHome1.setText(" ");
        footerHome1.setToolTipText("");
        footerHome1.setOpaque(true);

        mesa1.setLabel("1");

        mesa2.setText("2");
        mesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa2ActionPerformed(evt);
            }
        });

        mesa3.setText("3");

        mesa4.setText("4");

        mesa5.setText("5");

        mesa6.setText("6");

        mesa7.setText("7");

        mesa8.setText("8");

        mesa9.setText("9");

        mesa10.setText("10");

        mesa11.setText("11");

        mesa12.setText("12");

        mesa13.setText("13");

        mesa14.setText("14");

        mesa15.setText("15");

        mesa16.setText("16");

        mesa17.setText("17");

        mesa18.setText("18");

        mesa19.setText("19");

        mesa20.setText("20");

        mesa21.setText("21");

        mesa22.setText("22");

        mesa23.setText("23");

        mesa24.setText("24");

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Balcão");
        jLabel1.setToolTipText("");
        jLabel1.setFocusable(false);
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout SelectMesaLayout = new javax.swing.GroupLayout(SelectMesa);
        SelectMesa.setLayout(SelectMesaLayout);
        SelectMesaLayout.setHorizontalGroup(
            SelectMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerHome1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addComponent(footerHome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SelectMesaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SelectMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SelectMesaLayout.createSequentialGroup()
                        .addGroup(SelectMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SelectMesaLayout.createSequentialGroup()
                                .addComponent(mesa1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mesa2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mesa3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SelectMesaLayout.createSequentialGroup()
                                .addComponent(mesa4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mesa5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mesa6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SelectMesaLayout.createSequentialGroup()
                                .addComponent(mesa7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mesa8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mesa9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SelectMesaLayout.createSequentialGroup()
                                .addComponent(mesa10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mesa11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mesa12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(98, 98, 98)
                        .addGroup(SelectMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SelectMesaLayout.createSequentialGroup()
                                .addComponent(mesa22, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mesa23, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mesa24, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SelectMesaLayout.createSequentialGroup()
                                .addComponent(mesa19, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mesa20, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mesa21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SelectMesaLayout.createSequentialGroup()
                                .addComponent(mesa16, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mesa17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mesa18, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SelectMesaLayout.createSequentialGroup()
                                .addComponent(mesa13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mesa14, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mesa15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SelectMesaLayout.setVerticalGroup(
            SelectMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SelectMesaLayout.createSequentialGroup()
                .addComponent(headerHome1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(SelectMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mesa1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa14, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SelectMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mesa4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa16, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa18, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SelectMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mesa7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa19, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa20, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SelectMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mesa10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa22, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa23, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesa24, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 37, Short.MAX_VALUE)
                .addComponent(footerHome1))
        );

        mesa1.getAccessibleContext().setAccessibleName("mesa01");

        panelPrincipal.add(SelectMesa, "card7");

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
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(menuCardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cat1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(Cat3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(menuCardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cat2, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(Cat4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(menuCardapioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuCardapioLayout.setVerticalGroup(
            menuCardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuCardapioLayout.createSequentialGroup()
                .addComponent(headerCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(menuCardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cat1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cat2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(menuCardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cat3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cat4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
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

        headerCategories_lista.setBackground(new java.awt.Color(0, 0, 127));
        headerCategories_lista.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerCategories_lista.setForeground(new java.awt.Color(255, 255, 255));
        headerCategories_lista.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerCategories_lista.setText("Bebidas");
        headerCategories_lista.setToolTipText("");
        headerCategories_lista.setOpaque(true);

        footerCategories_lista.setBackground(new java.awt.Color(0, 0, 127));
        footerCategories_lista.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        footerCategories_lista.setForeground(new java.awt.Color(255, 255, 255));
        footerCategories_lista.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        footerCategories_lista.setText(" ");
        footerCategories_lista.setToolTipText("");
        footerCategories_lista.setOpaque(true);

        bt_voltar.setBackground(new java.awt.Color(0, 0, 76));
        bt_voltar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_voltar.setForeground(new java.awt.Color(244, 244, 255));
        bt_voltar.setText("Voltar");
        bt_voltar.setToolTipText("Clique aqui para fazer um novo pedido!");
        bt_voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_voltar.setMaximumSize(new java.awt.Dimension(2050, 4500));
        bt_voltar.setMinimumSize(new java.awt.Dimension(110, 35));
        bt_voltar.setPreferredSize(new java.awt.Dimension(110, 35));
        bt_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltarActionPerformed(evt);
            }
        });

        bt_confirmar.setBackground(new java.awt.Color(0, 0, 76));
        bt_confirmar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_confirmar.setForeground(new java.awt.Color(244, 244, 255));
        bt_confirmar.setText("Concluído");
        bt_confirmar.setToolTipText("Clique aqui para fazer um novo pedido!");
        bt_confirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_confirmar.setMaximumSize(new java.awt.Dimension(2050, 4500));
        bt_confirmar.setMinimumSize(new java.awt.Dimension(110, 35));
        bt_confirmar.setPreferredSize(new java.awt.Dimension(110, 35));
        bt_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmarActionPerformed(evt);
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
        lista_itens.setViewportBorder(null);
        lista_itens.setOpaque(true);

        lista_itens = bebidas.getPanel();

        javax.swing.GroupLayout cardapioBebidasLayout = new javax.swing.GroupLayout(cardapioBebidas);
        cardapioBebidas.setLayout(cardapioBebidasLayout);
        cardapioBebidasLayout.setHorizontalGroup(
            cardapioBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(footerCategories_lista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerCategories_lista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addComponent(lista_itens)
        );
        cardapioBebidasLayout.setVerticalGroup(
            cardapioBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardapioBebidasLayout.createSequentialGroup()
                .addComponent(headerCategories_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(bt_voltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_confirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(footerCategories_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        Categories.add(cardapioBebidas, "cardapioBebidas");

        cardapioRefeicoes.setBackground(new java.awt.Color(244, 244, 255));
        cardapioRefeicoes.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        cardapioRefeicoes.setInheritsPopupMenu(true);
        cardapioRefeicoes.setMinimumSize(new java.awt.Dimension(720, 480));

        headerCategories_lista1.setBackground(new java.awt.Color(0, 0, 127));
        headerCategories_lista1.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerCategories_lista1.setForeground(new java.awt.Color(255, 255, 255));
        headerCategories_lista1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerCategories_lista1.setText("Refeições");
        headerCategories_lista1.setToolTipText("");
        headerCategories_lista1.setOpaque(true);

        footerCategories_lista1.setBackground(new java.awt.Color(0, 0, 127));
        footerCategories_lista1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        footerCategories_lista1.setForeground(new java.awt.Color(255, 255, 255));
        footerCategories_lista1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        footerCategories_lista1.setText(" ");
        footerCategories_lista1.setToolTipText("");
        footerCategories_lista1.setOpaque(true);

        bt_voltar1.setBackground(new java.awt.Color(0, 0, 76));
        bt_voltar1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_voltar1.setForeground(new java.awt.Color(244, 244, 255));
        bt_voltar1.setText("Voltar");
        bt_voltar1.setToolTipText("Clique aqui para fazer um novo pedido!");
        bt_voltar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_voltar1.setMaximumSize(new java.awt.Dimension(2050, 4500));
        bt_voltar1.setMinimumSize(new java.awt.Dimension(110, 35));
        bt_voltar1.setPreferredSize(new java.awt.Dimension(110, 35));
        bt_voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar1ActionPerformed(evt);
            }
        });

        bt_confirmar1.setBackground(new java.awt.Color(0, 0, 76));
        bt_confirmar1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_confirmar1.setForeground(new java.awt.Color(244, 244, 255));
        bt_confirmar1.setText("Concluído");
        bt_confirmar1.setToolTipText("Clique aqui para fazer um novo pedido!");
        bt_confirmar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_confirmar1.setMaximumSize(new java.awt.Dimension(2050, 4500));
        bt_confirmar1.setMinimumSize(new java.awt.Dimension(110, 35));
        bt_confirmar1.setPreferredSize(new java.awt.Dimension(110, 35));
        bt_confirmar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmar1ActionPerformed(evt);
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
        lista_itens1.setViewportBorder(null);
        lista_itens1.setOpaque(true);

        lista_itens1 = refeicoes.getPanel();

        javax.swing.GroupLayout cardapioRefeicoesLayout = new javax.swing.GroupLayout(cardapioRefeicoes);
        cardapioRefeicoes.setLayout(cardapioRefeicoesLayout);
        cardapioRefeicoesLayout.setHorizontalGroup(
            cardapioRefeicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(footerCategories_lista1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerCategories_lista1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(bt_voltar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_confirmar1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addComponent(lista_itens1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        cardapioRefeicoesLayout.setVerticalGroup(
            cardapioRefeicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardapioRefeicoesLayout.createSequentialGroup()
                .addComponent(headerCategories_lista1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(bt_voltar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_confirmar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(footerCategories_lista1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        Categories.add(cardapioRefeicoes, "cardapioRefeicoes");

        cardapioSobremesas.setBackground(new java.awt.Color(244, 244, 255));
        cardapioSobremesas.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        cardapioSobremesas.setInheritsPopupMenu(true);
        cardapioSobremesas.setMinimumSize(new java.awt.Dimension(720, 480));

        headerCategories_lista2.setBackground(new java.awt.Color(0, 0, 127));
        headerCategories_lista2.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerCategories_lista2.setForeground(new java.awt.Color(255, 255, 255));
        headerCategories_lista2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerCategories_lista2.setText("Sobremesas");
        headerCategories_lista2.setToolTipText("");
        headerCategories_lista2.setOpaque(true);

        footerCategories_lista2.setBackground(new java.awt.Color(0, 0, 127));
        footerCategories_lista2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        footerCategories_lista2.setForeground(new java.awt.Color(255, 255, 255));
        footerCategories_lista2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        footerCategories_lista2.setText(" ");
        footerCategories_lista2.setToolTipText("");
        footerCategories_lista2.setOpaque(true);

        bt_voltar2.setBackground(new java.awt.Color(0, 0, 76));
        bt_voltar2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_voltar2.setForeground(new java.awt.Color(244, 244, 255));
        bt_voltar2.setText("Voltar");
        bt_voltar2.setToolTipText("Clique aqui para fazer um novo pedido!");
        bt_voltar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_voltar2.setMaximumSize(new java.awt.Dimension(2050, 4500));
        bt_voltar2.setMinimumSize(new java.awt.Dimension(110, 35));
        bt_voltar2.setPreferredSize(new java.awt.Dimension(110, 35));
        bt_voltar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar2ActionPerformed(evt);
            }
        });

        bt_confirmar2.setBackground(new java.awt.Color(0, 0, 76));
        bt_confirmar2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_confirmar2.setForeground(new java.awt.Color(244, 244, 255));
        bt_confirmar2.setText("Concluído");
        bt_confirmar2.setToolTipText("Clique aqui para fazer um novo pedido!");
        bt_confirmar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_confirmar2.setMaximumSize(new java.awt.Dimension(2050, 4500));
        bt_confirmar2.setMinimumSize(new java.awt.Dimension(110, 35));
        bt_confirmar2.setPreferredSize(new java.awt.Dimension(110, 35));
        bt_confirmar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmar2ActionPerformed(evt);
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
        lista_itens2.setViewportBorder(null);
        lista_itens2.setOpaque(true);

        lista_itens2 = sobremesas.getPanel();

        javax.swing.GroupLayout cardapioSobremesasLayout = new javax.swing.GroupLayout(cardapioSobremesas);
        cardapioSobremesas.setLayout(cardapioSobremesasLayout);
        cardapioSobremesasLayout.setHorizontalGroup(
            cardapioSobremesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(footerCategories_lista2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerCategories_lista2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(bt_voltar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_confirmar2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addComponent(lista_itens2)
        );
        cardapioSobremesasLayout.setVerticalGroup(
            cardapioSobremesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardapioSobremesasLayout.createSequentialGroup()
                .addComponent(headerCategories_lista2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(bt_voltar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_confirmar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(footerCategories_lista2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        Categories.add(cardapioSobremesas, "cardapioSobremesas");

        cardapioLanches.setBackground(new java.awt.Color(244, 244, 255));
        cardapioLanches.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        cardapioLanches.setInheritsPopupMenu(true);
        cardapioLanches.setMinimumSize(new java.awt.Dimension(720, 480));

        headerCategories_lista3.setBackground(new java.awt.Color(0, 0, 127));
        headerCategories_lista3.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        headerCategories_lista3.setForeground(new java.awt.Color(255, 255, 255));
        headerCategories_lista3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerCategories_lista3.setText("Lanches");
        headerCategories_lista3.setToolTipText("");
        headerCategories_lista3.setOpaque(true);

        footerCategories_lista3.setBackground(new java.awt.Color(0, 0, 127));
        footerCategories_lista3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        footerCategories_lista3.setForeground(new java.awt.Color(255, 255, 255));
        footerCategories_lista3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        footerCategories_lista3.setText(" ");
        footerCategories_lista3.setToolTipText("");
        footerCategories_lista3.setOpaque(true);

        bt_voltar3.setBackground(new java.awt.Color(0, 0, 76));
        bt_voltar3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_voltar3.setForeground(new java.awt.Color(244, 244, 255));
        bt_voltar3.setText("Voltar");
        bt_voltar3.setToolTipText("Clique aqui para fazer um novo pedido!");
        bt_voltar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_voltar3.setMaximumSize(new java.awt.Dimension(2050, 4500));
        bt_voltar3.setMinimumSize(new java.awt.Dimension(110, 35));
        bt_voltar3.setPreferredSize(new java.awt.Dimension(110, 35));
        bt_voltar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar3ActionPerformed(evt);
            }
        });

        bt_confirmar3.setBackground(new java.awt.Color(0, 0, 76));
        bt_confirmar3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_confirmar3.setForeground(new java.awt.Color(244, 244, 255));
        bt_confirmar3.setText("Concluído");
        bt_confirmar3.setToolTipText("Clique aqui para fazer um novo pedido!");
        bt_confirmar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_confirmar3.setMaximumSize(new java.awt.Dimension(2050, 4500));
        bt_confirmar3.setMinimumSize(new java.awt.Dimension(110, 35));
        bt_confirmar3.setPreferredSize(new java.awt.Dimension(110, 35));
        bt_confirmar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmar3ActionPerformed(evt);
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
        lista_itens3.setViewportBorder(null);
        lista_itens3.setOpaque(true);

        lista_itens3 = lanches.getPanel();

        javax.swing.GroupLayout cardapioLanchesLayout = new javax.swing.GroupLayout(cardapioLanches);
        cardapioLanches.setLayout(cardapioLanchesLayout);
        cardapioLanchesLayout.setHorizontalGroup(
            cardapioLanchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(footerCategories_lista3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerCategories_lista3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(bt_voltar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_confirmar3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addComponent(lista_itens3)
        );
        cardapioLanchesLayout.setVerticalGroup(
            cardapioLanchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardapioLanchesLayout.createSequentialGroup()
                .addComponent(headerCategories_lista3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(bt_voltar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_confirmar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(footerCategories_lista3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        Categories.add(cardapioLanches, "cardapioLanches");

        panelPrincipal.add(Categories, "Categories");

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
        headerCategories_lista.setText(dummy.getText());
        card.show(Categories, "Categories.listaCardapio");
    }
    
    private void novoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoPedidoActionPerformed
        showCard("Categories");
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
        getContaInfo();
        showCard("Home");
    }//GEN-LAST:event_backButtonActionPerformed

    private void fecharContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharContaActionPerformed
        showCard("Close");
    }//GEN-LAST:event_fecharContaActionPerformed

    private void cancelCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelCloseActionPerformed
        getContaInfo();
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
        showCard("FinalMessage");
    }//GEN-LAST:event_noCPFActionPerformed

    private void cpfTryAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfTryAgainActionPerformed
        showCPF.setText("");
        CardLayout card = (CardLayout)CPF.getLayout();
        card.show(CPF, "getCPF");
    }//GEN-LAST:event_cpfTryAgainActionPerformed

    private void mesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa2ActionPerformed
        
    }//GEN-LAST:event_mesa2ActionPerformed

    private void selectMesaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectMesaButtonActionPerformed
        //Recebe o número selecionado na comboBox
        numMesa = Integer.parseInt(comboBoxSelectMesa.getSelectedItem().toString());
        //Faz o update do status da mesa no banco
        conn.comando_sql("UPDATE t_mesas SET mesa_status = 1 WHERE mesa_codigo = "+numMesa+";");
        //Altera o header da tela Home adicionando o número da mesa
        headerHome.setText("Mesa: "+numMesa);
        showCard("Home");
    }//GEN-LAST:event_selectMesaButtonActionPerformed

    private void comboBoxSelectMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSelectMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSelectMesaActionPerformed

    private void Cat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cat2ActionPerformed
        CardLayout card = (CardLayout)Categories.getLayout();
        card.show(Categories, "cardapioBebidas");

    }//GEN-LAST:event_Cat2ActionPerformed

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltarActionPerformed
        CardLayout card = (CardLayout)Categories.getLayout();
        card.show(Categories, "Categories.menuCardapio");
    }//GEN-LAST:event_bt_voltarActionPerformed

    private void bt_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_confirmarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        liberarMesa();
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

    private void bt_voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar1ActionPerformed
        CardLayout card = (CardLayout)Categories.getLayout();
        card.show(Categories, "Categories.menuCardapio");
    }//GEN-LAST:event_bt_voltar1ActionPerformed

    private void bt_confirmar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_confirmar1ActionPerformed

    private void bt_voltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar2ActionPerformed
        CardLayout card = (CardLayout)Categories.getLayout();
        card.show(Categories, "Categories.menuCardapio");
    }//GEN-LAST:event_bt_voltar2ActionPerformed

    private void bt_confirmar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_confirmar2ActionPerformed

    private void bt_voltar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar3ActionPerformed
        CardLayout card = (CardLayout)Categories.getLayout();
        card.show(Categories, "Categories.menuCardapio");
    }//GEN-LAST:event_bt_voltar3ActionPerformed

    private void bt_confirmar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_confirmar3ActionPerformed

    private void showCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showCPFActionPerformed

    private void cpfEraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfEraseActionPerformed
        cpf = null;
        showCPF.setText(cpf);
    }//GEN-LAST:event_cpfEraseActionPerformed

    private void cpfFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfFinishActionPerformed
        if(cpf == null || cpf.length()>11 || cpf.length()<11){
            CardLayout card = (CardLayout)CPF.getLayout();
            card.show(CPF, "invalidCPF");
        }else{
            showCard("FinalMessage");
        }
    }//GEN-LAST:event_cpfFinishActionPerformed
    
    private String getData(){
        Date d = Calendar.getInstance().getTime();
        SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
        return sdfD.format(d); //data formatada em string
    }
    
    private String getHora(){
        Date d = Calendar.getInstance().getTime();
        SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm:ss");
        return sdfH.format(d); //hora formatada em string
    }
    
    //-------------BEGIN SQL--------------//
    
        //Adiciona uma nova conta ao banco de dados.
    private void createConta(){ 	
        //Cria uma nova conta na tabela t_contas
        conn.comando_sql("INSERT INTO t_contas(conta_valor, conta_mesa, conta_status, conta_data, conta_hora)" 
                       + "VALUES ("+valorConta+","+numMesa+",'ABERTO','"+getData()+"','"+getHora()+"');");
        //Pega o código gerado pelo banco para esta conta
        ArrayList<ArrayList<String>> codigo = conn.retornar_query("SELECT conta_codigo FROM t_contas "
                          + "WHERE conta_mesa LIKE "+numMesa+" AND conta_status LIKE 'ABERTO';");
        codConta = Integer.parseInt(codigo.get(0).get(0));
    }
    
    //Função que monta e mostra o resumo na Home
    private void getContaInfo(){
        //Inicializa a lista de itens
        String stringItens; //string final dos itens da conta
        double vAux = 0;
        ArrayList<ArrayList<String>> infoItens = new ArrayList(); //guarda as informações de cada item de cada pedido
        ArrayList<ArrayList<String>> codItensPedido;  //Armazena os codigos dos itens de cada pedido 
        ArrayList<ArrayList<String>> codPedidosConta; //Armazena os codigos dos pedidos referentes à conta
        ArrayList<ArrayList<String>> Itens;  //Armazena os codigos dos itens de cada pedido 

        //SELECTS necessários para obtenção dos dados
        codPedidosConta = conn.retornar_query("SELECT t_pedidos_ped_codigo FROM t_pedidos_contas "
                                            + "WHERE t_contas_conta_codigo LIKE '"+codConta+"';");
        for(ArrayList<String> cods: codPedidosConta){
            codItensPedido = conn.retornar_query("SELECT itm_codigo, itm_qtde FROM t_pedido_itens "
                                                + "WHERE ped_codigo LIKE '"+cods.get(0)+"';");
            for(int i = 0; i<codItensPedido.size(); i++){
                Itens = conn.retornar_query("SELECT itm_nome, itm_valor FROM t_itens "
                                            + "WHERE itm_codigo LIKE "+codItensPedido.get(i).get(0)+";");
                for(int j=0; j<Itens.size(); j++){
                    vAux+= Double.parseDouble(Itens.get(j).get(1));
                    ArrayList<String> aux = new ArrayList();
                    aux.add(Itens.get(j).get(0)); //nome do item
                    aux.add(codItensPedido.get(i).get(1)); // qtde do mesmo item
                    aux.add(Itens.get(j).get(1)); //valor do item
                    infoItens.add(aux); //Add to itens
                }
            }
        }
        valorConta = vAux;
        
        //Formatação dos itens em String para amostragem
        stringItens = ""; //reseta e impede de imprimir 'null' no começo
        for(ArrayList<String> ar: infoItens){
            stringItens+="\n"+ar.get(0)+"\t"+ar.get(1)+"\t"+nf.format(Double.parseDouble(ar.get(2)));
        }
        resumo = "Item\t\tQtde.\tValor"
                +"\n---------------------------------------------------------------"+stringItens 
                + "\n---------------------------------------------------------------"+"\nValor Total: "+valorConta
                +"\n\nBom apetite!\n";
        showResumo.setText(resumo);
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
  /*      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mesa().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CPF;
    private javax.swing.JButton Cat1;
    private javax.swing.JButton Cat2;
    private javax.swing.JButton Cat3;
    private javax.swing.JButton Cat4;
    private javax.swing.JPanel Categories;
    private javax.swing.JPanel Close;
    private javax.swing.JPanel FinalMessage;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel SelectMesa;
    private javax.swing.JPanel SelectMesaProvavel;
    private javax.swing.JButton backButton;
    private javax.swing.JButton bt_confirmar;
    private javax.swing.JButton bt_confirmar1;
    private javax.swing.JButton bt_confirmar2;
    private javax.swing.JButton bt_confirmar3;
    private javax.swing.JButton bt_voltar;
    private javax.swing.JButton bt_voltar1;
    private javax.swing.JButton bt_voltar2;
    private javax.swing.JButton bt_voltar3;
    private javax.swing.JButton cancelClose;
    private javax.swing.JPanel cardapioBebidas;
    private javax.swing.JPanel cardapioLanches;
    private javax.swing.JPanel cardapioRefeicoes;
    private javax.swing.JPanel cardapioSobremesas;
    private javax.swing.JToggleButton check_item;
    private javax.swing.JToggleButton check_item1;
    private javax.swing.JToggleButton check_item2;
    private javax.swing.JToggleButton check_item3;
    private javax.swing.JComboBox<String> comboBoxSelectMesa;
    private javax.swing.JButton confirmClose;
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
    private javax.swing.JLabel desc_item;
    private javax.swing.JLabel desc_item1;
    private javax.swing.JLabel desc_item2;
    private javax.swing.JLabel desc_item3;
    private javax.swing.JButton fecharConta;
    private javax.swing.JLabel footerCPF;
    private javax.swing.JLabel footerCPF1;
    private javax.swing.JLabel footerCPF2;
    private javax.swing.JLabel footerCategories;
    private javax.swing.JLabel footerCategories_lista;
    private javax.swing.JLabel footerCategories_lista1;
    private javax.swing.JLabel footerCategories_lista2;
    private javax.swing.JLabel footerCategories_lista3;
    private javax.swing.JLabel footerClose;
    private javax.swing.JLabel footerFinalMessage;
    private javax.swing.JLabel footerHome;
    private javax.swing.JLabel footerHome1;
    private javax.swing.JLabel footerHome2;
    private javax.swing.JPanel getCPF;
    private javax.swing.JLabel getCPFText;
    private javax.swing.JLabel headerCPF;
    private javax.swing.JLabel headerCPF1;
    private javax.swing.JLabel headerCPF2;
    private javax.swing.JLabel headerCategories;
    private javax.swing.JLabel headerCategories_lista;
    private javax.swing.JLabel headerCategories_lista1;
    private javax.swing.JLabel headerCategories_lista2;
    private javax.swing.JLabel headerCategories_lista3;
    private javax.swing.JLabel headerClose;
    private javax.swing.JLabel headerFinalMessage;
    private javax.swing.JLabel headerHome;
    private javax.swing.JLabel headerHome1;
    private javax.swing.JLabel headerHome2;
    private javax.swing.JLabel headerOptions;
    private javax.swing.JLabel headerResumo;
    private javax.swing.JPanel invalidCPF;
    private javax.swing.JLabel invalidCPFText;
    private javax.swing.JPanel item;
    private javax.swing.JPanel item1;
    private javax.swing.JPanel item2;
    private javax.swing.JPanel item3;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JButton mesa1;
    private javax.swing.JButton mesa10;
    private javax.swing.JButton mesa11;
    private javax.swing.JButton mesa12;
    private javax.swing.JButton mesa13;
    private javax.swing.JButton mesa14;
    private javax.swing.JButton mesa15;
    private javax.swing.JButton mesa16;
    private javax.swing.JButton mesa17;
    private javax.swing.JButton mesa18;
    private javax.swing.JButton mesa19;
    private javax.swing.JButton mesa2;
    private javax.swing.JButton mesa20;
    private javax.swing.JButton mesa21;
    private javax.swing.JButton mesa22;
    private javax.swing.JButton mesa23;
    private javax.swing.JButton mesa24;
    private javax.swing.JButton mesa3;
    private javax.swing.JButton mesa4;
    private javax.swing.JButton mesa5;
    private javax.swing.JButton mesa6;
    private javax.swing.JButton mesa7;
    private javax.swing.JButton mesa8;
    private javax.swing.JButton mesa9;
    private javax.swing.JButton noCPF;
    private javax.swing.JLabel nome_item;
    private javax.swing.JLabel nome_item1;
    private javax.swing.JLabel nome_item2;
    private javax.swing.JLabel nome_item3;
    private javax.swing.JButton novoPedido;
    protected javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel preco_item;
    private javax.swing.JLabel preco_item1;
    private javax.swing.JLabel preco_item2;
    private javax.swing.JLabel preco_item3;
    private javax.swing.JSpinner qtd_item;
    private javax.swing.JSpinner qtd_item1;
    private javax.swing.JSpinner qtd_item2;
    private javax.swing.JSpinner qtd_item3;
    private javax.swing.JPanel questCPF;
    private javax.swing.JLabel questCPFText;
    private javax.swing.JButton selectMesaButton;
    private javax.swing.JTextField showCPF;
    private javax.swing.JTextArea showResumo;
    private javax.swing.JPanel teclas;
    private javax.swing.JLabel textoConfirmaFecha;
    private javax.swing.JLabel textoSelectMesa;
    private javax.swing.JButton yesCPF;
    // End of variables declaration//GEN-END:variables
// </editor-fold> 
}
