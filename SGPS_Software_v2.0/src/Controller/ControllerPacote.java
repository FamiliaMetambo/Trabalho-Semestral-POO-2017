package Controller;

import java.util.List;
import Model.Cliente;
import Model.Pacote;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;

/**
 *
 * @author User1
 */
public class ControllerPacote extends AbstractControle<Pacote>{
   
     public List<String> findNames() {
        Criteria cr = getSession().createCriteria(Pacote.class);
        cr.setProjection(Projections.property("idPacote"));
        return cr.list();
    }
}
