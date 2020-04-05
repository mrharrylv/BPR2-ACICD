package DK.HAPK.ACICD.Parser.GUI;

import DK.HAPK.ACICD.Parser.CSVReader;
import DK.HAPK.ACICD.Parser.ModelClassList;
import DK.HAPK.ACICD.Parser.ModelExamples.Company;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class MainWindow extends JFrame {
    private JPanel mainPanel;
    private JComboBox comboBox1;
    private JButton selectFileButton;
    private JFormattedTextField txt_lineNumber;
    private JPanel tablePanel;
    private JButton saveParserButton;

    private ModelClassList modelClassList = new ModelClassList();
    private CSVReader csvReader = new CSVReader();

    private Map<String, Integer> objectFieldMap = new HashMap<>();
    private JComboBox comboFields;
    private JTable previewTable;
    private String[] fields;
    private Class classObj;

    public void run() {
        populateObjectComboBox();
        setupFrame();

        selectFileButton.addActionListener((ActionEvent e) -> {
            if(txt_lineNumber != null && objectFieldMap.isEmpty()) {
                String[] previewList = csvReader.fileSelector(Integer.parseInt(txt_lineNumber.getText()));
                classObj = modelClassList.getObjectByName(comboBox1.getSelectedItem());

                fields = new String[classObj.getFields().length];
                int i = 0;
                for (Field f : classObj.getFields()) {
                    objectFieldMap.put(f.getName(), i);
                    fields[i] = f.getName();
                    i++;
                }
                if (previewList != null) {
                    previewSetup(previewList, fields);
                }
            }
        });


        saveParserButton.addActionListener((ActionEvent e) -> {
            ArrayList<Integer> indexOrder = new ArrayList();
            for (int i = 0; i < previewTable.getRowCount(); i++) {
                indexOrder.add(objectFieldMap.get(previewTable.getModel().getValueAt(i, 1)));
                System.out.println("Row: <" + previewTable.getModel().getValueAt(i,0) +"> is <" + previewTable.getModel().getValueAt(i, 1) + ">");
            }

            //TODO not generic
            ArrayList<Company> listX = csvReader.createCompany(indexOrder);


            System.out.println("TEST " + listX.get(1).toString());


        });
    }

    private void populateObjectComboBox() {
        for ( Class c : modelClassList.getModelClassList() ) {
            comboBox1.addItem(c.getName());
        }
    }

    private void setupFrame() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        txt_lineNumber.setText("0");
        this.add(mainPanel);
    }

    private void previewSetup(String[] previewList, String[] fields) {
        previewTable = new JTable();
        tablePanel.add(previewTable);

        DefaultTableModel model = new DefaultTableModel();
        previewTable.setModel(model);
        model.addColumn("Data");
        model.addColumn("Object Field");

        for (int i = 0; i < previewList.length; i++) {
            model.addRow(new Object[0]);
            System.out.println(previewList[i]);
            model.setValueAt(previewList[i], i, 0);
            model.setValueAt(fields[i], i, 1);
        }

        previewTable.getColumnModel().getColumn(0).setPreferredWidth(350);
        previewTable.getColumnModel().getColumn(1).setPreferredWidth(100);

        comboFields = new JComboBox(fields);
        TableColumn columnEditor = previewTable.getColumnModel().getColumn(1);
        columnEditor.setCellEditor(new DefaultCellEditor(comboFields));
    }
}
