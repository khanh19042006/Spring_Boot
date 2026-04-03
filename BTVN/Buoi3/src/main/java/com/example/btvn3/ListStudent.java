package com.example.btvn3;

import com.example.btvn3.model.Student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListStudent {
    public static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1L, "SV001", "Nguyễn Văn An", "an.nguyen@example.com", "0912345678", LocalDate.of(2003, 5, 10), 3.5, "Công nghệ thông tin", 3));
        students.add(new Student(2L, "SV002", "Trần Thị Bình", "binh.tran@example.com", "0987654321", LocalDate.of(2002, 8, 15), 3.8, "Kế toán", 4));
        students.add(new Student(3L, "SV003", "Lê Minh Cường", "cuong.le@example.com", "0371234567", LocalDate.of(2004, 1, 20), 3.2, "Marketing", 2));
        students.add(new Student(4L, "SV004", "Phạm Thu Dung", "dung.pham@example.com", "0359876543", LocalDate.of(2003, 11, 5), 3.9, "Luật", 3));
        students.add(new Student(5L, "SV005", "Hoàng Gia Huy", "huy.hoang@example.com", "0394567890", LocalDate.of(2001, 7, 25), 2.9, "Quản trị kinh doanh", 5));
        students.add(new Student(6L, "SV006", "Đỗ Khánh Linh", "linh.do@example.com", "0381122334", LocalDate.of(2004, 3, 18), 3.6, "Thiết kế đồ họa", 2));
        students.add(new Student(7L, "SV007", "Vũ Quốc Nam", "nam.vu@example.com", "0972233445", LocalDate.of(2002, 9, 30), 3.1, "Công nghệ phần mềm", 4));
        students.add(new Student(8L, "SV008", "Bùi Thảo Nhi", "nhi.bui@example.com", "0363344556", LocalDate.of(2003, 12, 12), 3.7, "Ngôn ngữ Anh", 3));
        students.add(new Student(9L, "SV009", "Đặng Minh Quân", "quan.dang@example.com", "0934455667", LocalDate.of(2001, 6, 8), 2.7, "Du lịch", 5));
        students.add(new Student(10L, "SV010", "Ngô Nhật Sơn", "son.ngo@example.com", "0855566778", LocalDate.of(2004, 4, 22), 3.4, "Trí tuệ nhân tạo", 2));
    }
}