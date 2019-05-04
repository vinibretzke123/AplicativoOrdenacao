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


public class JanelaPrincipal extends JFrame {
	private JButton BFALSO,B1,B2,B3;
	private JLabel Lb1,Nome;
	private JPanel panel2;

    public JanelaPrincipal() {
        super("Janela Principal");
		super.setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		init();
		init_event();
    }

    public void Posiciona_Componentes() {
    	panel2.setBounds(0,0,500,150);  
    	Lb1.setBounds(70,50,300,60);        
        B1.setBounds(150,200,170,40);
        B2.setBounds(150,260,170,40);
        B3.setBounds(150,320,170,40);
        Nome.setBounds(165,430,170,40);
	};
	public void init() {
        Container Cnt=this.getContentPane();
		Cnt.setLayout(null);
		Cnt.setBackground(Color.WHITE);

		//Label Titulo
		Lb1=new JLabel("EQUIPE C");
		Lb1.setFont(new Font("Trebuchet MS", Font.BOLD, 56));
		Lb1.setBackground(new Color(0, 0, 46));
		Lb1.setForeground(Color.WHITE);
		Lb1.setHorizontalAlignment(JLabel.RIGHT);
		Lb1.setOpaque(true);
		Cnt.add(Lb1);
		//

		//Label Nome
		Nome=new JLabel("Marcos Roberto Ruginski");
		Nome.setFont(new Font("Trebuchet MS", Font.ITALIC, 13));
		Cnt.add(Nome);
		//

		//Panel
		panel2 = new JPanel();
		panel2.setBackground(new Color(0, 0, 46));
		Cnt.add(panel2);
		//

		//Botão Falso - para pegar o foco
		BFALSO = new JButton(".");
		Cnt.add(BFALSO);
		//
		
		//Botao Gerar Arquivos
		B1=new JButton("Gerar Arquivos");
		B1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		Cnt.add(B1);
		//

		//Botão Ordernar
		B2=new JButton("Ordenar");
		B2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		Cnt.add(B2);
		//

		//Botao Buscar
		B3=new JButton("Buscar");
		B3.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		Cnt.add(B3);
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

		B1.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent AE1) {
					JanelaGeraArquivo J1=new JanelaGeraArquivo();
					J1.show();
					hide();					
				}
			}
		);

		B2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent AE1) {
					JanelaSelecionaTipoOrdenacao J2=new JanelaSelecionaTipoOrdenacao();
					J2.show();
					hide();					
				}
			}
		);

		B3.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent AE1) {
					JanelaSelecionaTipoBusca J3=new JanelaSelecionaTipoBusca();
					J3.show();
					hide();					
				}
			}
		);
	}
    public static void main(String[] args) {
    	JanelaPrincipal J1=new JanelaPrincipal();
		J1.show();
    }
}