/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base_de_donnee;

import Application.BDD;
import Application.Parameter;
import Application.ResultSetTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author khaoula atig
 */
public final class Emprunt extends javax.swing.JFrame {

    /**
     * Creates new form Emprunt
     */
    ResultSet rs;
    BDD db;

    public Emprunt() throws SQLException {
        db = new BDD(new Parameter().HOST_DB, new Parameter().USERNAME_DB, new Parameter().PASSWORD_DB, new Parameter().IPHOST, new Parameter().PORT);
        initComponents();
        table();
      
        remplircombo2();
        remplircombo3();
    }

    public void table() {
        String a[] = {"idemprunte", "dateemp", "dateretour", "adherent", "idadherent", "idli"};
        rs = db.querySelect(a, "emprunt");
        emprunttable.setModel(new ResultSetTableModel(rs));
    }

    void actualiser() {
        idtext.setText("");
        dateemp.setText("");
        dateretour.setText("");
        role.setText("");

    }
    /*public void remplircombo(JComboBox bx) throws SQLException{
       String a[]={"idA","nom","prenom"};
       rs=db.querySelect(a, "enseignant");
       while(rs.next()){
           String id=String.valueOf(rs.getInt("idA"));
           //String name =rs.getString("nom");
           //String lastname =rs.getString("prenom");
           bx.addItem(id);
       }
       
    }*/
     
        
        public void remplircombo2() throws SQLException{
             enseignant.addItemListener(new ItemListener(){
                 @Override
                 public void itemStateChanged(ItemEvent e) {
                     if(enseignant.isSelected()){
                      
                        role.setText("enseignant");
                        jComboBox1.removeAllItems();
                        String a[]={"idA"};
                        rs=db.querySelect(a, "enseignant");
                         try {
                             while(rs.next()){
                                 String id=String.valueOf(rs.getInt("idA"));
                                 jComboBox1.addItem(id);
                             }} catch (SQLException ex) {
                             Logger.getLogger(Emprunt.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }  
                 }
                 
            });
              etudiant.addItemListener(new ItemListener(){
                 @Override
                 public void itemStateChanged(ItemEvent e) {
                     if(etudiant.isSelected()){
                      
                            role.setText("etudiant");
                            jComboBox1.removeAllItems();

                            String a[]={"idE"};
                            rs=db.querySelect(a, "etudiant");
                         try {
                             while(rs.next()){
                                 String id=String.valueOf(rs.getInt("idE"));
                                 jComboBox1.addItem(id);
                             }    } catch (SQLException ex) {
                             Logger.getLogger(Emprunt.class.getName()).log(Level.SEVERE, null, ex);
                         }
                        }
                    }
            });
             
        }
       
        
    
     public void remplircombo3() throws SQLException{
        String a[]={"idL","titre","auteur"};
       rs=db.querySelect(a, "livre");
       while(rs.next()){
           String id=String.valueOf(rs.getInt("idL"));
           //String name =rs.getString("titre");
           //String lastname =rs.getString("auteur");
           jComboBox3.addItem(id);
          
       }
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        idlabel = new java.awt.Label();
        idtext = new java.awt.TextField();
        dateemplab = new java.awt.Label();
        dateemp = new java.awt.TextField();
        dateretourlab = new java.awt.Label();
        dateretour = new java.awt.TextField();
        emprunter = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        role = new javax.swing.JLabel();
        livrelab = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        adherentlab = new javax.swing.JLabel();
        enseignant = new javax.swing.JCheckBox();
        etudiant = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        emprunttable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        rech = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        label1.setText("Emprunts");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        idlabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        idlabel.setText("Id:");

        idtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idtextActionPerformed(evt);
            }
        });

        dateemplab.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        dateemplab.setText("date d'emprunt");

        dateretourlab.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        dateretourlab.setText("date de retour ");

