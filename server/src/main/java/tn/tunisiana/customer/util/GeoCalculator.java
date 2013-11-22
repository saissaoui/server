package tn.tunisiana.customer.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class GeoCalculator {

	public int distance(String origin, String destination) {
//		ObjectMapper m = new ObjectMapper();
//
//		JsonNode rootNode;
//		Long distance = -1L;
//		String url = "http://maps.googleapis.com/maps/api/distancematrix/json?origins="
//				+ origin
//				+ "&destinations="
//				+ destination
//				+ "&mode=driving&language=fr-FR&sensor=false";
//
//		System.out.println(url);
//
//		try {
//			
//			URL myURL = new URL(url);
//			URI myURI = new URI(myURL.getProtocol(), myURL.getHost(),
//					myURL.getPath(), myURL.getQuery(), myURL.getRef());
//		
//			
//			WebClient client = WebClient.create(myURI);
//			String resp = client.accept("text/xml").get(String.class);
//
//		
//			File json = new File("json");
//
//			FileOutputStream fop = new FileOutputStream(json);
//			fop.write(resp.getBytes());
//			fop.close();
//		
//			rootNode = m.readTree(json);
//			json.delete();
//			JsonNode distanceNode = ((rootNode.path("rows"))
//					.findValues("elements").get(0)).findValue("distance").get(
//					"value");
//			distance = distanceNode.asLong();
//
//		} catch (JsonProcessingException e) {
//
//			e.printStackTrace();
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return distance;
	return 1;
	}

}
