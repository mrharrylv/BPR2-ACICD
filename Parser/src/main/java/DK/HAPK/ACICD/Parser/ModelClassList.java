package DK.HAPK.ACICD.Parser;

import DK.HAPK.ACICD.Parser.ModelExamples.Company;
import DK.HAPK.ACICD.Parser.ModelExamples.Company2;

import java.util.ArrayList;
import java.util.List;

public class ModelClassList {
    private List<Class> modelClassList = new ArrayList<>();

    public ModelClassList() {
        modelClassList.add(Company.class);
        modelClassList.add(Company2.class);
    }

    public Class getObjectByName(Object selectedItem) {
        for (Class c : modelClassList) {
            if (c.getName().equals(selectedItem)) {
                return c;
            }
        }
        return null;
    }

    public List<Class> getModelClassList() {
        return modelClassList;
    }
}
