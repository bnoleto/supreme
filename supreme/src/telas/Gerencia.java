package telas;

import codigo.Conexao;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Rafael
 */
public class Gerencia extends javax.swing.JFrame {
    
    private codigo.Conexao conn = new codigo.Conexao(); //conexao com o banco de dados
    private NumberFormat nf = NumberFormat.getCurrencyInstance(); //Formata valor na moeda do sistema
    private ArrayList<ArrayList<String>> tabelaItens = new ArrayList(); 
    private ArrayList<ArrayList<String>> tabelaPessoas = new ArrayList(); 
    private ArrayList<ArrayList<String>> tabelaMesas = new ArrayList();
    private ArrayList<ArrayList<String>> tabelaPedidos = new ArrayList();
    private DefaultTableModel modelPessoas, modelItens, modelPedidos, modelMesas;
    
    //ALTERAR OS VALORES DE TAMANHO DOS JINTERNALFRAMES ANTES DE TESTAR OU COMPILAR
    //POR PADRÃO, SEMPRE FICAM 0x0. BASTA MUDAR PARA DEFAULT
    
    public Gerencia() {
        initComponents();
    }

    public void initConexao(Conexao conex){
        this.conn = conex;
        System.out.println(conn.getStatus());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desktop = new javax.swing.JDesktopPane();
        Pessoas = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePessoas = new javax.swing.JTable();
        jToolBar2 = new javax.swing.JToolBar();
        cadastraPessoa = new javax.swing.JButton();
        gap = new javax.swing.JLabel();
        alteraPessoa = new javax.swing.JButton();
        gap1 = new javax.swing.JLabel();
        excluiPessoa = new javax.swing.JButton();
        gap8 = new javax.swing.JLabel();
        atualizaPessoas = new javax.swing.JButton();
        Itens = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableItens = new javax.swing.JTable();
        jToolBar3 = new javax.swing.JToolBar();
        cadastraItem = new javax.swing.JButton();
        gap2 = new javax.swing.JLabel();
        alteraItem = new javax.swing.JButton();
        gap3 = new javax.swing.JLabel();
        excluiItem = new javax.swing.JButton();
        gap9 = new javax.swing.JLabel();
        atualizaItens = new javax.swing.JButton();
        Mesas = new javax.swing.JInternalFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableMesas = new javax.swing.JTable();
        jToolBar4 = new javax.swing.JToolBar();
        cadastraMesa = new javax.swing.JButton();
        gap4 = new javax.swing.JLabel();
        alteraMesa = new javax.swing.JButton();
        gap5 = new javax.swing.JLabel();
        excluiMesa = new javax.swing.JButton();
        gap10 = new javax.swing.JLabel();
        atualizaMesas = new javax.swing.JButton();
        Pedidos = new javax.swing.JInternalFrame();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablePedidos = new javax.swing.JTable();
        jToolBar5 = new javax.swing.JToolBar();
        cadastraPedido = new javax.swing.JButton();
        gap6 = new javax.swing.JLabel();
        alteraPedido = new javax.swing.JButton();
        gap7 = new javax.swing.JLabel();
        excluirPedido = new javax.swing.JButton();
        gap11 = new javax.swing.JLabel();
        atualizaPedidos = new javax.swing.JButton();
        Menu = new javax.swing.JMenuBar();
        menuGerencia = new javax.swing.JMenu();
        menuPessoa = new javax.swing.JMenuItem();
        menuItem = new javax.swing.JMenuItem();
        menuPedido = new javax.swing.JMenuItem();
        menuMesa = new javax.swing.JMenuItem();
        menuConta = new javax.swing.JMenu();
        menuLogout = new javax.swing.JMenuItem();
        menuTrocaUser = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("S.U.P.R.E.M.E - Gerência");
        setBackground(new java.awt.Color(0, 153, 153));
        setMinimumSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Desktop.setDragMode(javax.swing.JDesktopPane.OUTLINE_DRAG_MODE);
        Desktop.setMinimumSize(new java.awt.Dimension(720, 480));
        Desktop.setPreferredSize(new java.awt.Dimension(800, 600));

        Pessoas.setClosable(true);
        Pessoas.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        Pessoas.setMaximizable(true);
        Pessoas.setResizable(true);
        Pessoas.setTitle("Gerencia Pessoal");
        Pessoas.setMinimumSize(new java.awt.Dimension(720, 480));
        Pessoas.setPreferredSize(new java.awt.Dimension(720, 480));
        Pessoas.setVisible(false);

        tablePessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Tipo", "Login", "Senha"
            }
        ));
        tablePessoas.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(tablePessoas);
        if (tablePessoas.getColumnModel().getColumnCount() > 0) {
            tablePessoas.getColumnModel().getColumn(2).setResizable(false);
        }

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        cadastraPessoa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cadastraPessoa.setText("Cadastrar");
        cadastraPessoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cadastraPessoa.setFocusable(false);
        cadastraPessoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cadastraPessoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cadastraPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastraPessoaActionPerformed(evt);
            }
        });
        jToolBar2.add(cadastraPessoa);

        gap.setText("  ");
        jToolBar2.add(gap);

        alteraPessoa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        alteraPessoa.setText("Alterar");
        alteraPessoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alteraPessoa.setFocusable(false);
        alteraPessoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alteraPessoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(alteraPessoa);

        gap1.setText("  ");
        jToolBar2.add(gap1);

        excluiPessoa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        excluiPessoa.setText("Excluir");
        excluiPessoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        excluiPessoa.setFocusable(false);
        excluiPessoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        excluiPessoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(excluiPessoa);

        gap8.setText("  ");
        jToolBar2.add(gap8);

        atualizaPessoas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        atualizaPessoas.setText("Atualizar");
        atualizaPessoas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atualizaPessoas.setFocusable(false);
        atualizaPessoas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        atualizaPessoas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(atualizaPessoas);

        javax.swing.GroupLayout PessoasLayout = new javax.swing.GroupLayout(Pessoas.getContentPane());
        Pessoas.getContentPane().setLayout(PessoasLayout);
        PessoasLayout.setHorizontalGroup(
            PessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PessoasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PessoasLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jToolBar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        PessoasLayout.setVerticalGroup(
            PessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PessoasLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Itens.setClosable(true);
        Itens.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        Itens.setMaximizable(true);
        Itens.setResizable(true);
        Itens.setTitle("Gerenciamento dos Itens");
        Itens.setMinimumSize(new java.awt.Dimension(720, 480));
        Itens.setPreferredSize(new java.awt.Dimension(720, 480));
        Itens.setVisible(false);

        tableItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Descricao", "Tipo", "Preço", "Status"
            }
        ));
        tableItens.setFillsViewportHeight(true);
        jScrollPane2.setViewportView(tableItens);
        if (tableItens.getColumnModel().getColumnCount() > 0) {
            tableItens.getColumnModel().getColumn(2).setResizable(false);
        }

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        cadastraItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cadastraItem.setText("Cadastrar");
        cadastraItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cadastraItem.setFocusable(false);
        cadastraItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cadastraItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(cadastraItem);

        gap2.setText("  ");
        jToolBar3.add(gap2);

        alteraItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        alteraItem.setText("Alterar");
        alteraItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alteraItem.setFocusable(false);
        alteraItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alteraItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(alteraItem);

        gap3.setText("  ");
        jToolBar3.add(gap3);

        excluiItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        excluiItem.setText("Excluir");
        excluiItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        excluiItem.setFocusable(false);
        excluiItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        excluiItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(excluiItem);

        gap9.setText("  ");
        jToolBar3.add(gap9);

        atualizaItens.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        atualizaItens.setText("Atualizar");
        atualizaItens.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atualizaItens.setFocusable(false);
        atualizaItens.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        atualizaItens.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(atualizaItens);

        javax.swing.GroupLayout ItensLayout = new javax.swing.GroupLayout(Itens.getContentPane());
        Itens.getContentPane().setLayout(ItensLayout);
        ItensLayout.setHorizontalGroup(
            ItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItensLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ItensLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jToolBar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        ItensLayout.setVerticalGroup(
            ItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItensLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Mesas.setClosable(true);
        Mesas.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        Mesas.setMaximizable(true);
        Mesas.setResizable(true);
        Mesas.setTitle("Gerenciamento das Mesas");
        Mesas.setMinimumSize(new java.awt.Dimension(435, 480));
        Mesas.setPreferredSize(new java.awt.Dimension(435, 480));
        Mesas.setVisible(false);

        tableMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Status"
            }
        ));
        tableMesas.setFillsViewportHeight(true);
        jScrollPane3.setViewportView(tableMesas);

        jToolBar4.setRollover(true);

        cadastraMesa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cadastraMesa.setText("Cadastrar");
        cadastraMesa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cadastraMesa.setFocusable(false);
        cadastraMesa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cadastraMesa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar4.add(cadastraMesa);

        gap4.setText("  ");
        jToolBar4.add(gap4);

        alteraMesa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        alteraMesa.setText("Alterar");
        alteraMesa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alteraMesa.setFocusable(false);
        alteraMesa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alteraMesa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar4.add(alteraMesa);

        gap5.setText("  ");
        jToolBar4.add(gap5);

        excluiMesa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        excluiMesa.setText("Excluir");
        excluiMesa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        excluiMesa.setFocusable(false);
        excluiMesa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        excluiMesa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar4.add(excluiMesa);

        gap10.setText("  ");
        jToolBar4.add(gap10);

        atualizaMesas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        atualizaMesas.setText("Atualizar");
        atualizaMesas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atualizaMesas.setFocusable(false);
        atualizaMesas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        atualizaMesas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar4.add(atualizaMesas);

        javax.swing.GroupLayout MesasLayout = new javax.swing.GroupLayout(Mesas.getContentPane());
        Mesas.getContentPane().setLayout(MesasLayout);
        MesasLayout.setHorizontalGroup(
            MesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MesasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MesasLayout.setVerticalGroup(
            MesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MesasLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Pedidos.setClosable(true);
        Pedidos.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        Pedidos.setMaximizable(true);
        Pedidos.setResizable(true);
        Pedidos.setTitle("Gerenciamento de Pedidos");
        Pedidos.setMinimumSize(new java.awt.Dimension(720, 480));
        Pedidos.setPreferredSize(new java.awt.Dimension(720, 480));
        Pedidos.setVisible(false);

        tablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mesa", "Item", "Qtde.", "Valor", "Status", "Data", "Hora"
            }
        ));
        tablePedidos.setFillsViewportHeight(true);
        jScrollPane4.setViewportView(tablePedidos);

        jToolBar5.setFloatable(false);
        jToolBar5.setRollover(true);

        cadastraPedido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cadastraPedido.setText("Cadastrar");
        cadastraPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cadastraPedido.setFocusable(false);
        cadastraPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cadastraPedido.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(cadastraPedido);

        gap6.setText("  ");
        jToolBar5.add(gap6);

        alteraPedido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        alteraPedido.setText("Alterar");
        alteraPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alteraPedido.setFocusable(false);
        alteraPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alteraPedido.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(alteraPedido);

        gap7.setText("  ");
        jToolBar5.add(gap7);

        excluirPedido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        excluirPedido.setText("Excluir");
        excluirPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        excluirPedido.setFocusable(false);
        excluirPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        excluirPedido.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(excluirPedido);

        gap11.setText("  ");
        jToolBar5.add(gap11);

        atualizaPedidos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        atualizaPedidos.setText("Atualizar");
        atualizaPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atualizaPedidos.setFocusable(false);
        atualizaPedidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        atualizaPedidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(atualizaPedidos);

        javax.swing.GroupLayout PedidosLayout = new javax.swing.GroupLayout(Pedidos.getContentPane());
        Pedidos.getContentPane().setLayout(PedidosLayout);
        PedidosLayout.setHorizontalGroup(
            PedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PedidosLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jToolBar5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        PedidosLayout.setVerticalGroup(
            PedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PedidosLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Desktop.setLayer(Pessoas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Desktop.setLayer(Itens, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Desktop.setLayer(Mesas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Desktop.setLayer(Pedidos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DesktopLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addGroup(DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Pessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Itens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Mesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Pedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(768, Short.MAX_VALUE)))
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DesktopLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(Pessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(26, 26, 26)
                    .addComponent(Pedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(26, 26, 26)
                    .addComponent(Mesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(26, 26, 26)
                    .addComponent(Itens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap(574, Short.MAX_VALUE)))
        );

        try {
            Pessoas.setMaximum(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        try {
            Itens.setMaximum(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        try {
            Mesas.setMaximum(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        try {
            Pedidos.setMaximum(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        Menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N

        menuGerencia.setText("Gerenciar");
        menuGerencia.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        menuPessoa.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        menuPessoa.setText("Pessoa");
        menuPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPessoaActionPerformed(evt);
            }
        });
        menuGerencia.add(menuPessoa);

        menuItem.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        menuItem.setText("Item");
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemActionPerformed(evt);
            }
        });
        menuGerencia.add(menuItem);

        menuPedido.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        menuPedido.setText("Pedido");
        menuPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPedidoActionPerformed(evt);
            }
        });
        menuGerencia.add(menuPedido);

        menuMesa.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        menuMesa.setText("Mesa");
        menuMesa.setToolTipText("");
        menuMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMesaActionPerformed(evt);
            }
        });
        menuGerencia.add(menuMesa);

        Menu.add(menuGerencia);

        menuConta.setText("Conta");
        menuConta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        menuLogout.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        menuLogout.setText("Sair");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        menuConta.add(menuLogout);

        menuTrocaUser.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        menuTrocaUser.setText("Trocar Usuário");
        menuTrocaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTrocaUserActionPerformed(evt);
            }
        });
        menuConta.add(menuTrocaUser);

        Menu.add(menuConta);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPessoaActionPerformed
        fillTablePessoas();
        Pessoas.setVisible(true);
        Pessoas.toFront();
    }//GEN-LAST:event_menuPessoaActionPerformed

    private void menuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemActionPerformed
        fillTableItens();
        Itens.setVisible(true);
        Itens.toFront();
    }//GEN-LAST:event_menuItemActionPerformed

    private void menuPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPedidoActionPerformed
        fillTablePedidos();
        Pedidos.setVisible(true);
        Pedidos.toFront();
    }//GEN-LAST:event_menuPedidoActionPerformed

    private void menuMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMesaActionPerformed
        fillTableMesas();
        Mesas.setVisible(true);
        Mesas.toFront();
    }//GEN-LAST:event_menuMesaActionPerformed

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        this.dispose();
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void menuTrocaUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTrocaUserActionPerformed
        this.dispose();
        Login login = new Login();
        login.setVisible(true);
        try {
            conn.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuTrocaUserActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Login login = new Login();
        login.setVisible(true);
        try {
            conn.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void cadastraPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastraPessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastraPessoaActionPerformed
        
    private void updateTableItens(){
        for(ArrayList<String> arr: tabelaItens){
            conn.comando_sql("UPDATE t_itens "
                        +" SET itm_nome = '"+arr.get(1)+"', itm_descricao = '"+arr.get(2)+"', itm_tipo = '"+arr.get(3)+"'"
                        +", itm_valor = "+arr.get(4)+", itm_status = "+arr.get(5)
                        +" WHERE itm_codigo = "+arr.get(0)+";");
        }
    }
    
    private void updateTablePessoas(){
        for(ArrayList<String> arr: tabelaItens){
            conn.comando_sql("UPDATE t_itens "
                        +" SET itm_nome = '"+arr.get(1)+"', itm_descricao = '"+arr.get(2)+"', itm_tipo = '"+arr.get(3)+"'"
                        +", itm_valor = "+arr.get(4)+", itm_status = "+arr.get(5)
                        +" WHERE itm_codigo = "+arr.get(0)+";");
        }
    }
    
    private void fillTableMesas(){
        modelMesas = (DefaultTableModel) tableMesas.getModel();
        modelMesas.setRowCount(0);
        
        tabelaMesas = conn.retornar_query("SELECT mesa_codigo, mesa_status FROM t_mesas WHERE mesa_status = 0");
        
        tableMesas.setRowSorter(new TableRowSorter(modelMesas));
        
        for(ArrayList<String> ars: tabelaMesas){ 
           modelMesas.addRow(new Object[]{ ars.get(0), ars.get(1)});
        }
    }
    
    private void fillTablePedidos(){
        modelPedidos = (DefaultTableModel) tablePedidos.getModel();
        modelPedidos.setRowCount(0);
        
        tabelaPedidos = conn.retornar_query("SELECT ped_codigo, itm_codigo, mesa_status FROM t_pedidos WHERE mesa_status = 0");
        
        tablePedidos.setRowSorter(new TableRowSorter(modelPedidos));
        
        for(ArrayList<String> ars: tabelaPedidos){ 
           modelPedidos.addRow(new Object[]{ ars.get(0), ars.get(1)});
        }
    }
    
    private void fillTableItens(){
        modelItens = (DefaultTableModel) tableItens.getModel();
        modelItens.setRowCount(0);
        
        //Preenche tabela primitiva
        tabelaItens = conn.retornar_query(
            "SELECT itm_codigo, itm_nome, itm_descricao, itm_tipo, itm_valor, itm_status FROM t_itens;"
        );

        tableItens.setRowSorter(new TableRowSorter(modelItens));
        
        for(ArrayList<String> ars: tabelaItens){ 
            modelItens.addRow(new Object[]{ ars.get(1), ars.get(2), ars.get(3), ars.get(4), ars.get(5) });
        }
    }
    
    private void fillTablePessoas(){
        modelPessoas = (DefaultTableModel) tablePessoas.getModel();
        modelPessoas.setRowCount(0);
        
        //Preenche tabela primitiva
        tabelaPessoas = conn.retornar_query(
            "SELECT pes_codigo, pes_nome, pes_cpf, pes_tipo, pes_login, pes_senha FROM t_pessoas;"
        );

        tablePessoas.setRowSorter(new TableRowSorter(modelPessoas));
        
        for(ArrayList<String> ars: tabelaPessoas){ 
            modelPessoas.addRow(new Object[]{ ars.get(1), ars.get(2), ars.get(3), ars.get(4), ars.get(5) });
        }
    }
    
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
            java.util.logging.Logger.getLogger(Gerencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gerencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gerencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gerencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gerencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JInternalFrame Itens;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JInternalFrame Mesas;
    private javax.swing.JInternalFrame Pedidos;
    private javax.swing.JInternalFrame Pessoas;
    private javax.swing.JButton alteraItem;
    private javax.swing.JButton alteraMesa;
    private javax.swing.JButton alteraPedido;
    private javax.swing.JButton alteraPessoa;
    private javax.swing.JButton atualizaItens;
    private javax.swing.JButton atualizaMesas;
    private javax.swing.JButton atualizaPedidos;
    private javax.swing.JButton atualizaPessoas;
    private javax.swing.JButton cadastraItem;
    private javax.swing.JButton cadastraMesa;
    private javax.swing.JButton cadastraPedido;
    private javax.swing.JButton cadastraPessoa;
    private javax.swing.JButton excluiItem;
    private javax.swing.JButton excluiMesa;
    private javax.swing.JButton excluiPessoa;
    private javax.swing.JButton excluirPedido;
    private javax.swing.JLabel gap;
    private javax.swing.JLabel gap1;
    private javax.swing.JLabel gap10;
    private javax.swing.JLabel gap11;
    private javax.swing.JLabel gap2;
    private javax.swing.JLabel gap3;
    private javax.swing.JLabel gap4;
    private javax.swing.JLabel gap5;
    private javax.swing.JLabel gap6;
    private javax.swing.JLabel gap7;
    private javax.swing.JLabel gap8;
    private javax.swing.JLabel gap9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JMenu menuConta;
    private javax.swing.JMenu menuGerencia;
    private javax.swing.JMenuItem menuItem;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenuItem menuMesa;
    private javax.swing.JMenuItem menuPedido;
    private javax.swing.JMenuItem menuPessoa;
    private javax.swing.JMenuItem menuTrocaUser;
    private javax.swing.JTable tableItens;
    private javax.swing.JTable tableMesas;
    private javax.swing.JTable tablePedidos;
    private javax.swing.JTable tablePessoas;
    // End of variables declaration//GEN-END:variables
}
