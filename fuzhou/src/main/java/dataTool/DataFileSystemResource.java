package dataTool;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;



public class DataFileSystemResource {
	private String pathName = null;
    private String fileName = null;
    private Class<?> cls = null;

    public DataFileSystemResource() {
    }
	
    public DataFileSystemResource(String pathName, String fileName, Class<?> cls) {
        super();
        setPathName(pathName);
        setFileName(fileName);
        setCls(cls);
    }

    public DataFileSystemResource(String fileName, Class<?> cls) {
        this(null, fileName, cls);
    }
    
    public DataFileSystemResource(String pathName, String fileName) {
        this(pathName, fileName, null);
    }

    public DataFileSystemResource(String fileName) {
        this(null, fileName, null);
    }
    
	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Class<?> getCls() {
		return cls;
	}

	public void setCls(Class<?> cls) {
		this.cls = cls;
	}
    
	public InputStream getInputStream() {
        InputStream is = null;
        
        if (this.pathName == null) {
            is = new BufferedInputStream(DataFileAssistant.loadFile(this.fileName));
        } else {
            File file = new File(this.pathName + this.fileName);
            is = new BufferedInputStream(DataFileAssistant.loadFile(file));
        }

        return is;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("FileSystemResource: [ ");
        str.append("pathName = " + this.getPathName() + ", ");
        str.append("fileName = " + this.getFileName() + ", ");
        str.append("class = " + this.getCls() + " ]");
        return str.toString();
    }
    
}
