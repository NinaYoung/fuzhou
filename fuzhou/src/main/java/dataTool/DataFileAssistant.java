package dataTool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Preconditions;


public class DataFileAssistant {
	
	private DataFileAssistant() {

    }

	public static InputStream loadFile(String fileName) {
       
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream iStream = loader.getResourceAsStream(fileName);
        if (iStream == null) {
            try {
                iStream = new FileInputStream(fileName);
            } catch (FileNotFoundException e) { 
            }
        }
        if (iStream == null) {
            throw new IllegalArgumentException("[" + fileName + "] is not a valid resource");
        }
        
        return iStream;
    }
	
	public static InputStream loadFile(File file) {
        return loadFile(file.getAbsolutePath());
    }
	
	public static String readFile(String fileName) throws IOException {
        
        Preconditions.checkArgument(StringUtils.isNotBlank(fileName), "File name cannot be null (or) empty.");
        StringBuilder output = new StringBuilder();
        try (BufferedReader buffreader = new BufferedReader(new InputStreamReader(loadFile(fileName),
                Charset.forName("UTF-8")))) {
            String line = null;
            while ((line = buffreader.readLine()) != null) {
                output.append(line);
            }
        }
       
        return output.toString();
    }
	
	
}
