package papeleria.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import papeleria.controladores.ControladorArticulo;
import papeleria.controladores.ControladorProveedor;
import papeleria.entities.Articulo;
import papeleria.entities.Proveedor;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class PanelProveedor extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfCIF;
	private JTextField jtfFecha;
	private JComboBox<String> jcbNacionalidad;
	private JCheckBox jchkbActivo;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private ButtonGroup jBGroup;
	private JRadioButton jrbIvaExento;
	private JRadioButton jrbIva4;
	private JRadioButton jrbIva10;
	private JRadioButton jrbIva21;
	
	private PanelArticulo panelArticulo;
	private JDialog jd;

	/**
	 * Create the panel.
	 */
	public PanelProveedor(PanelArticulo panelArticulo, JDialog jd) {
		
		this.panelArticulo = panelArticulo;
		this.jd = jd;
		
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btnSave = new JButton("Guardar");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnSave.setIcon(new ImageIcon(PanelProveedor.class.getResource("/papeleria/res/guardar.png")));
		toolBar.add(btnSave);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Gestión de Proveedor");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		jtfId.setFont(new Font("Dialog", Font.PLAIN, 15));
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("CIF:");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 2;
		panel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		jtfCIF = new JTextField();
		jtfCIF.setFont(new Font("Dialog", Font.PLAIN, 15));
		jtfCIF.setColumns(10);
		GridBagConstraints gbc_jtfCIF = new GridBagConstraints();
		gbc_jtfCIF.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCIF.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCIF.gridx = 1;
		gbc_jtfCIF.gridy = 2;
		panel.add(jtfCIF, gbc_jtfCIF);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nacionalidad:");
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 0;
		gbc_lblNewLabel_1_2.gridy = 3;
		panel.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		jcbNacionalidad = new JComboBox<String>();
		jcbNacionalidad.setFont(new Font("Dialog", Font.PLAIN, 15));
		GridBagConstraints gbc_jcbNacionalidad = new GridBagConstraints();
		gbc_jcbNacionalidad.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNacionalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNacionalidad.gridx = 1;
		gbc_jcbNacionalidad.gridy = 3;
		panel.add(jcbNacionalidad, gbc_jcbNacionalidad);
		
		JLabel lblNewLabel_1_3 = new JLabel("Activo:");
		lblNewLabel_1_3.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3.gridx = 0;
		gbc_lblNewLabel_1_3.gridy = 4;
		panel.add(lblNewLabel_1_3, gbc_lblNewLabel_1_3);
		
		jchkbActivo = new JCheckBox("");
		jchkbActivo.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_jchkbActivo = new GridBagConstraints();
		gbc_jchkbActivo.anchor = GridBagConstraints.WEST;
		gbc_jchkbActivo.insets = new Insets(0, 0, 5, 0);
		gbc_jchkbActivo.gridx = 1;
		gbc_jchkbActivo.gridy = 4;
		panel.add(jchkbActivo, gbc_jchkbActivo);
		
		JLabel lblNewLabel_1_4 = new JLabel("Fecha de alta:");
		lblNewLabel_1_4.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_4 = new GridBagConstraints();
		gbc_lblNewLabel_1_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_4.gridx = 0;
		gbc_lblNewLabel_1_4.gridy = 5;
		panel.add(lblNewLabel_1_4, gbc_lblNewLabel_1_4);
		
		jtfFecha = new JTextField();
		jtfFecha.setFont(new Font("Dialog", Font.PLAIN, 15));
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 5;
		panel.add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);
		
		JLabel lblNewLabel_1_5 = new JLabel("Tipo de IVA:");
		lblNewLabel_1_5.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_5 = new GridBagConstraints();
		gbc_lblNewLabel_1_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_5.gridx = 0;
		gbc_lblNewLabel_1_5.gridy = 6;
		panel.add(lblNewLabel_1_5, gbc_lblNewLabel_1_5);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.WEST;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 6;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		jrbIvaExento = new JRadioButton("Exento");
		jrbIvaExento.setSelected(true);
		jrbIvaExento.setFont(new Font("Dialog", Font.PLAIN, 15));
		GridBagConstraints gbc_jrbIvaExento = new GridBagConstraints();
		gbc_jrbIvaExento.insets = new Insets(0, 0, 5, 5);
		gbc_jrbIvaExento.gridx = 0;
		gbc_jrbIvaExento.gridy = 0;
		panel_1.add(jrbIvaExento, gbc_jrbIvaExento);
		
		jrbIva10 = new JRadioButton("10%");
		jrbIva10.setFont(new Font("Dialog", Font.PLAIN, 15));
		GridBagConstraints gbc_jrbIva10 = new GridBagConstraints();
		gbc_jrbIva10.insets = new Insets(0, 0, 5, 0);
		gbc_jrbIva10.gridx = 1;
		gbc_jrbIva10.gridy = 0;
		panel_1.add(jrbIva10, gbc_jrbIva10);
		
		jrbIva4 = new JRadioButton("4%");
		jrbIva4.setFont(new Font("Dialog", Font.PLAIN, 15));
		GridBagConstraints gbc_jrbIva4 = new GridBagConstraints();
		gbc_jrbIva4.anchor = GridBagConstraints.WEST;
		gbc_jrbIva4.insets = new Insets(0, 0, 0, 5);
		gbc_jrbIva4.gridx = 0;
		gbc_jrbIva4.gridy = 1;
		panel_1.add(jrbIva4, gbc_jrbIva4);
		
		jrbIva21 = new JRadioButton("21%");
		jrbIva21.setFont(new Font("Dialog", Font.PLAIN, 15));
		GridBagConstraints gbc_jrbIva21 = new GridBagConstraints();
		gbc_jrbIva21.gridx = 1;
		gbc_jrbIva21.gridy = 1;
		panel_1.add(jrbIva21, gbc_jrbIva21);
		
		// Creamos el ButtonGroup.
		jBGroup = new ButtonGroup();
		jBGroup.add(jrbIvaExento);
		jBGroup.add(jrbIva4);
		jBGroup.add(jrbIva10);
		jBGroup.add(jrbIva21);

		// Cargamos las nacionalidades.
		loadNacionalidades();
		
		// Mostramos la información del Articulo seleccionado.
		showProveedor();
		
	}
	
	private void guardar() {
		///PROCESO DE GUARDADO///
		Proveedor p = new Proveedor();
		
		p.setId(Integer.parseInt(this.jtfId.getText()));
		p.setCif(this.jtfCIF.getText());
		p.setNacionalidad((String) this.jcbNacionalidad.getSelectedItem());
		p.setActivo(this.jchkbActivo.isSelected());
		
		String str = this.jtfFecha.getText();
		if (!str.trim().equals("")) {
			try {
				p.setFechaAlta(sdf.parse(this.jtfFecha.getText()));
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null,
						"Error. La fecha de alta debe tener el siguiente formato: dd/MM/yyyy");
				return;
			}
		} else {
			p.setFechaAlta(null);
		}
		
		if (this.jrbIvaExento.isSelected()) {
			p.setIva(0);
		} else if (this.jrbIva4.isSelected()) {
			p.setIva(4);
		} else if (this.jrbIva10.isSelected()) {
			p.setIva(10);
		} else {
			p.setIva(21);
		}
		
		// Efectuamos el guardado.
		ControladorProveedor.getInstance().updateProveedor(p);
		
		// Actualizamos los datos del PanelArticulo.
		// Al cerrar el JDialog, volvemos a cargar a los proveedores.
		// A continuación, mostramos el registro que teniamos seleccionado.
		// De esta manera, podemos observar el cambio en tiempo real 
		// del JComboBox de Proveedores.
		this.jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.jd.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				panelArticulo.loadAllProveedores();
				
				int idArticuloActual = Integer.parseInt(panelArticulo.getJtfId().getText());
				Articulo a = (Articulo) ControladorArticulo
						.getInstance().findById(idArticuloActual);
				panelArticulo.showArticulo(a);
			}
		});
	}
	
	/**
	 * 
	 * @param idProveedor
	 */
	private void showProveedor() {
		
		Proveedor p = (Proveedor) this.panelArticulo.jcbProveedor
				.getSelectedItem();
		
		if (p != null) {
			this.jtfId.setText("" + p.getId());
			this.jtfCIF.setText(p.getCif());
			
			for (int i = 0; i < this.jcbNacionalidad.getItemCount(); i++) {
				if (this.jcbNacionalidad.getItemAt(i).equals(p.getNacionalidad())) {
					this.jcbNacionalidad.setSelectedIndex(i);
				}
			}
			
			this.jchkbActivo.setSelected(p.isActivo());
			this.jtfFecha.setText(sdf.format(p.getFechaAlta()));
			
			switch (p.getIva()) {
			case 0:
				this.jrbIvaExento.setSelected(true);
				break;
			case 4:
				this.jrbIva4.setSelected(true);
				break;
			case 10:
				this.jrbIva10.setSelected(true);
				break;
			case 21:
				this.jrbIva21.setSelected(true);
				break;
			}
			
		}
	}
	
	/**
	 * 
	 */
	private void loadNacionalidades() {
		this.jcbNacionalidad.addItem("España");
		this.jcbNacionalidad.addItem("Extranjero");
		this.jcbNacionalidad.setSelectedIndex(0);
	}

}
