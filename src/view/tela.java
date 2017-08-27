package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			private final JButton btncalcular = new JButton("Calcular");
			private final JPanel [] cores;
			private final JPanel panelProgresso = new JPanel();
			private final JPanel panelcor1,panelcor2,panelcor3,panelcor4,panelcor5;

			
			 private Color color = Color.LIGHT_GRAY;
			    private JPanel colorJPanel;
				
	public tela() {
				super("Gerador de Palheta de cores");
				panelProgresso.setBounds(1059, 302, 130, 94);
				panelProgresso.setBackground(Color.WHITE);

				cores = new JPanel[9];
				
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
				
				btncalcular.setBounds(10, 135, 774, 35);
				Janela.getContentPane().add(btncalcular);
				
				JPanel panelresult = new JPanel();
				panelresult.setBackground(Color.WHITE);
				panelresult.setBounds(10, 179, 774, 360);
				Janela.getContentPane().add(panelresult);
				
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
	
	public void setaCorDegrade(int [] cores) {
		
		
		for (int i =0; i<9; i++) {
			this.cores[i].setBackground(new Color(cores[i]));
			this.cores[i].repaint();
		}
		
	}
	public void setaCorProgresso(int cor) {
		
		this.panelProgresso.setBackground(new Color(cor));
		this.panelProgresso.repaint();
	}
}
