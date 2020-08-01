import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
		CongTy congTy = new CongTy();
		congTy.nhap();
		doMenu(congTy);

	}

	private static void inMenu() {
		System.out.println("Vui lòng chọn thực hiện:");
		System.out.println("1. Thêm Nhân Viên");
		System.out.println("2. Xuất danh sách nhân viên");
		System.out.println("3. Liệt kê nhân viên có lương cao nhất");
		System.out.println("4. Tổng lương tất cả nhân viên");
	}

	private static void doMenu(CongTy congTy) {
		boolean flag = true;
		Scanner scan = new Scanner(System.in);
		do {
			inMenu();
			System.out.print("Mời chọn:");
			int chon = Integer.parseInt(scan.nextLine().trim());
			switch (chon) {
				case 1:
					NhanVien nv = new NhanVien();
					nv.nhap(scan);
					congTy.themSinhVien(nv);
					break;
				case 2:
					congTy.xuat();
					break;
				case 3:
					nv = congTy.timNhanVienLuongCaoNhat();
					nv.xuat();
					break;
				case 4:
					congTy.tinhTongLuongToanBoNhanVien();
					break;
				case 0:
					flag = false;
					break;
			}
		} while (flag);
	}
}
