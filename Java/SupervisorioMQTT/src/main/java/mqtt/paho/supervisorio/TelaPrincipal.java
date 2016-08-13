package mqtt.paho.supervisorio;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame implements ActionListener
{
	JButton botaoSair;
	JButton botaoConectarBroker;
	JButton botaoDesconectarBroker;
	JButton botaoLigaSaida1Modulo1;
	JButton botaoLigaSaida2Modulo1;
	JButton botaoLigaSaida3Modulo1;
	JButton botaoDesligaSaida1Modulo1;
	JButton botaoDesligaSaida2Modulo1;
	JButton botaoDesligaSaida3Modulo1;
	JButton botaoLigaSaida1Modulo2;
	JButton botaoLigaSaida2Modulo2;
	JButton botaoLigaSaida3Modulo2;
	JButton botaoDesligaSaida1Modulo2;
	JButton botaoDesligaSaida2Modulo2;
	JButton botaoDesligaSaida3Modulo2;
	JLabel  labelModulo1;
	JLabel  labelModulo2;
	static JLabel  statusEntradasModulo1;
	static JLabel  statusEntradasModulo2;
	
	public TelaPrincipal()
	{
		//desenho da tela
		setTitle(".:: Supervisório MQTT - FATEA 2016 ::.");
		setBounds(200,150,500,500);
		botaoSair = new JButton("Encerrar");
		botaoSair.setSize(100,25);
		botaoSair.setLocation(200,400);
		botaoSair.setFont(new Font("ScriptS",Font.ITALIC,12));
		botaoSair.setEnabled(true);
		botaoSair.addActionListener(this);
		
		botaoConectarBroker = new JButton("Conecta ao Broker");
		botaoConectarBroker.setSize(200,25);
		botaoConectarBroker.setLocation(50,50);
		botaoConectarBroker.setFont(new Font("ScriptS",Font.ITALIC,12));
		botaoConectarBroker.setEnabled(true);
		botaoConectarBroker.addActionListener(this);
		
		botaoDesconectarBroker = new JButton("Desconecta do Broker");
		botaoDesconectarBroker.setSize(210,25);
		botaoDesconectarBroker.setLocation(250,50);
		botaoDesconectarBroker.setFont(new Font("ScriptS",Font.ITALIC,12));
		botaoDesconectarBroker.setEnabled(true);
		botaoDesconectarBroker.addActionListener(this);
		
		labelModulo1 = new JLabel("Módulo 1");
		labelModulo1.setForeground(Color.BLUE);
		labelModulo1.setEnabled(true);
		
		botaoLigaSaida1Modulo1 = new JButton("Saída 1 - liga");
		botaoLigaSaida1Modulo1.setSize(200,25);
		botaoLigaSaida1Modulo1.setFont(new Font("ScriptS",Font.ITALIC,12));
		botaoLigaSaida1Modulo1.setEnabled(true);
		botaoLigaSaida1Modulo1.addActionListener(this);
		
		botaoDesligaSaida1Modulo1 = new JButton("Saída 1 - desliga");
		botaoDesligaSaida1Modulo1.setSize(210,25);
		botaoDesligaSaida1Modulo1.setFont(new Font("ScriptS",Font.ITALIC,12));
		botaoDesligaSaida1Modulo1.setEnabled(true);
		botaoDesligaSaida1Modulo1.addActionListener(this);
		
		botaoLigaSaida2Modulo1 = new JButton("Saída 2 - liga");
		botaoLigaSaida2Modulo1.setSize(200,25);
		botaoLigaSaida2Modulo1.setFont(new Font("ScriptS",Font.ITALIC,12));
		botaoLigaSaida2Modulo1.setEnabled(true);
		botaoLigaSaida2Modulo1.addActionListener(this);
		
		botaoDesligaSaida2Modulo1 = new JButton("Saída 2 - desliga");
		botaoDesligaSaida2Modulo1.setSize(210,25);
		botaoDesligaSaida2Modulo1.setFont(new Font("ScriptS",Font.ITALIC,12));
		botaoDesligaSaida2Modulo1.setEnabled(true);
		botaoDesligaSaida2Modulo1.addActionListener(this);
		
		botaoLigaSaida3Modulo1 = new JButton("Saída 3 - liga");
		botaoLigaSaida3Modulo1.setSize(200,25);
		botaoLigaSaida3Modulo1.setFont(new Font("ScriptS",Font.ITALIC,12));
		botaoLigaSaida3Modulo1.setEnabled(true);
		botaoLigaSaida3Modulo1.addActionListener(this);
		
		botaoDesligaSaida3Modulo1 = new JButton("Saída 3 - desliga");
		botaoDesligaSaida3Modulo1.setSize(210,25);
		botaoDesligaSaida3Modulo1.setFont(new Font("ScriptS",Font.ITALIC,12));
		botaoDesligaSaida3Modulo1.setEnabled(true);
		botaoDesligaSaida3Modulo1.addActionListener(this);
		
		labelModulo2 = new JLabel("Módulo 2");
		labelModulo2.setForeground(Color.BLUE);
		labelModulo2.setEnabled(true);
		
		botaoLigaSaida1Modulo2 = new JButton("Saída 1 - liga");
		botaoLigaSaida1Modulo2.setSize(200,25);
		botaoLigaSaida1Modulo2.setFont(new Font("ScriptS",Font.ITALIC,12));
		botaoLigaSaida1Modulo2.setEnabled(true);
		botaoLigaSaida1Modulo2.addActionListener(this);
		
		botaoDesligaSaida1Modulo2 = new JButton("Saída 1 - desliga");
		botaoDesligaSaida1Modulo2.setSize(210,25);
		botaoDesligaSaida1Modulo2.setFont(new Font("ScriptS",Font.ITALIC,12));
		botaoDesligaSaida1Modulo2.setEnabled(true);
		botaoDesligaSaida1Modulo2.addActionListener(this);
		
		botaoLigaSaida2Modulo2 = new JButton("Saída 2 - liga");
		botaoLigaSaida2Modulo2.setSize(200,25);
		botaoLigaSaida2Modulo2.setFont(new Font("ScriptS",Font.ITALIC,12));
		botaoLigaSaida2Modulo2.setEnabled(true);
		botaoLigaSaida2Modulo2.addActionListener(this);
		
		botaoDesligaSaida2Modulo2 = new JButton("Saída 2 - desliga");
		botaoDesligaSaida2Modulo2.setSize(210,25);
		botaoDesligaSaida2Modulo2.setFont(new Font("ScriptS",Font.ITALIC,12));
		botaoDesligaSaida2Modulo2.setEnabled(true);
		botaoDesligaSaida2Modulo2.addActionListener(this);
		
		botaoLigaSaida3Modulo2 = new JButton("Saída 3 - liga");
		botaoLigaSaida3Modulo2.setSize(200,25);
		botaoLigaSaida3Modulo2.setFont(new Font("ScriptS",Font.ITALIC,12));
		botaoLigaSaida3Modulo2.setEnabled(true);
		botaoLigaSaida3Modulo2.addActionListener(this);
		
		botaoDesligaSaida3Modulo2 = new JButton("Saída 3 - desliga");
		botaoDesligaSaida3Modulo2.setSize(210,25);
		botaoDesligaSaida3Modulo2.setFont(new Font("ScriptS",Font.ITALIC,12));
		botaoDesligaSaida3Modulo2.setEnabled(true);
		botaoDesligaSaida3Modulo2.addActionListener(this);

		statusEntradasModulo1 = new JLabel("Desligado, Desligado, Desligado");
		statusEntradasModulo1.setForeground(Color.BLUE);
		statusEntradasModulo1.setEnabled(true);
		
		statusEntradasModulo2 = new JLabel("Desligado, Desligado, Desligado");
		statusEntradasModulo2.setForeground(Color.BLUE);
		statusEntradasModulo2.setEnabled(true);
		
		
		//adiciona os botoes e labels na tela e define layout:
		JPanel panel = new JPanel(new GridLayout(8,1));  //tela dividida em oito sessões
		
		//primeira sessão: botões de conexão e desconexão ao broker
		JPanel pBotoesConectarDesConectar = new JPanel();
		pBotoesConectarDesConectar.add(botaoConectarBroker);
		pBotoesConectarDesConectar.add(botaoDesconectarBroker);
		panel.add(pBotoesConectarDesConectar);
		
		//Segunda, terceira e quarta sessões: monitoramentos e ações do módulo 1 
		JPanel pLabelModulo1 = new JPanel();
		pLabelModulo1.add(labelModulo1);
		panel.add(pLabelModulo1);
		
		JPanel pMonitoramentosModulo1 = new JPanel();
		pMonitoramentosModulo1.add(statusEntradasModulo1);
		panel.add(pMonitoramentosModulo1);
		
		JPanel pAcoesModulo1 = new JPanel(new GridLayout(3,2));
		pAcoesModulo1.add(botaoLigaSaida1Modulo1);
		pAcoesModulo1.add(botaoDesligaSaida1Modulo1);
		pAcoesModulo1.add(botaoLigaSaida2Modulo1);
		pAcoesModulo1.add(botaoDesligaSaida2Modulo1);
		pAcoesModulo1.add(botaoLigaSaida3Modulo1);
		pAcoesModulo1.add(botaoDesligaSaida3Modulo1);
		panel.add(pAcoesModulo1);
		
		//Quinta, sexta e sétima sessões: monitoramentos e ações do módulo 2
		JPanel pLabelModulo2 = new JPanel();
		pLabelModulo2.add(labelModulo2);
		panel.add(pLabelModulo2);
		
		
		JPanel pMonitoramentosModulo2 = new JPanel();
		pMonitoramentosModulo2.add(statusEntradasModulo2);
		panel.add(pMonitoramentosModulo2);
		
		
		JPanel pAcoesModulo2 = new JPanel(new GridLayout(3,2));
		pAcoesModulo2.add(botaoLigaSaida1Modulo2);
		pAcoesModulo2.add(botaoDesligaSaida1Modulo2);
		pAcoesModulo2.add(botaoLigaSaida2Modulo2);
		pAcoesModulo2.add(botaoDesligaSaida2Modulo2);
		pAcoesModulo2.add(botaoLigaSaida3Modulo2);
		pAcoesModulo2.add(botaoDesligaSaida3Modulo2);
		panel.add(pAcoesModulo2);
		
		//Oitava sessão: monitoramentos e ações do módulo 1
		JPanel pBotaoSair = new JPanel();
		pBotaoSair.add(botaoSair);
		panel.add(pBotaoSair);
		
		//desenha na tela o panel completo
		getContentPane().add(panel);
	}
	
	
	public void actionPerformed(ActionEvent arg0) 
	{
		//ações dos botoes:
		
		//botão de sair
		if(arg0.getSource()==botaoSair) 
			System.exit(0);

		//botão de conexão ao broker
		if(arg0.getSource()==botaoConectarBroker)
			Supervisorio.FazConexaoBroker();
		
		//botão para desconectar do broker
		if(arg0.getSource()==botaoDesconectarBroker)
			Supervisorio.FazDesconexaoBroker();
		
		//botao: liga saida 1 do modulo 1
		if(arg0.getSource()==botaoLigaSaida1Modulo1)
			Supervisorio.LigaDesligaSaida("1","1","1");
		
		//botao: liga saida 2 do modulo 1
	    if(arg0.getSource()==botaoLigaSaida2Modulo1)
			Supervisorio.LigaDesligaSaida("1","2","1");
	    
	    //botao: liga saida 3 do modulo 1
	    if(arg0.getSource()==botaoLigaSaida3Modulo1)
			Supervisorio.LigaDesligaSaida("1","3","1");
	    
	    //botao: desliga saida 1 do modulo 1
	  	if(arg0.getSource()==botaoDesligaSaida1Modulo1)
	  		Supervisorio.LigaDesligaSaida("1","1","0");
	  		
	  	//botao: desliga saida 2 do modulo 1
	  	if(arg0.getSource()==botaoDesligaSaida2Modulo1)
	  		Supervisorio.LigaDesligaSaida("1","2","0");
	  	    
	  	//botao: desliga saida 3 do modulo 1
	  	if(arg0.getSource()==botaoDesligaSaida3Modulo1)
	  	    Supervisorio.LigaDesligaSaida("1","3","0");
	  	
	    //botao: liga saida 1 do modulo 2
	  	if(arg0.getSource()==botaoLigaSaida1Modulo2)
	  		Supervisorio.LigaDesligaSaida("2","1","1");
	  		
	  	//botao: liga saida 2 do modulo 2
	  	if(arg0.getSource()==botaoLigaSaida2Modulo2)
	  		Supervisorio.LigaDesligaSaida("2","2","1");
	  	    
	  	//botao: liga saida 3 do modulo 2
	  	if(arg0.getSource()==botaoLigaSaida3Modulo2)
	  		Supervisorio.LigaDesligaSaida("2","3","1");
	  	    
	  	//botao: desliga saida 1 do modulo 2
	  	if(arg0.getSource()==botaoDesligaSaida1Modulo2)
	  		Supervisorio.LigaDesligaSaida("2","1","0");
	  	  		
	  	//botao: desliga saida 2 do modulo 2
	  	if(arg0.getSource()==botaoDesligaSaida2Modulo2)
	  	 	Supervisorio.LigaDesligaSaida("2","2","0");
	  	  	    
	  	//botao: desliga saida 3 do modulo 2
	  	if(arg0.getSource()==botaoDesligaSaida3Modulo2)
	  	    Supervisorio.LigaDesligaSaida("2","3","0");
		
	}

	public static void AlteraStatusModulo1(String statusMod1)
	{
		statusEntradasModulo1.setText(statusMod1);
	}
	
	public static void AlteraStatusModulo2(String statusMod2)
	{
		statusEntradasModulo2.setText(statusMod2);
	}
}
