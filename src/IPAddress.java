import java.util.stream.Stream;

public class IPAddress {
	private String addressString;
	private String[] addressBinary;
	private String[] maskBinary;
	
	public IPAddress(){
		addressString = "";
		addressBinary = null;
		maskBinary = null;
	}
	
	public IPAddress(String addr){
		this.addressString = addr;
		this.addressBinary = addressToBinary(addr.split("/")[0]);
		if(addr.contains("/")) {
			this.maskBinary = maskToBinary(Integer.parseInt(addr.split("/")[1]));
		}else {
			this.maskBinary = null;
		}
	}
	
	public String[] addressToBinary(String addr) {
		int [] v = Stream.of(addr.split("\\."))
				  .mapToInt(Integer::parseInt)
				  .toArray();
		String[] binaryRep = new String[4];
		for(int x = 0; x <4; x++) {
			binaryRep[x] = String.format("%8s",Integer.toBinaryString(v[x])).replace(' ', '0'); 	
		}	
		return binaryRep;
	}
	
	public String[] maskToBinary(int mask) {
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
	
	public String getAddressString() {
		return addressString;
	}
	
	public String[] getAddressBinary() {
		return addressBinary;
	}
	
	public String[] getMaskBinary() {
		return maskBinary;
	}
	
}
