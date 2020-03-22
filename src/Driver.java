
public class Driver {
	
	public static void main(String args[]) {
	Table t = new Table(new String[]{"135.46.56.0/22", "135.46.60.0/22", "192.53.40.0/23"}, 
			new String[]{"Interface 0", "Interface 1", "Router 1", "Router 2 (DEFAULT) "});
	
	IPAddress ad = new IPAddress("135.46.63.10");
	IPAddress ad1 = new IPAddress("135.46.57.14");
	IPAddress ad2 = new IPAddress("135.46.52.2");
	IPAddress ad3 = new IPAddress("192.53.40.7");
	IPAddress ad4 = new IPAddress("192.53.56.7");
	
	System.out.println(ad.getAddressString());
	System.out.println(t.getHop(t.router(ad)));
	System.out.println(t.getAddress(t.router(ad)));
	
		
	}
}
