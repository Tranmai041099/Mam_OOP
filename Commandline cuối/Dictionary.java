package DictionaryCommandline;

import java.io.IOException;
import java.util.Scanner;

public class Dictionary {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		DictionaryCommandLine dic = new DictionaryCommandLine();
		DictionaryManagement d = new DictionaryManagement();
		d.insertFromFile();
		System.out.print("Moi ban chon che do 1 hoac 2: ");
		int num = new Scanner(System.in).nextInt();
		if(num == 1) {
			System.out.println("Che do da chuc nang");
			System.out.println();	
			System.out.println("*************************************************");
			System.out.println("* Nhap du lieu nhap: nhap                       *");
			System.out.println("* Tra tu nhap : tra                             *");
			System.out.println("* Sua tu nhap : sua                             *");
			System.out.println("* Them tu nhap : them                           *");
			System.out.println("* Xoa tu nhap : xoa                             *");
			System.out.println("* Goi y tu nhap : show                          *");
			System.out.println("* Xem toan bo tu dien va tra tu nhap : show_all *");
			System.out.println("* Tro giup, xem huong dan nhap : ?, help        *");
			System.out.println("* Luu va thoat chuong trinh nhap : exit, x      *");
			System.out.println("*************************************************");
			boolean check = true;
			while(check) {
				System.out.print("Moi nhap chuc nang: ");
				String s = new Scanner(System.in).nextLine();
				switch(s) {
				case "nhap":{
					dic.dictionaryBasic();
					break;
				}
				case "tra": {
					d.dictionaryLookup();
					break;
				}
				case "sua": {
					d.dictionaryReplace();
					break;
				}
				case "them": {
					d.dictionaryAddword();
					break;
				}
				case "xoa": {
					d.dictionaryDelete();
					break;
				}
				case "show": {
					dic.dictionarySearcher();
					break;
				}
				case "show_all": {
					dic.dictionaryAdvanced();
					break;
				}
				case "?": {
					System.out.println("*************************************************");
					System.out.println("* Nhap du lieu nhap: nhap                       *");
					System.out.println("* Tra tu nhap : tra                             *");
					System.out.println("* Sua tu nhap : sua                             *");
					System.out.println("* Them tu nhap : them                           *");
					System.out.println("* Xoa tu nhap : xoa                             *");
					System.out.println("* Goi y tu nhap : show                          *");
					System.out.println("* Xem toan bo tu dien va tra tu nhap : show_all *");
					System.out.println("* Tro giup, xem huong dan nhap : ?, help        *");
					System.out.println("* Luu va thoat chuong trinh nhap : exit, x      *");
					System.out.println("*************************************************");
					break;
				}
				case "help": {
					System.out.println("*************************************************");
					System.out.println("* Nhap du lieu nhap: nhap                       *");
					System.out.println("* Tra tu nhap : tra                             *");
					System.out.println("* Sua tu nhap : sua                             *");
					System.out.println("* Them tu nhap : them                           *");
					System.out.println("* Xoa tu nhap : xoa                             *");
					System.out.println("* Goi y tu nhap : show                          *");
					System.out.println("* Xem toan bo tu dien va tra tu nhap : show_all *");
					System.out.println("* Tro giup, xem huong dan nhap : ?, help        *");
					System.out.println("* Luu va thoat chuong trinh nhap : exit, x      *");
					System.out.println("*************************************************");
					break;
				}
				case "exit": {
					check = false;
					d.dictionaryExpertToFile();
					System.out.println("Da luu nhung thay doi. Ket thuc");
					break;
				}
				case "x": {
					check = false;
					d.dictionaryExpertToFile();
					System.out.println("Da luu nhung thay doi. Ket thuc");
					break;
				}
				}
			}
		}
		
		if(num == 2) {
			System.out.println("Che do don gian");
			System.out.println();
			System.out.println("*************************************************");
			System.out.println("* Tra tu nhap : tra                             *");
			System.out.println("* Goi y tu nhap : show                          *");
			System.out.println("* Xem toan bo tu dien va tra tu nhap : show_all *");
			System.out.println("* Tro giup, xem huong dan nhap : ?, help        *");
			System.out.println("* Thoat chuong trinh nhap : exit, x             *");
			System.out.println("*************************************************");
			boolean check = true;
			while(check) {
				System.out.print("Moi nhap chuc nang: ");
				String s = new Scanner(System.in).nextLine();
				switch(s) {
				case "tra": {
					d.dictionaryLookup();
					break;
				}
				case "show": {
					dic.dictionarySearcher();
					break;
				}
				case "show_all": {
					dic.dictionaryAdvanced();
					break;
				}
				case "?": {
					System.out.println("*************************************************");
					System.out.println("* Tra tu nhap : tra                             *");
					System.out.println("* Goi y tu nhap : show                          *");
					System.out.println("* Xem toan bo tu dien va tra tu nhap : show_all *");
					System.out.println("* Tro giup, xem huong dan nhap : ?, help        *");
					System.out.println("* Thoat chuong trinh nhap : exit, x             *");
					System.out.println("*************************************************");
					break;
				}
				case "help": {
					System.out.println("*************************************************");
					System.out.println("* Tra tu nhap : tra                             *");
					System.out.println("* Goi y tu nhap : show                          *");
					System.out.println("* Xem toan bo tu dien va tra tu nhap : show_all *");
					System.out.println("* Tro giup, xem huong dan nhap : ?, help        *");
					System.out.println("* Thoat chuong trinh nhap : exit, x             *");
					System.out.println("*************************************************");
					break;
				}
				case "exit": {
					check = false;
					System.out.println("Ket thuc ");
					break;
				}
				case "x": {
					check = false;
					System.out.println("Ket thuc ");
					break;
				}
				}
			}
		}
	}
}
