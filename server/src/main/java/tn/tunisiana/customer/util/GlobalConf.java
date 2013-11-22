package tn.tunisiana.customer.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class GlobalConf {
	static Properties properties = new Properties();
	private static String localisation;
	private static ClassLoader loader;
	static {
		try {
			loader = GlobalConf.class.getClassLoader();
			if (loader == null)
				loader = ClassLoader.getSystemClassLoader();

			String propFile = "conf/global.properties";
			java.net.URL url = loader.getResource(propFile);
			properties.load(url.openStream());

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static String getLocalisation() {
		localisation = properties.getProperty("localisation");
		return localisation;
	}

	public void saveConf() {

		properties.setProperty("localisation", localisation);
	}

	public static List<String> getGouvernorats() {
		String propFile = "conf/gouvern.txt";
		java.net.URL url = loader.getResource(propFile);
		List<String> gouvsList = new ArrayList<String>();

		File gouvs;
		try {
			gouvs = new File(url.toURI());

			Scanner s = new Scanner(gouvs);

			while (s.hasNext()) {
				gouvsList.add(s.next());
			}
			s.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (URISyntaxException e1) {

			e1.printStackTrace();
		}
		return gouvsList;
	}
}
