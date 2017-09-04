package dataTool;

import java.util.List;

public class ById implements DataProviderFilter {

	//@Override
	public List<Object> filter(List<Object> list, String parameter) {
		// TODO Auto-generated method stub
        ByKey byKey = new ByKey();
        
        return byKey.filter(list, "id|" + parameter);
	}

}
