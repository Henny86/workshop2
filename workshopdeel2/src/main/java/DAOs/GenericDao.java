/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jeroenO
 */
@Repository
@Transactional
public abstract class GenericDao<T> {
    
    private Class<T> type;
    
    @PersistenceContext
    protected EntityManager em;
    
    public GenericDao() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }
      
    public void save(T entity){
         em.persist(entity);
    }

    public void update(T entity) {
	 em.merge(entity);
    }

    public List<T> findAll() {
        Query query = em.createQuery("select e from " + type.getSimpleName()+ " e");
        List<T> entities = query.getResultList();
        return entities;
    }

    public T findByID(long id) {
	 return em.find(type, id);
    }

    public void delete(T entity) {
	em.remove(entity);
    }
    
}
