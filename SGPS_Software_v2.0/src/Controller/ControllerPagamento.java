package Controller;

import java.util.List;
import Model.Pagamento;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;

/**
 *
 * @author Jeremias Constantino Paulo
 */
public class ControllerPagamento extends AbstractControle<Pagamento> {

    public Pagamento saveOrUpdate(Pagamento l) {
        if (l.getIdPagamento()!= null) {
            return super.update(l);
        } else {
            return save(l);
        }
    }

      public List<String> findNames() {
        Criteria cr = getSession().createCriteria(Pagamento.class);
        cr.setProjection(Projections.property("idPagamento"));
        return cr.list();
    }
}
