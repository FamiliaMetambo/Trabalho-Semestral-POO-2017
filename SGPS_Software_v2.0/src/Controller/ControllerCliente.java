package Controller;

import java.util.List;
import Model.Cliente;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;

/**
 *
 * @author Jeremias Constantino Paulo
 * Metodo Crontrolador do criterio de Pesquisa
 */
public class ControllerCliente extends AbstractControle<Cliente>{
     public List<String> findNames() {
        Criteria cr = getSession().createCriteria(Cliente.class);
        cr.setProjection(Projections.property("nome"));
        return cr.list();
    }
}
