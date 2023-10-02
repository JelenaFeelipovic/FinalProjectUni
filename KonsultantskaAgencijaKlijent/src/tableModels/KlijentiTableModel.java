/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModels;

import controller.ClientController;
import domain.Klijent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jela
 */
public class KlijentiTableModel extends AbstractTableModel implements Runnable
{

    private ArrayList<Klijent> lista;
    private String[] kolone = {"ID", "Naziv firme", "Industrija", "Grad", "Vlasnik", "Kontakt"};
    private String parametar = "";

    public KlijentiTableModel()
    {
        try {
            lista = ClientController.getInstance().getAllKlijent();
        } catch (Exception ex) {
	    Logger.getLogger(KlijentiTableModel.class.getName()).log(
		    Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Klijent k = lista.get(row);

        switch (column) {
            case 0:
                return k.getKlijentID();
            case 1:
                return k.getNazivFirme();
            case 2:
                return k.getIndustrija();
            case 3:
                return k.getGradFirme();
            case 4:
                return k.getImeVlasnika();
            case 5:
                return k.getKontakt();

            default:
                return null;
        }
    }

    public Klijent getSelectedKlijent(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
		Thread.sleep(5000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
	    Logger.getLogger(KlijentiTableModel.class.getName()).log(
		    Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllKlijent();
            if (!parametar.equals("")) {
                ArrayList<Klijent> novaLista = new ArrayList<>();
                for (Klijent k : lista) {
                    if (k.getNazivFirme().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(k);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
