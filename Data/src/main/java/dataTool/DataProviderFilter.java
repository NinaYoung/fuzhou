package dataTool;

import java.util.List;

public interface DataProviderFilter {

	 List<Object> filter(List<Object> list, String parameter);
}
