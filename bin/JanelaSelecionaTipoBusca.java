import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;


public class JanelaSelecionaTipoBusca extends JFrame {
	private JButton BFALSO,Avancar,Seta,Gnome,Buble;
	private JLabel Lb1,Lb_ArquivoTipo;
	private JPanel panel2;
	int Gnomeclicado,Bubleclicado,Insertionclicado,Selectionclicado=0;
	JanelaGeraArquivo J1=new JanelaGeraArquivo();

    public JanelaSelecionaTipoBusca() {
        super("JanelaSelecionaTipoBusca");
		super.setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		init();		
		init_event();
    }

    public void Posiciona_Componentes() {
    	panel2.setBounds(0,0,500,80);  
    	Lb1.setBounds(155,8,150,60);     	
    	Seta.setBounds(10,20,50,30);

    	Lb_ArquivoTipo.setBounds(33,120,250,30);

    	//Botoes
    	Gnome.setBounds(50,180,180,60);
    	Buble.setBounds(250,180,180,60);

    	Avancar.setBounds(200,350,66,66);       
	}

	public String QuemFoiSelecionado() {
		String retorno="";
		if(Gnomeclicado==1){
			retorno = "Gnomeclicado";
		}else if(Bubleclicado ==1){
			retorno = "Bubleclicado";
		}
		return retorno;
	}

	public void init() {
        Container Cnt=this.getContentPane();
		Cnt.setLayout(null);
		Cnt.setBackground(Color.WHITE);

		//Botao Gnome
		Gnome = new JButton("Sequencial");
		Gnome.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		Gnome.setBackground(new Color(249, 255, 255));	
		Cnt.add(Gnome);
		//

		//Botao Buble
		Buble = new JButton("Binario");
		Buble.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		Buble.setBackground(new Color(249, 255, 255));	
		Cnt.add(Buble);
		//

		//Label Gerando arquivo
		Lb1=new JLabel("Buscar");
		Lb1.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		Lb1.setBackground(new Color(0, 0, 46));
		Lb1.setForeground(Color.WHITE);
		Lb1.setHorizontalAlignment(JLabel.RIGHT);
		Lb1.setOpaque(true);
		Cnt.add(Lb1);
		//

		//Label Arquivo Gerado
		Lb_ArquivoTipo=new JLabel("Selecione o modo:");
		Lb_ArquivoTipo.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		Cnt.add(Lb_ArquivoTipo);
		//

		//Botao Voltar
		Icon imgAcabou = new ImageIcon("imagens"+File.separator+"checked.png");
		Avancar = new JButton(imgAcabou);
		Avancar.setBackground(Color.WHITE);
		Avancar.setBorderPainted(false);
		Cnt.add(Avancar);
		//

		//Botao Seta
		Icon imgSair = new ImageIcon("imagens"+File.separator+"left-arrow1.png");		
		Seta=new JButton(imgSair);
		Seta.setBackground(new Color(0, 0, 46));
		Seta.setBorderPainted(false);
		Seta.setToolTipText("Voltar");
		Cnt.add(Seta);	
		//

		//Painel Titulo
		panel2 = new JPanel();
		panel2.setBackground(new Color(0, 0, 46));
		Cnt.add(panel2);
		//

		//Botao falso
		BFALSO = new JButton(".");
		Cnt.add(BFALSO);
		//		

		Posiciona_Componentes();
	};

	 public void init_event() {
		
		this.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent WE1) {
					System.exit(0);					
				}
			}
		);

		Avancar.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent AE1) {
					int erro=0;
					String mensagem="Campos obrigatorios nao preenchidos:\n------------------------------------------------------\n";
					if( ((Gnomeclicado==1) && (Bubleclicado ==1)) || ((Gnomeclicado==1) && (Insertionclicado ==1)) || ((Gnomeclicado==1) && (Selectionclicado ==1))
					|| ((Bubleclicado==1) && (Insertionclicado ==1)) || ((Bubleclicado==1) && (Selectionclicado ==1)) 
					|| ((Insertionclicado==1) && (Selectionclicado ==1))){
						mensagem += "- Selecione apenas um modo. \n";
						erro=1;			
					}
					if (erro == 1){
						JOptionPane.showMessageDialog(null,mensagem,"Algo deu errado...",JOptionPane.ERROR_MESSAGE);
						return;
					}else{
						if(QuemFoiSelecionado().equals("Gnomeclicado")){
							JanelaBuscarSequencial JGnome=new JanelaBuscarSequencial();
							JGnome.show();				
							hide();
						}
						if(QuemFoiSelecionado().equals("Bubleclicado")){
							JanelaBuscarBinario JBubble =new JanelaBuscarBinario();
							JBubble.show();				
							hide();
						}						
					}					
				}
			}
		);

		Seta.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent AE1) {
					JanelaPrincipal J1=new JanelaPrincipal();
					J1.show();				
					hide();
				}
			}
		);

		//Modos
		Gnome.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent AE1) {
					if(Gnomeclicado==0){
						Gnome.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
						Gnome.setForeground(new Color(255,255,255)); 
						Gnome.setBackground(new Color(0, 0, 46));
						Gnomeclicado=1; 
					}else{
						Gnome.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
						Gnome.setForeground(new Color(0,0,0)); 
						Gnome.setBackground(new Color(249, 255, 255));
						Gnomeclicado=0; 
					}
					
				}
			}
		);

		Buble.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent AE1) {
					if(Bubleclicado==0){
						Buble.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
						Buble.setForeground(new Color(255,255,255)); 
						Buble.setBackground(new Color(0, 0, 46));
						Bubleclicado=1; 
					}else{
						Buble.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
						Buble.setForeground(new Color(0,0,0)); 
						Buble.setBackground(new Color(249, 255, 255));
						Bubleclicado=0; 
					}
					
				}
			}
		);
	}

	/*//Main para testes
    public static void main(String[] args) {
    	JanelaSelecionaTipoBusca J1=new JanelaSelecionaTipoBusca();
		J1.show();
    }*/
}