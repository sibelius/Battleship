package batalhanaval;

import java.awt.Point;
import java.util.Random;

/**
 * Classe BatalhaNavalFrame - Janela do jogo BatalhaNaval
 *
 * @version 1.0
 * @author Sibelius Seraphini (Feitiço)
 * @author Fernando Sergent Maia (Violeta)
 */
public class BatalhaNavalFrame extends javax.swing.JFrame {

    /**
     * Representa o <code>Oceano</code> do <code>Jogador</code> Humano
     */
    private Oceano oceanHuman;

    /**
     * Representa o <code>Oceano</code> do <code>Jogador</code> CPU
     */
    private Oceano oceanCpu;

    /**
     * Representa os possíveis estados do jogo
     */
    public enum Estado {
        /**
         * Representa o estado Inserindo
         */
        Inserindo,
        /**
         * Representa o estado Jogando
         */
        Jogando,
        /**
         * Representa o estado Fim_de_Jogo
         */
        Fim_de_Jogo
    };

    /**
     * Representa o <code>Estado</code> atual do jogo
     */
    private Estado estado = Estado.Inserindo;

    /**
     * Representa o <code>Jogador</code> do turno
     */
    private Jogador turno;

    /**
     * Constroi a janela do jogo BatalhaNaval
     */
    public BatalhaNavalFrame() {
        initComponents();

        oceanHuman = (Oceano)ocean;
        oceanCpu = (Oceano) ocean1;

        PanelJogando.setVisible(false);
    }

    /**
     * Posiciona os navios do <code>Jogador</code> CPU randomicamente
     */
    public void PosiciarNaviosCpu() {
        Navio nCpu;

        //Galeão
        nCpu = new Galeao();
        AddNavioRandom(nCpu);
        //Cruzador
        nCpu = new Cruzador();
        AddNavioRandom(nCpu);

        //Torpedeiro
        nCpu = new Torpedeiro();
        AddNavioRandom(nCpu);
        
        //Porta-Avião
        nCpu = new PortaAviao();
        AddNavioRandom(nCpu);
    }

    /**
     * Randomiza e adiciona navios do <code>Jogador</code> CPU ao
     * <code>Oceano</code>
     * @param n
     */
    public void AddNavioRandom(Navio n) {
        Random rm = new Random();

        do {
           //Gera a direção
           if(rm.nextInt(2) == 0)
               n.setDirecao(Navio.Direcao.Cima_Baixo);
           else
               n.setDirecao(Navio.Direcao.Esquerda_Direita);

           //Gera a posição
           if(n.getDirecao() == Navio.Direcao.Cima_Baixo)
               n.setPos(new Point((int)rm.nextInt(10),(int)rm.nextInt(10-n.getTamanho())));
           else
               n.setPos(new Point((int)rm.nextInt(10-n.getTamanho()),(int)rm.nextInt(10)));

        } while(!oceanCpu.addNavio(n));
    }

    /**
     * Executa uma jogada para o <code>Jogador</code> CPU
     */
    public void CpuJogar() {
        Point pos = new Point();
        Random r = new Random();
        
      
        do {
            pos.setLocation(r.nextInt(10), r.nextInt(10));

            System.out.println(pos.toString());
        } while(!oceanHuman.Marcar(pos));

        //System.out.println("cpu jogou");
    }

    /**
     * Define um novo <code>Estado</code> atual do jogo, realizando as devidas
     * modificações
     * @param estado
     */
    public void setEstado(Estado estado) {
        this.estado = estado;

        if(this.estado.equals(Estado.Jogando)) {
            PosiciarNaviosCpu();
            
            setTurno(Jogador.HUMAN);
            
            PanelInserir.setVisible(false);
            PanelJogando.setVisible(true);

            // TODO - Mudar o Painel para turno atual e numero de navios
        } else if(this.estado.equals(Estado.Fim_de_Jogo)) {
            System.out.println("fim");

            PanelInserir.setVisible(true);
            PanelJogando.setVisible(false);

        }
    }

    /**
     * Retorna o <code>Estado</code> atual do jogo
     * @return <code>Estado</code> atual do jogo
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Define novo <code>Jogador</code> do turno, realizando as devidas
     * modificações
     * @param turno - Novo <code>Jogador</code> do turno
     */
    public void setTurno(Jogador turno) {
        this.turno = turno;

        lblTurno.setText(turno.toString());
        lblNaviosHuman.setText(Integer.toString(oceanHuman.getFrota().size()));
        lblNaviosCpu.setText(Integer.toString(oceanCpu.getFrota().size()));

        if(this.turno.equals(Jogador.CPU))
            CpuJogar();
    }

    /**
     * Retorna o <code>Jogador</code> do turno
     * @return <code>Jogador</code> do turno
     */
    public Jogador getTurno() {
        return turno;
    }

    /**
     * Troca o turno entre os <code>Jogador</code>es
     */
    public void TrocaTurno() {
        if(turno == Jogador.HUMAN)
           setTurno(Jogador.CPU);
        else
           setTurno(Jogador.HUMAN);
    }

