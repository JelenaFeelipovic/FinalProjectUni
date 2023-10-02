/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formsKlijent;

import domain.Klijent;
import forms.MainForm;
import tableModels.KlijentiTableModel;

/**
 *
 * @author Jela
 */
public class PretragaKlijentaForm extends javax.swing.JDialog
{

    public PretragaKlijentaForm(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
	KlijentiTableModel ktm = new KlijentiTableModel();
	Thread thread = new Thread(ktm);
	thread.start();
	tblKlijenti.setModel(ktm);
	setTitle("Pretraga klijenata");
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKlijenti = new javax.swing.JTable();
        txtPretraga = new javax.swing.JTextField();
        btnInfoKlijenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("Pretraga (naziv firme):");

        tblKlijenti.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblKlijenti);

        txtPretraga.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtPretragaActionPerformed(evt);
            }
        });
        txtPretraga.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txtPretragaKeyReleased(evt);
            }
        });

        btnInfoKlijenta.setBackground(new java.awt.Color(51, 153, 255));
        btnInfoKlijenta.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnInfoKlijenta.setForeground(new java.awt.Color(255, 255, 255));
        btnInfoKlijenta.setText("Informacije o izabranom klijentu");
        btnInfoKlijenta.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnInfoKlijentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPretraga))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(btnInfoKlijenta, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInfoKlijenta, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPretragaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPretragaKeyReleased
        String parametar = txtPretraga.getText();
	((KlijentiTableModel) tblKlijenti.getModel()).setParametar(parametar);
    }//GEN-LAST:event_txtPretragaKeyReleased

    private void btnInfoKlijentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoKlijentaActionPerformed

        int row = tblKlijenti.getSelectedRow();

        if (row >= 0) {
	    Klijent k = ((KlijentiTableModel) tblKlijenti.getModel()).getSelectedKlijent(
		    row);
	    new InfoKlijentaForm(this, rootPaneCheckingEnabled, k).setVisible(
		    true);
        }

    }//GEN-LAST:event_btnInfoKlijentaActionPerformed

    private void txtPretragaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtPretragaActionPerformed
    {//GEN-HEADEREND:event_txtPretragaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPretragaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInfoKlijenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKlijenti;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables

    void refreshTable() {
	KlijentiTableModel tm = (KlijentiTableModel) tblKlijenti.getModel();
        tm.refreshTable();
    }

    void popuniKlijente() {
        MainForm mf = (MainForm) getParent();
        mf.popuniKlijente();
    }

}