package fr.iocean.application.media;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;


public class MediaRepositoryImpl implements MediaRepositoryCustom  {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Media> search(String titre, String type, String auteur) {
		Criteria query = getSession().createCriteria(Media.class);
		if(!StringUtils.isEmpty(titre))
			query.add(Restrictions.ilike("titre", "%"+titre+"%"));
		if(!StringUtils.isEmpty(auteur))
			query.add(Restrictions.ilike("auteur", "%"+auteur+"%"));
		if(!StringUtils.isEmpty(type))
			query.add(Restrictions.like("type", type));
		
		return query.list();
	}

	private Session getSession(){
		return this.em.unwrap(Session.class);
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
}
