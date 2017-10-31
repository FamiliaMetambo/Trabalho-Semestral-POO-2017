package Controller;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.Util;

/**
 * @param <T> Entidade Qualquer
 * @author User1
 */
public class AbstractControle<T extends Serializable> {

    private static final ThreadLocal session = new ThreadLocal();
    private final Class<T> persistentClass;

    public AbstractControle() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Fabrica de sessoes
     *
     * @return sessao
     */
    protected Session getSession() {
        Session sessao = (Session) AbstractControle.session.get();
        if (sessao == null) {
            sessao = HibernateUtil.getSessionFactory().openSession();
            AbstractControle.session.set(sessao);
        }
        return sessao;
    }

    /**
     * Grava o objecto recebido por parametro na base de dados
     *
     * @param entidade
     * @return entidade
     */
    public T save(T entidade) {
        try {
            getSession().getTransaction().begin();
            getSession().save(entidade);
            getSession().getTransaction().commit();
            Util.mensagemA("Salvo com sucesso!", true);
            return entidade;
        } catch (Throwable t) {
            Util.mensagemA("Ocorreu um erro ao salvar", false);
            JOptionPane.showMessageDialog(null, "Verifique o Erro: " + t);
            getSession().getTransaction().rollback();
        } finally {
            close();
        }
        return null;
    }

    /**
     * Actualiza dados de certa entidade recebida por parametros
     *
     * @param entity
     * @return
     */
    public T update(T entity) {
        try {
            Transaction tx = getSession().beginTransaction();
            getSession().update(entity);
            System.out.println("yep");
            Util.mensagemA("Atualizado com sucesso!", true);
            tx.commit();
            return entity;
        } catch (Throwable t) {
            Util.mensagemA("Ocorreu um erro ao atualizar", false);
            getSession().getTransaction().rollback();
        } finally {
            close();
        }
        return null;
    }

    /**
     * Remove um objecto recebido por parametros na base de dados
     *
     * @param entity
     * @return entidade
     */
    public boolean delete(T entity) {
        try {
            getSession().getTransaction().begin();
            getSession().delete(entity);
            getSession().getTransaction().commit();
            return true;
        } catch (Throwable t) {
            Util.mensagemA("Ocorreu um erro ao apagar", false);
            getSession().getTransaction().rollback();
        } finally {
            close();
        }
        return false;
    }

    /**
     * @return objecto(s) na tabela
     */
    public List<T> findAll() {
        List<T> l = getSession().createCriteria(persistentClass).list();
        return l;
    }

    /**
     * Pesquisa por nome recebido por parametros na base de dados
     *
     * @return objecto(s) na tabela
     */
    public T findByName(String string, String nome) {
        T l = (T) getSession().createCriteria(persistentClass)
                .add(Restrictions.eq("" + string + "", nome).ignoreCase()).uniqueResult();
        return l;
    }

    /**
     *
     * @param string
     * @param id
     * @returndado(s) na tabela
     */
    public T findById(String string, int id) {
        return (T) getSession().createCriteria(persistentClass)
                .add(Restrictions.eq("" + string + "", id)).uniqueResult();
    }

    /**
     *close connection with DB
     */
    private void close() {
        getSession().close();
        AbstractControle.session.set(null);
    }
}
