package progIIex02;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.text.DecimalFormat;



public class Ex02Class extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	private BorderLayout layout;
	private JPanel PTopo;
	//
	private JPanel PCentro;
	private JLabel lSalBruto;
	private JTextField tSalBruto;
	private JButton Calcular;
	private JCheckBox Formatar;
	
	
	private JLabel lBaseInss;
	private JTextField tBaseInss;
	private JLabel lDescInss;
	private JTextField tDescInss;
	private JLabel lBaseirpf;
	private JTextField tBaseirpf;
	private JLabel lDescirpf;
	private JTextField tDescirpf;
	
	private JLabel lSalLiq;
	private JTextField tSalLiq;
	
public Ex02Class(){
	
	super("Cálculo de Salário");
	
	layout = new BorderLayout(2,2); //espaco de 5 pixels
	setLayout(layout);
	
	PTopo = new JPanel();
	PCentro = new JPanel();
	PCentro.setLayout(new GridLayout(5, 2));
	
	lSalBruto = new JLabel("Salario bruto:");
	tSalBruto = new JTextField(7);
	Calcular = new JButton("Calcular");
	Formatar = new JCheckBox();
	
	lBaseInss = new JLabel("Base INSS: ");
	tBaseInss = new JTextField(20);
	lDescInss = new JLabel("Desconto INSS: ");
	tDescInss = new JTextField(20);
	lBaseirpf = new JLabel("Base IRPF: ");
	tBaseirpf = new JTextField(20);
	lDescirpf = new JLabel("Desconto IRPF:");
	tDescirpf = new JTextField(20); 
	
	lSalLiq = new JLabel("Salário Líquido: ");
	tSalLiq = new JTextField(12);
	
	PTopo.add(lSalBruto);
	PTopo.add(tSalBruto);
	PTopo.add(Calcular);
	PTopo.add(Formatar);
	
	//getContentPane().setLayout(new GridLayout(5,2));
	getContentPane().setLayout(new BorderLayout(2, 2));
	
	PCentro.add(getContentPane().add(lBaseInss));
	PCentro.add(getContentPane().add(tBaseInss));
	PCentro.add(getContentPane().add(lDescInss));
	PCentro.add(getContentPane().add(tDescInss));
	PCentro.add(getContentPane().add(lBaseirpf));
	PCentro.add(getContentPane().add(tBaseirpf));
	PCentro.add(getContentPane().add(lDescirpf));
	PCentro.add(getContentPane().add(tDescirpf));
	
	PCentro.add(getContentPane().add(lSalLiq));
	PCentro.add(getContentPane().add(tSalLiq));
	
	
	add(PTopo,BorderLayout.NORTH);
	add(PCentro,BorderLayout.CENTER);
	
	
	Calcular.addActionListener(this);
	
	
	
}
	public void actionPerformed(ActionEvent e) {
		float vSalBruto = Integer.parseInt(tSalBruto.getText());
		float vBaseInss = Integer.parseInt(tSalBruto.getText());
		float vDescInss;
		float vBaseirpf;
		float vDescirpf = 0;
		float vSalLiq;
		
		
		
		if (vBaseInss <= 1659.38){
		
		vDescInss = (vBaseInss * 8 )/ 100;
		
		}else if(vBaseInss >= 1659.39 && vBaseInss <=2765.66){
		
		vDescInss = (vBaseInss * 9 )/ 100;
			
		} else if (vBaseInss >= 2765.67 && vBaseInss <=5531.31){
		
		vDescInss = (vBaseInss * 11 )/ 100;
		} else {
			
		vDescInss = (float) 608.45;
		} // FIM DO PRIMEIRO IF
	    
		vBaseirpf = vSalBruto - vDescInss;
		
	 DecimalFormat FormatarNumero = new DecimalFormat("0.##");
		
		
	  if (vBaseirpf >= 1903.99 && vBaseirpf <= 2826.65) {
		  
		  vDescirpf = (float) (((vBaseirpf * 7.5)/ 100) - 142.80);
		  
	  } else if (vBaseirpf >= 2826.66 && vBaseirpf <= 3751.05){
		  
		  vDescirpf = (float) (((vBaseirpf * 15)/ 100) - 354.80);
		  
	  } else if (vBaseirpf >= 3751.06 && vBaseirpf <= 4664.68){
		  
		  vDescirpf = (float) (((vBaseirpf * 22.50)/ 100) - 636.13); 
		  
	  } else if (vBaseirpf >= 4664.69){
		  
		  vDescirpf = (float) (((vBaseirpf * 27.50)/ 100) - 869.36);  
	  } else {
		  
		  vBaseirpf = 0;
		  
	  }
	  
	  
	  
	  
	  //FIM DO SEGUNDO IF
	   
	  
	       vSalLiq = vSalBruto - (vDescInss + vDescirpf);
	  
	  if (Formatar.isSelected()){
			tBaseInss.setText("R$ "+tSalBruto.getText());
			tDescInss.setText("R$ "+String.valueOf(vDescInss));
			tBaseirpf.setText("RS "+String.valueOf(vBaseirpf));
			tDescirpf.setText("RS "+String.valueOf(FormatarNumero.format((vDescirpf))));
			tSalLiq.setText("RS "+String.valueOf(FormatarNumero.format(vSalLiq)));
			} else {
			tBaseInss.setText(tSalBruto.getText());
			tDescInss.setText(String.valueOf(vDescInss));
			tBaseirpf.setText(String.valueOf(vBaseirpf));
			tDescirpf.setText(String.valueOf(FormatarNumero.format((vDescirpf))));
			tSalLiq.setText(String.valueOf(FormatarNumero.format(vSalLiq)));
	        	 
			} //FIM DO TERCEIRO IF
	} // FIM DO ACTION LISTENER
	
	
	
}

