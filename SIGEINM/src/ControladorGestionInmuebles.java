import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ControladorGestionInmuebles extends JDialog implements ActionListener {
	private JButton mostrarInmueblesBoton=new JButton("Mostrar inmuebles");
	private JButton mostrarInventariosBoton=new JButton("Mostrar inventarios");
	private DefaultTableModel modeloTabla=new DefaultTableModel();
	private JTable tabla=new JTable(modeloTabla);
	private ModeloGestionInmuebles modelo=new ModeloGestionInmuebles();
	public ControladorGestionInmuebles(JFrame parent,String user) {
		super(parent,"GestionInmuebles",true);
		setSize(400,600);
		setLocation(100, 100);
		setLayout(null);
		//setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		JLabel label=new JLabel("usuario: "+user);
		label.setSize(label.getPreferredSize());
		label.setLocation(10, 10);
		add(label);
		
		createTable();
		
		mostrarInmueblesBoton.setSize(mostrarInmueblesBoton.getPreferredSize());
		mostrarInmueblesBoton.setLocation(10, 450);
		mostrarInmueblesBoton.addActionListener(this);
		add(mostrarInmueblesBoton);
		
		mostrarInventariosBoton.setSize(mostrarInventariosBoton.getPreferredSize());
		mostrarInventariosBoton.setLocation(10, 500);
		mostrarInventariosBoton.addActionListener(this);
		add(mostrarInventariosBoton);
		
		setVisible(true);
		
	}
	
	void createTable(){
		String [][] datos={{}};
		String [] cabezera={"ID","DIRECCION","PRECIO","USUARIO"};
		modeloTabla.setDataVector(new String[0][4], cabezera);
		JScrollPane scrollPane=new JScrollPane(tabla);
		scrollPane.setPreferredSize(tabla.getPreferredSize());
		add(scrollPane);
		scrollPane.setSize(300,300);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setLocation(10, 40);
	}
	
	public void actionPerformed(ActionEvent event){
		if(event.getSource()==mostrarInmueblesBoton){
			System.out.println("mostrar Inmuebles");
			tabla.setModel(modelo.obtenerInmuebles());
		}
		else if(event.getSource()==mostrarInventariosBoton){
			System.out.println("mostrar inventarios");
			//tabla.setModel(modelo.obtenerInventarios());
		}
	}
}
