import DAO.AdminDao;

public class main {
    public static void main(String[] args) {
        AdminDao adminDao = new AdminDao();

        System.out.println(adminDao.trocarSenha("senha123", "123", "marcelo@gmail.com"));
    }
}