    /**
     * Còdigo gerado pelo NetBeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OceanoContainerHuman = new javax.swing.JPanel();
        PanelInserir = new javax.swing.JPanel();
        CruzadorButton = new javax.swing.JButton();
        GaleaoButton = new javax.swing.JButton();
        PortaAviaoButton = new javax.swing.JButton();
        TorpedeiroButton = new javax.swing.JButton();
        ocean = new Oceano(this, Jogador.HUMAN);
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PanelJogando = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        lblNaviosHuman = new javax.swing.JLabel();
        lblNaviosCpu = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        MostrarHumanButton = new javax.swing.JButton();
        EsconderHumanButton = new javax.swing.JButton();
        MostrarCpuButton = new javax.swing.JButton();
        EsconderCpuButton = new javax.swing.JButton();
        OceanoContainerCPU = new javax.swing.JPanel();
        ocean1 = new Oceano(this, Jogador.CPU );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Batalha Naval");
        setName("BatalhaNavalFrame"); // NOI18N
        setResizable(false);

        OceanoContainerHuman.setBorder(javax.swing.BorderFactory.createTitledBorder("Human"));

        PanelInserir.setBorder(javax.swing.BorderFactory.createTitledBorder("Navio"));
        PanelInserir.setPreferredSize(new java.awt.Dimension(160, 347));

        CruzadorButton.setText("Cruzador");
        CruzadorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CruzadorButtonActionPerformed(evt);
            }
        });

        GaleaoButton.setText("Galeao");
        GaleaoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GaleaoButtonActionPerformed(evt);
            }
        });

        PortaAviaoButton.setText("Porta Avião");
        PortaAviaoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PortaAviaoButtonActionPerformed(evt);
            }
        });

        TorpedeiroButton.setText("Torpedeiro");
        TorpedeiroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TorpedeiroButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelInserirLayout = new javax.swing.GroupLayout(PanelInserir);
        PanelInserir.setLayout(PanelInserirLayout);
        PanelInserirLayout.setHorizontalGroup(
            PanelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInserirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GaleaoButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(CruzadorButton, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(TorpedeiroButton, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(PortaAviaoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelInserirLayout.setVerticalGroup(
            PanelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInserirLayout.createSequentialGroup()
                .addComponent(GaleaoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CruzadorButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TorpedeiroButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PortaAviaoButton)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        ocean.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout oceanLayout = new javax.swing.GroupLayout(ocean);
        ocean.setLayout(oceanLayout);
        oceanLayout.setHorizontalGroup(
            oceanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 184, Short.MAX_VALUE)
        );
        oceanLayout.setVerticalGroup(
            oceanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 164, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Navio"));

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(51, 255, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        jLabel1.setText("Galeão");

        jLabel2.setText("Cruzador");

        jLabel3.setText("Torpedeiro");

        jLabel4.setText("Porta Avião");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        PanelJogando.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do Jogo"));

        jLabel5.setText("Turno");

        jLabel6.setText("Nº Navios CPU");

        jLabel7.setText("Nº Navios Human");

        javax.swing.GroupLayout PanelJogandoLayout = new javax.swing.GroupLayout(PanelJogando);
        PanelJogando.setLayout(PanelJogandoLayout);
        PanelJogandoLayout.setHorizontalGroup(
            PanelJogandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelJogandoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelJogandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelJogandoLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(lblNaviosCpu))
                    .addGroup(PanelJogandoLayout.createSequentialGroup()
                        .addGroup(PanelJogandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelJogandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTurno)
                            .addComponent(lblNaviosHuman))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelJogandoLayout.setVerticalGroup(
            PanelJogandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelJogandoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelJogandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblTurno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelJogandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblNaviosHuman))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelJogandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblNaviosCpu))
                .addContainerGap(257, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cheat"));

        MostrarHumanButton.setText("Mostrar Human");
        MostrarHumanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarHumanButtonActionPerformed(evt);
            }
        });

        EsconderHumanButton.setText("Esconder Human");
        EsconderHumanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EsconderHumanButtonActionPerformed(evt);
            }
        });

        MostrarCpuButton.setText("Mostrar CPU");
        MostrarCpuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarCpuButtonActionPerformed(evt);
            }
        });

        EsconderCpuButton.setText("Esconder CPU");
        EsconderCpuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EsconderCpuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(EsconderCpuButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MostrarCpuButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MostrarHumanButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EsconderHumanButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MostrarHumanButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EsconderHumanButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MostrarCpuButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EsconderCpuButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout OceanoContainerHumanLayout = new javax.swing.GroupLayout(OceanoContainerHuman);
        OceanoContainerHuman.setLayout(OceanoContainerHumanLayout);
        OceanoContainerHumanLayout.setHorizontalGroup(
            OceanoContainerHumanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OceanoContainerHumanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelJogando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(OceanoContainerHumanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OceanoContainerHumanLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ocean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        OceanoContainerHumanLayout.setVerticalGroup(
            OceanoContainerHumanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OceanoContainerHumanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OceanoContainerHumanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelJogando, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, OceanoContainerHumanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(OceanoContainerHumanLayout.createSequentialGroup()
                            .addComponent(ocean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11)
                            .addGroup(OceanoContainerHumanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(PanelInserir, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)))
                .addContainerGap())
        );

        OceanoContainerCPU.setBorder(javax.swing.BorderFactory.createTitledBorder("CPU"));

        ocean1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout ocean1Layout = new javax.swing.GroupLayout(ocean1);
        ocean1.setLayout(ocean1Layout);
        ocean1Layout.setHorizontalGroup(
            ocean1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );
        ocean1Layout.setVerticalGroup(
            ocean1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout OceanoContainerCPULayout = new javax.swing.GroupLayout(OceanoContainerCPU);
        OceanoContainerCPU.setLayout(OceanoContainerCPULayout);
        OceanoContainerCPULayout.setHorizontalGroup(
            OceanoContainerCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OceanoContainerCPULayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ocean1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        OceanoContainerCPULayout.setVerticalGroup(
            OceanoContainerCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OceanoContainerCPULayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ocean1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OceanoContainerHuman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OceanoContainerCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OceanoContainerCPU, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OceanoContainerHuman, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método chamado ao clicar no botão do <code>Cruzador</code>
     * @param evt - <code>ActionListener</code> com informações do clique
     */
    private void CruzadorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CruzadorButtonActionPerformed
        oceanHuman.setNavio(new Cruzador());
    }//GEN-LAST:event_CruzadorButtonActionPerformed

    /**
     * Método chamado ao clicar no botão do <code>Galeao</code>
     * @param evt - <code>ActionListener</code> com informações do clique
     */
    private void GaleaoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GaleaoButtonActionPerformed
        oceanHuman.setNavio(new Galeao());
    }//GEN-LAST:event_GaleaoButtonActionPerformed

    /**
     * Método chamado ao clicar no botão do <code>PortaAviao</code>
     * @param evt - <code>ActionListener</code> com informações do clique
     */
    private void PortaAviaoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PortaAviaoButtonActionPerformed
        oceanHuman.setNavio(new PortaAviao());
    }//GEN-LAST:event_PortaAviaoButtonActionPerformed

    /**
     * Método chamado ao clicar no botão do <code>Torpedeiro</code>
     * @param evt - <code>ActionListener</code> com informações do clique
     */
    private void TorpedeiroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TorpedeiroButtonActionPerformed
        oceanHuman.setNavio(new Torpedeiro());
    }//GEN-LAST:event_TorpedeiroButtonActionPerformed

    /**
     * Método chamado ao clicar no botão que mostra o <code>Oceano</code> do
     * <code>Jogador</code> Humano
     * @param evt - <code>ActionListener</code> com informações do clique
     */
    private void MostrarHumanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarHumanButtonActionPerformed
        oceanHuman.Mostrar();
    }//GEN-LAST:event_MostrarHumanButtonActionPerformed

    /**
     * Método chamado ao clicar no botão que esconde o <code>Oceano</code> do
     * <code>Jogador</code> Humano
     * @param evt - <code>ActionListener</code> com informações do clique
     */
    private void EsconderHumanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EsconderHumanButtonActionPerformed
        oceanHuman.Esconder();
    }//GEN-LAST:event_EsconderHumanButtonActionPerformed

    /**
     * Método chamado ao clicar no botão que mostra o <code>Oceano</code> do
     * <code>Jogador</code> CPU
     * @param evt - <code>ActionListener</code> com informações do clique
     */
    private void MostrarCpuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarCpuButtonActionPerformed
        oceanCpu.Mostrar();
    }//GEN-LAST:event_MostrarCpuButtonActionPerformed

    /**
     * Método chamado ao clicar no botão que esconde o <code>Oceano</code> do
     * <code>Jogador</code> CPU
     * @param evt - <code>ActionListener</code> com informações do clique
     */
    private void EsconderCpuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EsconderCpuButtonActionPerformed
        oceanCpu.Esconder();
    }//GEN-LAST:event_EsconderCpuButtonActionPerformed

    /**
     * Função principal responsável por criar a janela do jogo
     * @param args - Parâmetros da linha de comando
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BatalhaNavalFrame().setVisible(true);
            }
        });
    }

    /**
     * Código gerado pelo NetBeans
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CruzadorButton;
    private javax.swing.JButton EsconderCpuButton;
    private javax.swing.JButton EsconderHumanButton;
    private javax.swing.JButton GaleaoButton;
    private javax.swing.JButton MostrarCpuButton;
    private javax.swing.JButton MostrarHumanButton;
    private javax.swing.JPanel OceanoContainerCPU;
    private javax.swing.JPanel OceanoContainerHuman;
    private javax.swing.JPanel PanelInserir;
    private javax.swing.JPanel PanelJogando;
    private javax.swing.JButton PortaAviaoButton;
    private javax.swing.JButton TorpedeiroButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblNaviosCpu;
    private javax.swing.JLabel lblNaviosHuman;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JPanel ocean;
    private javax.swing.JPanel ocean1;
    // End of variables declaration//GEN-END:variables

}