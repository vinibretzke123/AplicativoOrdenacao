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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.File;

public class JanelaGeraArquivo extends JFrame {
	private JButton BFALSO,Seta,Gerar,Lupa;
	private JLabel Lb1,Lb_Tipo,Lb_Caminho,Lb_Quantidade;
	private JPanel panel2;	
	private JComboBox cmbNiv,cmbQuantidade;
	private JTextField TF1;
	String tipo,caminho;
	int quantidade;

    public JanelaGeraArquivo() {
        super("Janela para Gerar Arquivo");
		super.setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		init();
		init_event();

    }

    public void Posiciona_Componentes() {
    	panel2.setBounds(0,0,500,80);  
    	Lb1.setBounds(100,8,250,60);        
        Seta.setBounds(10,20,50,30);

        Lb_Tipo.setBounds(33,120,120,30);
		cmbNiv.setBounds(33,160,415,30);

        Lb_Caminho.setBounds(33,210,120,30);
        TF1.setBounds(33,250,387,30);
        Lupa.setBounds(420,250,30,30);

        Lb_Quantidade.setBounds(33,300,250,30);
        cmbQuantidade.setBounds(33,340,415,30);
        
        Gerar.setBounds(400,385,66,66);
	};
	public void init() {
        Container Cnt=this.getContentPane();
		Cnt.setLayout(null);
		Cnt.setBackground(Color.WHITE);

		BFALSO = new JButton(".");
		Cnt.add(BFALSO);

		//Label
		Lb1=new JLabel("Gerar arquivo");
		Lb1.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		Lb1.setBackground(new Color(0, 0, 46));
		Lb1.setForeground(Color.WHITE);
		Lb1.setHorizontalAlignment(JLabel.RIGHT);
		Lb1.setOpaque(true);
		Cnt.add(Lb1);
		//

		//Label Tipo:
		Lb_Tipo = new JLabel("Tipo:");
		Lb_Tipo.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		Lb_Tipo.setForeground(Color.BLACK);
		Cnt.add(Lb_Tipo);
		//

		//Combo box Tipo
	    cmbNiv = new JComboBox();
	    cmbNiv.setBackground(Color.WHITE);
	    cmbNiv.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
	    cmbNiv.addItem("Random");
	    cmbNiv.addItem("NearSort");
	    cmbNiv.addItem("FewUnique");
	    cmbNiv.addItem("Sort");
	    cmbNiv.addItem("Reversed");
	    Cnt.add(cmbNiv);
	    //

		//Label Caminho:		
		Lb_Caminho = new JLabel("Caminho:");
		Lb_Caminho.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		Lb_Caminho.setForeground(Color.BLACK);
		Cnt.add(Lb_Caminho);
		//

		//Text Field Caminho
		TF1=new JTextField(10);
		TF1.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		TF1.setText("<Selecione o caminho>");
		TF1.setEditable(false);
		Cnt.add(TF1);
		//

		//Botao Lupa
		Icon imgLupa = new ImageIcon("imagens"+File.separator+"lupa24.png");
		Lupa=new JButton(imgLupa);
		Cnt.add(Lupa);
		//

		//Label Quantidade
		Lb_Quantidade = new JLabel("Quantidade:");
		Lb_Quantidade.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		Lb_Quantidade.setForeground(Color.BLACK);
		Cnt.add(Lb_Quantidade);
		//

		//ComboBox Quantidade
	    cmbQuantidade = new JComboBox();
	    cmbQuantidade.setBackground(Color.WHITE);
	    cmbQuantidade.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
	    cmbQuantidade.addItem("<Quantidade Registros>");
	    cmbQuantidade.addItem("10");
	    cmbQuantidade.addItem("100");
	    cmbQuantidade.addItem("1000");
	    cmbQuantidade.addItem("10000");
	    cmbQuantidade.addItem("100000");
	    cmbQuantidade.addItem("1000000");
	    cmbQuantidade.addItem("10000000");
	    cmbQuantidade.addItem("100000000");
	    Cnt.add(cmbQuantidade);
	    //

		panel2 = new JPanel();
		panel2.setBackground(new Color(0, 0, 46));

		//Botao Seta
		Icon imgSair = new ImageIcon("imagens"+File.separator+"left-arrow1.png");		
		Seta=new JButton(imgSair);
		Seta.setBackground(new Color(0, 0, 46));
		Seta.setBorderPainted(false);
		Seta.setToolTipText("Voltar");
		Cnt.add(Seta);	
		//

		//Botao Gerar
		Icon imgOk = new ImageIcon("imagens"+File.separator+"right-arrow (3).png");
		Gerar=new JButton(imgOk);
		Gerar.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
		Gerar.setBackground(Color.WHITE);
		Gerar.setBorderPainted(false);
		Gerar.setToolTipText("Gera o arquivo");
		Cnt.add(Gerar);
		//	
		
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

		Seta.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent AE1) {
					JanelaPrincipal J1=new JanelaPrincipal();
					J1.show();				
					hide();
				}
			}
		);

		Gerar.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent AE1) {
					int erro=0;
					String mensagem="Campos obrigatorios nao preenchidos:\n------------------------------------------------------\n";
					String caminho = TF1.getText();
					if (caminho.equals("null") || caminho.equals("<Selecione o caminho>")){
						mensagem += "- Caminho.\n";
						erro=1;
					}
					int tipoIndex = cmbQuantidade.getSelectedIndex();
					if (tipoIndex == 0){
						mensagem += "- Quantidade.\n";
						erro=1;
					}
					if (erro == 1){
						JOptionPane.showMessageDialog(null,mensagem,"Algo deu errado...",JOptionPane.ERROR_MESSAGE);
						return;
					}else{
						JFileChooser f = new JFileChooser();
						tipo =  cmbNiv.getSelectedItem().toString();
						caminho = TF1.getText();
						quantidade = Integer.parseInt(cmbQuantidade.getSelectedItem().toString());
						String caminhoNome = caminho+"\\" + tipo+quantidade+".txt";
						JanelaGerandoArquivo J2 =new JanelaGerandoArquivo(caminhoNome);
						try
						{
							if(tipo.equals("Random")){
								J2.random(caminhoNome,quantidade);
							}
							else if(tipo.equals("NearSort")){
								J2.nearSort(caminhoNome,quantidade);
							}
							else if(tipo.equals("FewUnique")){
								J2.fewUnique(caminhoNome,quantidade);
							}
							else if(tipo.equals("Sort")){
								J2.ordenado(caminhoNome,quantidade);
							}
							else if(tipo.equals("Reversed")){
								J2.invertido(caminhoNome,quantidade);
							}
						}
						catch(IOException e){

						}
						JanelaGerandoArquivo J1=new JanelaGerandoArquivo(caminhoNome);
						J1.show();				
						hide();	
					}					
									
				}
			}
		);

		Lupa.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent AE1) {        
				    JFileChooser f = new JFileChooser();
			        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
			        f.showSaveDialog(null);
			        TF1.setText(f.getSelectedFile()+"");
			        if (f.getSelectedFile() == null){
			        	TF1.setText("<Selecione o arquivo>");
			        }
					
				}
			}
		);
	}
	/*
	//Main para testes
    public static void main(String[] args) {
    	JanelaGeraArquivo J1=new JanelaGeraArquivo();
		J1.show();
    }*/
}