package dataTool;

import java.util.List;

import dataTool.DataConfig.DataConfigProperty;

public class DataProviderFilterUtils {

    public static List<Object> filter(List<Object> list) throws ReflectiveOperationException {
        
        if(DataConfig.getConfigProperty(DataConfigProperty.DATAPROVIDER_FILTER).equals(""))
            return list;
        //src.main.java.
        String default_package = "dataTool";
        String[] filters = DataConfig.getConfigProperty(DataConfigProperty.DATAPROVIDER_FILTER).split(";");
        
        for(String filter : filters) {
            String[] values = filter.trim().split("\\(");
            
            String method = values[0];
            String parameter = values[1].replaceAll("\\)", "");
            
            try {
                DataProviderFilter filterClass = (DataProviderFilter) Class.forName(default_package + ".By" + method.substring(0, 1).toUpperCase() + method.substring(1, method.length())).newInstance();
                
                list = filterClass.filter(list, parameter);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                throw e;
            }
        }
       
        return list;
    }
    
}