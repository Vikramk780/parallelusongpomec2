package ApphaUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	Properties prop;
	
	public Properties init_properties() throws IOException {
		prop = new Properties();
		
		FileInputStream file = new FileInputStream("./config.properties");
		
		prop.load(file);
		return prop;
	}

}
