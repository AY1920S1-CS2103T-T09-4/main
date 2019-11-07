package seedu.address.logic.graphs;

import java.util.List;

import seedu.address.logic.GraphWithPreamble;
import seedu.address.model.Model;
import seedu.address.model.phone.Phone;

public class CopyPhoneGraph extends GraphWithPreamble {

    public CopyPhoneGraph(Model model) {
        super(model);
    }

    @Override
    protected void build(Model model) {
        List<Phone> phoneList = model.getFilteredPhoneList();
        setDataList(phoneList);
    }

}
