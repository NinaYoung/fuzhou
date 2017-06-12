package dataTool;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ByKey implements DataProviderFilter {

	@Override
	public List<Object> filter(List<Object> list, String parameter) {
		// TODO Auto-generated method stub
		String[] parameters = parameter.split("\\|");

        String[] keys = parameters[0].split("\\.");
        String[] values = Arrays.copyOfRange(parameters, 1, parameters.length);

        List<Object> tmpList = new ArrayList<Object>();

        for (Object object : list) {
            for(String value : values) {

                Class<?> currentClass = object.getClass();
                do {
                    try {
                        Method method = currentClass.getDeclaredMethod("getId");

                    } catch (Exception e) {
                        // NOSONAR
                    }
                } while ((currentClass = currentClass.getSuperclass()) != null);
     
              try {
                    Field field = null;

                    Object obj = object;
                    for (String key : keys) {
                        if (field != null) {
                            field.setAccessible(true);

                            obj = field.get(obj);
                        }
                        field = getField(obj.getClass(), key);
                    }
                    
                    field.setAccessible(true);

                    Object currentValue = field.get(obj);

                    if (currentValue != null && currentValue.toString().equals(value)) {
                        tmpList.add(object);
                    }
                } catch (NullPointerException | IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return tmpList;
    }

    private static Field getField(Class<?> currentClass, String name) {
        do {
            try {
                Field field = currentClass.getDeclaredField(name);
                return field;
            } catch (Exception e) {
                // NOSONAR
            }

        } while ((currentClass = currentClass.getSuperclass()) != null);

        return null;
    }
}

