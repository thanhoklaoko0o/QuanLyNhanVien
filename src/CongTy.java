import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CongTy {
	private DanhSachNhanVien danhSachNhanVien;

	public DanhSachNhanVien getDssvToanTruong() {
		return danhSachNhanVien;
	}

	public void setDanhSachNhanVien(DanhSachNhanVien danhSachNhanVien) {
		this.danhSachNhanVien = danhSachNhanVien;
	}

	public CongTy() {
		this.danhSachNhanVien = new DanhSachNhanVien();
	}

	public void themSinhVien(NhanVien nhanVien) {
		this.danhSachNhanVien.themNhanVien(nhanVien);
	}

	public void nhap() {
		Date ngaySinh = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			ngaySinh = sdf.parse("01/01/1990");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		NhanVien nhanVien = new NhanVien("01", "Lan", ngaySinh, "Hà Nội", 1500000, 1.5);
		this.danhSachNhanVien.themNhanVien(nhanVien);

		nhanVien = new  NhanVien("02", "Yến", ngaySinh, "Hải Phòng", 1500000, 1.8);
		this.danhSachNhanVien.themNhanVien(nhanVien);
		nhanVien = new  NhanVien("03", "Toàn", ngaySinh, "Quảng Ninh", 1500000, 1.6);
		this.danhSachNhanVien.themNhanVien(nhanVien);

		nhanVien = new  NhanVien("04", "Hữu", ngaySinh, "Thái Bình", 1500000, 1.6);
		this.danhSachNhanVien.themNhanVien(nhanVien);

	}

	public void xuat() {
		this.danhSachNhanVien.xuat();
	}

	public void tinhLuong() {
		danhSachNhanVien.tinhLuong();
	}

	public void tinhTongLuongToanBoNhanVien() {
		System.out.println("Tổng lương toàn bộ nhân viên là: " + danhSachNhanVien.tinhTongLuongToanBoNhanVien());
	}

	public NhanVien timNhanVienLuongCaoNhat() {
		return danhSachNhanVien.timNhanVienLuongCaoNhat();
	}
}
