import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachNhanVien {

	private ArrayList<NhanVien> listNhanVien;

	public ArrayList<NhanVien> getListNhanVien() {
		return listNhanVien;
	}

	public void setListNhanVien(ArrayList<NhanVien> listNhanVien) {
		this.listNhanVien = listNhanVien;
	}

	public DanhSachNhanVien() {
		this.listNhanVien = new ArrayList<>();
	}

	public void nhap(Scanner scan) {
		for (NhanVien nhanVien : this.listNhanVien) {
			nhanVien.nhap(scan);
		}
	}

	public void themNhanVien(NhanVien nhanVien) {
		this.listNhanVien.add(nhanVien);
	}

	public void xuat() {
		for (NhanVien nhanVien : this.listNhanVien) {
			nhanVien.xuat();
		}
	}

	public void tinhLuong() {
		for (NhanVien nhanVien : this.listNhanVien) {
			nhanVien.tinhLuong();
		}
	}

	public long tinhTongLuongToanBoNhanVien() {
		long tongLuong = 0;
		for (NhanVien nhanVien : this.listNhanVien) {
			tongLuong += nhanVien.tinhLuong();
		}

		return tongLuong;
	}

	public NhanVien timNhanVienLuongCaoNhat() {
		long max = 0;
		NhanVien nhanVien = new NhanVien();
		for (NhanVien nv : listNhanVien) {
			if (max < nv.tinhLuong()) {
				max = nv.getLuongNhanVien();
				nhanVien = nv;
			}
		}

		return nhanVien;
	}

}
