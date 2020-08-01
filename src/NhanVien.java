import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class NhanVien {
	private String maNhanVien;
	private String hoTen;
	private Date ngaySinh;
	private String diaChi;
	private long luongNhanVien;
	private long luongCoBan;
	private double heSoLuong;

	/**
	 *
	 * @param maNhanVien
	 * @param hoTen
	 * @param ngaySinh
	 */
	public NhanVien(String maNhanVien, String hoTen, Date ngaySinh) {
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
	}

	/**
	 *
	 * @param maNhanVien
	 * @param hoTen
	 * @param diaChi
	 */
	public NhanVien(String maNhanVien, String hoTen, String diaChi) {
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
	}

	/**
	 *
	 * @param maNhanVien
	 * @param ngaySinh
	 * @param diaChi
	 */
	public NhanVien(String maNhanVien, Date ngaySinh, String diaChi) {
		this.maNhanVien = maNhanVien;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
	}

	/**
	 *
	 * @param maNhanVien
	 * @param hoTen
	 * @param ngaySinh
	 * @param diaChi
	 */
	public NhanVien(String maNhanVien, String hoTen, Date ngaySinh, String diaChi, long luongCoBan, double heSoLuong) {
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.luongCoBan = luongCoBan;
		this.heSoLuong = heSoLuong;
	}

	public NhanVien() {}

	public long getLuongNhanVien() {
		return luongNhanVien;
	}

	public void setLuongNhanVien(long luongNhanVien) {
		this.luongNhanVien = luongNhanVien;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		if (maNhanVien != null && !maNhanVien.isEmpty()) {
			this.maNhanVien = maNhanVien;
		}
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		if (hoTen != null && !hoTen.isEmpty()) {
			this.hoTen = hoTen;
		}
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		if (ngaySinh != null) {
			this.ngaySinh = ngaySinh;
		}
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		if (diaChi != null && !diaChi.isEmpty()) {
			this.diaChi = diaChi;
		}
	}

	public long getLuongCoBan() {
		return luongCoBan;
	}

	public void setLuongCoBan(long luongCoBan) {
		if (luongCoBan > 0) {
			this.luongCoBan = luongCoBan;
		}

	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		if (heSoLuong > 0) {
			this.heSoLuong = heSoLuong;
		}
	}

	public void nhap(Scanner scan) {
		System.out.print("Nhập mã nhân viên: ");
		setMaNhanVien(scan.nextLine());

		System.out.print("Nhập họ tên: ");
		setHoTen(scan.nextLine());

		System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date birthDate = sdf.parse(scan.nextLine());
			setNgaySinh(birthDate);
		} catch (ParseException e) {
			System.out.println("Lỗi ngày sinh");
		}


		System.out.print("Nhập địa chỉ: ");
		setDiaChi(scan.nextLine());

		System.out.print("Nhập lương Cơ Bản: ");
		String luongCoBan = scan.nextLine();
		if (luongCoBan != null && !luongCoBan.isEmpty()) {
			setLuongCoBan(Long.parseLong(luongCoBan.trim()));
		}

		System.out.print("Nhập hệ số lương:: ");
		String heSoLuong = scan.nextLine();
		if (heSoLuong != null && !heSoLuong.isEmpty()) {
			setHeSoLuong(Double.parseDouble(heSoLuong));
		}

	}

	public void xuat() {
		System.out.println("Nhân vien - Mã: " + this.maNhanVien + "\t Tên: " + this.hoTen + "\t Ngày Sinh: " + this.ngaySinh
				+ "\t Địa Chỉ: " + this.diaChi + "\t Lương Cơ Bản: " + this.luongCoBan + "\t Hệ số lương: " + this.heSoLuong
				+ "\t Lương Nhân Viên: " + tinhLuong());
	}

	public long tinhLuong() {
		this.luongNhanVien = (long) (this.heSoLuong * this.luongCoBan);
		return this.luongNhanVien;
	}

	private String formatNumCell(Number num) {
		String paddLeft = "%5s";
		String paddRight = "%-8s";
		return String.format(paddLeft, " ") + String.format(paddRight, num) + "|";
	}

	private String formatTextCell(String text) {
		String paddLeft = "%-15s";
		return String.format(paddLeft, " " + text);
	}

	public void xuatRowFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		String text;
		text = formatTextCell(this.maNhanVien);
		text += formatTextCell(this.hoTen) + "|";
		text += formatTextCell(sdf.format(this.ngaySinh));
		text += formatTextCell(this.diaChi);
		text += formatNumCell(this.luongCoBan);
		text += formatNumCell(this.heSoLuong);
		System.out.println(text);

	}

}
