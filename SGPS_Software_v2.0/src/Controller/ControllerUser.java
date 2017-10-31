package Controller;

import java.util.List;
import Model.Cliente;
import Model.Pacote;
import Model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;

/**
 *
 * @author User1
 */
public class ControllerUser extends AbstractControle<User>{
    /**
     * Listar utilizadores
     * @return 
     */
     public List<String> findNames() {
        Criteria cr = getSession().createCriteria(User.class);
        cr.setProjection(Projections.property("idUser"));
        return cr.list();
    }
}
