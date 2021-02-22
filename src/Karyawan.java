
public class Karyawan {
	
	private String kode;
	private String nama;
	private String gender;
	private String jabatan;
	private int gaji;
	
	public Karyawan(String kode, String nama, String gender, String jabatan, int gaji) {
		super();
		this.kode = kode;
		this.nama = nama;
		this.gender = gender;
		this.jabatan = jabatan;
		this.gaji = gaji;
	}
	
	public String getKode() {
		return kode;
	}
	
	public void setKode(String kode) {
		this.kode = kode;
	}
	
	public String getNama() {
		return nama;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getJabatan() {
		return jabatan;
	}
	
	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}
	
	public int getGaji() {
		return gaji;
	}
	
	public void setGaji(int gaji) {
		this.gaji = gaji;
	}

}
