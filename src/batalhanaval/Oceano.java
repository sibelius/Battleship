package batalhanaval;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Classe Oceano - Tabuleiro do jogo BatalhaNaval
 *
 * @version 1.0
 * @author Sibelius Seraphini (Feitiço)
 * @author Fernando Sergent Maia (Violeta)
 */
public class Oceano  extends  JPanel implements MouseListener, MouseMotionListener {

    /**
     * Pai do componente Oceano
     */
    private BatalhaNavalFrame pai;

    /**
     * <code>ArrayList</code> frota que contém todos os <code>Navio</code>
     * do Oceano
     */
    private ArrayList<Navio> frota = new ArrayList<Navio>();

    /**
     * Representa o <code>Jogador</code> dono do Oceano
     */
    private Jogador jog;

    /**
     * <code>Navio</code> temporário usado para o sombreamento e inserção de
     * novos navios no Oceano
     */
    private Navio n=null;

    /**
     * Vetor que representa o estado de cada célula do Oceano
     */
    private int tab[][] = new int[10][10];

    /**
     * Variável que indica o estado de visibilidade do Oceano
     */
    private boolean mostrar;

    /**
     * Constroi um oceano com pai e com <code>Jogador</code> dono dele
     * @param pai - <code>BatalhaNavalFrame</code> pai do Oceano
     * @param jog - <code>Jogador</code> dono do Oceano
     */
    public Oceano(BatalhaNavalFrame pai, Jogador jog) {
        this.pai = pai;
        this.jog = jog;

        setPreferredSize(new Dimension(405, 405));
        addMouseListener(this);
        addMouseMotionListener(this);

        Mostrar();

        if(jog.equals(Jogador.HUMAN))
           mostrar = true;
        else
           mostrar = false;

        Disponivel();
    }

    /**
     * Muda o estado de visibilidade do Oceano para visível
     */
    public void Mostrar() {
        mostrar = true;

        repaint();
    }

    /**
     * Muda o estado de visibilidade do Oceano para invisível
     */
    public void Esconder() {
        mostrar = false;

        repaint();
    }

    /**
     * Torna todas células do Oceano disponíveis
     */
    public void Disponivel() {
        //Deixa todas as posições disponiveis
        for(int i=0; i<10; i++)
           for(int j=0; j<10; j++)
               tab[i][j] = 0;
    }

    /**
     * Verifica se uma posição do Oceano se encontra disponível e em caso
     * afirmativo marca a posição e muda o turno, se atingiu o
     * <code>Navio</code> decrementa o tamanho atual do <code>Navio</code>, se
     * destruiu o <code>Navio</code> remove-o da frota, se não houver mais
     * navios na frota e muda o <code>Estado</code> para Fim_de_Jogo
     * @param pos - Posição a ser marcada
     * @return true caso o <code>Point</code> tenha sido marcado
     *         false caso o <code>Point</code> não tenha sido marcado
     */
    public boolean Marcar(Point pos) {
        //Verifica se o ponto está disponivel
        if(tab[(int)pos.getX()][(int)pos.getY()] == 0) {
           Navio n1 = Colidiu(pos);

           if(n1 != null) { //Acertou o navio
               //Cor do navio
               tab[(int)pos.getX()][(int)pos.getY()] = 2;

               n1.setTamAtual(n1.getTamAtual()-1);

               if(n1.getTamAtual() == 0) {
                  frota.remove(n1);

                  if(frota.size() == 0) {
                     pai.setEstado(BatalhaNavalFrame.Estado.Fim_de_Jogo);
                  }   
               }

               pai.setTurno(pai.getTurno());
           } else {
               //Cor de mar
               tab[(int)pos.getX()][(int)pos.getY()] = 1;
               
               //Troca o turno
               pai.TrocaTurno();
           }

           repaint();

           return true;
       }

       return false;
    }

    /**
     * Retorna a frota de <code>Navio</code> no Oceano
     * @return Um <code>ArrayList<Navio></code> que representa a frota
     */
    public ArrayList<Navio> getFrota() {
        return frota;
    }

    /**
     * Adiciona um <code>Navio</code> à frota, caso a frota tenha quatro
     * <code>Navio</code> muda o <code>Estado</code> do jogo para Jogando
     * @param n1 - <code>Navio</code> a ser adicionado à frota
     * @return true caso o <code>Navio</code> tenha sido adicionado
     *         false caso o <code>Navio</code> não tenha sido adicionado
     */
    public boolean addNavio(Navio n1) {
        if(Colidiu(n1) == null) {
            frota.add(n1);

            if(jog.equals(Jogador.HUMAN)) {
                if(frota.size() == 4) {
                   pai.setEstado(BatalhaNavalFrame.Estado.Jogando);
                   return false;
                }
            }
            
            repaint();

            return true;
        }

        return false;
    }

    /**
     * Define um <code>Navio</code> temporário
     * @param n - <code>Navio</code> temporário utilizado para o sombreamento
     * e inserção na frota
     */
    public void setNavio(Navio n) {
        this.n = n;
        n.setPos(new Point(-1, -1));
    }

    /**
     * Verifica se um ponto pertence a algum dos navios da frota
     * @param p - <code>Point</code> a ser testado
     * @return <code>Navio</code> que contém o ponto
     */
    public Navio Colidiu(Point p) {
        for(Navio n1:frota) {
            if(n1.Contem(p))
                return n1;
        }

        return null;
    }

