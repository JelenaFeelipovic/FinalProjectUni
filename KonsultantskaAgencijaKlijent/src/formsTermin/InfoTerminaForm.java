/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formsTermin;

import controller.ClientController;
import domain.StavkaTermina;
import domain.Termin;
import domain.Usluga;
import forms.MainForm;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import tableModels.StavkeTableModel;

/**
 *
 * @author Jela
 */
public class InfoTerminaForm extends javax.swing.JDialog
{

    private Termin t;
    private double ukupnaCena;

    public InfoTerminaForm(JDialog parent, boolean modal, Termin t)
    {
        super(parent, modal);
        initComponents();
        this.t = t;
        setLocationRelativeTo(null);
	setTitle("Informacije o terminu");
        lblKlijent.setText(t.getKlijent().getNazivFirme());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        txtDatumVreme.setText(sdf.format(t.getDatumVreme()));
        ukupnaCena = t.getCenaTermina();
        txtCenaTermina.setEditable(false);
        txtCenaStavke.setEditable(false);
        txtCenaTermina.setText(String.valueOf(ukupnaCena) + "€");
        popuniUsluge();
	tblStavke.setModel(new StavkeTableModel(t));

        if (!t.getDatumVreme().after(new Date())) {
            txtDatumVreme.setEditable(false);
            cmbUsluga.setEnabled(false);
            btnDodaj.setEnabled(false);
            btnObrisi.setEnabled(false);
            btnOtkazi.setEnabled(false);
            btnIzmeni.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Ovaj termin je prosao, ne mozete ga menjati!");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDatumVreme = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        cmbUsluga = new javax.swing.JComboBox();
        txtCenaStavke = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        txtCenaTermina = new javax.swing.JTextField();
        btnOtkazi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        lblKlijent = new javax.swing.JLabel();
        btnZatvori = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos termina"));

        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("Klijent:");

        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("Datum i vreme konsultacija:");

        jLabel3.setForeground(new java.awt.Color(0, 102, 153));
        jLabel3.setText("Cena termina (€):");

        txtDatumVreme.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm"))));
        txtDatumVreme.setText("06.08.2023 10:00");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos stavki termina"));

        jLabel4.setForeground(new java.awt.Color(0, 102, 153));
        jLabel4.setText("Usluga:");

        jLabel5.setForeground(new java.awt.Color(0, 102, 153));
        jLabel5.setText("Cena:");

        btnDodaj.setForeground(new java.awt.Color(0, 102, 255));
        btnDodaj.setText("Dodaj stavku");
        btnDodaj.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setForeground(new java.awt.Color(0, 102, 255));
        btnObrisi.setText("Obrisi stavku");
        btnObrisi.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnObrisiActionPerformed(evt);
            }
        });

        cmbUsluga.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbUsluga.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                cmbUslugaItemStateChanged(evt);
            }
        });

        tblStavke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStavke);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmbUsluga, 0, 278, Short.MAX_VALUE)
                        .addComponent(txtCenaStavke))
                    .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbUsluga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCenaStavke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDodaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnObrisi)))
                .addContainerGap())
        );

        btnOtkazi.setBackground(new java.awt.Color(255, 255, 255));
        btnOtkazi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnOtkazi.setForeground(new java.awt.Color(0, 102, 255));
        btnOtkazi.setText("Otkazi termin");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnIzmeni.setBackground(new java.awt.Color(51, 153, 255));
        btnIzmeni.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnIzmeni.setForeground(new java.awt.Color(255, 255, 255));
        btnIzmeni.setText("Izmeni termin");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnIzmeniActionPerformed(evt);
            }
        });

        lblKlijent.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        btnZatvori.setBackground(new java.awt.Color(255, 255, 255));
        btnZatvori.setForeground(new java.awt.Color(0, 102, 255));
        btnZatvori.setText("Zatvori");
        btnZatvori.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnZatvoriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDatumVreme)
                            .addComponent(txtCenaTermina)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblKlijent, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(btnZatvori, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnIzmeni, btnOtkazi, btnZatvori});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblKlijent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDatumVreme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCenaTermina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOtkazi)
                    .addComponent(btnZatvori))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnIzmeni, btnOtkazi, btnZatvori});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnZatvoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZatvoriActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnZatvoriActionPerformed

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed

	int deleteYesNo = JOptionPane.showConfirmDialog(this,
		"Da li ste sigurni da zelite da otkazete ovaj termin?",
		"Konfirmacija", JOptionPane.YES_NO_OPTION);

	if (deleteYesNo == JOptionPane.NO_OPTION)
	{
            return;
        }

	if (deleteYesNo == JOptionPane.YES_OPTION)
	{
            try {
                ClientController.getInstance().deleteTermin(t);
		PretragaTerminaForm ptf = (PretragaTerminaForm) getParent();
		ptf.refreshTable();
		JOptionPane.showMessageDialog(this, "Uspesno obrisan termin!");
                this.dispose();
            } catch (Exception ex) {
		Logger.getLogger(InfoTerminaForm.class.getName()).log(
			Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed

        if (txtDatumVreme.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Morate uneti datum i vreme konsultacija!");
            return;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Date datumVreme = sdf.parse(txtDatumVreme.getText());

	    StavkeTableModel tm = (StavkeTableModel) tblStavke.getModel();

            t.setCenaTermina(ukupnaCena);
            t.setDatumVreme(datumVreme);
            t.setStavkeTermina(tm.getLista());

            ClientController.getInstance().updateTermin(t);
	    PretragaTerminaForm ptf = (PretragaTerminaForm) getParent();
	    ptf.refreshTable();
	    JOptionPane.showMessageDialog(this, "Uspesno izmenjen termin!");
            this.dispose();
        } catch (Exception ex) {
	    JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed

        Usluga usluga = (Usluga) cmbUsluga.getSelectedItem();

        StavkaTermina st = new StavkaTermina(t, -1, usluga.getCena(), usluga);

	StavkeTableModel tm = (StavkeTableModel) tblStavke.getModel();

        if (tm.postojiUsluga(usluga)) {
            JOptionPane.showMessageDialog(this, "Vec ste uneli ovu uslugu!");
            return;
        }

        tm.dodajStavku(st);

        ukupnaCena = tm.vratiUkupnuCenu();

        txtCenaTermina.setText(String.valueOf(ukupnaCena) + "€");
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        int row = tblStavke.getSelectedRow();

        if (row >= 0) {
	    StavkeTableModel tm = (StavkeTableModel) tblStavke.getModel();
            tm.obrisiStavku(row);

            ukupnaCena = tm.vratiUkupnuCenu();

            txtCenaTermina.setText(String.valueOf(ukupnaCena) + "€");
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void cmbUslugaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbUslugaItemStateChanged

        if (cmbUsluga.getSelectedItem() != null) {
            Usluga usluga = (Usluga) cmbUsluga.getSelectedItem();
            txtCenaStavke.setText(String.valueOf(usluga.getCena()) + "€");
        }
    }//GEN-LAST:event_cmbUslugaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnZatvori;
    private javax.swing.JComboBox cmbUsluga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKlijent;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtCenaStavke;
    private javax.swing.JTextField txtCenaTermina;
    private javax.swing.JFormattedTextField txtDatumVreme;
    // End of variables declaration//GEN-END:variables

    private void popuniUsluge() {
        try {
            ArrayList<Usluga> usluge = ClientController.getInstance().getAllUsluga();

            cmbUsluga.removeAllItems();

            for (Usluga usluga : usluge) {
                cmbUsluga.addItem(usluga);
            }
        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}