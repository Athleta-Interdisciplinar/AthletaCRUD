<<<<<<< HEAD
import Classes.AnaliseEventos;
import DAO.AdminDao;
import DAO.AnaliseEventosDao;

import java.time.LocalDate;
import java.util.Date;
=======
import dao.AdminDao;
>>>>>>> 84e57f2294f06826346daa8563c288e3684adbce

public class main {
    public static void main(String[] args) {
//        AdminDao adminDao = new AdminDao();

//        adminDao.cadastrarAdm(24, "admin2", "admin2@gmail.com", "senha2");

//        LocalDate dataAtual = LocalDate.now(); //Data hj
        LocalDate dt1 =  LocalDate.of(2008,11,21);
//        AnaliseEventos an = new AnaliseEventos(3,"Torneio de beisebbol", "torneio amador ", dt1, "Nakashima",4,6);
//        System.out.println(an);
        AnaliseEventosDao an2 = new AnaliseEventosDao();
        an2.inserirEvento(3,"Torneio de beisebbol", "torneio amador ", dt1, "Nakashima","qsjnejnejqeijq",170, 34);
    }
}
