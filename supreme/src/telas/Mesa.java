package telas;

import java.awt.CardLayout;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Rafael
 */
public class Mesa extends javax.swing.JFrame {

    private String cpf = "", dataHoraAbertura, resumo;
    public static int numMesa, codConta;
    private double valorConta = 0.0;
    private codigo.Conexao conn = new codigo.Conexao(); //conexao com o banco de dados
    private NumberFormat nf = NumberFormat.getCurrencyInstance(); //Formata valor na moeda do sistema
    
    public Mesa() {
        initComponents();
        //Loga no banco
        //troque ou crie este usuário para testar//
        conn.conectar("bnoleto", "041995".toCharArray()); 
        createConta();
        dataHoraAbertura = getData()+" "+getHora();
        getContaInfo();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        Home = new javax.swing.JPanel();
        headerHome = new javax.swing.JLabel();
        footerHome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        showResumo = new javax.swing.JTextArea();
        headerResumo = new javax.swing.JLabel();
        novoPedido = new javax.swing.JButton();
        fecharConta = new javax.swing.JButton();
        headerOptions = new javax.swing.JLabel();
        Categories = new javax.swing.JPanel();
        headerCategories = new javax.swing.JLabel();
        footerCategories = new javax.swing.JLabel();
        Cat1 = new javax.swing.JButton();
        Cat3 = new javax.swing.JButton();
        Cat4 = new javax.swing.JButton();
        Cat2 = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
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
        cpfFinish = new javax.swing.JButton();
        cpfErase = new javax.swing.JButton();
        showCPF = new javax.swing.JTextField();
        cpf0 = new javax.swing.JButton();
        cpf1 = new javax.swing.JButton();
        cpf2 = new javax.swing.JButton();
        cpf3 = new javax.swing.JButton();
        cpf4 = new javax.swing.JButton();
        cpf5 = new javax.swing.JButton();
        cpf7 = new javax.swing.JButton();
        cpf8 = new javax.swing.JButton();
        cpf9 = new javax.swing.JButton();
        cpf6 = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("S.U.P.R.E.M.E. V1.0");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        setForeground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(720, 480));
        setName(""); // NOI18N
        setSize(new java.awt.Dimension(720, 480));

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        panelPrincipal.setInheritsPopupMenu(true);
        panelPrincipal.setMinimumSize(new java.awt.Dimension(720, 480));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(720, 480));
        panelPrincipal.setLayout(new java.awt.CardLayout());

        Home.setBackground(new java.awt.Color(255, 255, 255));
        Home.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        Home.setInheritsPopupMenu(true);
        Home.setMinimumSize(new java.awt.Dimension(720, 480));
        Home.setPreferredSize(new java.awt.Dimension(720, 480));

        headerHome.setBackground(new java.awt.Color(0, 0, 127));
        headerHome.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
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

        headerResumo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        headerResumo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerResumo.setText("Resumo:");

        novoPedido.setBackground(new java.awt.Color(255, 255, 255));
        novoPedido.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        novoPedido.setText("Novo Pedido");
        novoPedido.setToolTipText("");
        novoPedido.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        novoPedido.setMinimumSize(new java.awt.Dimension(250, 100));
        novoPedido.setPreferredSize(new java.awt.Dimension(250, 100));
        novoPedido.setSelected(true);
        novoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoPedidoActionPerformed(evt);
            }
        });

        fecharConta.setBackground(new java.awt.Color(255, 255, 255));
        fecharConta.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        fecharConta.setText("Fechar Conta");
        fecharConta.setToolTipText("");
        fecharConta.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        fecharConta.setMinimumSize(new java.awt.Dimension(250, 100));
        fecharConta.setPreferredSize(new java.awt.Dimension(250, 100));
        fecharConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharContaActionPerformed(evt);
            }
        });

        headerOptions.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(headerResumo, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addComponent(headerHome)
                .addGap(15, 15, 15)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(headerResumo)
                    .addComponent(headerOptions))
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(novoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(41, 41, 41)
                        .addComponent(fecharConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(79, 79, 79))
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(footerHome))
        );

        panelPrincipal.add(Home, "Home");

        Categories.setBackground(new java.awt.Color(255, 255, 255));
        Categories.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        Categories.setInheritsPopupMenu(true);
        Categories.setMinimumSize(new java.awt.Dimension(720, 480));
        Categories.setPreferredSize(new java.awt.Dimension(720, 480));

        headerCategories.setBackground(new java.awt.Color(0, 0, 127));
        headerCategories.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
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

        Cat1.setBackground(new java.awt.Color(255, 255, 255));
        Cat1.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        Cat1.setText("Refeições");
        Cat1.setToolTipText("Clique aqui para fazer um novo pedido!");
        Cat1.setMaximumSize(new java.awt.Dimension(2050, 4500));
        Cat1.setMinimumSize(new java.awt.Dimension(250, 100));
        Cat1.setPreferredSize(new java.awt.Dimension(250, 100));

        Cat3.setBackground(new java.awt.Color(255, 255, 255));
        Cat3.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        Cat3.setText("Sobremesas");
        Cat3.setToolTipText("Clique aqui para fazer um novo pedido!");
        Cat3.setMaximumSize(new java.awt.Dimension(2050, 4500));
        Cat3.setMinimumSize(new java.awt.Dimension(250, 100));
        Cat3.setPreferredSize(new java.awt.Dimension(250, 100));

        Cat4.setBackground(new java.awt.Color(255, 255, 255));
        Cat4.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        Cat4.setText("Lanches");
        Cat4.setToolTipText("Clique aqui para fazer um novo pedido!");
        Cat4.setMaximumSize(new java.awt.Dimension(2050, 4500));
        Cat4.setMinimumSize(new java.awt.Dimension(250, 100));
        Cat4.setPreferredSize(new java.awt.Dimension(250, 100));

        Cat2.setBackground(new java.awt.Color(255, 255, 255));
        Cat2.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        Cat2.setText("Bebidas");
        Cat2.setToolTipText("Clique aqui para fazer um novo pedido!");
        Cat2.setMaximumSize(new java.awt.Dimension(2050, 4500));
        Cat2.setMinimumSize(new java.awt.Dimension(250, 100));
        Cat2.setPreferredSize(new java.awt.Dimension(250, 100));

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        backButton.setText("Voltar");
        backButton.setToolTipText("Clique aqui para fazer um novo pedido!");
        backButton.setMaximumSize(new java.awt.Dimension(2050, 4500));
        backButton.setMinimumSize(new java.awt.Dimension(110, 35));
        backButton.setPreferredSize(new java.awt.Dimension(110, 35));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CategoriesLayout = new javax.swing.GroupLayout(Categories);
        Categories.setLayout(CategoriesLayout);
        CategoriesLayout.setHorizontalGroup(
            CategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(footerCategories, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerCategories, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(CategoriesLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(CategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cat1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(Cat3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(CategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cat2, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(Cat4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(CategoriesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CategoriesLayout.setVerticalGroup(
            CategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CategoriesLayout.createSequentialGroup()
                .addComponent(headerCategories)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(CategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cat1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cat2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(CategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cat3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cat4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(footerCategories)
                .addGap(0, 0, 0))
        );

        panelPrincipal.add(Categories, "Categories");

        Close.setBackground(new java.awt.Color(255, 255, 255));
        Close.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        Close.setInheritsPopupMenu(true);
        Close.setMinimumSize(new java.awt.Dimension(720, 480));

        headerClose.setBackground(new java.awt.Color(0, 0, 127));
        headerClose.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
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

        cancelClose.setBackground(new java.awt.Color(255, 255, 255));
        cancelClose.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        cancelClose.setText("Cancelar");
        cancelClose.setMinimumSize(new java.awt.Dimension(170, 80));
        cancelClose.setPreferredSize(new java.awt.Dimension(170, 80));
        cancelClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelCloseActionPerformed(evt);
            }
        });

        textoConfirmaFecha.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        textoConfirmaFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoConfirmaFecha.setText("Confirme o fechamento de sua conta");

        confirmClose.setBackground(new java.awt.Color(255, 255, 255));
        confirmClose.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        confirmClose.setText("Confirmar");
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
                .addComponent(headerClose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(textoConfirmaFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addGroup(CloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(footerClose)
                .addGap(0, 0, 0))
        );

        panelPrincipal.add(Close, "Close");

        CPF.setBackground(new java.awt.Color(255, 255, 255));
        CPF.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        CPF.setInheritsPopupMenu(true);
        CPF.setMinimumSize(new java.awt.Dimension(720, 480));
        CPF.setPreferredSize(new java.awt.Dimension(720, 480));
        CPF.setLayout(new java.awt.CardLayout());

        questCPF.setBackground(new java.awt.Color(255, 255, 255));
        questCPF.setMinimumSize(new java.awt.Dimension(720, 480));

        headerCPF.setBackground(new java.awt.Color(0, 0, 127));
        headerCPF.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
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

        questCPFText.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        questCPFText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        questCPFText.setText("CPF na nota?");
        questCPFText.setMaximumSize(new java.awt.Dimension(18300, 35000));

        yesCPF.setBackground(new java.awt.Color(255, 255, 255));
        yesCPF.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        yesCPF.setText("Sim");
        yesCPF.setMaximumSize(null);
        yesCPF.setMinimumSize(new java.awt.Dimension(100, 80));
        yesCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesCPFActionPerformed(evt);
            }
        });

        noCPF.setBackground(new java.awt.Color(255, 255, 255));
        noCPF.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        noCPF.setText("Não");
        noCPF.setMaximumSize(null);
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
                .addComponent(headerCPF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(questCPFText, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(questCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(yesCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(footerCPF)
                .addGap(0, 0, 0))
        );

        CPF.add(questCPF, "questCPF");

        getCPF.setBackground(new java.awt.Color(255, 255, 255));
        getCPF.setMinimumSize(new java.awt.Dimension(720, 480));

        headerCPF1.setBackground(new java.awt.Color(0, 0, 127));
        headerCPF1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
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

        getCPFText.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        getCPFText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getCPFText.setText("Informe seu CPF (apenas números):");
        getCPFText.setMaximumSize(new java.awt.Dimension(48000, 35000));

        cpfFinish.setBackground(new java.awt.Color(255, 255, 255));
        cpfFinish.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        cpfFinish.setForeground(new java.awt.Color(1, 1, 1));
        cpfFinish.setText("Finalizar");
        cpfFinish.setMaximumSize(new java.awt.Dimension(1252342, 323429));
        cpfFinish.setMinimumSize(new java.awt.Dimension(145, 60));
        cpfFinish.setPreferredSize(new java.awt.Dimension(145, 60));
        cpfFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfFinishActionPerformed(evt);
            }
        });

        cpfErase.setBackground(new java.awt.Color(254, 254, 254));
        cpfErase.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        cpfErase.setForeground(new java.awt.Color(1, 1, 1));
        cpfErase.setText("Apagar");
        cpfErase.setMaximumSize(new java.awt.Dimension(111342, 123139));
        cpfErase.setMinimumSize(new java.awt.Dimension(145, 60));
        cpfErase.setPreferredSize(new java.awt.Dimension(145, 60));
        cpfErase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfEraseActionPerformed(evt);
            }
        });

        showCPF.setEditable(false);
        showCPF.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        showCPF.setMinimumSize(new java.awt.Dimension(400, 50));
        showCPF.setPreferredSize(new java.awt.Dimension(400, 50));

        cpf0.setBackground(new java.awt.Color(255, 255, 255));
        cpf0.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        cpf0.setText("0");
        cpf0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf0.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf0.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf0.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        cpf1.setBackground(new java.awt.Color(255, 255, 255));
        cpf1.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        cpf1.setText("1");
        cpf1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf1.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf1.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf1.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        cpf2.setBackground(new java.awt.Color(255, 255, 255));
        cpf2.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        cpf2.setText("2");
        cpf2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf2.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf2.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf2.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        cpf3.setBackground(new java.awt.Color(255, 255, 255));
        cpf3.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        cpf3.setText("3");
        cpf3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf3.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf3.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf3.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        cpf4.setBackground(new java.awt.Color(255, 255, 255));
        cpf4.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        cpf4.setText("4");
        cpf4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf4.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf4.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf4.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        cpf5.setBackground(new java.awt.Color(255, 255, 255));
        cpf5.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        cpf5.setText("5");
        cpf5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf5.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf5.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf5.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        cpf7.setBackground(new java.awt.Color(255, 255, 255));
        cpf7.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        cpf7.setText("7");
        cpf7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf7.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf7.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf7.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        cpf8.setBackground(new java.awt.Color(255, 255, 255));
        cpf8.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        cpf8.setText("8");
        cpf8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf8.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf8.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf8.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        cpf9.setBackground(new java.awt.Color(255, 255, 255));
        cpf9.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        cpf9.setText("9");
        cpf9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf9.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf9.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf9.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        cpf6.setBackground(new java.awt.Color(255, 255, 255));
        cpf6.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        cpf6.setText("6");
        cpf6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpf6.setMaximumSize(new java.awt.Dimension(5000000, 5000000));
        cpf6.setMinimumSize(new java.awt.Dimension(60, 60));
        cpf6.setPreferredSize(new java.awt.Dimension(60, 60));
        cpf6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecladoCPF(evt);
            }
        });

        javax.swing.GroupLayout getCPFLayout = new javax.swing.GroupLayout(getCPF);
        getCPF.setLayout(getCPFLayout);
        getCPFLayout.setHorizontalGroup(
            getCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerCPF1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(footerCPF1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(getCPFText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(getCPFLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(showCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(164, 164, 164))
            .addGroup(getCPFLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cpfErase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addGroup(getCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cpf4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cpf1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cpf7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(getCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(getCPFLayout.createSequentialGroup()
                        .addComponent(cpf0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(78, 78, 78))
                    .addGroup(getCPFLayout.createSequentialGroup()
                        .addComponent(cpf2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cpf3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(getCPFLayout.createSequentialGroup()
                        .addGroup(getCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cpf5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cpf8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(getCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpf9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cpf6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(97, 97, 97)
                .addComponent(cpfFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        getCPFLayout.setVerticalGroup(
            getCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(getCPFLayout.createSequentialGroup()
                .addComponent(headerCPF1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getCPFText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 46, Short.MAX_VALUE)
                .addGroup(getCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(getCPFLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(getCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpf7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cpf8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cpf9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(14, 14, 14)
                        .addGroup(getCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpf4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cpf5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cpf6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(getCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpf2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cpf1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cpf3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(cpf0, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addGroup(getCPFLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                        .addGroup(getCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpfErase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpfFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(footerCPF1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        CPF.add(getCPF, "getCPF");

        invalidCPF.setBackground(new java.awt.Color(255, 255, 255));
        invalidCPF.setMinimumSize(new java.awt.Dimension(720, 480));
        invalidCPF.setPreferredSize(new java.awt.Dimension(720, 480));

        headerCPF2.setBackground(new java.awt.Color(0, 0, 127));
        headerCPF2.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
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

        invalidCPFText.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        invalidCPFText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidCPFText.setText("CPF Inválido!");

        cpfTryAgain.setBackground(new java.awt.Color(255, 255, 255));
        cpfTryAgain.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        cpfTryAgain.setText("Tentar novamente");
        cpfTryAgain.setMaximumSize(new java.awt.Dimension(229123123, 12313139));
        cpfTryAgain.setMinimumSize(new java.awt.Dimension(229, 87));
        cpfTryAgain.setPreferredSize(new java.awt.Dimension(229, 87));
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
            .addComponent(invalidCPFText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(invalidCPFLayout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(cpfTryAgain, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(246, 246, 246))
        );
        invalidCPFLayout.setVerticalGroup(
            invalidCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(invalidCPFLayout.createSequentialGroup()
                .addComponent(headerCPF2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(invalidCPFText, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(cpfTryAgain, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(footerCPF2)
                .addGap(0, 0, 0))
        );

        CPF.add(invalidCPF, "invalidCPF");

        panelPrincipal.add(CPF, "CPF");

        FinalMessage.setBackground(new java.awt.Color(255, 255, 255));
        FinalMessage.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        FinalMessage.setInheritsPopupMenu(true);
        FinalMessage.setMinimumSize(new java.awt.Dimension(720, 480));
        FinalMessage.setPreferredSize(new java.awt.Dimension(720, 480));

        headerFinalMessage.setBackground(new java.awt.Color(0, 0, 127));
        headerFinalMessage.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
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

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Por favor, compareça ao caixa para finalizar o pagamento.");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Agradecemos aos nossos clientes pela preferência.");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Quase lá...");

        javax.swing.GroupLayout FinalMessageLayout = new javax.swing.GroupLayout(FinalMessage);
        FinalMessage.setLayout(FinalMessageLayout);
        FinalMessageLayout.setHorizontalGroup(
            FinalMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(footerFinalMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerFinalMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        FinalMessageLayout.setVerticalGroup(
            FinalMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FinalMessageLayout.createSequentialGroup()
                .addComponent(headerFinalMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(footerFinalMessage))
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
                        .addComponent(mesa15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(SelectMesaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        panelPrincipal.add(SelectMesa, "Home");

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
    
    private void showCard(String name){
        CardLayout card = (CardLayout)panelPrincipal.getLayout();
        card.show(panelPrincipal, name);
    }
    
    private void novoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoPedidoActionPerformed
        showCard("Categories");
    }//GEN-LAST:event_novoPedidoActionPerformed

    private void cpfFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfFinishActionPerformed
        if(cpf == null || cpf.length()>11 || cpf.length()<11){
            CardLayout card = (CardLayout)CPF.getLayout();
            card.show(CPF, "invalidCPF");
        }else{
            showCard("FinalMessage");
        }
    }//GEN-LAST:event_cpfFinishActionPerformed

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
    
    private void cpfEraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfEraseActionPerformed
        cpf = null;
        showCPF.setText(cpf);
    }//GEN-LAST:event_cpfEraseActionPerformed

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
        // TODO add your handling code here:
    }//GEN-LAST:event_mesa2ActionPerformed
    
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
        //Comandos SQL para pegar as contas 
        conn.comando_sql("USE bdsupreme2;");	
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mesa().setVisible(true);
            }
        });
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
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelClose;
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
    private javax.swing.JButton fecharConta;
    private javax.swing.JLabel footerCPF;
    private javax.swing.JLabel footerCPF1;
    private javax.swing.JLabel footerCPF2;
    private javax.swing.JLabel footerCategories;
    private javax.swing.JLabel footerClose;
    private javax.swing.JLabel footerFinalMessage;
    private javax.swing.JLabel footerHome;
    private javax.swing.JLabel footerHome1;
    private javax.swing.JPanel getCPF;
    private javax.swing.JLabel getCPFText;
    private javax.swing.JLabel headerCPF;
    private javax.swing.JLabel headerCPF1;
    private javax.swing.JLabel headerCPF2;
    private javax.swing.JLabel headerCategories;
    private javax.swing.JLabel headerClose;
    private javax.swing.JLabel headerFinalMessage;
    private javax.swing.JLabel headerHome;
    private javax.swing.JLabel headerHome1;
    private javax.swing.JLabel headerOptions;
    private javax.swing.JLabel headerResumo;
    private javax.swing.JPanel invalidCPF;
    private javax.swing.JLabel invalidCPFText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
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
    private javax.swing.JButton novoPedido;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel questCPF;
    private javax.swing.JLabel questCPFText;
    private javax.swing.JTextField showCPF;
    private javax.swing.JTextArea showResumo;
    private javax.swing.JLabel textoConfirmaFecha;
    private javax.swing.JButton yesCPF;
    // End of variables declaration//GEN-END:variables
}
