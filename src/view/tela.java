package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.BorderLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class tela extends JFrame {
			JFrame Janela = new JFrame();
			JScrollPane scroll = new JScrollPane();
			JMenuBar menuBar = new JMenuBar();
			JMenu mnArquivo = new JMenu("Arquivo");
			JMenuItem preferenciasAction = new JMenuItem("Preferencias"), 
					  sairAction = new JMenuItem("Sair"),
					  novoAction = new JMenuItem("Novo");
			private final JPanel panel = new JPanel();
			private final JLabel lblintro = new JLabel("Programa desenvolvido para efetuar o cálculo de palhetas de cores através do uso de algoritmos genéticos.");
			private final JButton btnNewButton_1 = new JButton("Calcular");
			private final JPanel cor1 = new JPanel();
			private final JPanel cor2 = new JPanel();
			private final JPanel cor3 = new JPanel();
			private final JPanel cor4 = new JPanel();
			private final JPanel cor5 = new JPanel();
			private final JPanel cor6 = new JPanel();
			private final JPanel cor7 = new JPanel();
			private final JPanel cor8 = new JPanel();
			private final JPanel cor9 = new JPanel();
				
	public tela() {
				super("Gerador de Palheta de cores");
				cor1.setBackground(Color.WHITE);
				cor2.setBackground(Color.WHITE);
				cor3.setBackground(Color.WHITE);
				cor4.setBackground(Color.WHITE);
				cor5.setBackground(Color.WHITE);
				cor6.setBackground(Color.WHITE);
				cor7.setBackground(Color.WHITE);
				cor8.setBackground(Color.WHITE);
				cor9.setBackground(Color.WHITE);
				menuprincipal();
				adicionatela();
				Janela.setMinimumSize(new Dimension(800, 600));
				Janela.setMaximumSize(new Dimension(800, 600));
				Janela.setResizable(false);
				Janela.setTitle("Gerador de Palheta de cores");
				Janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				Janela.pack();
				Janela.setVisible(true);
				Janela.setJMenuBar(menuBar);
				
				menuBar.add(panel);
				
				JPanel panel_1 = new JPanel();
				
				JPanel panel_2 = new JPanel();
				panel_2.setBackground(Color.WHITE);
				
				JButton btnNewButton = new JButton("Selecione");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				GroupLayout groupLayout = new GroupLayout(Janela.getContentPane());
				groupLayout.setHorizontalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(357)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
								.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
							.addGap(408))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(cor1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cor2, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cor3, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cor4, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cor5, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cor6, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cor7, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cor8, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cor9, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(34, Short.MAX_VALUE))
				);
				groupLayout.setVerticalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)
							.addGap(92)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(cor1, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
								.addComponent(cor2, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
								.addComponent(cor3, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
								.addComponent(cor4, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
								.addComponent(cor5, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
								.addComponent(cor6, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
								.addComponent(cor7, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
								.addComponent(cor8, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
								.addComponent(cor9, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
				);
				
				panel_1.add(lblintro);
				Janela.getContentPane().setLayout(groupLayout);
				
			}
			
	private void menuArquivo(){
		menuBar.add(mnArquivo);
		addmenu(novoAction,mnArquivo);
		addmenu(preferenciasAction,mnArquivo);
		addmenu(sairAction,mnArquivo);
		
		sairAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	System.exit(0);
            }
        });
	}
			
	private void menuprincipal(){
		menuArquivo();
	}
			
	private void adicionatela(){
	}
			
	private void addmenu(JMenuItem filho, JMenu pai){
		pai.add(filho);
	}
}
