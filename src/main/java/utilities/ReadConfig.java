package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class ReadConfig {

		
		public static Properties pro = new Properties();
		
		public static String ReadPropertiesData(String data) {
			File f = new File(FilePath.propertiesPath);
			FileInputStream fil = null;
			try {
				fil = new FileInputStream(f);
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				pro.load(fil);
			} catch (IOException e) {
				e.printStackTrace();
				
			}
			
			String dATA = pro.getProperty(data);
			return dATA;
		}
		
		public static String userName() {
			String bname = ReadPropertiesData("username");
			return bname;
		}
		
		public static String passWord() {
			String url = ReadPropertiesData("password");
			return url;
		}

	}

