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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class JanelaBuscarSequencial extends JFrame {
	private JButton BFALSO,Seta,Lupa,Ordenar,Voltar;
	private JLabel Lb1,Lb_Caminho,Lb_Ordenacao,valorB;
	private JPanel panel2;
	private JTextField TF1,TF2;
	String caminho,dadosOrdenados="";
	long tempoInicio;
	int quantidadeTroca=1,valor,a,achou;

    public JanelaBuscarSequencial() {
        super("JanelaBuscarSequencial");
		super.setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		init();
		init_event();

    }
    public void Posiciona_Componentes() {
    	panel2.setBounds(0,0,500,80);  
    	Lb1.setBounds(100,8,300,60); 
    	Voltar.setBounds(10,20,50,30);

    	Lb_Caminho.setBounds(33,140,120,30);
        TF1.setBounds(33,180,387,30);
        Lupa.setBounds(420,180,30,30);

        valorB.setBounds(33,210,250,80);    
        TF2.setBounds(235,235,80,30);    

        Ordenar.setBounds(200,350,66,66);
	};
	public void init() {
        Container Cnt=this.getContentPane();
		Cnt.setLayout(null);
		Cnt.setBackground(Color.WHITE);

		//Label Ordenar Arquivo
		Lb1=new JLabel("Busca Sequencial");
		Lb1.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		Lb1.setBackground(new Color(0, 0, 46));
		Lb1.setForeground(Color.WHITE);
		Lb1.setHorizontalAlignment(JLabel.RIGHT);
		Lb1.setOpaque(true);
		//

		//Valor Buscar
		valorB=new JLabel("Valor para buscar:");
		valorB.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		Cnt.add(valorB);
		//

		panel2 = new JPanel();
		panel2.setBackground(new Color(0, 0, 46));

		//Botao Falso
		BFALSO = new JButton(".");
		//

		//Botao Ordenar
		Icon imgOk = new ImageIcon("imagens"+File.separator+"checked.png");
		Ordenar = new JButton(imgOk);
		Ordenar.setBackground(Color.WHITE);
		Ordenar.setBorderPainted(false);
		Ordenar.setToolTipText("Ordena o arquivo");
		Cnt.add(Ordenar);
		//

		//Label Caminho:		
		Lb_Caminho = new JLabel("Caminho:");
		Lb_Caminho.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		Lb_Caminho.setForeground(Color.BLACK);
		Cnt.add(Lb_Caminho);
		//

		//Botao Seta
		Icon imgSair = new ImageIcon("imagens"+File.separator+"left-arrow1.png");		
		Voltar=new JButton(imgSair);
		Voltar.setBackground(new Color(0, 0, 46));
		Voltar.setBorderPainted(false);
		Voltar.setToolTipText("Voltar");
		Cnt.add(Voltar);	
		//

		//Valor buscar
		TF2=new JTextField(10);
		TF2.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		Cnt.add(TF2);
		//

		//Text Field Caminho
		TF1=new JTextField(10);
		TF1.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		TF1.setText("<Selecione o arquivo ordenado>");
		caminho = TF1.getText();
		//JOptionPane.showMessageDialog(null,caminho);
		TF1.setEditable(false);
		Cnt.add(TF1);
		//

		//Botao Lupa
		Icon imgLupa = new ImageIcon("imagens"+File.separator+"lupa24.png");
		Lupa=new JButton(imgLupa);
		Cnt.add(Lupa);
		//

		Cnt.add(BFALSO);
		Cnt.add(Lb1);
		Cnt.add(panel2);

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

		Lupa.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent AE1) {        
				    JFileChooser f = new JFileChooser();
				    f.setFileFilter(new FileNameExtensionFilter("Arquivo de texto","txt"));
			        f.setFileSelectionMode(JFileChooser.FILES_ONLY); 
			        f.showSaveDialog(null);
			        caminho = f.getSelectedFile()+"";
			        TF1.setText(f.getSelectedFile()+"");
			        if (f.getSelectedFile() == null){
			        	TF1.setText("<Selecione o arquivo ordenado>");
			        }
				}
			}
		);

		Ordenar.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent AE1) {
					int erro=0;
					String mensagem="Campos obrigatorios nao preenchidos:\n------------------------------------------------------\n";
					if(caminho==null || caminho.equals("<Selecione o arquivo ordenado>")){
						mensagem += "- Caminho.\n";
						erro=1;
					}
					if((TF2.getText()+"").equals("")){
						mensagem += "- Digite um valor.\n";
						erro=1;
					}
					if (erro == 1){
						JOptionPane.showMessageDialog(null,mensagem,"Algo deu errado...",JOptionPane.ERROR_MESSAGE);
						return;
					}else{					        
				        valor = Integer.parseInt(TF2.getText());
				        alocaVetor(caminho,valor);
				        if(achou == 1){
				        	JOptionPane.showMessageDialog(null,"Achou em "+tempoInicio+" milissegundos");
				        }else{
				        	JOptionPane.showMessageDialog(null,"Nao contem no arquivo");
				        }
					}			
				}
			}
		);

		Voltar.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent AE1) {
					JanelaSelecionaTipoBusca J1=new JanelaSelecionaTipoBusca();
					J1.show();				
					hide();
				}
			}
		);
	}
	 
	 public void alocaVetor(String path,int valorBuscar) {
		 try {
				FileReader fileReader = new FileReader(path);
				BufferedReader reader = new BufferedReader(fileReader);
				ArrayList<Integer> list = new ArrayList<>();
				String linha = "";
				int prog = 0;
				tempoInicio = System.currentTimeMillis();
				linha = reader.readLine();
				while(linha!=null) {
					list.add(Integer.parseInt(linha));
					linha = reader.readLine();
					prog++;
				}
				reader.close();
				fileReader.close();		
				int[] a = list.stream().mapToInt(Integer::intValue).toArray();			
				sequencial(a,valorBuscar);

			} catch (IOException e) {
				e.printStackTrace();
			}		 
	 }
	 private int sequencial(int[] dados,int valorBuscar) {
	 	tempoInicio = System.currentTimeMillis();  
		for(int i = 0; i<dados.length; i++){
			if(dados[i] == valorBuscar) {
				achou=1;
				tempoInicio = System.currentTimeMillis()-tempoInicio;  
				return dados[i];
			}
		}
		achou=0;
		return 0;
	}
	 private int binario(int[] dados,int valorBuscar) {
	 	tempoInicio = System.currentTimeMillis();       
	    int n = dados.length;     
	    int aux = 0;     
	    for(int i = 0; i < n-1; i++){   
	    	for(int j = i+1 ; j < n; j++){ 
	            if(dados[i] > dados[j]){   
	                aux = dados[j];     
	                dados[j] = dados[i];     
	                dados[i] = aux;     
	            }     
	    	}     
	     }     
	     int meio;     
	     int inicio = 0;     
	     int fim = dados.length-1;     
	     while (inicio <= fim) {     
	    	meio = (inicio + fim)/2;     
	    	if (valorBuscar == dados[meio]) {
	    		achou = 1;
	    		tempoInicio = System.currentTimeMillis()-tempoInicio;    
	    		return dados[meio];     
	    	}
	    	if (valorBuscar < dados[meio]) {     
	    		 fim = meio - 1;
	    	}
	    	else {     
	    		 inicio = meio + 1;     
	     	}         
	 	 }
	 	achou = 0;
	  	tempoInicio = System.currentTimeMillis()-tempoInicio;
		return 0;     
	}
	/*//Main para testes
    public static void main(String[] args) {
    	JanelaBuscarSequencial J1=new JanelaBuscarSequencial();
		J1.show();
    }*/
}