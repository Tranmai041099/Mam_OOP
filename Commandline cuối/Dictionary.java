package Dictionary;

import java.io.IOException;
import java.util.Scanner;

import DictionaryCommandline.DictionaryCommandLine;
import DictionaryCommandline.DictionaryManagement;

public class Dictionary {

	public static void main(String[] args) throws IOException {
		DictionaryCommandLine dic = new DictionaryCommandLine();
		DictionaryManagement d = new DictionaryManagement();
		d.insertFromFile();
		
		//Scanner n = new Scanner(System.in);
		System.out.println("Nhap du lieu nhap so 1");
		System.out.println("Tra tu nhap so 2");
		System.out.println("Xoa tu nhap so 3");
		System.out.println("Sua tu nhap so 4");
		System.out.println("Them tu nhap so 5");
		System.out.println("Goi y tu nhap so 6");
		System.out.println("Luu va thoat chuong trinh nhap so 7");
		boolean check = true;
		while(check) {
			System.out.print("Moi nhap so: ");
			int number = new Scanner(System.in).nextInt();
			switch(number) {
			case 1:{
				dic.dictionaryBasic();
				break;
			}
			case 2: {
				dic.dictionaryAdvanced();
				break;
			}
			case 3: {
				d.dictionaryDelete();
				break;
			}
			case 4: {
				d.dictionaryReplace();
				break;
			}
			case 5: {
				d.dictionaryAddword();
				break;
			}
			case 6: {
				dic.dictionarySearcher();
				break;
			}
			case 7: {
				check = false;
				d.dictionaryExpertToFile();
				System.out.println("Da luu thay doi. Ket thuc ");
				break;
			}
		}
	}

}
