
public class Table {
	IPAddress Address[];
	String Hop[];
	
	public Table() {
		Address = null;
		Hop = null;
	}
	
	/**
	 * Table
	 * @param addr - Array of Strings of Addresses with Mask
	 * @param inHop - Hop String Array
	 */
	public Table(String[] addr, String[] inHop) {
		Address = new IPAddress[addr.length];
		Hop = new String[inHop.length];
		for(int x = 0; x < addr.length; x++) {
			Address[x] = new IPAddress(addr[x]);
			Hop[x] = inHop[x];
		}
		//default won't have ipAddr, adding here
		Hop[inHop.length-1] = inHop[inHop.length-1];
	}	
	/**
	 * router
	 * @param addr - IPAddress to route
	 * @return index of sent address
	 */
	public int router(IPAddress addr) {
		String[] newS = new String[4];
		boolean accepted = true;
		for(int x = 0; x < this.Address.length; x++) {
			for(int z = 0; z<4; z++) {
				newS[z] = "";
				for(int y = 0; y<8; y++) {
					if(addr.getAddressBinary()[z].substring(y, y+1).contains(this.getAddress()[x].getMaskBinary()[z].substring(y, y+1))) {
						newS[z] += (addr.getAddressBinary()[z].substring(y, y+1));
					}else {
						newS[z] += "0";
					}
				}
				if (!newS[z].equals(this.getAddress()[x].getAddressBinary()[z])) {
					accepted = false;
				}
			}
			if(accepted){
				return x;
			}else {
				accepted = true;
			}
		}
		//default
		return 3;

	}

	public IPAddress[] getAddress() {
		return Address;
	}
	
	public String[] getHop() {
		return Hop;
	}
	
	public IPAddress getAddress(int x) {
		if(x != this.Address.length) {
			return this.Address[x];
		}else {
			return null;
		}
	}
	
	public String getHop(int x) {
		return this.Hop[x];
	}
	
	
}
