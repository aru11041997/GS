import java.util.LinkedHashMap;
import java.util.Map;

public class ApacheLogPattern {

	public static void main(String[] args) {
		
		String[] lines1 = { 
				"10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
				"10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
				"10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234"
			 };
		
		String[] lines2 = { 
				"10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
				"10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
				"10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
				"10.0.0.2 - nancy [10/Dec/2000:12:34:59 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
				"10.0.0.3 - logan [10/Dec/2000:12:34:59 -0500] \"GET /d.gif HTTP/1.0\" 200 234" };
		
		System.out.println(findTopIpaddress(lines1));
		System.out.println(findTopIpaddress(lines2));
		System.out.println(findTopIpaddress(null));
	}

	private static String findTopIpaddress(String[] lines) {
		String output = "";
		if (lines==null||lines.length == 0)
			return output;

		Map<String, Integer> ipAddresses = new LinkedHashMap<>();
		for (int i = 0; i < lines.length; i++) {
			String ipAddress = lines[i].split(" ")[0];
			if (ipAddresses.containsKey(ipAddress))
				ipAddresses.put(ipAddress, ipAddresses.get(ipAddress) + 1);
			else
				ipAddresses.put(ipAddress, 1);
		}
		int maxValue = 0;
		for (String ipAddress : ipAddresses.keySet()) {
			maxValue = Math.max(maxValue, ipAddresses.get(ipAddress));
			if (ipAddresses.get(ipAddress) == maxValue) {
				if (output.equals(""))
					output += ipAddress;
				else
					output += ", " + ipAddress;
			}
		}
		return output;
	}
}
