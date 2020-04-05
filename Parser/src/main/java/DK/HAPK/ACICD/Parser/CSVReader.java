package DK.HAPK.ACICD.Parser;

import DK.HAPK.ACICD.Parser.ModelExamples.Company;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private final String HARRY_DIR = "/_repo/intellij/BPR2-ACICD/Parser/";
    private final String userDir = System.getProperty("user.home") + HARRY_DIR;

    private int LINE_START = 0;

    private String[] currentLine;
    private ArrayList<String[]> data = new ArrayList<>();

    public String[] fileSelector(int lineNumber) {
        LINE_START = lineNumber;
        JFileChooser fc = new JFileChooser(userDir);
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String sourceName = fc.getSelectedFile().getAbsolutePath();
            return readDataFromCSV(sourceName);
        }
        return null;
    }

    private String[] readDataFromCSV(String fileName) {
        String line = "";
        String cvsSplitBy = ";";
        String[] preview = new String[0];
        int maxColumns = 0;
        int start = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                if (start >= LINE_START - 1) {
                    data.add(line.split(cvsSplitBy));

                    if (line.length() > maxColumns) {
                        maxColumns = line.length();
                        preview = line.split(cvsSplitBy);
                    }
                }
                start++;
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return preview;
    }

    public ArrayList<Company> createCompany(ArrayList<Integer> indexOrder) {
        ArrayList<Company> companyList = new ArrayList<>();

        for (String[] line : data) {
            String IC_DPH = line[indexOrder.get(0)];
            String ICO = line[indexOrder.get(1)];
            String NAZOV_DS = line[indexOrder.get(2)];
            String OBEC = line[indexOrder.get(3)];
            String ULICA_CISLO = line[indexOrder.get(4)];
            String PSC = line[indexOrder.get(5)];
            String STAT = line[indexOrder.get(6)];
            String DRUH_REG_DPH = line[indexOrder.get(7)];
            String DATUM_REG = line[indexOrder.get(8)];

            String DATUM_ZMENY_DRUHU_REG = null;
            if ( indexOrder.size() > 9)
            DATUM_ZMENY_DRUHU_REG = line[indexOrder.get(9)];

            companyList.add(new Company(IC_DPH, ICO, NAZOV_DS, OBEC, ULICA_CISLO, PSC, STAT, DRUH_REG_DPH, DATUM_REG, DATUM_ZMENY_DRUHU_REG));
        }
        return companyList;
    }

}
