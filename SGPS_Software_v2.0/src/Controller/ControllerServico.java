package Controller;

import java.util.List;
import Model.Cliente;
import Model.Servicos;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;

/**
 *
 * @author User1
 */
public class ControllerServico extends AbstractControle<Servicos>{
    /**
     * Listar servicos
     * @return 
     */
     public List<String> findNames() {
        Criteria cr = getSession().createCriteria(Servicos.class);
        cr.setProjection(Projections.property("idServicos"));
        return cr.list();
    }
}
