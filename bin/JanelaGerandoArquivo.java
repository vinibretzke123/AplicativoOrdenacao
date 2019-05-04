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

public class JanelaGerandoArquivo extends JFrame {
	private JButton BFALSO,Voltar;
	private JLabel Lb1,Lb_ArquivoGerado,Lb_ArquivoGeradoSucesso;
	private JPanel panel2;
	private JTextField TF1;
	String caminhoNome1;
	JanelaGeraArquivo J1=new JanelaGeraArquivo();

    public JanelaGerandoArquivo(String caminhoNome) {
        super("Janela Gerando Arquivo");
		super.setSize(500, 500);
		caminhoNome1 = caminhoNome;
		setLocationRelativeTo(null);
		setResizable(false);
		
		init();		
		init_event();
    }

    public void fewUnique(String caminho,int quantidade) throws IOException{
    	try {
    		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(caminho));
	    	for (int i = 0; i < quantidade; i++) {
	    		int x = (int) (Math.random() * 3);
	            buffWrite.append(x+"");
	            buffWrite.newLine();
	        }
	    	buffWrite.close();
		}catch(IOException e) {
		  
		} 		    
    }

    public void nearSort(String caminho,int quantidade) throws IOException{
    	try {
    		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(caminho));
    		int metade = quantidade / 2;
    		int i=1;
	    	while(i != metade+1){
	    		buffWrite.append(i + ""); 
	    		buffWrite.newLine();
	    		i++;
	    	} 
	    	for (int j = 0; j < metade; j++) {
	    		int x = (int) (Math.random() * quantidade);
	            buffWrite.append(x+"");
	            buffWrite.newLine();
	        }

	    	buffWrite.close();
		}catch(IOException e) {
		  
		} 		    
    }

    public void ordenado(String caminho,int quantidade) throws IOException{
    	try {
	    	BufferedWriter buffWrite = new BufferedWriter(new FileWriter(caminho));
	    	int i=1;
	    	while(i != quantidade+1){
	    		buffWrite.append(i + "");
	    		buffWrite.newLine();
	    		i++;
	    	}  
	    	buffWrite.close();  
    	}
    	catch(IOException e) {
		  
		}            
    }

    public void invertido(String caminho,int quantidade) throws IOException{
    	try {
	    	BufferedWriter buffWrite = new BufferedWriter(new FileWriter(caminho));
	    	int i=quantidade;
	    	while(i != 0){
	    		buffWrite.append(i + "");
	    		buffWrite.newLine();
	    		i--;
	    	}  
	    	buffWrite.close();  
    	}
    	catch(IOException e) {
		  
		}            
    }

    public void random(String caminho,int quantidade) throws IOException{
    	try {
	    	BufferedWriter buffWrite = new BufferedWriter(new FileWriter(caminho));
	    	Random gerador = new Random(quantidade * 10);
	    	for (int i = 0; i < quantidade; i++) {
	            buffWrite.append(gerador.nextInt(quantidade * 10)+"");
	            buffWrite.newLine();
	        }
	    	buffWrite.close();  
    	}
    	catch(IOException e) {
		  
		}
    }

    public void Posiciona_Componentes() {
    	panel2.setBounds(0,0,500,80);  
    	Lb1.setBounds(0,8,380,60);  
    	Lb_ArquivoGerado.setBounds(33,120,120,30);
    	TF1.setBounds(33,160,420,30);
    	Lb_ArquivoGeradoSucesso.setBounds(95,270,420,30);    
    	Voltar.setBounds(200,350,66,66);       
	}

	public void init() {
        Container Cnt=this.getContentPane();
		Cnt.setLayout(null);
		Cnt.setBackground(Color.WHITE);

		//Label Gerando arquivo
		Lb1=new JLabel("Gerando arquivo");
		Lb1.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		Lb1.setBackground(new Color(0, 0, 46));
		Lb1.setForeground(Color.WHITE);
		Lb1.setHorizontalAlignment(JLabel.RIGHT);
		Lb1.setOpaque(true);
		Cnt.add(Lb1);
		//

		//Label Arquivo Gerado
		Lb_ArquivoGerado=new JLabel("Arquivo:");
		Lb_ArquivoGerado.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		Cnt.add(Lb_ArquivoGerado);
		//

		//Label Arquivo Gerado
		Lb_ArquivoGeradoSucesso=new JLabel("Gerado com sucesso!");
		Lb_ArquivoGeradoSucesso.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		Cnt.add(Lb_ArquivoGeradoSucesso);
		//

		//Text Field Caminho
		JanelaGeraArquivo J1=new JanelaGeraArquivo();
		TF1=new JTextField(10);
		TF1.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		TF1.setText(caminhoNome1);
		TF1.setEditable(false);
		Cnt.add(TF1);
		//

		//Botao Voltar
		Icon imgAcabou = new ImageIcon("imagens"+File.separator+"checked.png");
		Voltar = new JButton(imgAcabou);
		Voltar.setBackground(Color.WHITE);
		Voltar.setBorderPainted(false);
		Voltar.setToolTipText("Volta a tela inicial");	
		Cnt.add(Voltar);
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

		Voltar.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent AE1) {
					JanelaPrincipal J1=new JanelaPrincipal();
					J1.show();
					hide();					
				}
			}
		);
	}
	/*//Main para testes
    public static void main(String[] args) {
    	JanelaGerandoArquivo J1=new JanelaGerandoArquivo("C:\\Users\\Particular\\Desktop\\teste.txt");
		J1.show();
    }*/
}