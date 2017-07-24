package dataTool;

import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;


import basicClass.AbstractData;
import dataTool.DataConfig.DataConfigProperty;

public class DataFactory {

//	public static Map getData(String path) throws FileNotFoundException{
//		
//
//		Yaml yaml = new Yaml();
//		
//		File file = new File("src/test/source/com.octa.fuzhou.yaml." + path + ".yaml");
//		
//		Map results = (Map) yaml.load(new FileInputStream(file));
//		
//		return results;
//	}
	
	
	
	public static Object[][] getData(Class<? extends AbstractData> classObject,  String path){
		
		Constructor constructor = new Constructor(classObject);
		
		if(!DataConfig.getConfigProperty(DataConfigProperty.DATAPROVIDER_APPENDIX).isEmpty()) {
            path += "-" + DataConfig.getConfigProperty(DataConfigProperty.DATAPROVIDER_APPENDIX);
        }
		
		DataFileSystemResource resource = new DataFileSystemResource(
				//DataConfig.getConfigProperty(DataConfigProperty.DATAPROVIDER_FOLDER) + "/" + path + ".yaml");
		        DataConfig.getConfigProperty(DataConfigProperty.DATAPROVIDER_FOLDER) + path + ".yaml");
		
		
        Yaml yaml = new Yaml(constructor);
		
		Iterable<Object> data = yaml.loadAll(resource.getInputStream());
		
		List<Object> list = IteratorUtils.toList(data.iterator());
		
		try {
			list = DataProviderFilterUtils.filter(list);
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		Object[][] returnData = new Object[list.size()][1];
		
		for(int i = 0; i <list.size(); i++){
			
			Object object = list.get(i);
			returnData[i][0] = object;
			
		}
		
		return returnData;
		
	}
	
}
