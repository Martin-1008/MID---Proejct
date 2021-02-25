import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
	
	public Main() {
		Menu();
	}
	
	Scanner scan = new Scanner(System.in);
	ArrayList<Karyawan> listKaryawan = new ArrayList<>();
	
	
	void Clear() {
		for(int a = 0 ; a < 30; a++) {
			System.out.println("");
		}
	}
	
	void Menu() {
		int ChooseMenu;
		do {
			System.out.println("Data Karyawan");
			System.out.println("---------------------------------\n");
			System.out.println("1. Insert Data Karyawan");
			System.out.println("2. View Data Karyawan");
			System.out.println("3. Update Data Karyawan");
			System.out.println("4. Delete Data Karyawan");
			System.out.println("5. Exit");
			System.out.println("---------------------------------");
			ChooseMenu = scan.nextInt();
			scan.nextLine();
		}while(ChooseMenu < 1 || ChooseMenu > 5);
		
		switch(ChooseMenu) {
		case 1:
			Insert();
			break;
		case 2:
			View();
			break;
		case 3:
			Update();
			break;
		case 4:
			Delete();
			break;
		case 5:
			Clear();
			return;
		}
	}
	
	void Insert() {
		String kode, nama, gender, jabatan, bonus;
		char[] kode1 = new char[8]; 
		int gaji;
		int tambah;
		float tambahan;
		int count = 0;
		Clear();
		do {
			System.out.println("Input kode karyawan [MM-XXXX]:");
			System.out.println("M = UpperCase");
			System.out.println("X = Number");
			kode1 = scan.next().toCharArray();
		}while(!(kode1[2]=='-' && kode1[0]>='A'&&kode1[0]<='Z'
				&&kode1[1]>='A'&&kode1[1]<='Z'
				&&kode1[3]>='0'&&kode1[3]<='9'
				&&kode1[4]>='0'&&kode1[4]<='9'
				&&kode1[5]>='0'&&kode1[5]<='9'
				&&kode1[6]>='0'&&kode1[6]<='9'
				&&kode1.length==7));
		kode = String.valueOf(kode1);
		scan.nextLine();
		
		do {
			
			System.out.print("Input nama karyawan [>=3]:");
			nama = scan.nextLine();
			
		}while(nama.length()<3);
		
		do {
			System.out.print("Input jenis kelamin[Laki-laki | Perempuan](Case Sensitive):");
			gender = scan.nextLine();
		}while(!(gender.contentEquals("Laki-laki")||gender.contentEquals("Perempuan")));
		
		do {
			System.out.print("Input jabatan[Manager | Supervisor | Admin](Case Sensitive):");
			jabatan = scan.nextLine();
		}while(!(jabatan.contentEquals("Manager")||jabatan.contentEquals("Supervisor")||jabatan.contentEquals("Admin")));
		
		if(jabatan.contentEquals("Manager")) {
			gaji = 8000000;
		}else if(jabatan.contentEquals("Supervisor")) {
			gaji = 6000000;
		}else {
			gaji = 4000000;
		}
		
		Karyawan ambil = new Karyawan(kode,nama,gender,jabatan,gaji);
		listKaryawan.add(ambil);
		
		if(listKaryawan.size() > 1) {
			for(int i=0;i<listKaryawan.size()-1;i++) {
				if(listKaryawan.get(i).getJabatan().contentEquals(jabatan)) {
					count++;
				}
			}
		}
		System.out.println("Berhasil menambahkan karyawan dengan id " + kode);
		
		
		if(count >= 3 ) {
			count=0;
			if(jabatan.contentEquals("Manager")) {
				bonus = "10%";
				tambahan = (float)1/10;
			}else if(jabatan.contentEquals("Supervisor")) {
				bonus = "7.5%";
				tambahan = (float)75/1000;
			}else {
				bonus = "5%";
				tambahan = (float)5/100;
			}
			System.out.print("Bonus sebesar "+ bonus +" telah diberikan kepada karyawan dengan id ");
			for(int a = 0; a < listKaryawan.size()-1;a++ ) {
				if(listKaryawan.get(a).getJabatan().contentEquals(jabatan)) {
					tambah = listKaryawan.get(a).getGaji();
					tambah += tambah*tambahan;
					listKaryawan.get(a).setGaji(tambah);
					if(count!=0) {
						System.out.print(",");
					}
					System.out.print(listKaryawan.get(a).getKode());
					count++;
				}
			}
		}
		System.out.println("\nENTER to return");
		scan.nextLine();
		
		Menu();
	}
	
	void Sorting() {
		for(int i=0;i<listKaryawan.size();i++) {
			for(int j=listKaryawan.size()-1;j>0;j--) {
				if(listKaryawan.get(j-1).getNama().compareTo(listKaryawan.get(j).getNama())>0) {
					Collections.swap(listKaryawan, j-1, j);
				}
			}
		}
	}
	
	void ViewDetail() {
		Sorting();
		Clear();
		for(int i=1;i<=100;i++) {
			if(i==1||i==6||i==24||i==55||i==71||i==86) {
				System.out.print("|");
			}else if(i==100){
				System.out.println("|");
			}else {
				System.out.print("-");
			}
		}
		System.out.print("|No  |");
		System.out.print("Kode Karyawan    |");
		System.out.print("Nama Karyawan                 |");
		System.out.print("Jenis Kelamin  |");
		System.out.print("Jabatan       |");
		System.out.println("Gaji Karyawan|");
		for(int i=1;i<=100;i++) {
			if(i==1||i==6||i==24||i==55||i==71||i==86) {
				System.out.print("|");
			}else if(i==100){
				System.out.println("|");
			}else {
				System.out.print("-");
			}
		}
		for(int i=0;i<listKaryawan.size();i++) {
			System.out.printf("|%4d|%17s|%30s|%15s|%14s|%13d|\n",i+1,
					listKaryawan.get(i).getKode(),
					listKaryawan.get(i).getNama(),
					listKaryawan.get(i).getGender(),
					listKaryawan.get(i).getJabatan(),
					listKaryawan.get(i).getGaji());
			
		}
		for(int i=1;i<=100;i++) {
			if(i==1||i==6||i==24||i==55||i==71||i==86) {
				System.out.print("|");
			}else if(i==100){
				System.out.println("|");
			}else {
				System.out.print("-");
			}
		}
	}
	void View() {
		Sorting();
		Clear();
		ViewDetail();
		System.out.println("\nENTER to return");
		scan.nextLine();
		
		Menu();
	}
	
	void Update() {
		String kode, nama, gender, jabatan;
		int gaji;
		int ChooseNumber;
		char[] kode1 = new char[8];
		ViewDetail();
		
		do {
			System.out.println("Choose Number[1-"+ listKaryawan.size() +"] to update");
			System.out.println("[0 to Menu]");
			ChooseNumber = scan.nextInt();
			scan.nextLine();
		}while(ChooseNumber<0 && ChooseNumber>listKaryawan.size());
		if(ChooseNumber==0) {
			Clear();
			Menu();
		}else {
			Clear();
			do {
				System.out.println("Input kode karyawan [MM-XXXX]:");
				System.out.println("M = UpperCase");
				System.out.println("X = Number");
				kode1 = scan.next().toCharArray();
			}while(!(kode1[2]=='-' && kode1[0]>='A'&&kode1[0]<='Z'
					&&kode1[1]>='A'&&kode1[1]<='Z'
					&&kode1[3]>='0'&&kode1[3]<='9'
					&&kode1[4]>='0'&&kode1[4]<='9'
					&&kode1[5]>='0'&&kode1[5]<='9'
					&&kode1[6]>='0'&&kode1[6]<='9'
					&&kode1.length==7));
			kode = String.valueOf(kode1);
			scan.nextLine();
			
			do {
				
				System.out.print("Input nama karyawan [>=3]:");
				nama = scan.nextLine();
				
			}while(nama.length()<3);
			
			do {
				System.out.print("Input jenis kelamin[Laki-laki | Perempuan](Case Sensitive):");
				gender = scan.nextLine();
			}while(!(gender.contentEquals("Laki-laki")||gender.contentEquals("Perempuan")));
			
			do {
				System.out.print("Input jabatan[Manager | Supervisor | Admin](Case Sensitive):");
				jabatan = scan.nextLine();
			}while(!(jabatan.contentEquals("Manager")||jabatan.contentEquals("Supervisor")||jabatan.contentEquals("Admin")));
			
			if(jabatan.contentEquals("Manager")) {
				gaji = 8000000;
			}else if(jabatan.contentEquals("Supervisor")) {
				gaji = 6000000;
			}else {
				gaji = 4000000;
			}
			
			listKaryawan.get(ChooseNumber-1).setKode(kode);
			listKaryawan.get(ChooseNumber-1).setNama(nama);
			listKaryawan.get(ChooseNumber-1).setGender(gender);
			listKaryawan.get(ChooseNumber-1).setJabatan(jabatan);
			listKaryawan.get(ChooseNumber-1).setGaji(gaji);
			
			System.out.println("Berhasil Mengubah data karyawan");
			System.out.println("\nENTER to return");
			scan.nextLine();
			
			Menu();
		}
	}
	
	void Delete() {
		String kode;
		int ChooseNumber;
		if(listKaryawan.isEmpty()) {
			System.out.println("Tidak ada data karyawan");
			System.out.println("Enter to return");
			scan.nextLine();
			Menu();
		}else {
			do {
				ViewDetail();
				System.out.println("Choose Number[1-"+ listKaryawan.size() +"] to delete");
				System.out.println("[0 to Menu]");
				ChooseNumber = scan.nextInt();
				scan.nextLine();
			}while(ChooseNumber<0 && ChooseNumber>listKaryawan.size());
			if(ChooseNumber==0) {
				Clear();
				Menu();
			}else {
				kode = listKaryawan.get(ChooseNumber-1).getKode();
				listKaryawan.remove(ChooseNumber-1);
				System.out.println("Berhasil menghapus data dengan id "+kode);
				do {
					System.out.println("Ingin delete data karyawan lainnya?[Iya | Tidak](Case Sensitive)");
					kode = scan.nextLine();
				}while(!(kode.contentEquals("Iya")||kode.contentEquals("Tidak")));
				if(kode.contentEquals("Iya")) {
					Delete();
				}else {
					Menu();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}
}

