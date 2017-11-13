package telas;

/**
 *
 * @author Rafael
 */
public class Mesa extends javax.swing.JFrame {
    
    public String cpf;
    public static int numMesa;
    
    public Mesa() {
        initComponents();
        //Esconde os paineis na inicialização
        Cardapios.setVisible(false);
        confirmaFecha.setVisible(false);
        questCPF.setVisible(false);
        CPF.setVisible(false);
        CPFinvalido.setVisible(false);
        Final.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Home = new javax.swing.JPanel();
        numeroMesa = new javax.swing.JLabel();
        novoPedido = new javax.swing.JButton();
        fecharConta = new javax.swing.JButton();
        mostraResumo = new javax.swing.JScrollPane();
        resumo = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        Cardapios = new javax.swing.JPanel();
        tituloCardapios = new javax.swing.JLabel();
        btCP1 = new javax.swing.JButton();
        btCP2 = new javax.swing.JButton();
        btCP3 = new javax.swing.JButton();
        btCP4 = new javax.swing.JButton();
        btVoltarCardapios = new javax.swing.JButton();
        confirmaFecha = new javax.swing.JPanel();
        textoConfirmaFecha = new javax.swing.JLabel();
        btConfirmaFechamento = new javax.swing.JButton();
        btCancelaFechamento = new javax.swing.JButton();
        questCPF = new javax.swing.JPanel();
        textoConfirmaFecha1 = new javax.swing.JLabel();
        btSimCPF = new javax.swing.JButton();
        btNaoCPF = new javax.swing.JButton();
        CPF = new javax.swing.JPanel();
        textoConfirmaFecha2 = new javax.swing.JLabel();
        cpf8 = new javax.swing.JButton();
        cpfFinalizar = new javax.swing.JButton();
        cpfApagar = new javax.swing.JButton();
        cpf9 = new javax.swing.JButton();
        cpf7 = new javax.swing.JButton();
        cpf4 = new javax.swing.JButton();
        cpf5 = new javax.swing.JButton();
        cpf6 = new javax.swing.JButton();
        cpf1 = new javax.swing.JButton();
        cpf2 = new javax.swing.JButton();
        cpf3 = new javax.swing.JButton();
        cpf0 = new javax.swing.JButton();
        mostraCPF = new javax.swing.JTextField();
        CPFinvalido = new javax.swing.JPanel();
        textoCPFInvalido = new javax.swing.JLabel();
        tentarNovamente = new javax.swing.JButton();
        Final = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SUPREME v0.000000000000000000000000000000001 alpha");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMinimumSize(new java.awt.Dimension(720, 480));

        Home.setBackground(new java.awt.Color(255, 255, 255));
        Home.setMinimumSize(new java.awt.Dimension(720, 480));
        Home.setPreferredSize(new java.awt.Dimension(720, 480));

        numeroMesa.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        numeroMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numeroMesa.setText("Mesa ##");

        novoPedido.setBackground(new java.awt.Color(255, 255, 255));
        novoPedido.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        novoPedido.setText("Novo Pedido");
        novoPedido.setFocusCycleRoot(true);
        novoPedido.setSelected(true);
        novoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoPedidoActionPerformed(evt);
            }
        });

        fecharConta.setBackground(new java.awt.Color(255, 255, 255));
        fecharConta.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        fecharConta.setText("Fechar Conta");
        fecharConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharContaActionPerformed(evt);
            }
        });

        resumo.setEditable(false);
        resumo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        resumo.setFocusCycleRoot(false);
        resumo.setRequestFocusEnabled(false);
        resumo.setVerifyInputWhenFocusTarget(false);
        mostraResumo.setViewportView(resumo);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Resumo");
        jLabel1.setToolTipText("Resumo da conta até o momento.");

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(numeroMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecharConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(novoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addComponent(mostraResumo))
                .addGap(54, 54, 54))
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addComponent(numeroMesa)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(novoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addGap(38, 38, 38)
                        .addComponent(fecharConta, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addGap(107, 107, 107))
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mostraResumo)
                        .addGap(24, 24, 24))))
        );

        Cardapios.setBackground(new java.awt.Color(255, 255, 255));
        Cardapios.setMinimumSize(new java.awt.Dimension(720, 480));
        Cardapios.setPreferredSize(new java.awt.Dimension(720, 480));

        tituloCardapios.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        tituloCardapios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloCardapios.setText("Cardápios");

        btCP1.setBackground(new java.awt.Color(255, 255, 255));
        btCP1.setFont(new java.awt.Font("Arial", 0, 32)); // NOI18N
        btCP1.setText("Refeições");
        btCP1.setMinimumSize(new java.awt.Dimension(211, 100));
        btCP1.setPreferredSize(new java.awt.Dimension(211, 100));
        btCP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCP1ActionPerformed(evt);
            }
        });

        btCP2.setBackground(new java.awt.Color(255, 255, 255));
        btCP2.setFont(new java.awt.Font("Arial", 0, 32)); // NOI18N
        btCP2.setText("Lanches");
        btCP2.setMinimumSize(new java.awt.Dimension(211, 100));
        btCP2.setPreferredSize(new java.awt.Dimension(211, 100));
        btCP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCP2ActionPerformed(evt);
            }
        });

        btCP3.setBackground(new java.awt.Color(255, 255, 255));
        btCP3.setFont(new java.awt.Font("Arial", 0, 32)); // NOI18N
        btCP3.setText("Sobremesas");
        btCP3.setMinimumSize(new java.awt.Dimension(211, 100));
        btCP3.setPreferredSize(new java.awt.Dimension(211, 100));
        btCP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCP3ActionPerformed(evt);
            }
        });

        btCP4.setBackground(new java.awt.Color(255, 255, 255));
        btCP4.setFont(new java.awt.Font("Arial", 0, 32)); // NOI18N
        btCP4.setText("Bebidas");
        btCP4.setMinimumSize(new java.awt.Dimension(211, 100));
        btCP4.setPreferredSize(new java.awt.Dimension(211, 100));
        btCP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCP4ActionPerformed(evt);
            }
        });

        btVoltarCardapios.setBackground(new java.awt.Color(255, 255, 255));
        btVoltarCardapios.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btVoltarCardapios.setText("Voltar");
        btVoltarCardapios.setMaximumSize(new java.awt.Dimension(12131237, 12312339));
        btVoltarCardapios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarCardapiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CardapiosLayout = new javax.swing.GroupLayout(Cardapios);
        Cardapios.setLayout(CardapiosLayout);
        CardapiosLayout.setHorizontalGroup(
            CardapiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloCardapios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(CardapiosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btVoltarCardapios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(613, 613, 613))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CardapiosLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(CardapiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(CardapiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCP4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(113, 113, 113))
        );
        CardapiosLayout.setVerticalGroup(
            CardapiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardapiosLayout.createSequentialGroup()
                .addComponent(tituloCardapios, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(CardapiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(CardapiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCP4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(77, 77, 77)
                .addComponent(btVoltarCardapios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        confirmaFecha.setBackground(new java.awt.Color(255, 255, 255));
        confirmaFecha.setMinimumSize(new java.awt.Dimension(720, 480));
        confirmaFecha.setPreferredSize(new java.awt.Dimension(720, 480));

        textoConfirmaFecha.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        textoConfirmaFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoConfirmaFecha.setText("Confirme o fechamento de sua conta");

        btConfirmaFechamento.setBackground(new java.awt.Color(255, 255, 255));
        btConfirmaFechamento.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        btConfirmaFechamento.setText("Confirmar");
        btConfirmaFechamento.setMinimumSize(new java.awt.Dimension(170, 80));
        btConfirmaFechamento.setPreferredSize(new java.awt.Dimension(170, 80));
        btConfirmaFechamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmaFechamentoActionPerformed(evt);
            }
        });

        btCancelaFechamento.setBackground(new java.awt.Color(255, 255, 255));
        btCancelaFechamento.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        btCancelaFechamento.setText("Cancelar");
        btCancelaFechamento.setMinimumSize(new java.awt.Dimension(170, 80));
        btCancelaFechamento.setPreferredSize(new java.awt.Dimension(170, 80));
        btCancelaFechamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelaFechamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout confirmaFechaLayout = new javax.swing.GroupLayout(confirmaFecha);
        confirmaFecha.setLayout(confirmaFechaLayout);
        confirmaFechaLayout.setHorizontalGroup(
            confirmaFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textoConfirmaFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(confirmaFechaLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(btConfirmaFechamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addComponent(btCancelaFechamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(172, 172, 172))
        );
        confirmaFechaLayout.setVerticalGroup(
            confirmaFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmaFechaLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(textoConfirmaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(confirmaFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConfirmaFechamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCancelaFechamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(165, 165, 165))
        );

        questCPF.setBackground(new java.awt.Color(255, 255, 255));
        questCPF.setAlignmentX(0.0F);
        questCPF.setAlignmentY(0.0F);
        questCPF.setMinimumSize(new java.awt.Dimension(720, 480));
        questCPF.setPreferredSize(new java.awt.Dimension(720, 480));

        textoConfirmaFecha1.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        textoConfirmaFecha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoConfirmaFecha1.setText("CPF na nota?");
        textoConfirmaFecha1.setMaximumSize(new java.awt.Dimension(18300, 35000));

        btSimCPF.setBackground(new java.awt.Color(255, 255, 255));
        btSimCPF.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btSimCPF.setText("Sim");
        btSimCPF.setMaximumSize(null);
        btSimCPF.setMinimumSize(new java.awt.Dimension(100, 80));
        btSimCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimCPFActionPerformed(evt);
            }
        });

        btNaoCPF.setBackground(new java.awt.Color(255, 255, 255));
        btNaoCPF.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btNaoCPF.setText("Não");
        btNaoCPF.setMaximumSize(null);
        btNaoCPF.setMinimumSize(new java.awt.Dimension(100, 80));
        btNaoCPF.setPreferredSize(new java.awt.Dimension(100, 80));
        btNaoCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNaoCPFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout questCPFLayout = new javax.swing.GroupLayout(questCPF);
        questCPF.setLayout(questCPFLayout);
        questCPFLayout.setHorizontalGroup(
            questCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textoConfirmaFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(questCPFLayout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(btSimCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addGap(74, 74, 74)
                .addComponent(btNaoCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(223, 223, 223))
        );
        questCPFLayout.setVerticalGroup(
            questCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(questCPFLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(textoConfirmaFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(questCPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNaoCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSimCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(185, 185, 185))
        );

        CPF.setBackground(new java.awt.Color(255, 255, 255));
        CPF.setMinimumSize(new java.awt.Dimension(720, 480));
        CPF.setPreferredSize(new java.awt.Dimension(720, 480));

        textoConfirmaFecha2.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        textoConfirmaFecha2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoConfirmaFecha2.setText("Informe seu CPF (apenas números):");
        textoConfirmaFecha2.setMaximumSize(new java.awt.Dimension(48000, 35000));

        cpf8.setBackground(new java.awt.Color(255, 255, 255));
        cpf8.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        cpf8.setForeground(new java.awt.Color(1, 1, 1));
        cpf8.setText("8");
        cpf8.setMaximumSize(new java.awt.Dimension(70000, 70000));
        cpf8.setMinimumSize(new java.awt.Dimension(65, 60));
        cpf8.setPreferredSize(new java.awt.Dimension(65, 60));
        cpf8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpf8ActionPerformed(evt);
            }
        });

        cpfFinalizar.setBackground(new java.awt.Color(255, 255, 255));
        cpfFinalizar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        cpfFinalizar.setForeground(new java.awt.Color(1, 1, 1));
        cpfFinalizar.setText("Finalizar");
        cpfFinalizar.setMaximumSize(new java.awt.Dimension(1252342, 323429));
        cpfFinalizar.setMinimumSize(new java.awt.Dimension(145, 60));
        cpfFinalizar.setPreferredSize(new java.awt.Dimension(145, 60));
        cpfFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfFinalizarActionPerformed(evt);
            }
        });

        cpfApagar.setBackground(new java.awt.Color(254, 254, 254));
        cpfApagar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        cpfApagar.setForeground(new java.awt.Color(1, 1, 1));
        cpfApagar.setText("Apagar");
        cpfApagar.setMaximumSize(new java.awt.Dimension(111342, 123139));
        cpfApagar.setMinimumSize(new java.awt.Dimension(145, 60));
        cpfApagar.setPreferredSize(new java.awt.Dimension(145, 60));
        cpfApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfApagarActionPerformed(evt);
            }
        });

        cpf9.setBackground(new java.awt.Color(255, 255, 255));
        cpf9.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        cpf9.setForeground(new java.awt.Color(1, 1, 1));
        cpf9.setText("9");
        cpf9.setMaximumSize(new java.awt.Dimension(70000, 70000));
        cpf9.setMinimumSize(new java.awt.Dimension(65, 60));
        cpf9.setPreferredSize(new java.awt.Dimension(65, 60));
        cpf9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpf9ActionPerformed(evt);
            }
        });

        cpf7.setBackground(new java.awt.Color(255, 255, 255));
        cpf7.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        cpf7.setForeground(new java.awt.Color(1, 1, 1));
        cpf7.setText("7");
        cpf7.setMaximumSize(new java.awt.Dimension(70000, 70000));
        cpf7.setMinimumSize(new java.awt.Dimension(65, 60));
        cpf7.setPreferredSize(new java.awt.Dimension(65, 60));
        cpf7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpf7ActionPerformed(evt);
            }
        });

        cpf4.setBackground(new java.awt.Color(255, 255, 255));
        cpf4.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        cpf4.setForeground(new java.awt.Color(1, 1, 1));
        cpf4.setText("4");
        cpf4.setMaximumSize(new java.awt.Dimension(70000, 70000));
        cpf4.setMinimumSize(new java.awt.Dimension(65, 60));
        cpf4.setPreferredSize(new java.awt.Dimension(65, 60));
        cpf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpf4ActionPerformed(evt);
            }
        });

        cpf5.setBackground(new java.awt.Color(255, 255, 255));
        cpf5.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        cpf5.setForeground(new java.awt.Color(1, 1, 1));
        cpf5.setText("5");
        cpf5.setMaximumSize(new java.awt.Dimension(70000, 70000));
        cpf5.setMinimumSize(new java.awt.Dimension(65, 60));
        cpf5.setPreferredSize(new java.awt.Dimension(65, 60));
        cpf5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpf5ActionPerformed(evt);
            }
        });

        cpf6.setBackground(new java.awt.Color(255, 255, 255));
        cpf6.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        cpf6.setForeground(new java.awt.Color(1, 1, 1));
        cpf6.setText("6");
        cpf6.setMaximumSize(new java.awt.Dimension(70000, 70000));
        cpf6.setMinimumSize(new java.awt.Dimension(65, 60));
        cpf6.setPreferredSize(new java.awt.Dimension(65, 60));
        cpf6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpf6ActionPerformed(evt);
            }
        });

        cpf1.setBackground(new java.awt.Color(255, 255, 255));
        cpf1.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        cpf1.setForeground(new java.awt.Color(1, 1, 1));
        cpf1.setText("1");
        cpf1.setMaximumSize(new java.awt.Dimension(70000, 70000));
        cpf1.setMinimumSize(new java.awt.Dimension(65, 60));
        cpf1.setPreferredSize(new java.awt.Dimension(65, 60));
        cpf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpf1ActionPerformed(evt);
            }
        });

        cpf2.setBackground(new java.awt.Color(255, 255, 255));
        cpf2.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        cpf2.setForeground(new java.awt.Color(1, 1, 1));
        cpf2.setText("2");
        cpf2.setMaximumSize(new java.awt.Dimension(70000, 70000));
        cpf2.setMinimumSize(new java.awt.Dimension(65, 60));
        cpf2.setPreferredSize(new java.awt.Dimension(65, 60));
        cpf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpf2ActionPerformed(evt);
            }
        });

        cpf3.setBackground(new java.awt.Color(255, 255, 255));
        cpf3.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        cpf3.setForeground(new java.awt.Color(1, 1, 1));
        cpf3.setText("3");
        cpf3.setMaximumSize(new java.awt.Dimension(70000, 70000));
        cpf3.setMinimumSize(new java.awt.Dimension(65, 60));
        cpf3.setPreferredSize(new java.awt.Dimension(65, 60));
        cpf3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpf3ActionPerformed(evt);
            }
        });

        cpf0.setBackground(new java.awt.Color(255, 255, 255));
        cpf0.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        cpf0.setForeground(new java.awt.Color(1, 1, 1));
        cpf0.setText("0");
        cpf0.setMaximumSize(new java.awt.Dimension(70000, 70000));
        cpf0.setMinimumSize(new java.awt.Dimension(65, 60));
        cpf0.setPreferredSize(new java.awt.Dimension(65, 60));
        cpf0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpf0ActionPerformed(evt);
            }
        });

        mostraCPF.setEditable(false);
        mostraCPF.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        mostraCPF.setMinimumSize(new java.awt.Dimension(400, 50));
        mostraCPF.setPreferredSize(new java.awt.Dimension(400, 50));

        javax.swing.GroupLayout CPFLayout = new javax.swing.GroupLayout(CPF);
        CPF.setLayout(CPFLayout);
        CPFLayout.setHorizontalGroup(
            CPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CPFLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoConfirmaFecha2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(CPFLayout.createSequentialGroup()
                        .addGroup(CPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CPFLayout.createSequentialGroup()
                                .addGap(231, 231, 231)
                                .addGroup(CPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CPFLayout.createSequentialGroup()
                                        .addComponent(cpf1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addGroup(CPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(CPFLayout.createSequentialGroup()
                                                .addComponent(cpf0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(83, 83, 83))
                                            .addGroup(CPFLayout.createSequentialGroup()
                                                .addComponent(cpf2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cpf3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CPFLayout.createSequentialGroup()
                                        .addComponent(cpf4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cpf5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cpf6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CPFLayout.createSequentialGroup()
                                        .addComponent(cpf7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cpf8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cpf9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(CPFLayout.createSequentialGroup()
                                .addComponent(cpfApagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(317, 317, 317)))
                        .addGap(93, 93, 93)
                        .addComponent(cpfFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(CPFLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(mostraCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(168, 168, 168))
        );
        CPFLayout.setVerticalGroup(
            CPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CPFLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoConfirmaFecha2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(19, 19, 19)
                .addComponent(mostraCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(CPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpf8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cpf9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cpf7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cpf4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(CPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cpf5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cpf6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(11, 11, 11)
                .addGroup(CPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpf2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cpf3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cpf1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cpf0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addGroup(CPFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cpfApagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        CPFinvalido.setBackground(new java.awt.Color(255, 255, 255));
        CPFinvalido.setMinimumSize(new java.awt.Dimension(720, 480));
        CPFinvalido.setPreferredSize(new java.awt.Dimension(720, 480));

        textoCPFInvalido.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        textoCPFInvalido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoCPFInvalido.setText("CPF Inválido!");

        tentarNovamente.setBackground(new java.awt.Color(255, 255, 255));
        tentarNovamente.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        tentarNovamente.setText("Tentar novamente");
        tentarNovamente.setMaximumSize(new java.awt.Dimension(229123123, 12313139));
        tentarNovamente.setMinimumSize(new java.awt.Dimension(229, 87));
        tentarNovamente.setPreferredSize(new java.awt.Dimension(229, 87));
        tentarNovamente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tentarNovamenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CPFinvalidoLayout = new javax.swing.GroupLayout(CPFinvalido);
        CPFinvalido.setLayout(CPFinvalidoLayout);
        CPFinvalidoLayout.setHorizontalGroup(
            CPFinvalidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textoCPFInvalido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CPFinvalidoLayout.createSequentialGroup()
                .addContainerGap(247, Short.MAX_VALUE)
                .addComponent(tentarNovamente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(244, 244, 244))
        );
        CPFinvalidoLayout.setVerticalGroup(
            CPFinvalidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CPFinvalidoLayout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(textoCPFInvalido, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(tentarNovamente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(161, 161, 161))
        );

        Final.setBackground(new java.awt.Color(255, 255, 255));
        Final.setMinimumSize(new java.awt.Dimension(720, 480));
        Final.setPreferredSize(new java.awt.Dimension(720, 480));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Por favor, compareça ao caixa para finalizar o pagamento.");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Agradecemos aos nossos clientes pela preferência.");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Quase lá...");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 100)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 255, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("$");

        javax.swing.GroupLayout FinalLayout = new javax.swing.GroupLayout(Final);
        Final.setLayout(FinalLayout);
        FinalLayout.setHorizontalGroup(
            FinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        FinalLayout.setVerticalGroup(
            FinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FinalLayout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(82, 82, 82)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(88, 88, 88)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Final, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(confirmaFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CPFinvalido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Cardapios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(questCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Final, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(confirmaFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(CPFinvalido, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(Cardapios, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(questCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(Home, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(CPF, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //Action do botão Novo Pedido, do Panel Home
    private void novoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoPedidoActionPerformed
        Home.setVisible(false);
        Cardapios.setVisible(true);
    }//GEN-LAST:event_novoPedidoActionPerformed
    
    //Action do botão Refeições, do Panel Cardapios
    private void btCP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCP1ActionPerformed
        Cardapios.setVisible(false);
        int itens[] = {0,1,2,3,4};
        Cardapio c = new Cardapio("Refeições", itens);
        c.setVisible(true);
    }//GEN-LAST:event_btCP1ActionPerformed
    
    //Action do botão Doces, do Panel Cardapios
    private void btCP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCP3ActionPerformed
        Cardapios.setVisible(false);
        int itens[] = {0,1,2,3,4};
        Cardapio c = new Cardapio("Sobremesas", itens);
        c.setVisible(true);
    }//GEN-LAST:event_btCP3ActionPerformed
    
    //Action do botão Lanches, do Panel Cardapios
    private void btCP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCP2ActionPerformed
        Cardapios.setVisible(false);
        int itens[] = {0,1,2,3,4};
        Cardapio c = new Cardapio("Lanches", itens);
        c.setVisible(true);
    }//GEN-LAST:event_btCP2ActionPerformed
    
    //Action do botão Bebidas, do Panel Cardapios
    private void btCP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCP4ActionPerformed
        Cardapios.setVisible(false);
        int itens[] = {0,1,2,3,4}; //Apenas exemplo
        Cardapio c = new Cardapio("Bebidas", itens);
        c.setVisible(true);
    }//GEN-LAST:event_btCP4ActionPerformed

    //Action do botão Voltar, do Panel Cardapios
    private void btVoltarCardapiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarCardapiosActionPerformed
        Cardapios.setVisible(false);
        Home.setVisible(true);
    }//GEN-LAST:event_btVoltarCardapiosActionPerformed
   
    //Action do botão de confirmação do fechamento da conta
    private void btConfirmaFechamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmaFechamentoActionPerformed
        confirmaFecha.setVisible(false);
        questCPF.setVisible(true);
    }//GEN-LAST:event_btConfirmaFechamentoActionPerformed
    
    //Action do botão que cancela o fechamento da conta
    private void btCancelaFechamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelaFechamentoActionPerformed
        confirmaFecha.setVisible(false);
        Home.setVisible(true);
    }//GEN-LAST:event_btCancelaFechamentoActionPerformed
    
    //Action do botão Finalizar Conta
    private void fecharContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharContaActionPerformed
        Home.setVisible(false);
        confirmaFecha.setVisible(true);
    }//GEN-LAST:event_fecharContaActionPerformed
    
    //Action do botão que confirma o CPF na nota
    private void btSimCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimCPFActionPerformed
        questCPF.setVisible(false);
        CPF.setVisible(true);
    }//GEN-LAST:event_btSimCPFActionPerformed
    
    //Action do botão que não confirma CPF na nota
    private void btNaoCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNaoCPFActionPerformed
        questCPF.setVisible(false);
        Final.setVisible(true);
    }//GEN-LAST:event_btNaoCPFActionPerformed
    
    //INICIO TECLADO CPF
    //Action do teclado que pega o cpf
    private void cpf8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpf8ActionPerformed
        cpf = mostraCPF.getText()+"8";
        mostraCPF.setText(cpf);
    }//GEN-LAST:event_cpf8ActionPerformed

    private void cpfFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfFinalizarActionPerformed
        CPF.setVisible(false);
        if(cpf == null || cpf.length()>11 || cpf.length()<11){
            CPFinvalido.setVisible(true);
        }else{
            Final.setVisible(true);
        }
    }//GEN-LAST:event_cpfFinalizarActionPerformed

    private void cpfApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfApagarActionPerformed
        cpf = null;
        mostraCPF.setText(cpf);
    }//GEN-LAST:event_cpfApagarActionPerformed

    private void cpf9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpf9ActionPerformed
        cpf = mostraCPF.getText()+"9";
        mostraCPF.setText(cpf);
    }//GEN-LAST:event_cpf9ActionPerformed

    private void cpf7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpf7ActionPerformed
        cpf = mostraCPF.getText()+"7";
        mostraCPF.setText(cpf);
    }//GEN-LAST:event_cpf7ActionPerformed

    private void cpf4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpf4ActionPerformed
        cpf = mostraCPF.getText()+"4";
        mostraCPF.setText(cpf);
    }//GEN-LAST:event_cpf4ActionPerformed

    private void cpf5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpf5ActionPerformed
        cpf = mostraCPF.getText()+"5";
        mostraCPF.setText(cpf);
    }//GEN-LAST:event_cpf5ActionPerformed

    private void cpf6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpf6ActionPerformed
        cpf = mostraCPF.getText()+"6";
        mostraCPF.setText(cpf);
    }//GEN-LAST:event_cpf6ActionPerformed

    private void cpf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpf1ActionPerformed
        cpf = mostraCPF.getText()+"1";
        mostraCPF.setText(cpf);
    }//GEN-LAST:event_cpf1ActionPerformed

    private void cpf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpf2ActionPerformed
        cpf = mostraCPF.getText()+"2";
        mostraCPF.setText(cpf);
    }//GEN-LAST:event_cpf2ActionPerformed

    private void cpf3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpf3ActionPerformed
        cpf = mostraCPF.getText()+"3";
        mostraCPF.setText(cpf);
    }//GEN-LAST:event_cpf3ActionPerformed

    private void cpf0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpf0ActionPerformed
        cpf = mostraCPF.getText()+"0";
        mostraCPF.setText(cpf);
    }//GEN-LAST:event_cpf0ActionPerformed
    //FIM TECLADO CPF
    
    //Action do botão Tentar Novamente, da tela de erro do CPF
    private void tentarNovamenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tentarNovamenteActionPerformed
        mostraCPF.setText("");
        CPF.setVisible(true);
        CPFinvalido.setVisible(false);
    }//GEN-LAST:event_tentarNovamenteActionPerformed
    
    
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mesa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CPF;
    private javax.swing.JPanel CPFinvalido;
    public static javax.swing.JPanel Cardapios;
    private javax.swing.JPanel Final;
    public static javax.swing.JPanel Home;
    private javax.swing.JButton btCP1;
    private javax.swing.JButton btCP2;
    private javax.swing.JButton btCP3;
    private javax.swing.JButton btCP4;
    private javax.swing.JButton btCancelaFechamento;
    private javax.swing.JButton btConfirmaFechamento;
    private javax.swing.JButton btNaoCPF;
    private javax.swing.JButton btSimCPF;
    private javax.swing.JButton btVoltarCardapios;
    private javax.swing.JPanel confirmaFecha;
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
    private javax.swing.JButton cpfApagar;
    private javax.swing.JButton cpfFinalizar;
    private javax.swing.JButton fecharConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField mostraCPF;
    private javax.swing.JScrollPane mostraResumo;
    private javax.swing.JButton novoPedido;
    private javax.swing.JLabel numeroMesa;
    private javax.swing.JPanel questCPF;
    public static javax.swing.JTextPane resumo;
    private javax.swing.JButton tentarNovamente;
    private javax.swing.JLabel textoCPFInvalido;
    private javax.swing.JLabel textoConfirmaFecha;
    private javax.swing.JLabel textoConfirmaFecha1;
    private javax.swing.JLabel textoConfirmaFecha2;
    private javax.swing.JLabel tituloCardapios;
    // End of variables declaration//GEN-END:variables
}
