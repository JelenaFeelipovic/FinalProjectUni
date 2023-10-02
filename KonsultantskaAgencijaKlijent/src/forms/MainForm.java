/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import controller.ClientController;
import domain.Klijent;
import domain.Konsultant;
import domain.StavkaTermina;
import domain.Termin;
import domain.Usluga;
import formsKlijent.NoviKlijentForm;
import formsKlijent.PretragaKlijentaForm;
import formsTermin.PretragaTerminaForm;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import socket.Communication;
import tableModels.StavkeTableModel;

/**
 *
 * @author Jela
 */
public class MainForm extends javax.swing.JFrame {

    Konsultant ulogovani;
    double ukupnaCena;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        setLocationRelativeTo(null);
	this.ulogovani = Communication.getInstance().getUlogovani();
	lblUlogovani.setText("Zdravo, " + ulogovani + "!");
	setTitle("Glavna klijentska forma");
        popuniKlijente();
        popuniUsluge();
        txtCenaStavke.setEditable(false);
        txtCenaTermina.setEditable(false);
	tblStavke.setModel(new StavkeTableModel());
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

        lblUlogovani = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbKlijent = new javax.swing.JComboBox();
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
        btnSacuvaj = new javax.swing.JButton();
        txtCenaTermina = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        miNoviKlijent = new javax.swing.JMenuItem();
        miPretragaKlijenta = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        miPretragaTermina = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        miOdjava = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblUlogovani.setText("Ulogovani");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos termina"));
        jPanel1.setForeground(new java.awt.Color(0, 102, 153));
        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("Klijent:");

        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("Datum i vreme konsultacija:");

        jLabel3.setForeground(new java.awt.Color(0, 102, 153));
        jLabel3.setText("Cena termina (€):");

        cmbKlijent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        btnSacuvaj.setBackground(new java.awt.Color(51, 153, 255));
        btnSacuvaj.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnSacuvaj.setForeground(new java.awt.Color(255, 255, 255));
        btnSacuvaj.setText("Sacuvaj termin");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbKlijent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDatumVreme)
                                    .addComponent(txtCenaTermina))
                                .addContainerGap())))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbKlijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(btnSacuvaj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu6.setText("Klijent");

        miNoviKlijent.setText("Novi klijent");
        miNoviKlijent.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                miNoviKlijentActionPerformed(evt);
            }
        });
        jMenu6.add(miNoviKlijent);

        miPretragaKlijenta.setText("Pretraga klijenta");
        miPretragaKlijenta.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                miPretragaKlijentaActionPerformed(evt);
            }
        });
        jMenu6.add(miPretragaKlijenta);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Termin");

        miPretragaTermina.setText("Pretraga termina");
        miPretragaTermina.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                miPretragaTerminaActionPerformed(evt);
            }
        });
        jMenu7.add(miPretragaTermina);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("Odjava");

        miOdjava.setText("Odjavi se");
        miOdjava.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                miOdjavaActionPerformed(evt);
            }
        });
        jMenu8.add(miOdjava);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUlogovani))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUlogovani)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miNoviKlijentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNoviKlijentActionPerformed
	new NoviKlijentForm(this, true).setVisible(true);
    }//GEN-LAST:event_miNoviKlijentActionPerformed

    private void miPretragaKlijentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaKlijentaActionPerformed
	new PretragaKlijentaForm(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaKlijentaActionPerformed

    private void miPretragaTerminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaTerminaActionPerformed
	new PretragaTerminaForm(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaTerminaActionPerformed

    private void miOdjavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOdjavaActionPerformed

	int yesNo = JOptionPane.showConfirmDialog(this,
		"Da li ste sigurni da zelite da se odjavite?", "Konfirmacija", JOptionPane.YES_NO_OPTION);

	if (yesNo == JOptionPane.NO_OPTION)
	{
            return;
        }

	if (yesNo == JOptionPane.YES_OPTION)
	{
	    new LoginForm().setVisible(true);
	    Communication.getInstance().setUlogovani(null);
            this.dispose();
        }

    }//GEN-LAST:event_miOdjavaActionPerformed

    private void cmbUslugaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbUslugaItemStateChanged

        if (cmbUsluga.getSelectedItem() != null) {
            Usluga usluga = (Usluga) cmbUsluga.getSelectedItem();
            txtCenaStavke.setText(String.valueOf(usluga.getCena()) + "€");
        }

    }//GEN-LAST:event_cmbUslugaItemStateChanged

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed

        Usluga usluga = (Usluga) cmbUsluga.getSelectedItem();

        StavkaTermina st = new StavkaTermina(null, -1, usluga.getCena(), usluga);

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

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed

        try {
            if (txtDatumVreme.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Morate uneti datum i vreme konsultacija!");
                return;
            }

            Klijent klijent = (Klijent) cmbKlijent.getSelectedItem();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Date datumVreme = sdf.parse(txtDatumVreme.getText());

	    StavkeTableModel tm = (StavkeTableModel) tblStavke.getModel();

            Termin termin = new Termin(null, datumVreme, ukupnaCena,
                    klijent, ulogovani, tm.getLista());

            ClientController.getInstance().addTermin(termin);
            resetujFormu();
            JOptionPane.showMessageDialog(this, "Uspesno sacuvan termin!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }


    }//GEN-LAST:event_btnSacuvajActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbKlijent;
    private javax.swing.JComboBox cmbUsluga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUlogovani;
    private javax.swing.JMenuItem miNoviKlijent;
    private javax.swing.JMenuItem miOdjava;
    private javax.swing.JMenuItem miPretragaKlijenta;
    private javax.swing.JMenuItem miPretragaTermina;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtCenaStavke;
    private javax.swing.JTextField txtCenaTermina;
    private javax.swing.JFormattedTextField txtDatumVreme;
    // End of variables declaration//GEN-END:variables

    public void popuniKlijente() {
        try {
            ArrayList<Klijent> klijenti = ClientController.getInstance().getAllKlijent();

            cmbKlijent.removeAllItems();

            for (Klijent klijent : klijenti) {
                cmbKlijent.addItem(klijent);
            }

        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    private void resetujFormu() {
        txtDatumVreme.setText("");
        txtCenaTermina.setText("");
        ukupnaCena = 0;
	StavkeTableModel tm = (StavkeTableModel) tblStavke.getModel();
        tm.getLista().clear();
        tm.fireTableDataChanged();
    }

}
