package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Principal;

import javax.swing.*;
import java.awt.BorderLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ComponentOrientation;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.border.LineBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class tela extends JFrame {
	JFrame Janela = new JFrame();
	JScrollPane scroll = new JScrollPane();
	JMenuBar menuBar = new JMenuBar();
	JMenu mnArquivo = new JMenu("Arquivo");
	JMenuItem sobreAction = new JMenuItem("Sobre"), 
			  sairAction = new JMenuItem("Sair"),
			  novoAction = new JMenuItem("Novo");
	JDialog janelaSobre = new JDialog();
	JButton btncalcular = new JButton("Calcular");
	public static JPanel [] coresSolucao;
	private final JPanel panelProgresso = new JPanel();
	private final JPanel panelcor1,panelcor2,panelcor3,panelcor4,panelcor5;
	private Color color = Color.LIGHT_GRAY;
	private JPanel colorJPanel;
    public static JTextField tfStatus;
    private JTextField tfCaracteres;
    private JTextField tfMutacao;
    private JTextField tfTamPop;
    private JTextField tfNumGer;
    private JTextField tfCrossover;
    JCheckBox cbElitismo = new JCheckBox("");
    private JTextField textField;
			
	public tela() {
		super("Gerador de Palheta de cores");
		panelProgresso.setBounds(1059, 302, 130, 94);
		panelProgresso.setBackground(Color.WHITE);
		coresSolucao = new JPanel[5];
		sobre();
		menuPrincipal();
		adicionaTela();
		Janela.setMinimumSize(new Dimension(800,600));
		Janela.setMaximumSize(new Dimension(800,600));
		Janela.setResizable(false);
		Janela.setTitle("Gerador de Palheta de cores");
		Janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		Janela.pack();
		Janela.setVisible(true);
		Janela.setJMenuBar(menuBar);
				
		panelcor1 = new JPanel();
		panelcor1.setBackground(Color.WHITE);
		panelcor1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelcor1.setBounds(35, 20, 130, 50);
		
		
		panelcor2 = new JPanel();
		panelcor2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelcor2.setBackground(Color.WHITE);
		panelcor2.setBounds(185, 20, 130, 50);
		JButton btncor2 = new JButton("Selecione");
		btncor2.setBounds(185, 77, 130, 23);
		btncor2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selecionaCor(panelcor2);
			}
		});
		panelcor3 = new JPanel();
		panelcor3.setBackground(Color.WHITE);
		panelcor3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelcor3.setBounds(335, 20, 130, 50);
		JButton btncor3 = new JButton("Selecione");
		btncor3.setBounds(335, 77, 130, 23);
		btncor3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selecionaCor(panelcor3);
			}
		});
		panelcor4 = new JPanel();
		panelcor4.setBackground(Color.WHITE);
		panelcor4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelcor4.setBounds(485, 20, 130, 50);
		JButton btncor4 = new JButton("Selecione");
		btncor4.setBounds(485, 77, 130, 23);
		btncor4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selecionaCor(panelcor4);
			}
		});
		panelcor5 = new JPanel();
		panelcor5.setBackground(Color.WHITE);
		panelcor5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelcor5.setBounds(635,20, 130, 50);;
		JButton btncor5 = new JButton("Selecione");
		btncor5.setBounds(635, 77, 130, 23);
		btncor5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selecionaCor(panelcor5);
			}
		});
		Janela.getContentPane().setLayout(null);
		Janela.getContentPane().add(panelProgresso);
		Janela.getContentPane().add(panelcor1);
		Janela.getContentPane().add(panelcor2);
		Janela.getContentPane().add(panelcor3);
		Janela.getContentPane().add(panelcor4);
		Janela.getContentPane().add(panelcor5);
				
		JButton btncor1 = new JButton("Selecione");
		btncor1.setBounds(35, 77, 130, 23);
		btncor1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selecionaCor(panelcor1);
			}
		});
		Janela.getContentPane().add(btncor1);
		Janela.getContentPane().add(btncor2);
		Janela.getContentPane().add(btncor3);
		Janela.getContentPane().add(btncor4);
		Janela.getContentPane().add(btncor5);
		
		btncalcular.setBounds(35, 235, 730, 35);
		Janela.getContentPane().add(btncalcular);
		
		JPanel panelresult1 = new JPanel();
		panelresult1.setBackground(Color.WHITE);
		panelresult1.setBounds(35, 323, 130, 218);
		Janela.getContentPane().add(panelresult1);
		coresSolucao[0] = panelresult1;
		
		JPanel panelresult2 = new JPanel();
		panelresult2.setBackground(Color.WHITE);
		panelresult2.setBounds(185, 323, 130, 218);
		Janela.getContentPane().add(panelresult2);
		coresSolucao[1] = panelresult2;
		
		JPanel panelresult3 = new JPanel();
		panelresult3.setBackground(Color.WHITE);
		panelresult3.setBounds(335, 323, 130, 218);
		Janela.getContentPane().add(panelresult3);
		coresSolucao[2] = panelresult3;
		
		JPanel panelresult4 = new JPanel();
		panelresult4.setBackground(Color.WHITE);
		panelresult4.setBounds(485, 323, 130, 218);
		Janela.getContentPane().add(panelresult4);
		coresSolucao[3] = panelresult4;
		
		
		JPanel panelresult5 = new JPanel();
		panelresult5.setBackground(Color.WHITE);
		panelresult5.setBounds(635, 323, 130, 218);
		Janela.getContentPane().add(panelresult5);
		coresSolucao[4] = panelresult5;
		
		tfStatus = new JTextField();
		tfStatus.setHorizontalAlignment(SwingConstants.CENTER);
		tfStatus.setEditable(false);
		tfStatus.setBounds(35, 281, 730, 20);
		Janela.getContentPane().add(tfStatus);
		tfStatus.setColumns(10);
				
		tfCaracteres = new JTextField();
		tfCaracteres.setText("01");
		tfCaracteres.setBounds(199, 129, 90, 20);
		Janela.getContentPane().add(tfCaracteres);
		tfCaracteres.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("String caracteres");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(70, 129, 117, 20);
		Janela.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Crossover");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(126, 159, 65, 20);
		Janela.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Muta\u00E7\u00E3o");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(136, 189, 51, 20);
		Janela.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Tamanho popula\u00E7\u00E3o");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(320, 129, 108, 20);
		Janela.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("N\u00FAmeros gera\u00E7\u00F5es");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(320, 159, 108, 20);
		Janela.getContentPane().add(lblNewLabel_5);
		
		tfMutacao = new JTextField();
		tfMutacao.setText("0.6");
		tfMutacao.setBounds(199, 189, 90, 20);
		Janela.getContentPane().add(tfMutacao);
		tfMutacao.setColumns(10);
		
		tfTamPop = new JTextField();
		tfTamPop.setText("2000");
		tfTamPop.setBounds(438, 129, 90, 20);
		Janela.getContentPane().add(tfTamPop);
		tfTamPop.setColumns(10);
		
		tfNumGer = new JTextField();
		tfNumGer.setText("1000");
		tfNumGer.setBounds(438, 159, 90, 20);
		Janela.getContentPane().add(tfNumGer);
		tfNumGer.setColumns(10);
		
		
		cbElitismo.setSelected(true);
		cbElitismo.setBounds(624, 189, 97, 23);
		Janela.getContentPane().add(cbElitismo);
		
		JLabel lblElitismo = new JLabel("Elitismo");
		lblElitismo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblElitismo.setBounds(555, 189, 54, 20);
		Janela.getContentPane().add(lblElitismo);
		
		tfCrossover = new JTextField();
		tfCrossover.setText("0.99");
		tfCrossover.setBounds(199, 159, 86, 20);
		Janela.getContentPane().add(tfCrossover);
		tfCrossover.setColumns(10);
		
		JButton btnSugestao = new JButton("Sugerir cores");
		btnSugestao.setBounds(635, 110, 130, 29);
		Janela.getContentPane().add(btnSugestao);
		
		textField = new JTextField();
		textField.setBounds(438, 189, 90, 20);
		Janela.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblVelocidadeExibio = new JLabel("Velocidade exibi\u00E7\u00E3o");
		lblVelocidadeExibio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVelocidadeExibio.setBounds(299, 192, 129, 14);
		Janela.getContentPane().add(lblVelocidadeExibio);
		
		
		
		btncalcular.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
               calcular();
              }
          });
		
		btnSugestao.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
               sugestao();
              }
          });
		Janela.repaint();
	}
			
	
	private void calcular() {
				
				
		main.Principal p = new main.Principal();
		Color[] solucao = pegaCoresObjetivo();
			
				
		Thread t1 = new Thread(new Runnable() {
		    public void run()
		    {
		    	Color[] result = p.execucao(solucao, tfCaracteres.getText(), Double.parseDouble(tfCrossover.getText()),
		    	Double.parseDouble(tfMutacao.getText()), cbElitismo.isSelected(),  Integer.parseInt(tfTamPop.getText()),  Integer.parseInt(tfNumGer.getText()));
		    }});  
		    t1.start();
	}
			
	
	public Color[] pegaCoresObjetivo () {
	
		Color [] cores = new Color[5];
		cores[0] = panelcor1.getBackground(); 
		cores[1] = panelcor2.getBackground();
		cores[2] = panelcor3.getBackground();
		cores[3] = panelcor4.getBackground();
		cores[4] = panelcor5.getBackground();

		return cores;
	}
	
	public void setaCoresSolucao(Color[] solucao) {
		
		for (int i =0; i< 5; i++) {
			coresSolucao[i].setBackground(solucao[i]);
		}
	}
	
	
	private void sobre() {
		JPanel messagePane = new JPanel();
		 

		JLabel texto = new JLabel("<html><body>  Programa desenvolvido para efetuar  o cálculo  de palhetas <br> de cores através do uso de algoritmos genéticos<br><br> Desenvolvido por: <br> Gustavo Pistore <br> Leonardo Gobi <br> Guilherme Masiero </body></html>");
		 
		// \b \f \n \r \t
		//JLabel texto = new JLabel("Programa \n\n desenvolvido para ");
        messagePane.add(texto);
        janelaSobre.getContentPane().add(messagePane);
        janelaSobre.setTitle("Sobre");
        Dimension d = new Dimension();
        d.setSize(400, 200);
        janelaSobre.setMinimumSize(d);
	}
	
	private void menuArquivo(){
		menuBar.add(mnArquivo);
		addmenu(novoAction,mnArquivo);
		addmenu(sobreAction,mnArquivo);
		addmenu(sairAction,mnArquivo);
		
		sairAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	System.exit(0);
            	
            }
        });
		
		sobreAction.addActionListener(new ActionListener() {
         
			public void actionPerformed(ActionEvent arg0) {
				janelaSobre.setVisible(true);            	
	        }
        });
		
	}
			
	private void menuPrincipal(){
		menuArquivo();
	}
	
	private void sugestao() {
		panelcor1.setBackground(Color.BLUE);
		panelcor2.setBackground(Color.RED);
		panelcor3.setBackground(Color.YELLOW);
		panelcor4.setBackground(Color.WHITE);
		panelcor5.setBackground(Color.GREEN);
		
	}
	private void adicionaTela(){
	}
			
	private void addmenu(JMenuItem filho, JMenu pai){
		pai.add(filho);
	}
	
	private void selecionaCor(JPanel painel) {
		JColorChooser seletor = new JColorChooser(painel.getBackground());
        AbstractColorChooserPanel[] panels = seletor.getChooserPanels();
        for (AbstractColorChooserPanel accp : panels) {
            if (accp.getDisplayName().equals("RGB")) {
                JOptionPane.showMessageDialog(painel, accp);
            }
        }
        painel.setBackground(seletor.getColor());
	}
	
	public void setaCorProgresso(int cor) {
		
		this.panelProgresso.setBackground(new Color(cor));
		this.panelProgresso.repaint();
	}
}