        dateretour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateretourActionPerformed(evt);
            }
        });

        emprunter.setText("Emprunter");
        emprunter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emprunterActionPerformed(evt);
            }
        });

        jButton2.setText("Routourner");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        supprimer.setText("Supprimer ");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        livrelab.setText("livre");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        adherentlab.setText("Adherent");

        enseignant.setText("enseignant");
        enseignant.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                enseignantStateChanged(evt);
            }
        });

        etudiant.setText("etudiant");
        etudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etudiantActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(emprunter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(74, 74, 74)
                .addComponent(supprimer)
                .addGap(88, 88, 88))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dateretourlab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(idlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateemplab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(role, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(88, 88, 88)))
                            .addGap(45, 45, 45))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(livrelab, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(adherentlab, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dateemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(idtext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dateretour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox3, 0, 141, Short.MAX_VALUE))
                            .addComponent(enseignant))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etudiant))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idlabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateemplab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateretourlab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateretour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adherentlab)
                    .addComponent(enseignant)
                    .addComponent(etudiant))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(role)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(livrelab)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emprunter)
                    .addComponent(jButton2)
                    .addComponent(supprimer))
                .addGap(46, 46, 46))
        );

        emprunttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        emprunttable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emprunttableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(emprunttable);
        emprunttable.getAccessibleContext().setAccessibleName("");

        jLabel1.setText("ID Emprunt: ");

        jButton1.setText("recherhcer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Menu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(rech, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(207, 207, 207))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton3)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        label1.getAccessibleContext().setAccessibleName("");
        label1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idtextActionPerformed

    private void dateretourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateretourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateretourActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        // TODO add your handling code here:
        String id = String.valueOf(emprunttable.getValueAt(emprunttable.getSelectedRow(), 0));
        if (JOptionPane.showConfirmDialog(this, "est ce que tu es sure que tu veux suuprimer", "attention!!!",
                JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            db.queryDelete("emprunt", "idemprunte='" + id + "'");
        } else {
            return;
        }
        table();
        actualiser();
    }//GEN-LAST:event_supprimerActionPerformed

    private void emprunterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emprunterActionPerformed
        // TODO add your handling code here:
        if ( dateemp.getText().equals("") || role.getText().equals("")||jComboBox1.getSelectedObjects().equals("")  || jComboBox3.getSelectedObjects().equals("") ) {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
            String[] colon = {"dateemp","dateretour","adherent", "idadherent","idli"};
            String[] inf = {dateemp.getText(), dateretour.getText(),role.getText(),String.valueOf(jComboBox1.getSelectedItem()),String.valueOf(jComboBox3.getSelectedItem())};
            System.out.println(db.queryInsert("emprunt", colon, inf));
           table();
            actualiser();
        }
    }//GEN-LAST:event_emprunterActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        jComboBox1.getSelectedItem();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        jComboBox3.getSelectedItem();
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if ( dateemp.getText().equals("") ||dateretour.getText().equals("") || role.getText().equals("") || jComboBox1.getSelectedObjects().equals("")  || jComboBox3.getSelectedObjects().equals("") ) {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
            String[] colon = {"dateemp","dateretour","adherent", "idadherent","idli"};
            String[] inf = {dateemp.getText(), dateretour.getText(),role.getText(),String.valueOf(jComboBox1.getSelectedItem()),String.valueOf(jComboBox3.getSelectedItem())};
         
            System.out.println(db.queryUpdate("emprunt", colon, inf, "idemprunte='" + idtext.getText() + "'"));
            table();
            actualiser();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void emprunttableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emprunttableMouseClicked
        // TODO add your handling code here:
        idtext.setText(String.valueOf(emprunttable.getValueAt(emprunttable.getSelectedRow(), 0)));
        dateemp.setText((String)emprunttable.getValueAt(emprunttable.getSelectedRow(), 1));
        dateretour.setText((String)emprunttable.getValueAt(emprunttable.getSelectedRow(), 2));
        role.setText((String)(emprunttable.getValueAt(emprunttable.getSelectedRow(), 3)));
        
        if(role.getText().equals("etudiant")){
            enseignant.setSelected(false);
            etudiant.setSelected(true);
            //jComboBox1.setSelectedItem(String.valueOf(emprunttable.getValueAt(emprunttable.getSelectedRow(), 4)));
            
        }else{
             etudiant.setSelected(false);
            enseignant.setSelected(true);
            
            //jComboBox1.setSelectedItem(String.valueOf(emprunttable.getValueAt(emprunttable.getSelectedRow(), 4)));
        }
        
       jComboBox1.setSelectedItem(String.valueOf(emprunttable.getValueAt(emprunttable.getSelectedRow(), 4)));
        jComboBox3.setSelectedItem(String.valueOf(emprunttable.getValueAt(emprunttable.getSelectedRow(), 5)));
    }//GEN-LAST:event_emprunttableMouseClicked

    private void etudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etudiantActionPerformed
        // TODO add your handling code here:
        etudiant.isSelected();
    }//GEN-LAST:event_etudiantActionPerformed

    private void enseignantStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_enseignantStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_enseignantStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                  if (rech.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SVP entrer quelque chose");
        } else {
           
                rs = db.querySelectAll("emprunt", "idemprunte LIKE '%" + rech.getText() + "%' ");
                emprunttable.setModel(new ResultSetTableModel(rs));
               
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        accueil h= new accueil();
                h.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Emprunt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Emprunt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Emprunt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Emprunt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Emprunt().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Emprunt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adherentlab;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private java.awt.TextField dateemp;
    private java.awt.Label dateemplab;
    private java.awt.TextField dateretour;
    private java.awt.Label dateretourlab;
    private javax.swing.JButton emprunter;
    private javax.swing.JTable emprunttable;
    private javax.swing.JCheckBox enseignant;
    private javax.swing.JCheckBox etudiant;
    private java.awt.Label idlabel;
    private java.awt.TextField idtext;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JLabel livrelab;
    private javax.swing.JTextField rech;
    private javax.swing.JLabel role;
    private javax.swing.JButton supprimer;
    // End of variables declaration//GEN-END:variables

    private void toString(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
