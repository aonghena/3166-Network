import java.util.stream.Stream;

/**
 * A router has the following (CIDR) entries in its routing table:
Address/mask
135.46.56.0/22 135.46.60.0/22 192.53.40.0/23 default
Next hop
Interface 0 Interface 1 Router 1 Router 2
CHAP. 5 PROBLEMS 493 For each of the following IP addresses, what does the router do if a packet with that
address arrives?
(a) 135.46.63.10 (b) 135.46.57.14 (c) 135.46.52.2 (d) 192.53.40.7 (e) 192.53.56.7
 *
 */
public class Network {
	/**
	public static void main(String[] args) {
		String IPADDRESS = "135.46.63.10";
		
		//Routing Table
		String[] Address = new String[]{"135.46.56.0/22", "135.46.60.0/22", "192.53.40.0/23"};
		String[] Hop = new String[]{"Interface 0", "Interface 1", "Router 1", "Router 2 (DEFAULT) "};
		//
		
		for(int x = 0; x < 3; x++) {
			if(route(IPADDRESS, Address[x])){
				System.out.println(Hop[x]);
				break;
			}else if(x == 2) {
				System.out.print(Hop[3]);
			}
		}
			
}

	/**
	 * Compares IP Addresses to see if it should be routed there or not
	 * @param address - starting address
	 * @param address1 - address from table
	 * @return - True if yes, False if no
	 */
	public static boolean route(String address, String address1) {
		String[] addr = addressToBinary(address);
		String[] addr1 = addressToBinary(address1.split("/")[0]);
		String[] mask = maskToBinary(Integer.parseInt(address1.split("/")[1]));
		String[] newS = new String[4];
		for(int x = 0; x<4; x++){
			newS[x] = "";
			for(int y = 0; y<8; y++) {
				if(addr[x].substring(y, y+1).contains(mask[x].substring(y, y+1))) {
					newS[x] += addr[x].substring(y,y+1);				
				}else {
					newS[x] += "0";
				}
			}
			if (!newS[x].equals(addr1[x])) {
				return false;
			}
		}
		System.out.println("Address: " + address + " Binary rep:		" + ats(addr));
		System.out.println("Table Address: " + address1 + " Binary rep:	" + ats(addr1));
		System.out.println("Table Mask Binary Rep				" + ats(mask));
		System.out.println("Result of AND operation between mask and addr:  " +  ats(newS));

		return true;
		
	}
	
	/**
	 * 
	 * @param mask
	 * @return
	 */
	public static String[] maskToBinary(int mask) {
		String[] binaryRep = new String[4];
		for(int x = 0; x < 4; x++) {
			binaryRep[x] = "";
			for(int y = 0; y < 8; y++) {
				if(mask >0) {
					binaryRep[x]+="1";
				}else {
					binaryRep[x]+="0";
				}
				mask--;
			}
		}
		return binaryRep;
	}
	
	public static String[] addressToBinary(String addr) {
		System.out.println(addr);
		int [] v = Stream.of(addr.split("\\."))
				  .mapToInt(Integer::parseInt)
				  .toArray();
		String[] binaryRep = new String[4];
		for(int x = 0; x <4; x++) {
			binaryRep[x] = String.format("%8s",Integer.toBinaryString(v[x])).replace(' ', '0'); 	
		}	
		return binaryRep;
	}
	
	public static String ats(String[] addr) {
		return addr[0]+"."+addr[1]+"."+addr[2]+"."+addr[3];
	}
}
