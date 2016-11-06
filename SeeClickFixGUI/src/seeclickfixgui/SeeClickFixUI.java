/*
 * GUI class for SeeClickFix project
 * Written by Will Dower, using the NetBeans IDE to auto-generate much of
 * the trivial code
 * william.dower@yale.edu
 * 10/29/16
 */

package seeclickfixgui;

import java.util.ArrayList;

/**
 *
 * @author Will
 */
public class SeeClickFixUI extends javax.swing.JFrame {

    /**
     * Creates new form SeeClickFixUI
     */
    public SeeClickFixUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        issuesPopup = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        nfsLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        StartDateSelector = new datechooser.beans.DateChooserCombo();
        EndDateSelector = new datechooser.beans.DateChooserCombo();
        jScrollPane1 = new javax.swing.JScrollPane();
        AllNeighborhoods = new javax.swing.JList<>();
        AddNeighborhood = new javax.swing.JButton();
        RemoveNeighborhood = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        SelectedNeighborhoods = new javax.swing.JList<>();
        RunButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        issuesPopup.setTitle("Issues");
        issuesPopup.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        issuesPopup.setFocusable(false);
        issuesPopup.setIconImage(null);
        issuesPopup.setMinimumSize(new java.awt.Dimension(650, 500));
        issuesPopup.setPreferredSize(new java.awt.Dimension(650, 500));
        issuesPopup.setType(java.awt.Window.Type.POPUP);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Issue Type", "Total Issues", "Total Issue Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setFillsViewportHeight(true);
        jScrollPane2.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("<html>You are viewing the issues for these neighborhoods:");
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        nfsLabel.setText("jLabel5");
        nfsLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout issuesPopupLayout = new javax.swing.GroupLayout(issuesPopup.getContentPane());
        issuesPopup.getContentPane().setLayout(issuesPopupLayout);
        issuesPopupLayout.setHorizontalGroup(
            issuesPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(issuesPopupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(issuesPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(issuesPopupLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 39, Short.MAX_VALUE))
                    .addComponent(nfsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        issuesPopupLayout.setVerticalGroup(
            issuesPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(issuesPopupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(issuesPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(issuesPopupLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nfsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SeeClickFix", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        AllNeighborhoods.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Neighborhoods in New Haven", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        AllNeighborhoods.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Amity", "Annex", "Beaver Hills", "Dixwell", "Downtown", "Dwight", "East Rock", "East Shore", "Edgewood", "Fair Haven", "Fair Haven Heights", "Hill", "Long Wharf", "Newhallville", "Prospect Hill", "Quinnipiac Meadows", "West River", "West Rock", "Westville", "Wooster Square/Mill River" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        AllNeighborhoods.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AllNeighborhoods.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        jScrollPane1.setViewportView(AllNeighborhoods);

        AddNeighborhood.setText("Add Neighborhood");
        AddNeighborhood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNeighborhoodActionPerformed(evt);
            }
        });

        RemoveNeighborhood.setText("Remove Neighborhood");
        RemoveNeighborhood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveNeighborhoodActionPerformed(evt);
            }
        });

        jLabel1.setText("Please select the neighborhood(s) to test, and a date range.");

        SelectedNeighborhoods.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Neighborhood(s) Selected", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        SelectedNeighborhoods.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        jScrollPane3.setViewportView(SelectedNeighborhoods);

        RunButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RunButton.setText("Run!");
        RunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Start Date:");

        jLabel3.setText("End Date:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(419, 419, 419)
                        .addComponent(RunButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddNeighborhood)
                            .addComponent(StartDateSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(277, 277, 277)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RemoveNeighborhood)
                            .addComponent(EndDateSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddNeighborhood, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(RemoveNeighborhood, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StartDateSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EndDateSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(58, 58, 58)
                .addComponent(RunButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //for now, the Run button just prints the parameters the user has selected
    private void RunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RunButtonActionPerformed
        
        //these three lines are dummy values which will later be hooked up to
        //actual data from the database
        String[] issues = {"pothole","broken stoplight","abandoned car",
                           "graffiti","illegal dumping","godzilla attack"};
        int[] issueNum = { 4, 5, 3, 2, 6, 1};
        int[] issueTime = { 100, 200, 300, 400, 500, 100}; //this should be changed to whatever datatype time is stored in
        
        
        int size = SelectedNeighborhoods.getModel().getSize();
        String entry, startDate, endDate, neighborhoodFormattedString = "";
        ArrayList neighborhoods = new ArrayList(20);
        Object[][] obj = new Object[issues.length][3]; //for making the table in the popup
        
        //initialize the table 
        for(int i = 0; i < issues.length; i++) {
            obj[i][0] = issues[i];
            obj[i][1] = issueNum[i];
            obj[i][2] = issueTime[i];
        }
        
        //put together a string of all the selected neighborhoods
        for (int i = 0; i < size; i++) {
            entry = SelectedNeighborhoods.getModel().getElementAt(i);
            //System.out.print(" " + entry);]
            neighborhoods.add(entry);
            neighborhoodFormattedString += ( entry );
            if(i < size - 1 ) { neighborhoodFormattedString += ", "; }
        }
        
        //get the start and end dates
        startDate =  StartDateSelector.getText();
        endDate = EndDateSelector.getText();
        
        //debugging print statements
        System.out.println("You selected the neighborhoods: " + neighborhoods);
        System.out.println("You selected the date range: "
                + startDate + " to "
                + endDate);
        
        nfsLabel.setText("<html>" + neighborhoodFormattedString);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            /*new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            }*/obj,
            new String [] {
                "Issue Type", "Total Issues", "Total Issue Time"
            })
        ); 
        issuesPopup.setVisible(true);   
    }//GEN-LAST:event_RunButtonActionPerformed

    //pushing the add neighborhood button will grab the selected item from the 
    //list of all neighborhoods and add it to the list of selected ones
    private void AddNeighborhoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNeighborhoodActionPerformed
        String selected = AllNeighborhoods.getSelectedValue();
        if(selected == null) { return; } //the button was pressed, but nothing
                                         //was selected
        int size = SelectedNeighborhoods.getModel().getSize();
        String entry;       
        String[] allEntries = new String[size + 1];
        
        //build a list of everything currently in the selected list
        for (int i = 0; i < size; i++) {
            entry = SelectedNeighborhoods.getModel().getElementAt(i);
            //check to make sure the entry hasn't already been added
            if( entry.equals( selected ) ) { return; }
            allEntries[i] = entry;
        }
        //add the new neighborhood to the end of the list
        allEntries[size] = selected;
        //set the selected list to be the new updated version
        SelectedNeighborhoods.setListData( allEntries );
    }//GEN-LAST:event_AddNeighborhoodActionPerformed
    
    //removes the selected neighborhood from the selected list
    private void RemoveNeighborhoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveNeighborhoodActionPerformed
        String selected = SelectedNeighborhoods.getSelectedValue();
        if(selected == null) { return; } //the button was pressed, but nothing
                                         //was selected
        int size = SelectedNeighborhoods.getModel().getSize();
        String entry;       
        String[] newEntries = new String[size - 1];
        int offset = 0;
        //rebuild the list, skipping the selected value
        for (int i = 0; i < size; i++) {
            entry = SelectedNeighborhoods.getModel().getElementAt(i);
            if( entry.equals( selected ) ) { offset = 1; continue; }
            newEntries[i - offset] = entry;
        }
        
        
        
        //reset the list to the new version
        SelectedNeighborhoods.setListData( newEntries );
        
    }//GEN-LAST:event_RemoveNeighborhoodActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeeClickFixUI().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddNeighborhood;
    private javax.swing.JList<String> AllNeighborhoods;
    private datechooser.beans.DateChooserCombo EndDateSelector;
    private javax.swing.JButton RemoveNeighborhood;
    private javax.swing.JButton RunButton;
    private javax.swing.JList<String> SelectedNeighborhoods;
    private datechooser.beans.DateChooserCombo StartDateSelector;
    private javax.swing.JDialog issuesPopup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel nfsLabel;
    // End of variables declaration//GEN-END:variables
}
