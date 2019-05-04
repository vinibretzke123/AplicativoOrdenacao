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

public class JanelaOrdenandoArquivo extends JFrame {
	private JButton BFALSO,Seta;
	private JLabel Lb1,Lb_ArquivoGerado,Lb_ArquivoGeradoSucesso,quantidadeTempo,mili,quantidadetroca,L_troca;
	private JPanel panel2;
	private JTextField TF1;
	String caminho,DadosOrdenados,Path,a;
	long tempo;
	int quantidadeTroca;
	JanelaGeraArquivo J1=new JanelaGeraArquivo();

    public JanelaOrdenandoArquivo(long Tempo,int troca,String dadosOrdenados,String path) {
        super("Janela Arquivo Ordenado");
		super.setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		tempo = Tempo;
		DadosOrdenados = dadosOrdenados;
		quantidadeTroca = troca;		
		Path = path;
		init();		
		init_event();
    }
    public void Posiciona_Componentes() {
    	panel2.setBounds(0,0,500,80);  
    	Lb1.setBounds(0,8,380,60);  

    	Lb_ArquivoGerado.setBounds(33,250,180,30);    	
    	TF1.setBounds(33,300,420,30);

	   	quantidadeTempo.setBounds(80,120,180,50);
	   	mili.setBounds(100,160,300,50);

	   	quantidadetroca.setBounds(300,120,180,50);
	   	L_troca.setBounds(320,160,300,50);

	   	Seta.setBounds(200,370,66,66);     
	}

	public void init() {
        Container Cnt=this.getContentPane();
		Cnt.setLayout(null);
		Cnt.setBackground(Color.WHITE);

		//Label Gerando arquivo
		Lb1=new JLabel("Arquivo Ordenado");
		Lb1.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		Lb1.setBackground(new Color(0, 0, 46));
		Lb1.setForeground(Color.WHITE);
		Lb1.setHorizontalAlignment(JLabel.RIGHT);
		Lb1.setOpaque(true);
		Cnt.add(Lb1);
		//

		//Label Arquivo Gerado
		Lb_ArquivoGerado=new JLabel("Salvar arquivo:");
		Lb_ArquivoGerado.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		Cnt.add(Lb_ArquivoGerado);
		//

		//Label Arquivo Gerado
		Lb_ArquivoGeradoSucesso=new JLabel("Ordenado com sucesso!");
		Lb_ArquivoGeradoSucesso.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		Cnt.add(Lb_ArquivoGeradoSucesso);
		//

		//Text Field Caminho
		a = Path.replace(".txt","Ordenardo.txt");
		TF1=new JTextField(10);
		TF1.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		TF1.setText(a);
		TF1.setEditable(false);
		Cnt.add(TF1);
		//

		//Label Tempo
		quantidadeTempo=new JLabel(tempo+"");
		quantidadeTempo.setFont(new Font("Trebuchet MS", Font.PLAIN, 50));
		Cnt.add(quantidadeTempo);
		//

		//Label mili
		mili=new JLabel("milissegundos");
		mili.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		Cnt.add(mili);
		//

		//Botao Seta
		Icon imgOk = new ImageIcon("imagens"+File.separator+"checked.png");
		Seta = new JButton(imgOk);
		Seta.setBackground(Color.WHITE);
		Seta.setBorderPainted(false);
		Seta.setToolTipText("Ordena o arquivo");
		Cnt.add(Seta);
		//

		//Label quantidadetroca
		quantidadetroca=new JLabel(quantidadeTroca+"");
		quantidadetroca.setFont(new Font("Trebuchet MS", Font.PLAIN, 50));
		Cnt.add(quantidadetroca);
		//

		//Label comparações
		L_troca=new JLabel("comparacoes");
		L_troca.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		Cnt.add(L_troca);
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

	public void salvar(String dadosOrdenados,String caminho) throws IOException{
    	try {
    		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(caminho));
    		String[] dados =  dadosOrdenados.split(";");
    		for(int i=0;i<dados.length;i++){
    			buffWrite.append(dados[i]+"");
    			buffWrite.newLine();
    		}            
	    	buffWrite.close();  
    	}
    	catch(IOException e) {
		  
		}
	}

	 public void init_event() {
		
		this.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent WE1) {
					System.exit(0);					
				}
			}
		);

		Seta.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent AE1) {
					int erro=0;
					String mensagem="Campos obrigatorios nao preenchidos:\n------------------------------------------------------\n";
					String caminho = TF1.getText();
					//if (caminho.equals("null") || caminho.equals("<Selecione o caminho>")){
					//	mensagem += "- Caminho.\n";
					//	erro=1;
					//}				    
				    if (erro == 1){
						JOptionPane.showMessageDialog(null,mensagem,"Algo deu errado...",JOptionPane.ERROR_MESSAGE);
						return;
					}else{
						try{
							salvar(DadosOrdenados,a);
							JanelaPrincipal J1=new JanelaPrincipal();
							J1.show();
							hide();
						}catch(IOException e) {
		  
						}						
					}					
				}
			}
		);
	}

/*	//Main para testes
    public static void main(String[] args) {
    	JanelaOrdenandoArquivo J1=new JanelaOrdenandoArquivo(10000,50,"ALGOALGO","C:\\Users\\Particular\\Desktop\\Reversed10.txt");
		J1.show();
    }*/
}