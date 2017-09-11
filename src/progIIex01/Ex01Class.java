package progIIex01;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.util.ArrayList;
import javax.swing.JScrollPane;

public class Ex01Class extends JFrame implements ActionListener{
	
	
	private static final long serialVersionUID = 1L;
	
	private JButton Calcular;
	private JLabel lTabuadaDo;
	private JLabel lDe;
	private JLabel lAte;
	private JLabel ResultTabuada;
	private BorderLayout layout;
	private JPanel PTopo;
	private JTextField tTabuadaDo;
	private JTextField tDe;
	private JTextField tAte;
	private JPanel PCentro;
	private JScrollPane Scroll;
	
	ArrayList<String> items= new ArrayList<String>();
	
	public Ex01Class()
	{
		super("Tabuada Dinamica");
		
		layout = new BorderLayout(5,5);
		setLayout(layout);
		
		Calcular = new JButton("Calcular");
		lTabuadaDo = new JLabel("Tabuada do: ");
		lDe = new JLabel("de ");
		lAte = new JLabel("ate ");
		ResultTabuada = new JLabel();
		tTabuadaDo = new JTextField(8);
		tDe = new JTextField(8);
		tAte = new JTextField(8);
		PTopo = new JPanel(new FlowLayout());
		PCentro = new JPanel(new FlowLayout());
		Scroll = new JScrollPane(PCentro);
		
	
		
		PTopo.add(lTabuadaDo);
		PTopo.add(tTabuadaDo);
		PTopo.add(lDe);
		PTopo.add(tDe);
		PTopo.add(lAte);
		PTopo.add(tAte);
		PTopo.add(Calcular);
		
		
		add(PTopo,BorderLayout.NORTH);
		add(Scroll,BorderLayout.CENTER);
		Calcular.addActionListener(this);
		
        PCentro.add(ResultTabuada);
       // PCentro.removeAll();
        
		
	}

	public void actionPerformed(ActionEvent event)
	{
		int vTabuadaDo = Integer.parseInt(tTabuadaDo.getText());
		int vDe = Integer.parseInt(tDe.getText());
		int vAte = Integer.parseInt(tAte.getText());
	    int result;
         for(int i = vDe; i <= vAte; i++){
		    
			result = vTabuadaDo * i;
			
			String equacao = vTabuadaDo +" x "+ i +" = "+result+" / ";
			
	       
			
			 items.add(equacao);
			 
			 
			
			 
		}
		
         
         
         ResultTabuada.setText(items.toString().replace(',', ' '));
         
	}
	
}

