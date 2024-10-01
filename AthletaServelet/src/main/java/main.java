import dao.AdminDao;

public class main {
    public static void main(String[] args) {
        AdminDao adminDao = new AdminDao();

        adminDao.cadastrarAdm(23, "admin", "admin@gmail.com", "senha");
    }
}