    /**
     * Verifica se um navio colide com algum dos navios da frota
     * @param nav - <code>Navio</code> a ser testado
     * @return <code>Navio</code> que colide com o <code>Navio</code> passado
     */
    public Navio Colidiu(Navio nav) {
        for(Navio n1:frota) {
            if(n1.Colidiu(nav))
                return n1;
        }

        return null;
    }

    /**
     * Método usado para desenhar o Oceano e seus <code>Navio</code>
     * @param g - <code>Graphics</code> usado nas funções gráficas
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //Light Blue
        //g2d.setPaint(new Color(173, 216, 230));

        g2d.setPaint(new GradientPaint(200, 0, new Color(50,50,255), 200, 300, new Color(0,0,200)));

        g2d.fill(new Rectangle(0, 0, 400, 400));

        //g2d.clearRect(0, 0, 400, 400);

        g2d.setPaint(Color.white);
        //Desenha a grade
        for (int i = 0; i <= 10; i++) {
           g2d.draw(new Line2D.Float(i*40, 0, i*40, 400));
           g2d.draw(new Line2D.Float(0, i*40, 400, i*40));
        }

        if(mostrar) {
            //Desenha os navios
            for(Navio aux: frota) {
                aux.desenhar(g2d);
            }
        }


        g2d.setPaint(new GradientPaint(200, 0, new Color(50,50,255), 200, 300, new Color(0,0,200)));

        for(int i=0; i<10; i++)
           for(int j=0; j<10; j++) {
               if(tab[i][j] == 1)
                   g2d.setPaint(Color.darkGray);
               else if(tab[i][j] == 2)
                   g2d.setPaint(new Color(255, 120, 0));
               else //0 - não desenha
                   continue;

               g2d.fill(new Rectangle(i*40 + 1,j*40+1, 39,39));
           }

        if(n != null) {
            if(n.getPos().getX() != -1) {
                if(Colidiu(n) != null)
                    g2d.setPaint(Color.darkGray);
                else
                    g2d.setPaint(Color.white);

                for(int i=0; i<n.getTamanho(); i++) {
                    if(n.getDirecao() == Navio.Direcao.Esquerda_Direita)
                       g2d.fill(new Rectangle((int) n.getPos().getX()*40 + i*40+1,
                                              (int) n.getPos().getY()*40+1, 39,39));
                    else
                       g2d.fill(new Rectangle((int) n.getPos().getX()*40 + 1,
                                              (int) n.getPos().getY()*40 + i*40+1,39,39));
                }
            }
        }
    }

    /**
     * Trata os cliques do mouse
     * @param e - <code>MouseEvent</code> que contém informações sobre o
     * clique
     */
    public void mouseClicked(MouseEvent e) {
        if(pai.getEstado() == BatalhaNavalFrame.Estado.Inserindo) {
            if(jog.equals(Jogador.CPU))
               return;

            if(n == null)
               return;

            if(Colidiu(n) != null)
                return;

            //Botão esquerdo
            if(e.getButton() == MouseEvent.BUTTON1) {

                addNavio(n);

                n = null;

                repaint();
            } else { //Botão esquerdo
                //Troca a direção
                if(n.getDirecao() == Navio.Direcao.Esquerda_Direita) {
                    n.setDirecao(Navio.Direcao.Cima_Baixo);
                } else {
                    n.setDirecao(Navio.Direcao.Esquerda_Direita);
                }
            }
        } else { //Jogando
            if( (jog.equals(Jogador.HUMAN)) || (pai.getTurno() != Jogador.HUMAN) )
                return;

            Point pos = new Point(e.getX() / 40, e.getY() / 40);

            Marcar(pos);
       }
   }

    /**
     * Trata os pressionamentos do mouse
     * @param e - <code>MouseEvent</code> que contém informações sobre o
     * pressionamento
     */
    public void mousePressed(MouseEvent e) {
    }

    /**
     * Trata os despressionamentos do mouse
     * @param e - <code>MouseEvent</code> que contém informações sobre o
     * despressionamento
     */
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Trata a entrada do mouse no Oceano
     * @param e - <code>MouseEvent</code> que contém informações sobre a
     * entrada
     */
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * Trata a saída do mouse no Oceano
     * @param e - <code>MouseEvent</code> que contém informações sobre a
     * saída
     */
    public void mouseExited(MouseEvent e) {
        if(n == null)
            return;
        
         n.setPos(new Point(-1,-1)) ;

         repaint();
    }

    /**
     * Trata a movimentação do mouse dentro do Oceano
     * @param e - <code>MouseEvent</code> que contém informações sobre a
     * movimentação
     */
    public void mouseMoved(MouseEvent e) {
        if(pai.getEstado() == BatalhaNavalFrame.Estado.Jogando)
            return;

        if(n==null)
           return;

        n.setPos(new Point((int)e.getX() / 40, (int) e.getY() / 40));

        if(n.getDirecao() == Navio.Direcao.Esquerda_Direita) {
            if( (n.getPos().getX() + n.getTamanho() > 10) || (n.getPos().getY() >= 10))
                n.setPos(new Point(-1,-1)) ;
        } else {
            if( (n.getPos().getY() + n.getTamanho() > 10) || (n.getPos().getX() >= 10) )
                n.setPos(new Point(-1,-1)) ;
        }
        
        repaint();
    }

    /**
     * Trata o arrastamento de objetos pelo Oceano
     * @param e - <code>MouseEvent</code> que contém informações sobre o
     * arrastamento
     */
    public void mouseDragged(MouseEvent e) {
    }
}
