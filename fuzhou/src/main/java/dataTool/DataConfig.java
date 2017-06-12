package dataTool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.junit.validator.PublicClassValidator;

public class DataConfig {

	private static XMLConfiguration config = null;
    private static final String CONFIG_LOCATION = "DataConfig.xml";
    private static String configLocatiton = CONFIG_LOCATION;
    
    private DataConfig() {
        
    }

    public static void setConfigLocation(String location) {
        configLocatiton = location;
        initConfig();
    }

    /**
     * Reads and parses configuration file Initializes the configuration,
     * reloading all data
     */
    public synchronized static void initConfig() {
        Map<DataConfigProperty, String> initialValues = new HashMap<DataConfigProperty, String>();

        initConfig(initialValues);
    }


    public synchronized static void initConfig(Map<DataConfigProperty, String> initialValues) {
        
        config = new XMLConfiguration();
        config.setThrowExceptionOnMissing(false);
        config.setAutoSave(false);
        
        

        DataConfigProperty[] configProps = DataConfigProperty.values();
        for (int i = 0; i < configProps.length; i++) {
            config.setProperty(configProps[i].getName(), configProps[i].getDefaultValue());
        }
        
        XMLConfiguration userConfig = null;
        try {
            userConfig = new XMLConfiguration(configLocatiton);
        } catch (ConfigurationException e) {
        } finally {
            if (userConfig != null) {
                Iterator<String> keys = userConfig.getKeys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    config.setProperty(key, userConfig.getString(key));
                }
            }
        }
    }   
    
    
    public static String getConfigProperty(DataConfigProperty configProperty) {
        loadValueAtFirstUsage(configProperty.getName());
        return DataConfig.getConfig().getString(configProperty.getName());
    }

    private static XMLConfiguration getConfig() {
        if(config==null) {
            initConfig();
        }
        return config;
    }

    private static void loadValueAtFirstUsage(String configProperty) {
        config = getConfig();
        
        if ((configProperty.equals(DataConfigProperty.DATAPROVIDER_FILTER.getName())) &&
                (config.getProperty(DataConfigProperty.DATAPROVIDER_FILTER.getName()) == null)) {
            
            loadValueAtFirstUsage(DataConfigProperty.DATAPROVIDER_FILTER.getName());
        }
        
        if ((configProperty.equals(DataConfigProperty.DATAPROVIDER_APPENDIX.getName())) &&
                (config.getProperty(DataConfigProperty.DATAPROVIDER_APPENDIX.getName()) == null)) {
            
            loadValueAtFirstUsage(DataConfigProperty.DATAPROVIDER_APPENDIX.getName());
        }
        
        if ((configProperty.equals(DataConfigProperty.DATAPROVIDER_FOLDER.getName())) &&
                (config.getProperty(DataConfigProperty.DATAPROVIDER_FOLDER.getName()) == null)) {
            
            loadValueAtFirstUsage(DataConfigProperty.DATAPROVIDER_FOLDER.getName());
        }
              
    }
    
    public static synchronized void setConfigProperty(DataConfigProperty configProperty, String configPropertyValue) {
        DataConfig.getConfig().setProperty(configProperty.getName(), configPropertyValue);
    }


    public static enum DataConfigProperty {
      
        DATAPROVIDER_FILTER("dataproviderFilter", ""),
    	DATAPROVIDER_APPENDIX("dataproviderAppendix", ""),
    	DATAPROVIDER_FOLDER("dataproviderFolder", "src/test/source/com.octa.fuzhou.yaml.");
    	
        private String name = null;
        private String defaultValue = null;
        private int intDefaultValue;

        private DataConfigProperty(String name, String defaultValue) {
            this.name = name;
            this.defaultValue = defaultValue;
        }

        private DataConfigProperty(String name, int intDefaultValue) {
            this.name = name;
            this.intDefaultValue = intDefaultValue;
        }

   
        public String getName() {
            return this.name;
        }

      
        public String getDefaultValue() {
            return this.defaultValue;
        }

        public int getIntDefaultValue() {
            return this.intDefaultValue;
        }
    }
}
